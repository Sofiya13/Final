import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;
import java.awt.Color;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

@MultipartConfig
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
        Part file=request.getPart("design_image");
       
        
        String hexValueStr = request.getParameter("hexValue");
        int hexValue = 0;        

        if (hexValueStr != null && !hexValueStr.isEmpty()) {
            if (hexValueStr.startsWith("#")) {
                hexValueStr = hexValueStr.substring(1);
            }

            // Parse the hexadecimal string
            hexValue = Integer.parseInt(hexValueStr, 16);
        }
        Color color1 = new Color(hexValue);
        System.out.println(color1);

        String imageFileName=file.getSubmittedFileName();
        System.out.println("Selected Image File Name : "+imageFileName);
      
        String uploadpath = request.getServletContext().getRealPath("/images/") + imageFileName;

        System.out.println("Upload path: "+uploadpath);
        
        
       
		
        try
        {
        FileOutputStream fos=new FileOutputStream(uploadpath);
        InputStream is=file.getInputStream();
        byte[] data=new byte[is.available()];
        is.read(data);
        fos.write(data);
        fos.close();
        
        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
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
        user.setImageFileName(imageFileName);
        user.setHexValue(hexValue);
        requestDAO.insertUser(user);

        // You can add additional logic here, e.g., redirecting to a success page.
        // For simplicity, we're not adding any further processing in this example.

        response.sendRedirect("success.jsp"); // Replace with your success page URL
    }
}
