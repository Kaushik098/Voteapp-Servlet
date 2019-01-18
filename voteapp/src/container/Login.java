package container;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaushik.voteapp.model.User;
import com.kaushik.voteapp.service.UserService;
import com.kaushik.voteapp.service.impl.UserServiceImpl;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter w = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");
		String adhaarNumber = request.getParameter("an");
	
	if(name.equals("admin11") && password.equals("admin11") && adhaarNumber.equals("111")){
	     response.sendRedirect("admin.jsp");		
	}
		
	else{
			
		UserService userLogin = new UserServiceImpl();
	    User user = userLogin.login(name,password,adhaarNumber);
	    
	    if(user != null){
	     HttpSession session = request.getSession();
	     session.setAttribute("LOGGED_IN_USER", user);
	       
	     response.sendRedirect("Cast.jsp");
	    }
		else{
			request.setAttribute("ERROR_MSG", "invalid email/password");
			RequestDispatcher req = request.getServletContext().getRequestDispatcher("/login.jsp");
			req.forward(request, response);	
			
		//	response.sendRedirect("index.jsp");
		}
		
	}
	
	
	}
}
