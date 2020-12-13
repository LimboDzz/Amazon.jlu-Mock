<template>
  <div>
  <Nav></Nav>
  <el-form :model="ruleForm" ref="ruleForm" label-width="120px" style="width:40%;margin:100px auto;">
    <el-form-item label="ISBN">
      <el-input v-model="ruleForm.isbn"></el-input>
    </el-form-item>
    <el-form-item label="Bookname">
      <el-input type="password" v-model="ruleForm.name"></el-input>
    </el-form-item>
    <el-form-item label="Author">
      <el-input type="password" v-model="ruleForm.author"></el-input>
    </el-form-item>

  <el-form-item label="Publish Date">
    <el-col :span="11">
      <el-date-picker type="date" placeholder="Pick a date" v-model="ruleForm.pubDate" style="width: 100%;"></el-date-picker>
    </el-col>
  </el-form-item>
  <el-form-item label="Stock">
    <el-input-number v-model="ruleForm.stock" controls-position="right" :min="1" :max="999"></el-input-number>
  </el-form-item>
  <el-form-item label="Set Price">
    <el-input-number v-model="ruleForm.cost" controls-position="right" :min="1" :max="999"></el-input-number>
  </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">Order</el-button>
      <el-button @click="onReset">Reset</el-button>
    </el-form-item>
  </el-form>
  </div>  
</template>

<script>
import Nav from '../nav/In'
  export default {
    name: 'Admin',
    data() {
      return {
        ruleForm: {
          isbn: '',
          name: '',
          author: '',
          pubDate: ''
        }
      }
    },
    methods: {
      onSubmit() {
        if(!/\S/.test(this.ruleForm.isbn) || !/\S/.test(this.ruleForm.name) || !/\S/.test(this.ruleForm.author)){
          this.$notify({
            title: 'Warning',
            message: 'Invalid info',
            type: 'warning'
          });
        }else{
          this.$http.post("http://localhost:4025/book/save",this.ruleForm)
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
        this.ruleForm={};
      },
      // handleChange(value) {
      //   console.log(value);
      // }
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