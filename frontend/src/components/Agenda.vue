<template>
  <div id="contenedor">
    <titulo texto="Agenda" texto-boton="Agregar evento"></titulo>
    <eventos></eventos>
  </div>
</template>

<script>
import Titulo from './Titulo'
import Eventos from './Eventos'

export default {
  name: 'Agenda',
  components: { Titulo, Eventos }
}
</script>

<style scoped>
  #contenedor {
    margin-top: 1.5em;
    margin-bottom: 1.5em;
  }
</style>
