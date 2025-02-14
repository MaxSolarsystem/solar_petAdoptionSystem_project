import {createRouter, createWebHistory} from 'vue-router';
import Login from '../views/Login.vue';
import Pet from '../views/Pet/index.vue';
import Register from "../views/Register.vue";
import Home from "../views/Pet/Home.vue";
import Store from "../views/Pet/Store.vue";
import PetAdoption from "../views/Pet/PetAdoption.vue";
import Forum from "../views/Pet/Forum.vue";
import UserCenter from "../views/Pet/UserCenter.vue";
import PetAdoptionInfo from "../views/Info/petAdoptionInfo.vue";
import ForumInfo from "../views/Info/ForumInfo.vue";
import BuyCar from "../views/Pet/BuyCar.vue";

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
                path: 'petAdoption',
                component: PetAdoption
            },
            {
                path: 'petAdoption/info/:id',
                name: 'PetAdoptionInfo',
                component: PetAdoptionInfo,
                props: true
            },
            {
                path: 'store',
                component: Store
            },
            {
                path: 'forum',
                component: Forum
            },
            {
                path: 'forum/info/:id',
                name: 'ForumInfo',
                component: ForumInfo,
                props: true
            },
            {
                path: 'userCenter',
                component: UserCenter
            },
            {
                path: 'buyCar',
                component: BuyCar
            },
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
