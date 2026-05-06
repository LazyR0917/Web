<template>
  <div class="modal-overlay" @click.self="$emit('close')">
    <div class="modal-box">
      <h2 class="modal-title">注册</h2>
      
      <div class="form-group">
        <label class="form-label">
          <span class="required">*</span> 用户名
        </label>
        <div class="input-wrapper">
          <input 
            type="text" 
            v-model="username" 
            class="form-input"
            :class="{ 'input-error': errors.username }"
            @input="clearError('username')"
          >
          <span v-if="errors.username" class="clear-icon" @click="clearField('username')">×</span>
          <p v-if="errors.username" class="error-msg">用户名不能为空！</p>
        </div>
      </div>
      
      <div class="form-group">
        <label class="form-label">
          <span class="required">*</span> 密码
        </label>
        <div class="input-wrapper">
          <input 
            type="password" 
            v-model="password" 
            class="form-input"
            :class="{ 'input-error': errors.password }"
            @input="clearError('password')"
          >
          <span v-if="errors.password" class="clear-icon" @click="clearField('password')">×</span>
          <p v-if="errors.password" class="error-msg">请输入密码</p>
        </div>
      </div>
      
      <div class="form-group">
        <label class="form-label">
          <span class="required">*</span> 确认密码
        </label>
        <div class="input-wrapper">
          <input 
            type="password" 
            v-model="confirmPassword" 
            class="form-input"
            :class="{ 'input-error': errors.confirmPassword }"
            @input="clearError('confirmPassword')"
          >
          <span v-if="errors.confirmPassword" class="clear-icon" @click="clearField('confirmPassword')">×</span>
          <p v-if="errors.confirmPassword" class="error-msg">{{ confirmPasswordError }}</p>
        </div>
      </div>
      
      <div class="button-group">
        <button class="btn btn-primary" @click="handleRegister">提交</button>
        <button class="btn btn-default" @click="handleReset">重置</button>
        <button class="btn btn-default" @click="$emit('switch-to-login')">返回</button>
      </div>
    </div>
  </div>
</template>

<script>
import { registerApi } from '@/api/user'

export default {
  name: 'RegisterModal',
  emits: ['close', 'switch-to-login'],
  data() {
    return {
      username: '',
      password: '',
      confirmPassword: '',
      confirmPasswordError: '',
      errors: {
        username: false,
        password: false,
        confirmPassword: false
      }
    }
  },
  methods: {
    async handleRegister() {
      // 表单校验
      this.errors.username = !this.username
      this.errors.password = !this.password

      if (!this.confirmPassword) {
        this.errors.confirmPassword = true
        this.confirmPasswordError = '请再次输入密码'
      } else if (this.confirmPassword !== this.password) {
        this.errors.confirmPassword = true
        this.confirmPasswordError = '两次密码输入不一致'
        this.confirmPassword = ''
      } else {
        this.errors.confirmPassword = false
      }

      if (this.errors.username || this.errors.password || this.errors.confirmPassword) return

      try {
        const res = await registerApi(this.username, this.password)
        if (res.data.code === 200) {
          alert('注册成功！请登录')
          this.$emit('switch-to-login')
        } else {
          alert(res.data.message || '注册失败')
        }
      } catch (error) {
        console.error('注册请求失败：', error)
        alert('注册失败，请检查后端服务是否启动')
      }
    },
    handleReset() {
      this.username = ''
      this.password = ''
      this.confirmPassword = ''
      this.errors.username = false
      this.errors.password = false
      this.errors.confirmPassword = false
    },
    clearError(field) {
      this.errors[field] = false
    },
    clearField(field) {
      this[field] = ''
      this.errors[field] = false
    }
  }
}
</script>

<style scoped>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.modal-box {
  background: white;
  border-radius: 8px;
  padding: 40px 50px;
  width: 90%;
  max-width: 500px;
}

.modal-title {
  text-align: center;
  font-size: 1.8rem;
  font-weight: bold;
  margin-bottom: 30px;
  color: #333;
}

.form-group {
  display: flex;
  align-items: flex-start;
  margin-bottom: 20px;
}

.form-label {
  width: 90px;
  font-size: 1rem;
  color: #666;
  flex-shrink: 0;
  padding-top: 12px;
}

.required {
  color: #ff4d4f;
  margin-right: 4px;
}

.input-wrapper {
  flex: 1;
  position: relative;
}

.form-input {
  width: 100%;
  padding: 12px 35px 12px 15px;
  border: 1px solid #ddd;
  border-radius: 6px;
  font-size: 1rem;
  outline: none;
  box-sizing: border-box;
}

.form-input:focus {
  border-color: #4facfe;
}

.form-input.input-error {
  border-color: #ff4d4f;
}

.clear-icon {
  position: absolute;
  right: 12px;
  top: 12px;
  color: #ff4d4f;
  cursor: pointer;
  font-size: 1.1rem;
  line-height: 1;
}

.error-msg {
  color: #ff4d4f;
  font-size: 0.85rem;
  margin-top: 6px;
  margin-bottom: 0;
}

.button-group {
  display: flex;
  justify-content: center;
  gap: 15px;
  margin-top: 35px;
}

.btn {
  padding: 10px 35px;
  font-size: 1rem;
  border-radius: 6px;
  cursor: pointer;
}

.btn-primary {
  background: #4facfe;
  color: white;
  border: 1px solid #4facfe;
}

.btn-primary:hover {
  background: #3b9af5;
}

.btn-default {
  background: white;
  color: #333;
  border: 1px solid #ddd;
}

.btn-default:hover {
  border-color: #4facfe;
  color: #4facfe;
}

/* 移动端适配 */
@media (max-width: 480px) {
  .modal-box {
    padding: 30px 20px;
  }
  
  .form-group {
    flex-direction: column;
    align-items: flex-start;
  }
  
  .form-label {
    padding-top: 0;
    margin-bottom: 8px;
  }
  
  .input-wrapper {
    width: 100%;
  }
  
  .form-input {
    width: 100%;
  }
  
  .button-group {
    flex-wrap: wrap;
  }
  
  .btn {
    padding: 10px 25px;
    min-width: 80px;
  }
}
</style>