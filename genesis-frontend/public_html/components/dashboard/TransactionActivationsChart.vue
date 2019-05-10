<script>
    import { Line } from 'vue-chartjs';
    import { getStyle, hexToRgba } from '@coreui/coreui-pro/dist/js/coreui-utilities';
    import { CustomTooltips } from '@coreui/coreui-plugin-chartjs-custom-tooltips';
    import { random } from '@/middleware/utils';

    export default {
        extends: Line,
        props: [
            'selected'
        ],
        data: function () {
            return {
                activationsData: []
            };
        },
        mounted() {
            switch (this.selected) {
                case 'hour':
                    this.searchHourlyData();
                    break;
                case 'day':
                    this.searchDailyData();
                    break;
                case 'month':
                    this.searchMonthlyData();
                    break;
            }
        },
        computed: {
            chartData: function () {
                return this.activationsData;
            }
        },
        methods: {
            async searchHourlyData() {
                try {
                    let response = await this.$axios.get('/crm/getTransactionActivationsByHour');

                    const data = [];

                    response.data.forEach(function (element) {
                        data.push({
                            col1: element[0],
                            col2: element[1]
                        });
                    });

                    this.activationsData = data;

                    this.renderLineChart();
                } catch (error) {
                    console.error("FATAL: " + error);
                }
            },
            async searchDailyData() {
                try {
                    let response = await this.$axios.get('/crm/getTransactionActivationsByDay');

                    const data = [];

                    response.data.forEach(function (element) {
                        data.push({
                            col1: element[0],
                            col2: element[1]
                        });
                    });

                    this.activationsData = data;

                    this.renderLineChart();
                } catch (error) {
                    console.error("FATAL: " + error);
                }
            },
            async searchMonthlyData() {
                try {
                    let response = await this.$axios.get('/crm/getTransactionActivationsByMonth');

                    const data = [];

                    response.data.forEach(function (element) {
                        data.push({
                            col1: element[0],
                            col2: element[1]
                        });
                    });

                    this.activationsData = data;

                    this.renderLineChart();
                } catch (error) {
                    console.error("FATAL: " + error);
                }
            },
            renderLineChart: function () {
                const color = getStyle('--info') || '#20a8d8';

                let elements = this.chartData.length;
                const dataRows = [];
                const dataColumns = [];
                let max = 10;

                this.chartData.forEach(function (element) {
                    dataRows.push(element.col2);
                    dataColumns.push(element.col1);
                    
                    max = (parseInt(element.col2, 10) > max) ? parseInt(element.col2, 10) : max;                    
                });               
                
                this.renderChart({
                    labels: dataColumns,
                    datasets: [
                        {
                            label: 'Activaciones',
                            backgroundColor: hexToRgba(color, 10),
                            borderColor: color,
                            pointHoverBackgroundColor: '#fff',
                            borderWidth: 2,
                            data: dataRows
                        }
                    ]
                }, {
                    tooltips: {
                        enabled: false,
                        custom: CustomTooltips,
                        intersect: true,
                        mode: 'index',
                        position: 'nearest',
                        callbacks: {
                            labelColor: function (tooltipItem, chart) {
                                return {
                                    backgroundColor: chart.data.datasets[tooltipItem.datasetIndex].borderColor
                                };
                            }
                        }
                    },
                    maintainAspectRatio: false,
                    legend: {
                        display: false
                    },
                    scales: {
                        xAxes: [{
                                gridLines: {
                                    drawOnChartArea: false
                                }
                            }],
                        yAxes: [{
                                ticks: {
                                    beginAtZero: true,
                                    maxTicksLimit: 500,
                                    stepSize: Math.ceil(max / 5),
                                    max: max
                                },
                                gridLines: {
                                    display: true
                                }
                            }]
                    },
                    elements: {
                        point: {
                            radius: 0,
                            hitRadius: 10,
                            hoverRadius: 4,
                            hoverBorderWidth: 3
                        }
                    }
                });
            }
        },
        watch: {
            selected: function () {
                switch (this.selected) {
                    case 'hour':
                        this.searchHourlyData();
                        break;
                    case 'day':
                        this.searchDailyData();
                        break;
                    case 'month':
                        this.searchMonthlyData();
                        break;
                }
            }
        }
    }
</script>
