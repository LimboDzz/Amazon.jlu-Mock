<template>
    <el-input-number placeholder="0"  v-model="num" controls-position="right" @change="handleChange" :min="0" :max="999" style="width: 100px;"></el-input-number>
</template>

<script>
export default {
    name: 'InN'
}
</script>

<script>
  export default {
    data() {
      return {
        num: 1,
        max: 999
      };
    },
    methods: {
      handleChange(value) {
        console.log(value)
      }
    }
  };
</script>