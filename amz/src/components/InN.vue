<template>
    <el-input-number v-model="num" controls-position="right" @change="handleChange" :min="1" :max=max style="width: 100px;"></el-input-number>
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
        max: 25
      };
    },
    methods: {
      handleChange(value) {
        console.log(value)
      }
    }
  };
</script>