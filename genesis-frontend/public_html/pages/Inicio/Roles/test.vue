<template>
  <div>
    <b-form-group label="Selection mode:" label-cols-md="4">
      <b-form-select v-model="selectMode" :options="modes" class="mb-3" />
    </b-form-group>

    <b-table
      selectable
      :select-mode="selectMode"
      selectedVariant="success"
      :items="items"
      @row-selected="rowSelected"
    />

    {{ selected }}
  </div>
</template>

<script>
  export default {
    data() {
      return {
        modes: ['multi', 'single', 'range'],
        items: [
          { isActive: true, age: 40, first_name: 'Dickerson', last_name: 'Macdonald' },
          { isActive: false, age: 21, first_name: 'Larsen', last_name: 'Shaw' },
          { isActive: false, age: 89, first_name: 'Geneva', last_name: 'Wilson' },
          { isActive: true, age: 38, first_name: 'Jami', last_name: 'Carney' }
        ],
        selectMode: 'multi',
        selected: []
      }
    },
    methods: {
      rowSelected(items) {
        this.selected = items
      }
    }
  }
</script>