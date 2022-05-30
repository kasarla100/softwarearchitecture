package com.drexel.gists.service;

import java.util.List;

import com.drexel.gists.model.GithubRepository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * @author rkasar422
 *
 */
public interface RepositoryInterface {

	@GET("user/repos")
	Call<List<GithubRepository>> listRepos(@Header("Authorization") String accessToken,
			@Header("Accept") String apiVersionSpec);

	@GET("user/branches")
	Call<List<GithubRepository>> branches(@Header("Authorization") String accessToken,
			@Header("Accept") String apiVersionSpec);

}
