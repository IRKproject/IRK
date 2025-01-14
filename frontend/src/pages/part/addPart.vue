<template>
    <div class="main">
        <header-component></header-component>
        <h1>Добавить деталь</h1>
        <form @submit.prevent="savePart">
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
            
            <button class="btn btn-primary" type="submit">Добавить</button>
        </form>
    </div>
</template>

<script>
import http from '../../shared/api/http-common.js';

export default {
    data() {
        return {
            part: {
                type: "Body",
                specification: null,
                quantity: null,
                reference: null
            }
        };
    },
    methods: {
        savePart(e) {
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