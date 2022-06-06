package com.drexel.gists.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.drexel.gists.model.GithubRepository;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class GitHubService {

	@Value("${accessToken}")
	private String accessToken;

	private Logger logger = LoggerFactory.getLogger(GitHubService.class);

	private RepositoryInterface service = null;

	public GitHubService() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
				.addConverterFactory(GsonConverterFactory.create()).build();

		service = retrofit.create(RepositoryInterface.class);
	}

	/**
	 * @return
	 * @throws IOException
	 */
	public List<GithubRepository> getRepos() throws IOException {
		Call<List<GithubRepository>> reposCall = service.listRepos("token " + accessToken, Constants.API_VERSION);

		Response<List<GithubRepository>> reposResponse = null;
		List<GithubRepository> repos = null;
		reposResponse = reposCall.execute();

		if (reposResponse.isSuccessful()) {
			repos = reposResponse.body();
			if (repos != null) {
				logger.info("web request to Github was successful");
			} else
				logger.info("Zero repositories found");
		} else {
			ResponseBody errorResponse = reposResponse.errorBody();
			if (errorResponse != null) {
				logger.warn(errorResponse.string());
			}
		}

		return repos;
	}

	/**
	 * @return
	 * @throws IOException
	 */
	public List<GithubRepository> getBranches() throws IOException {
		Call<List<GithubRepository>> reposCall = service.branches("token " + accessToken, Constants.API_VERSION);

		Response<List<GithubRepository>> reposResponse = null;
		List<GithubRepository> repos = null;
		reposResponse = reposCall.execute();

		if (reposResponse.isSuccessful()) {
			repos = reposResponse.body();
			if (repos != null) {
				logger.info("web request to Github was successful");
			} else
				logger.info("Zero repositories found");
		} else {
			ResponseBody errorResponse = reposResponse.errorBody();
			if (errorResponse != null) {
				logger.warn(errorResponse.string());
			}
		}

		return repos;
	}

	/**
	 * @return
	 * @throws IOException
	 */
	public List<GithubRepository> gists(String userName) throws IOException {
		Call<List<GithubRepository>> reposCall = service.gists("token " + accessToken, Constants.API_VERSION, userName);

		Response<List<GithubRepository>> reposResponse = null;
		List<GithubRepository> repos = null;
		reposResponse = reposCall.execute();

		if (reposResponse.isSuccessful()) {
			repos = reposResponse.body();
			if (repos != null) {
				logger.info("web request to Github was successful");
			} else
				logger.info("Zero repositories found");
		} else {
			ResponseBody errorResponse = reposResponse.errorBody();
			if (errorResponse != null) {
				logger.warn(errorResponse.string());
			}
		}

		return repos;
	}

}
