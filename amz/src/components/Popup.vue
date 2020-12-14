<template>
<div align="center">
  <el-button id="order" type="primary" plain @click="open">Order</el-button>
</div>
</template>

<script>
  export default {
      name: 'Popup',
    methods: {
      open() {
        this.$confirm('Confirm your order.', 'Warning', {
          confirmButtonText: 'OK',
          cancelButtonText: 'Cancel',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: 'Order completed'
          });
          this.$http.get("http://localhost:4025/user/order")
            .then(res => {
                console.log("delete");
            })
            .catch(err => {
                console.error(err); 
            })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: 'Order canceled'
          });          
        });
      }
    }
  }
</script>

<style scoped>
#order {
    font-size: 30px ;
    font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}
</style>