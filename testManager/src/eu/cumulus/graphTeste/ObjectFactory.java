//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2014.07.29 alle 05:38:26 PM CEST 
//


package eu.cumulus.graphTeste;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.graphdrawing.graphml.xmlns package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Default_QNAME = new QName("http://graphml.graphdrawing.org/xmlns", "default");
    private final static QName _Edge_QNAME = new QName("http://graphml.graphdrawing.org/xmlns", "edge");
    private final static QName _Endpoint_QNAME = new QName("http://graphml.graphdrawing.org/xmlns", "endpoint");
    private final static QName _Node_QNAME = new QName("http://graphml.graphdrawing.org/xmlns", "node");
    private final static QName _Data_QNAME = new QName("http://graphml.graphdrawing.org/xmlns", "data");
    private final static QName _Port_QNAME = new QName("http://graphml.graphdrawing.org/xmlns", "port");
    private final static QName _Graphml_QNAME = new QName("http://graphml.graphdrawing.org/xmlns", "graphml");
    private final static QName _Key_QNAME = new QName("http://graphml.graphdrawing.org/xmlns", "key");
    private final static QName _Graph_QNAME = new QName("http://graphml.graphdrawing.org/xmlns", "graph");
    private final static QName _Desc_QNAME = new QName("http://graphml.graphdrawing.org/xmlns", "desc");
    private final static QName _Locator_QNAME = new QName("http://graphml.graphdrawing.org/xmlns", "locator");
    private final static QName _Hyperedge_QNAME = new QName("http://graphml.graphdrawing.org/xmlns", "hyperedge");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.graphdrawing.graphml.xmlns
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NodeType }
     * 
     */
    public NodeType createNodeType() {
        return new NodeType();
    }

    /**
     * Create an instance of {@link DefaultType }
     * 
     */
    public DefaultType createDefaultType() {
        return new DefaultType();
    }

    /**
     * Create an instance of {@link EdgeType }
     * 
     */
    public EdgeType createEdgeType() {
        return new EdgeType();
    }

    /**
     * Create an instance of {@link EndpointType }
     * 
     */
    public EndpointType createEndpointType() {
        return new EndpointType();
    }

    /**
     * Create an instance of {@link DataType }
     * 
     */
    public DataType createDataType() {
        return new DataType();
    }

    /**
     * Create an instance of {@link PortType }
     * 
     */
    public PortType createPortType() {
        return new PortType();
    }

    /**
     * Create an instance of {@link GraphmlType }
     * 
     */
    public GraphmlType createGraphmlType() {
        return new GraphmlType();
    }

    /**
     * Create an instance of {@link LocatorType }
     * 
     */
    public LocatorType createLocatorType() {
        return new LocatorType();
    }

    /**
     * Create an instance of {@link HyperedgeType }
     * 
     */
    public HyperedgeType createHyperedgeType() {
        return new HyperedgeType();
    }

    /**
     * Create an instance of {@link KeyType }
     * 
     */
    public KeyType createKeyType() {
        return new KeyType();
    }

    /**
     * Create an instance of {@link GraphType }
     * 
     */
    public GraphType createGraphType() {
        return new GraphType();
    }

    /**
     * Create an instance of {@link DataExtensionType }
     * 
     */
    public DataExtensionType createDataExtensionType() {
        return new DataExtensionType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DefaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://graphml.graphdrawing.org/xmlns", name = "default")
    public JAXBElement<DefaultType> createDefault(DefaultType value) {
        return new JAXBElement<DefaultType>(_Default_QNAME, DefaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EdgeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://graphml.graphdrawing.org/xmlns", name = "edge")
    public JAXBElement<EdgeType> createEdge(EdgeType value) {
        return new JAXBElement<EdgeType>(_Edge_QNAME, EdgeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EndpointType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://graphml.graphdrawing.org/xmlns", name = "endpoint")
    public JAXBElement<EndpointType> createEndpoint(EndpointType value) {
        return new JAXBElement<EndpointType>(_Endpoint_QNAME, EndpointType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://graphml.graphdrawing.org/xmlns", name = "node")
    public JAXBElement<NodeType> createNode(NodeType value) {
        return new JAXBElement<NodeType>(_Node_QNAME, NodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://graphml.graphdrawing.org/xmlns", name = "data")
    public JAXBElement<DataType> createData(DataType value) {
        return new JAXBElement<DataType>(_Data_QNAME, DataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://graphml.graphdrawing.org/xmlns", name = "port")
    public JAXBElement<PortType> createPort(PortType value) {
        return new JAXBElement<PortType>(_Port_QNAME, PortType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GraphmlType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://graphml.graphdrawing.org/xmlns", name = "graphml")
    public JAXBElement<GraphmlType> createGraphml(GraphmlType value) {
        return new JAXBElement<GraphmlType>(_Graphml_QNAME, GraphmlType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://graphml.graphdrawing.org/xmlns", name = "key")
    public JAXBElement<KeyType> createKey(KeyType value) {
        return new JAXBElement<KeyType>(_Key_QNAME, KeyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GraphType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://graphml.graphdrawing.org/xmlns", name = "graph")
    public JAXBElement<GraphType> createGraph(GraphType value) {
        return new JAXBElement<GraphType>(_Graph_QNAME, GraphType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://graphml.graphdrawing.org/xmlns", name = "desc")
    public JAXBElement<String> createDesc(String value) {
        return new JAXBElement<String>(_Desc_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocatorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://graphml.graphdrawing.org/xmlns", name = "locator")
    public JAXBElement<LocatorType> createLocator(LocatorType value) {
        return new JAXBElement<LocatorType>(_Locator_QNAME, LocatorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HyperedgeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://graphml.graphdrawing.org/xmlns", name = "hyperedge")
    public JAXBElement<HyperedgeType> createHyperedge(HyperedgeType value) {
        return new JAXBElement<HyperedgeType>(_Hyperedge_QNAME, HyperedgeType.class, null, value);
    }

}
