package com.mezzomedia.core.model.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * <pre>
 * TODO : builder pattern 방식으로 VAST 모델이 생성 될 수 있도록 고민 해볼 필요 있음.
 * </pre> 
 *
 * @author skan
 * @since 2018. 2. 27.
 * @version 
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
@JacksonXmlRootElement(localName="VAST")
public class Vast {
	
	@XmlAttribute(name="version")
	private String version;
	
	@XmlElement(name="ad")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Advertisement> advertisement;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Advertisement> getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(List<Advertisement> advertisement) {
		this.advertisement = advertisement;
	}


}
