package app.modele;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ResponseOfRest {
	private static final Logger LOGGER = LogManager.getLogger(ResponseOfRest.class);
	
	private String URI;
	
	public ResponseOfRest() {
		this.URI = "http://54.38.191.87/gsb_julien_quentin/public/api/gsb/praticien/2";
	}
	
	public ResponseOfRest(String URI) {
		this.URI = URI;
	}
	
	public List<Praticien> getXmlToObjects() {
		ClientConfig clientConfig = new DefaultClientConfig();
		 
	    // Create Client based on Config
	    Client client = Client.create(clientConfig);
	
	    WebResource webResource = client.resource(URI);
	
	    Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
	            .header("content-type", MediaType.APPLICATION_JSON);
	
	    ClientResponse response = builder.get(ClientResponse.class);
	
	    // Status 200 is successful.
	    if (response.getStatus() != 200) {
	    	LOGGER.error("Failed with HTTP Error code: " + response.getStatus());
	        String error= response.getEntity(String.class);
	        LOGGER.error("Error: "+ error);
	    }
	    
	    GenericType<List<Praticien>> generic = new GenericType<List<Praticien>>() {
	         // No thing
	    };
	
	    List<Praticien> lesPraticiens = response.getEntity(generic);
	
	    LOGGER.info("Output from Server .... \n");
	
	    for (Praticien unPraticien : lesPraticiens) {
	        LOGGER.info("——————————————————————————————————————————");
	        LOGGER.info("Pers No .... " + unPraticien.getId());
	        LOGGER.info("Pers name .... " + unPraticien.getNom());
	        LOGGER.info("Pers firstName .... " + unPraticien.getPrenom());
	    }
	    
	    return lesPraticiens;
	}

	public String getURI() {
		return URI;
	}

	public void setURI(String URI) {
		this.URI = URI;
	}
}
