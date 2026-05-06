<template>
  <section class="hero-section" :style="{ backgroundImage: `url(${bannerBg})` }">
    <div class="container">
      <!-- 导航栏 -->
      <nav class="nav-bar">
        <img :src="logoImg" alt="云端编程" class="logo">
        <div class="nav-buttons">
          <button class="btn text-white" @click="$emit('show-login')">登录</button>
          <button class="btn text-white" @click="$emit('show-register')">注册</button>
        </div>
      </nav>
      
      <!-- 主标题内容 -->
      <div class="hero-content">
        <h1 class="hero-title">云端编程，浏览器里边学边练</h1>
        <p class="hero-subtitle">软件定义一切，网络连接时空，学习软件技术，创造未来世界。</p>
        <button class="hero-btn" @click="handleStartLearning">马上学习</button>
      </div>
    </div>
  </section>
</template>

<script>
import logoImg from '@/assets/images/logo-white.svg'
import bannerBg from '@/assets/images/home-banner@2x.jpg'

export default {
  name: 'HeroSection',
  emits: ['show-login', 'show-register'],
  data() {
    return {
      logoImg,
      bannerBg
    }
  },
  methods: {
    handleStartLearning() {
      window.alert('欢迎开始学习！我们将为您推荐最适合的课程。')
    }
  }
}
</script>

<style scoped>
.hero-section {
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  color: white;
  padding-bottom: 60px;
  position: relative;
}

.container {
  position: relative;
  z-index: 2;
}

.nav-bar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 15px 0;
}

.logo {
  height: 24px;
  width: auto;
}

.nav-buttons {
  display: flex;
  gap: 10px;
}

.nav-buttons .btn {
  padding: 4px 18px;
  font-size: 13px;
  border-radius: 4px;
  background: transparent;
  border: 1px solid rgba(255, 255, 255, 0.8);
}

.nav-buttons .btn:hover {
  background: rgba(255, 255, 255, 0.1);
}

.hero-content {
  padding: 40px 20px 30px;
  text-align: center;
}

.hero-title {
  font-size: 1.5rem;
  font-weight: bold;
  margin-bottom: 15px;
  line-height: 1.4;
}

.hero-subtitle {
  font-size: 0.9rem;
  margin-bottom: 25px;
  opacity: 0.9;
  line-height: 1.6;
}

.hero-btn {
  padding: 10px 45px;
  font-size: 0.95rem;
  border-radius: 4px;
  color: #3b86f7;
  font-weight: 500;
  background: white;
  border: none;
  cursor: pointer;
}

.hero-btn:hover {
  color: #2d6fd6;
  background-color: #f8f9fa;
}

@media (min-width: 992px) {
  .nav-bar {
    padding: 20px 0;
  }

  .logo {
    height: 32px;
  }

  .nav-buttons .btn {
    padding: 6px 25px;
    font-size: 14px;
  }

  .hero-section {
    padding-bottom: 80px;
  }

  .hero-content {
    padding: 80px 0 60px;
  }

  .hero-title {
    font-size: 2.2rem;
    line-height: 1.3;
  }

  .hero-subtitle {
    font-size: 1rem;
    margin-bottom: 30px;
  }

  .hero-btn {
    padding: 12px 55px;
    font-size: 1rem;
  }
}

@media (min-width: 1200px) {
  .hero-title {
    font-size: 2.5rem;
  }

  .hero-subtitle {
    font-size: 1.1rem;
  }
}

@media (max-width: 375px) {
  .hero-title {
    font-size: 1.3rem;
  }

  .hero-subtitle {
    font-size: 0.85rem;
  }
}
</style>