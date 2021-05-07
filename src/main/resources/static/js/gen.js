const gen = {
  data() {
    return {
      titleText: "We Are Generating Your Travel Plan…",
      img: {
        src: "img/gen_people_waiting.png",
        styles: {
          "max-height": "40vh",
        }
      },
    }
  },
  template: `
  <div>
    <div class="row justify-content-center">
      <div class="col-12 text-center">
        <h1>{{ titleText }}</h1>
      </div>
      <div class="col-12 col-lg-6 m-4 p-4 bg-white text-center rounded shadow">
        <img :src="img.src" :style="img.styles">
      </div>
    </div>
    <div class="text-end">
      <router-link to="/destlist">Next (Debug)</router-link>
    </div>
  </div>`
}
