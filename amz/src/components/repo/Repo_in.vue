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
        <template>
        <el-input-number placeholder="0" v-model="num[scope.$index]" controls-position="right" :min="0" :max="999" style="width: 100px;margin-right: 10px;" ></el-input-number>
        </template>
        <el-button
          type="plain"
          size="medium"
          @click="handlePurchase(scope.$index, scope.row)">Add to Cart</el-button>
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
        account: {},
        num: [],
      }
    },
    methods: {
      handlePurchase(index, row){
        console.log(index, row);
        if(this.num[index]>0){
          // 深克隆
          // 将原对象中的数据全部复制过去，新对象和原对象毫无关系，互不影响
          let mock=JSON.parse(JSON.stringify(row));
          mock.stock=this.num[index];
          this.$http.post("http://localhost:4025/cart/save",mock)
          .then(res => {
            console.log(res.data);
          })
          .catch(err => {
            console.error(err); 
          })
          // console.log(row,mock);
          this.$message({
            message: `${this.num[index]} X <${row.name}> added.`,
            type: 'success'
          });
        }
        else{
          this.$message.error('Please input number.');
        }
        }
       
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