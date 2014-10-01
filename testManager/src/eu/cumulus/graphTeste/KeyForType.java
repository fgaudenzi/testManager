//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2014.07.29 alle 05:38:26 PM CEST 
//


package eu.cumulus.graphTeste;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per key.for.type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="key.for.type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="all"/>
 *     &lt;enumeration value="graphml"/>
 *     &lt;enumeration value="graph"/>
 *     &lt;enumeration value="node"/>
 *     &lt;enumeration value="edge"/>
 *     &lt;enumeration value="hyperedge"/>
 *     &lt;enumeration value="port"/>
 *     &lt;enumeration value="endpoint"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "key.for.type")
@XmlEnum
public enum KeyForType {

    @XmlEnumValue("all")
    ALL("all"),
    @XmlEnumValue("graphml")
    GRAPHML("graphml"),
    @XmlEnumValue("graph")
    GRAPH("graph"),
    @XmlEnumValue("node")
    NODE("node"),
    @XmlEnumValue("edge")
    EDGE("edge"),
    @XmlEnumValue("hyperedge")
    HYPEREDGE("hyperedge"),
    @XmlEnumValue("port")
    PORT("port"),
    @XmlEnumValue("endpoint")
    ENDPOINT("endpoint");
    private final String value;

    KeyForType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static KeyForType fromValue(String v) {
        for (KeyForType c: KeyForType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
