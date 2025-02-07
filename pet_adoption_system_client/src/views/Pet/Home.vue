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
    <main class="main-grid">
      <!-- 左边宠物领养 -->
      <router-link
          :to="cards.adoption.link"
          class="main-card adoption-card"
      >
        <div class="card-overlay"></div>
        <div class="card-content">
          <h2>{{ cards.adoption.title }}</h2>
          <p>{{ cards.adoption.description }}</p>
        </div>
        <img :src="cards.adoption.image" alt="宠物领养" class="card-bg">
      </router-link>

      <!-- 右边栏 -->
      <div class="right-column">
        <!-- 公告 -->
        <div class="announcement-card">
          <h3>最新公告</h3>
          <ul class="announcement-list">
            <li
                v-for="(item, index) in announcements"
                :key="index"
                class="announcement-item"
            >
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
            <h2>{{ cards.store.title }}</h2>
            <p>{{ cards.store.description }}</p>
          </div>
          <img :src="cards.store.image" alt="宠物商店" class="card-bg">
        </router-link>
      </div>
    </main>
  </div>
</template>

<style scoped>
.home-container {

  margin: 0 auto;
  padding: 2rem;
}

.main-grid {
  display: grid;
  grid-template-columns: 3fr 2fr; /* 调整比例 */
  gap: 2rem;
}

/* 通用卡片样式 */
[class$="-card"] {
  position: relative;
  border-radius: 1.5rem;
  overflow: hidden;
  transition: transform 0.3s ease;
  box-shadow: 0 10px 20px rgba(0,0,0,0.1);
  width: 100%; /* 撑满容器 */
}

/* 高度调整 */
.adoption-card {
  height: 75vh; /* 改用视窗单位 */
  min-height: 600px;
}

.right-column {
  display: flex;
  flex-direction: column;
  height: 75vh; /* 与左边高度一致 */
  min-height: 600px;
  gap: 2rem;
}

.announcement-card {
  flex: 4;  /* 公告占4份 */
  background: #fff;
  padding: 2rem;
}

.store-card {
  flex: 6;  /* 商店占6份 */
  position: relative;
}

/* 图片优化 */
.card-bg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
  z-index: 1;
}

.card-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(45deg, rgba(0,0,0,0.6), rgba(0,0,0,0.3));
  z-index: 2;
}

.card-content {
  position: relative;
  z-index: 3;
  color: white;
  padding: 2rem;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
}

/* 文字优化 */
h2 {
  font-size: 2.8rem;
  margin: 0 0 1rem 0;
  line-height: 1.2;
}

h3 {
  font-size: 1.8rem;
  margin: 0 0 1.5rem 0;
  color: #333;
}

.announcement-list {
  list-style: none;
  padding: 0;
  margin: 0;
}

.announcement-item {
  padding: 1.2rem 0;
  border-bottom: 1px solid #eee;
  font-size: 1.1rem;
  color: #444;
  line-height: 1.5;
}

@media (max-width: 1024px) {
  .main-grid {
    grid-template-columns: 1fr;
    min-height: auto;
  }

  .adoption-card,
  .right-column {
    height: auto;
    min-height: 400px;
  }

  h2 {
    font-size: 2rem;
  }
}
</style>