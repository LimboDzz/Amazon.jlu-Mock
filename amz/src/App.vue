<template>
  <div id="app">
    <router-view/>
    <router-link to="/index">Index</router-link>
    <router-link to="/Admin">Admin</router-link>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
</style>
