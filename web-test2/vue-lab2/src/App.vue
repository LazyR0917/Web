<template>
  <div id="app">
    <HeroSection @show-login="showLogin = true" @show-register="showRegister = true" />
    <FeatureSection />
    <CourseSection />
    <FooterSection />
    
    <LoginModal 
      v-if="showLogin" 
      @close="showLogin = false"
      @switch-to-register="switchToRegister"
    />
    <RegisterModal 
      v-if="showRegister" 
      @close="showRegister = false"
      @switch-to-login="switchToLogin"
    />
  </div>
</template>

<script>
import HeroSection from './components/HeroSection.vue'
import FeatureSection from './components/FeatureSection.vue'
import CourseSection from './components/CourseSection.vue'
import FooterSection from './components/FooterSection.vue'
import LoginModal from './components/LoginModal.vue'
import RegisterModal from './components/RegisterModal.vue'

export default {
  name: 'App',
  components: {
    HeroSection,
    FeatureSection,
    CourseSection,
    FooterSection,
    LoginModal,
    RegisterModal
  },
  data() {
    return {
      showLogin: false,
      showRegister: false
    }
  },
  methods: {
    switchToLogin() {
      this.showRegister = false
      this.showLogin = true
    },
    switchToRegister() {
      this.showLogin = false
      this.showRegister = true
    }
  }
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: "Microsoft YaHei", "微软雅黑", "PingFang SC", sans-serif;
  color: #333333;
  line-height: 1.6;
}

.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}
</style>