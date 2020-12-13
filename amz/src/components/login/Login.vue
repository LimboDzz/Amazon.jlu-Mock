<template>
<el-form :model="ruleForm" ref="ruleForm" label-width="120px" style="width:40%;margin:100px auto;">
  <el-form-item label="Username">
    <el-input v-model="ruleForm.username" placeholder="4-20 letters or numbers"></el-input>
  </el-form-item>
  <el-form-item label="Password">
    <el-input type="password" v-model="ruleForm.password" placeholder="4-20 letters or numbers"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">Login</el-button>
    <el-button @click="onReset">Reset</el-button>
  </el-form-item>
</el-form>
</template>

<script>
  export default {
    name: 'Login',
    data() {
      return {
        ruleForm: {
          username: '',
          password: ''
        }
      }
    },
    methods: {
      onSubmit() {
        let {username:name,password:pass}=this.ruleForm;
        console.log(this.ruleForm);
        if(!/^[a-zA-Z0-9]{4,20}$/.test(name)){
          this.$notify({
            title: 'Warning',
            message: 'Invalid username',
            type: 'warning'
          });
        }else if(!/^[a-zA-Z0-9]{4,20}$/.test(pass)){
          this.$notify({
            title: 'Warning',
            message: 'Invalid password',
            type: 'warning'
          });
        }else{
          this.$http.post("http://localhost:4025/user/login",this.ruleForm)
          .then(res => {
            res.data.status?
            this.$notify({
              title: 'Success',
              message: res.data.msg,
              type: 'success'
            }):
            this.$notify.error({
              title: 'Error',
              message: res.data.msg
            });
          })
          .catch(err => {
            this.$notify.error({
              title: 'Error',
              message: res.data.msg
            });
          })
        }
      },
      onReset() {
        this.ruleForm={
          username: '',
          password: ''
        };
      }
    }
  }
</script>

<style>
.el-form-item__label {
  font-size: 16px;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}
#code:hover {
    cursor: pointer;
}
</style>