Vue.createApp({
  components: {
    navbar,
  },
  template: `
    <navbar></navbar>
    <div class="container">
      <div id="card" class="m-4 p-5 rounded shadow">
        <router-view></router-view>
      </div>
    </div>`
}).use(router).mount("#app")
