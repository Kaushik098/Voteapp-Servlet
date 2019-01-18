package container;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaushik.voteapp.service.CandidateService;
import com.kaushik.voteapp.service.CastService;
import com.kaushik.voteapp.service.impl.CandidateServiceImpl;
import com.kaushik.voteapp.service.impl.CastServiceImpl;

/**
 * Servlet implementation class AddCandidate
 */
@WebServlet("/AddCandidate")
public class AddCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int candidateID = Integer.parseInt(request.getParameter("cID"));
		String candidateName = request.getParameter("cN");
		
		CandidateService add = new CandidateServiceImpl();
		add.addCandidate(candidateID, candidateName);
	   
		System.out.println("Candidate Added");
	}

}
