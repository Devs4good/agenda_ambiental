<template>
  <div class="carousel-item" :class="{ active: activo }">
    <router-link :to="{ name: 'Evento', params: { id: evento.id }}">
      <img class="d-block w-100" :src="evento.imagen" :alt="evento.titulo">
    </router-link>
  </div>
</template>

<script>
export default {
  name: 'CarouselSlide',
  props: ['evento', 'activo']
}
</script>
