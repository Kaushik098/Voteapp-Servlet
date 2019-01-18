package container;

import java.io.IOException;

import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaushik.voteapp.dao.UserDAO;
import com.kaushik.voteapp.dao.impl.UserDAOImpl;
import com.kaushik.voteapp.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter printer = response.getWriter();
		
		System.out.println("Welcome");
		
		String adhaarName = request.getParameter("AdhaarName");
		String adhaarNumber = request.getParameter("AdhaarNumber");
	    String dob = request.getParameter("DateOfBirth");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String mob = request.getParameter("mobilenumber");
		String gender = request.getParameter("gender");
		
		User user = new User();
		user.setAdhaarName(adhaarName);
		user.setAdhaarNumber(adhaarNumber);
        LocalDate d = LocalDate.parse(dob);
        user.setDob(d);
		user.setUsername(username);
		user.setPassword(password);
		user.setMobileNumber(mob);
		user.setGender(gender);
		
		
		UserDAO register = new UserDAOImpl();
		register.register(user);
		printer.print("Successfully registered with name, "+adhaarName);
		
	    response.sendRedirect("login.jsp");
	}

}
