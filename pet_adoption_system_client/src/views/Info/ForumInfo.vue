<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const articleId = route.params.id
const article = ref(null)

// 模拟获取文章详细信息
const fetchArticleInfo = async () => {
  // 这里应该是实际的API调用
  // 现在用模拟数据
  article.value = {
    id: articleId,
    title: '如何帮助流浪猫找到温暖的家',
    author: {
      name: '爱心使者',
      avatar: 'https://api.dicebear.com/7.x/micah/svg?seed=Felix',
      description: '资深动物保护志愿者，5年救助经验'
    },
    publishTime: '2024-03-18 14:30',
    content: `
      在城市中，我们经常能看到流浪猫的身影。作为爱护动物的人，我们应该如何正确地帮助它们呢？

      1. 评估状况
      首先要观察猫咪的状况，包括：
      - 健康状况
      - 是否有项圈（可能是走失的宠物猫）
      - 性格特点

      2. 临时救助
      - 提供食物和水
      - 准备干净的猫砂
      - 设置温暖的休息区域

      3. 寻找原主人
      如果怀疑是走失的宠物猫：
      - 在社区张贴寻猫启示
      - 在社交媒体发布信息
      - 带去宠物医院检查是否有芯片

      4. 助养和领养
      如果确定是流浪猫：
      - 进行体检和疫苗注射
      - 发布领养信息
      - 严格筛选领养人

      5. 后续跟进
      - 定期回访
      - 建立领养群
      - 分享养护经验
    `,
    images: [
      'https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?w=800',
      'https://images.unsplash.com/photo-1573865526739-10659fec78a5?w=800',
      'https://images.unsplash.com/photo-1495360010541-f48722b34f7d?w=800'
    ],
    tags: ['流浪猫', '领养', '救助', '科普'],
    stats: {
      views: 1234,
      likes: 156,
      comments: 45
    },
    comments: [
      {
        id: 1,
        user: '小明',
        avatar: 'https://api.dicebear.com/7.x/micah/svg?seed=1',
        content: '非常实用的文章，感谢分享！',
        time: '2024-03-18 15:00'
      },
      {
        id: 2,
        user: '爱心妈妈',
        avatar: 'https://api.dicebear.com/7.x/micah/svg?seed=2',
        content: '我也是救助站的志愿者，这些建议都很专业。',
        time: '2024-03-18 15:30'
      }
    ]
  }
}

onMounted(() => {
  fetchArticleInfo()
})
</script>

<template>
  <div class="article-page">
    <div v-if="article" class="article-container">
      <!-- 文章头部 -->
      <div class="article-header">
        <div class="breadcrumb">
          <router-link to="/forum" class="back-link">
            <span class="icon">←</span> 返回论坛
          </router-link>
        </div>
        <h1>{{ article.title }}</h1>
        <div class="article-meta">
          <div class="author-info">
            <img :src="article.author.avatar" :alt="article.author.name" class="author-avatar">
            <div class="author-details">
              <span class="author-name">{{ article.author.name }}</span>
              <span class="author-description">{{ article.author.description }}</span>
            </div>
          </div>
          <div class="publish-info">
            <div class="publish-time">
              <span class="icon">🕒</span>
              {{ article.publishTime }}
            </div>
            <div class="article-stats">
              <span class="stat-item">
                <span class="icon">👁️</span>
                {{ article.stats.views }}
              </span>
              <span class="stat-item">
                <span class="icon">❤️</span>
                {{ article.stats.likes }}
              </span>
              <span class="stat-item">
                <span class="icon">💬</span>
                {{ article.stats.comments }}
              </span>
            </div>
          </div>
        </div>
        <div class="tags">
          <span v-for="tag in article.tags" :key="tag" class="tag">
            <span class="icon">#</span>
            {{ tag }}
          </span>
        </div>
      </div>

      <!-- 文章内容 -->
      <div class="article-content">
        <div class="content-text" v-html="article.content.replace(/\n/g, '<br>')"></div>
        <div class="content-images">
          <div v-for="(image, index) in article.images" 
               :key="index"
               class="image-wrapper"
               @click="() => window.open(image, '_blank')">
            <img :src="image" :alt="`图片${index + 1}`">
            <div class="image-overlay">
              <span class="icon">🔍</span>
            </div>
          </div>
        </div>
      </div>

      <!-- 互动区域 -->
      <div class="interaction-section">
        <button class="like-button">
          <span class="icon">❤️</span>
          点赞 {{ article.stats.likes }}
        </button>
        <button class="share-button">
          <span class="icon">📤</span>
          分享文章
        </button>
      </div>

      <!-- 评论区 -->
      <div class="comments-section">
        <h2>
          <span class="icon">💬</span>
          评论 ({{ article.comments.length }})
        </h2>
        <div class="comment-input">
          <textarea 
            placeholder="写下你的评论..."
            rows="3"
          ></textarea>
          <button class="submit-comment">
            <span class="icon">📝</span>
            发表评论
          </button>
        </div>
        <div class="comments-list">
          <div v-for="comment in article.comments" 
               :key="comment.id"
               class="comment-item">
            <img :src="comment.avatar" :alt="comment.user" class="comment-avatar">
            <div class="comment-content">
              <div class="comment-header">
                <span class="comment-user">{{ comment.user }}</span>
                <span class="comment-time">{{ comment.time }}</span>
              </div>
              <p class="comment-text">{{ comment.content }}</p>
              <div class="comment-actions">
                <button class="action-button">
                  <span class="icon">👍</span> 赞
                </button>
                <button class="action-button">
                  <span class="icon">↩️</span> 回复
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.article-page {
  padding: 2rem;
  min-height: 100vh;
  background: linear-gradient(135deg, #f6f9fc 0%, #ffffff 100%);
}

.article-container {
  max-width: 1200px;
  margin: 0 auto;
  background: white;
  border-radius: 16px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
  padding: 2rem;
}

.breadcrumb {
  margin-bottom: 2rem;
}

.back-link {
  display: inline-flex;
  align-items: center;
  gap: 0.5rem;
  color: #666;
  text-decoration: none;
  font-size: 0.9rem;
  transition: all 0.3s ease;
}

.back-link:hover {
  color: #ff6b6b;
  transform: translateX(-5px);
}

.article-header h1 {
  font-size: 2.2rem;
  font-weight: 800;
  color: #333;
  margin-bottom: 1.5rem;
  line-height: 1.3;
}

.article-meta {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1.5rem;
  padding: 1.5rem;
  background: #f8f9fa;
  border-radius: 12px;
}

.author-info {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.author-avatar {
  width: 48px;
  height: 48px;
  border-radius: 50%;
  object-fit: cover;
  border: 2px solid #fff;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.author-details {
  display: flex;
  flex-direction: column;
}

.author-name {
  font-weight: 600;
  color: #333;
}

.author-description {
  font-size: 0.9rem;
  color: #666;
}

.publish-info {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  gap: 0.5rem;
}

.publish-time {
  color: #666;
  font-size: 0.9rem;
}

.article-stats {
  display: flex;
  gap: 1rem;
}

.stat-item {
  display: flex;
  align-items: center;
  gap: 0.3rem;
  color: #666;
  font-size: 0.9rem;
}

.tags {
  display: flex;
  gap: 0.8rem;
  flex-wrap: wrap;
  margin-bottom: 2rem;
}

.tag {
  background: #f8f9fa;
  padding: 0.6rem 1.2rem;
  border-radius: 20px;
  font-size: 0.9rem;
  color: #666;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  gap: 0.3rem;
}

.tag:hover {
  transform: translateY(-2px);
  background: #fff0f0;
  color: #ff6b6b;
}

.content-text {
  font-size: 1.1rem;
  line-height: 1.8;
  color: #333;
  margin-bottom: 2rem;
}

.content-images {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 1rem;
  margin-bottom: 2rem;
}

.image-wrapper {
  position: relative;
  border-radius: 12px;
  overflow: hidden;
  cursor: pointer;
}

.image-wrapper img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: all 0.3s ease;
}

.image-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.3);
  display: flex;
  align-items: center;
  justify-content: center;
  opacity: 0;
  transition: all 0.3s ease;
}

.image-wrapper:hover img {
  transform: scale(1.05);
}

.image-wrapper:hover .image-overlay {
  opacity: 1;
}

.interaction-section {
  display: flex;
  gap: 1rem;
  margin-bottom: 3rem;
}

.like-button,
.share-button {
  flex: 1;
  padding: 1rem;
  border: none;
  border-radius: 12px;
  font-size: 1rem;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.5rem;
}

.like-button {
  background: linear-gradient(45deg, #ff6b6b, #ff8e8e);
  color: white;
}

.share-button {
  background: #f8f9fa;
  color: #666;
}

.like-button:hover,
.share-button:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

.comments-section {
  margin-top: 3rem;
}

.comments-section h2 {
  font-size: 1.5rem;
  color: #333;
  margin-bottom: 1.5rem;
}

.comments-list {
  margin-top: 2rem;
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
  margin-bottom: 2rem;
}

.comment-item {
  display: flex;
  gap: 1rem;
  padding: 1.5rem;
  background: #f8f9fa;
  border-radius: 12px;
  transition: all 0.3s ease;
}

.comment-item:hover {
  transform: translateX(5px);
  background: #fff0f0;
}

.comment-avatar {
  width: 40px;
  height: 40px;
  border-radius: 50%;
}

.comment-content {
  flex: 1;
}

.comment-header {
  display: flex;
  justify-content: space-between;
  margin-bottom: 0.5rem;
}

.comment-user {
  font-weight: 600;
  color: #333;
}

.comment-time {
  font-size: 0.9rem;
  color: #666;
}

.comment-text {
  color: #333;
  line-height: 1.6;
}

.comment-input {
  margin-top: 2rem;
}

.comment-input textarea {
  width: 100%;
  padding: 1rem;
  border: 2px solid #eee;
  border-radius: 12px;
  resize: vertical;
  font-size: 1rem;
  margin-bottom: 1rem;
  transition: all 0.3s ease;
}

.comment-input textarea:focus {
  border-color: #ff6b6b;
  outline: none;
  box-shadow: 0 0 0 3px rgba(255, 107, 107, 0.1);
}

.submit-comment {
  padding: 0.8rem 1.5rem;
  background: linear-gradient(45deg, #ff6b6b, #ff8e8e);
  color: white;
  border: none;
  border-radius: 12px;
  font-size: 1rem;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
}

.submit-comment:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(255, 107, 107, 0.2);
}

.comment-actions {
  display: flex;
  gap: 1rem;
  margin-top: 0.8rem;
}

.action-button {
  background: none;
  border: none;
  color: #666;
  font-size: 0.9rem;
  cursor: pointer;
  display: flex;
  align-items: center;
  gap: 0.3rem;
  transition: all 0.3s ease;
}

.action-button:hover {
  color: #ff6b6b;
}

@media (max-width: 768px) {
  .article-page {
    padding: 1rem;
  }

  .article-container {
    padding: 1.5rem;
  }

  .article-header h1 {
    font-size: 1.8rem;
  }

  .article-meta {
    flex-direction: column;
    align-items: flex-start;
    gap: 1rem;
    padding: 1rem;
  }

  .publish-info {
    align-items: flex-start;
  }

  .content-images {
    grid-template-columns: 1fr;
  }

  .interaction-section {
    flex-direction: column;
  }
}
</style>