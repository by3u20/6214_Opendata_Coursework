const routes = [
  {path: "/", name: "index", component: welcome},
  {path: "/about", name: "about", component: about},
  {path: "/pref", name: "pref", component: pref},
  {path: "/gen", name: "gen", component: gen, props: true},
  {path: "/destlist", name: "destlist", component: destlist, props: true},
]

const router = VueRouter.createRouter({
  history: VueRouter.createWebHashHistory(),
  routes: routes,
})
