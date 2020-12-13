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
      <el-menu-item index="/repo_in">Amazon.jlu <u>Mock</u></el-menu-item>
      <el-menu-item index="/cart" :disabled="!account.admin">
        Admin</el-menu-item
      >
      <el-menu-item index="/admin">
        Cart</el-menu-item
      >
      <el-menu-item class="ir" @click="logout">
      {{account.username}} Logout</el-menu-item
      >
    </el-menu>

  </div>
</template>

<script>
export default {
  name: "Nav",
  data() {
    return {
      activeIndex: this.$route.path,
      activeIndex2: this.$route.path,
      account: {}
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
      this.$router.push(key);
    },
    toAdmin(){
      console.log(this.account);
      if(!(this.account.admin)){
        this.$message({
          message: 'Admin access only.',
          type: 'warning'
        });
      }else{
        this.$router.push({path: '/admin'});
      }
    },
    logout(){
      this.$http.get("http://localhost:4025/user/logout")
      .then(res => {
        console.log("delete");
        this.$router.push({path: '/'});
      })
      .catch(err => {
        console.error(err); 
      })
    }
  },
  created(){
      this.$http.get("http://localhost:4025/user/loginUser")
      .then(res => {
        console.log(res.data);
        this.account=res.data;
        if(this.account == null){
          console.log("not log in yet");
          this.$router.push({path: '/'})
        }
      })
      .catch(err => {
        console.error(err); 
      })
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
