

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class Admin_sampleController
 */
@MultipartConfig
@WebServlet("/Admin_sampleController")
public class Admin_sampleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Admin_sampleDAO admin_sampleDAO;

    public void init() {
    	admin_sampleDAO = new Admin_sampleDAO();
    }
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date date = null;
        Part file=request.getPart("design_image");
        int price1 = Integer.parseInt(request.getParameter("price"));
        
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
      
       String uploadpath = "C:/Users/Shaki/git/Final/Project/src/main/webapp/images/" + imageFileName;

       
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
        
        Admin_sample user = new Admin_sample();
       user.setUsername(request.getParameter("username"));
        user.setDate(date);
        user.setImageFileName(imageFileName);
        user.setHexValue(hexValue);
        user.setPrice(price1);

        admin_sampleDAO.insertUser(user);

        // You can add additional logic here, e.g., redirecting to a success page.
        // For simplicity, we're not adding any further processing in this example.

        response.sendRedirect("Sample_details?username="+ request.getParameter("username") ); // Replace with your success page URL
    }
}