package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Book;
import database.UserData;

/**
 * Servlet implementation class BooktableServlet
 */
@WebServlet("/BooktableServlet")
public class BooktableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooktableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("fname");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String person=request.getParameter("person");
		String date=request.getParameter("bookdate");
		
		Book b=new Book();
		
		b.setName(fname);
		b.setMobile(mobile);
		b.setEmail(email);
		b.setPerson(person);
		b.setBookdate(date);
		
		UserData ud=new UserData();
		
		boolean f=ud.booktable(b);
		
		HttpSession session;
		if(f)
		{
			session=request.getSession();
			session.setAttribute("reg-success","Registration Successfully!...");
			response.sendRedirect("index.jsp");
		}
		else {
			session=request.getSession();
			session.setAttribute("failed-msg", "Something went wrong");
			response.sendRedirect("book.jsp");
		}
		
		
	}

}
