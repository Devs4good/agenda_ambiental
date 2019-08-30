<template>
  <div class="evento">
    <img class="event-image" :src="evento.urlImage" :alt="evento.title" @click="irAlEvento(evento)">
    <span class="badge badge-tipo-evento dark">{{ evento.type }}</span>
    <div>
      <p class="nombre-evento" @click="irAlEvento(evento.id)">{{ evento.title }}</p>
      <p>{{ formatearFecha(evento.startDate) }}</p>
    </div>
  </div>
</template>

<script>
import moment from 'moment'

export default {
  name: 'Evento',
  props: ['evento'],
  methods: {
    irAlEvento (unEvento) {
      this.evento = unEvento
      this.$router.push({name: 'Evento', params: { id: unEvento.id }})
    },

    formatearFecha (epochTimestamp) {
      return moment(epochTimestamp).format('dddd DD [de] MMMM')
    }
  }
}
</script>

<style scoped>
  .evento {
    display: flex;
    flex-direction: column;
  }

  .event-image {
    width: 100%;
    height: 262px;
  }

  .badge-tipo-evento {
    background-color: #cf7d33;
    color: white;
    padding: 0.8em;
    margin-right: 3em;
    text-transform: uppercase;
  }

  .badge-tipo-evento.dark {
    background-color: #212121;
    position: relative;
    bottom: 1rem;
    margin-right: 0;
    max-width: 50%;
  }

  @media (min-width: 576px) and (max-width: 768px) {
    .badge-tipo-evento.dark {
      max-width: 80%;
    }
  }

  .nombre-evento {
    font-style: normal;
    font-stretch: normal;
    line-height: normal;
    letter-spacing: normal;
    font-weight: bold;
    cursor: pointer;
  }

  img {
    cursor: pointer;
  }
</style>
