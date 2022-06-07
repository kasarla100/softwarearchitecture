package com.drexel.gists;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.drexel.gists.model.User;
import com.drexel.gists.service.GitHubService;

/**
 * @author rkasar422
 *
 */
@SpringBootApplication
public class GithubClientApplication {
	@Autowired
	GitHubService gitHubService;

	public static void main(String[] args) {
		SpringApplication.run(GithubClientApplication.class, args);

	}

	@PostConstruct
	public void init() throws IOException {
		User.setUsername(gitHubService.username());
	}
}
