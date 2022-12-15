<template>
  <div>
    <!--搜索表单-->
    <div style="margin-bottom: 20px">
      <el-input style="width: 240px" placeholder="请输入用户名" suffix-icon="el-icon-search" v-model="params.username"></el-input>
      <el-input style="width: 240px; margin-left: 5px" placeholder="请输入寝室地址" suffix-icon="el-icon-position" v-model="params.address"></el-input>
      <el-button style="margin-left: 5px" type="primary" @click="load"><i class="el-icon-search">搜索</i></el-button>
      <el-button style="margin-left: 5px" type="warning" @click="reset"><i class="el-icon-refresh">重置</i></el-button>
    </div>
    <!--表格-->
    <el-table :data="tableData" stripe>
      <el-table-column prop="username" label="用户名"></el-table-column>
      <el-table-column prop="name" label="姓名"></el-table-column>
      <el-table-column prop="telephone" label="联系方式"></el-table-column>
      <el-table-column prop="address" label="寝室地址"></el-table-column>
      <el-table-column label="查看详情">
        <template v-slot="table">
          <el-button type="success" @click="$router.push('/studentOrder?studentId=' + table.row.studentId)">订单<i class="el-icon-more"></i></el-button>
          <el-button type="success" @click="$router.push('/studentCollect?studentId=' + table.row.studentId)">收藏<i class="el-icon-more"></i></el-button>
        </template>
      </el-table-column>
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
  name: 'StudentBaseInfo',
  data(){
    return{
      tableData: [],
      total: 0,
      params: {
        pageNum: 1,
        pageSize: 10,
        username: '',
        address: ''
      }
    }
  },
  created() {
    this.load()
  },
  methods:{
    //查询学生信息列表
    load(){
      request.get('/user/studentBaseInfo', {
        params: this.params
      }).then(res =>{
        if(res.code === "A0000"){
          this.tableData = res.data.studentBaseInfo
          this.total = res.data.total
        }
      })
    },
    //重置
    reset(){
      this.params = {
        pageNum: 1,
        pageSize: 10,
        username: '',
        address: ''
      }
      this.load()
    },
    //点击分页按钮触发分页
    handleCurrentChange(pageNum){
      this.params.pageNum = pageNum
      this.load()
    }
  }
}
</script>