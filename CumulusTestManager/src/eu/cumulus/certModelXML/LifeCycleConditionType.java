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
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for lifeCycleConditionType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="lifeCycleConditionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="EvidenceIsValid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="EvidenceIsNotValid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="EvidenceIsQuestionable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ValidityPeriodExpired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lifeCycleConditionType", propOrder = { "evidenceIsValid",
		"evidenceIsNotValid", "evidenceIsQuestionable", "validityPeriodExpired" })
public class LifeCycleConditionType {

	@XmlElement(name = "EvidenceIsValid")
	protected Boolean evidenceIsValid;
	@XmlElement(name = "EvidenceIsNotValid")
	protected Boolean evidenceIsNotValid;
	@XmlElement(name = "EvidenceIsQuestionable")
	protected Boolean evidenceIsQuestionable;
	@XmlElement(name = "ValidityPeriodExpired")
	protected Boolean validityPeriodExpired;

	/**
	 * Gets the value of the evidenceIsValid property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isEvidenceIsValid() {
		return evidenceIsValid;
	}

	/**
	 * Sets the value of the evidenceIsValid property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setEvidenceIsValid(Boolean value) {
		this.evidenceIsValid = value;
	}

	/**
	 * Gets the value of the evidenceIsNotValid property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isEvidenceIsNotValid() {
		return evidenceIsNotValid;
	}

	/**
	 * Sets the value of the evidenceIsNotValid property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setEvidenceIsNotValid(Boolean value) {
		this.evidenceIsNotValid = value;
	}

	/**
	 * Gets the value of the evidenceIsQuestionable property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isEvidenceIsQuestionable() {
		return evidenceIsQuestionable;
	}

	/**
	 * Sets the value of the evidenceIsQuestionable property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setEvidenceIsQuestionable(Boolean value) {
		this.evidenceIsQuestionable = value;
	}

	/**
	 * Gets the value of the validityPeriodExpired property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isValidityPeriodExpired() {
		return validityPeriodExpired;
	}

	/**
	 * Sets the value of the validityPeriodExpired property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setValidityPeriodExpired(Boolean value) {
		this.validityPeriodExpired = value;
	}

}
