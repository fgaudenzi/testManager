//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.08 at 02:07:54 PM CEST 
//

package eu.cumulus.certModelXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for actionabilityType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="actionabilityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Mechanism" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MechanismURI" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actionabilityType", propOrder = { "description", "mechanism",
		"mechanismURI" })
public class ActionabilityType {

	@XmlElement(name = "Description", required = true)
	protected String description;
	@XmlElement(name = "Mechanism", required = true)
	protected String mechanism;
	@XmlElement(name = "MechanismURI", required = true)
	@XmlSchemaType(name = "anyURI")
	protected String mechanismURI;

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the mechanism property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMechanism() {
		return mechanism;
	}

	/**
	 * Sets the value of the mechanism property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMechanism(String value) {
		this.mechanism = value;
	}

	/**
	 * Gets the value of the mechanismURI property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMechanismURI() {
		return mechanismURI;
	}

	/**
	 * Sets the value of the mechanismURI property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMechanismURI(String value) {
		this.mechanismURI = value;
	}

}
