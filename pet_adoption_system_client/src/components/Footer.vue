<script lang="ts" setup>
</script>

<template>
  <footer class="footer">
    <div class="footer-content">
      <p>&copy; 2025 宠物领养平台. 保留所有权利。</p>
    </div>
  </footer>
</template>

<style scoped>
.footer {
  background-color: #fafafa;
  padding: 40px 0;
  border-top: 1px solid #eaeaea;
  text-align: center;
}

.footer-content {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
}

.footer p {
  font-size: 14px;
  color: #777;
  font-weight: 400;
  line-height: 1.5;
}

/* Responsive Design */
@media (max-width: 768px) {
  .footer-content {
    padding: 0 15px;
  }

  .footer p {
    font-size: 12px;
  }
}
</style>
