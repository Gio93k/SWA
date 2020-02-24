package mioPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
	  Connection conn;
      Statement stmt;
      String name,pw;
      String dbUrl="jdbc:sqlserver://localhost\\SQLEXPRESS;Database=master;Trusted_Connection=True;";
      
      
      /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		name=request.getParameter("user");
		pw=request.getParameter("psw");
		try {
		Class.forName("com.microsoft.Sqlserver.jdbc.SQLServerDriver");
		conn =DriverManager.getConnection(dbUrl);
		stmt = conn.createStatement();
		
		String insertQuery = "insert into Prova1 values(' "+name+"');";
		stmt.executeQuery(insertQuery);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
