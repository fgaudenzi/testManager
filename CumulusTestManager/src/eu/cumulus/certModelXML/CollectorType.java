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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for collectorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="collectorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AbstractCollector" type="{}abstracCollectorType" maxOccurs="unbounded"/>
 *         &lt;element name="Collector" type="{}GeneralCollectorType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EventBusCollector" type="{}eventBusCollectorType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "collectorType", propOrder = {
    "abstractCollector",
    "collector",
    "eventBusCollector"
})
public class CollectorType {

    @XmlElement(name = "AbstractCollector", required = true)
    protected List<AbstracCollectorType> abstractCollector;
    @XmlElement(name = "Collector")
    protected List<GeneralCollectorType> collector;
    @XmlElement(name = "EventBusCollector")
    protected EventBusCollectorType eventBusCollector;

    /**
     * Gets the value of the abstractCollector property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractCollector property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractCollector().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstracCollectorType }
     * 
     * 
     */
    public List<AbstracCollectorType> getAbstractCollector() {
        if (abstractCollector == null) {
            abstractCollector = new ArrayList<AbstracCollectorType>();
        }
        return this.abstractCollector;
    }

    /**
     * Gets the value of the collector property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the collector property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCollector().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeneralCollectorType }
     * 
     * 
     */
    public List<GeneralCollectorType> getCollector() {
        if (collector == null) {
            collector = new ArrayList<GeneralCollectorType>();
        }
        return this.collector;
    }

    /**
     * Gets the value of the eventBusCollector property.
     * 
     * @return
     *     possible object is
     *     {@link EventBusCollectorType }
     *     
     */
    public EventBusCollectorType getEventBusCollector() {
        return eventBusCollector;
    }

    /**
     * Sets the value of the eventBusCollector property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventBusCollectorType }
     *     
     */
    public void setEventBusCollector(EventBusCollectorType value) {
        this.eventBusCollector = value;
    }

}
