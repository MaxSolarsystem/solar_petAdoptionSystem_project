<script lang="ts" setup>
import { ref } from 'vue'

// 热门文章数据
const hotArticles = ref([
  {
    id: 1,
    title: '新手养猫必读指南',
    views: 2341,
    likes: 156
  },
  {
    id: 2,
    title: '狗狗训练的五个小技巧',
    views: 1892,
    likes: 143
  },
  {
    id: 3,
    title: '如何选择合适的宠物食品',
    views: 1654,
    likes: 98
  },
  {
    id: 4,
    title: '宠物日常护理小知识',
    views: 1432,
    likes: 87
  },
  {
    id: 5,
    title: '居家环境布置技巧',
    views: 1298,
    likes: 76
  }
])

// 文章列表数据
const articles = ref([
  {
    id: 1,
    title: '如何帮助流浪猫找到温暖的家',
    image: 'https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?w=500',
    publishTime: '2024-03-18 14:30',
    author: '爱心使者',
    summary: '在城市中，我们经常能看到流浪猫的身影。本文将分享如何正确帮助流浪猫，以及领养注意事项...',
    views: 1234,
    comments: 45
  },
  {
    id: 2,
    title: '狗狗的行为语言解读',
    image: 'https://images.unsplash.com/photo-1544568100-847a948585b9?w=500',
    publishTime: '2024-03-17 16:20',
    author: '汪星人专家',
    summary: '你真的了解狗狗在表达什么吗？摇尾巴不一定代表开心，躺下露出肚子也不一定想让你摸...',
    views: 892,
    comments: 23
  },
  {
    id: 3,
    title: '猫咪的日常护理指南',
    image: 'https://images.unsplash.com/photo-1533743983669-94fa5c4338ec?w=500',
    publishTime: '2024-03-16 09:45',
    author: '喵星人铲屎官',
    summary: '从梳毛、洗澡到指甲护理，本文详细介绍猫咪日常护理的各个方面，让你的猫主子更健康快乐...',
    views: 756,
    comments: 31
  },
  {
    id: 4,
    title: '宠物友好的居家环境布置',
    image: 'https://images.unsplash.com/photo-1600369671236-e74521d4b6ad?w=500',
    publishTime: '2024-03-15 11:30',
    author: '家居达人',
    summary: '如何打造一个既美观又适合宠物生活的家？从材料选择到空间规划，让家更适合主人和宠物...',
    views: 645,
    comments: 28
  }
])
</script>

<template>
  <div class="forum-container">
    <div class="forum-layout">
      <!-- 左侧热门文章 -->
      <div class="hot-articles">
        <div class="section-title">
          <span class="icon">🔥</span>
          热门文章
        </div>
        <div class="hot-list">
          <div v-for="(article, index) in hotArticles" 
               :key="article.id"
               class="hot-item">

            <div class="rank-number" :class="`rank-${index + 1}`">{{ index + 1 }}</div>
                       <router-link 
              :to="`/forum/info/${article.id}`"
            >
            <div class="hot-content">
              <h3>{{ article.title }}</h3>
              <div class="hot-stats">
                <span>👁️ {{ article.views }}</span>
                <span>❤️ {{ article.likes }}</span>
              </div>
            </div>
              </router-link>
          </div>
        </div>
      </div>

      <!-- 右侧文章列表 -->
      <div class="article-list">
        <div class="section-title">
          <span class="icon">📝</span>
          最新文章
        </div>
        <div class="articles">
          <div v-for="article in articles" 
               :key="article.id"
               class="article-card">
            <div class="article-image">
              <img :src="article.image" :alt="article.title">
            </div>

           <router-link 
              :to="`/forum/info/${article.id}`"
            >
            <div class="article-content">
              <h2 class="article-title">{{ article.title }}</h2>
              <div class="article-meta">
                <span>👤 {{ article.author }}</span>
                <span>🕒 {{ article.publishTime }}</span>
              </div>
              <p class="article-summary">{{ article.summary }}</p>
              <div class="article-footer">
                <span>👁️ {{ article.views }} 阅读</span>
                <span>💬 {{ article.comments }} 评论</span>
              </div>
            </div>
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.forum-container {
  padding: 2rem;
  background: linear-gradient(135deg, #f6f9fc 0%, #ffffff 100%);
}

.forum-layout {
  display: grid;
  grid-template-columns: 300px 1fr;
  gap: 2rem;
  max-width: 1600px;
  margin: 0 auto;
}

.section-title {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  font-size: 1.2rem;
  font-weight: 700;
  color: #333;
  margin-bottom: 1.5rem;
}

.icon {
  font-size: 1.4rem;
}

/* 热门文章样式 */
.hot-articles {
  background: white;
  padding: 1.5rem;
  border-radius: 16px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
}

.hot-list {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.hot-item {
  display: flex;
  align-items: center;
  gap: 1rem;
  padding: 1rem;
  background: #f8f9fa;
  border-radius: 12px;
  transition: all 0.3s ease;
}

.hot-item:hover {
  transform: translateX(5px);
  background: #fff0f0;
}

.rank-number {
  width: 28px;
  height: 28px;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 50%;
  font-weight: 700;
  font-size: 0.9rem;
  background: #ddd;
  color: white;
}

.rank-1 { background: #ff6b6b; }
.rank-2 { background: #ff8e8e; }
.rank-3 { background: #ffa5a5; }

.hot-content {
  flex: 1;
}

.hot-content h3 {
  font-size: 0.95rem;
  margin-bottom: 0.5rem;
  color: #333;
}

.hot-stats {
  display: flex;
  gap: 1rem;
  font-size: 0.8rem;
  color: #666;
}

/* 文章列表样式 */
.article-list {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.articles {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.article-card {
  display: flex;
  gap: 1.5rem;
  background: white;
  border-radius: 16px;
  overflow: hidden;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
  transition: all 0.3s ease;
}

.article-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 8px 30px rgba(0, 0, 0, 0.12);
}

.article-image {
  width: 200px;
  height: 200px;
  overflow: hidden;
}

.article-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.3s ease;
}

.article-card:hover .article-image img {
  transform: scale(1.05);
}

.article-content {
  flex: 1;
  padding: 1.5rem;
  padding-left: 0;
}

.article-title {
  font-size: 1.3rem;
  font-weight: 700;
  color: #333;
  margin-bottom: 0.5rem;
}

.article-meta {
  display: flex;
  gap: 1rem;
  font-size: 0.9rem;
  color: #666;
  margin-bottom: 1rem;
}

.article-summary {
  font-size: 0.95rem;
  color: #666;
  line-height: 1.6;
  margin-bottom: 1rem;
}

.article-footer {
  display: flex;
  gap: 1rem;
  font-size: 0.9rem;
  color: #666;
}

.article-link {
  display: flex;
  width: 100%;
  text-decoration: none;
  color: inherit;
}

@media (max-width: 1024px) {
  .forum-layout {
    grid-template-columns: 1fr;
  }

  .hot-articles {
    order: 2;
  }

  .article-list {
    order: 1;
  }
}

@media (max-width: 768px) {
  .forum-container {
    padding: 1rem;
  }

  .article-card {
    flex-direction: column;
  }

  .article-image {
    width: 100%;
    height: 200px;
  }

  .article-content {
    padding: 1.5rem;
  }

  .article-title {
    font-size: 1.2rem;
  }
}
</style>