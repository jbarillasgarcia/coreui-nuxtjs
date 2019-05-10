<template>
    <div class="animated fadeIn">
        <b-row>
            <b-col lg="12">
                <b-form @submit.prevent="search" @reset="reset">
                    <b-card>
                        <b-card-header>
                            <i class="fa fa-filter"></i>Par&aacute;metros de B&uacute;squeda
                        </b-card-header>
                        <b-card-body>                        
                            <b-form-row>
                                <b-col class="col-5"> 
                                    <b-form-group id="startDateLabel"
                                                  label="Desde"
                                                  label-for="startDate"
                                                  description="Se mostrarán resultados desde esta fecha.">
                                        <b-form-input id="startDate"
                                                      type="date"
                                                      v-model="filter.startDate"
                                                      :disabled="!enabledControls"
                                                      required>
                                        </b-form-input>
                                    </b-form-group>
                                </b-col>
                                <b-col  class="col-5 offset-1">
                                    <b-form-group id="endDateLabel"
                                                  label="Hasta"
                                                  label-for="endDate"
                                                  description="Se mostrarán resultados hasta esta fecha.">
                                        <b-form-input id="endDate"
                                                      type="date"
                                                      v-model="filter.endDate"
                                                      :disabled="!enabledControls"
                                                      required>
                                        </b-form-input>
                                    </b-form-group>
                                </b-col>                                                                
                            </b-form-row>
                        </b-card-body>
                        <b-card-footer class="text-center">
                            <b-button type="submit" variant="primary" :disabled="!enabledControls"><i class="fa fa-search"></i>&nbsp;Buscar</b-button>
                            <b-button type="reset" variant="danger" :disabled="!enabledControls"><i class="fa fa-eraser"></i>&nbsp;Limpiar</b-button>
                        </b-card-footer>
                    </b-card>                
                </b-form>
            </b-col>
        </b-row>
        <b-card v-if="showResults">
            <b-card-header>
                <i class="fa fa-gift"></i>Data Rewards Activations
                <div class="card-header-actions">                                        
                    <a class="card-header-action" @click="download" style="cursor: pointer" v-if="$reportsPerimeter.isAllowed('exportDataRewards')">
                        <i class="fa fa-download"></i>
                    </a>                    
                </div>
            </b-card-header>
            <b-card-body>
                <v-client-table 
                    id="dataTable" 
                    class="text-center"
                    :columns="dataTable.columns" 
                    :data="dataTable.data" 
                    :options="dataTable.options" 
                    :theme="dataTable.theme">                    
                </v-client-table>
            </b-card-body>            
        </b-card>
    </div>
</template>

<script>
    import Vue from 'vue';

    import {ClientTable, Event} from 'vue-tables-2';
    import toastr from 'toastr';
    import 'toastr/toastr.js';
    import 'toastr/toastr.scss';

    import ReportsPerimeter from '@/perimeter/ReportsPerimeter';

    Vue.use(ClientTable);

    export default {
        name: 'DataTable',
        middleware: 'authenticated',
        perimeters: [
            ReportsPerimeter
        ],
        components: {
            ClientTable,
            Event
        },
        computed: {
            showResults: function () {
                return this.dataTable.data.length > 0;
            }
        },
        created() {
            toastr.options.closeButton = true;
            toastr.options.newestOnTop = false;
            toastr.options.timeOut = 5000; // How long the toast will display without user interaction. If 0, the toastr will persist until selected.
            toastr.options.extendedTimeOut = 5000; // How long the toast will display after a user hovers over it. If 0, the toastr will persist until selected.
            toastr.options.progressBar = true;
            toastr.options.preventDuplicates = true;
        },
        data: function () {
            return {
                filter: {
                    startDate: new Date(),
                    endDate: new Date()
                },
                dataTable: {
                    columns: ['transaction', 'activationDate', 'dn', 'client', 'bonusCode', 'description', 'carrierStatus', 'magusStatus'],
                    data: [],
                    options: {
                        headings: {
                            transaction: 'Transacción',
                            activationDate: 'Activación',
                            dn: 'DN',
                            client: 'Cliente',
                            bonusCode: 'Código bono',
                            description: 'Descripción',
                            carrierStatus: 'Estado Carrier',
                            magusStatus: 'Estado Magus'
                        },
                        dateColumns: ['activationDate'],
                        sortable: ['transaction', 'activationDate', 'dn', 'client', 'bonusCode', 'carrierStatus', 'magusStatus'],
                        filterable: ['transaction', 'activationDate', 'dn', 'client', 'bonusCode', 'description'],
                        sortIcon: {base: 'fa', up: 'fa-sort-asc', down: 'fa-sort-desc', is: 'fa-sort'},
                        pagination: {
                            chunk: 5,
                            edge: false,
                            nav: 'scroll'
                        },
                        perPage: 10
                    },
                    useVuex: false,
                    theme: 'bootstrap4',
                    template: 'default',
                },
                enabledControls: true
            }
        },
        methods: {
            async search() {
                this.enabledControls = false;

                try {
                    let response = await this.$axios.get('/crm/getDataRewardsActivation', {
                        params: {
                            startDate: this.filter.startDate,
                            endDate: this.filter.endDate
                        }
                    });

                    let formattedData = [];

                    response.data.forEach(function (row) {
                        formattedData.push({
                            transaction: row[0],
                            activationDate: row[1],
                            dn: row[2],
                            client: row[3],
                            bonusCode: row[4],
                            description: row[5],
                            carrierStatus: row[6],
                            magusStatus: row[7]
                        });
                    });

                    this.dataTable.data = formattedData;

                    if (this.dataTable.data.length <= 0) {
                        toastr.remove();
                        toastr.warning('No se ha encontrado ningún resultado para las fechas indicadas.');
                    }

                    //console.log('Response: ' + JSON.stringify(this.dataTable.data));
                } catch (error) {
                    //console.error("FATAL: " + JSON.stringify(error));

                    let message = error.response.data.message.split('|');

                    toastr.remove();
                    toastr.error(message[1], message[0]);
                    
                    this.dataTable.data = [];
                } finally {
                    this.enabledControls = true;
                }
            },
            reset() {
                this.filter.startDate = null;
                this.filter.endDate = null;
                this.dataTable.data = [];
            },
            async download() {
                this.enabledControls = false;

                try {
                    this.$axios({
                        url: '/crm/exportDataRewardsActivationAsXLSX',
                        method: 'GET',
                        responseType: 'blob',
                        params: {
                            startDate: this.filter.startDate,
                            endDate: this.filter.endDate
                        }
                    }).then((response) => {                        
                        const url = window.URL.createObjectURL(new Blob([response.data]));
                        const link = document.createElement('a');
                        link.href = url;
                        link.setAttribute('download', response.headers['filename']); //or any other extension
                        document.body.appendChild(link);
                        link.click();
                        document.body.removeChild(link);
                        window.URL.revokeObjectURL(url);
                    });

                    /*let response = await this.$axios.get('/crm/exportDataRewardsActivationAsXLSX', {
                        params: {
                            startDate: this.filter.startDate,
                            endDate: this.filter.endDate
                        }
                    });

                    console.log('Response: ' + JSON.stringify(this.dataTable.data));*/
                } catch (error) {
                    //console.error("FATAL: " + JSON.stringify(error));

                    let message = error.response.data.message.split('|');

                    toastr.error(message[1], message[0]);
                } finally {
                    this.enabledControls = true;
                }
            }
        }
    }
</script>

<style src="./index.scss" lang="scss"/>