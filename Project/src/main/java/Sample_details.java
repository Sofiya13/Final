import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class Sample_details extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String URL = "jdbc:mysql://localhost:3306/register";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       

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
                     ResultSet resultSet = statement.executeQuery("SELECT * FROM info");

                     PrintWriter out = response.getWriter();

                     // Generate the HTML response
                     out.println("<html>");
                     out.println("<head><title> Request Details</title>");
                     out.println("<style>");
                     out.println("a { text-decoration: none; color: black; }");
                     out.println("</style>");
                     out.println("</head>");
                     out.println("<body>");
                     out.println("<h1>All details of Sample</h1>");
                     out.println("<table border='1'>");
                     out.println("<tr><th>Username</th><th>Fabric Type</th><th>Sample Quantity</th><th>Contact</th><th>Date</th><th>Color_Hexcode</th><th>Design_image </th></tr>");

            // Process the ResultSet and populate the infoList
            while (resultSet.next()) {
            	  out.println("<tr>");
                  out.println("<td>" + resultSet.getString("username") + "</td>");
                  out.println("<td>" + resultSet.getString("fabric_type") + "</td>");
                  out.println("<td>" +resultSet.getInt("sample_quantity")+ "</td>");
                  out.println("<td>" +  resultSet.getLong("contact") + "</td>");
                  out.println("<td>" + resultSet.getDate("date") + "</td>");
                  out.println("<td>" + resultSet.getInt("color") + "</td>");

                  out.println("<td><img src='/Final/Project/images/" + resultSet.getString("imgName") + "' width='100' height='100'></td>");

                  out.println("</tr>");
            }
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");

                out.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            // In case of database errors, you might handle the error here or redirect to an error page.
           
            return;
        }

        // Forward the infoList to the JSP view for display
        
        request.getRequestDispatcher("clientrequest.jsp").forward(request, response);
    }
}