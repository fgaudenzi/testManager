//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2014.07.10 alle 07:00:30 PM CEST 
//


package org.cumulus.certificate.certificate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per CertificateType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="CertificateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CertificateId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CertificationModelId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CertifiedSecurityProperty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CertificateInfo" type="{}certificateInfoType"/>
 *         &lt;element name="CertificationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="CertificateStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Artifacts" type="{}Artifacts"/>
 *         &lt;element name="Signature" type="{}signatureType"/>
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
@XmlType(name = "CertificateType", propOrder = {
    "certificateId",
    "certificationModelId",
    "certifiedSecurityProperty",
    "certificateInfo",
    "certificationDate",
    "certificateStatus",
    "expirationDate",
    "artifacts",
    "signature"
})
public class CertificateType {

    @XmlElement(name = "CertificateId", required = true)
    protected String certificateId;
    @XmlElement(name = "CertificationModelId", required = true)
    protected String certificationModelId;
    @XmlElement(name = "CertifiedSecurityProperty", required = true)
    protected String certifiedSecurityProperty;
    @XmlElement(name = "CertificateInfo", required = true)
    protected CertificateInfoType certificateInfo;
    @XmlElement(name = "CertificationDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar certificationDate;
    @XmlElement(name = "CertificateStatus", required = true)
    protected String certificateStatus;
    @XmlElement(name = "ExpirationDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationDate;
    @XmlElement(name = "Artifacts", required = true)
    protected Artifacts artifacts;
    @XmlElement(name = "Signature", required = true)
    protected SignatureType signature;

    /**
     * Recupera il valore della proprietà certificateId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateId() {
        return certificateId;
    }

    /**
     * Imposta il valore della proprietà certificateId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateId(String value) {
        this.certificateId = value;
    }

    /**
     * Recupera il valore della proprietà certificationModelId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificationModelId() {
        return certificationModelId;
    }

    /**
     * Imposta il valore della proprietà certificationModelId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificationModelId(String value) {
        this.certificationModelId = value;
    }

    /**
     * Recupera il valore della proprietà certifiedSecurityProperty.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertifiedSecurityProperty() {
        return certifiedSecurityProperty;
    }

    /**
     * Imposta il valore della proprietà certifiedSecurityProperty.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertifiedSecurityProperty(String value) {
        this.certifiedSecurityProperty = value;
    }

    /**
     * Recupera il valore della proprietà certificateInfo.
     * 
     * @return
     *     possible object is
     *     {@link CertificateInfoType }
     *     
     */
    public CertificateInfoType getCertificateInfo() {
        return certificateInfo;
    }

    /**
     * Imposta il valore della proprietà certificateInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateInfoType }
     *     
     */
    public void setCertificateInfo(CertificateInfoType value) {
        this.certificateInfo = value;
    }

    /**
     * Recupera il valore della proprietà certificationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCertificationDate() {
        return certificationDate;
    }

    /**
     * Imposta il valore della proprietà certificationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCertificationDate(XMLGregorianCalendar value) {
        this.certificationDate = value;
    }

    /**
     * Recupera il valore della proprietà certificateStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateStatus() {
        return certificateStatus;
    }

    /**
     * Imposta il valore della proprietà certificateStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateStatus(String value) {
        this.certificateStatus = value;
    }

    /**
     * Recupera il valore della proprietà expirationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * Imposta il valore della proprietà expirationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDate(XMLGregorianCalendar value) {
        this.expirationDate = value;
    }

    /**
     * Recupera il valore della proprietà artifacts.
     * 
     * @return
     *     possible object is
     *     {@link Artifacts }
     *     
     */
    public Artifacts getArtifacts() {
        return artifacts;
    }

    /**
     * Imposta il valore della proprietà artifacts.
     * 
     * @param value
     *     allowed object is
     *     {@link Artifacts }
     *     
     */
    public void setArtifacts(Artifacts value) {
        this.artifacts = value;
    }

    /**
     * Recupera il valore della proprietà signature.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Imposta il valore della proprietà signature.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
    }

}
