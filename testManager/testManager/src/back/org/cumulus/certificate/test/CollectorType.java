//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2014.07.08 alle 10:57:54 AM CEST 
//


package back.org.cumulus.certificate.test;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per CollectorType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="CollectorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AbstractCollector" type="{http://www.cumulus.org/certificate/model/test}AbstracCollectorType" maxOccurs="unbounded"/>
 *         &lt;element name="Collector" type="{http://www.cumulus.org/certificate/model/test}GeneralCollectorType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CollectorType", propOrder = {
    "abstractCollector",
    "collector"
})
public class CollectorType {

    @XmlElement(name = "AbstractCollector", required = true)
    protected List<AbstracCollectorType> abstractCollector;
    @XmlElement(name = "Collector", required = true)
    protected List<GeneralCollectorType> collector;

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

}
