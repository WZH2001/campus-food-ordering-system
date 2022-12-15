<template>
  <div>
    <!--表格-->
    <el-table :data="tableData" stripe>
      <el-table-column prop="name" label="学生姓名"></el-table-column>
      <el-table-column prop="orderTime" label="订单时间"></el-table-column>
      <el-table-column prop="takeTime" label="取餐时间"></el-table-column>
      <el-table-column prop="foodName" label="菜品名称"></el-table-column>
      <el-table-column prop="foodPrice" label="菜品价格"></el-table-column>
      <el-table-column prop="windowName" label="窗口名称"></el-table-column>
      <el-table-column prop="windowAddress" label="窗口地址"></el-table-column>
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
  name: "StudentOrder",
  data(){
    return{
      tableData: [],
      total: 0,
      params: {
        pageNum: 1,
        pageSize: 10,
        studentId: this.$route.query.studentId
      }
    }
  },
  created() {
    this.load()
  },
  methods: {
    load(){
      request.get('/user/studentOrderInfo', {
        params: this.params
      }).then(res =>{
        if(res.code === "A0000"){
          this.tableData = res.data.studentOrderInfo
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