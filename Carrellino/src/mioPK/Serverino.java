package mioPK;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.microsoft.sqlserver.jdbc.*;

/**
 * Servlet implementation class Serverino
 */
@WebServlet("/Serverino")
public class Serverino extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serverino() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    Connection connessioneDB ;
    Statement stmt ;
    String connString = "jdbc:sqlserver://\\localhost:1433; databaseName=dbprova;integratedSecurity=true;";
    
    String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// LOGIN
		RequestDispatcher dispatcher;
		String user = request.getParameter("user");
		String psw = request.getParameter("psw");		
		request.setAttribute("user", user);
		request.setAttribute("psw", psw);
		
		//Insert Articolo
		String articolo = request.getParameter("artic");
		String id_articolo = request.getParameter("id_artic");		
		request.setAttribute("art", articolo);
		request.setAttribute("id_art", id_articolo);
			
		try {
			Class.forName(driver);
			connessioneDB=DriverManager.getConnection(connString);
			stmt = connessioneDB.createStatement();
			
			String queryI="insert into Utenti values('"+user+"','"+psw+"');";
			stmt.execute(queryI);		
			System.out.println("Login avvenuto con successo!");
												
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// stampa select 
	/*	try {			
			Class.forName(driver);
			connessioneDB=DriverManager.getConnection(connString);
			stmt = connessioneDB.createStatement();
			
			String query="Select * from Articoli;";
			ResultSet rs = stmt.executeQuery(query);	
			while (rs.next()) {
				  String elem = rs.getString("Articolo");
				//  System.out.println(elem + "\n");				
				}
		
			System.out.println("Fatto!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			Class.forName(driver);
			connessioneDB=DriverManager.getConnection(connString);
			stmt = connessioneDB.createStatement();
			
			String queryIA="insert into Articoli values('"+id_articolo+"','"+articolo+"');";
			System.out.println("Inserimento avvenuto con successo!");
			stmt.execute(queryIA);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	
		dispatcher = getServletContext().getRequestDispatcher("/jsp/home.jsp");
		dispatcher.forward(request, response);
	}

}
