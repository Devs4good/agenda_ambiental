<template>
  <div>
    <evento v-for="(evento, indice) in eventos"
            :evento="evento"
            :key="indice">
    </evento>
  </div>
</template>

<script>
import Evento from './Evento'
import EventosRestAPI from '../models/EventosRestAPIStub'

export default {
  name: 'Eventos',
  data () {
    return { eventos: [] }
  },
  created () {
    EventosRestAPI.noDestacados().then(eventosNoDestacados => {
      this.eventos = eventosNoDestacados
    })
  },
  components: { Evento }
}
</script>

<style scoped>
  div {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-column-gap: 15px;
    grid-row-gap: 15px;
  }

  @media (max-width: 576px) {
    div {
      display: grid;
      grid-template-columns: 1fr;
    }
  }
</style>
