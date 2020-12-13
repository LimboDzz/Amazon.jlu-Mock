import Vue from 'vue'
import Router from 'vue-router'
import Admin from '@/components/admin/Admin'
import Repo from '@/components/repo/Repo'
import Cart from '@/components/cart/Cart'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',                    // root
      redirect: '/repo'
    },
    {                               // repo
      path: '/repo',
      component: Repo
    },
    {                               // admin
      path: '/admin',
      component: Admin
    },
    {                               // cart
      path: '/cart',
      component: Cart
    }
  ]
})
