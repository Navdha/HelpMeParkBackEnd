<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HelpMe Park</title>
<link rel="stylesheet" type="text/css" href="park.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
	var xmlhttp;
	var now;
	var xmlDBobj;
	var errorDiv;
	function init() {
		// put more code here in case you are concerned about browsers that do not provide XMLHttpRequest object directly
		xmlhttp = new XMLHttpRequest();
		xmlDBobj = new XMLHttpRequest();
		errorDiv = document.getElementById("error");
	}
	function callDB() {
		var loc = document.getElementById("ddlLocation");
		if (loc.selectedIndex != -1) {
			var url = "http://comp512.pagekite.me/DatabaseService/rest/database/"
					+ loc.options[loc.selectedIndex].text;
			xmlDBobj.open('GET', url, true);
			xmlDBobj.send(null);
			xmlDBobj.onreadystatechange = function() {
				var add = document.getElementById("address");
				var avail = document.getElementById("availability");
				var ts = document.getElementById("timestamp");
				var add1 = document.getElementById("address1");
				var btn1 = document.getElementById("refresh1");
				var lbl1 = document.getElementById("lblServerName1");
				var avail1 = document.getElementById("availability1");
				var ts1 = document.getElementById("timestamp1");

				var add2 = document.getElementById("address2");
				var btn2 = document.getElementById("refresh2");
				var lbl2 = document.getElementById("lblServerName2");
				var avail2 = document.getElementById("availability2");
				var ts2 = document.getElementById("timestamp2");

				var add3 = document.getElementById("address3");
				var btn3 = document.getElementById("refresh3");
				var lbl3 = document.getElementById("lblServerName3");
				var avail3 = document.getElementById("availability3");
				var ts3 = document.getElementById("timestamp3");

				var add4 = document.getElementById("address4");
				var btn4 = document.getElementById("refresh4");
				var lbl4 = document.getElementById("lblServerName4");
				var avail4 = document.getElementById("availability4");
				var ts4 = document.getElementById("timestamp4");
				var time;
				if (xmlDBobj.readyState == 4) {
					if (xmlDBobj.status == 200) {
						var det = JSON.parse(xmlDBobj.responseText);
						if (det != null) {
							add.innerHTML = det.address;
							avail.innerHTML = det.availability;
							ts.innerHTML = det.timestamp;
							add1.innerHTML = det.address1;
							btn1.innerHTML = det.refresh1;
							lbl1.innerHTML = det.sName1;
							avail1.innerHTML = det.availability1;
							time = det.timestamp1;
							time = time.substr(time.length - 8);
							time = time.replace(/\./g, ':');
							ts1.innerHTML = time;

							add2.innerHTML = det.address2;
							btn2.innerHTML = det.refresh2;
							lbl2.innerHTML = det.sName2;
							avail2.innerHTML = det.availability2;
							time = det.timestamp2;
							time = time.substr(time.length - 8);
							time = time.replace(/\./g, ':');
							ts2.innerHTML = time;

							add3.innerHTML = det.address3;
							btn3.innerHTML = det.refresh3;
							lbl3.innerHTML = det.sName3;
							avail3.innerHTML = det.availability3;
							time = det.timestamp3;
							time = time.substr(time.length - 8);
							time = time.replace(/\./g, ':');
							ts3.innerHTML = time;

							add4.innerHTML = det.address4;
							btn4.innerHTML = det.refresh4;
							lbl4.innerHTML = det.sName4;
							avail4.innerHTML = det.availability4;
							time = det.timestamp4;
							time = time.substr(time.length - 8);
							time = time.replace(/\./g, ':');
							ts4.innerHTML = time;
						}
					} else {
						errorDiv.innerHTML = "Error ->" + xmlhttp.responseText;
					}
				}
			};
		}
	}

	function callCommon1() {
		var sname = document.getElementById("lblServerName1");
		var url = "http://comp512.pagekite.me/ParkingService/rest/garage/"
				+ sname.innerHTML;
		xmlhttp.open('GET', url, true);
		xmlhttp.send(null);
		xmlhttp.onreadystatechange = function() {

			var avail = document.getElementById("availability1");
			var ts = document.getElementById("timestamp1");
			if (xmlhttp.readyState == 4) {
				if (xmlhttp.status == 200) {
					var det = JSON.parse(xmlhttp.responseText);
					if (det != null) {
						avail.innerHTML = det.avail;
						var time = det.time;
						var newtime = time.substr(time.length - 8);
						now = newtime.replace(/\./g, ':');
						ts.innerHTML = now;
					}

				} else
				errorDiv.innerHTML = "Error ->" + xmlhttp.responseText;
			}
		};
	}
	function callCommon2() {
		var sname = document.getElementById("lblServerName2");
		var url = "http://comp512.pagekite.me/ParkingService/rest/garage/"
				+ sname.innerHTML;
		xmlhttp.open('GET', url, true);
		xmlhttp.send(null);
		xmlhttp.onreadystatechange = function() {

			var avail = document.getElementById("availability2");
			var ts = document.getElementById("timestamp2");
			if (xmlhttp.readyState == 4) {
				if (xmlhttp.status == 200) {
					var det = JSON.parse(xmlhttp.responseText);
					if (det != null) {
						avail.innerHTML = det.avail;
						var time = det.time;
						var newtime = time.substr(time.length - 8);
						now = newtime.replace(/\./g, ':');
						ts.innerHTML = now;
					}

				} else
					errorDiv.innerHTML = "Error ->" + xmlhttp.responseText;
			}
		};
	}
	function callCommon3() {
		var sname = document.getElementById("lblServerName3");
		var url = "http://comp512.pagekite.me/ParkingService/rest/garage/"
				+ sname.innerHTML;
		xmlhttp.open('GET', url, true);
		xmlhttp.send(null);
		xmlhttp.onreadystatechange = function() {

			var avail = document.getElementById("availability3");
			var ts = document.getElementById("timestamp3");
			if (xmlhttp.readyState == 4) {
				if (xmlhttp.status == 200) {
					var det = JSON.parse(xmlhttp.responseText);
					if (det != null) {
						avail.innerHTML = det.avail;
						var time = det.time;
						var newtime = time.substr(time.length - 8);
						now = newtime.replace(/\./g, ':');
						ts.innerHTML = now;
					}

				} else
					errorDiv.innerHTML = "Error ->" + xmlhttp.responseText;
			}
		};
	}
	function callCommon4() {
		var sname = document.getElementById("lblServerName4");
		var url = "http://comp512.pagekite.me/ParkingService/rest/garage/"
				+ sname.innerHTML;
		xmlhttp.open('GET', url, true);
		xmlhttp.send(null);
		xmlhttp.onreadystatechange = function() {

			var avail = document.getElementById("availability4");
			var ts = document.getElementById("timestamp4");
			if (xmlhttp.readyState == 4) {
				if (xmlhttp.status == 200) {
					var det = JSON.parse(xmlhttp.responseText);
					if (det != null) {
						avail.innerHTML = det.avail;
						var time = det.time;
						var newtime = time.substr(time.length - 8);
						now = newtime.replace(/\./g, ':');
						ts.innerHTML = now;
					}
				} else
					errorDiv.innerHTML = "Error ->" + xmlhttp.responseText;
			}
		};
	}
	function callGarage1() {
		var sname = document.getElementById("lblServerName1");
		var url = "http://comp512.pagekite.me/ParkingService/rest/garage/"
				+ sname.innerHTML;
		xmlhttp.open('GET', url, true);
		xmlhttp.send(null);
		xmlhttp.onreadystatechange = function() {

			var avail = document.getElementById("availability1");
			var ts = document.getElementById("timestamp1");
			if (xmlhttp.readyState == 4) {
				if (xmlhttp.status == 200) {
					var det = JSON.parse(xmlhttp.responseText);
					if (det != null) {
						avail.innerHTML = det.avail;
						var time = det.time;
						var newtime = time.substr(time.length - 8);
						now = newtime.replace(/\./g, ':');
						ts.innerHTML = now;
					}
				} else
					errorDiv.innerHTML = "Error ->" + xmlhttp.responseText;
			}
		};
	}
	function callGarage2() {
		var sname = document.getElementById("lblServerName2");
		var url = "http://comp512.pagekite.me/ParkingService/rest/garage/"
				+ sname.innerHTML;
		xmlhttp.open('GET', url, true);
		xmlhttp.send(null);
		xmlhttp.onreadystatechange = function() {

			var avail = document.getElementById("availability2");
			var ts = document.getElementById("timestamp2");
			if (xmlhttp.readyState == 4) {
				if (xmlhttp.status == 200) {
					var det = JSON.parse(xmlhttp.responseText);
					if (det != null) {
						avail.innerHTML = det.avail;
						var time = det.time;
						var newtime = time.substr(time.length - 8);
						now = newtime.replace(/\./g, ':');
						ts.innerHTML = now;
					}
				} else
					errorDiv.innerHTML = "Error ->" + xmlhttp.responseText;
			}
		};
	}
	function callGarage3() {
		var sname = document.getElementById("lblServerName3");
		var url = "http://comp512.pagekite.me/ParkingService/rest/garage/"
				+ sname.innerHTML;
		xmlhttp.open('GET', url, true);
		xmlhttp.send(null);
		xmlhttp.onreadystatechange = function() {

			var avail = document.getElementById("availability3");
			var ts = document.getElementById("timestamp3");
			if (xmlhttp.readyState == 4) {
				if (xmlhttp.status == 200) {
					var det = JSON.parse(xmlhttp.responseText);
					if (det != null) {
						avail.innerHTML = det.avail;
						var time = det.time;
						var newtime = time.substr(time.length - 8);
						now = newtime.replace(/\./g, ':');
						ts.innerHTML = now;
					}
				} else
					errorDiv.innerHTML = "Error ->" + xmlhttp.responseText;
			}
		};
	}
	function callGarage4() {
		var sname = document.getElementById("lblServerName4");
		var url = "http://comp512.pagekite.me/ParkingService/rest/garage/"
				+ sname.innerHTML;
		xmlhttp.open('GET', url, true);
		xmlhttp.send(null);
		xmlhttp.onreadystatechange = function() {

			var avail = document.getElementById("availability4");
			var ts = document.getElementById("timestamp4");
			if (xmlhttp.readyState == 4) {
				if (xmlhttp.status == 200) {
					var det = JSON.parse(xmlhttp.responseText);
					if (det != null) {
						avail.innerHTML = det.avail;
						var time = det.time;
						var newtime = time.substr(time.length - 8);
						now = newtime.replace(/\./g, ':');
						ts.innerHTML = now;
					}
				} else
					errorDiv.innerHTML = "Error ->" + xmlhttp.responseText;
			}
		};
	}
</script>
<body class="centered" onload="init();">
	<header> <img src="logo.jpeg" alt="Logo" height="100"
		width="100"> </header>

	<div class="tbl">
		<div class="table-row">
			<div class="table-cel">
				<label><b>Choose Location:</b></label>
			</div>
			<div class="table-cel">
				<select id="ddlLocation" name="ddlLocation">
					<option value="Middletown">Middletown</option>
					<option value="Pittsburg">Pittsburgh</option>
				</select>
			</div>
		</div>
	</div>
	<div class="table">
		<div class="table-row">
			<div class="table-cell1" id="address"></div>
			<div class="table-cell" id="availability"></div>
			<div class="table-cell" id="timestamp"></div>
		</div>
		<div class="table-row">
			<div class="table-cell1" id="address1"></div>
			<div class="table-cell" id="availability1"></div>
			<div class="table-cell" id="timestamp1"></div>
			<div class="table-cell" id="refresh1"></div>
			<label id="lblServerName1" class="hidden"> </label>
		</div>
		<div class="table-row">
			<div class="table-cell1" id="address2"></div>
			<div class="table-cell" id="availability2"></div>
			<div class="table-cell" id="timestamp2"></div>
			<div class="table-cell" id="refresh2"></div>
			<label id="lblServerName2" class="hidden"></label>
		</div>
		<div class="table-row">
			<div class="table-cell1" id="address3"></div>
			<div class="table-cell" id="availability3"></div>
			<div class="table-cell" id="timestamp3"></div>
			<div class="table-cell" id="refresh3"></div>
			<label id="lblServerName3" class="hidden"></label>
		</div>
		<div class="table-row">
			<div class="table-cell1" id="address4"></div>
			<div class="table-cell" id="availability4"></div>
			<div class="table-cell" id="timestamp4"></div>
			<div class="table-cell" id="refresh4"></div>
			<label id="lblServerName4" class="hidden"></label>
		</div>
	</div>
	<p>
		<input id="btnSubmit" type="submit" value="Submit" onclick="callDB();" />
	</p>

	<footer> <small>Copyright &copy; 2016</small> </footer>
	<div id="error" class="hidden"></div>
</body>
</html>