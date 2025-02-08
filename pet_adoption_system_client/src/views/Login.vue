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
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: linear-gradient(135deg, #f6d365 0%, #fda085 100%);
  position: relative;
  overflow: hidden;
}

.login-container::before {
  content: "";
  position: absolute;
  width: 100%;
  height: 100%;
  background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100"><path d="M30,50 Q50,30 70,50 Q50,70 30,50 Z" fill="rgba(255,255,255,0.1)"/></svg>');
  background-size: 100px 100px;
  opacity: 0.5;
  animation: floating 20s linear infinite;
}

.login-box {
  background: rgba(255, 255, 255, 0.95);
  padding: 40px;
  border-radius: 20px;
  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.1);
  backdrop-filter: blur(10px);
  width: 420px;
  position: relative;
  transform: translateY(0);
  transition: transform 0.3s ease;
}

.login-box:hover {
  transform: translateY(-5px);
}

.title {
  font-size: 28px;
  margin-bottom: 30px;
  color: #ff6b6b;
  font-weight: 700;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
}

.input-group {
  margin-bottom: 25px;
}

.input-group label {
  font-size: 15px;
  color: #555;
  font-weight: 500;
  margin-bottom: 8px;
  display: block;
}

.input-group input {
  width: 100%;
  padding: 12px 15px;
  border: 2px solid #eee;
  border-radius: 12px;
  font-size: 15px;
  transition: all 0.3s ease;
  background: rgba(255, 255, 255, 0.9);
}

.input-group input:focus {
  border-color: #ff6b6b;
  box-shadow: 0 0 0 3px rgba(255, 107, 107, 0.2);
}

.login-button {
  width: 100%;
  padding: 14px;
  background: linear-gradient(45deg, #ff6b6b, #ffa502);
  color: white;
  border: none;
  border-radius: 12px;
  font-size: 16px;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
  box-shadow: 0 4px 15px rgba(255, 107, 107, 0.3);
}

.login-button:hover {
  transform: translateY(-2px);
  box-shadow: 0 6px 20px rgba(255, 107, 107, 0.4);
}

.switch-link {
  margin-top: 20px;
}

.switch-link span {
  color: #666;
}

.switch-link a {
  color: #ff6b6b;
  font-weight: 600;
  text-decoration: none;
  margin-left: 5px;
  position: relative;
}

.switch-link a::after {
  content: '';
  position: absolute;
  width: 100%;
  height: 2px;
  bottom: -2px;
  left: 0;
  background-color: #ff6b6b;
  transform: scaleX(0);
  transition: transform 0.3s ease;
}

.switch-link a:hover::after {
  transform: scaleX(1);
}

@keyframes floating {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}
</style>
