<template>
  <div>
  <Nav></Nav>
  <el-table
    :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase())
                                            || data.isbn.includes(search)
                                            || data.author.toLowerCase().includes(search.toLowerCase()))"
    style="width: 80%;margin: 30px auto;">
    <el-table-column
      label="ISBN"
      prop="isbn">
    </el-table-column>
    <el-table-column
      label="Bookname"
      prop="name">
    </el-table-column>
    <el-table-column
      label="Author"
      prop="author">
    </el-table-column>
    <el-table-column
      label="PubDate"
      prop="pubDate">
    </el-table-column>
    <el-table-column
      label="Stock"
      prop="stock">
    </el-table-column>
    <el-table-column
      label="Cost"
      prop="cost">
    </el-table-column>
    <el-table-column
      align="right" width="250">
      <template slot="header" slot-scope="scope">
        <el-input
          v-model="search"
          size="medium"
          placeholder="Type to search"/>
      </template>
      <template slot-scope="scope">
        <InN style="margin-right: 10px;"></InN>
        <el-button
          type="plain"
          size="medium">Purchase</el-button>
      </template>
    </el-table-column>
  </el-table>
  </div>  
</template>

<script>
import Nav from '../nav/In';
import InN from '../InN';
  export default {
    name: 'Repo_in',
    data() {
      return {
        tableData: [],
        search: '',
        account: {}
      }
    },
    methods: {
    },
    created(){
      this.$http.get("http://localhost:4025/book/findall")
      .then(res => {
        console.log(res);
        this.tableData=res.data;
      })
      .catch(err => {
        console.error(err); 
      })
      this.$http.get("http://localhost:4025/user/loginUser")
      .then(res => {
        console.log(res.data);
        this.account=res.data;
        if(this.account == null){
          console.log("no account back");
          this.$router.push({path: '/'})
        }
      })
      .catch(err => {
        console.error(err); 
      })
    },
    components: {
      Nav,
      InN
    }

  }
</script>

<style>
.el-table {
  font-size: 16px;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}
.el-table td, .el-table th {
    text-align: center;
}
</style>