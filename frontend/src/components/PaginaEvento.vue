<template>
  <div>
    <div class="link-volver" @click="volver()">
      &lt;&lt; <span>Volver a la agenda</span>
    </div>
    <div id="evento">
      <img :alt="evento.title" :src="evento.urlImage">
      <div class="detalles">
        <div>
          <span v-if="evento.type" class="badge">{{ evento.type }}</span>
          <i class="fas fa-dollar-sign icono-verde"></i> {{ evento.price ? evento.price : 'Evento gratuito' }}
        </div>

        <h1>{{ evento.title }}</h1>
        <p id="descripcion">{{ evento.description }}</p>

        <ul class="fa-ul atributos-evento">
          <li><span class="fa-li"><i class="fas fa-map-marker-alt icono-verde"></i></span>{{ evento.address }}</li>
          <li><span class="fa-li"><i class="far fa-calendar icono-verde"></i></span>{{ formatearFecha(evento.startDate) }}</li>
          <li><span class="fa-li"><i class="far fa-clock icono-verde"></i></span>{{ formatearHorario(evento.startDate) }}</li>
          <li><span class="fa-li"><i class="far fa-envelope icono-verde"></i></span>{{ evento.contact }}</li>
        </ul>
      </div>
    </div>

    <div class="row">
      <div class="col-md-2 col-sm-3 col-sm-2 offset-md-6 ">
        <div class="align-middle">
          <a class="link-informacion" :href="evento.link" target="_blank">Más información</a>
        </div>
      </div>
      <div class="col-md-2 col-sm-3 offset-sm-3 offset-md-2">
<!--        <boton-redondeado texto="Inscribirme"></boton-redondeado>-->
      </div>
    </div>
  </div>
</template>

<script>
import BotonRedondeado from './BotonRedondeado'
import EventosRestAPI from '../services/EventosRestAPIStub'
import moment from 'moment'

export default {
  name: 'PaginaEvento',
  components: { BotonRedondeado },
  methods: {
    volver () {
      this.$router.go(-1)
    },

    formatearFecha (epochTimestamp) {
      return moment(epochTimestamp).format('dddd DD [de] MMMM')
    },

    formatearHorario (epochTimestamp) {
      return moment(epochTimestamp).format('HH:mm')
    }
  },
  data () {
    return { evento: null }
  },
  created () {
    EventosRestAPI.porId(this.$route.params.id).then(evento => {
      this.evento = evento
    })
  }
}
</script>

<style scoped>
  #evento {
    display: flex;
  }

  #evento img {
    flex: 1;
    width: 100%;
  }

  @media(max-width: 768px) {
    #evento img {
      max-height: 262px;
      padding-bottom: 1rem;
    }

    #evento {
      flex-direction: column;
    }
  }

  #evento .detalles {
    flex: 1;
    padding-left: 1em;
  }

  .badge {
    background-color: #cf7d33;
    color: white;
    padding: 0.8em;
    margin-right: 3em;
    text-transform: uppercase;
    display: inline-block;
    font-size: 75%;
    font-weight: 700;
    line-height: 1;
    text-align: center;
    white-space: nowrap;
    vertical-align: baseline;
    border-radius: .25rem;
  }

  #descripcion {
    padding-bottom: 0.5rem;
  }

  .atributos-evento {
    margin-top: 7vh;
  }

  .atributos-evento li {
    margin-bottom: 3vh;
  }

  .icono-verde {
    color: #8fa702;
  }

  .link-informacion {
    color: #cf7d33;
    text-decoration: underline;
  }

  .link-volver {
    margin-top: 15px;
    margin-bottom: 15px;
    cursor: pointer;
  }

  .link-volver span {
    text-decoration: underline;
  }
</style>
