<script lang="ts" setup>
import {ref} from 'vue';

const isLoggedIn = ref(false);
</script>

<template>
  <header>
    <nav class="navbar">
      <div class="navbar-left">
        <router-link class="nav-link" to="/">
          <span class="nav-icon">🏠</span>
          主页
        </router-link>
        <router-link class="nav-link" to="/petAdoption">
          <span class="nav-icon">🐾</span>
          宠物领养
        </router-link>
        <router-link class="nav-link" to="/store">
          <span class="nav-icon">🛍️</span>
          商店
        </router-link>
        <router-link class="nav-link" to="/forum">
          <span class="nav-icon">💭</span>
          论坛
        </router-link>
        <router-link class="nav-link" to="/userCenter">
          <span class="nav-icon">👤</span>
          个人中心
        </router-link>
      </div>
      <div class="navbar-right">
        <router-link v-if="!isLoggedIn" class="nav-link" to="/login">登录</router-link>
        <router-link v-if="!isLoggedIn" class="nav-link register" to="/register">注册</router-link>
        <div v-if="isLoggedIn" class="nav-link welcome">欢迎，用户</div>
      </div>
    </nav>
  </header>
</template>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 16px 32px;
  background-color: rgba(255, 255, 255, 0.95);
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
  backdrop-filter: blur(10px);
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1000;
}

.navbar-left,
.navbar-right {
  display: flex;
  gap: 24px;
  align-items: center;
}

.nav-link {
  text-decoration: none;
  color: #555;
  font-size: 16px;
  font-weight: 500;
  transition: all 0.3s ease;
  padding: 8px 16px;
  border-radius: 12px;
  display: flex;
  align-items: center;
  gap: 6px;
  position: relative;
}

.nav-icon {
  font-size: 18px;
  transition: transform 0.3s ease;
}

.nav-link:hover {
  color: #ff6b6b;
  background: rgba(255, 107, 107, 0.1);
}

.nav-link:hover .nav-icon {
  transform: scale(1.2);
}

.nav-link::after {
  content: '';
  position: absolute;
  bottom: 4px;
  left: 50%;
  width: 0;
  height: 2px;
  background-color: #ff6b6b;
  transition: all 0.3s ease;
  transform: translateX(-50%);
}

.nav-link:hover::after {
  width: 60%;
}

.register {
  color: #ff6b6b;
  border: 2px solid #ff6b6b;
  background-color: transparent;
  font-weight: 600;
  padding: 8px 20px;
  transition: all 0.3s ease;
}

.register:hover {
  background-color: #ff6b6b;
  color: white;
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(255, 107, 107, 0.3);
}

.welcome {
  color: #4caf50;
  font-weight: 600;
  background: rgba(76, 175, 80, 0.1);
  padding: 8px 20px;
  border-radius: 12px;
}

@media (max-width: 768px) {
  .navbar {
    padding: 12px 16px;
  }

  .navbar-left,
  .navbar-right {
    gap: 12px;
  }

  .nav-link {
    font-size: 14px;
    padding: 6px 12px;
  }

  .nav-icon {
    font-size: 16px;
  }
}
</style>
