<template>
  <div id="carouselPrincipal" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li v-for="(_, indice) in slides"
          data-target="#carouselPrincipal"
          :data-slide-on="indice"
          :class="{ active: indice === 0 }"
          :key="indice">
      </li>
    </ol>
    <div class="carousel-inner">
      <carousel-slide v-for="(slide, indice) in slides"
                      :titulo="slide.titulo"
                      :imagen="slide.imagen"
                      :activo="indice === 0"
                      :key="indice">
      </carousel-slide>
    </div>
    <a class="carousel-control-prev" href="#carouselPrincipal" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselPrincipal" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</template>

<script>
import CarouselSlide from './CarouselSlide'

export default {
  name: 'Carousel',
  data () {
    return {
      slides: [
        { titulo: 'Primer slide', imagen: 'https://tinyurl.com/ybbn5ahe' },
        { titulo: 'Segundo slide', imagen: 'https://tinyurl.com/yd7ouvuk' },
        { titulo: 'Tercer slide', imagen: 'https://tinyurl.com/yd6sp2tk' }
      ]
    }
  },
  components: {
    CarouselSlide
  }
}
</script>

<style scoped>
  .carousel-inner {
    max-width: 1144px;
    max-height: 570px;
  }
</style>
