<template>
  <div id="container">
    <subtitulo-footer titulo="Contacto"></subtitulo-footer>
    <div id="form-contacto">
      <input type="text" placeholder="Nombre">
      <input type="text" placeholder="Apellido">
      <input type="text" id="email" placeholder="Email">
      <textarea placeholder="Mensaje" rows="2"></textarea>
    </div>
    <boton-redondeado id="boton" texto="Enviar"></boton-redondeado>
  </div>
</template>

<script>
import SubtituloFooter from './SubtituloFooter'
import BotonRedondeado from './BotonRedondeado'

export default {
  name: 'FormContactoFooter',
  components: { BotonRedondeado, SubtituloFooter }
}
</script>

<style scoped>
  #container {
    display: flex;
    flex-direction: column;
  }

  #form-contacto {
    display: grid;
    grid-template-columns: 47% 47%;
    grid-gap: 1rem 6%;
    padding-bottom: 1rem;
  }

  #email, textarea {
    grid-column: 1 / span 2;
  }

  #boton {
    align-self: flex-end;
  }
</style>
