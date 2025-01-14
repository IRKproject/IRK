<template>
    <div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <h1>ИРК</h1>

            <h5><router-link class="nav-link" to="/instruments">Инструменты</router-link></h5>
            <h5><router-link class="nav-link" to="/parts">Части</router-link></h5>
            <h5><router-link class="nav-link" to="/techcards">Техкарты</router-link></h5>

        </nav>
        
    </div>
</template>

<script>

export default {
        name: "NavBar",
        data() {
            return {

            };
        }
    };
</script>
<style>

h1{margin-left: 3%;}
h5{margin-left: 3%;}
</style>