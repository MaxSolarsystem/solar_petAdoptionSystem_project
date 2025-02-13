<script lang="ts" setup>
</script>

<template>
  <footer class="footer">
    <div class="footer-content">
      <div class="footer-info">
        <div class="footer-logo">
          <span class="logo-icon">💖</span>
          <span class="logo-text">宠物领养平台</span>
        </div>
        <p class="footer-description">让每一个生命都被温柔以待</p>
      </div>
      <div class="footer-links">
        <a href="#" class="footer-link">关于我们</a>
        <a href="#" class="footer-link">使用条款</a>
        <a href="#" class="footer-link">隐私政策</a>
        <a href="#" class="footer-link">联系我们</a>
      </div>
      <p class="copyright">&copy; 2025 宠物领养平台. 保留所有权利。</p>
    </div>
  </footer>
</template>

<style scoped>
.footer {
  background-color: #fff;
  padding: 40px 0;
  border-top: 1px solid rgba(0, 0, 0, 0.1);
  margin-top: auto;
}

.footer-content {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 24px;
}

.footer-info {
  text-align: center;
}

.footer-logo {
  display: flex;
  align-items: center;
  gap: 8px;
  margin-bottom: 12px;
}

.logo-icon {
  font-size: 24px;
  animation: bounce 2s infinite;
}

.logo-text {
  font-size: 18px;
  font-weight: 600;
  color: #333;
}

.footer-description {
  color: #666;
  font-size: 14px;
}

.footer-links {
  display: flex;
  gap: 24px;
  margin: 16px 0;
}

.footer-link {
  color: #666;
  text-decoration: none;
  font-size: 14px;
  transition: all 0.3s ease;
  position: relative;
}

.footer-link::after {
  content: '';
  position: absolute;
  bottom: -2px;
  left: 0;
  width: 100%;
  height: 1px;
  background-color: #ff6b6b;
  transform: scaleX(0);
  transition: transform 0.3s ease;
}

.footer-link:hover {
  color: #ff6b6b;
}

.footer-link:hover::after {
  transform: scaleX(1);
}

.copyright {
  font-size: 14px;
  color: #999;
}

@keyframes bounce {
  0%, 100% { transform: translateY(0); }
  50% { transform: translateY(-5px); }
}

@media (max-width: 768px) {
  .footer {
    padding: 30px 0;
  }

  .footer-links {
    flex-wrap: wrap;
    justify-content: center;
    gap: 16px;
  }

  .logo-text {
    font-size: 16px;
  }
}
</style>
