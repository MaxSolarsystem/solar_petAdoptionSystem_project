<script lang="ts" setup>
const cards = {
  adoption: {
    title: '宠物领养',
    description: '寻找您的新伙伴',
    image: 'https://cdn2.thedogapi.com/images/4UKTN_dQ5.jpg',
    link: '/petAdoption'
  },
  store: {
    title: '宠物商店',
    description: '精选优质宠物用品',
    image: 'https://cdn2.thedogapi.com/images/2xHtTb2Ee.jpg',
    link: '/store'
  }
}

const announcements = [
  '2024-03-15 系统升级维护通知',
  '2024-03-10 春季领养日活动报名开始',
  '2024-03-01 新用户注册指南更新'
]
</script>

<template>
  <div class="home-container">
    <div class="hero-section">
      <h1 class="hero-title">
        <span class="highlight">为爱</span>寻找一个家
      </h1>
      <p class="hero-subtitle">每一个生命都值得被温柔以待</p>
    </div>

    <main class="main-grid">
      <!-- 左边宠物领养 -->
      <router-link
          :to="cards.adoption.link"
          class="main-card adoption-card"
      >
        <div class="card-overlay"></div>
        <div class="card-content">
          <div class="card-icon">🏠</div>
          <h2>{{ cards.adoption.title }}</h2>
          <p>{{ cards.adoption.description }}</p>
          <span class="card-action">立即查看 →</span>
        </div>
        <img :src="cards.adoption.image" alt="宠物领养" class="card-bg">
      </router-link>

      <!-- 右边栏 -->
      <div class="right-column">
        <!-- 公告 -->
        <div class="announcement-card">
          <div class="card-header">
            <span class="header-icon">📢</span>
            <h3>最新公告</h3>
          </div>
          <ul class="announcement-list">
            <li
                v-for="(item, index) in announcements"
                :key="index"
                class="announcement-item"
            >
              <span class="announcement-dot"></span>
              {{ item }}
            </li>
          </ul>
        </div>

        <!-- 商店 -->
        <router-link
            :to="cards.store.link"
            class="store-card"
        >
          <div class="card-overlay"></div>
          <div class="card-content">
            <div class="card-icon">🛍️</div>
            <h2>{{ cards.store.title }}</h2>
            <p>{{ cards.store.description }}</p>
            <span class="card-action">去购物 →</span>
          </div>
          <img :src="cards.store.image" alt="宠物商店" class="card-bg">
        </router-link>
      </div>
    </main>
  </div>
</template>

<style scoped>
.home-container {
  padding: 2rem;
  min-height: 100vh;
  background: linear-gradient(135deg, #f6f9fc 0%, #ffffff 100%);
}

.hero-section {
  text-align: center;
  padding: 4rem 0;
  margin-bottom: 2rem;
}

.hero-title {
  font-size: 3.5rem;
  font-weight: 800;
  color: #2d3436;
  margin-bottom: 1rem;
  animation: fadeInUp 1s ease;
}

.highlight {
  color: #ff6b6b;
  position: relative;
}

.highlight::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 8px;
  background-color: rgba(255, 107, 107, 0.2);
  z-index: -1;
}

.hero-subtitle {
  font-size: 1.2rem;
  color: #636e72;
  animation: fadeInUp 1s ease 0.2s backwards;
}

.main-grid {
  display: grid;
  grid-template-columns: 3fr 2fr;
  gap: 2rem;
  max-width: 1400px;
  margin: 0 auto;
}

/* 卡片通用样式 */
[class$="-card"] {
  position: relative;
  border-radius: 24px;
  overflow: hidden;
  transition: all 0.4s cubic-bezier(0.4, 0, 0.2, 1);
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  background: white;
}

[class$="-card"]:hover {
  transform: translateY(-8px);
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.15);
}

.card-bg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.4s ease;
}

[class$="-card"]:hover .card-bg {
  transform: scale(1.05);
}

.card-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(
    to bottom,
    rgba(0, 0, 0, 0.2),
    rgba(0, 0, 0, 0.6)
  );
  z-index: 1;
}

.card-content {
  position: relative;
  z-index: 2;
  color: white;
  padding: 2rem;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
}

.card-icon {
  font-size: 2.5rem;
  margin-bottom: 1rem;
  animation: bounce 2s infinite;
}

.card-content h2 {
  font-size: 2rem;
  font-weight: 700;
  margin-bottom: 0.5rem;
}

.card-content p {
  font-size: 1.1rem;
  opacity: 0.9;
  margin-bottom: 1.5rem;
}

.card-action {
  font-size: 1rem;
  font-weight: 600;
  opacity: 0.8;
  transition: all 0.3s ease;
}

[class$="-card"]:hover .card-action {
  opacity: 1;
  transform: translateX(8px);
}

/* 高度调整 */
.adoption-card {
  height: 75vh;
  min-height: 600px;
}

.right-column {
  display: flex;
  flex-direction: column;
  height: 75vh;
  min-height: 600px;
  gap: 2rem;
}

/* 公告卡片 */
.announcement-card {
  flex: 4;
  padding: 2rem;
  background: white;
  border-radius: 24px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
}

.card-header {
  display: flex;
  align-items: center;
  gap: 0.8rem;
  margin-bottom: 1.5rem;
}

.header-icon {
  font-size: 1.5rem;
  animation: shake 2s infinite;
}

.announcement-card h3 {
  font-size: 1.5rem;
  font-weight: 700;
  color: #2d3436;
  margin: 0;
}

.announcement-list {
  list-style: none;
  padding: 0;
  margin: 0;
}

.announcement-item {
  display: flex;
  align-items: center;
  gap: 0.8rem;
  padding: 1rem 0;
  border-bottom: 1px solid rgba(0, 0, 0, 0.1);
  color: #636e72;
  transition: all 0.3s ease;
}

.announcement-item:hover {
  color: #2d3436;
  transform: translateX(8px);
}

.announcement-dot {
  width: 8px;
  height: 8px;
  background-color: #ff6b6b;
  border-radius: 50%;
}

/* 商店卡片 */
.store-card {
  flex: 6;
}

/* 动画 */
@keyframes fadeInUp {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes bounce {
  0%, 100% { transform: translateY(0); }
  50% { transform: translateY(-10px); }
}

@keyframes shake {
  0%, 100% { transform: rotate(0); }
  25% { transform: rotate(10deg); }
  75% { transform: rotate(-10deg); }
}

/* 响应式设计 */
@media (max-width: 1024px) {
  .main-grid {
    grid-template-columns: 1fr;
  }

  .hero-title {
    font-size: 2.5rem;
  }

  .adoption-card,
  .right-column {
    height: auto;
    min-height: auto;
  }

  .right-column {
    gap: 1.5rem;
  }

  .announcement-card,
  .store-card {
    min-height: 300px;
  }
}

@media (max-width: 768px) {
  .home-container {
    padding: 1rem;
  }

  .hero-section {
    padding: 2rem 0;
  }

  .card-content h2 {
    font-size: 1.5rem;
  }

  .card-content p {
    font-size: 1rem;
  }
}
</style>