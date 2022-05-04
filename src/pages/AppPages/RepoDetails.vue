import data from "./assets/repos.yaml"
<template>
  <h4>repo details will go here</h4>

  <div class="collapse" id="collapseInnerResponseConfig">
    <div class="card card-body">Repos: {{ callRepoApi() }}</div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import api from '../../api/backend-api';

export default defineComponent({
  name: 'HomePage',
  methods: {
    callRepoApi(): any {
      api.getRepos;
    },
  },
});
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h4 {
  margin: 48px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
