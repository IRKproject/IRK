<template>
    <div class="main">
        <header-component></header-component>
        <h1>Редактировать деталь</h1>
        <form @submit.prevent="editPart">
            <label for="instrumentName">Тип детали:</label><br>
            <input class="form-check-input" type="radio" value='Body' v-model="part.type" checked>
            <label class="form-check-label" >
                Корпус
            </label><br>
            
            <input class="form-check-input" type="radio" value="Plate" v-model="part.type" >
            <label class="form-check-label" >
                Пластина
            </label><br>

            <input class="form-check-input" type="radio" value="Cang" v-model="part.type" >
            <label class="form-check-label" >
                Цанга
            </label><br>

            <input class="form-check-input" type="radio" value="Cang_inner" v-model="part.type" >
            <label class="form-check-label" >
                Цанг. патрон
            </label><br>

            <input class="form-check-input" type="radio" value="Holder" v-model="part.type">
            <label class="form-check-label" >
                Б. держатель
            </label><br>

            <label for="instrumentName">Спецификация:</label><br>
            <input class="form-control" type="text" v-model="part.specification" required />

            <label for="instrumentName">Количество:</label><br>
            <input class="form-control" type="text" v-model="part.quantity" required />

            <label for="instrumentName">Наименование:</label><br>
            <input class="form-control" type="text" v-model="part.reference" required />
            
            <button class="btn btn-primary" type="submit">Сохранить изменения</button>
        </form>
        <button class="btn btn-danger" type="button" @click="deletePart">Удалить деталь</button>
    </div>
</template>

<script>
import http from '../../shared/api/http-common.js';

export default {
    data() {
        return {
            part: {
                id: null,
                type: "Body",
                specification: null,
                quantity: null,
                reference: null
            }
        };
    },
    async created() {
        await this.getPartData();
    },
    methods: {
        async getPartData(){
            const partId = this.$route.params.id;
            if (partId) {
                try {
                    const response = await http.get(`/parts/get/${partId}`);
                    this.part = response.data;
                } catch (error) {
                    console.error('Error loading part data:', error);
                }
            }
        },
        editPart(e) {
            e.preventDefault();
            http
                .post("parts/save",this.part)
                .then(response => {
                    this.part.id = response.data.id;
                    this.$router.push('/parts');
                })
                .catch(e => {
                    console.log(e);
                });
        },
        async deletePart() {
            if (confirm('Вы уверены, что хотите удалить этот инструмент?')) {
                try {
                    await http.delete(`/parts/delete/${this.part.id}`);
                    this.$router.push('/parts'); // Перенаправляем на страницу со списком инструментов
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
.btn{min-width: 400px;}
</style>