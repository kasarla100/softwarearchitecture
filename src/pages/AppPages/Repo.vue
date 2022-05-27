<template>
  <div class="q-pa-md">
    <q-banner class="bg-primary text-white">
      <div class="text-h6">GitHub Repositories</div>
      {{ pathvar }}
    </q-banner>
    <div style="width: 60%; margin: 0px auto;font-weight:bold;" class="row">
      <q-table
        title="GitHub Repos Info"
        dense
        :rows="rows"
        :columns="columns"
        row-key="id"
      />
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'GitHubRepoComponent',
  setup() {
    return {
      pathvar: 'path of github repositores',
    };
  },
});
</script>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import axios from 'axios';
type rowType = {
  id: string;
  name: string;
  url: string;
  language: string;
  updated_at: string;
};
const columns = [
  { name: 'id', label: 'ID', align: 'left', field: 'id', sortable: true },
  { name: 'name', label: 'name', align: 'left', field: 'name', sortable: true },
  { name: 'url', label: 'URL', align: 'left', field: 'url', sortable: true },
  { name: 'language', label: 'Language', align: 'left', field: 'language' },
  { name: 'updated_at', label: 'Updated', align: 'left', field: 'updated_at' },
];
let rows = ref([] as rowType[]);
onMounted(async () => {
  const res = await axios.get('http://localhost:5000/repos');
  rows.value = [];
  const rList = res.data['repos'] as rowType[];
  const resList = rList.map((row) => {
    const mappedRow: rowType = {
      id: row.id,
      name: row.name,
      url: row.url,
      language: row.language,
      updated_at: row.updated_at,
    };
    return mappedRow;
  });
  console.log('DEBUG', resList);
  rows.value = resList;
});
</script>


<style scoped></style>
