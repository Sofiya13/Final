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
       
        String username = request.getParameter("username");
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sample WHERE username = '" + username + "'");

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            // Generate the HTML response
            out.println("<html>");
            out.println("<head><title>Admin Sample Data</title>");
            out.println("<link href='https://fonts.googleapis.com/css?family=Merienda' rel='stylesheet'>");
            out.println("<style>");
            out.println("body { font-family:'Merienda'; text-align: center; background-color: #E9EBE0; }");
            out.println("table { border-collapse: collapse; margin: 20px auto; box-shadow: 0 0 30px rgba(0, 0, 0, 0.1); }");
            out.println("th, td { padding: 10px 20px; text-align: center; border: 2px solid #ddd; }");
            out.println("th { background-color: #2F3C7E; color: white; }");
            out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
            out.println("a { text-decoration: none; color: #E9EBE0; }");
            out.println("h1{ color: #2F3C7E;}");
            out.println("button { background-color: #2F3C7E; color: #FBEAEB; border: none; padding: 5px 10px; cursor: pointer; }");
            out.println("a:hover {  color:black;}");
            out.println("button:hover{background-color: #E9EBE0;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Admin Sample Data</h1>");
            out.println("<table>");
            out.println("<tr><th>Design</th><th>Color</th><th>Price</th><th>Date</th><th>Decision</th></tr>");

            // Process the ResultSet and populate the infoList
            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td><img src='" + request.getContextPath() + "/images/" + resultSet.getString("imgName") + "' width='100' height='100'></td>");
                out.println("<td>" + resultSet.getInt("color") + "</td>");
                out.println("<td>" + resultSet.getInt("price") + "</td>");
                out.println("<td>" + resultSet.getDate("date") + "</td>");
                out.println("<td>");
                out.println("<button><a href='Client_challan.jsp?username=" + username + "'>Accept</a></button> | <button><a href='Client_view'>Reject</a></button>");
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
    }
}
