<template>
    <div class="main">
        <header-component></header-component>
        <h1>Добавить инструмент</h1>
        <form @submit.prevent="saveInstrument">
            <label for="instrumentName">Номер инструмента:</label>
            <input class="form-control" type="text" v-model="instrument.instrumentNumber" required />
            <table class="table">
                <thead>
                    <tr>
                        <th></th>
                        <th>Тип</th>
                        <th>Спецификация</th>
                        <th>Количество</th>
                        <th>Наименование</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="part in allParts" :key="part.id">
                        <td><input type="checkbox" :value="part" v-model="instrument.selectedParts"/></td>
                        <td>{{ part.type }}</td>
                        <td>{{ part.specification }}</td>
                        <td>{{ part.quantity }}</td>
                        <td>{{ part.reference }}</td>
                    </tr>
                </tbody>
            </table>
            <button class="btn btn-primary" type="submit">Добавить</button>
        </form>
    </div>
</template>

<script>
import http from '../../http-common.js';

export default {
    data() {
        return {
            allParts: [],
            instrument: {
                instrumentNumber: null,
                selectedParts: []
            }
        };
    },
    async created() {
        try {
            const response = await http.get('/parts');
            this.allParts = response.data;
            console.log(this.allParts);
        }
        catch (error) {
            console.error(error);
        }
    },
    methods: {
        saveInstrument(e) {
            e.preventDefault();
            http
                .post("instruments/save",this.instrument)
                .then(response => {
                    this.instrument.id = response.data.id;
                    this.$router.push('/instruments');
                })
                .catch(e => {
                    console.log(e);
                });
        },
    },
};
</script>

<style scoped>
.main{
    margin-left: 15%;
    margin-right: 15%;
}
.btn{min-width: 100px;}
</style>