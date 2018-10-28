<template>
  <div class="carousel-item" :class="{ active: activo }">
    <img class="d-block w-100" :src="imagen" :alt="titulo">
  </div>
</template>

<script>
export default {
  name: 'CarouselSlide',
  props: ['titulo', 'imagen', 'activo']
}
</script>
