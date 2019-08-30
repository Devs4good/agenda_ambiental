<template>
  <div id="carouselPrincipal" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li v-for="(_, indice) in eventos"
          data-target="#carouselPrincipal"
          :data-slide-on="indice"
          :class="{ active: indice === 0 }"
          :key="indice">
      </li>
    </ol>
    <div class="carousel-inner">
      <carousel-slide v-for="(evento, indice) in eventos"
                      :evento="evento"
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
import EventosRestAPI from '../services/EventosRestAPIStub'

export default {
  name: 'Carousel',
  data () {
    return { eventos: [] }
  },
  created () {
    EventosRestAPI.destacados().then(eventosDestacados => {
      this.eventos = eventosDestacados
    })
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
