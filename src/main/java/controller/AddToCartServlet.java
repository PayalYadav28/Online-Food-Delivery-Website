package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import beans.Cart;
import beans.Products;
import beans.User;
import database.UserData;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				int id=Integer.parseInt(request.getParameter("id"));
				String image=request.getParameter("image");
				String dishname=request.getParameter("dishname");
				String description=request.getParameter("description");
				String price=request.getParameter("price");
				int uid=Integer.parseInt(request.getParameter("uid"));
			
				
				
				UserData ud=new UserData();
				
				
				boolean f =ud.addtoCart(id,image, dishname, description, price,uid);
				
				List<Cart> products=ud.getCart(uid);
				
		
				
				
				HttpSession session=request.getSession();
				session.setAttribute("cart", products);
				response.sendRedirect("cart.jsp");
					
				
				
				
	}
				
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}
