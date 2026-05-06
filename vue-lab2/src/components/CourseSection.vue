<template>
  <section class="course-section">
    <div class="container">
      <h2 class="section-title">课程特色</h2>
      <div class="row course-row">
        <div class="col-12 col-lg-4" v-for="course in courses" :key="course.id">
          <div class="course-item">
            <div class="course-icon" :class="course.iconClass">
              <i :class="course.icon"></i>
            </div>
            <div class="course-content">
              <h3 class="course-item-title">{{ course.title }}</h3>
              <p class="course-item-desc">{{ course.description }}</p>
              <a href="#" class="course-link" @click.prevent="handleLearn(course.title)">
                马上学习 <i class="bi bi-chevron-right"></i>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: 'CourseSection',
  data() {
    return {
      courses: [
        {
          id: 1,
          icon: 'bi bi-book',
          iconClass: 'icon-blue',
          title: '丰富的教学服务',
          description: '特色教学服务功能，各种配套教学服务，在线学习从未如此轻松。'
        },
        {
          id: 2,
          icon: 'bi bi-lightbulb',
          iconClass: 'icon-cyan',
          title: '多元的学习方式',
          description: '知识提炼、答疑解惑、实时互动、开发有特色的教学服务方式。'
        },
        {
          id: 3,
          icon: 'bi bi-award',
          iconClass: 'icon-orange',
          title: '高品质的学习体验',
          description: '多屏合一，随时学习，随时在线，学习记录一目了然，知识充电不再受限。'
        }
      ]
    }
  },
  methods: {
    handleLearn(title) {
      window.alert(`即将开始学习！`)
    }
  }
}
</script>

<style scoped>
.course-section {
  padding: 40px 0 50px;
  background-color: #ffffff;
}

.section-title {
  font-size: 1.2rem;
  font-weight: bold;
  margin-bottom: 25px;
  color: #333;
  text-align: left;
  padding: 0 15px;
}

.course-row {
  gap: 20px 0;
}

.course-item {
  display: flex;
  align-items: flex-start;
  gap: 15px;
  text-align: left;
  padding: 0 15px;
}

.course-icon {
  width: 42px;
  height: 42px;
  border-radius: 8px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-shrink: 0;
}

.course-icon i {
  font-size: 1.2rem;
  color: white;
}

.icon-blue {
  background-color: #3b86f7;
}

.icon-cyan {
  background-color: #00c9c9;
}

.icon-orange {
  background-color: #ff9500;
}

.course-content {
  flex: 1;
}

.course-item-title {
  font-size: 1rem;
  font-weight: bold;
  margin-bottom: 5px;
  color: #333;
}

.course-item-desc {
  font-size: 0.85rem;
  color: #888;
  margin-bottom: 8px;
  line-height: 1.6;
}

.course-link {
  font-size: 0.8rem;
  color: #3b86f7;
  text-decoration: none;
  display: inline-flex;
  align-items: center;
  gap: 3px;
}

.course-link:hover {
  color: #2d6fd6;
}

.course-link i {
  font-size: 0.7rem;
}

/* 平板样式 */
@media (min-width: 768px) and (max-width: 991px) {
  .section-title {
    padding: 0 40px;
  }

  .course-item {
    padding: 0 40px;
  }
}

/* 桌面端样式 */
@media (min-width: 992px) {
  .course-section {
    padding: 60px 0 80px;
  }

  .section-title {
    font-size: 1.4rem;
    margin-bottom: 50px;
    text-align: center;
    padding: 0;
  }

  .course-item {
    flex-direction: column;
    align-items: center;
    text-align: center;
    gap: 18px;
    padding: 0 20px;
  }

  .course-icon {
    width: 50px;
    height: 50px;
  }

  .course-icon i {
    font-size: 1.4rem;
  }

  .course-item-title {
    font-size: 1.1rem;
  }

  .course-item-desc {
    font-size: 0.88rem;
  }

  .course-link {
    font-size: 0.85rem;
  }
}

@media (max-width: 375px) {
  .course-icon {
    width: 38px;
    height: 38px;
  }

  .course-icon i {
    font-size: 1rem;
  }
}
</style>