import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
// Import the java.sql and JDBC packages to use JDBC 
import java.sql.*;

/**
 * A server program which accepts requests from clients to
 * capitalize strings.  When clients connect, a new thread is
 * started to handle an interactive dialog in which the client
 * sends in a string and the server thread sends back the
 * capitalized version of the string.
 *
 * The program is runs in an infinite loop, so shutdown in platform
 * dependent.  If you ran it from a console window with the "java"
 * interpreter, Ctrl+C generally will shut it down.
 */

public class Server{

    /**
     * Application method to run the server runs in an infinite loop
     * listening on port 6714.  When a connection is requested, it
     * spawns a new thread to do the servicing and immediately returns
     * to listening.  The server keeps a unique client number for each
     * client that connects just to show interesting logging
     * messages.  It is certainly not necessary to do this.
     */

   public static void main(String[] args) throws Exception {
	System.out.println("The server is running!");
	int clientNumber = 0;
	ServerSocket listener = new ServerSocket(6714);
	try{
	    while(true) {
		new Worker(listener.accept(), clientNumber++).start();
	    }
	}
	finally{
	    listener.close();
	}
    }

    /**
     * A private thread to handle capitalization requests on a particular
     * socket.  The client terminates the dialogue by sending a single line
     * containing only a period.
     */

   private static class Worker extends Thread{
	private Socket socket;
	private int clientNumber;
	String query = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	StringBuilder output = new StringBuilder();

	public Worker(Socket socket, int clientNumber) {
	    this.socket = socket;
	    this.clientNumber = clientNumber;
	    log("New connection with client # " +clientNumber + " at " + socket);
	    run();
	}
	
	/**
         * Services this thread's client by first sending the
         * client a welcome message then repeatedly reading strings
         * and sending back the capitalized version of the string.
         */
	public void run() {
	    try {
		
		// Decorate the streams so we can send characters
                // and not just bytes.  Ensure output is flushed
                // after every newline.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// connect using Native-API (OCI) thin driver 
		//Connection conn = DriverManager.getConnection("jdbc:oracle:oci:@pdbcldb","mab794","os2016" );
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@hbgoracle.hbg.psu.edu:1521/pdbcldb.hbg.psu.edu","mab794","os2016" );
		System.out.println("Connected Successfully To Oracle using OCI driver");

		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		// Could send a connection established message to the client.
		//out.println("Connection successful! You are client #" + clientNumber + ".");
		//out.println("Enter a line with only a period to quit\n");

		// Get message from the client, line by line; return them capitalized.
		 String input = "";
		 char c;
		    while ((c = (char) in.read()) != ';') {
		        input += Character.toString(c);
		    }
		    System.out.println(input);
		    if (input == null || input.equals(".")) {
			//not needed
			//break;
		    }
		    else {
			//Query the database to get all garages from a particular location
			query = "SELECT NAME, ADDRESS, CITY, IP, AVAILABILITY, TIMESTAMP, COORDINATES " +
			    "FROM testGarageName WHERE CITY= ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, input);
			rs = stmt.executeQuery();
			while(rs.next()){
				output.append(rs.getString("NAME"));
				output.append(",");
				output.append(rs.getString("ADDRESS"));
				output.append(",");
			    output.append(rs.getString("CITY"));
			    output.append(";");
			    output.append(rs.getString("IP"));
			    output.append(";");
			    output.append(rs.getString("AVAILABILITY"));
			    output.append(";");
			    output.append(rs.getString("TIMESTAMP"));
			    output.append(";");
			    output.append(rs.getString("COORDINATES"));
			    output.append("|");
			}
			System.out.println("The string is " + output.toString());
			//output the data to the client
			out.println(output.toString() + "~");
		    }   
		
	    }
	    catch (IOException e) {
		log("Error handling client #" +clientNumber + ": " +e);
	    } 
	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
//		try {
//		    socket.close();
//		}
//		catch (IOException e) {
//		    log("Socket not closed");
//		}
		log("Connection closed for client #" + clientNumber);
	    }
	} //end run

	/**
         * Logs a simple message.  In this case we just write the
         * message to the server applications standard output.
         */
	private void log(String message) {
	    System.out.println(message);
	}
   }
}
