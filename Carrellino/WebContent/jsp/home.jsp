<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<style type="text/css">
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<title>Carrellino</title>
</head>
<body>
 <h1> <%="Benvenuto "+request.getAttribute("user")%> </h1> 
<h2> Eccoci su SpesAppWEB </h2>

<button type="button" onclick="loadDoc()">Visualizza Lista</button>
<p id="tabella"> <!--  Visualizza il carrello della spesa--> </p>
<script>
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("tabella").innerHTML = this.responseText;
    }
  };
  xhttp.open("POST", "tabella.jsp", true);
  xhttp.send();
}
</script>
<button type="button" onclick="inserisci()"> Inserisci Elementi </button>
<p id="azioni"> <!--  Visualizza il carrello della spesa--> </p>
<script>
function inserisci() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("azioni").innerHTML = this.responseText;
    }
  };
  xhttp.open("POST", "inserisci.html", true);
  xhttp.send();
}
</script>




</body>
</html>