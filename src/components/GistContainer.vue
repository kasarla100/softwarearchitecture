<template>
  <div v-if="hasError === true">Error</div>
  <div v-else>

    <ul>
      <div class="col" v-for="gist in data" v-bind:key="gist.id">
        <li><a :href="gist.html_url" target="_blank">{{ gist.description }}</a></li>
      </div>
    </ul>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'GithubGistsContainer',
  data() {
    return {
      data: null,
      hasError: false,
      userNameText: this.$route.query.username,
    }
  },
  methods:
  {
    getGistsFromGithub: function(userNameVal) {
      var userNameVal = userNameVal;
      axios
      .get('http://localhost:5000/gists')
      .then(response => (
        this.data = response.data
      ))
      .catch(error => {
        console.log(error)
        this.hasError = true
      })
      }
  },
  created: function(){
    var user = this.userNameText;
    if(user) {
      this.getGistsFromGithub(user)
    }
  }
}
</script>

<style>
.grid {
  display: flex;
}
.col {
  flex: 1;
}
</style>
