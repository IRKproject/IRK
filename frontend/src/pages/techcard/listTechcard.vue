<template>
  <div class="main">
    <header>
      <h1>Техкарты</h1>
    </header>
  
    <table class="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>ID техкарты</th>
          <th>Инструменты</th>
          <th>Действие</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="techcard in allTechcards" :key="techcard.id">
          <td>{{ techcard.id }}</td>
          <td>{{ techcard.cardId }}</td>
          <td>
            <ul>
              <li v-for="instrument in techcard.selectedInstruments" :key="instrument.id">
                <b>{{ instrument.instrumentNumber}}</b>
                <ul>
                  <li v-for="part in instrument.selectedParts" :key="part.id">
                    <span>Тип: <b>{{ part.type }}</b>, </span>
                    <span>Спецификация: <b>{{ part.specification }}</b>, </span>
                    <span>Количество: <b>{{ part.quantity }}</b>, </span>
                    <span>Наименование: <b>{{ part.reference }}</b></span>
                  </li>
                </ul>
              </li>
            </ul>
          </td>
          <td>
            <router-link type = "button" class="btn btn-primary" :to="`/techcards/edit/${techcard.id}`">Изменить</router-link>
          </td>
        </tr>
      </tbody>
    </table>
    <router-link type = "button" class="btn btn-primary" to="/techcards/add">Добавить</router-link>
  </div>
</template>

<script>
import http from "../../shared/api/http-common";
export default {
  data() {
    return {
      allTechcards: []
    };
  },
  async created(){
    try {
      const response = await http.get("/techcards");
      this.allTechcards = response.data;
      console.log(this.allTechcards);
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