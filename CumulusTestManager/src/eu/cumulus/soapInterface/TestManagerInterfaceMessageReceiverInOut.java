
/**
 * TestManagerInterfaceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package eu.cumulus.soapInterface;

        /**
        *  TestManagerInterfaceMessageReceiverInOut message receiver
        */

        public class TestManagerInterfaceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        TestManagerInterfaceSkeletonInterface skel = (TestManagerInterfaceSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("getCertificates_Testing".equals(methodName)){
                
                eu.cumulus.soapResponse.GetCertificates_TestingResponse getCertificates_TestingResponse15 = null;
	                        eu.cumulus.soapResponse.GetCertificates_Testing wrappedParam =
                                                             (eu.cumulus.soapResponse.GetCertificates_Testing)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    eu.cumulus.soapResponse.GetCertificates_Testing.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getCertificates_TestingResponse15 =
                                                   
                                                   
                                                         skel.getCertificates_Testing(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getCertificates_TestingResponse15, false, new javax.xml.namespace.QName("http://soapResponse.cumulus.eu",
                                                    "getCertificates_Testing"));
                                    } else 

            if("deleteCm_Testing".equals(methodName)){
                
                eu.cumulus.soapResponse.DeleteCm_TestingResponse deleteCm_TestingResponse17 = null;
	                        eu.cumulus.soapResponse.DeleteCm_Testing wrappedParam =
                                                             (eu.cumulus.soapResponse.DeleteCm_Testing)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    eu.cumulus.soapResponse.DeleteCm_Testing.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               deleteCm_TestingResponse17 =
                                                   
                                                   
                                                         skel.deleteCm_Testing(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), deleteCm_TestingResponse17, false, new javax.xml.namespace.QName("http://soapResponse.cumulus.eu",
                                                    "deleteCm_Testing"));
                                    } else 

            if("addCm_Testing".equals(methodName)){
                
                eu.cumulus.soapResponse.AddCm_TestingResponse addCm_TestingResponse19 = null;
	                        eu.cumulus.soapResponse.AddCm_Testing wrappedParam =
                                                             (eu.cumulus.soapResponse.AddCm_Testing)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    eu.cumulus.soapResponse.AddCm_Testing.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               addCm_TestingResponse19 =
                                                   
                                                   
                                                         skel.addCm_Testing(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), addCm_TestingResponse19, false, new javax.xml.namespace.QName("http://soapResponse.cumulus.eu",
                                                    "addCm_Testing"));
                                    } else 

            if("getCertificatesSummary_Testing".equals(methodName)){
                
                eu.cumulus.soapResponse.GetCertificatesSummary_TestingResponse getCertificatesSummary_TestingResponse21 = null;
	                        eu.cumulus.soapResponse.GetCertificatesSummary_Testing wrappedParam =
                                                             (eu.cumulus.soapResponse.GetCertificatesSummary_Testing)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    eu.cumulus.soapResponse.GetCertificatesSummary_Testing.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getCertificatesSummary_TestingResponse21 =
                                                   
                                                   
                                                         skel.getCertificatesSummary_Testing(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getCertificatesSummary_TestingResponse21, false, new javax.xml.namespace.QName("http://soapResponse.cumulus.eu",
                                                    "getCertificatesSummary_Testing"));
                                    } else 

            if("getCertificationModelsTesting".equals(methodName)){
                
                eu.cumulus.soapResponse.GetCertificationModelsTestingResponse getCertificationModelsTestingResponse23 = null;
	                        eu.cumulus.soapResponse.GetCertificationModelsTesting wrappedParam =
                                                             (eu.cumulus.soapResponse.GetCertificationModelsTesting)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    eu.cumulus.soapResponse.GetCertificationModelsTesting.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getCertificationModelsTestingResponse23 =
                                                   
                                                   
                                                         skel.getCertificationModelsTesting(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getCertificationModelsTestingResponse23, false, new javax.xml.namespace.QName("http://soapResponse.cumulus.eu",
                                                    "getCertificationModelsTesting"));
                                    } else 

            if("getPropertyAndTOCsTesting".equals(methodName)){
                
                eu.cumulus.soapResponse.GetPropertyAndTOCsTestingResponse getPropertyAndTOCsTestingResponse25 = null;
	                        eu.cumulus.soapResponse.GetPropertyAndTOCsTesting wrappedParam =
                                                             (eu.cumulus.soapResponse.GetPropertyAndTOCsTesting)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    eu.cumulus.soapResponse.GetPropertyAndTOCsTesting.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getPropertyAndTOCsTestingResponse25 =
                                                   
                                                   
                                                         skel.getPropertyAndTOCsTesting(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getPropertyAndTOCsTestingResponse25, false, new javax.xml.namespace.QName("http://soapResponse.cumulus.eu",
                                                    "getPropertyAndTOCsTesting"));
                                    } else 

            if("requestCertificate_Testing".equals(methodName)){
                
                eu.cumulus.soapResponse.RequestCertificate_TestingResponse requestCertificate_TestingResponse27 = null;
	                        eu.cumulus.soapResponse.RequestCertificate_Testing wrappedParam =
                                                             (eu.cumulus.soapResponse.RequestCertificate_Testing)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    eu.cumulus.soapResponse.RequestCertificate_Testing.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               requestCertificate_TestingResponse27 =
                                                   
                                                   
                                                         skel.requestCertificate_Testing(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), requestCertificate_TestingResponse27, false, new javax.xml.namespace.QName("http://soapResponse.cumulus.eu",
                                                    "requestCertificate_Testing"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(eu.cumulus.soapResponse.GetCertificates_Testing param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(eu.cumulus.soapResponse.GetCertificates_Testing.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(eu.cumulus.soapResponse.GetCertificates_TestingResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(eu.cumulus.soapResponse.GetCertificates_TestingResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(eu.cumulus.soapResponse.DeleteCm_Testing param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(eu.cumulus.soapResponse.DeleteCm_Testing.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(eu.cumulus.soapResponse.DeleteCm_TestingResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(eu.cumulus.soapResponse.DeleteCm_TestingResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(eu.cumulus.soapResponse.AddCm_Testing param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(eu.cumulus.soapResponse.AddCm_Testing.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(eu.cumulus.soapResponse.AddCm_TestingResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(eu.cumulus.soapResponse.AddCm_TestingResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(eu.cumulus.soapResponse.GetCertificatesSummary_Testing param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(eu.cumulus.soapResponse.GetCertificatesSummary_Testing.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(eu.cumulus.soapResponse.GetCertificatesSummary_TestingResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(eu.cumulus.soapResponse.GetCertificatesSummary_TestingResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(eu.cumulus.soapResponse.GetCertificationModelsTesting param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(eu.cumulus.soapResponse.GetCertificationModelsTesting.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(eu.cumulus.soapResponse.GetCertificationModelsTestingResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(eu.cumulus.soapResponse.GetCertificationModelsTestingResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(eu.cumulus.soapResponse.GetPropertyAndTOCsTesting param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(eu.cumulus.soapResponse.GetPropertyAndTOCsTesting.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(eu.cumulus.soapResponse.GetPropertyAndTOCsTestingResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(eu.cumulus.soapResponse.GetPropertyAndTOCsTestingResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(eu.cumulus.soapResponse.RequestCertificate_Testing param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(eu.cumulus.soapResponse.RequestCertificate_Testing.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(eu.cumulus.soapResponse.RequestCertificate_TestingResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(eu.cumulus.soapResponse.RequestCertificate_TestingResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, eu.cumulus.soapResponse.GetCertificates_TestingResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(eu.cumulus.soapResponse.GetCertificates_TestingResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private eu.cumulus.soapResponse.GetCertificates_TestingResponse wrapgetCertificates_Testing(){
                                eu.cumulus.soapResponse.GetCertificates_TestingResponse wrappedElement = new eu.cumulus.soapResponse.GetCertificates_TestingResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, eu.cumulus.soapResponse.DeleteCm_TestingResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(eu.cumulus.soapResponse.DeleteCm_TestingResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private eu.cumulus.soapResponse.DeleteCm_TestingResponse wrapdeleteCm_Testing(){
                                eu.cumulus.soapResponse.DeleteCm_TestingResponse wrappedElement = new eu.cumulus.soapResponse.DeleteCm_TestingResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, eu.cumulus.soapResponse.AddCm_TestingResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(eu.cumulus.soapResponse.AddCm_TestingResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private eu.cumulus.soapResponse.AddCm_TestingResponse wrapaddCm_Testing(){
                                eu.cumulus.soapResponse.AddCm_TestingResponse wrappedElement = new eu.cumulus.soapResponse.AddCm_TestingResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, eu.cumulus.soapResponse.GetCertificatesSummary_TestingResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(eu.cumulus.soapResponse.GetCertificatesSummary_TestingResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private eu.cumulus.soapResponse.GetCertificatesSummary_TestingResponse wrapgetCertificatesSummary_Testing(){
                                eu.cumulus.soapResponse.GetCertificatesSummary_TestingResponse wrappedElement = new eu.cumulus.soapResponse.GetCertificatesSummary_TestingResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, eu.cumulus.soapResponse.GetCertificationModelsTestingResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(eu.cumulus.soapResponse.GetCertificationModelsTestingResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private eu.cumulus.soapResponse.GetCertificationModelsTestingResponse wrapgetCertificationModelsTesting(){
                                eu.cumulus.soapResponse.GetCertificationModelsTestingResponse wrappedElement = new eu.cumulus.soapResponse.GetCertificationModelsTestingResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, eu.cumulus.soapResponse.GetPropertyAndTOCsTestingResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(eu.cumulus.soapResponse.GetPropertyAndTOCsTestingResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private eu.cumulus.soapResponse.GetPropertyAndTOCsTestingResponse wrapgetPropertyAndTOCsTesting(){
                                eu.cumulus.soapResponse.GetPropertyAndTOCsTestingResponse wrappedElement = new eu.cumulus.soapResponse.GetPropertyAndTOCsTestingResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, eu.cumulus.soapResponse.RequestCertificate_TestingResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(eu.cumulus.soapResponse.RequestCertificate_TestingResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private eu.cumulus.soapResponse.RequestCertificate_TestingResponse wraprequestCertificate_Testing(){
                                eu.cumulus.soapResponse.RequestCertificate_TestingResponse wrappedElement = new eu.cumulus.soapResponse.RequestCertificate_TestingResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (eu.cumulus.soapResponse.GetCertificates_Testing.class.equals(type)){
                
                           return eu.cumulus.soapResponse.GetCertificates_Testing.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (eu.cumulus.soapResponse.GetCertificates_TestingResponse.class.equals(type)){
                
                           return eu.cumulus.soapResponse.GetCertificates_TestingResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (eu.cumulus.soapResponse.DeleteCm_Testing.class.equals(type)){
                
                           return eu.cumulus.soapResponse.DeleteCm_Testing.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (eu.cumulus.soapResponse.DeleteCm_TestingResponse.class.equals(type)){
                
                           return eu.cumulus.soapResponse.DeleteCm_TestingResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (eu.cumulus.soapResponse.AddCm_Testing.class.equals(type)){
                
                           return eu.cumulus.soapResponse.AddCm_Testing.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (eu.cumulus.soapResponse.AddCm_TestingResponse.class.equals(type)){
                
                           return eu.cumulus.soapResponse.AddCm_TestingResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (eu.cumulus.soapResponse.GetCertificatesSummary_Testing.class.equals(type)){
                
                           return eu.cumulus.soapResponse.GetCertificatesSummary_Testing.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (eu.cumulus.soapResponse.GetCertificatesSummary_TestingResponse.class.equals(type)){
                
                           return eu.cumulus.soapResponse.GetCertificatesSummary_TestingResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (eu.cumulus.soapResponse.GetCertificationModelsTesting.class.equals(type)){
                
                           return eu.cumulus.soapResponse.GetCertificationModelsTesting.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (eu.cumulus.soapResponse.GetCertificationModelsTestingResponse.class.equals(type)){
                
                           return eu.cumulus.soapResponse.GetCertificationModelsTestingResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (eu.cumulus.soapResponse.GetPropertyAndTOCsTesting.class.equals(type)){
                
                           return eu.cumulus.soapResponse.GetPropertyAndTOCsTesting.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (eu.cumulus.soapResponse.GetPropertyAndTOCsTestingResponse.class.equals(type)){
                
                           return eu.cumulus.soapResponse.GetPropertyAndTOCsTestingResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (eu.cumulus.soapResponse.RequestCertificate_Testing.class.equals(type)){
                
                           return eu.cumulus.soapResponse.RequestCertificate_Testing.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (eu.cumulus.soapResponse.RequestCertificate_TestingResponse.class.equals(type)){
                
                           return eu.cumulus.soapResponse.RequestCertificate_TestingResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    