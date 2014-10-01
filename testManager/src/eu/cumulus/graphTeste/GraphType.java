//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2014.07.29 alle 05:38:26 PM CEST 
//


package eu.cumulus.graphTeste;

import java.math.BigInteger;
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
 *       Complex type for the <graph> element.
 *     
 * 
 * <p>Classe Java per graph.type complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="graph.type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://graphml.graphdrawing.org/xmlns}desc" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;choice maxOccurs="unbounded" minOccurs="0">
 *               &lt;element ref="{http://graphml.graphdrawing.org/xmlns}data"/>
 *               &lt;element ref="{http://graphml.graphdrawing.org/xmlns}node"/>
 *               &lt;element ref="{http://graphml.graphdrawing.org/xmlns}edge"/>
 *               &lt;element ref="{http://graphml.graphdrawing.org/xmlns}hyperedge"/>
 *             &lt;/choice>
 *           &lt;/sequence>
 *           &lt;element ref="{http://graphml.graphdrawing.org/xmlns}locator"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://graphml.graphdrawing.org/xmlns}graph.extra.attrib"/>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="edgedefault" use="required" type="{http://graphml.graphdrawing.org/xmlns}graph.edgedefault.type" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "graph.type", propOrder = {
    "desc",
    "dataOrNodeOrEdge",
    "locator"
})
public class GraphType {

    protected String desc;
    @XmlElements({
        @XmlElement(name = "data", type = DataType.class),
        @XmlElement(name = "node", type = NodeType.class),
        @XmlElement(name = "edge", type = EdgeType.class),
        @XmlElement(name = "hyperedge", type = HyperedgeType.class)
    })
    protected List<Object> dataOrNodeOrEdge;
    protected LocatorType locator;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String id;
    @XmlAttribute(name = "edgedefault", required = true)
    protected GraphEdgedefaultType edgedefault;
    @XmlAttribute(name = "parse.nodeids")
    protected GraphNodeidsType parseNodeids;
    @XmlAttribute(name = "parse.edgeids")
    protected GraphEdgeidsType parseEdgeids;
    @XmlAttribute(name = "parse.order")
    protected GraphOrderType parseOrder;
    @XmlAttribute(name = "parse.nodes")
    protected BigInteger parseNodes;
    @XmlAttribute(name = "parse.edges")
    protected BigInteger parseEdges;
    @XmlAttribute(name = "parse.maxindegree")
    protected BigInteger parseMaxindegree;
    @XmlAttribute(name = "parse.maxoutdegree")
    protected BigInteger parseMaxoutdegree;

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
     * Gets the value of the dataOrNodeOrEdge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataOrNodeOrEdge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataOrNodeOrEdge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataType }
     * {@link NodeType }
     * {@link EdgeType }
     * {@link HyperedgeType }
     * 
     * 
     */
    public List<Object> getDataOrNodeOrEdge() {
        if (dataOrNodeOrEdge == null) {
            dataOrNodeOrEdge = new ArrayList<Object>();
        }
        return this.dataOrNodeOrEdge;
    }

    /**
     * Recupera il valore della proprietà locator.
     * 
     * @return
     *     possible object is
     *     {@link LocatorType }
     *     
     */
    public LocatorType getLocator() {
        return locator;
    }

    /**
     * Imposta il valore della proprietà locator.
     * 
     * @param value
     *     allowed object is
     *     {@link LocatorType }
     *     
     */
    public void setLocator(LocatorType value) {
        this.locator = value;
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
     * Recupera il valore della proprietà edgedefault.
     * 
     * @return
     *     possible object is
     *     {@link GraphEdgedefaultType }
     *     
     */
    public GraphEdgedefaultType getEdgedefault() {
        return edgedefault;
    }

    /**
     * Imposta il valore della proprietà edgedefault.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphEdgedefaultType }
     *     
     */
    public void setEdgedefault(GraphEdgedefaultType value) {
        this.edgedefault = value;
    }

    /**
     * Recupera il valore della proprietà parseNodeids.
     * 
     * @return
     *     possible object is
     *     {@link GraphNodeidsType }
     *     
     */
    public GraphNodeidsType getParseNodeids() {
        return parseNodeids;
    }

    /**
     * Imposta il valore della proprietà parseNodeids.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphNodeidsType }
     *     
     */
    public void setParseNodeids(GraphNodeidsType value) {
        this.parseNodeids = value;
    }

    /**
     * Recupera il valore della proprietà parseEdgeids.
     * 
     * @return
     *     possible object is
     *     {@link GraphEdgeidsType }
     *     
     */
    public GraphEdgeidsType getParseEdgeids() {
        return parseEdgeids;
    }

    /**
     * Imposta il valore della proprietà parseEdgeids.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphEdgeidsType }
     *     
     */
    public void setParseEdgeids(GraphEdgeidsType value) {
        this.parseEdgeids = value;
    }

    /**
     * Recupera il valore della proprietà parseOrder.
     * 
     * @return
     *     possible object is
     *     {@link GraphOrderType }
     *     
     */
    public GraphOrderType getParseOrder() {
        return parseOrder;
    }

    /**
     * Imposta il valore della proprietà parseOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphOrderType }
     *     
     */
    public void setParseOrder(GraphOrderType value) {
        this.parseOrder = value;
    }

    /**
     * Recupera il valore della proprietà parseNodes.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getParseNodes() {
        return parseNodes;
    }

    /**
     * Imposta il valore della proprietà parseNodes.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setParseNodes(BigInteger value) {
        this.parseNodes = value;
    }

    /**
     * Recupera il valore della proprietà parseEdges.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getParseEdges() {
        return parseEdges;
    }

    /**
     * Imposta il valore della proprietà parseEdges.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setParseEdges(BigInteger value) {
        this.parseEdges = value;
    }

    /**
     * Recupera il valore della proprietà parseMaxindegree.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getParseMaxindegree() {
        return parseMaxindegree;
    }

    /**
     * Imposta il valore della proprietà parseMaxindegree.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setParseMaxindegree(BigInteger value) {
        this.parseMaxindegree = value;
    }

    /**
     * Recupera il valore della proprietà parseMaxoutdegree.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getParseMaxoutdegree() {
        return parseMaxoutdegree;
    }

    /**
     * Imposta il valore della proprietà parseMaxoutdegree.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setParseMaxoutdegree(BigInteger value) {
        this.parseMaxoutdegree = value;
    }

}
