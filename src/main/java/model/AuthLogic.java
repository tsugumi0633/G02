package model;

import dao.UsersDAO;
import jakarta.servlet.http.HttpSession;

public class AuthLogic {
	public User login(String email,String pass) {
		UsersDAO usersDAO = new UsersDAO();
		return usersDAO.findByLogin(email, pass);
	}
	public void logout(HttpSession session) {
		if(isLoggedIn(session)) {
			session.removeAttribute("loginUser");
			}
	}
	public boolean isLoggedIn(HttpSession session) {
		return session.getAttribute("loginUser") != null;
		}
}