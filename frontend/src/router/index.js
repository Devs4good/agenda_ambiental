import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import PaginaEvento from '@/components/PaginaEvento'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/evento/:id',
      name: 'Evento',
      component: PaginaEvento
    }
  ]
})
