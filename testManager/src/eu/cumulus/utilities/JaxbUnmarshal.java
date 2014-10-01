package eu.cumulus.utilities;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/*
 * return root XMMLObject from String
 */
/**
 * @author filippogaudenzi
 * 
 */
public class JaxbUnmarshal {
	String XML;
	String context;
	JAXBContext jaxbContext;
	InputStream InpStr;

	/**
	 * @param XML
	 * @param context
	 */
	public JaxbUnmarshal(String XML, String context) {
		this.XML = XML;
		this.context = context;
		try {
			jaxbContext = JAXBContext.newInstance(context);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	public Object getUnmarshalledObject() {
		Unmarshaller unmarshaller = null;
		Object objectJAXB = null;
		try {
			unmarshaller = jaxbContext.createUnmarshaller();
			InputStream is = new ByteArrayInputStream(XML.getBytes());

			objectJAXB = unmarshaller.unmarshal(is);
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
		return objectJAXB;
	}
}