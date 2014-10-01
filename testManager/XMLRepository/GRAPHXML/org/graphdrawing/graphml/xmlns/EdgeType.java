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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *       Complex type for the <edge> element.
 *     
 * 
 * <p>Classe Java per edge.type complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="edge.type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://graphml.graphdrawing.org/xmlns}desc" minOccurs="0"/>
 *         &lt;element ref="{http://graphml.graphdrawing.org/xmlns}data" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://graphml.graphdrawing.org/xmlns}graph" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://graphml.graphdrawing.org/xmlns}edge.extra.attrib"/>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="directed" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="source" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="sourceport" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="targetport" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "edge.type", propOrder = {
    "desc",
    "data",
    "graph"
})
public class EdgeType {

    protected String desc;
    protected List<DataType> data;
    protected GraphType graph;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String id;
    @XmlAttribute(name = "directed")
    protected Boolean directed;
    @XmlAttribute(name = "source", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String source;
    @XmlAttribute(name = "target", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String target;
    @XmlAttribute(name = "sourceport")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String sourceport;
    @XmlAttribute(name = "targetport")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String targetport;

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
     * Gets the value of the data property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the data property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataType }
     * 
     * 
     */
    public List<DataType> getData() {
        if (data == null) {
            data = new ArrayList<DataType>();
        }
        return this.data;
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

    /**
     * Recupera il valore della proprietà directed.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDirected() {
        return directed;
    }

    /**
     * Imposta il valore della proprietà directed.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDirected(Boolean value) {
        this.directed = value;
    }

    /**
     * Recupera il valore della proprietà source.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Imposta il valore della proprietà source.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Recupera il valore della proprietà target.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarget() {
        return target;
    }

    /**
     * Imposta il valore della proprietà target.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarget(String value) {
        this.target = value;
    }

    /**
     * Recupera il valore della proprietà sourceport.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceport() {
        return sourceport;
    }

    /**
     * Imposta il valore della proprietà sourceport.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceport(String value) {
        this.sourceport = value;
    }

    /**
     * Recupera il valore della proprietà targetport.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetport() {
        return targetport;
    }

    /**
     * Imposta il valore della proprietà targetport.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetport(String value) {
        this.targetport = value;
    }

}
