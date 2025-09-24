package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Fortune;
import model.User;

/**
 * Servlet implementation class UranaiServlet
 */
@WebServlet("/UranaiServlet")
public class UranaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		//		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/form.jsp");
//		dispatcher.forward(request,response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] luckArray = {"超スッキリ","まあまあスッキリ","スッキリ","最悪"};
		int index = (int)(Math.random() * luckArray.length);
		String luck = luckArray[index];
		
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH:mm:ss");
		String today = date.format(sdf);
		
//		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		String name = user.getName();
		
		Fortune fortune = new Fortune();
		fortune.setName(name);
		fortune.setToday(today);
		fortune.setLuck(luck);
		
		request.setAttribute("fortune", fortune);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/result.jsp");
		dispatcher.forward(request,response);
	}

}
