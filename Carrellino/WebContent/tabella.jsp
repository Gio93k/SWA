<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
   
     <%@page import="java.sql.*"%>

</head>

<body>
<%
    try
    { 	     
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     Connection con=(Connection)DriverManager.getConnection("jdbc:sqlserver://\\localhost:1433; databaseName=dbprova;integratedSecurity=true;");
	 Statement	st = con.createStatement();
     ResultSet  rs=st.executeQuery("select * from Articoli;");
    %><table border=1 align=center style="text-align:center">
      <thead>
          <tr>
             <th>ID</th>
             <th>Articolo</th>
          </tr>
      </thead>
      <tbody>
        <%while(rs.next())
        {
            %>
            <tr>
                <td><%=rs.getString("id_art") %></td>
                <td><%=rs.getString("Articolo") %></td>
            </tr>
            <%}%>
           </tbody>
        </table>
    <%} 
    catch(Exception e){
        out.print(e.getMessage());       
        } //ci vorrebbe un finally che chiude la connessione al db
        
        
        
        %>
</body>
</html>