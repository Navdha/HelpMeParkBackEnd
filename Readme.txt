Folder description:

CommonGarage : Server returns random location and timestamp for all garages in Middletown.
DatabaseService : Web service that returns the garage information (Address, availability, timestamp) according to the location selected by user.
Garage : Real time garage for Pittsburgh
GarageA : Real time garage for Pittsburgh
GarageB : Real time garage for Pittsburgh
GarageC : Real time garage for Pittsburgh
ParkingService : Web service that returns the latest availability with the recent timestamp for the garage the update is called for.
ParkUI : Client-side UI for the application
Server : Centralized server that connects with the database and sends output through socket.
UpdateDBServer : Server that contacts all garages periodically and updates their availability on the database.

Requirements:

- Eclipse Kepler/Neon (Latest Eclipse EE)
- Tomcat server

To run:

- The web services DatabaseService and ParkingService need to be run on Apache(Tomcat) server. We did this by running the application using Eclipse EE IDE.
- The centralized server file can be compiled using the command prompt.
- To compile : javac -cp .:ojdbc6.jar Server.java
- To run : java -cp .:ojdbc6.jar Server
- Please run the centralized server on the machine 'ada'.
- To test the backup server, need to follow the same steps on machine 'euler'
- The individual garages (Garage, GarageA, GarageB and GarageC) can be compiled using the command prompt.
- To compile : javac -cp .:jsoup-1.8.3.jar filename.java
- To run : java -cp .:jsoup-1.8.3.jar filename
- Please run Garage on machine 'zeno', GarageA on 'nygaard', GarageB on 'ulam' and GarageC on 'hardy'
- If the port is already being used, you need to try the following command on the command prompt.
- lsof -i:portNum and then kill the process displayed, where portNum = 6765 for 'zeno', 6762 for 'nygaard', 6763 for 'ulam' and 6764 for 'hardy'
- To run CommonGarage, compile using javac GarageServer.java and run using java GarageServer. The port number used is 6767 on machine 'alonzo'
- To run the server that updates the database, compile using javac -cp .:java-json.jar:ojdbc6.jar Server2.java and run using java -cp .:java-json.jar:ojdbc6.jar Server2
- To run the client using the URL "http://comp512.pagekite.me/ParkUI/ParkMain.jsp", we need to run the ParkUI application on the tomcat server and need to install and run pagekite.py on the machine as an executable. It is only an active link for 30 days so it is recommended to change the URL to "http://localhost:8080/ParkUI/ParkMain.jsp" in the ParkMain.jsp file if running the application using a Tomcat server.

To kill any java program run from the command line, press Ctrl+C
