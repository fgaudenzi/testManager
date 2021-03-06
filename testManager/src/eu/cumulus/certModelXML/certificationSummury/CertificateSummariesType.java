//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.14 at 03:20:09 PM CEST 
//


package eu.cumulus.certModelXML.certificationSummury;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CertificateSummariesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CertificateSummariesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CertificateSummary" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="certificateSerialNo" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *                 &lt;attribute name="securityProperty" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="tocName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="status" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "CertificateSummariesType", propOrder = {
    "certificateSummary"
})
public class CertificateSummariesType {

    @XmlElement(name = "CertificateSummary", required = true)
    protected List<CertificateSummariesType.CertificateSummary> certificateSummary;

    /**
     * Gets the value of the certificateSummary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the certificateSummary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCertificateSummary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CertificateSummariesType.CertificateSummary }
     * 
     * 
     */
    public List<CertificateSummariesType.CertificateSummary> getCertificateSummary() {
        if (certificateSummary == null) {
            certificateSummary = new ArrayList<CertificateSummariesType.CertificateSummary>();
        }
        return this.certificateSummary;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="certificateSerialNo" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
     *       &lt;attribute name="securityProperty" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="tocName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="status" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CertificateSummary {

        @XmlAttribute(required = true)
        protected long certificateSerialNo;
        @XmlAttribute(required = true)
        protected String securityProperty;
        @XmlAttribute(required = true)
        protected String tocName;
        @XmlAttribute(required = true)
        protected String status;

        /**
         * Gets the value of the certificateSerialNo property.
         * 
         */
        public long getCertificateSerialNo() {
            return certificateSerialNo;
        }

        /**
         * Sets the value of the certificateSerialNo property.
         * 
         */
        public void setCertificateSerialNo(long value) {
            this.certificateSerialNo = value;
        }

        /**
         * Gets the value of the securityProperty property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSecurityProperty() {
            return securityProperty;
        }

        /**
         * Sets the value of the securityProperty property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSecurityProperty(String value) {
            this.securityProperty = value;
        }

        /**
         * Gets the value of the tocName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTocName() {
            return tocName;
        }

        /**
         * Sets the value of the tocName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTocName(String value) {
            this.tocName = value;
        }

        /**
         * Gets the value of the status property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatus() {
            return status;
        }

        /**
         * Sets the value of the status property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatus(String value) {
            this.status = value;
        }

    }

}
