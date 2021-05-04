package testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServletDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setup connection variables
		String user = "root";
		String pass = "rootroot";

		String url = "jdbc:mysql://localhost:3306/springhibernate";
		String driver = "com.mysql.jdbc.Driver";

		// get connection to database
		try {
			PrintWriter out = response.getWriter();
			out.println("connecting to database :" + url);

			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(url, user, pass);
			out.println("connection succesful :  " + myConn);

			myConn.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
