package com.mezzomedia.core.model.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@XmlRootElement(name="Creative")
public class Creative {
	
	@JacksonXmlProperty(isAttribute=true)
	public String id;
	@JacksonXmlProperty(isAttribute=true)
	public String sequence;
	
	@XmlElement
	public Linear linear;  

}
