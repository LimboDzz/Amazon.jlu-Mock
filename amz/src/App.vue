<template>
  <div id="app">
    <Nav></Nav>
    <!-- <Carousel></Carousel> -->
    <router-view/>
  </div>
</template>

<script>
import Nav from './components/Nav'
import Carousel from './components/Carousel'
export default {
  name: 'App',
  components: {
    Nav,
    Carousel
  }
}
</script>

<style>
</style>
