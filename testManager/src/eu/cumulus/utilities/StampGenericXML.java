package eu.cumulus.utilities;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class StampGenericXML {
	static public void staticStampGenericXML(Object objectJAXB, String context) {
		try {
			JAXBContext jaxbLocalContext = JAXBContext.newInstance(context);
			Marshaller marshaller = jaxbLocalContext.createMarshaller();
			marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(objectJAXB, System.out);
		} catch (JAXBException e1) {
			e1.printStackTrace();
		}
	}
}
