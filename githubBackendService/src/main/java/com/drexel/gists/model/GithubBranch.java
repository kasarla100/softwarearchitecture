package com.drexel.gists.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GithubBranch {
	private String name;
	private Commit commit;
	@JsonProperty("protected")
	private boolean protectedInfo;

}
