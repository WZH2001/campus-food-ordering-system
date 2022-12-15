<template>
  <div>
    <!--表格-->
    <el-table :data="tableData" stripe>
      <el-table-column prop="windowName" label="窗口名"></el-table-column>
      <el-table-column prop="foodName" label="菜品名称"></el-table-column>
      <el-table-column prop="foodPrice" label="菜品价格"></el-table-column>
      <el-table-column prop="foodDescribe" label="菜品描述"></el-table-column>
    </el-table>
    <!--分页-->
    <div style="margin-top: 20px">
      <el-pagination
          background
          :current-page="params.pageNum"
          :page-size="params.pageSize"
          @current-change="handleCurrentChange"
          layout="prev, pager, next"
          :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import request from "@/utils/Request";

export default {
  name: "SellerMenu",
  data(){
    return{
      tableData: [],
      total: 0,
      params: {
        pageNum: 1,
        pageSize: 10,
        sellerId: this.$route.query.sellerId
      }
    }
  },
  created() {
    this.load()
  },
  methods: {
    load(){
      request.get('/user/sellerFoodInfo', {
        params: this.params
      }).then(res =>{
        if(res.code === "A0000"){
          this.tableData = res.data.sellerFoodInfo
          this.total = res.data.total
        }
      })
    },
    handleCurrentChange(pageNum){
      //点击分页按钮触发分页
      this.params.pageNum = pageNum
      this.load()
    }
  }
}
</script>