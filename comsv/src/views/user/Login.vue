<template>
  <div style="height: 100vh; overflow: hidden; background-image: url(https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg); background-size: 100%">
    <div style="margin-left: 570px; margin-top: 40px">
      <span style="font-size: 30px; font-weight: bold">
        欢迎来到校园订餐系统
      </span>
    </div>
    <div style="width: 500px; height: 400px; background-color: white; border-radius: 10px; margin: 150px auto; padding: 50px">
      <div style="margin: 25px; text-align: center; font-size: 30px; font-weight: bold; color: dodgerblue">登 录</div>
      <el-form :model="user" :rules="rules" ref="loginForm">
        <el-form-item prop="username">
          <el-input placeholder="请输入用户名" prefix-icon="el-icon-user" size="medium" v-model="user.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input placeholder="请输入密码" show-password prefix-icon="el-icon-lock" size="medium" v-model="user.password"></el-input>
        </el-form-item>
        <el-form-item><el-button style="width: 100%" size="medium" type="primary" @click="login">登录</el-button></el-form-item>
      </el-form>
      <div style="margin-left: 320px;">
        <router-link :to="{ path: '/register'}" >点击注册</router-link>
      </div>
    </div>
  </div>
</template>

<script>
import request from "@/utils/Request";
import Cookies from "js-cookie"

export default {
  name: "Login",
  data(){
    return{
      user: {},
      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {min: 3, max: 10, message: '长度为3-10个字符', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 3, max: 10, message: '长度为3-10个字符', trigger: 'blur'}
        ]
      }
    }
  },
  methods:{
    login(){
      this.$refs['loginForm'].validate((valid) =>{
        if(valid){
          request.post('/user/userLogin', this.user).then(res =>{
            if(res.code === 'A0000'){
              Cookies.set('user', JSON.stringify(res.data))
              this.$notify.success("登录成功")
              if(res.data.roleId === '4c2f94fcb40142448ae78db8cad241df'){
                this.$router.push('/sellerLayout')
              }else if(res.data.roleId === '722b752e5c5d4c5d9d55f1160ed46875'){
                this.$router.push('/studentLayout')
              }
              else{
                this.$router.push('/')
              }
            }
            else if(res.code === 'A0001'){
              this.$notify.error("密码错误！")
            }
            else if(res.code === 'A0002'){
              this.$notify.error("用户名不存在，请注册！")
            }
          })
        }
      })
    }
  }
}
</script>
