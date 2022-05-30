<template>
  <q-page class="flex flex-center">
    <div class="text-h6">
      <GithubReposContainer />
    </div>
  </q-page>

</template>

<script>
import { defineComponent } from 'vue'
import GithubReposContainer from '../../components/GithubReposContainer.vue'
export default defineComponent({
  name: 'RepoList',
  components: {
    GithubReposContainer,
  }
})
</script>
