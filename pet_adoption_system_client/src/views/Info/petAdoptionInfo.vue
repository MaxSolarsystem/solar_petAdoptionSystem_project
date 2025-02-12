<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const petId = route.params.id
const petInfo = ref(null)

// 模拟获取宠物详细信息
const fetchPetInfo = async () => {
  // 这里应该是实际的API调用
  // 现在用模拟数据
  petInfo.value = {
    id: petId,
    name: '奥利奥',
    image: 'https://images.dog.ceo/breeds/shiba/shiba-8.jpg',
    images: [
      'https://images.dog.ceo/breeds/shiba/shiba-8.jpg',
      'https://images.dog.ceo/breeds/shiba/shiba-12.jpg',
      'https://images.dog.ceo/breeds/shiba/shiba-14.jpg'
    ],
    category: '狗狗',
    breed: '柴犬',
    gender: '男孩',
    age: '2岁',
    weight: '5kg',
    health: '健康',
    training: '基础训练',
    description: '奥利奥是一只活泼可爱的柴犬，性格温顺，特别喜欢和人互动。已经完成基础训练，会基本的指令。身体健康，定期打疫苗，适合家庭领养。',
    requirements: [
      '有养狗经验',
      '有充足的活动空间',
      '能保证每天遛狗时间',
      '接受定期回访'
    ],
    contact: {
      name: '王老师',
      phone: '138****1234',
      email: 'wang@example.com'
    }
  }
}

onMounted(() => {
  fetchPetInfo()
})
</script>

<template>
  <div class="pet-info-page">
    <div v-if="petInfo" class="pet-info-container">
      <!-- 宠物基本信息 -->
      <div class="pet-header">
        <div class="main-image">
          <img :src="petInfo.image" :alt="petInfo.name">
          <div class="category-tag">{{ petInfo.category }}</div>
        </div>
        <div class="image-gallery">
          <img 
            v-for="(image, index) in petInfo.images" 
            :key="index"
            :src="image" 
            :alt="`${petInfo.name}-${index}`"
            @click="petInfo.image = image"
            :class="{ active: petInfo.image === image }"
          >
        </div>
      </div>

      <div class="info-content">
        <div class="basic-info">
          <h1>{{ petInfo.name }}</h1>
          <div class="tags">
            <span class="tag">
              {{ petInfo.gender === '男孩' ? '🚹' : '🚺' }} {{ petInfo.gender }}
            </span>
            <span class="tag">{{ petInfo.breed }}</span>
            <span class="tag">{{ petInfo.age }}</span>
            <span class="tag" :class="{'tag-warning': petInfo.health !== '健康'}">
              {{ petInfo.health }}
            </span>
          </div>
          <p class="description">{{ petInfo.description }}</p>
        </div>

        <div class="details-grid">
          <div class="detail-item">
            <span class="label">体重</span>
            <span class="value">{{ petInfo.weight }}</span>
          </div>
          <div class="detail-item">
            <span class="label">健康状况</span>
            <span class="value" :class="{'text-warning': petInfo.health !== '健康'}">
              {{ petInfo.health }}
            </span>
          </div>
          <div class="detail-item">
            <span class="label">训练程度</span>
            <span class="value">{{ petInfo.training }}</span>
          </div>
        </div>

        <div class="requirements-section">
          <h2>领养要求</h2>
          <ul>
            <li v-for="(req, index) in petInfo.requirements" :key="index">
              {{ req }}
            </li>
          </ul>
        </div>

        <div class="contact-section">
          <h2>联系方式</h2>
          <div class="contact-info">
            <div class="contact-item">
              <span class="icon">👤</span>
              <span>负责人：{{ petInfo.contact.name }}</span>
            </div>
            <div class="contact-item">
              <span class="icon">📞</span>
              <span>电话：{{ petInfo.contact.phone }}</span>
            </div>
            <div class="contact-item">
              <span class="icon">📧</span>
              <span>邮箱：{{ petInfo.contact.email }}</span>
            </div>
          </div>
          <button class="contact-button">
            <span class="icon">💌</span>
            联系领养
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.pet-info-page {
  padding: 2rem;
  min-height: 100vh;
  background: linear-gradient(135deg, #f6f9fc 0%, #ffffff 100%);
}

.pet-info-container {
  max-width: 1200px;
  margin: 0 auto;
  background: white;
  border-radius: 16px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
  overflow: hidden;
}

.pet-header {
  position: relative;
}

.main-image {
  position: relative;
  width: 100%;
  height: 500px;
  overflow: hidden;
}

.main-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.5s ease;
}

.category-tag {
  position: absolute;
  top: 1.5rem;
  right: 1.5rem;
  background: rgba(255, 107, 107, 0.9);
  color: white;
  padding: 0.6rem 1.2rem;
  border-radius: 20px;
  font-size: 0.9rem;
  font-weight: 600;
  backdrop-filter: blur(4px);
}

.image-gallery {
  position: absolute;
  bottom: 1.5rem;
  left: 1.5rem;
  display: flex;
  gap: 1rem;
  padding: 0.5rem;
  background: rgba(255, 255, 255, 0.9);
  border-radius: 12px;
  backdrop-filter: blur(4px);
}

.image-gallery img {
  width: 80px;
  height: 80px;
  border-radius: 8px;
  object-fit: cover;
  cursor: pointer;
  transition: all 0.3s ease;
  border: 2px solid transparent;
}

.image-gallery img:hover {
  transform: translateY(-2px);
}

.image-gallery img.active {
  border-color: #ff6b6b;
}

.info-content {
  padding: 2rem;
}

.basic-info h1 {
  font-size: 2.2rem;
  font-weight: 700;
  color: #333;
  margin-bottom: 1rem;
}

.tags {
  display: flex;
  flex-wrap: wrap;
  gap: 0.8rem;
  margin-bottom: 1.5rem;
}

.tag {
  background: #f8f9fa;
  padding: 0.6rem 1.2rem;
  border-radius: 20px;
  font-size: 0.95rem;
  color: #666;
  transition: all 0.3s ease;
}

.tag:hover {
  transform: translateY(-2px);
}

.tag-warning {
  background: #fff3f3;
  color: #ff6b6b;
}

.description {
  font-size: 1.1rem;
  line-height: 1.8;
  color: #666;
  margin-bottom: 2rem;
}

.details-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 1.5rem;
  margin-bottom: 2.5rem;
}

.detail-item {
  background: #f8f9fa;
  padding: 1.5rem;
  border-radius: 12px;
  transition: all 0.3s ease;
}

.detail-item:hover {
  transform: translateY(-3px);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
}

.detail-item .label {
  font-size: 0.9rem;
  color: #666;
  display: block;
  margin-bottom: 0.5rem;
}

.detail-item .value {
  font-size: 1.2rem;
  color: #333;
  font-weight: 600;
}

.text-warning {
  color: #ff6b6b;
}

.requirements-section,
.contact-section {
  margin-bottom: 2.5rem;
}

.requirements-section h2,
.contact-section h2 {
  font-size: 1.5rem;
  color: #333;
  margin-bottom: 1.5rem;
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.requirements-section ul {
  list-style: none;
  padding: 0;
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 1rem;
}

.requirements-section li {
  padding: 1rem;
  color: #666;
  position: relative;
  padding-left: 2rem;
  background: #f8f9fa;
  border-radius: 12px;
  transition: all 0.3s ease;
}

.requirements-section li:hover {
  transform: translateX(5px);
  background: #fff0f0;
}

.requirements-section li::before {
  content: "✓";
  color: #ff6b6b;
  font-size: 1.2rem;
  position: absolute;
  left: 0.8rem;
}

.contact-info {
  background: #f8f9fa;
  padding: 1.5rem;
  border-radius: 12px;
  margin-bottom: 1.5rem;
}

.contact-item {
  display: flex;
  align-items: center;
  gap: 0.8rem;
  padding: 0.8rem 0;
  color: #666;
}

.contact-item .icon {
  font-size: 1.2rem;
}

.contact-button {
  width: 100%;
  padding: 1.2rem;
  background: linear-gradient(45deg, #ff6b6b, #ff8e8e);
  color: white;
  border: none;
  border-radius: 12px;
  font-size: 1.1rem;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.8rem;
}

.contact-button:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(255, 107, 107, 0.2);
}

.contact-button .icon {
  font-size: 1.2rem;
}

@media (max-width: 768px) {
  .pet-info-page {
    padding: 1rem;
  }

  .main-image {
    height: 300px;
  }

  .image-gallery {
    position: relative;
    bottom: 0;
    left: 0;
    padding: 1rem;
    overflow-x: auto;
  }

  .info-content {
    padding: 1.5rem;
  }

  .basic-info h1 {
    font-size: 1.8rem;
  }

  .requirements-section ul {
    grid-template-columns: 1fr;
  }
}
</style>