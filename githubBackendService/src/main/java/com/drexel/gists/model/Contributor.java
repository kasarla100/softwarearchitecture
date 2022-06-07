package com.drexel.gists.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Contributor {
	private String login;
	private int contributions;
}
