package eu.cumulus.utilities;

import javax.servlet.ServletContext;

import org.apache.axis2.context.MessageContext;
import org.apache.axis2.transport.http.HTTPConstants;


public class ServletContextGetter{
public ServletContext getServletContext()
{
MessageContext mc = MessageContext.getCurrentMessageContext();

return (ServletContext) mc.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);

}
}