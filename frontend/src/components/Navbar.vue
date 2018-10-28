<template>
  <nav class="navbar sticky-top navbar-expand-lg navbar-light bg-light">
    <router-link  to="/" class="navbar-brand">
      <img class="logo" src="../assets/logo.png">
    </router-link>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="#">Agenda <span class="sr-only">(current)</span></a>
        </li>

        <li class="nav-item active">
          <a class="nav-link" href="#">Eventos destacados <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="about.html">Quienes somos <span class="sr-only">(current)</span></a>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'Navbar'
}
</script>

<style scoped>
  .navbar{
    box-shadow: 0 3px 20px 0 rgba(0,0,0,.25);
  }
  #navbarSupportedContent li:hover{
    border-bottom: 2px solid #8fa702;
  }
  .logo {
    max-height: 95px;
    max-width: 200px;
  }
</style>
