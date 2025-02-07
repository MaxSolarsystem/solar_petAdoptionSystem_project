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
}

.register-box {
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

.email-code-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.get-code-button {
  background-color: #4c9aff;
  color: white;
  border: none;
  width: 80px;
  padding: 8px 15px;
  border-radius: 5px;
  cursor: pointer;
  margin-left: 5px;
}

.get-code-button:hover {
  background-color: #357bd1;
}

.captcha-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.captcha-image {
  width: 100px;
  height: 40px;
  border-radius: 5px;
  margin-left: 5px;
}

.register-button {
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

.register-button:hover {
  background-color: #357bd1;
}

.login-link {
  margin-top: 15px;
}

.login-link a {
  font-size: 12px;
  color: #357bd1;
  text-decoration: none;
}

.login-link a:hover {
  text-decoration: underline;
}
</style>
