package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.RegisterUserLogic;
import model.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getParameter("action");
	        String forwardPath = null;
	        
		if(action == null) {
			forwardPath = "WEB-INF/jsp/registerForm.jsp";
		}
		else if(action.equals("done")){
			HttpSession session = request.getSession();
			User registerUser = (User)session.getAttribute("registerUser");
			RegisterUserLogic logic = new RegisterUserLogic();
			if(logic.execute(registerUser)) {
			session.removeAttribute("registerUser");//登録出来たら削除
			}
			forwardPath = "WEB-INF/jsp/registerDone.jsp";
		}
	        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
	        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String name = request.getParameter("name");

        // 入力チェック
        if (email == null || pass == null || name == null || 
            email.isEmpty() || pass.isEmpty() || name.isEmpty()) {
            request.setAttribute("msg", "入力内容に不備があります");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerForm.jsp");
            dispatcher.forward(request, response);
        }
        else {
        	User user = new User(email, name, pass); // Userクラスのコンストラクタを想定
            HttpSession session = request.getSession();
            session.setAttribute("registerUser", user);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerConfirm.jsp");
            dispatcher.forward(request, response);
        }
	}

}
