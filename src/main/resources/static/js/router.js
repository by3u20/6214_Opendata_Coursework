const routes = [
  {path: "/", component: welcome},
  {path: "/about", component: about},
  {path: "/pref", component: pref},
  {path: "/gen", component: gen},
  {path: "/destlist", component: destlist},
]

const router = VueRouter.createRouter({
  history: VueRouter.createWebHashHistory(),
  routes: routes,
})
