package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AuthLogic;
import model.Goods;
import model.ListLogic;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AuthLogic logic = new AuthLogic();
        if (logic.isLoggedIn(session)) {
            ListLogic listLogic = new ListLogic();
            List<Goods> goodsList = listLogic.get();
            
            request.setAttribute("goodsList", goodsList);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
            dispatcher.forward(request, response);
        } else {
        	
        	ListLogic listLogic = new ListLogic();
        	List<Goods> list = listLogic.get();
        	request.setAttribute("goodslist", list);
        	
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		 if (keyword == null) {
			 keyword = "";
		 }
		 ListLogic listLogic = new ListLogic();
//         List<Goods> goodsList = listLogic.search(getServletContext(),keyword);
		 List<Goods> list = listLogic.search(keyword);
		 request.setAttribute("goodsList", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
        dispatcher.forward(request, response);
	}

}
