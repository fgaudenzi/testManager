//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2014.09.15 alle 02:35:38 PM CEST 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="collector" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TestCases">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence maxOccurs="unbounded">
 *                             &lt;element name="TestCase" type="{}TestCaseType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="tot" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "collector"
})
@XmlRootElement(name = "cm")
public class Cm {

    protected List<Cm.Collector> collector;
    @XmlAttribute(name = "id")
    protected String id;

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
     * {@link Cm.Collector }
     * 
     * 
     */
    public List<Cm.Collector> getCollector() {
        if (collector == null) {
            collector = new ArrayList<Cm.Collector>();
        }
        return this.collector;
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
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="TestCases">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence maxOccurs="unbounded">
     *                   &lt;element name="TestCase" type="{}TestCaseType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="tot" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "testCases"
    })
    public static class Collector {

        @XmlElement(name = "TestCases", required = true)
        protected Cm.Collector.TestCases testCases;
        @XmlAttribute(name = "tot")
        protected String tot;
        @XmlAttribute(name = "id")
        protected String id;

        /**
         * Recupera il valore della proprietà testCases.
         * 
         * @return
         *     possible object is
         *     {@link Cm.Collector.TestCases }
         *     
         */
        public Cm.Collector.TestCases getTestCases() {
            return testCases;
        }

        /**
         * Imposta il valore della proprietà testCases.
         * 
         * @param value
         *     allowed object is
         *     {@link Cm.Collector.TestCases }
         *     
         */
        public void setTestCases(Cm.Collector.TestCases value) {
            this.testCases = value;
        }

        /**
         * Recupera il valore della proprietà tot.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTot() {
            return tot;
        }

        /**
         * Imposta il valore della proprietà tot.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTot(String value) {
            this.tot = value;
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
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence maxOccurs="unbounded">
         *         &lt;element name="TestCase" type="{}TestCaseType"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "testCase"
        })
        public static class TestCases {

            @XmlElement(name = "TestCase", required = true)
            protected List<TestCaseType> testCase;

            /**
             * Gets the value of the testCase property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the testCase property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTestCase().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TestCaseType }
             * 
             * 
             */
            public List<TestCaseType> getTestCase() {
                if (testCase == null) {
                    testCase = new ArrayList<TestCaseType>();
                }
                return this.testCase;
            }

        }

    }

}
