//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.14 at 11:38:52 AM CEST 
//


package eu.cumulus.certModelXML;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for testBasedCertificationModelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="testBasedCertificationModelType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CertificationModelId" type="{}certificationModelType"/>
 *         &lt;element name="Collectors" type="{}collectorType"/>
 *         &lt;element name="LifeCycle" type="{}lifeCycleType"/>
 *         &lt;element name="Toc" type="{}tocType"/>
 *         &lt;element name="TestedSecurityProperty" type="{}securityPropertyType"/>
 *         &lt;element name="Tester" type="{}testerType"/>
 *         &lt;element name="Context">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{}contextType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="Agent" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
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
@XmlType(name = "testBasedCertificationModelType", propOrder = {
    "certificationModelId",
    "collectors",
    "lifeCycle",
    "toc",
    "testedSecurityProperty",
    "tester",
    "context"
})
public class TestBasedCertificationModelType {

    @XmlElement(name = "CertificationModelId", required = true)
    protected CertificationModelType certificationModelId;
    @XmlElement(name = "Collectors", required = true)
    protected CollectorType collectors;
    @XmlElement(name = "LifeCycle", required = true)
    protected LifeCycleType lifeCycle;
    @XmlElement(name = "Toc", required = true)
    protected TocType toc;
    @XmlElement(name = "TestedSecurityProperty", required = true)
    protected SecurityPropertyType testedSecurityProperty;
    @XmlElement(name = "Tester", required = true)
    protected TesterType tester;
    @XmlElement(name = "Context", required = true)
    protected TestBasedCertificationModelType.Context context;

    /**
     * Gets the value of the certificationModelId property.
     * 
     * @return
     *     possible object is
     *     {@link CertificationModelType }
     *     
     */
    public CertificationModelType getCertificationModelId() {
        return certificationModelId;
    }

    /**
     * Sets the value of the certificationModelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificationModelType }
     *     
     */
    public void setCertificationModelId(CertificationModelType value) {
        this.certificationModelId = value;
    }

    /**
     * Gets the value of the collectors property.
     * 
     * @return
     *     possible object is
     *     {@link CollectorType }
     *     
     */
    public CollectorType getCollectors() {
        return collectors;
    }

    /**
     * Sets the value of the collectors property.
     * 
     * @param value
     *     allowed object is
     *     {@link CollectorType }
     *     
     */
    public void setCollectors(CollectorType value) {
        this.collectors = value;
    }

    /**
     * Gets the value of the lifeCycle property.
     * 
     * @return
     *     possible object is
     *     {@link LifeCycleType }
     *     
     */
    public LifeCycleType getLifeCycle() {
        return lifeCycle;
    }

    /**
     * Sets the value of the lifeCycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link LifeCycleType }
     *     
     */
    public void setLifeCycle(LifeCycleType value) {
        this.lifeCycle = value;
    }

    /**
     * Gets the value of the toc property.
     * 
     * @return
     *     possible object is
     *     {@link TocType }
     *     
     */
    public TocType getToc() {
        return toc;
    }

    /**
     * Sets the value of the toc property.
     * 
     * @param value
     *     allowed object is
     *     {@link TocType }
     *     
     */
    public void setToc(TocType value) {
        this.toc = value;
    }

    /**
     * Gets the value of the testedSecurityProperty property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityPropertyType }
     *     
     */
    public SecurityPropertyType getTestedSecurityProperty() {
        return testedSecurityProperty;
    }

    /**
     * Sets the value of the testedSecurityProperty property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityPropertyType }
     *     
     */
    public void setTestedSecurityProperty(SecurityPropertyType value) {
        this.testedSecurityProperty = value;
    }

    /**
     * Gets the value of the tester property.
     * 
     * @return
     *     possible object is
     *     {@link TesterType }
     *     
     */
    public TesterType getTester() {
        return tester;
    }

    /**
     * Sets the value of the tester property.
     * 
     * @param value
     *     allowed object is
     *     {@link TesterType }
     *     
     */
    public void setTester(TesterType value) {
        this.tester = value;
    }

    /**
     * Gets the value of the context property.
     * 
     * @return
     *     possible object is
     *     {@link TestBasedCertificationModelType.Context }
     *     
     */
    public TestBasedCertificationModelType.Context getContext() {
        return context;
    }

    /**
     * Sets the value of the context property.
     * 
     * @param value
     *     allowed object is
     *     {@link TestBasedCertificationModelType.Context }
     *     
     */
    public void setContext(TestBasedCertificationModelType.Context value) {
        this.context = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{}contextType">
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element name="Agent" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "agent"
    })
    public static class Context
        extends ContextType
    {

        @XmlElement(name = "Agent", required = true)
        protected List<Object> agent;

        /**
         * Gets the value of the agent property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the agent property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAgent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * 
         * 
         */
        public List<Object> getAgent() {
            if (agent == null) {
                agent = new ArrayList<Object>();
            }
            return this.agent;
        }

    }

}
