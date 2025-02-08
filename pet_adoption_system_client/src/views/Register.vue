<script lang="ts" setup>
import {ref} from 'vue'
import {useRouter} from 'vue-router'

const router = useRouter()

// 注册表单的绑定
const email = ref('')
const password = ref('')
const confirmPassword = ref('')
const emailCode = ref('')
const captcha = ref('')
const captchaImg = ref('')

const handleRegister = () => {
  if (password.value !== confirmPassword.value) {
    alert('密码和确认密码不一致')
    return
  }

  // 模拟注册逻辑，实际开发时需要与后端交互
  console.log(`注册邮箱: ${email.value}, 密码: ${password.value}, 邮箱验证码: ${emailCode.value}, 图形验证码: ${captcha.value}`)
}

const navigateToLogin = () => {
  router.push('/login')
}

// 获取图形验证码
const getCaptchaImage = async () => {
  // 在实际开发中，你可以向后端请求获取验证码
  captchaImg.value = 'http://example.com/captcha-image'
}

// 页面加载时获取图形验证码
getCaptchaImage()
</script>

<template>
  <div class="register-container">
    <div class="register-box">
      <h1 class="title">🐾 宠物领养平台 - 注册</h1>

      <div class="input-group">
        <label for="email">邮箱</label>
        <input id="email" v-model="email" placeholder="请输入邮箱" type="email"/>
      </div>

      <div class="input-group">
        <label for="password">密码</label>
        <input id="password" v-model="password" placeholder="请输入密码" type="password"/>
      </div>

      <div class="input-group">
        <label for="confirmPassword">确认密码</label>
        <input id="confirmPassword" v-model="confirmPassword" placeholder="确认密码" type="password"/>
      </div>

      <div class="input-group">
        <label for="emailCode">邮箱验证码</label>
        <div class="email-code-container">
          <input id="emailCode" v-model="emailCode" placeholder="请输入验证码" type="text"/>
          <button class="get-code-button">获取</button>
        </div>
      </div>

      <div class="input-group">
        <label for="captcha">图形验证码</label>
        <div class="captcha-container">
          <input id="captcha" v-model="captcha" placeholder="请输入图形验证码" type="text"/>
          <img :src="captchaImg" alt="图形验证码" class="captcha-image"/>
        </div>
      </div>

      <button class="register-button" @click="handleRegister">注册</button>

      <div class="login-link">
        <span>已有账号？</span>
        <a href="javascript:void(0)" @click="navigateToLogin">去登录</a>
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

.register-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: linear-gradient(135deg, #a8e6cf 0%, #dcedc1 100%);
  position: relative;
  overflow: hidden;
}

.register-container::before {
  content: "";
  position: absolute;
  width: 100%;
  height: 100%;
  background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100"><circle cx="50" cy="50" r="20" fill="rgba(255,255,255,0.1)"/></svg>');
  background-size: 100px 100px;
  opacity: 0.5;
  animation: floating 20s linear infinite;
}

.register-box {
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

.register-box:hover {
  transform: translateY(-5px);
}

.title {
  font-size: 28px;
  margin-bottom: 30px;
  color: #4CAF50;
  font-weight: 700;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
}

.input-group {
  margin-bottom: 20px;
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
  border-color: #4CAF50;
  box-shadow: 0 0 0 3px rgba(76, 175, 80, 0.2);
}

.email-code-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.email-code-container input {
  width: calc(100% - 100px);
}

.get-code-button {
  background: linear-gradient(45deg, #4CAF50, #8BC34A);
  color: white;
  border: none;
  padding: 12px 15px;
  border-radius: 12px;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
  box-shadow: 0 4px 15px rgba(76, 175, 80, 0.3);
}

.get-code-button:hover {
  transform: translateY(-2px);
  box-shadow: 0 6px 20px rgba(76, 175, 80, 0.4);
}

.captcha-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.captcha-container input {
  width: calc(100% - 120px);
}

.captcha-image {
  width: 110px;
  height: 44px;
  border-radius: 8px;
  cursor: pointer;
  transition: transform 0.3s ease;
}

.captcha-image:hover {
  transform: scale(1.05);
}

.register-button {
  width: 100%;
  padding: 14px;
  background: linear-gradient(45deg, #4CAF50, #8BC34A);
  color: white;
  border: none;
  border-radius: 12px;
  font-size: 16px;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
  box-shadow: 0 4px 15px rgba(76, 175, 80, 0.3);
}

.register-button:hover {
  transform: translateY(-2px);
  box-shadow: 0 6px 20px rgba(76, 175, 80, 0.4);
}

.login-link {
  margin-top: 20px;
}

.login-link span {
  color: #666;
}

.login-link a {
  color: #4CAF50;
  font-weight: 600;
  text-decoration: none;
  margin-left: 5px;
  position: relative;
}

.login-link a::after {
  content: '';
  position: absolute;
  width: 100%;
  height: 2px;
  bottom: -2px;
  left: 0;
  background-color: #4CAF50;
  transform: scaleX(0);
  transition: transform 0.3s ease;
}

.login-link a:hover::after {
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
