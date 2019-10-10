package com.netty.api.core.model.domain.ads;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 
 * <pre>
 * Description : 광고 기본 모델
 * </pre>
 *
 * @author skan
 * @since 2018. 2. 21.
 * @version 
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class Advertisement {
	
	
	@XmlAttribute
	private String id;

	@XmlAttribute
	private String sequence;
	
	private InLine inline;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public InLine getInline() {
		return inline;
	}

	public void setInline(InLine inline) {
		this.inline = inline;
	}

	
	@XmlRootElement(name="inline" )
	@JsonPropertyOrder({ "adSystem", "adTitle" ,"impression" })
	public class InLine {
		
		
		//@XmlAttribute(name = "AdSystem", required=false)
		//@XmlID
		@XmlElement(name = "AdSystem" )
		private AdSystem adSystem;
		
		@JacksonXmlProperty(isAttribute=true , localName="AdSystem")
		public String version;
		
		@JacksonXmlProperty
		public String value;
		
		@XmlElement(name = "AdTitle" )
		@JacksonXmlCData
		private String adTitle;
		
		private String impression;
		
		@XmlElement(name = "Creatives")
		private Creative[] creatives;
		
		public AdSystem getAdSystem() {
			return adSystem;
		}
		public void setAdSystem(AdSystem adSystem) {
			this.adSystem = adSystem;
		}
		public String getAdTitle() {
			return adTitle;
		}
		public void setAdTitle(String adTitle) {
			this.adTitle = adTitle;
		}
		public String getImpression() {
			return impression;
		}
		public void setImpression(String impression) {
			this.impression = impression;
		}
		
	}
	
}
