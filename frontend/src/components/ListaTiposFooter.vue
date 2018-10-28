<template>
  <div id="contenedor">
    <subtitulo-footer titulo="Agenda"></subtitulo-footer>
    <div class="grid">
      <div>
        <ul>
          <li>Ferias</li>
          <li>Charlas</li>
          <li>Talleres</li>
        </ul>
      </div>
      <div>
        <ul>
          <li>Jornadas</li>
          <li>Voluntariados</li>
          <li>Cursos</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import SubtituloFooter from './SubtituloFooter'

export default {
  name: 'ListaTiposFooter',
  components: { SubtituloFooter }
}
</script>

<style scoped>
  ul {
    padding-left: 0;
    list-style: none;
  }

  .grid {
    display: grid;
    grid-template-columns: 1fr 1fr;
  }

  #contenedor {
    justify-self: stretch;
  }
</style>
