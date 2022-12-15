<template>
  <div>
    <!--表格-->
    <el-table :data="tableData" stripe>
      <el-table-column prop="windowName" label="窗口名"></el-table-column>
      <el-table-column prop="senderName" label="配送员姓名"></el-table-column>
      <el-table-column prop="senderTelephone" label="联系方式"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import request from "@/utils/Request";

export default {
  name: "SellerSender",
  data(){
    return{
      tableData: [],
      params: {
        sellerId: this.$route.query.sellerId
      }
    }
  },
  created() {
    this.load()
  },
  methods: {
    load(){
      request.get('/user/sellerSenderInfo', {
        params: this.params
      }).then(res =>{
        if(res.code === "A0000"){
          this.tableData = res.data
        }
      })
    }
  }
}
</script>