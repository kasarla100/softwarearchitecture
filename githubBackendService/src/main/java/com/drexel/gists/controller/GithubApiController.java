package com.drexel.gists.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drexel.gists.model.GithubRepository;
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

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/branches")
	public List<GithubRepository> branches() throws IOException {
		return githubService.getRepos();
	}

}
