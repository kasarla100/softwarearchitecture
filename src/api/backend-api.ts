interface Repo {
  branchName: string;
  url: string;
}

export default {
  getRepos(): Repo {
    return {
      branchName:'Proj-release-2',
      url:'https://github.com/kasarla100/softwarearchitecture/tree/proj-release-2'
    };
  },
};
