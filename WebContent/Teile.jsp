<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="Control.*" import="Model.*" import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eratzteile</title>

<script src="http://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/app-ajax.js" type="text/javascript"></script>
</head>
<body>
	<form id="form" action="TeileServlet" method="POST">
	
		Bezeichnung nach Wort durchsuchen:
		
		<input type="text" name="bezeichnung"/> <input type="submit"  name="submitSearch" value="Submit" />
		<br/>
		<br/>
		<h1>Ergebnisse</h1>
		
		<table>
			<tr>
				<th>TeileID</th>
				<th>VerkaufsID</th>
				<th>KompatibleKFZ</th>
				<th>Preis</th>
				<th>Verfügbarkeit</th>
				<th>Bezeichnung</th>
			</tr>
	
			<%
				try {
					
					ArrayList<Teile> teile = (ArrayList<Teile>) (session.getAttribute("Teile"));
					
					/*
					private int TeileID;
					private int VerkaufsID;
					private String kompatibleKFZ;
					private double preis;
					private boolean Verfügbarkeit;
					private String Bezeichnung;**/
					
					for(int i = 0; i < teile.size(); i++){
						out.println("<td>"+teile.get(i).getTeileID()+"</td>");
						out.println("<td>"+teile.get(i).getVerkaufsID()+"</td>");
						out.println("<td>"+teile.get(i).getKompatibleKFZ()+"</td>");
						out.println("<td>"+teile.get(i).getPreis()+"</td>");
						out.println("<td>"+teile.get(i).isVerfügbarkeit()+"</td>");
						out.println("<td>"+teile.get(i).getBezeichnung()+"</td>");
						
						out.print("</tr>");
						
					}
					out.print("</table>");
				
				}catch(Exception e){
					e.printStackTrace();
				}
			
			%>
		</table>
		
	</form>
	
	<script>
		function loadDoc() {
		  var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		      document.getElementById("form").innerHTML = this.responseText;
		    }
		  };
		  xhttp.open("GET", "Teile.jsp", true);
		  xhttp.send();
		}
	</script>


</body>
</html>