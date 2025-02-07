import {createRouter, createWebHistory} from 'vue-router';
import LoginPage from '../views/Login.vue';
import HomePage from '../views/Home.vue';

const routes = [
    {
        path: '/',
        name: 'Home',
        component: HomePage,
    },
    {
        path: '/login',
        name: 'Login',
        component: LoginPage,
    },
];

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes,
});

export default router;
