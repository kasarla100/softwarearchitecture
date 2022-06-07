<template>
  <div>
    <div>
      <p>
        <a :href="repoUrl">{{ repoUrl }}</a>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'BranchDetails',
  props: {
    branchName: String,
    repo: String,
    repoFullName: String
  },
  data() {
    return {
      repoUrl: 'https://github.com/' + this.repoFullName + '/tree/' + this.branchName
    }
  }
};
</script>
