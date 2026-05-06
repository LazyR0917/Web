<template>
  <div>
    <!-- 云端编程实验室 - 白色背景 -->
    <section class="feature-section feature-section-white">
      <div class="container">
        <div class="row feature-row align-items-center">
          <div class="col-12 col-lg-6 feature-image-col">
            <div class="feature-image-wrapper">
              <img :src="labImg" alt="云端编程实验室" class="feature-image">
            </div>
          </div>
          <div class="col-12 col-lg-6 feature-text-col">
            <div class="feature-text-wrapper">
              <h2 class="feature-title">云端编程实验室</h2>
              <p class="feature-description">每人拥有自己完全独立的编程实验室，内置所有基础软件及学习素材。打开浏览器，即刻开始编程！</p>
              <button class="btn btn-primary btn-detail" @click="handleDetail('云端编程实验室')">了解详情</button>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- 双屏学习 - 灰色背景 -->
    <section class="feature-section feature-section-gray">
      <div class="container">
        <div class="row feature-row align-items-center">
          <div class="col-12 col-lg-6 feature-image-col">
            <div class="feature-image-wrapper">
              <img :src="screensImg" alt="双屏学习" class="feature-image">
            </div>
          </div>
          <div class="col-12 col-lg-6 feature-text-col">
            <div class="feature-text-wrapper">
              <h2 class="feature-title">双屏学习</h2>
              <p class="feature-description">双屏学习，小屏视频互动，大屏实际操作，学习无障碍。打开浏览器，即刻开始编程！</p>
              <button class="btn btn-primary btn-detail" @click="handleDetail('双屏学习')">了解详情</button>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import labImg from '@/assets/images/img-lab@2x.png'
import screensImg from '@/assets/images/img-screens@2x.png'

export default {
  name: 'FeatureSection',
  data() {
    return {
      labImg,
      screensImg
    }
  },
  methods: {
    handleDetail(feature) {
      window.alert(`您正在了解「${feature}」功能，更多详情请联系我们！`)
    }
  }
}
</script>

<style scoped>
.feature-section {
  padding: 40px 0;
}

.feature-section-white {
  background-color: #ffffff;
}

.feature-section-gray {
  background-color: #f5f7fa;
}

.feature-row {
  gap: 20px 0;
}

.feature-image-wrapper {
  text-align: center;
  margin-bottom: 25px;
  padding: 0 20px;
}

.feature-image {
  max-width: 100%;
  height: auto;
  max-height: 200px;
}

.feature-text-wrapper {
  text-align: left;
  padding: 0 15px;
}

.feature-title {
  font-size: 1.25rem;
  font-weight: bold;
  margin-bottom: 12px;
  color: #333;
}

.feature-description {
  font-size: 0.9rem;
  color: #666;
  margin-bottom: 20px;
  line-height: 1.7;
}

.btn-detail {
  padding: 10px 0;
  border-radius: 4px;
  font-size: 0.9rem;
  width: 100%;
  display: block;
  text-align: center;
  background-color: white;
  color: #3b86f7;
  border: 1px solid #3b86f7;
}

.btn-detail:hover {
  background-color: #f8f9fa;
  color: #2d6fd6;
}

/* 移动端样式 - 图片在上，文字在下 */
@media (max-width: 991px) {
  .feature-image-col {
    order: 1 !important;
  }

  .feature-text-col {
    order: 2 !important;
  }
}

/* 平板样式 */
@media (min-width: 768px) and (max-width: 991px) {
  .feature-image {
    max-height: 250px;
  }

  .feature-text-wrapper {
    padding: 0 40px;
  }

  .btn-detail {
    width: auto;
    padding: 10px 40px;
    display: inline-block;
  }
}

/* 桌面端样式 */
@media (min-width: 992px) {
  .feature-section {
    padding: 80px 0;
  }

  .feature-image-wrapper {
    margin-bottom: 0;
    padding: 0;
  }

  .feature-image {
    max-height: 320px;
  }

  .feature-text-wrapper {
    text-align: left;
    padding: 20px 0;
  }

  .feature-title {
    font-size: 1.6rem;
    margin-bottom: 18px;
  }

  .feature-description {
    font-size: 0.95rem;
    margin-bottom: 25px;
    max-width: 450px;
  }

  .btn-detail {
    width: auto;
    padding: 8px 35px;
    display: inline-block;
  }
}

@media (min-width: 1200px) {
  .feature-image {
    max-height: 350px;
  }

  .feature-title {
    font-size: 1.8rem;
  }

  .feature-description {
    font-size: 1rem;
  }
}

@media (max-width: 375px) {
  .feature-image {
    max-height: 160px;
  }

  .feature-title {
    font-size: 1.1rem;
  }
}
</style>