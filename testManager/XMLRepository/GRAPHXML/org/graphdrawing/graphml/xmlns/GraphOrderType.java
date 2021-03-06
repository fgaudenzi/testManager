//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2014.07.29 alle 05:38:26 PM CEST 
//


package org.graphdrawing.graphml.xmlns;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per graph.order.type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="graph.order.type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="free"/>
 *     &lt;enumeration value="nodesfirst"/>
 *     &lt;enumeration value="adjacencylist"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "graph.order.type")
@XmlEnum
public enum GraphOrderType {

    @XmlEnumValue("free")
    FREE("free"),
    @XmlEnumValue("nodesfirst")
    NODESFIRST("nodesfirst"),
    @XmlEnumValue("adjacencylist")
    ADJACENCYLIST("adjacencylist");
    private final String value;

    GraphOrderType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GraphOrderType fromValue(String v) {
        for (GraphOrderType c: GraphOrderType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
