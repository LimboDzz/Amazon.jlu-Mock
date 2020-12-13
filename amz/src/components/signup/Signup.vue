<template>
<el-form ref="form" :model="form" label-width="120px" style="width:40%;margin:100px auto;">
  <el-form-item label="Username">
    <el-input v-model="form.username"></el-input>
  </el-form-item>
  <el-form-item label="Password">
    <el-input v-model="form.password"></el-input>
  </el-form-item>
  <el-form-item label="User type">
    <el-checkbox-group v-model="form.type">
      <el-checkbox label="Admin" name="type"></el-checkbox>
    </el-checkbox-group>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">Create</el-button>
    <el-button>Cancel</el-button>
  </el-form-item>
</el-form>
</template>

<script>
  export default {
    name: 'Signup',
        data() {
      return {
        form: {
          username: '',
          password: '',
          type: [],
          resource: '',
          desc: ''
        }
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      }
    }
  }
</script>

<style>
.el-form-item__label {
  font-size: 16px;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}
</style>