package com.drexel.gists.service;

import java.util.List;

import com.drexel.gists.model.Contributor;
import com.drexel.gists.model.GitHubUser;
import com.drexel.gists.model.GithubBranch;
import com.drexel.gists.model.GithubRepository;
import com.drexel.gists.model.Owner;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * @author rkasar422
 *
 */
public interface RepositoryInterface {

	@GET("user/repos")
	Call<List<GithubRepository>> listRepos(@Header("Authorization") String accessToken,
			@Header("Accept") String apiVersionSpec);

	@GET("repos/{owner}/{reponame}/branches")
	Call<List<GithubBranch>> branches(@Path("owner") String owner, @Path("reponame") String reponame);

	@GET("users/{username}/gists")
	Call<List<GithubRepository>> gists(@Path("username") String username);

	@GET("orgs/{org}/members")
	Call<List<GitHubUser>> getOrganizationMembers(@Path("org") String org);

	@GET("users/{user}")
	Call<Owner> getUser(@Path("user") String user);

	@GET("/repos/{owner}/{reponame}/contributors")
	Call<List<Contributor>> contributors(@Path("owner") String owner, @Path("reponame") String reponame);

	@GET("user")
	Call<Owner> username(@Header("Authorization") String accessToken, @Header("Accept") String apiVersionSpec);

}
