package com.drexel.gists.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * @author rkasar422
 *
 */
@Data
public class Status {

	@SerializedName("status")
	@Expose
	private String status;

	public Status(String stat) {
		this.status = stat;
	}

}
