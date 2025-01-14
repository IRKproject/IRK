<template>
  <div id="app">
    <navbar/>
    <router-view />
  </div>
</template>

<script>
import Navbar from './shared/ui/navbar'

export default {
    name: 'App',
    components: {
        Navbar: Navbar
    }
}
</script>
