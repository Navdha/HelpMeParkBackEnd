package ws;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/database/{location}")  
public class DBService {
	Main obj = new Main();
	String delimRows = "\\|";
	String delimInsideRow = ";";
	 @GET   // this method process GET request from client
	    @Produces("application/json")   // sends JSON
	    public String getJson( @PathParam("location") String location) throws UnknownHostException, IOException {  // garageName represents the garage name sent from client   
		  String str = obj.getData(location);
		  System.out.println(str);
		  String fncall1, fncall2, fncall3, fncall4;
		  String[] tem = str.split(delimRows);
		  String[] temp1;
		  temp1 = tem[0].split(delimInsideRow);
		  String[] temp2;
		  temp2 = tem[1].split(delimInsideRow);
		  String[] temp3;
		  temp3 = tem[2].split(delimInsideRow);
		  String[] temp4;
		  temp4 = tem[3].split(delimInsideRow);
		  if(location.equals("Middletown")){
			  fncall1 = "callCommon1();";
			  fncall2 = "callCommon2();";
			  fncall3 = "callCommon3();";
			  fncall4 = "callCommon4();";
		  }
		  else{
			  fncall1 = "callGarage1();";
			  fncall2 = "callGarage2();";
			  fncall3 = "callGarage3();";
			  fncall4 = "callGarage4();";
		  }
		  String jsonOutput = "{\"address\": \"<b>Address</b>\", \"availability\": \"<b>Spots Available</b>\", \"timestamp\": \"<b>Last Updated</b>\", \"address1\":\""+ temp1[0]+ 
				  "\", \"sName1\":\"" + temp1[1] + "\", \"availability1\":\"" + temp1[2] + "\", \"timestamp1\":\"" + temp1[3] + 
				  "\", \"refresh1\" : \"<input type='image' src='refresh.jpeg' alt='Refresh' width='20' height='20' id='btnRefresh1' onClick='" + fncall1 +"'>" +
				  "\", \"address2\":\""+ temp2[0]+ "\", \"sName2\":\"" + temp2[1] + "\", \"availability2\":\"" + temp2[2] + "\", \"timestamp2\":\"" + temp2[3] + 
				  "\", \"refresh2\" : \"<input type='image' src='refresh.jpeg' alt='Refresh' width='20' height='20' id='btnRefresh2' onClick='" + fncall2 +"'>" +
				  "\", \"address3\":\""+ temp3[0]+ "\", \"sName3\":\"" + temp3[1] + "\", \"availability3\":\"" + temp3[2] + "\", \"timestamp3\":\"" + temp3[3] + 
				  "\", \"refresh3\" : \"<input type='image' src='refresh.jpeg' alt='Refresh' width='20' height='20' id='btnRefresh3' onClick='" + fncall3 +"'>" +
				  "\", \"address4\":\""+ temp4[0]+ "\", \"sName4\":\"" + temp4[1] + "\", \"availability4\":\"" + temp4[2] + "\", \"timestamp4\":\"" + temp4[3] + 
				  "\", \"refresh4\" : \"<input type='image' src='refresh.jpeg' alt='Refresh' width='20' height='20' id='btnRefresh4' onClick='" + fncall4 +"'>" +
		 "\"}";
		  // close the reader, and return the results as a String
		  //"{\"name\":\"George Koch\", \"age\":58}";		 
		  return jsonOutput;
	   } // end of getJson()
}
