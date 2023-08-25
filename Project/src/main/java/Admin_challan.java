
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin_challan
 */
@WebServlet("/Admin_challan")
public class Admin_challan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String URL = "jdbc:mysql://localhost:3306/register";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();
			String on = request.getParameter("username");
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM challan  WHERE username='" + on + "'");

			PrintWriter out = response.getWriter();

			// Generate the HTML response
			out.println("<html>");
			out.println("<head><title>Admin side</title>");
			out.println("<style>");
			out.println("a { text-decoration: none; color: black; }");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Client sent challan</h1>");
			out.println("<h2>Your sample is successfully approved by client and here the order challan is.</h2>");
			out.println("<table border='1'>");
			out.println(
					"<tr><th>From</th><th>To</th><th> Quantity</th><th>Product_details</th><th>challan_number</th><th>rate</th><th>Final Amount</th><th>Date</th></tr>");

			// Process the ResultSet and populate the infoList
			while (resultSet.next()) {
				out.println("<tr>");
				out.println("<td>" + resultSet.getString("from_location") + "</td>");
				out.println("<td>" + resultSet.getString("to_location") + "</td>");
				out.println("<td>" + resultSet.getInt("quantity") + "</td>");
				out.println("<td>" + resultSet.getString("product_details") + "</td>");
				out.println("<td>" + resultSet.getObject("challan_number") + "</td>");
				out.println("<td>" + resultSet.getDouble("rate") + "</td>");
				out.println("<td>" + resultSet.getDouble("final_amount") + "</td>");
				out.println("<td>" + resultSet.getObject("date") + "</td>");
				//out.println("<td>" + resultSet.getDate("challan_number") + "</td>");
				out.println("<td>");
			out.println("<button><a href=''>Collect Order</a></button> | <button><a href=''>Reject</a></button>");

				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");

		} catch (SQLException e) {
			e.printStackTrace();
			// In case of database errors, you might handle the error here or redirect to an
			// error page.

			return;
		}

	}

}
