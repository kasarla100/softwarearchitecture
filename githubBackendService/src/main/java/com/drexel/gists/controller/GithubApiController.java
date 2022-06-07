package com.drexel.gists.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.drexel.gists.model.GithubBranch;
import com.drexel.gists.model.GithubRepository;
import com.drexel.gists.model.Owner;
import com.drexel.gists.service.GitHubService;

/**
 * @author rkasar422
 *
 */
@RestController
public class GithubApiController {

	@Autowired
	private GitHubService githubService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/repos")
	public List<GithubRepository> repos() throws IOException {
		return githubService.getRepos();
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/branches/{reponame}")
	public List<GithubBranch> branches(@PathVariable String reponame) throws IOException {
		return githubService.getBranches(reponame);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/gists")
	public List<GithubRepository> gists() throws IOException {
		return githubService.gists();
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/userinfo")
	public Owner userInfo() throws IOException {
		return githubService.userInfo();
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/user")
	public String username() throws IOException {
		return githubService.username();
	}

}
