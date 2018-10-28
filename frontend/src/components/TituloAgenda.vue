<template>
  <div id="titulo-agenda">
    <span>Agenda</span>
    <boton-redondeado texto="Agregar evento" outline="true"></boton-redondeado>
  </div>
</template>

<script>
import BotonRedondeado from './BotonRedondeado'

export default {
  name: 'TituloAgenda',
  components: {BotonRedondeado}
}
</script>

<style>
  #titulo-agenda {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  #titulo-agenda span {
    font-size: 4.5vw;
    font-weight: bold;
    font-style: normal;
    font-stretch: normal;
    line-height: normal;
    letter-spacing: normal;
    color: #212121;
  }
</style>
