//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2014.07.10 alle 07:00:30 PM CEST 
//


package back.org.cumulus.certificate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Artifacts complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Artifacts">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Test-Artifact" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="Monitor-Artifact" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="TPM-Artificat" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Artifacts", propOrder = {
    "testArtifact",
    "monitorArtifact",
    "tpmArtificat"
})
public class Artifacts {

    @XmlElement(name = "Test-Artifact")
    protected Object testArtifact;
    @XmlElement(name = "Monitor-Artifact")
    protected Object monitorArtifact;
    @XmlElement(name = "TPM-Artificat")
    protected Object tpmArtificat;

    /**
     * Recupera il valore della proprietà testArtifact.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTestArtifact() {
        return testArtifact;
    }

    /**
     * Imposta il valore della proprietà testArtifact.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTestArtifact(Object value) {
        this.testArtifact = value;
    }

    /**
     * Recupera il valore della proprietà monitorArtifact.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getMonitorArtifact() {
        return monitorArtifact;
    }

    /**
     * Imposta il valore della proprietà monitorArtifact.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setMonitorArtifact(Object value) {
        this.monitorArtifact = value;
    }

    /**
     * Recupera il valore della proprietà tpmArtificat.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTPMArtificat() {
        return tpmArtificat;
    }

    /**
     * Imposta il valore della proprietà tpmArtificat.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTPMArtificat(Object value) {
        this.tpmArtificat = value;
    }

}
