<template>
    <div class="main">
        <header-component></header-component>
        <h1>Редактировать техкарту</h1>
        <form @submit.prevent="editTechcard">
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
                            <input type="checkbox" :value="instrument" v-model="techcard.selectedInstruments"/>
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
            <button class="btn btn-primary" type="submit">Сохранить изменения</button>
        </form>
        <button class="btn btn-danger" type="button" @click="deleteTechcard">Удалить техкарту</button>
    </div>
</template>

<script>
import http from '../../http-common.js';

export default {
    data() {
        return {
            allInstruments: [],
            techcard: {
                id: null,
                cardId: null,
                instruments: [],
                selectedInstruments: []
            }
        };
    },
    async created() {
        await this.getAllInstruments();
        await this.getTechCard();
    },
    methods: {
        async getTechCard(){
            const techcardId = this.$route.params.id;
            if (techcardId) {
                try {
                    const response = await http.get(`/techcards/get/${techcardId}`);
                    this.techcard = response.data;
                } catch (error) {
                    console.error('Error loading techcard data:', error);
                }
            }
        },
        async getAllInstruments(){
            try {
                const response = await http.get('/instruments');
                this.allInstruments = response.data;
            }
            catch (error) {
                console.error(error);
            }
        },
        async editTechcard(e) {
            e.preventDefault();
            console.log(this.techcard);
            try {
                await http.post(
                    `/techcards/edit/${this.techcard.id}`,
                    this.techcard
                );
                this.$router.push('/techcards');
            } catch (error) {
                console.error('Error updating techcard:', error);
            }
        },
        async deleteTechcard() {
            console.log(this.techcard.id)
            if (confirm('Вы уверены, что хотите удалить эту техкарту?')) {
                try {
                    await http.delete(`/techcards/delete/${this.techcard.id}`);
                    this.$router.push('/techcards'); // Перенаправляем на страницу со списком инструментов
                } catch (error) {
                    console.error('Ошибка при удалении инструмента:', error);
                }
            }
        }
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