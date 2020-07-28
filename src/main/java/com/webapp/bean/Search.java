package com.webapp.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class Search {
	
	@NotEmpty(message="This field is required.")
	private String search;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
}
