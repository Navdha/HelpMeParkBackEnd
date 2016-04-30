import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetAvailability {
    public static void main(String[] args) throws IOException {
	/**
	     * Application method to run the server runs in an infinite loop
	     * listening on port 6765.  When a connection is requested, it
	     * spawns a new thread to do the servicing and immediately returns
	     * to listening.  The server keeps a unique client number for each
	     * client that connects just to show interesting logging
	     * messages.
	     */

	int clientNumber = 0;
	ServerSocket listener = new ServerSocket(6765);
	try {
	    while (true) {
		new Worker(listener.accept(), clientNumber++).start();
	    }
	} finally {
	    listener.close();
	}
    }

    private static class Worker extends Thread {
	private Socket socket;
	private int clientNumber;
	String numAvail = "";
	String timeStamp;
	StringBuilder obj = new StringBuilder();

	public Worker(Socket socket, int clientNumber) {
	    this.socket = socket;
	    this.clientNumber = clientNumber;
	    run();
	}

	public void run() {

	    try {
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Document doc = Jsoup.connect("http://parkpgh.org/lots/25").get();
		Elements availability = doc.getElementsByClass("spots");
		Elements temp;
		System.out.println(availability.text());
		for (Element getspots : availability) {
		    Elements number = getspots.getElementsByClass("left");
		    if(!number.isEmpty()) {
			temp = number.select("span");
			numAvail = temp.text();
		    }
		    else{
			Elements full = getspots.getElementsByClass("full-row");
			temp = full.select("span");
			numAvail = temp.text();
		    }
		}
		obj.append(numAvail);
		obj.append(";");
		obj.append(timeStamp);
		obj.append(";");
		obj.append("zeno");
		out.println(obj.toString());

	    }
	    catch(UnknownHostException ue){
	    	System.out.println(ue);
	    }
	    catch (HttpStatusException hse) {
		System.out.println(hse);
	    } catch (IOException ioe) {
		System.out.println(ioe);
	    } 
	    
	    catch (Exception e) {
		System.out.println("Error handling client #" + clientNumber + ": " + e);
	    }
	    finally {
		try {
		    socket.close();
		} catch (IOException e) {
		    System.out.println("Socket not closed");
		}
		System.out.println("Connection closed for client #" + clientNumber);
	    }

	}
    }
}
