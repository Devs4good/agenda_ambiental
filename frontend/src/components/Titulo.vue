<template>
  <div>
    <span>{{ texto }}</span>
<!--    <boton-redondeado v-if="textoBoton" :texto="textoBoton" outline="true"></boton-redondeado>-->
  </div>
</template>

<script>
import BotonRedondeado from './BotonRedondeado'

export default {
  name: 'Titulo',
  props: ['texto', 'textoBoton'],
  components: {BotonRedondeado}
}
</script>

<style scoped>
  div {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: 1.5em;
    margin-bottom: 1.5em;
  }

  div span {
    font-size: 4.5vw;
    font-weight: bold;
    font-style: normal;
    font-stretch: normal;
    line-height: normal;
    letter-spacing: normal;
    color: #212121;
  }

  @media (max-width: 768px) {
    div span {
      font-size: 6vh;
    }
  }
</style>
