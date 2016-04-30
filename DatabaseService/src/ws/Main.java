package ws;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class Main {
	private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    
    public String getData(String location) {
    	try {
			 socket = new Socket("ada.cs.hbg.psu.edu", 6714);
			 // write text to the socket
		      BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		      bufferedWriter.write(location+";");
		      bufferedWriter.flush();
			
		     in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		     out = new PrintWriter(socket.getOutputStream(), true);	
		     String input = "";
			 char c;
			    while ((c = (char) in.read()) != '~') {
			        //out.println(c);
			        input += Character.toString(c);
			        //System.out.println("echo: " + in.readLine());
			    }
			    System.out.println(input);
		     //String str = in.readLine();
		     //System.out.println(str);
		      // close the reader, and return the results as a String
		      in.close();
		     String message = input.toString();
		     socket.close();
		     return message;
        }
    	catch(ConnectException e) {
    		try {
    			  socket = new Socket("euler.cs.hbg.psu.edu", 6714);
    				 // write text to the socket
    			      BufferedWriter bufferedWriter1 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    			      bufferedWriter1.write(location+";");
    			      bufferedWriter1.flush();
    				
    			     in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    			     out = new PrintWriter(socket.getOutputStream(), true);	
    			     String input1 = "";
    				 char c1;
    				    while ((c1 = (char) in.read()) != '~') {
    				        //out.println(c);
    				        input1 += Character.toString(c1);
    				        //System.out.println("echo: " + in.readLine());
    				    }
    				    System.out.println(input1);
    			     //String str = in.readLine();
    			     //System.out.println(str);
    			      // close the reader, and return the results as a String
    			      in.close();
    			     String message1 = input1.toString();
    			     socket.close();
    			     return message1;
    	        }
    	    	catch (SocketTimeoutException ste1) 
    		    {
    			ste1.printStackTrace();
    			//throw ste1;
    		    } catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    	}
    	catch (SocketTimeoutException ste) 
	    {
	      System.err.println("Timed out waiting for the socket.");
	      
	   //   ste.printStackTrace();
	     
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error";
    }
}
