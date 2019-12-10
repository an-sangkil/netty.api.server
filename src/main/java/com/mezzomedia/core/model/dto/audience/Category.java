package com.mezzomedia.core.model.dto.audience;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
	
	@JsonProperty("cate_no")
	private List<String> categoryNo;

	public List<String> getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(List<String> categoryNo) {
		this.categoryNo = categoryNo;
	}
	
}
