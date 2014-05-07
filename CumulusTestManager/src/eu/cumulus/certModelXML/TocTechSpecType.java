//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.06 at 01:56:53 PM CEST 
//


package eu.cumulus.certModelXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for tocTechSpecType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tocTechSpecType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TocVendor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TocRelease" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TocDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tocTechSpecType", propOrder = {
    "tocVendor",
    "tocRelease",
    "tocDate"
})
public class TocTechSpecType {

    @XmlElement(name = "TocVendor", required = true)
    protected String tocVendor;
    @XmlElement(name = "TocRelease", required = true)
    protected String tocRelease;
    @XmlElement(name = "TocDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar tocDate;

    /**
     * Gets the value of the tocVendor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTocVendor() {
        return tocVendor;
    }

    /**
     * Sets the value of the tocVendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTocVendor(String value) {
        this.tocVendor = value;
    }

    /**
     * Gets the value of the tocRelease property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTocRelease() {
        return tocRelease;
    }

    /**
     * Sets the value of the tocRelease property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTocRelease(String value) {
        this.tocRelease = value;
    }

    /**
     * Gets the value of the tocDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTocDate() {
        return tocDate;
    }

    /**
     * Sets the value of the tocDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTocDate(XMLGregorianCalendar value) {
        this.tocDate = value;
    }

}
