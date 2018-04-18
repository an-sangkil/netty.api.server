package com.mezzomedia.core.model.domain.ads;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@XmlRootElement(name="AdSystem")
public class AdSystem {
	
	public AdSystem() {}
	public AdSystem(String version, String value) {
		this.version =version;
		this.value   = value;
	}

	@JacksonXmlProperty(isAttribute=true)
	public String version;
	
	@JacksonXmlText
	public String value;

}
