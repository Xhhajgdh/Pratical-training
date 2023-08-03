import {createRouter, createWebHashHistory} from 'vue-router'


const routes = [
    {
        path:'/',
        redirect:'/login'
    },
    {
        path:'/login',
        component:() => import('../views/Login.vue')
    },
    {
        path:'/adminLayout',
        component:() => import('../components/admin/AdminLayout.vue'),
        children:[
          {
            path:'',
            component:() => import('../views/Welcome.vue')
          },
          {
            path:'car',
            component:() => import('../views/admin/Car.vue')
          },
          {
            path:'customer',
            component:() => import('../views/admin/Customer.vue')
          },
          {
            path:'driver',
            component:() => import('../views/admin/Driver.vue')
          },
          {
            path:'auditOrder',
            component:() => import('../views/admin/AuditOrder.vue')
          },
          {
            path:'allOrder',
            component:() => import('../views/admin/AllOrder.vue')
          }
      ]
    },

]


const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router