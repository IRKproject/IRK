<template>
    <div class="main">
      <header>
        <h1>Детали</h1>
      </header>
    
      <table class="table">
                <thead>
                    <tr>
                        <th>Тип</th>
                        <th>Спецификация</th>
                        <th>Количество</th>
                        <th>Наименование</th>
                        <th>Действия</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="part in allParts" :key="part.id">
                        <td>{{ part.type }}</td>
                        <td>{{ part.specification }}</td>
                        <td>{{ part.quantity }}</td>
                        <td>{{ part.reference }}</td>
                        <td><router-link type = "button" class="btn btn-primary" :to="`/parts/edit/${part.id}`">Изменить</router-link></td>
                    </tr>
                </tbody>
            </table>
      <router-link type = "button" class="btn btn-primary" to="/parts/add">Добавить</router-link>
    </div>
  </template>
  
  <script>
  import http from "../../shared/api/http-common";
  export default {
    name: "ListPart",
    data() {
      return {
        allParts: []
      };
    },
    async created(){
      try {
        const response = await http.get("/parts");
        this.allParts = response.data;
        console.log("Parts fetched successfully", response.data);
      }
      catch (error) {
        console.error("Error fetching parts", error);
      }
    }
  }
  </script>
  <style scoped>
  .main{
      margin-left: 15%;
      margin-right: 15%;
  }
  </style>