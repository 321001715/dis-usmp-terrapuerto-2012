package pe.com.terrapuerto.commons.util;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.sessions.JNDIConnector;
import org.eclipse.persistence.sessions.Session;

public class JPAEclipseLinkSessionCustomizer implements SessionCustomizer{

	@Override
	public void customize(Session session) throws Exception {
		// TODO Auto-generated method stub
		JNDIConnector connector = null;
	    Context context = null;
	    try {
	      context = new InitialContext();
	      if(context != null) {
	        connector = (JNDIConnector)session.getLogin().getConnector();
	        connector.setLookupType(JNDIConnector.STRING_LOOKUP);
	        System.err.println("******************** JPAEclipseLinkSessionCustomizer: configured " + connector.getName());
	      }
	    }catch(Exception e) {
	      e.printStackTrace();
	    }
	}

}