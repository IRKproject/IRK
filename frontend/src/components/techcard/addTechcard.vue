<template>
    <div class="main">
        <header-component></header-component>
        <h1>Добавить техкарту</h1>
        <form @submit.prevent="saveTechcard">
            <label for="instrumentName">ID техкарты:</label>
            <input class="form-control" type="text" v-model="techcard.cardId" required />
            <table class="table">
                <thead>
                    <tr>
                        <th></th>
                        <th>Номер инструмента</th>
                        <th>Части</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="instrument in allInstruments" :key="instrument.id">
                        <td>
                            <input 
                                type="checkbox" 
                                :value="instrument" 
                                v-model="techcard.selectedInstruments"
                            />
                        </td>
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
            allInstruments: [],
            techcard: {
                cardId: null,
                selectedInstruments: []
            }
        };
    },
    async created() {
        try {
            const response = await http.get('/instruments');
            this.allInstruments = response.data;
            console.log(this.allInstruments);
        }
        catch (error) {
            console.error(error);
        }
    },
    methods: {
        saveTechcard(e) {
            console.log(this.techcard);
            e.preventDefault();
            http
                .post("techcards/save",this.techcard)
                .then(response => {
                    this.techcard.id = response.data.id;
                    this.$router.push('/techcards');
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