package container;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaushik.voteapp.service.CastService;
import com.kaushik.voteapp.service.impl.CastServiceImpl;

/**
 * Servlet implementation class IndividualCandidateResult
 */
@WebServlet("/IndividualCandidateResult")
public class IndividualCandidateResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndividualCandidateResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
        int candidateID = Integer.parseInt(request.getParameter("cID"));
		
		CastService individual = new CastServiceImpl();
		int voteCount = individual.candidateVoteCount(candidateID);
		
		System.out.println("The total vote count for candidateid "+ candidateID +" is "+ voteCount);
	}

	

}
