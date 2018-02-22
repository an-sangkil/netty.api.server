package com.mezzomedia.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mezzomedia.model.AdSystem;
import com.mezzomedia.model.Advertisement;
import com.mezzomedia.model.Advertisement.InLine;
import com.mezzomedia.model.Vast;
import com.mezzomedia.util.utils.xml.XmlUtils;

public class XmlConvertTest {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void xmlConvert() throws Exception {
		
		Vast vast = new Vast();
		vast.setVersion("3.0");
		
		List<Advertisement> advers = new ArrayList<>();
		Advertisement ad = new Advertisement();
		ad.setId("3242");
		ad.setSequence("1");
		
		Advertisement.InLine inline = ad.new InLine();
		inline.setAdSystem(new AdSystem("2","CAMP"));
		inline.setAdTitle("1140_3924_4923");
		inline.setImpression("http://");
		inline.version="2";
		inline.value="value2";
		ad.setInline(inline);
		
		advers.add(ad);
		
		ad = new Advertisement();
		ad.setId("1112");
		ad.setSequence("2");
		advers.add(ad);
		
		ad = new Advertisement();
		ad.setId("1113");
		ad.setSequence("3");
		advers.add(ad);
		
		vast.setAdvertisement(advers);
		String strXml = XmlUtils.convertJson(vast);
		
		logger.debug("strXml = {} ", strXml);
		XmlUtils.convertXML(ad);
		
	}
}
