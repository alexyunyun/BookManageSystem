import Vue from 'vue'
import VueRouter from 'vue-router'
import SearchBook from "@/views/SearchBook";
import AddBook from "@/views/AddBook";
import DeleteBook from "@/views/DeleteBook";
import UpdateBook from "@/views/UpdateBook";
import APP from '../App'
import Index from '@/views/Index'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: '图书管理',
        component: Index,
        redirect: '/find',
        show:true,
        children: [{
            path: '/find',
            name: '查询图书',
            component: SearchBook
        },
            {
                path: '/add',
                name: '添加图书',
                component: AddBook
            }
        ]
    }
    ,
    {
        path: '/navigation',
        name: '图书更新',
        component: Index,
        show:false,
        children: [
            {
                path: '/update',
                name: '更新图书',
                component: UpdateBook
            }, {
                path: '/delete',
                name: '删除图书',
                component: DeleteBook
            }
        ]
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
