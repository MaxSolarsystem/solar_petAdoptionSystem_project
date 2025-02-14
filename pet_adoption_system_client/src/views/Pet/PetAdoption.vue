<script lang="ts" setup>
import { ref } from 'vue'

// 筛选条件
const filters = ref({
  category: '',
  gender: '',
  ageRange: '',
  weight: '',
  health: '',
  training: ''
})

// 筛选选项
const filterOptions = {
  categories: ['猫咪', '狗狗', '兔子', '仓鼠'],
  genders: ['男孩', '女孩'],
  ageRanges: ['0-1岁', '1-3岁', '3-7岁', '7岁以上'],
  weights: ['0-5kg', '5-10kg', '10-20kg', '20kg以上'],
  healthStatus: ['健康', '亚健康', '需要特殊照顾'],
  trainingLevels: ['未训练', '基础训练', '完全训练']
}

// 模拟宠物数据
const pets = ref([
  {
    id: 1,
    name: '奥利奥',
    image: 'https://images.dog.ceo/breeds/shiba/shiba-8.jpg',
    category: '狗狗',
    breed: '柴犬',
    gender: '男孩',
    age: '2岁',
    weight: '5kg',
    health: '健康',
    training: '基础训练'
  },
  {
    id: 2,
    name: '可可',
    image: 'https://cdn2.thecatapi.com/images/MTY3ODk4Mw.jpg',
    category: '猫咪',
    breed: '英短',
    gender: '女孩',
    age: '1岁',
    weight: '3kg',
    health: '健康',
    training: '基础训练'
  },
  {
    id: 3,
    name: '小白',
    image: 'https://cdn2.thecatapi.com/images/4lXnnfxac.jpg',
    category: '猫咪',
    breed: '布偶',
    gender: '男孩',
    age: '3岁',
    weight: '4.5kg',
    health: '健康',
    training: '完全训练'
  },
  {
    id: 4,
    name: '贝贝',
    image: 'https://images.dog.ceo/breeds/corgi-cardigan/n02113186_1030.jpg',
    category: '狗狗',
    breed: '柯基',
    gender: '女孩',
    age: '1.5岁',
    weight: '7kg',
    health: '健康',
    training: '完全训练'
  },
  {
    id: 5,
    name: '皮蛋',
    image: 'https://cdn2.thecatapi.com/images/xnsqonbjW.jpg',
    category: '猫咪',
    breed: '美短',
    gender: '男孩',
    age: '4岁',
    weight: '5kg',
    health: '亚健康',
    training: '基础训练'
  },
  {
    id: 6,
    name: '多多',
    image: 'https://images.dog.ceo/breeds/husky/n02110185_7740.jpg',
    category: '狗狗',
    breed: '哈士奇',
    gender: '男孩',
    age: '2岁',
    weight: '15kg',
    health: '健康',
    training: '完全训练'
  },
  {
    id: 7,
    name: '雪球',
    image: 'https://cdn2.thecatapi.com/images/Z2pMBDkih.jpg',
    category: '兔子',
    breed: '垂耳兔',
    gender: '女孩',
    age: '1岁',
    weight: '2kg',
    health: '健康',
    training: '未训练'
  },
  {
    id: 8,
    name: '豆豆',
    image: 'https://images.dog.ceo/breeds/poodle-toy/n02113624_1308.jpg',
    category: '狗狗',
    breed: '泰迪',
    gender: '男孩',
    age: '3岁',
    weight: '4kg',
    health: '健康',
    training: '基础训练'
  },
  {
    id: 9,
    name: '糯米',
    image: 'https://cdn2.thecatapi.com/images/sPMOo3Jn6.jpg',
    category: '仓鼠',
    breed: '布丁仓鼠',
    gender: '女孩',
    age: '6个月',
    weight: '0.2kg',
    health: '健康',
    training: '未训练'
  },
  {
    id: 10,
    name: '小灰',
    image: 'https://cdn2.thecatapi.com/images/bj2.jpg',
    category: '猫咪',
    breed: '英短',
    gender: '男孩',
    age: '5岁',
    weight: '6kg',
    health: '需要特殊照顾',
    training: '基础训练'
  }
])
</script>

<template>
  <div class="pet-adoption">
    <!-- 筛选区域 -->
    <div class="filter-section">
      <div class="filter-container">
        <div class="filter-group">
          <label>分类</label>
          <select v-model="filters.category">
            <option value="">全部</option>
            <option v-for="category in filterOptions.categories" :key="category" :value="category">
              {{ category }}
            </option>
          </select>
        </div>

        <div class="filter-group">
          <label>性别</label>
          <select v-model="filters.gender">
            <option value="">全部</option>
            <option v-for="gender in filterOptions.genders" :key="gender" :value="gender">
              {{ gender }}
            </option>
          </select>
        </div>

        <div class="filter-group">
          <label>年龄</label>
          <select v-model="filters.ageRange">
            <option value="">全部</option>
            <option v-for="age in filterOptions.ageRanges" :key="age" :value="age">
              {{ age }}
            </option>
          </select>
        </div>

        <div class="filter-group">
          <label>体重</label>
          <select v-model="filters.weight">
            <option value="">全部</option>
            <option v-for="weight in filterOptions.weights" :key="weight" :value="weight">
              {{ weight }}
            </option>
          </select>
        </div>

        <div class="filter-group">
          <label>健康状况</label>
          <select v-model="filters.health">
            <option value="">全部</option>
            <option v-for="status in filterOptions.healthStatus" :key="status" :value="status">
              {{ status }}
            </option>
          </select>
        </div>

        <div class="filter-group">
          <label>训练情况</label>
          <select v-model="filters.training">
            <option value="">全部</option>
            <option v-for="level in filterOptions.trainingLevels" :key="level" :value="level">
              {{ level }}
            </option>
          </select>
        </div>
      </div>
    </div>

    <!-- 宠物列表 -->
    <div class="pets-grid">
      <div v-for="pet in pets" :key="pet.id" class="pet-card">
        <div class="pet-image">
          <img :src="pet.image" :alt="pet.name">
          <div class="pet-category">{{ pet.category }}</div>
        </div>
        <div class="pet-info">
          <h3 class="pet-name">{{ pet.name }}</h3>
          <div class="pet-details">
            <span class="pet-gender">
              {{ pet.gender === '男孩' ? '🚹' : '🚺' }} {{ pet.gender }}
            </span>
            <span class="pet-breed">{{ pet.breed }}</span>
          </div>
            <router-link :to="`/petAdoption/info/${pet.id}`">
              <button class="adopt-button">了解更多</button>
            </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.pet-adoption {
  padding: 2rem;
  min-height: 100vh;
  background: linear-gradient(135deg, #f6f9fc 0%, #ffffff 100%);
}

.filter-section {
  background: white;
  border-radius: 16px;
  padding: 1.5rem;
  margin-bottom: 2rem;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
}

.filter-container {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 1.5rem;
}

.filter-group {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.filter-group label {
  font-size: 0.9rem;
  color: #666;
  font-weight: 500;
}

.filter-group select {
  padding: 0.8rem;
  border: 2px solid #eee;
  border-radius: 12px;
  font-size: 0.9rem;
  color: #333;
  background: white;
  cursor: pointer;
  transition: all 0.3s ease;
}

.filter-group select:focus {
  border-color: #ff6b6b;
  box-shadow: 0 0 0 3px rgba(255, 107, 107, 0.1);
  outline: none;
}

.pets-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
  gap: 2rem;
  padding: 1rem 0;
}

.pet-card {
  background: white;
  border-radius: 16px;
  overflow: hidden;
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.08);
  transition: all 0.3s ease;
}

.pet-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 15px 30px rgba(0, 0, 0, 0.12);
}

.pet-image {
  position: relative;
  height: 200px;
  overflow: hidden;
}

.pet-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.3s ease;
}

.pet-card:hover .pet-image img {
  transform: scale(1.05);
}

.pet-category {
  position: absolute;
  top: 1rem;
  right: 1rem;
  background: rgba(255, 107, 107, 0.9);
  color: white;
  padding: 0.5rem 1rem;
  border-radius: 20px;
  font-size: 0.8rem;
  font-weight: 600;
}

.pet-info {
  padding: 1.5rem;
}

.pet-name {
  font-size: 1.2rem;
  font-weight: 700;
  color: #333;
  margin-bottom: 0.5rem;
}

.pet-details {
  display: flex;
  gap: 1rem;
  margin-bottom: 1rem;
}

.pet-gender,
.pet-breed {
  font-size: 0.9rem;
  color: #666;
}

.adopt-button {
  width: 100%;
  padding: 0.8rem;
  background: linear-gradient(45deg, #ff6b6b, #ff8e8e);
  color: white;
  border: none;
  border-radius: 12px;
  font-size: 0.9rem;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
}

.adopt-button:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(255, 107, 107, 0.2);
}

@media (max-width: 768px) {
  .pet-adoption {
    padding: 1rem;
  }

  .filter-container {
    grid-template-columns: 1fr;
    gap: 1rem;
  }

  .pets-grid {
    grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
    gap: 1rem;
  }
}
</style>