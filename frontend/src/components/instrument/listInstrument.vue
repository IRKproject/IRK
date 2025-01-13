<template>
  <div>
    <header>
      <h1>All Instrument Details</h1>
    </header>
  
    <table class="table">
      <thead>
        <tr>
          <th>Instrument Number</th>
          <th>Parts</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="instrument in allInstruments" :key="instrument.id">
          <td>{{ instrument.instrumentNumber }}</td>
          <td>
            <ul>
              <li v-for="part in instrument.selectedParts" :key="part.reference">
                <span>Type: <b>{{ part.type }}</b>, </span>
                <span>Specification: <b>{{ part.specification }}</b>, </span>
                <span>Quantity: <b>{{ part.quantity }}</b>, </span>
                <span>Reference: <b>{{ part.reference }}</b></span>
              </li>
            </ul>
          </td>
          <td>
            <router-link :to="`/instruments/edit/${instrument.id}`">Edit</router-link>
          </td>
        </tr>
      </tbody>
    </table>
    <router-link to="/instruments/add">Add</router-link>
  </div>
</template>

<script>
import http from "../../http-common";
export default {
  name: "ListInstrument", // Имя шаблона
  data() { // данные компонента (определение переменных)
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