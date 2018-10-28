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

export default {
  name: 'Eventos',
  data () {
    return {
      eventos: [
        {
          id: 1,
          titulo: 'Experiencia despierta',
          fechaYHoraDeInicio: new Date(),
          tipo: 'charla',
          imagen: 'https://tinyurl.com/yd6sp2tk'
        },
        {
          id: 2,
          titulo: 'Paisaje natural',
          fechaYHoraDeInicio: new Date(),
          tipo: 'taller',
          imagen: 'https://tinyurl.com/yd7ouvuk'
        },
        {
          id: 3,
          titulo: 'Parque de la estación',
          fechaYHoraDeInicio: new Date(),
          tipo: 'charla',
          imagen: 'https://tinyurl.com/ybbn5ahe'
        },
        {
          id: 4,
          titulo: 'Jornada de Práctica en Instalación Fotovoltica',
          fechaYHoraDeInicio: new Date(),
          tipo: 'jornada',
          imagen: 'https://tinyurl.com/yd4dekyq'
        },
        {
          id: 5,
          titulo: 'Somos semilla',
          fechaYHoraDeInicio: new Date(),
          tipo: 'festival',
          imagen: 'https://tinyurl.com/yanyyzfn'
        },
        {
          id: 6,
          titulo: 'Limpieza de playas del centro en MDQ',
          fechaYHoraDeInicio: new Date(),
          tipo: 'voluntariado',
          imagen: 'https://tinyurl.com/ycfhb57o'
        }
      ]
    }
  },
  components: {
    Evento
  }
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
