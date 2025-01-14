<template>
  <div class="main">
    <header>
      <h1>Интрументы</h1>
    </header>
  
    <table class="table">
      <thead>
        <tr>
          <th>Номер инструмента</th>
          <th>Части</th>
          <th>Действия</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="instrument in allInstruments" :key="instrument.id">
          <td>{{ instrument.instrumentNumber }}</td>
          <td>
            <ul>
              <li v-for="part in instrument.selectedParts" :key="part.reference">
                <span>Тип: <b>{{ part.type }}</b>, </span>
                <span>Спецификация: <b>{{ part.specification }}</b>, </span>
                <span>Количество: <b>{{ part.quantity }}</b>, </span>
                <span>Наименование: <b>{{ part.reference }}</b></span>
              </li>
            </ul>
          </td>
          <td>
            <router-link type = "button" class="btn btn-primary" :to="`/instruments/edit/${instrument.id}`">Изменить</router-link>
          </td>
        </tr>
      </tbody>
    </table>
    <router-link type = "button" class="btn btn-primary" to="/instruments/add">Добавить</router-link>
  </div>
</template>

<script>
import http from "../../http-common";
export default {
  name: "ListInstrument",
  data() {
    return {
      allInstruments: []
    };
  },
  async created(){
    try {
      const response = await http.get("/instruments");
      this.allInstruments = response.data;
    }
    catch (error) {
      console.error("Error fetching instruments", error);
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