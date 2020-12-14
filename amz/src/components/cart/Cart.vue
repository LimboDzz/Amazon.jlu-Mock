<template>
  <div>
    <Nav></Nav>
        <el-table
    :data="tableData"
    border
    :summary-method="getSummaries"
    show-summary
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
      label="Purchase"
      prop="stock">
    </el-table-column>
    <el-table-column
      label="Cost"
      prop="cost">
    </el-table-column>
    <el-table-column
      align="center" width="200" label="Operation">
      <template slot-scope="scope">
        <el-button
          size="medium"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
      </template>
    </el-table-column>
  </el-table>
<div align="center">
  <el-button id="order" type="primary" plain @click="open">Order</el-button>
</div>
  </div>
</template>

<script>
import Nav from '../nav/In';
import InN from '../InN';
// import Popup from '../Popup';
  export default {
    name: 'Cart',
    data() {
      return {
        tableData: [],
        search: '',
        account: {},
        sum: 0
      }
    },
    methods: {
      handleDelete(index, row) {
        this.$http.post("http://localhost:4025/cart/delete",row)
        .then(res => {
            // console.log(res.data);
            // this.$router.push({path: '/cart'})
            this.login();
        })
        .catch(err => {
            console.error(err); 
        })
      },
      getSummaries(param) {
        const { columns, data } = param;
        const sums = [];
        columns.forEach((column, index) => {
          if (index === 0) {
            sums[index] = 'Total Cost';
            return;
          }
          if(index!=5){
            sums[index] = '';
            return;
          }
          const values = data.map(item => Number(item[column.property]));
          if (!values.every(value => isNaN(value))) {
            sums[index] = '$ ' + values.reduce((prev, curr) => {
              const value = Number(curr);
              if (!isNaN(value)) {
                return prev + curr;
              } else {
                return prev;
              }
            }, 0);
          } else {
            sums[index] = '';
          }
        });
        

        columns.forEach((column, index) => {
          if(index==5){
            const values = data.map(item => Number(item[column.property]));
            if (!values.every(value => isNaN(value))) {
              this.sum = values.reduce((prev, curr) => {
                const value = Number(curr);
                if (!isNaN(value)) {
                  return prev + curr;
                } else {
                  return prev;
                }
              }, 0);
            }
          }

        });
        return sums;
      },
      open() {
        this.$http.get("http://localhost:4025/user/order?sum="+this.sum)
          .then(res => {

          })
          .catch(err => {
              console.error(err); 
          })
        this.$http.get("http://localhost:4025/cart/deleteAll")
            .then(res=>{
              // console.log(res.data);
              this.login();
            }).catch((err)=>{
              console.log(err);
            })
      },
      login(){
              this.$http.get("http://localhost:4025/cart/findall")
                .then(res => {
                  // console.log(res);
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
      }
    },
    created(){
        this.login();
    },
    components: {
      Nav,
      InN,
      // Popup
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
#order {
    font-size: 30px ;
    font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}
</style>