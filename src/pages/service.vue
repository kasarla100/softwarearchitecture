<template>
  <div class="service">
    <h2>{{ msg }}}}</h2>

    <button @click="callRepoApi()">repo details</button>

    <h4>{{ backendResponse }}</h4>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import api from '../api/backend-api';
import { AxiosError } from 'axios';
interface State {
  msg: string;
  backendResponse: string;
  errors: AxiosError[];
}
export default defineComponent({
  name: 'Service-repo',
  data: (): State => {
    return {
      msg: 'Repo details:',
      backendResponse: '',
      errors: [],
    };
  },
  methods: {
    // Fetches posts when the component is created.
    callRepoApi() {
      api.getRepos();
    },
  },
});
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
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
