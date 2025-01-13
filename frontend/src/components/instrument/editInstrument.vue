<template>
    <div>
        <header-component></header-component>
        <h1>Edit instrument</h1>
        <form @submit.prevent="editInstrument">
            <label for="instrumentName">Instrument number:</label>
            <input type="text" v-model="instrument.instrumentNumber" value="{{ this.instrument.instrumentNumber }}" required />
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
            <button type="submit">Edit</button>
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
        }
    }
};
</script>