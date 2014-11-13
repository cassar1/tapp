package implementation;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String user = request.getParameter("username_field");
		String pass = request.getParameter("password_field");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String dob = request.getParameter("dob");
		String type = request.getParameter("type");
		String credit_card_num = request.getParameter("credit_card_num");
		String expiry_date = request.getParameter("expiry_date");
		String cvv = request.getParameter("cvv");

		User us= new User();


		/*JSONObject JObject = new JSONObject(); 
	    JObject.put("Response", "1"); 
	    JObject.put("Message", "Client unauthorized"); 
	        
		for(int i = 0; i < validate.length;i++)
		{
			if(validate[i] == false)
			{
				
			}
		}*/
		
		if ("edu4java".equals(user) && "eli4java".equals(pass)) {
			try 
			{
				response.sendRedirect("index.jsp");
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("");
		}
	}
    public Register() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
