import Vue from 'vue'
import Router from 'vue-router'
import Admin from '@/components/Admin'
import Index from '@/components/Index'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/Index'
    },
    {
      path: '/Admin',
      component: Admin
    },
    {
      path: '/index',
      component: Index
    }
  ]
})
