var xmlhttp;
function init() {
   // put more code here in case you are concerned about browsers that do not provide XMLHttpRequest object directly
   xmlhttp = new XMLHttpRequest();
}
function callDB(){
	var loc = document.getElementById("ddlLocation");
	if(loc.selectedIndex != -1){
		var url = "http://localhost:8080/DatabaseService/rest/database/" + loc.options[loc.selectedIndex].text;
		xmlhttp.open('GET',url,true);
	    xmlhttp.send(null);
	    xmlhttp.onreadystatechange = function() {
	    	var add = document.getElementById("address");
	    	var avail = document.getElementById("availability");
	    	var ts = document.getElementById("timestamp");
	    	var add1 = document.getElementById("address1");
	    	var btn1 = document.getElementById("refresh1");
	    	var lbl1 = document.getElementById("lblServerName1");
	    	var avail1 =  document.getElementById("availability1");
	        var ts1 =  document.getElementById("timestamp1");
	        
	        var add2 = document.getElementById("address2");
	    	var btn2 = document.getElementById("refresh2");
	    	var lbl2 = document.getElementById("lblServerName2");
	    	var avail2 =  document.getElementById("availability2");
	        var ts2 =  document.getElementById("timestamp2");
	        
	        var add3 = document.getElementById("address3");
	    	var btn3 = document.getElementById("refresh3");
	    	var lbl3 = document.getElementById("lblServerName3");
	    	var avail3 =  document.getElementById("availability3");
	        var ts3 =  document.getElementById("timestamp3");
	        
	        var add4 = document.getElementById("address4");
	    	var btn4 = document.getElementById("refresh4");
	    	var lbl4 = document.getElementById("lblServerName4");
	    	var avail4 =  document.getElementById("availability4");
	        var ts4 =  document.getElementById("timestamp4");
	        var time;
	        var now = new Date();
	    	if (xmlhttp.readyState == 4) {
	              if ( xmlhttp.status == 200) {
	            	  var det = JSON.parse(xmlhttp.responseText);;
	            	  if (det != null) {
	            		  add.innerHTML = det.address;
	            		  avail.innerHTML = det.availability;
	            		  ts.innerHTML = det.timestamp;
	            		  add1.innerHTML = det.address1;
	            		  btn1.innerHTML = det.refresh1;
	            		  lbl1.innerHTML = det.sName1;
	            		  avail1.innerHTML = det.availability1;
	            		  time = det.timestamp1;
	            		  var newtime = time.substr(time.length - 8);
	            		  now.setHours(newtime.substr(0,newtime.indexOf(".")));
	                	  now.setMinutes(newtime.substr(newtime.indexOf(".")+1));
	                	  now.setSeconds(newtime.substr(newtime.indexOf(".")+2));
	            		  ts1.innerHTML = now;
	            		  
	            		  add2.innerHTML = det.address2;
	            		  btn2.innerHTML = det.refresh2;
	            		  lbl2.innerHTML = det.sName2;
	            		  avail2.innerHTML = det.availability2;
	            		  ts2.innerHTML = det.timestamp2;
	            		  
	            		  add3.innerHTML = det.address3;
	            		  btn3.innerHTML = det.refresh3;
	            		  lbl3.innerHTML = det.sName3;
	            		  avail3.innerHTML = det.availability3;
	            		  ts3.innerHTML = det.timestamp3;
	            		  
	            		  add4.innerHTML = det.address4;
	            		  btn4.innerHTML = det.refresh4;
	            		  lbl4.innerHTML = det.sName4;
	            		  avail4.innerHTML = det.availability4;
	            		  ts4.innerHTML = det.timestamp4;
	            	  }
	              }
	              else {
	            	  alert("Error ->" + xmlhttp.responseText);
	              }
	    	}
	    };
	}	
}

function callCommon1() {
    var sname = document.getElementById("lblServerName1");
    var url = "http://localhost:8080/ParkingService/rest/garage/" + sname.innerHTML;
    xmlhttp.open('GET',url,true);
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function() {

           var avail =  document.getElementById("availability1");
           var ts =  document.getElementById("timestamp1");
           if (xmlhttp.readyState == 4) {
              if ( xmlhttp.status == 200) {
                   var det = JSON.parse(xmlhttp.responseText);
                   if (det != null) {
                	   avail.innerHTML = det.avail;
                	   var time = det.time;
                	   var newtime = time.substr(time.length - 8);
                	   var now = new Date();
                	   now.setHours(newtime.substr(0,newtime.indexOf(".")));
                	   now.setMinutes(newtime.substr(newtime.indexOf(".")+1));
                	   now.setSeconds(newtime.substr(newtime.indexOf(".")+2));
                	   ts.innerHTML = now;
                   }
                   
             }
             else
                   alert("Error ->" + xmlhttp.responseText);
          }
    };
}
function callCommon2() {
    var sname = document.getElementById("lblServerName2");
    var url = "http://localhost:8080/ParkingService/rest/garage/" + sname.innerHTML;
    xmlhttp.open('GET',url,true);
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function() {

           var avail =  document.getElementById("availability2");
           var ts =  document.getElementById("timestamp2");
           if (xmlhttp.readyState == 4) {
              if ( xmlhttp.status == 200) {
            	  var det = JSON.parse(xmlhttp.responseText);
                  if (det != null) {
               	   avail.innerHTML = det.avail;
               	   var time = det.time;
               	   var newtime = time.substr(time.length - 8);
               	   var now = new Date();
               	   now.setHours(newtime.substr(0,newtime.indexOf(".")));
               	   now.setMinutes(newtime.substr(newtime.indexOf(".")+1));
               	   now.setSeconds(newtime.substr(newtime.indexOf(".")+2));
               	   ts.innerHTML = now;
                  }
                   
             }
             else
                   alert("Error ->" + xmlhttp.responseText);
          }
    };
}
function callCommon3() {
    var sname = document.getElementById("lblServerName3");
    var url = "http://localhost:8080/ParkingService/rest/garage/" + sname.innerHTML;
    xmlhttp.open('GET',url,true);
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function() {

           var avail =  document.getElementById("availability3");
           var ts =  document.getElementById("timestamp3");
           if (xmlhttp.readyState == 4) {
              if ( xmlhttp.status == 200) {
            	  var det = JSON.parse(xmlhttp.responseText);
                  if (det != null) {
               	   avail.innerHTML = det.avail;
               	   var time = det.time;
               	   var newtime = time.substr(time.length - 8);
               	   var now = new Date();
               	   now.setHours(newtime.substr(0,newtime.indexOf(".")));
               	   now.setMinutes(newtime.substr(newtime.indexOf(".")+1));
               	   now.setSeconds(newtime.substr(newtime.indexOf(".")+2));
               	   ts.innerHTML = now;
                  }
                   
             }
             else
                   alert("Error ->" + xmlhttp.responseText);
          }
    };
}
function callCommon4() {
    var sname = document.getElementById("lblServerName4");
    var url = "http://localhost:8080/ParkingService/rest/garage/" + sname.innerHTML;
    xmlhttp.open('GET',url,true);
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function() {

           var avail =  document.getElementById("availability4");
           var ts =  document.getElementById("timestamp4");
           if (xmlhttp.readyState == 4) {
              if ( xmlhttp.status == 200) {
            	  var det = JSON.parse(xmlhttp.responseText);
                  if (det != null) {
               	   avail.innerHTML = det.avail;
               	   var time = det.time;
               	   var newtime = time.substr(time.length - 8);
               	   var now = new Date();
               	   now.setHours(newtime.substr(0,newtime.indexOf(".")));
               	   now.setMinutes(newtime.substr(newtime.indexOf(".")+1));
               	   now.setSeconds(newtime.substr(newtime.indexOf(".")+2));
               	   ts.innerHTML = now;
                  }
             }
             else
                   alert("Error ->" + xmlhttp.responseText);
          }
    };
}
function callGarage1(){
	var sname = document.getElementById("lblServerName1");
    var url = "http://localhost:8080/ParkingService/rest/garage/" + sname.innerHTML;
    xmlhttp.open('GET',url,true);
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function() {

           var avail =  document.getElementById("availability1");
           var ts =  document.getElementById("timestamp1");
           if (xmlhttp.readyState == 4) {
              if ( xmlhttp.status == 200) {
            	  var det = JSON.parse(xmlhttp.responseText);
                  if (det != null) {
               	   avail.innerHTML = det.avail;
               	   var time = det.time;
               	   var newtime = time.substr(time.length - 8);
               	   var now = new Date();
               	   now.setHours(newtime.substr(0,newtime.indexOf(".")));
               	   now.setMinutes(newtime.substr(newtime.indexOf(".")+1));
               	   now.setSeconds(newtime.substr(newtime.indexOf(".")+2));
               	   ts.innerHTML = now;
                  }
             }
             else
                   alert("Error ->" + xmlhttp.responseText);
          }
    };
}
function callGarage2(){
    var sname = document.getElementById("lblServerName2");
    var url = "http://localhost:8080/ParkingService/rest/garage/" + sname.innerHTML;
    xmlhttp.open('GET',url,true);
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function() {

           var avail =  document.getElementById("availability2");
           var ts =  document.getElementById("timestamp2");
           if (xmlhttp.readyState == 4) {
              if ( xmlhttp.status == 200) {
            	  var det = JSON.parse(xmlhttp.responseText);
                  if (det != null) {
               	   avail.innerHTML = det.avail;
               	   var time = det.time;
               	   var newtime = time.substr(time.length - 8);
               	   var now = new Date();
               	   now.setHours(newtime.substr(0,newtime.indexOf(".")));
               	   now.setMinutes(newtime.substr(newtime.indexOf(".")+1));
               	   now.setSeconds(newtime.substr(newtime.indexOf(".")+2));
               	   ts.innerHTML = now;
                  }
             }
             else
                   alert("Error ->" + xmlhttp.responseText);
          }
    };
}
function callGarage3(){
	var sname = document.getElementById("lblServerName3");
    var url = "http://localhost:8080/ParkingService/rest/garage/" + sname.innerHTML;
    xmlhttp.open('GET',url,true);
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function() {

           var avail =  document.getElementById("availability3");
           var ts =  document.getElementById("timestamp3");
           if (xmlhttp.readyState == 4) {
              if ( xmlhttp.status == 200) {
            	  var det = JSON.parse(xmlhttp.responseText);
                  if (det != null) {
               	   avail.innerHTML = det.avail;
               	   var time = det.time;
               	   var newtime = time.substr(time.length - 8);
               	   var now = new Date();
               	   now.setHours(newtime.substr(0,newtime.indexOf(".")));
               	   now.setMinutes(newtime.substr(newtime.indexOf(".")+1));
               	   now.setSeconds(newtime.substr(newtime.indexOf(".")+2));
               	   ts.innerHTML = now;
                  }
             }
             else
                   alert("Error ->" + xmlhttp.responseText);
          }
    };
}
function callGarage4(){
	  var sname = document.getElementById("lblServerName4");
	    var url = "http://localhost:8080/ParkingService/rest/garage/" + sname.innerHTML;
	    xmlhttp.open('GET',url,true);
	    xmlhttp.send(null);
	    xmlhttp.onreadystatechange = function() {

	           var avail =  document.getElementById("availability4");
	           var ts =  document.getElementById("timestamp4");
	           if (xmlhttp.readyState == 4) {
	              if ( xmlhttp.status == 200) {
	            	  var det = JSON.parse(xmlhttp.responseText);
	                   if (det != null) {
	                	   avail.innerHTML = det.avail;
	                	   var time = det.time;
	                	   var newtime = time.substr(time.length - 8);
	                	   var now = new Date();
	                	   now.setHours(newtime.substr(0,newtime.indexOf(".")));
	                	   now.setMinutes(newtime.substr(newtime.indexOf(".")+1));
	                	   now.setSeconds(newtime.substr(newtime.indexOf(".")+2));
	                	   ts.innerHTML = now;
	                   }
	             }
	             else
	                   alert("Error ->" + xmlhttp.responseText);
	          }
	    };
}