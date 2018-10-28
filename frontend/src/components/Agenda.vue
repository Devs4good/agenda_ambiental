<template>
  <div>
    <titulo-agenda></titulo-agenda>
    <eventos></eventos>
  </div>
</template>

<script>
import TituloAgenda from './TituloAgenda'
import Eventos from './Eventos'

export default {
  name: 'Agenda',
  components: {
    TituloAgenda,
    Eventos
  }
}
</script>

<style scoped>
  div {
    margin-top: 1.5em;
    margin-bottom: 1.5em;
  }
</style>
