import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import Inventory from '../views/Inventory.vue'
import History from '../views/History.vue'
import FishForm from '../views/FishForm.vue'
import HistoryForm from '../views/HistoryForm.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    }, 
    {
      path: "/api/fish",
      name: "inventory",
      component: Inventory,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/api/tracking-history",
      name: "history",
      component: History,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/form/fish",
      name: "fish-form",
      component: FishForm,
      meta: {
        requiresAdmin: true
      }
    },
    {
      path: "/form/tracking-history",
      name: "history-form",
      component: HistoryForm,
      meta: {
        requiresAdmin: true
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
  const requiresAdmin = to.matched.some(x => x.meta.requiresAdmin);

  const isLoggedIn = store.state.token !== ''; // added to check if user is logged in
  const isAdmin = store.state.user.authorities[0].name === 'ROLE_ADMIN'; // added to check if user is admin

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && !isLoggedIn) {
    next("/login");
  } else if (requiresAdmin && !isAdmin) {
    next("/"); // added to redirect to home if not admin
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
