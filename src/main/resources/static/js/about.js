const about = {
  data() {
    return {
      authors: [
        {name: "Foo"},
        {name: "Bar"},
        {name: "Baz"},
      ]
    }
  },
  template: `
  <h1>Authors</h1>
  <ul>
    <li v-for="author in authors">{{ author.name }}</li>
  </ul>
  <p>Illustrations are <a href="http://www.freepik.com">Designed by <i>Unspecified Author</i> / Freepik</a>.</p>`
}
