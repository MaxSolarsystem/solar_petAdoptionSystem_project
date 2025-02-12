<script lang="ts" setup>
import { ref, computed } from 'vue'

// 搜索关键词
const searchQuery = ref('')

// 商品数据
const products = ref([
  {
    id: 1,
    name: '高级猫粮 - 三文鱼味',
    image: 'https://images.unsplash.com/photo-1589924691995-400dc9ecc119?w=500',
    description: '优质蛋白质，适合成年猫咪，改善毛发',
    price: 199,
    stock: 50
  },
  {
    id: 2,
    name: '狗狗磨牙玩具',
    image: 'https://images.unsplash.com/photo-1576201836106-db1758fd1c97?w=500',
    description: '耐咬耐磨，安全无毒，适合各种犬种',
    price: 39.9,
    stock: 100
  },
  {
    id: 3,
    name: '豪华猫爬架',
    image: 'https://images.unsplash.com/photo-1545249390-6bdfa286032f?w=500',
    description: '多层设计，带猫窝和磨爪板，稳固耐用',
    price: 299,
    stock: 20
  },
  {
    id: 4,
    name: '宠物自动喂食器',
    image: 'https://images.unsplash.com/photo-1601758228041-f3b2795255f1?w=500',
    description: '智能定时，可远程控制，大容量储粮',
    price: 259,
    stock: 30
  },
  {
    id: 5,
    name: '猫砂盆全套',
    image: 'https://images.unsplash.com/photo-1636567231896-02769b71b1eb?w=500',
    description: '半封闭式设计，防飞砂，送猫砂铲',
    price: 129,
    stock: 45
  },
  {
    id: 6,
    name: '宠物洗澡套装',
    image: 'https://images.unsplash.com/photo-1594140700614-fea11d7ff547?w=500',
    description: '温和配方，不刺激，送洗澡手套',
    price: 89,
    stock: 60
  },
  {
    id: 7,
    name: '小型宠物笼',
    image: 'https://images.unsplash.com/photo-1548767797-d8c844163c4c?w=500',
    description: '适合兔子和仓鼠，带饮水器和食盆',
    price: 159,
    stock: 25
  },
  {
    id: 8,
    name: '宠物外出背包',
    image: 'https://images.unsplash.com/photo-1601758124510-52d02ddb7cbd?w=500',
    description: '透气网面，承重强，多色可选',
    price: 199,
    stock: 40
  }
])

// 搜索过滤
const filteredProducts = computed(() => {
  const query = searchQuery.value.toLowerCase().trim()
  if (!query) return products.value
  return products.value.filter(product => 
    product.name.toLowerCase().includes(query) ||
    product.description.toLowerCase().includes(query)
  )
})
</script>

<template>
  <div class="store-container">
    <!-- 搜索区域 -->
    <div class="search-section">
      <div class="search-box">
        <input 
          v-model="searchQuery"
          type="text"
          placeholder="搜索商品..."
          class="search-input"
        >
        <span class="search-icon">🔍</span>
      </div>
    </div>

    <!-- 商品列表 -->
    <div class="products-grid">
      <div v-for="product in filteredProducts" 
           :key="product.id" 
           class="product-card">
        <div class="product-image">
          <img :src="product.image" :alt="product.name">
          <div class="stock-tag" :class="{ 'low-stock': product.stock < 30 }">
            库存: {{ product.stock }}
          </div>
        </div>
        <div class="product-info">
          <h3 class="product-name">{{ product.name }}</h3>
          <p class="product-description">{{ product.description }}</p>
          <div class="product-footer">
            <span class="product-price">¥{{ product.price }}</span>
            <button class="add-to-cart">加入购物车</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.store-container {
  padding: 2rem;
  min-height: 100vh;
  background: linear-gradient(135deg, #f6f9fc 0%, #ffffff 100%);
}

.search-section {
  margin-bottom: 2rem;
  display: flex;
  justify-content: center;
}

.search-box {
  position: relative;
  width: 100%;
  max-width: 600px;
}

.search-input {
  width: 100%;
  padding: 1rem 1.5rem;
  padding-right: 3rem;
  border: 2px solid #eee;
  border-radius: 16px;
  font-size: 1rem;
  background: white;
  transition: all 0.3s ease;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
}

.search-input:focus {
  border-color: #ff6b6b;
  box-shadow: 0 4px 20px rgba(255, 107, 107, 0.15);
  outline: none;
}

.search-icon {
  position: absolute;
  right: 1rem;
  top: 50%;
  transform: translateY(-50%);
  font-size: 1.2rem;
  color: #666;
  pointer-events: none;
}

.products-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 2rem;
  padding: 1rem 0;
}

.product-card {
  background: white;
  border-radius: 16px;
  overflow: hidden;
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.08);
  transition: all 0.3s ease;
}

.product-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 15px 30px rgba(0, 0, 0, 0.12);
}

.product-image {
  position: relative;
  height: 200px;
  overflow: hidden;
}

.product-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.3s ease;
}

.product-card:hover .product-image img {
  transform: scale(1.05);
}

.stock-tag {
  position: absolute;
  top: 1rem;
  right: 1rem;
  background: rgba(76, 175, 80, 0.9);
  color: white;
  padding: 0.4rem 0.8rem;
  border-radius: 20px;
  font-size: 0.8rem;
  font-weight: 600;
}

.stock-tag.low-stock {
  background: rgba(255, 107, 107, 0.9);
}

.product-info {
  padding: 1.5rem;
}

.product-name {
  font-size: 1.2rem;
  font-weight: 700;
  color: #333;
  margin-bottom: 0.5rem;
}

.product-description {
  font-size: 0.9rem;
  color: #666;
  margin-bottom: 1rem;
  line-height: 1.5;
}

.product-footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.product-price {
  font-size: 1.3rem;
  font-weight: 700;
  color: #ff6b6b;
}

.add-to-cart {
  padding: 0.8rem 1.2rem;
  background: linear-gradient(45deg, #ff6b6b, #ff8e8e);
  color: white;
  border: none;
  border-radius: 12px;
  font-size: 0.9rem;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
}

.add-to-cart:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(255, 107, 107, 0.2);
}

@media (max-width: 768px) {
  .store-container {
    padding: 1rem;
  }

  .search-section {
    margin-bottom: 1.5rem;
  }

  .products-grid {
    grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
    gap: 1rem;
  }

  .product-name {
    font-size: 1.1rem;
  }

  .product-price {
    font-size: 1.2rem;
  }

  .add-to-cart {
    padding: 0.6rem 1rem;
  }
}
</style>