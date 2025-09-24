package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.GoodsDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Goods;
import model.ListLogic;

/**
 * Servlet implementation class CartAddServlet
 */
@WebServlet("/CartAddServlet")
public class CartAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		if(idParam == null) { //メニューから遷移
		//cart.jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cart.jsp");
            dispatcher.forward(request, response);
		} else { //list.jspから遷移
		int id = Integer.parseInt(idParam);
		ListLogic logic = new ListLogic();
		Goods goods = logic.get(id);
		request.setAttribute("goods", goods);
		//cartadd.jstにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cartadd.jsp");
        dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
	    String quantityParam = request.getParameter("num");
		
	    HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Cart> cartList = (List<Cart>)session.getAttribute("cartList");
		
		if(cartList == null) {

			cartList = new ArrayList<Cart>();

		}
		
		// カートインスタンスを作成
        int id = Integer.parseInt(idParam);
        int quantity = Integer.parseInt(quantityParam);
        GoodsDAO goodsDAO = new GoodsDAO();
        Goods goods = goodsDAO.get(id); // 商品を取得 
        
        if (goods != null) {
            Cart cart = new Cart(goods, quantity); // Cartクラスのインスタンスを作成
            cartList.add(cart); // cartlist に追加
        }
        
     // セッションスコープに cartlist を保存
        session.setAttribute("cartlist", cartList);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/cart.jsp");
		rd.forward(request, response);
	}

}
