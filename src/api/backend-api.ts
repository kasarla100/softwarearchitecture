import axios, { AxiosResponse } from 'axios';

const axiosApi = axios.create({
  baseURL: '/api',
  timeout: 1000,
  headers: { 'Content-Type': 'application/json' },
});

interface Repo {
  branchName: string;
  url: string;
}

export default {
  getRepos(): Repo {
    return {
      branchName: 'Proj-release-2',
      url: 'https://github.com/kasarla100/softwarearchitecture/tree/proj-release-2',
    };
  },
};
