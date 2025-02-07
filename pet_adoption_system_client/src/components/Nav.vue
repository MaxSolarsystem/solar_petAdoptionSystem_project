<script lang="ts" setup>
import {ref} from 'vue';

const isLoggedIn = ref(false);
</script>

<template>
  <header>
    <nav class="navbar">
      <div class="navbar-left">
        <router-link class="nav-link" to="/">主页</router-link>
        <router-link class="nav-link" to="/petAdoption">宠物领养</router-link>
        <router-link class="nav-link" to="/store">商店</router-link>
        <router-link class="nav-link" to="/forum">论坛</router-link>
        <router-link class="nav-link" to="/userCenter">个人中心</router-link>
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
  background-color: #fff;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
}

.navbar-left,
.navbar-right {
  display: flex;
  gap: 24px;
}

.nav-link {
  text-decoration: none;
  color: #333;
  font-size: 18px;
  font-weight: 500;
  transition: color 0.3s ease, transform 0.3s ease;
  padding: 8px 16px;
  border-radius: 4px;
  display: inline-block;
}

.nav-link:hover {
  color: #007bff;
  transform: translateY(-2px);
}

.nav-link:active {
  transform: translateY(1px);
}

.register {
  color: #007bff;
  border: 1px solid #007bff;
  background-color: transparent;
  font-weight: 600;
  padding: 8px 16px;
  transition: background-color 0.3s ease, color 0.3s ease;
  border-radius: 4px;
}

.register:hover {
  background-color: #007bff;
  color: #fff;
}

.welcome {
  color: #4caf50;
  font-weight: 600;
  font-size: 16px;
}

@media (max-width: 768px) {
  .navbar {
    flex-direction: column;
    gap: 20px;
    align-items: center;
  }

  .navbar-left,
  .navbar-right {
    gap: 16px;
  }

  .nav-link {
    font-size: 16px;
  }
}
</style>
