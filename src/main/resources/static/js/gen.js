const gen = {
  data() {
    return {
      titleText: "We Are Generating Your Travel Plan…",
      img: {
        src: "img/gen_people_waiting.png",
        styles: {
          "max-height": "40vh",
          "max-width": "100%",
        }
      },
    }
  },
  props: ["options"],
  methods: {
    getPlan() {
      const options = JSON.parse(this.options)
      let url = "/api/plan?"

      options.forEach((opt) => {
        url += opt.name + "=" + opt.val + "&"
      })

      // Remove trailing `&`
      url = url.slice(0, -1)

      fetch(url, {
        method: "GET",
        headers: {
          "Accept": "application/json",
        },
      }).then((resp) => resp.json())
        .then((data) => {
          this.$router.push({
            name: "destlist",
            params: {
              dests: JSON.stringify(data.destinations),
            },
          })
        })
        .catch(console.error)
    }
  },
  template: `
  <div>
    <div class="row justify-content-center">
      <div class="col-12 text-center">
        <h1>{{ titleText }}</h1>
      </div>
      <div class="col-12 col-lg-6 m-4 p-4 bg-white text-center rounded shadow">
        <img :src="img.src" :style="img.styles" @load="getPlan()">
      </div>
    </div>
  </div>`
}
