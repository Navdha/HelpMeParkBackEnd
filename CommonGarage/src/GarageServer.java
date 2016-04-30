import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GarageServer {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 Random rn = new Random();
		 int value; 
		 ServerSocket listener = new ServerSocket(6767);
		 String numAvail; 
		 String timeStamp; 
		 StringBuilder obj; 
		 try {
	           while (true) {
	        	Socket socket = listener.accept();
	        	try{
	        		PrintWriter out =  new PrintWriter(socket.getOutputStream(), true);
	        		value = rn.nextInt(400) + 1;
	        		numAvail = Integer.toString(value);
	        		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	        		obj = new StringBuilder();
	        		obj.append(numAvail);
	       		 	obj.append(";");
	       		 	obj.append(timeStamp);
	       		 	obj.append(";");
	       		 	obj.append("alonzo");
	                out.println(obj.toString());	
	        	}
	        	finally {
	  	    	  socket.close();
	        	}
	           }
	       }
	      finally {
	         listener.close();
	      }
	}
}
