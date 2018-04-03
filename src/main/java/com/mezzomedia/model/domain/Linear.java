package com.mezzomedia.model;

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
