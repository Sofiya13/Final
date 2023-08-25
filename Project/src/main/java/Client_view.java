import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class Client_view extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String URL = "jdbc:mysql://localhost:3306/register";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
String username= request.getParameter("username");
        try 
        	 {
        		try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			 Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                     Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery("SELECT * FROM sample WHERE username = '" + username + "'");

                     PrintWriter out = response.getWriter();

                     // Generate the HTML response
                     out.println("<html>");
                     out.println("<head><title>Admin sample data</title>");
                     out.println("<style>");
                     out.println("a { text-decoration: none; color: black; }");
                     out.println("</style>");
                     out.println("</head>");
                     out.println("<body>");
                     out.println("<h1>Admin sample data</h1>");
                     out.println("<table border='1'>");
                     out.println("<tr><th>Design</th><th>Color</th><th>Price</th><th>Date</th></tr>");

            // Process the ResultSet and populate the infoList
            while (resultSet.next()) {
            	  out.println("<tr>");
                  out.println("<td><img src='" + request.getContextPath() + "/images/" + resultSet.getString("imgName") + "' width='100' height='100'></td>");
                  out.println("<td>" + resultSet.getInt("color") + "</td>");
            	  out.println("<td>" + resultSet.getInt("price") + "</td>");
                  out.println("<td>" + resultSet.getDate("date") + "</td>");
                  out.println("<td>");
                  out.println("<button><a href='Client_challan.jsp?username="+username+"'>Accept</a></button> | <button><a href='Client_view'>Reject</a></button>");
                  
                  out.println("</td>");
                  out.println("</tr>");
            }
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");

              
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            // In case of database errors, you might handle the error here or redirect to an error page.
           
            return;
        }

        // Forward the infoList to the JSP view for display
        
      //  request.getRequestDispatcher("client.jsp").forward(request, response);
    }
}