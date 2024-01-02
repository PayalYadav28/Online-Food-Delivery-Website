package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cart;
import database.UserData;

/**
 * Servlet implementation class CancelServlet
 */
@WebServlet("/CancelServlet")
public class CancelServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		
		UserData ud =new UserData();
		
		
		boolean f=ud.deleteFromCart(id);
		
		List<Cart> products=ud.getCart(id);

		if(f) {
			HttpSession session=request.getSession();
			session.setAttribute("cart",products);
			
			response.sendRedirect("cart.jsp");
								
		}
		
		
		
		
		}

		
		

}
