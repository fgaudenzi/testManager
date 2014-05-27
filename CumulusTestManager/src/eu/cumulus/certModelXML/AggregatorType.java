//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.14 at 11:38:52 AM CEST 
//


package eu.cumulus.certModelXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for aggregatorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="aggregatorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ModelLink" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="TestMetric" type="{}testMetricsType"/>
 *         &lt;element name="ElementForExtension" type="{}elementForExtensionType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AggregatorDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aggregatorType", propOrder = {
    "modelLink",
    "testMetric",
    "elementForExtension"
})
public class AggregatorType {

    @XmlElement(name = "ModelLink", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String modelLink;
    @XmlElement(name = "TestMetric", required = true)
    protected TestMetricsType testMetric;
    @XmlElement(name = "ElementForExtension", required = true)
    protected ElementForExtensionType elementForExtension;
    @XmlAttribute(name = "AggregatorDescription")
    protected String aggregatorDescription;

    /**
     * Gets the value of the modelLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelLink() {
        return modelLink;
    }

    /**
     * Sets the value of the modelLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelLink(String value) {
        this.modelLink = value;
    }

    /**
     * Gets the value of the testMetric property.
     * 
     * @return
     *     possible object is
     *     {@link TestMetricsType }
     *     
     */
    public TestMetricsType getTestMetric() {
        return testMetric;
    }

    /**
     * Sets the value of the testMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link TestMetricsType }
     *     
     */
    public void setTestMetric(TestMetricsType value) {
        this.testMetric = value;
    }

    /**
     * Gets the value of the elementForExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ElementForExtensionType }
     *     
     */
    public ElementForExtensionType getElementForExtension() {
        return elementForExtension;
    }

    /**
     * Sets the value of the elementForExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElementForExtensionType }
     *     
     */
    public void setElementForExtension(ElementForExtensionType value) {
        this.elementForExtension = value;
    }

    /**
     * Gets the value of the aggregatorDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAggregatorDescription() {
        return aggregatorDescription;
    }

    /**
     * Sets the value of the aggregatorDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAggregatorDescription(String value) {
        this.aggregatorDescription = value;
    }

}
