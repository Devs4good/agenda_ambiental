<template>
  <button :class="{ outline }">{{ texto }}</button>
</template>

<script>
export default {
  name: 'BotonRedondeado',
  props: ['texto', 'outline']
}
</script>

<style scoped>
  button {
    border-radius: 52px;
    background-color: #8fa702;
    text-transform: uppercase;
    color: white;
    padding: 0.5em;
    width: 100%;
    max-width: 170px;
  }

  button.outline {
    color: #8fa702;
    border: solid 2px #8fa702;
    background-color: white;
  }
</style>
