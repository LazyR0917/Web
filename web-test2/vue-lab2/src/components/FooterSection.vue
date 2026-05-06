<template>
  <footer class="footer-section">
    <div class="container">
      <p class="footer-text">©2024 云端科技 Artech All rights reserved</p>
    </div>
  </footer>
</template>

<script>
export default {
  name: 'FooterSection'
}
</script>

<style scoped>
.footer-section {
  background-color: #f5f7fa;
  padding: 20px 0;
  text-align: center;
  border-top: 1px solid #eee;
}

.footer-text {
  margin: 0;
  font-size: 0.8rem;
  color: #999;
}

@media (min-width: 992px) {
  .footer-section {
    padding: 30px 0;
  }

  .footer-text {
    font-size: 0.85rem;
  }
}
</style>