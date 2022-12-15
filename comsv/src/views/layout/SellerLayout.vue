<template>
  <div>
    <el-container style="height: 100vh; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246); box-shadow: 2px 0 6px rgb(0 21 41 / 35%)">
        <el-menu :default-openeds="['1', '3']" style="min-height: 100%; overflow-x: hidden">
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>导航一</template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="1-1">选项1</el-menu-item>
              <el-menu-item index="1-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i>导航二</template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="2-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="2-4">
              <template slot="title">选项4</template>
              <el-menu-item index="2-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title"><i class="el-icon-setting"></i>导航三</template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="3-1">选项1</el-menu-item>
              <el-menu-item index="3-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="3-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="3-4">
              <template slot="title">选项4</template>
              <el-menu-item index="3-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <div>
          <div style="margin-left: 4px; height: 80px; line-height: 60px; background-color: lightgrey; margin-bottom: 2px; display: flex">
            <div style="width: 300px">
              <img src="@/assets/logo.png" alt="" style="width: 40px; position: relative; top: 10px; left: 20px">
              <span style="margin-left: 25px; font-size: 24px">校园订餐管理系统</span>
            </div>
            <div style="flex: 1; text-align: right; padding-right: 20px">
              <el-dropdown size="medium">
            <span style="cursor: pointer">
             {{ user.username }}<i class="el-icon-arrow-down el-icon--right"></i>
            </span>
                <el-dropdown-menu slot="dropdown" style="margin-top: -5px">
                  <el-dropdown-item>
                    <div style="width: 50px; text-align: center">
                      <i class="el-icon-close"></i>退出
                    </div>
                  </el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </div>
            <div style="position: absolute; left: 204px; top: 84px; width: 1230px">
              <router-view/>
            </div>
          </div>
        </div>

      </el-container>
    </el-container>
  </div>
</template>

<script>
import Cookies from "js-cookie";

export default {
  name: "SellerLayout",
  data(){
    return{
      user: Cookies.get('user') ? JSON.parse(Cookies.get('user')) : {}
    }
  },
  methods: {
    logout(){
      this.$router.push('/login')
      //清除浏览器用户数据  bn   n
      Cookies.remove('user')
    }
  }
}
</script>
