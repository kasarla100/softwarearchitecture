<template>
  <div>
    <div>
      <p><b>Git URL:</b><a :href="urlLink">{{ urlLink }}</a></p>
      <div>
        <p><b>Description:</b> {{ desc }}</p>
        <p><b>Language:</b> {{ language }}</p>
        <p><b>Repo URL:</b> {{ htmlUrl }}</p>
      </div>
      <div>
        <span v-for="tag in tags" v-bind:key="tag">{{ tag }} </span>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: 'GithubItem',
  props: {
    name: String,
    urlLink: String,
    desc: String,
    language: String,
    tags:String

  }
}
</script>

<style>
.item-image {
  width: 300px;
}
</style>
