package com.mezzomedia.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

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
