import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

@WebServlet("/ChallanServlet")
public class ChallanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        // Initialize DataSource (Tomcat DBCP example)
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/register");
        ds.setUsername("root");
        ds.setPassword("root");
        
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource = ds;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
       String user=request.getParameter("username");
       
        String quantity = request.getParameter("quantity");
        String productDetails = request.getParameter("productDetails");
        String rate = request.getParameter("rate");
        String finalAmount = request.getParameter("finalAmount");

        Challan challan = new Challan(from, to,Integer.parseInt(quantity), productDetails, Double.parseDouble(rate), Double.parseDouble(finalAmount), user);
        ChallanDAO challanDAO = new ChallanDAO(dataSource);

        if (challanDAO.insertChallan(challan)) {
            response.getWriter().println("Challan inserted successfully.");
        } else {
            response.getWriter().println("Failed to insert challan.");
        }
    }
}
