//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.06 at 01:56:53 PM CEST 
//


package eu.cumulus.certModelXML;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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

    private final static QName _CapabilityTypeAttacker_QNAME = new QName("", "Attacker");
    private final static QName _CapabilityTypeAttackerCapabilities_QNAME = new QName("", "AttackerCapabilities");
    private final static QName _CapabilityTypeAttackName_QNAME = new QName("", "AttackName");
    private final static QName _TCHash_QNAME = new QName("", "TC_Hash");
    private final static QName _TestBasedCertificationModel_QNAME = new QName("", "TestBasedCertificationModel");
    private final static QName _TestedSecurityProperty_QNAME = new QName("", "TestedSecurityProperty");
    private final static QName _EventBusCollectorTypeEventId_QNAME = new QName("", "EventId");
    private final static QName _EventBusCollectorTypeEventCode_QNAME = new QName("", "EventCode");
    private final static QName _KeyInfoTypeRetrievalMethod_QNAME = new QName("", "RetrievalMethod");
    private final static QName _KeyInfoTypeSPKIData_QNAME = new QName("", "SPKIData");
    private final static QName _KeyInfoTypeKeyValue_QNAME = new QName("", "KeyValue");
    private final static QName _KeyInfoTypeX509Data_QNAME = new QName("", "X509Data");
    private final static QName _KeyInfoTypePGPData_QNAME = new QName("", "PGPData");
    private final static QName _KeyInfoTypeMgmtData_QNAME = new QName("", "MgmtData");
    private final static QName _KeyInfoTypeKeyName_QNAME = new QName("", "KeyName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TargetOfTestsType }
     * 
     */
    public TargetOfTestsType createTargetOfTestsType() {
        return new TargetOfTestsType();
    }

    /**
     * Create an instance of {@link AgentConfigurationType }
     * 
     */
    public AgentConfigurationType createAgentConfigurationType() {
        return new AgentConfigurationType();
    }

    /**
     * Create an instance of {@link TestInstanceType }
     * 
     */
    public TestInstanceType createTestInstanceType() {
        return new TestInstanceType();
    }

    /**
     * Create an instance of {@link LifeCycleConditionType }
     * 
     */
    public LifeCycleConditionType createLifeCycleConditionType() {
        return new LifeCycleConditionType();
    }

    /**
     * Create an instance of {@link CertificateInfoType }
     * 
     */
    public CertificateInfoType createCertificateInfoType() {
        return new CertificateInfoType();
    }

    /**
     * Create an instance of {@link LifeCycleStates }
     * 
     */
    public LifeCycleStates createLifeCycleStates() {
        return new LifeCycleStates();
    }

    /**
     * Create an instance of {@link ElementForExtensionType }
     * 
     */
    public ElementForExtensionType createElementForExtensionType() {
        return new ElementForExtensionType();
    }

    /**
     * Create an instance of {@link TestMetricsType }
     * 
     */
    public TestMetricsType createTestMetricsType() {
        return new TestMetricsType();
    }

    /**
     * Create an instance of {@link AggregatorType }
     * 
     */
    public AggregatorType createAggregatorType() {
        return new AggregatorType();
    }

    /**
     * Create an instance of {@link TotType }
     * 
     */
    public TotType createTotType() {
        return new TotType();
    }

    /**
     * Create an instance of {@link ThresholdTrafficType }
     * 
     */
    public ThresholdTrafficType createThresholdTrafficType() {
        return new ThresholdTrafficType();
    }

    /**
     * Create an instance of {@link AbstracCollectorType.TestCases }
     * 
     */
    public AbstracCollectorType.TestCases createAbstracCollectorTypeTestCases() {
        return new AbstracCollectorType.TestCases();
    }

    /**
     * Create an instance of {@link SingleLifeState }
     * 
     */
    public SingleLifeState createSingleLifeState() {
        return new SingleLifeState();
    }

    /**
     * Create an instance of {@link PropertyType }
     * 
     */
    public PropertyType createPropertyType() {
        return new PropertyType();
    }

    /**
     * Create an instance of {@link AbstracCollectorType }
     * 
     */
    public AbstracCollectorType createAbstracCollectorType() {
        return new AbstracCollectorType();
    }

    /**
     * Create an instance of {@link GeneralCollectorType }
     * 
     */
    public GeneralCollectorType createGeneralCollectorType() {
        return new GeneralCollectorType();
    }

    /**
     * Create an instance of {@link SignatureType.SignedInfo }
     * 
     */
    public SignatureType.SignedInfo createSignatureTypeSignedInfo() {
        return new SignatureType.SignedInfo();
    }

    /**
     * Create an instance of {@link TestAttributeType }
     * 
     */
    public TestAttributeType createTestAttributeType() {
        return new TestAttributeType();
    }

    /**
     * Create an instance of {@link EventType }
     * 
     */
    public EventType createEventType() {
        return new EventType();
    }

    /**
     * Create an instance of {@link CapabilityType.AttackerCapabilities }
     * 
     */
    public CapabilityType.AttackerCapabilities createCapabilityTypeAttackerCapabilities() {
        return new CapabilityType.AttackerCapabilities();
    }

    /**
     * Create an instance of {@link TestCaseType }
     * 
     */
    public TestCaseType createTestCaseType() {
        return new TestCaseType();
    }

    /**
     * Create an instance of {@link TestBasedCertificationModelType }
     * 
     */
    public TestBasedCertificationModelType createTestBasedCertificationModelType() {
        return new TestBasedCertificationModelType();
    }

    /**
     * Create an instance of {@link CollectorType }
     * 
     */
    public CollectorType createCollectorType() {
        return new CollectorType();
    }

    /**
     * Create an instance of {@link ContextType }
     * 
     */
    public ContextType createContextType() {
        return new ContextType();
    }

    /**
     * Create an instance of {@link PropertyType.PropertyParameterList }
     * 
     */
    public PropertyType.PropertyParameterList createPropertyTypePropertyParameterList() {
        return new PropertyType.PropertyParameterList();
    }

    /**
     * Create an instance of {@link TocTechSpecType }
     * 
     */
    public TocTechSpecType createTocTechSpecType() {
        return new TocTechSpecType();
    }

    /**
     * Create an instance of {@link TesterType }
     * 
     */
    public TesterType createTesterType() {
        return new TesterType();
    }

    /**
     * Create an instance of {@link PropertyType.PropertyPerformance }
     * 
     */
    public PropertyType.PropertyPerformance createPropertyTypePropertyPerformance() {
        return new PropertyType.PropertyPerformance();
    }

    /**
     * Create an instance of {@link PropertyType.PropertyPerformance.PropertyPerformanceRow.PropertyPerformanceCell }
     * 
     */
    public PropertyType.PropertyPerformance.PropertyPerformanceRow.PropertyPerformanceCell createPropertyTypePropertyPerformancePropertyPerformanceRowPropertyPerformanceCell() {
        return new PropertyType.PropertyPerformance.PropertyPerformanceRow.PropertyPerformanceCell();
    }

    /**
     * Create an instance of {@link AbstracCollectorType.TestAttributes }
     * 
     */
    public AbstracCollectorType.TestAttributes createAbstracCollectorTypeTestAttributes() {
        return new AbstracCollectorType.TestAttributes();
    }

    /**
     * Create an instance of {@link PropertyType.PropertyParameterList.PropertyParameter }
     * 
     */
    public PropertyType.PropertyParameterList.PropertyParameter createPropertyTypePropertyParameterListPropertyParameter() {
        return new PropertyType.PropertyParameterList.PropertyParameter();
    }

    /**
     * Create an instance of {@link PropertyType.PropertyPerformance.PropertyPerformanceRow }
     * 
     */
    public PropertyType.PropertyPerformance.PropertyPerformanceRow createPropertyTypePropertyPerformancePropertyPerformanceRow() {
        return new PropertyType.PropertyPerformance.PropertyPerformanceRow();
    }

    /**
     * Create an instance of {@link ConditionForSomministrationType }
     * 
     */
    public ConditionForSomministrationType createConditionForSomministrationType() {
        return new ConditionForSomministrationType();
    }

    /**
     * Create an instance of {@link SignatureType }
     * 
     */
    public SignatureType createSignatureType() {
        return new SignatureType();
    }

    /**
     * Create an instance of {@link LifeCycleTransitionType }
     * 
     */
    public LifeCycleTransitionType createLifeCycleTransitionType() {
        return new LifeCycleTransitionType();
    }

    /**
     * Create an instance of {@link CapabilityType }
     * 
     */
    public CapabilityType createCapabilityType() {
        return new CapabilityType();
    }

    /**
     * Create an instance of {@link SecurityPropertyType }
     * 
     */
    public SecurityPropertyType createSecurityPropertyType() {
        return new SecurityPropertyType();
    }

    /**
     * Create an instance of {@link EventBusCollectorType }
     * 
     */
    public EventBusCollectorType createEventBusCollectorType() {
        return new EventBusCollectorType();
    }

    /**
     * Create an instance of {@link ActionabilityType }
     * 
     */
    public ActionabilityType createActionabilityType() {
        return new ActionabilityType();
    }

    /**
     * Create an instance of {@link OperativeConditionsType }
     * 
     */
    public OperativeConditionsType createOperativeConditionsType() {
        return new OperativeConditionsType();
    }

    /**
     * Create an instance of {@link LifeCycleStateType }
     * 
     */
    public LifeCycleStateType createLifeCycleStateType() {
        return new LifeCycleStateType();
    }

    /**
     * Create an instance of {@link CertificationModelType }
     * 
     */
    public CertificationModelType createCertificationModelType() {
        return new CertificationModelType();
    }

    /**
     * Create an instance of {@link KeyInfoType }
     * 
     */
    public KeyInfoType createKeyInfoType() {
        return new KeyInfoType();
    }

    /**
     * Create an instance of {@link SingleLifeState.LifeCycleTransitions }
     * 
     */
    public SingleLifeState.LifeCycleTransitions createSingleLifeStateLifeCycleTransitions() {
        return new SingleLifeState.LifeCycleTransitions();
    }

    /**
     * Create an instance of {@link TCIntegrityProtectionType }
     * 
     */
    public TCIntegrityProtectionType createTCIntegrityProtectionType() {
        return new TCIntegrityProtectionType();
    }

    /**
     * Create an instance of {@link LifeCycleType }
     * 
     */
    public LifeCycleType createLifeCycleType() {
        return new LifeCycleType();
    }

    /**
     * Create an instance of {@link TocType }
     * 
     */
    public TocType createTocType() {
        return new TocType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Attacker", scope = CapabilityType.class)
    public JAXBElement<String> createCapabilityTypeAttacker(String value) {
        return new JAXBElement<String>(_CapabilityTypeAttacker_QNAME, String.class, CapabilityType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CapabilityType.AttackerCapabilities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AttackerCapabilities", scope = CapabilityType.class)
    public JAXBElement<CapabilityType.AttackerCapabilities> createCapabilityTypeAttackerCapabilities(CapabilityType.AttackerCapabilities value) {
        return new JAXBElement<CapabilityType.AttackerCapabilities>(_CapabilityTypeAttackerCapabilities_QNAME, CapabilityType.AttackerCapabilities.class, CapabilityType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AttackName", scope = CapabilityType.class)
    public JAXBElement<String> createCapabilityTypeAttackName(String value) {
        return new JAXBElement<String>(_CapabilityTypeAttackName_QNAME, String.class, CapabilityType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TC_Hash")
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    public JAXBElement<byte[]> createTCHash(byte[] value) {
        return new JAXBElement<byte[]>(_TCHash_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestBasedCertificationModelType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TestBasedCertificationModel")
    public JAXBElement<TestBasedCertificationModelType> createTestBasedCertificationModel(TestBasedCertificationModelType value) {
        return new JAXBElement<TestBasedCertificationModelType>(_TestBasedCertificationModel_QNAME, TestBasedCertificationModelType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TestedSecurityProperty")
    public JAXBElement<SecurityPropertyType> createTestedSecurityProperty(SecurityPropertyType value) {
        return new JAXBElement<SecurityPropertyType>(_TestedSecurityProperty_QNAME, SecurityPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EventId", scope = EventBusCollectorType.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    public JAXBElement<String> createEventBusCollectorTypeEventId(String value) {
        return new JAXBElement<String>(_EventBusCollectorTypeEventId_QNAME, String.class, EventBusCollectorType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EventCode", scope = EventBusCollectorType.class)
    public JAXBElement<String> createEventBusCollectorTypeEventCode(String value) {
        return new JAXBElement<String>(_EventBusCollectorTypeEventCode_QNAME, String.class, EventBusCollectorType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RetrievalMethod", scope = KeyInfoType.class)
    public JAXBElement<Object> createKeyInfoTypeRetrievalMethod(Object value) {
        return new JAXBElement<Object>(_KeyInfoTypeRetrievalMethod_QNAME, Object.class, KeyInfoType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SPKIData", scope = KeyInfoType.class)
    public JAXBElement<Object> createKeyInfoTypeSPKIData(Object value) {
        return new JAXBElement<Object>(_KeyInfoTypeSPKIData_QNAME, Object.class, KeyInfoType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "KeyValue", scope = KeyInfoType.class)
    public JAXBElement<Object> createKeyInfoTypeKeyValue(Object value) {
        return new JAXBElement<Object>(_KeyInfoTypeKeyValue_QNAME, Object.class, KeyInfoType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "X509Data", scope = KeyInfoType.class)
    public JAXBElement<Object> createKeyInfoTypeX509Data(Object value) {
        return new JAXBElement<Object>(_KeyInfoTypeX509Data_QNAME, Object.class, KeyInfoType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PGPData", scope = KeyInfoType.class)
    public JAXBElement<Object> createKeyInfoTypePGPData(Object value) {
        return new JAXBElement<Object>(_KeyInfoTypePGPData_QNAME, Object.class, KeyInfoType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MgmtData", scope = KeyInfoType.class)
    public JAXBElement<Object> createKeyInfoTypeMgmtData(Object value) {
        return new JAXBElement<Object>(_KeyInfoTypeMgmtData_QNAME, Object.class, KeyInfoType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "KeyName", scope = KeyInfoType.class)
    public JAXBElement<Object> createKeyInfoTypeKeyName(Object value) {
        return new JAXBElement<Object>(_KeyInfoTypeKeyName_QNAME, Object.class, KeyInfoType.class, value);
    }

}
