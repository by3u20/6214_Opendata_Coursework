const destlist = {
  data() {
    return {
      titleText: "Here Is Your Destination List!",
      btnText: "Go Back",
      destsSorted: null,
    }
  },
  props: ["dests"],
  computed: {
    getDests() {
      if (!this.destsSorted)
        this.destsSorted = JSON.parse(this.dests).sort((d1, d2) => d1.rank - d2.rank)
      return this.destsSorted
    }
  },
  template: `
  <div class="row">
    <div class="col-12 text-center">
      <h1>{{ titleText }}</h1>
    </div>
    <div class="col-12">
      <div class="my-3 p-3 bg-light rounded shadow">

        <div class="row fs-5">
          <div class="col-12 col-xl-1"><b>Rank</b></div>
          <div class="col-12 col-xl-3"><b>Name</b></div>
          <div class="col-12 col-xl-2"><b>COVID-19 Index</b></div>
          <div class="col-12 col-xl-2"><b>Weather</b></div>
          <div class="col-12 col-xl-2"><b>Travel Index</b></div>
          <div class="col-12 col-xl-2"><b>Shopping Index</b></div>
        </div>

        <div v-for="dest in getDests" class="row fs-5">
          <div class="col-12 col-xl-1">{{ dest.rank }}</div>
          <div class="col-12 col-xl-3">{{ dest.name }}</div>
          <div class="col-12 col-xl-2">{{ dest.covid19 }}</div>
          <div class="col-12 col-xl-2">{{ dest.weather }}</div>
          <div class="col-12 col-xl-2">{{ dest.travel }}</div>
          <div class="col-12 col-xl-2">{{ dest.shopping }}</div>
        </div>

      </div>
    </div>
  </div>
  <div class="text-end">
    <router-link to="/" class="btn btn-primary">{{ btnText }}</router-link>
  </div>`
}
