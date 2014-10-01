//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2014.07.29 alle 05:38:26 PM CEST 
//


package org.graphdrawing.graphml.xmlns;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *       Complex type for the <hyperedge> element.
 *     
 * 
 * <p>Classe Java per hyperedge.type complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="hyperedge.type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://graphml.graphdrawing.org/xmlns}desc" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{http://graphml.graphdrawing.org/xmlns}data"/>
 *           &lt;element ref="{http://graphml.graphdrawing.org/xmlns}endpoint"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://graphml.graphdrawing.org/xmlns}graph" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://graphml.graphdrawing.org/xmlns}hyperedge.extra.attrib"/>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hyperedge.type", propOrder = {
    "desc",
    "dataOrEndpoint",
    "graph"
})
public class HyperedgeType {

    protected String desc;
    @XmlElements({
        @XmlElement(name = "data", type = DataType.class),
        @XmlElement(name = "endpoint", type = EndpointType.class)
    })
    protected List<Object> dataOrEndpoint;
    protected GraphType graph;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String id;

    /**
     * Recupera il valore della proprietà desc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Imposta il valore della proprietà desc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Gets the value of the dataOrEndpoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataOrEndpoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataOrEndpoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataType }
     * {@link EndpointType }
     * 
     * 
     */
    public List<Object> getDataOrEndpoint() {
        if (dataOrEndpoint == null) {
            dataOrEndpoint = new ArrayList<Object>();
        }
        return this.dataOrEndpoint;
    }

    /**
     * Recupera il valore della proprietà graph.
     * 
     * @return
     *     possible object is
     *     {@link GraphType }
     *     
     */
    public GraphType getGraph() {
        return graph;
    }

    /**
     * Imposta il valore della proprietà graph.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphType }
     *     
     */
    public void setGraph(GraphType value) {
        this.graph = value;
    }

    /**
     * Recupera il valore della proprietà id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Imposta il valore della proprietà id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
