<template>
  <div id="app">
    <navbar></navbar>
    <div id="contenedor">
      <router-view/>
      <footer-agenda></footer-agenda>
    </div>
  </div>
</template>

<script>
import Navbar from './components/Navbar'
import FooterAgenda from './components/FooterAgenda'

export default {
  name: 'App',
  components: { FooterAgenda, Navbar }
}
</script>

<style scoped>
  @media(min-width: 576px){
    #contenedor {
      max-width: 540px;
    }
  }

  @media(min-width: 768px){
    #contenedor {
      max-width: 720px;
    }
  }

  @media(min-width: 992px){
    #contenedor {
      max-width: 960px;
    }
  }

  @media(min-width: 1200px) {
    #contenedor {
      max-width: 1140px;
    }
  }

  #contenedor {
    width: 100%;
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
  }
</style>
