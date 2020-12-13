<template>
  <div id="nav">
    <el-menu
      :default-active="activeIndex2"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <el-menu-item index="/repo">Amazon.jlu <u>Mock</u></el-menu-item>
      <el-menu-item index="/admin" disabled>
        Admin</el-menu-item
      >
      <el-menu-item index="/cart" disabled>
        Cart</el-menu-item
      >
      <el-menu-item index="/login" class="ir">
        Login</el-menu-item
      >
      <el-menu-item index="/signup" class="ir">
        Signup</el-menu-item
      >
    </el-menu>

  </div>
</template>

<script>
export default {
  name: "Out",
  data() {
    return {
      activeIndex: this.$route.path,
      activeIndex2: this.$route.path
    };
  },  
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
      this.$router.push(key);
    }
  }
};
</script>

<style>
.el-menu-item {
  font-size: 20px;
  font-family: Impact, Haettenschweiler, "Arial Narrow Bold", sans-serif;
}
.ir {
  float: right !important; 
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-size: 16px;
}
</style>
