package com.mezzomedia.core.model.dto.audience;

import java.util.Map;

import org.springframework.data.annotation.Id;

public class Audience {
	
	@Id
	private String adid;
	private Category category;
	private Retarget retarget;
	private ADIDTarget adidTarget;
	private int optYn;
	private Map<String,String> frequency;
	
	
	public String getAdid() {
		return adid;
	}
	public void setAdid(String adid) {
		this.adid = adid;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Retarget getRetarget() {
		return retarget;
	}
	public void setRetarget(Retarget retarget) {
		this.retarget = retarget;
	}
	public ADIDTarget getAdidTarget() {
		return adidTarget;
	}
	public void setAdidTarget(ADIDTarget adidTarget) {
		this.adidTarget = adidTarget;
	}
	public int getOptYn() {
		return optYn;
	}
	public void setOptYn(int optYn) {
		this.optYn = optYn;
	}
	public Map<String, String> getFrequency() {
		return frequency;
	}
	public void setFrequency(Map<String, String> frequency) {
		this.frequency = frequency;
	}
	
}
