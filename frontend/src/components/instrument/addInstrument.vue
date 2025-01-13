<template>
    <div>
        <header-component></header-component>
        <h1>Add Instrument</h1>
        <form @submit.prevent="saveInstrument">
            <label for="instrumentName">Instrument number:</label>
            <input type="text" id="instrumentName" v-model="instrument.instrumentNumber" required />
            <thead>
                <tr>
                    <th></th>
                    <th>Type</th>
                    <th>Specification</th>
                    <th>Quantity</th>
                    <th>Reference</th>
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
            <button type="submit">Add</button>
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
            console.log('Sending data:', this.instrument);
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