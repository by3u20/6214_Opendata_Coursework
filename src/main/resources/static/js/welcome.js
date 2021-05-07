const welcome = {
  data() {
    return {
      titleText: "At Anytime, To Anywhere, With a Happy Travel Plan",
      btnText: "GET STARTED",
      imgStyles: {
        "max-width": "100%",
      }
    }
  },
  template: `
    <div class="row justify-content-between">
      <div class="col-12 col-xl-6 mt-5 mb-5">
        <h1 class="display-4 mb-5">{{ titleText }}</h1>
        <router-link to="/pref" class="btn btn-primary" role="button">{{ btnText }}</router-link>
      </div>
      <div class="col-12 col-xl-6">
        <img src="img/welcome_people_travel.png" :style="imgStyles">
      </div>
    </div>`
}
