import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;


public class RequestController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RequestDAO requestDAO;

    public void init() {
    	requestDAO = new RequestDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String fabricType = request.getParameter("fabric_type");
        int sampleQuantity = Integer.parseInt(request.getParameter("sample_quantity"));
        String contact = request.getParameter("contact");
        Date date = null;
        try {
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
            date = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Client_request user = new Client_request();
        user.setUsername(username);
        user.setFabricType(fabricType);
        user.setSampleQuantity(sampleQuantity);
        user.setContact(contact);
        user.setDate(date);

        requestDAO.insertUser(user);

        // You can add additional logic here, e.g., redirecting to a success page.
        // For simplicity, we're not adding any further processing in this example.

        response.sendRedirect("success.jsp"); // Replace with your success page URL
    }
}
