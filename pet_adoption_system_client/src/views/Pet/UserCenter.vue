<script lang="ts" setup>
import { ref } from 'vue'

const userInfo = ref({
  avatar: 'https://api.dicebear.com/7.x/micah/svg?seed=pet&backgroundColor=ffdfbf', // 默认头像
  email: 'user@example.com',
  phone: '',
  username: '爱心领养者'
})

// 修改头像相关
const showAvatarUpload = ref(false)
const newAvatar = ref(null)

const handleAvatarChange = (event) => {
  const file = event.target.files[0]
  if (file) {
    const reader = new FileReader()
    reader.onload = (e) => {
      userInfo.value.avatar = e.target.result
    }
    reader.readAsDataURL(file)
  }
}

// 修改邮箱相关
const showEmailEdit = ref(false)
const newEmail = ref('')
const emailCode = ref('')

const sendEmailCode = () => {
  // TODO: 发送邮箱验证码
  console.log('发送验证码到:', newEmail.value)
}

const confirmEmailChange = () => {
  // TODO: 验证邮箱验证码
  console.log('确认修改邮箱')
  showEmailEdit.value = false
}

// 修改手机号相关
const showPhoneEdit = ref(false)
const newPhone = ref('')
const phoneCode = ref('')

const sendPhoneCode = () => {
  // TODO: 发送手机验证码
  console.log('发送验证码到:', newPhone.value)
}

const confirmPhoneChange = () => {
  // TODO: 验证手机验证码
  console.log('确认修改手机号')
  showPhoneEdit.value = false
}

// 修改密码相关
const showPasswordEdit = ref(false)
const passwordForm = ref({
  oldPassword: '',
  newPassword: '',
  confirmPassword: ''
})

const confirmPasswordChange = () => {
  if (passwordForm.value.newPassword !== passwordForm.value.confirmPassword) {
    alert('两次输入的新密码不一致')
    return
  }
  // TODO: 验证旧密码并修改
  console.log('确认修改密码')
  showPasswordEdit.value = false
}
</script>

<template>
  <div class="user-center">
    <div class="profile-header">
      <div class="avatar-section">
        <div class="avatar-container">
          <img :src="userInfo.avatar" alt="用户头像" class="avatar"/>
          <div class="avatar-overlay" @click="showAvatarUpload = true">
            <span class="edit-icon">📷</span>
          </div>
        </div>
        <h2 class="username">{{ userInfo.username }}</h2>
      </div>
    </div>

    <div class="profile-content">
      <!-- 基本信息卡片 -->
      <div class="info-card">
        <h3 class="card-title">
          <span class="title-icon">👤</span>
          基本信息
        </h3>
        
        <!-- 邮箱信息 -->
        <div class="info-item">
          <div class="item-label">邮箱</div>
          <div class="item-content">
            <template v-if="!showEmailEdit">
              <span>{{ userInfo.email }}</span>
              <button class="edit-button" @click="showEmailEdit = true">修改</button>
            </template>
            <div v-else class="edit-form">
              <div class="input-group">
                <input type="email" v-model="newEmail" placeholder="请输入新邮箱"/>
                <button class="verify-button" @click="sendEmailCode">获取验证码</button>
              </div>
              <div class="input-group">
                <input type="text" v-model="emailCode" placeholder="请输入验证码"/>
                <button class="confirm-button" @click="confirmEmailChange">确认</button>
                <button class="cancel-button" @click="showEmailEdit = false">取消</button>
              </div>
            </div>
          </div>
        </div>

        <!-- 手机号信息 -->
        <div class="info-item">
          <div class="item-label">手机号</div>
          <div class="item-content">
            <template v-if="!showPhoneEdit">
              <span>{{ userInfo.phone || '未绑定' }}</span>
              <button class="edit-button" @click="showPhoneEdit = true">
                {{ userInfo.phone ? '修改' : '绑定' }}
              </button>
            </template>
            <div v-else class="edit-form">
              <div class="input-group">
                <input type="tel" v-model="newPhone" placeholder="请输入手机号"/>
                <button class="verify-button" @click="sendPhoneCode">获取验证码</button>
              </div>
              <div class="input-group">
                <input type="text" v-model="phoneCode" placeholder="请输入验证码"/>
                <button class="confirm-button" @click="confirmPhoneChange">确认</button>
                <button class="cancel-button" @click="showPhoneEdit = false">取消</button>
              </div>
            </div>
          </div>
        </div>

        <!-- 密码修改 -->
        <div class="info-item">
          <div class="item-label">密码</div>
          <div class="item-content">
            <template v-if="!showPasswordEdit">
              <span>********</span>
              <button class="edit-button" @click="showPasswordEdit = true">修改</button>
            </template>
            <div v-else class="edit-form">
              <div class="input-group">
                <input type="password" v-model="passwordForm.oldPassword" placeholder="请输入原密码"/>
              </div>
              <div class="input-group">
                <input type="password" v-model="passwordForm.newPassword" placeholder="请输入新密码"/>
              </div>
              <div class="input-group">
                <input type="password" v-model="passwordForm.confirmPassword" placeholder="请确认新密码"/>
              </div>
              <div class="button-group">
                <button class="confirm-button" @click="confirmPasswordChange">确认</button>
                <button class="cancel-button" @click="showPasswordEdit = false">取消</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- 头像上传弹窗 -->
    <div v-if="showAvatarUpload" class="modal-overlay" @click="showAvatarUpload = false">
      <div class="modal-content" @click.stop>
        <h3>更换头像</h3>
        <input type="file" accept="image/*" @change="handleAvatarChange"/>
        <div class="button-group">
          <button class="confirm-button" @click="showAvatarUpload = false">确认</button>
          <button class="cancel-button" @click="showAvatarUpload = false">取消</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.user-center {
  padding: 2rem;
  min-height: 100vh;
  background: linear-gradient(135deg, #f6f9fc 0%, #ffffff 100%);
}

.profile-header {
  text-align: center;
  padding: 3rem 0;
  margin-bottom: 2rem;
}

.avatar-section {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 1rem;
}

.avatar-container {
  position: relative;
  width: 150px;
  height: 150px;
  border-radius: 50%;
  overflow: hidden;
  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.12);
  cursor: pointer;
  transition: transform 0.3s ease;
}

.avatar-container:hover {
  transform: scale(1.05);
}

.avatar {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.avatar-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  opacity: 0;
  transition: opacity 0.3s ease;
}

.avatar-container:hover .avatar-overlay {
  opacity: 1;
}

.edit-icon {
  font-size: 2rem;
  color: white;
}

.username {
  font-size: 1.8rem;
  color: #2d3436;
  font-weight: 700;
}

.profile-content {
  max-width: 800px;
  margin: 0 auto;
}

.info-card {
  background: white;
  border-radius: 24px;
  padding: 2rem;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
}

.card-title {
  display: flex;
  align-items: center;
  gap: 0.8rem;
  font-size: 1.5rem;
  color: #2d3436;
  margin-bottom: 2rem;
}

.title-icon {
  font-size: 1.8rem;
}

.info-item {
  display: flex;
  padding: 1.5rem 0;
  border-bottom: 1px solid rgba(0, 0, 0, 0.1);
}

.info-item:last-child {
  border-bottom: none;
}

.item-label {
  width: 100px;
  color: #666;
  font-weight: 500;
}

.item-content {
  flex: 1;
  display: flex;
  align-items: center;
  gap: 1rem;
}

.edit-button {
  padding: 6px 12px;
  border: none;
  background: rgba(255, 107, 107, 0.1);
  color: #ff6b6b;
  border-radius: 8px;
  cursor: pointer;
  font-weight: 500;
  transition: all 0.3s ease;
}

.edit-button:hover {
  background: rgba(255, 107, 107, 0.2);
  transform: translateY(-2px);
}

.edit-form {
  width: 100%;
}

.input-group {
  display: flex;
  gap: 1rem;
  margin-bottom: 1rem;
}

.input-group input {
  flex: 1;
  padding: 10px 15px;
  border: 2px solid #eee;
  border-radius: 12px;
  font-size: 14px;
  transition: all 0.3s ease;
}

.input-group input:focus {
  border-color: #ff6b6b;
  box-shadow: 0 0 0 3px rgba(255, 107, 107, 0.1);
  outline: none;
}

.verify-button {
  padding: 10px 20px;
  background: linear-gradient(45deg, #4CAF50, #8BC34A);
  color: white;
  border: none;
  border-radius: 12px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.verify-button:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(76, 175, 80, 0.2);
}

.button-group {
  display: flex;
  gap: 1rem;
  justify-content: flex-end;
  margin-top: 1rem;
}

.confirm-button,
.cancel-button {
  padding: 10px 20px;
  border: none;
  border-radius: 12px;
  cursor: pointer;
  transition: all 0.3s ease;
  font-weight: 500;
}

.confirm-button {
  background: linear-gradient(45deg, #ff6b6b, #ff8e8e);
  color: white;
}

.confirm-button:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(255, 107, 107, 0.2);
}

.cancel-button {
  background: #f1f2f6;
  color: #666;
}

.cancel-button:hover {
  background: #e4e5e9;
}

.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.modal-content {
  background: white;
  padding: 2rem;
  border-radius: 24px;
  width: 90%;
  max-width: 400px;
}

@media (max-width: 768px) {
  .user-center {
    padding: 1rem;
  }

  .info-item {
    flex-direction: column;
    gap: 1rem;
  }

  .item-label {
    width: auto;
  }

  .input-group {
    flex-direction: column;
  }
}
</style>