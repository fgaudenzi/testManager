package eu.cumulus.utilities;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * @author filippogaudenzi Return a String from XMLObject
 */
public class JaxbMarshal {
	String filePath;
	String context;
	JAXBContext jaxbContext;

	/**
	 * @param context
	 */
	public JaxbMarshal(String context) {
		// this.filePath=filePath;
		this.context = context;
		try {
			jaxbContext = JAXBContext.newInstance(context);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param object
	 * @return
	 */
	public String getMarshalledString(Object object) {
		Marshaller marshaller = null;
		try {
			marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					new Boolean(true));
			
			//TODO specify xml schema
			//marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://es.indra.transporte.configuration StationNetwork.xsd");
			ByteArrayOutputStream os = new ByteArrayOutputStream();

			marshaller.marshal(object, os);
			return os.toString();

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}