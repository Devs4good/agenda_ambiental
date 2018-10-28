<template>
  <div>
    <carousel></carousel>
    <agenda></agenda>
    <categorias></categorias>
  </div>
</template>

<script>
import Carousel from './Carousel'
import Agenda from './Agenda'
import Categorias from './Categorias'

export default {
  components: { Carousel, Agenda, Categorias }
}
</script>
