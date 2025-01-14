<template>
    <div class="main">
        <header-component></header-component>
        <h1>Редактировать инструмент</h1>
        <form @submit.prevent="editInstrument">
            <label >Номер инструмента:</label>
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
            <button class="btn btn-primary" type="submit">Сохранить исменения</button>
            
        </form>
        <button class="btn btn-danger" type="button" @click="deleteInstrument">Удалить инструмент</button>
    </div>
</template>

<script>
import http from '../../http-common.js';

export default {
    data() {
        return {
            allParts: [],
            instrument: {
                id: null, 
                instrumentNumber: '', 
                selectedParts: []
            }
        };
    },
    async created() {
        await this.loadInstrumentData();
        await this.loadAllParts();
    },
    methods: {
        async loadInstrumentData() {
            const instrumentId = this.$route.params.id;
            if (instrumentId) {
                try {
                    const response = await http.get(`/instruments/get/${instrumentId}`);
                    this.instrument = response.data;
                } catch (error) {
                    console.error('Error loading instrument data:', error);
                }
            }
        },
        
        async loadAllParts() {
            try {
                const response = await http.get('/parts');
                this.allParts = response.data;
            } catch (error) {
                console.error('Error loading parts:', error);
            }
        },
        async editInstrument(e) {
            e.preventDefault();
            try {
                await http.post(
                    `/instruments/edit/${this.instrument.id}`,
                    this.instrument
                );
                this.$router.push('/instruments');
            } catch (error) {
                console.error('Error updating instrument:', error);
            }
        },
        async deleteInstrument() {
            console.log(this.instrument.id)
            if (confirm('Вы уверены, что хотите удалить этот инструмент?')) {
                try {
                    await http.delete(`/instruments/delete/${this.instrument.id}`);
                    this.$router.push('/instruments'); // Перенаправляем на страницу со списком инструментов
                } catch (error) {
                    console.error('Ошибка при удалении инструмента:', error);
                }
            }
        }
    }
};
</script>
<style>
.main{
    margin-left: 15%;
    margin-right: 15%;
}
.btn{
    min-width: 100px;
}
</style>