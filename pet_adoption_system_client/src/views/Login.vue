<script lang="ts" setup>
import {ref} from 'vue'
import {useRouter} from 'vue-router'

const router = useRouter()

const loginEmail = ref('')
const loginPassword = ref('')

const handleLogin = () => {
  // 登录逻辑
  console.log(`登录邮箱: ${loginEmail.value}, 密码: ${loginPassword.value}`)
}

// 跳转到注册页面
const navigateToRegister = () => {
  router.push('/register')
}
</script>

<template>
  <div class="login-container">
    <div class="login-box">
      <h1 class="title">🐾 宠物领养平台 - 登录</h1>

      <div class="input-group">
        <label for="loginEmail">邮箱</label>
        <input id="loginEmail" v-model="loginEmail" placeholder="请输入邮箱" type="email"/>
      </div>

      <div class="input-group">
        <label for="loginPassword">密码</label>
        <input id="loginPassword" v-model="loginPassword" placeholder="请输入密码" type="password"/>
      </div>

      <button class="login-button" @click="handleLogin">登录</button>

      <div class="switch-link">
        <span>还没有账号？</span>
        <a href="javascript:void(0)" @click="navigateToRegister">立即注册</a>
      </div>
    </div>
  </div>
</template>

<style scoped>
* {
  box-sizing: border-box;
}

body {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  background: #f0f8ff;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  margin: 0;
}

.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.login-box {
  background-color: white;
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  width: 400px;
  text-align: center;
}

.title {
  font-size: 24px;
  margin-bottom: 20px;
  color: #4c9aff;
}

.input-group {
  margin-bottom: 20px;
  text-align: left;
}

.input-group label {
  font-size: 14px;
  color: #777;
}

.input-group input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 8px;
  margin-top: 5px;
  outline: none;
  transition: border-color 0.3s;
}

.input-group input:focus {
  border-color: #4c9aff;
}

.login-button {
  width: 100%;
  padding: 12px;
  background-color: #4c9aff;
  color: white;
  border: none;
  border-radius: 8px;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.login-button:hover {
  background-color: #357bd1;
}

.switch-link {
  margin-top: 15px;
}

.switch-link a {
  font-size: 12px;
  color: #357bd1;
  text-decoration: none;
}

.switch-link a:hover {
  text-decoration: underline;
}
</style>
