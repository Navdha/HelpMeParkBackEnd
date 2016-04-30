package ws;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/garage/{garageName}")  
public class GarageService {
	GetAvailability obj = new GetAvailability();
	 @GET   // this method process GET request from client
	    @Produces("application/json")   // sends JSON
	    public String getJson( @PathParam("garageName") String garageName) throws UnknownHostException, IOException {  // garageName represents the garage name sent from client   
		  String str = obj.getAvailability(garageName);
		  String[] tem = str.split(";");
		  String jsonOutput = "{\"avail\":\""+ tem[0] + "\",\"time\":\""+ tem[1] + "\",\"server\":\"" + tem[2] + "\"}";
		  // close the reader, and return the results as a String
		  //"{'name':'George Koch', 'age':58}";		 
		  return jsonOutput;
	   } // end of getJson()
}
