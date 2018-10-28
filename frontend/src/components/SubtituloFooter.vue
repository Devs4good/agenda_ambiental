<template>
  <div>{{ titulo }}</div>
</template>

<script>
export default {
  name: 'SubtituloFooter',
  props: ['titulo']
}
</script>

<style scoped>
  div {
    padding-left: 0;
    font-weight: bold;
    color: #cf7d33;
    border-bottom: 2px solid #5ed3cd;
    padding-bottom: 0.5rem;
    margin-bottom: 1rem;
  }
</style>
