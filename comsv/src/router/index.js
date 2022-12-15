import Vue from 'vue'
import VueRouter from 'vue-router'
import Cookies from "js-cookie"
import AdminLayout from "@/views/layout/AdminLayout";
import StudentLayout from "@/views/layout/StudentLayout";
import SellerLayout from "@/views/layout/SellerLayout";
Vue.use(VueRouter)

const routes = [
    //登录
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/user/Login.vue')
  },
    //注册
  {
    path: '/register',
    name: 'register',
    component: () => import('../views/user/Register.vue')
  },
  //学生主页
  {
    path: '/studentLayout',
    name: 'studentLayout',
    component: StudentLayout,
    redirect: '/studentMain',
    children: [
      {
        path: '/studentMain',
        name: 'studentMain',
        component: () => import('../views/home/StudentMain')
      }
    ]
  },
    //商家主页
  {
    path: '/sellerLayout',
    name: 'sellerLayout',
    component: SellerLayout,
    redirect: '/sellerMain',
    children: [
      {
        path: '/sellerMain',
        name: 'sellerMain',
        component: () => import('../views/home/SellerMain')
      },
        //菜单
      {
        path: '/menu',
        name: 'menu',
        component: () => import('../views/seller/Menu.vue')
      }
    ]
  },
   //管理员主页
  {
    path: '/',
    name: 'adminLayout',
    component: AdminLayout,
    redirect: '/adminHome',
    children: [ //子路由
      {
        path: '/adminHome',
        name: 'adminHome',
        component: () => import('../views/home/AdminHome.vue')
      },
      //学生列表
      {
        path: '/studentBaseInfo',
        name: 'studentBaseInfo',
        component: () => import('../views/userManage/StudentBaseInfo.vue')
      },
      //商家列表
      {
        path: '/sellerBaseInfo',
        name: 'sellerBaseInfo',
        component: () => import('../views/userManage/SellerBaseInfo.vue')
      },
      //学生订单
      {
        path: '/studentOrder',
        name: 'studentOrder',
        component: () => import('../views/userManage/StudentOrder.vue')
      },
      //学生收藏
      {
        path: '/studentCollect',
        name: 'studentCollect',
        component: () => import('../views/userManage/StudentCollect.vue')
      },
      //商家菜单
      {
        path: '/sellerMenu',
        name: 'sellerMenu',
        component: () => import('../views/userManage/SellerMenu')
      },
      //商家配送员
      {
        path: '/sellerSender',
        name: 'sellerSender',
        component: () => import('../views/userManage/SellerSender')
      }
    ]
  },
  {
    path: '*',
    component: () => import('@/views/404.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

//路由守卫
router.beforeEach((to, from, next) => {
  const user = Cookies.get("user")
  if(!user && to.path !== '/login' && to.path !== '/register') return next("/login") //强制跳转到登录页面
  //符合条件放行
  next()
})

export default router
