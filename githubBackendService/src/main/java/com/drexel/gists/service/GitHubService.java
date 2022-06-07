package com.drexel.gists.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.drexel.gists.model.GithubBranch;
import com.drexel.gists.model.GithubRepository;
import com.drexel.gists.model.Owner;
import com.drexel.gists.model.User;

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
	public List<GithubBranch> getBranches(String reponame) throws IOException {
		Call<List<GithubBranch>> reposCall = service.branches(User.getUsername(), reponame);

		Response<List<GithubBranch>> reposResponse = null;
		List<GithubBranch> repos = null;
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
	public List<GithubRepository> gists() throws IOException {
		Call<List<GithubRepository>> reposCall = service.gists(User.getUsername());

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
	public Owner userInfo() throws IOException {
		Call<Owner> usersInfo = service.getUser(User.getUsername());

		Response<Owner> reposResponse = null;
		Owner gitHubUser = null;
		reposResponse = usersInfo.execute();

		if (reposResponse.isSuccessful()) {
			gitHubUser = reposResponse.body();
			if (gitHubUser != null) {
				logger.info("web request to Github was successful");
			} else
				logger.info("Zero users found");
		} else {
			ResponseBody errorResponse = reposResponse.errorBody();
			if (errorResponse != null) {
				logger.warn(errorResponse.string());
			}
		}

		return gitHubUser;
	}

	/**
	 * @return
	 * @throws IOException
	 */
	public String username() throws IOException {
		Call<Owner> userInfo = service.username("token " + accessToken, Constants.API_VERSION);
		Response<Owner> ownerResponse = userInfo.execute();
		return ownerResponse.body().getLogin();

	}

}
