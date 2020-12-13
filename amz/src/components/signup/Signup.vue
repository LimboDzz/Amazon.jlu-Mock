<template>
<div>
  <Nav></Nav>
  <el-form :model="ruleForm" ref="ruleForm" label-width="120px" style="width:40%;margin:100px auto;">
    <el-form-item label="Username">
      <el-input v-model="ruleForm.username" placeholder="4-20 letters or numbers"></el-input>
    </el-form-item>
    <el-form-item label="Password">
      <el-input type="password" v-model="ruleForm.password" placeholder="4-20 letters or numbers"></el-input>
    </el-form-item>
    <el-form-item label="Confirm">
      <el-input type="password" v-model="ruleForm.confirm" placeholder="re-input your password"></el-input>
    </el-form-item>
    <el-form-item label="User type">
      <el-checkbox-group v-model="ruleForm.type">
        <el-checkbox label="Admin" name="type"></el-checkbox>
      </el-checkbox-group>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">Create</el-button>
      <el-button @click="onReset">Reset</el-button>
    </el-form-item>
  </el-form>
  </div>
</template>

<script>
import Nav from '../nav/Out'
  export default {
    name: 'Signup',
    data() {
      return {
        ruleForm: {
          username: '',
          password: '',
          confirm: '',
          type: []
        }
      }
    },
    methods: {
      onSubmit() {
        let {username:name,password:pass,confirm}=this.ruleForm;
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
        }else if(pass!=confirm){
          this.$notify({
            title: 'Warning',
            message: 'Unmatched confirmation',
            type: 'warning'
          });
        }else{
          this.ruleForm.admin=this.ruleForm.type.length==0?false:true;
          this.$http.post("http://localhost:4025/user/save",this.ruleForm)
          .then(res => {
            res.data.status?
            this.$notify({
              title: 'Success',
              message: res.data.msg,
              type: 'success'
            }):
            this.$notify.info({
              title: 'Info',
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
          password: '',
          confirm: '',
          type: []
        };
      }
    },
    components: {
      Nav
    }
  }
</script>

<style>
.el-form-item__label {
  font-size: 16px;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}
</style>