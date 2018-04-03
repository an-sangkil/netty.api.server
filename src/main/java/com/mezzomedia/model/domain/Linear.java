package com.mezzomedia.model.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Linear")
public class Linear {
	
	@XmlAttribute(name="Duration")
	public String duration;
	
	@XmlElement
	public TrackingEvent[] TrackingEvents;
}
