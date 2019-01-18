package container;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaushik.voteapp.model.VoteSummary;
import com.kaushik.voteapp.service.CastService;
import com.kaushik.voteapp.service.impl.CastServiceImpl;

/**
 * Servlet implementation class AllCandidateResult
 */
@WebServlet("/AllCandidateResult")
public class AllCandidateResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllCandidateResult() {
        super();        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 List<VoteSummary> votes = new ArrayList<>();
		 
		 CastService all = new CastServiceImpl();
		 votes = all.candidatesVoteCount();
		
		 HttpSession session = request.getSession();
	     session.setAttribute("CANDIDATE_VOTES", votes);
		 
	     response.sendRedirect("allVotes.jsp");

	}
}
