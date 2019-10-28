package icai.dtc.isw.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import icai.dtc.isw.configuration.PropertiesISW;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Test;
import icai.dtc.isw.domain.User;
import icai.dtc.isw.domain.Product;
import icai.dtc.isw.domain.Review;
import icai.dtc.isw.message.Message;

public class Client {
	private String host;
	private int port;
	private HashMap<String,Object> session;
	final static Logger logger = Logger.getLogger(Client.class);

	
	public Client() {
		this.host = PropertiesISW.getInstance().getProperty("host");
		this.port = Integer.parseInt(PropertiesISW.getInstance().getProperty("port"));
		Logger.getRootLogger().info("Host: "+host+" port"+port);
		session=new HashMap<String, Object>();
	}
	
	public ArrayList clientInteraction(String command) {
		
		Message mensajeEnvio=new Message();
		Message mensajeVuelta=new Message();
		mensajeEnvio.setContext(command);
		mensajeEnvio.setSession(session);
		this.sent(mensajeEnvio,mensajeVuelta);
		
		ArrayList response = new ArrayList();
		
		switch (mensajeVuelta.getContext()) {
			case "/getBasicProductResponse":
				response=(ArrayList<Product>)(mensajeVuelta.getSession().get("basicProduct"));
			break;
			case "/getFullProductResponse":
				response=(ArrayList<Product>)(mensajeVuelta.getSession().get("fullProduct"));
			break;
			case "/getUser":
				response=(ArrayList<User>)(mensajeVuelta.getSession().get("users"));
			break;
			case "/getReview":
				response=(ArrayList<Review>)(mensajeVuelta.getSession().get("reviews"));
			break;
				
			default:
				Logger.getRootLogger().info("Option not found");
				System.out.println("\nError a la vuelta");
				break;
			
			/*case "/getCustomerResponse":
				response = (ArrayList<Customer>)(mensajeVuelta.getSession().get("Customer"));
				 /*for (Customer customer : response) {			
						System.out.println("He leido el id: "+customer.getId()+" con nombre: "+customer.getName());
					}
				break;
			case "/getTestResponse":
				response = (ArrayList<Test>)(mensajeVuelta.getSession().get("Test"));
				/* for (Test test : response) {			
						System.out.println("He leido el id: "+test.getId()+" con nombre: "+test.getName());
					}
				break;*/
		
		}
		//System.out.println("3.- En Main.- El valor devuelto es: "+((String)mensajeVuelta.getSession().get("Nombre")));
		return response;
	}
	

	public void sent(Message messageOut, Message messageIn) {
		try {

			System.out.println("Connecting to host " + host + " on port " + port + ".");

			Socket echoSocket = null;
			OutputStream out = null;
			InputStream in = null;

			try {
				echoSocket = new Socket(host, port);
				in = echoSocket.getInputStream();
				out = echoSocket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
				
				//Create the objetct to send
				objectOutputStream.writeObject(messageOut);
				
				// create a DataInputStream so we can read data from it.
		        ObjectInputStream objectInputStream = new ObjectInputStream(in);
		        Message msg=(Message)objectInputStream.readObject();
		        messageIn.setContext(msg.getContext());
		        messageIn.setSession(msg.getSession());
		        /*System.out.println("\n1.- El valor devuelto es: "+messageIn.getContext());
		        String cadena=(String) messageIn.getSession().get("Nombre");
		        System.out.println("\n2.- La cadena devuelta es: "+cadena);*/
				
			} catch (UnknownHostException e) {
				System.err.println("Unknown host: " + host);
				System.exit(1);
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Unable to get streams from server");
				System.exit(1);
			}		

			/** Closing all the resources */
			out.close();
			in.close();			
			echoSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}