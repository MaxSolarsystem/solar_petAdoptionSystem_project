<script lang="ts" setup>
import { ref, onMounted, onUnmounted } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute();
const isLoggedIn = ref(true);
const isMenuOpen = ref(false);
const isMobile = ref(false);
// 使用在线头像服务
const avatarUrl = ref('https://api.dicebear.com/7.x/micah/svg?seed=pet&backgroundColor=ffdfbf');

// 检查屏幕宽度
const checkScreenSize = () => {
  isMobile.value = window.innerWidth <= 768;
  if (!isMobile.value) {
    isMenuOpen.value = false;
  }
};

// 监听路由变化关闭菜单
const closeMenu = () => {
  isMenuOpen.value = false;
};

// 阻止菜单打开时页面滚动
const preventScroll = (e: TouchEvent) => {
  if (isMenuOpen.value) {
    e.preventDefault();
  }
};

// 导航项配置
const navItems = [
  { path: '/', icon: '🏠', text: '主页' },
  { path: '/petAdoption', icon: '🐾', text: '宠物领养' },
  { path: '/store', icon: '🛍️', text: '商店' },
  { path: '/forum', icon: '💭', text: '论坛' },
  { path: '/userCenter', icon: '👤', text: '个人中心' },
  { path: '/buyCar', icon: '🛒', text: '购物车' }
] as const;

onMounted(() => {
  checkScreenSize();
  window.addEventListener('resize', checkScreenSize);
  document.body.addEventListener('touchmove', preventScroll, { passive: false });
});

onUnmounted(() => {
  window.removeEventListener('resize', checkScreenSize);
  document.body.removeEventListener('touchmove', preventScroll);
});
</script>

<template>
  <header :class="{ 'menu-open': isMenuOpen }">
    <nav class="navbar">
      <div class="navbar-left">
        <router-link 
          v-for="item in navItems"
          :key="item.path"
          :to="item.path"
          class="nav-link"
          :class="{ active: route.path === item.path }"
        >
          <span class="nav-icon">{{ item.icon }}</span>
          <span class="nav-text">{{ item.text }}</span>
        </router-link>
      </div>

      <div class="navbar-right">
        <template v-if="!isLoggedIn">
          <router-link class="nav-link login-link" to="/login">登录</router-link>
          <router-link class="nav-link register-link" to="/register">注册</router-link>
        </template>
        <div v-else class="user-info">
          <span class="welcome-text">欢迎，用户</span>
          <div class="user-avatar">
            <img :src="avatarUrl" alt="用户头像">
          </div>
        </div>

        <button 
          class="hamburger"
          :class="{ 'is-active': isMenuOpen }"
          @click="isMenuOpen = !isMenuOpen"
          aria-label="菜单"
        >
          <span></span>
          <span></span>
          <span></span>
        </button>
      </div>
    </nav>

    <!-- 移动端菜单 -->
    <transition name="fade">
      <div v-if="isMenuOpen" class="mobile-menu" @click="closeMenu">
        <div class="menu-content" @click.stop>
          <div class="menu-header">
            <div v-if="isLoggedIn" class="user-info">
              <div class="user-avatar">
                <img :src="avatarUrl" alt="用户头像">
              </div>
              <span class="welcome-text">欢迎，用户</span>
            </div>
          </div>
          
          <div class="menu-items">
            <router-link 
              v-for="item in navItems"
              :key="item.path"
              :to="item.path"
              class="menu-link"
              :class="{ active: route.path === item.path }"
              @click="closeMenu"
            >
              <span class="menu-icon">{{ item.icon }}</span>
              <span class="menu-text">{{ item.text }}</span>
            </router-link>
          </div>

          <div v-if="!isLoggedIn" class="menu-footer">
            <router-link class="mobile-login" to="/login" @click="closeMenu">登录</router-link>
            <router-link class="mobile-register" to="/register" @click="closeMenu">注册</router-link>
          </div>
        </div>
      </div>
    </transition>
  </header>
</template>

<style scoped>
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 32px;
  height: 70px;
  background: rgba(255, 255, 255, 0.95);
  backdrop-filter: blur(10px);
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1000;
  transition: all 0.3s ease;
}

.navbar-left,
.navbar-right {
  display: flex;
  align-items: center;
  gap: 8px;
}

.nav-link {
  text-decoration: none;
  color: #666;
  font-size: 15px;
  font-weight: 500;
  padding: 8px 16px;
  border-radius: 12px;
  display: flex;
  align-items: center;
  gap: 6px;
  transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
  position: relative;
}

.nav-link:hover,
.nav-link.active {
  color: #ff6b6b;
  background: rgba(255, 107, 107, 0.1);
}

.nav-icon {
  font-size: 18px;
  transition: transform 0.3s ease;
}

.nav-link:hover .nav-icon {
  transform: scale(1.2);
}

.login-link {
  color: #666;
}

.register-link {
  color: #ff6b6b;
  border: 2px solid #ff6b6b;
  background: transparent;
  font-weight: 600;
  padding: 8px 20px;
}

.register-link:hover {
  background: #ff6b6b;
  color: white;
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(255, 107, 107, 0.3);
}

.user-info {
  display: flex;
  align-items: center;
  gap: 12px;
  padding: 8px 16px;
  background: rgba(255, 107, 107, 0.1);
  border-radius: 12px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.user-info:hover {
  background: rgba(255, 107, 107, 0.15);
  transform: translateY(-2px);
}

.welcome-text {
  color: #ff6b6b;
  font-weight: 600;
  font-size: 14px;
}

.user-avatar {
  width: 32px;
  height: 32px;
  border-radius: 50%;
  overflow: hidden;
  border: 2px solid #ff6b6b;
}

.user-avatar img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  background-color: #fff; /* 添加背景色，防止图片加载时出现空白 */
}

/* 汉堡菜单按钮 */
.hamburger {
  display: none;
  width: 30px;
  height: 30px;
  position: relative;
  background: none;
  border: none;
  cursor: pointer;
  padding: 0;
}

.hamburger span {
  display: block;
  width: 100%;
  height: 2px;
  background: #666;
  position: absolute;
  left: 0;
  transition: all 0.3s ease;
}

.hamburger span:nth-child(1) { top: 8px; }
.hamburger span:nth-child(2) { top: 14px; }
.hamburger span:nth-child(3) { top: 20px; }

.hamburger.is-active span:nth-child(1) {
  transform: rotate(45deg);
  top: 14px;
  background: #ff6b6b;
}

.hamburger.is-active span:nth-child(2) {
  opacity: 0;
}

.hamburger.is-active span:nth-child(3) {
  transform: rotate(-45deg);
  top: 14px;
  background: #ff6b6b;
}

/* 移动端菜单 */
.mobile-menu {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  backdrop-filter: blur(5px);
  z-index: 999;
  display: flex;
  justify-content: flex-end;
}

.menu-content {
  width: 80%;
  max-width: 300px;
  height: 100%;
  background: white;
  padding: 20px;
  display: flex;
  flex-direction: column;
  animation: slideIn 0.3s ease;
}

.menu-header {
  padding: 20px 0;
  border-bottom: 1px solid rgba(0, 0, 0, 0.1);
}

.menu-items {
  flex: 1;
  padding: 20px 0;
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.menu-link {
  display: flex;
  align-items: center;
  gap: 12px;
  padding: 12px;
  color: #666;
  text-decoration: none;
  border-radius: 12px;
  transition: all 0.3s ease;
}

.menu-link:hover,
.menu-link.active {
  background: rgba(255, 107, 107, 0.1);
  color: #ff6b6b;
}

.menu-footer {
  padding: 20px 0;
  display: flex;
  gap: 10px;
}

.mobile-login,
.mobile-register {
  flex: 1;
  padding: 12px;
  text-align: center;
  text-decoration: none;
  border-radius: 12px;
  font-weight: 600;
  transition: all 0.3s ease;
}

.mobile-login {
  background: #f5f5f5;
  color: #666;
}

.mobile-register {
  background: #ff6b6b;
  color: white;
}

/* 动画 */
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.3s ease;
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}

@keyframes slideIn {
  from {
    transform: translateX(100%);
  }
  to {
    transform: translateX(0);
  }
}

/* 响应式设计 */
@media (max-width: 800px) {
  .navbar {
    padding: 0 16px;
    height: 60px;
  }

  .navbar-left {
    display: none;
  }

  .hamburger {
    display: block;
  }

  .nav-link {
    display: none;
  }

  .user-info {
    padding: 6px 12px;
  }

  .welcome-text {
    display: none;
  }
}
</style>
