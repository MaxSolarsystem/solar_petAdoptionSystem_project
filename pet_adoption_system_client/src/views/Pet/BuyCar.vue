<script setup lang="ts">
import { ref, computed } from 'vue'

// 购物车数据
const cartItems = ref([
  {
    id: 1,
    name: '高级猫粮 - 三文鱼味',
    image: 'https://images.unsplash.com/photo-1589924691995-400dc9ecc119?w=500',
    price: 199,
    quantity: 2,
    selected: false,
    stock: 50
  },
  {
    id: 2,
    name: '狗狗磨牙玩具',
    image: 'https://images.unsplash.com/photo-1576201836106-db1758fd1c97?w=500',
    price: 39.9,
    quantity: 1,
    selected: false,
    stock: 100
  },
  {
    id: 3,
    name: '豪华猫爬架',
    image: 'https://images.unsplash.com/photo-1545249390-6bdfa286032f?w=500',
    price: 299,
    quantity: 1,
    selected: false,
    stock: 20
  }
])

// 全选状态
const isAllSelected = computed({
  get: () => cartItems.value.length > 0 && cartItems.value.every(item => item.selected),
  set: (value) => cartItems.value.forEach(item => item.selected = value)
})

// 计算选中商品总价
const totalPrice = computed(() => {
  return cartItems.value
    .filter(item => item.selected)
    .reduce((total, item) => total + item.price * item.quantity, 0)
    .toFixed(2)
})

// 计算选中商品数量
const selectedCount = computed(() => {
  return cartItems.value.filter(item => item.selected).length
})

// 更新商品数量
const updateQuantity = (item: any, delta: number) => {
  const newQuantity = item.quantity + delta
  if (newQuantity > 0 && newQuantity <= item.stock) {
    item.quantity = newQuantity
  }
}

// 删除选中商品
const deleteSelected = () => {
  cartItems.value = cartItems.value.filter(item => !item.selected)
}

// 结算选中商品
const checkout = () => {
  if (selectedCount.value === 0) {
    alert('请先选择商品')
    return
  }
  // 这里添加结算逻辑
  alert('结算功能开发中...')
}
</script>

<template>
  <div class="cart-page">
    <div class="cart-container">
      <h1>我的购物车</h1>
      
      <!-- 购物车表头 -->
      <div class="cart-header">
        <div class="select-all">
          <input 
            type="checkbox" 
            :checked="isAllSelected"
            @change="isAllSelected = !isAllSelected"
          >
          <span>全选</span>
        </div>
        <div class="header-item">商品信息</div>
        <div class="header-item">单价</div>
        <div class="header-item">数量</div>
        <div class="header-item">小计</div>
      </div>

      <!-- 购物车列表 -->
      <div class="cart-list">
        <div v-for="item in cartItems" 
             :key="item.id" 
             class="cart-item">
          <div class="item-select">
            <input 
              type="checkbox" 
              v-model="item.selected"
            >
          </div>
          <div class="item-info">
            <img :src="item.image" :alt="item.name">
            <span class="item-name">{{ item.name }}</span>
          </div>
          <div class="item-price">¥{{ item.price }}</div>
          <div class="item-quantity">
            <button 
              @click="updateQuantity(item, -1)"
              :disabled="item.quantity <= 1"
            >-</button>
            <input type="number" v-model="item.quantity" :max="item.stock">
            <button 
              @click="updateQuantity(item, 1)"
              :disabled="item.quantity >= item.stock"
            >+</button>
          </div>
          <div class="item-subtotal">
            ¥{{ (item.price * item.quantity).toFixed(2) }}
          </div>
        </div>
      </div>

      <!-- 购物车底部 -->
      <div class="cart-footer">
        <div class="footer-left">
          <button class="delete-btn" @click="deleteSelected">
            删除选中商品
          </button>
          <span class="selected-count">
            已选择 {{ selectedCount }} 件商品
          </span>
        </div>
        <div class="footer-right">
          <div class="total-price">
            合计：<span>¥{{ totalPrice }}</span>
          </div>
          <button class="checkout-btn" @click="checkout">
            结算
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.cart-page {
  padding: 2rem;
  min-height: 100vh;
  background: linear-gradient(135deg, #f6f9fc 0%, #ffffff 100%);
}

.cart-container {
  max-width: 1200px;
  margin: 0 auto;
  background: white;
  border-radius: 16px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
  padding: 2rem;
}

h1 {
  font-size: 1.8rem;
  color: #333;
  margin-bottom: 2rem;
}

.cart-header {
  display: grid;
  grid-template-columns: 100px 2fr 1fr 1fr 1fr;
  padding: 1rem;
  background: #f8f9fa;
  border-radius: 12px;
  margin-bottom: 1rem;
  font-weight: 600;
  color: #333;
}

.select-all {
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.cart-item {
  display: grid;
  grid-template-columns: 100px 2fr 1fr 1fr 1fr;
  align-items: center;
  padding: 1.5rem 1rem;
  border-bottom: 1px solid #eee;
}

.item-info {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.item-info img {
  width: 80px;
  height: 80px;
  object-fit: cover;
  border-radius: 8px;
}

.item-name {
  font-weight: 500;
  color: #333;
}

.item-quantity {
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.item-quantity button {
  width: 32px;
  height: 32px;
  border: 1px solid #ddd;
  background: white;
  border-radius: 8px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.item-quantity button:hover:not(:disabled) {
  background: #f8f9fa;
  border-color: #ff6b6b;
  color: #ff6b6b;
}

.item-quantity button:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}

.item-quantity input {
  width: 50px;
  height: 32px;
  text-align: center;
  border: 1px solid #ddd;
  border-radius: 8px;
}

.cart-footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 2rem;
  padding-top: 2rem;
  border-top: 1px solid #eee;
}

.footer-left {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.delete-btn {
  padding: 0.8rem 1.5rem;
  background: #f8f9fa;
  border: none;
  border-radius: 12px;
  color: #666;
  cursor: pointer;
  transition: all 0.3s ease;
}

.delete-btn:hover {
  background: #ffe5e5;
  color: #ff6b6b;
}

.selected-count {
  color: #666;
}

.footer-right {
  display: flex;
  align-items: center;
  gap: 2rem;
}

.total-price {
  font-size: 1.1rem;
  color: #666;
}

.total-price span {
  font-size: 1.5rem;
  font-weight: 700;
  color: #ff6b6b;
}

.checkout-btn {
  padding: 1rem 2rem;
  background: linear-gradient(45deg, #ff6b6b, #ff8e8e);
  border: none;
  border-radius: 12px;
  color: white;
  font-size: 1.1rem;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
}

.checkout-btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(255, 107, 107, 0.2);
}

@media (max-width: 768px) {
  .cart-page {
    padding: 1rem;
  }

  .cart-container {
    padding: 1rem;
  }

  .cart-header,
  .cart-item {
    grid-template-columns: 60px 2fr 1fr;
    gap: 1rem;
  }

  .header-item:nth-child(3),
  .header-item:nth-child(4),
  .item-price,
  .item-subtotal {
    display: none;
  }

  .item-info img {
    width: 60px;
    height: 60px;
  }

  .cart-footer {
    flex-direction: column;
    gap: 1rem;
  }

  .footer-right {
    width: 100%;
    justify-content: space-between;
  }
}
</style>