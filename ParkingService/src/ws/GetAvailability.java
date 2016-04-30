package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GetAvailability {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public String getAvailability(String garageName) throws UnknownHostException, IOException {
	 int port;
     switch(garageName) {
     case "nygaard":
			 port = 6762;
			 break;
		 case "ulam":
			 port = 6763;
			 break;
		 case "hardy":
			 port = 6764;
			 break;
		 case "zeno":
			 port = 6765;
			 break;
		 default:
			 port = 6767;
			 break;
     } // end of switch
     socket = new Socket(garageName + ".cs.hbg.psu.edu", port);			
	 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	 out = new PrintWriter(socket.getOutputStream(), true);	
	     
	 String str = in.readLine();
	 in.close();
	 socket.close();
	 return str;
	}
}
