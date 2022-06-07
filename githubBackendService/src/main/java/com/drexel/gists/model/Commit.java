package com.drexel.gists.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Commit {
	private String sha;
	private String url;

}
