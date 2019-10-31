package icai.dtc.isw.message;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String context;
	private Object obj;
	private Map<String, Object> session;
	
	
	public Message () {
		context=new String();
		session=new HashMap<String, Object>();	
		
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	public Object getObject() {
		return obj;
	}

	public void setObject(Object obj) {
		this.obj = obj;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}	
}
