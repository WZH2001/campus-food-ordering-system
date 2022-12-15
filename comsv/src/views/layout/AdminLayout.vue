<template>
  <div>
    <!--头部区域-->
    <div style="height: 60px; line-height: 60px; background-color: lightgrey; margin-bottom: 2px; display: flex">
      <div style="width: 300px">
        <img src="@/assets/logo.png" alt="" style="width: 40px; position: relative; top: 10px; left: 20px">
        <span style="margin-left: 25px; font-size: 24px">校园订餐管理系统</span>
      </div>
      <div style="flex: 1; text-align: right; padding-right: 20px">
        <el-dropdown size="medium">
          <span class="el-dropdown-link" style="cursor: pointer">
            {{user.username}}<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown" style="margin-top: -5px">
            <el-dropdown-item><div style="width: 50px; text-align: center" @click="logout">
              <i class="el-icon-close"></i>退出
            </div></el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
    <!--侧边栏和主体-->
    <div style="display: flex">
      <!--侧边栏导航-->
      <div style="width: 180px; min-height: calc(100vh - 62px); overflow: hidden; margin-right: 2px">
        <el-menu :default-active="$route.path"
                 :default-opens="['/']" router
                 class="el-menu-demo"
                 background-color="rgb(48, 65, 86)"
                 text-color="#fff"
                 style="min-height: 100%; overflow-x: hidden"
        >
          <!--首页-->
          <el-menu-item index="/">
            <i class="el-icon-s-home"></i>
            <span>首页</span>
          </el-menu-item>
          <!--用户管理-->
          <el-submenu index="user">
            <template slot="title">
              <i class="el-icon-user-solid"></i>
              <span>用户管理</span>
            </template>
            <el-menu-item index="/studentBaseInfo">
              <i class="el-icon-dish"></i>
              <span>学生管理</span>
            </el-menu-item>
            <el-menu-item index="/sellerBaseInfo">
              <i class="el-icon-dish"></i>
              <span>商家管理</span>
            </el-menu-item>
          </el-submenu>
          <!--菜品管理-->
          <el-submenu index="/dishes">
            <template slot="title">
              <i class="el-icon-food"></i>
              <span>菜品管理</span>
            </template>
            <el-menu-item index="/dishesList">
              <i class="el-icon-chicken"></i>
              <span>菜品查看</span>
            </el-menu-item>
            <el-menu-item index="/dishesRecommend">
              <i class="el-icon-chicken"></i>
              <span>菜品推荐</span>
            </el-menu-item>
          </el-submenu>
          <!--订单管理-->
          <el-menu-item index="/order">
            <i class=""></i>
            <span>订单管理</span>
          </el-menu-item>
          <!--配送管理-->
          <el-menu-item index="/courier">
            <i class=""></i>
            <span>配送员管理</span>
          </el-menu-item>
          <!--收藏管理-->
          <el-menu-item index="/collect">
            <i class=""></i>
            <span>收藏管理</span>
          </el-menu-item>
          <!--查看以往-->
          <el-submenu index="past">
            <template slot="title">
              <i class=""></i>
              <span>查看以往</span>
            </template>
            <el-menu-item index="/pastStudent">
              <i class=""></i>
              <span>往期学生</span>
            </el-menu-item>
            <el-menu-item index="/pastSeller">
              <i class=""></i>
              <span>往期商家</span>
            </el-menu-item>
            <el-menu-item index="/pastDishes">
              <i class=""></i>
              <span>往期菜品</span>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </div>
      <!--主体数据-->
      <div style="flex: 1;padding: 5px">
        <router-view/>
      </div>
    </div>
  </div>
</template>

<script>
import Cookies from "js-cookie";

export default {
  name: "AdminLayout",
  data(){
    return{
      user: Cookies.get('user') ? JSON.parse(Cookies.get('user')) : {}
    }
  },
  methods: {
    logout(){
      this.$router.push('/login')
      //清除浏览器用户数据
      Cookies.remove('user')
    }
  }
}
</script>