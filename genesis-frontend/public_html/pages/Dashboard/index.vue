<template>
    <div class="animated fadeIn">        
        <b-card>
            <b-row>
                <b-col sm="5">
                    <h4 id="traffic" class="card-title mb-0">Activaciones</h4>
                    <div class="small text-muted">{{range}}</div>
                </b-col>
                <b-col sm="7" class="d-none d-md-block">
                    <b-button type="button" variant="primary" class="float-right"><i class="icon-cloud-download"></i></b-button>
                    <b-button-toolbar class="float-right" aria-label="Toolbar with buttons group">
                        <b-form-radio-group class="mr-3" id="radiosBtn" buttons button-variant="outline-secondary" v-model="selected" @change="updateRange" name="radiosBtn">
                            <b-form-radio class="mx-0" value="hour">Hora</b-form-radio>
                            <b-form-radio class="mx-0" value="day">D&iacute;a</b-form-radio>
                            <b-form-radio class="mx-0" value="month">Mes</b-form-radio>
                        </b-form-radio-group>
                    </b-button-toolbar>
                </b-col>
            </b-row>
            <transaction-activations-chart chartId="main-chart-01" class="chart-wrapper" style="height:300px;margin-top:40px;" :selected="selected"></transaction-activations-chart>
        </b-card>    
    </div>
</template>

<script>
    import TransactionActivationsChart from '@/components/dashboard/TransactionActivationsChart';

    import DashboardPerimeter from '@/perimeter/DashboardPerimeter';

    export default {
        name: 'dashboard',
        middleware: 'authenticated',
        perimeters: [
            DashboardPerimeter
        ],
        components: {
            TransactionActivationsChart
        },
        data: function () {
            return {
                selected: 'day',
                range: 'Activaciones de los últimos 30 días'
            };
        },
        methods: {
            updateRange: function (checked) {
                switch (checked) {
                    case 'hour':
                        this.range = 'Activaciones por hora del día de hoy';
                        break;
                    case 'day':
                        this.range = 'Activaciones de los últimos 30 días';
                        break;
                    case 'month':
                        this.range = 'Activaciones de los últimos 12 meses';
                        break;
                }
            }
        }
    }
</script>

<style src="./index.scss" lang="scss"/>