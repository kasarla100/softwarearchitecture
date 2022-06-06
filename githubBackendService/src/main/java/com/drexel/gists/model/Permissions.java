package com.drexel.gists.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * @author rkasar422
 *
 */
@Data
public class Permissions {

	@SerializedName("admin")
	@Expose
	private Boolean admin;
	@SerializedName("push")
	@Expose
	private Boolean push;
	@SerializedName("pull")
	@Expose
	private Boolean pull;

}