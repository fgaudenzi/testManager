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
 * <p>Classe Java per graph.edgeids.type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="graph.edgeids.type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="canonical"/>
 *     &lt;enumeration value="free"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "graph.edgeids.type")
@XmlEnum
public enum GraphEdgeidsType {

    @XmlEnumValue("canonical")
    CANONICAL("canonical"),
    @XmlEnumValue("free")
    FREE("free");
    private final String value;

    GraphEdgeidsType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GraphEdgeidsType fromValue(String v) {
        for (GraphEdgeidsType c: GraphEdgeidsType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
