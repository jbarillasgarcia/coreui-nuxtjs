<template>
    <div>
        <b-table :dark="dark" :hover="hover" :striped="striped" :bordered="bordered" :small="small" :fixed="fixed" responsive="sm" :items="items" :fields="captions" :current-page="currentPage" :per-page="perPage">
            <template slot="selected" slot-scope="data">
                <b-badge v-if="mode === 'view'" :variant="getBadge(data.item.selected)">{{data.item.selected}}</b-badge>                
                <label v-else class="switch switch-label switch-primary">
                    <input class="switch-input" type="checkbox" checked="">
                    <span class="switch-slider" data-checked="On" data-unchecked="Off"></span>
                </label>
            </template>
        </b-table>
        <nav>
            <b-pagination :total-rows="totalRows" :per-page="perPage" :align="paginationAlign" v-model="currentPage" prev-text="Prev" next-text="Next" hide-goto-end-buttons/>
        </nav>
    </div>
</template>

<script>
    export default {
        name: 'c-table',
        inheritAttrs: false,
        props: {
            caption: {
                type: String,
                default: 'Table'
            },
            hover: {
                type: Boolean,
                default: false
            },
            striped: {
                type: Boolean,
                default: false
            },
            bordered: {
                type: Boolean,
                default: false
            },
            small: {
                type: Boolean,
                default: false
            },
            fixed: {
                type: Boolean,
                default: false
            },
            tableData: {
                type: [Array, Function],
                default: () => []
            },
            fields: {
                type: [Array, Object],
                default: () => []
            },
            perPage: {
                type: Number,
                default: 5
            },
            dark: {
                type: Boolean,
                default: false
            },
            paginationAlign: {
                type: String,
                default: 'left'
            },
            mode: {
                type: String,
                default: 'create'
            }
        },
        data: function () {
            return {
                currentPage: 1
            }
        },
        computed: {
            items: function () {
                const items = this.tableData
                return Array.isArray(items) ? items : items()
            },
            totalRows: function () {
                return this.getRowCount()
            },
            captions: function () {
                return this.fields
            }
        },
        methods: {
            getBadge(selected) {
                return selected ? 'primary' : 'danger';
            },
            getRowCount: function () {
                return this.items.length
            }
        },
        watch: {
            mode: function() {
                console.log('mode changed to ' + this.mode);
            }
        }
    }
</script>
