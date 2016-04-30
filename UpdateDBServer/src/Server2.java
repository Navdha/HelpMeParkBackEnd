import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;

public class Server2 {

	long delay = 600 * 1000; // delay in milliseconds
	Retriever task = new Retriever();
	Timer timer = new Timer();

	public void start() {
		if(timer != null){
		timer.cancel();
		timer = new Timer();
		Date executionDate = new Date(); // no params = now
		timer.scheduleAtFixedRate(task, executionDate, delay); //call the run method after every 10mins
		}
	}

	public static void main(String[] args) throws Exception {
		Server2 obj = new Server2();
		obj.start();
	}

	private static class Retriever extends TimerTask {
		public void run() {
		    //go through all servers one by one and update the database
			int locationNumber = 1;
			int totalLocations = 5;
			while (locationNumber <= totalLocations) {
				try {
					String serverAddress;
					// int port;
					switch (locationNumber) {
					case 1:
						serverAddress = "zeno";
						// port = 6765;
						break;
					case 2:
						serverAddress = "nygaard";
						// port = 6762;
						break;
					case 3:
						serverAddress = "ulam";
						// port = 6763;
						break;
					case 4:
						serverAddress = "hardy";
						// port = 6764;
						break;
					default:
						serverAddress = "alonzo";
						// port = 6767;
						break;
					}
					//calling the webservice for the garages
					URL url = new URL(
							"http://localhost:8080/ParkingService/rest/garage/"
									+ serverAddress);
					HttpURLConnection conn = (HttpURLConnection) url
							.openConnection();
					conn.setRequestMethod("GET");
					conn.setRequestProperty("Accept", "application/json");

					if (conn.getResponseCode() != 200) {
						throw new RuntimeException(
								"Failed : HTTP error code : "
										+ conn.getResponseCode());
					}

					BufferedReader br = new BufferedReader(
							new InputStreamReader((conn.getInputStream())));

					String output = "";
					System.out.println("Output from Server .... \n");
					//while ((output = br.readLine()) != null) {
						//System.out.println(output);
					//}
					output = br.readLine();
					System.out.println(output);
					JSONObject obj = new JSONObject(output.toString());
					if(obj != null){	
					String availability = obj.getString("avail");
					String timestamp = obj.getString("time");
					String server = obj.getString("server");
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn1 = DriverManager
							.getConnection(
									"jdbc:oracle:thin:@hbgoracle.hbg.psu.edu:1521/pdbcldb.hbg.psu.edu",
									"mab794", "os2016");
					System.out
							.println("Connected Successfully To Oracle using OCI driver");
					String query = "UPDATE testGarageName SET AVAILABILITY=? , TIMESTAMP=? WHERE IP= ?";
					PreparedStatement stmt = conn1.prepareStatement(query);
					stmt.setString(1, availability);
					stmt.setString(2, timestamp);
					stmt.setString(3, server);
					int rowsAffected = stmt.executeUpdate();
					if (rowsAffected > 0)
						System.out.println("Row updated");
					}
					
					conn.disconnect();
				} catch (MalformedURLException e) {

					e.printStackTrace();

				} catch (IOException e) {
					System.out.println("Error : " + e);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				locationNumber++;
			}
			
		}
	}
}
