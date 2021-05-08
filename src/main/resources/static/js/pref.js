const pref = {
  data() {
    return {
      titleText: "Select Your Travel Preference",
      btnNextText: "Next",
      img: {
        src: "img/pref_checklist_boy.png",
        styles: {
          "max-height": "40vh",
        }
      },
      prefs: null,
    }
  },
  computed: {
    getAvailPrefs() {
      // No time left, hardcode
      if (!this.prefs)
        this.prefs = ["COVID-19", "Weather", "Travel", "Shopping"]

      return this.prefs
    }
  },
  methods: {
    routeToGen() {
      let options = []

      // Selections
      this.prefs.forEach((pref) => {
        if (document.getElementById(pref).checked) {
          options.push({name: pref, val: 1})
        }
      })

      // Dates
      options.push({name: "from", val: document.getElementById("date-from").value})
      options.push({name: "to", val: document.getElementById("date-to").value})

      this.$router.push({
        name: "gen",
        params: {
          options: JSON.stringify(options)
        }
      })
    }
  },
  template: `
    <div class="row g-3">
      <div class="col-12 text-center">
        <h1>{{ titleText }}</h1>
      </div>
      <div class="order-3 col-12 order-xl-1 col-xl-4 text-center">
        <img :src="img.src" :style="img.styles">
      </div>
      <div class="order-1 col-12 col-lg-6 order-xl-2 col-xl-4">
        <div class="card h-100 shadow rounded">
          <div class="card-body">
            <h5 class="card-title">Options</h5>
            <div v-for="pref in getAvailPrefs" class="m-3">
              <input type="checkbox" class="btn-check" :id="pref" autocomplete="off">
              <label class="btn btn-outline-primary w-100" :for="pref">{{ pref }}</label>
            </div>
          </div>
        </div>
      </div>
      <div class="order-2 col-12 col-lg-6 order-xl-3 col-xl-4">
        <div class="card h-100 shadow rounded">
          <div class="card-body">
            <h5 class="card-title">Date Range</h5>
            <div class="row m-3 g-3">
              <div class="col-12 col-lg-2">
                <label for="date-from">From</label>
              </div>
              <div class="col-12 col-lg-10">
                <input class="w-100" type="date" id="date-from">
              </div>
            </div>
            <div class="row m-3 g-3">
              <div class="col-12 col-lg-2">
                <label for="date-to">To</label>
              </div>
              <div class="col-12 col-lg-10">
                <input class="w-100" type="date" id="date-to">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="text-end mt-3">
      <button role="button" class="btn btn-primary shadow" @click="routeToGen">{{ btnNextText }}</button>
    </div>`
}
