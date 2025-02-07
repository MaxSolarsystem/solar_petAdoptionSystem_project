import {createRouter, createWebHistory} from 'vue-router';
import Login from '../views/Login.vue';
import Pet from '../views/Pet/index.vue';
import Register from "../views/Register.vue";
import Home from "../views/Pet/Home.vue";
import Store from "../views/Pet/Store.vue";

const routes = [
    {
        path: '/',
        redirect: '/home',
        name: 'Pet',
        component: Pet,
        children: [
            {
                path: 'home',
                component: Home
            },
            {
                path: 'store',
                component: Store
            }
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: Login,
    },
    {
        path: '/register',
        name: 'Register',
        component: Register,
    },
];

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes,
});

export default router;
