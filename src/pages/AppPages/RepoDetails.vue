<template>
  <q-page class="flex flex-center">
    <div class="text-h6">
      <GithubProjectsContainer />
    </div>
  </q-page>
</template>

<script>
import { defineComponent } from 'vue'
import GithubProjectsContainer from '../../components/GithubProjectsContainer.vue'
export default defineComponent({
  name: 'RepoDetails',
  components: {
    GithubProjectsContainer,
  }
})
</script>
