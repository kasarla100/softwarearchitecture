<template>
  <div v-if="isLoading === true">
    Loading...
  </div>
  <div v-if="hasError === true">
    Error
  </div>
  <div v-else>
    <ul>
      <div class="col" v-for="project in data" v-bind:key="project.id">
        <li><a :href="project.html_url">{{ project.name }}</a></li>
      </div>
    </ul>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'GithubReposContainer',
  data() {
    return {
      data: null,
      isLoading: true,
      hasError: false
    }
  },
  mounted() {
    axios
      .get('http://localhost:5000/repos')
      .then(response => (
        this.data = response.data
      ))
      .catch(error => {
        console.log(error)
        this.hasError = true
      })
      .finally(() => this.isLoading = false)
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
