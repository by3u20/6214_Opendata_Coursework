const about = {
  data() {
    return {
      authors: [
        {name: "Minyong Li"},
        {name: "Haoyu Wang"},
        {name: "Jiayi Xu"},
        {name: "Bin Ye"},
      ]
    }
  },
  template: `
  <h1>About the Application</h1>
  <p>Travel Designer can give you advice on your next travel destination. By selecting factors you care the most, you get a list of selected joyful destinations. Supported by a number of open data sources, Travel Designer cares your concerns by thinking beyond the data.</p>
  <h1>Authors</h1>
  <ul>
    <li v-for="author in authors">{{ author.name }}</li>
  </ul>
  <p>Illustrations are <a href="http://www.freepik.com">Designed by <i>Unspecified Author</i> / Freepik</a>.</p>`
}
