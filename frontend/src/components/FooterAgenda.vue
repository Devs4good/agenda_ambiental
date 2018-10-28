<template>
  <div class="grid">
    <img class="logo-footer" src="../assets/logo.png"/>
    <lista-tipos-footer></lista-tipos-footer>
    <form-contacto-footer></form-contacto-footer>
  </div>
</template>

<script>
import ListaTiposFooter from './ListaTiposFooter'
import FormContactoFooter from './FormContactoFooter'

export default {
  name: 'FooterAgenda',
  components: {
    FormContactoFooter,
    ListaTiposFooter
  }
}
</script>

<style scoped>
  .grid {
    display: grid;
    grid-template-columns: 30% 1fr 30%;
    grid-column-gap: 1.5rem;
    border-top: 2px solid #5ed3cd;
    padding-top: 2em;
  }

  @media (max-width: 576px) {
    .grid {
      grid-template-columns: 100%;
    }
  }

  .footer li {
    padding-bottom: 0.5rem;
  }

  .logo-footer {
    max-width: 18vw;
  }
</style>
