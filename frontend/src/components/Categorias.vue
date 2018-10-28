<template>
  <div id="contenedor">
    <titulo texto="Categorías"></titulo>
    <div id="categorias" class="contendedor-cuadros">
      <div class="categoria">
        <img src="../assets/charlas.jpg">
        <div class="titulo-sobre-imagen">Charlas</div>
      </div>
      <div class="categoria">
        <img src="../assets/cursos.jpg">
        <div class="titulo-sobre-imagen">Cursos</div>
      </div>
      <div class="categoria">
        <img src="../assets/ferias.jpg">
        <div class="titulo-sobre-imagen">Ferias</div>
      </div>
      <div class="categoria">
        <img src="../assets/jornadas.jpg">
        <div class="titulo-sobre-imagen">Jornadas</div>
      </div>
      <div class="categoria">
        <img src="../assets/talleres.jpg">
        <div class="titulo-sobre-imagen">Talleres</div>
      </div>
      <div class="categoria">
        <img src="../assets/voluntariados.jpg">
        <div class="titulo-sobre-imagen">Voluntariados</div>
      </div>
    </div>
  </div>
</template>

<script>
import Titulo from './Titulo'

export default {
  name: 'Categorias',
  components: { Titulo }
}
</script>

<style scoped>
  #contenedor {
    margin-bottom: 1.5rem;
  }

  #categorias {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-column-gap: 1rem;
    grid-row-gap: .5rem;
  }

  @media (max-width: 768px) {
    #categorias {
      grid-template-columns: 50% 50%;
      grid-gap: 0;
    }
  }

  .titulo-sobre-imagen {
    color: white;
    width: 100%;
    position: absolute;
    bottom: 0;
    text-align: center;
    font-size: 1.8rem;
    font-weight: bold;
    background-image: linear-gradient(rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.8) 50%);
  }

  .categoria {
    position: relative;
    height: 100%;
  }

  img {
    width: 100%;
    height: 100%;
  }

  @media (max-width: 768px) {
    .contendedor-cuadros>div {
      height: 50vw;
    }

    .titulo-sobre-imagen {
      font-size: 1.5rem;
    }
  }
</style>
