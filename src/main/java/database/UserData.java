package database;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mysql.cj.Query;

import beans.Book;
import beans.Cart;
import beans.Products;
import beans.Review;
import beans.User;


public class UserData {

public boolean register(User u) {
	
		boolean f=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodhunt","root","root");
			String qu="insert into user(name,email,password)values(?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(qu);
			ps.setString(1,u.getName());
			ps.setString(2,u.getEmail());
			ps.setString(3,u.getPassword());
			
			System.out.print("insert")		;			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

	public User loginUser(User u)
	{
		User user = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodhunt","root","root");
			String query="select * from user where email=? and password=?";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,u.getEmail());
			ps.setString(2,u.getPassword());
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	public  boolean reviewUser(Review rw) {
		
		boolean f= false;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodhunt","root","root");
			String query="insert into reviews(name,profession,comment)values(?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,rw.getName());
			ps.setString(2,rw.getProfession());
			ps.setString(3,rw.getComment());
			
			
			
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
			
		
	}
	
	public List<Review> getReview() throws SQLException
	{
		List<Review> review=new ArrayList<Review>();

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodhunt","root","root");
				String query="select * from reviews";
				
				PreparedStatement ps=con.prepareStatement(query);
				
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{		
					Review row =new Review();
					row.setName(rs.getString(1));
					row.setProfession(rs.getString(2));
					row.setComment(rs.getString(3));
					
					
					review.add(row);
			
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return review;
	
	}
public  boolean booktable(Book b) {
		
		boolean f= false;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodhunt","root","root");
			String query="insert into booktable(name,mobile,email,person,date)values(?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,b.getName());
			ps.setString(2,b.getMobile());
			ps.setString(3,b.getEmail());
			ps.setString(4,b.getPerson());
			ps.setString(5,b.getBookdate());
			
			
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
			
		
	}

public List<Products> getProducts(){
	
	List<Products> products=new ArrayList<Products>();
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodhunt","root","root");
		String query="select * from products";
		
		PreparedStatement ps=con.prepareStatement(query);
	
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{		
			Products row =new Products();
			row.setId(rs.getInt(1));
			row.setImage(rs.getString(2));
			row.setDishname(rs.getString(3));
			row.setDescription(rs.getString(4));
			row.setPrize(rs.getString(5));
			
			products.add(row);
			
			
		}
		
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return products;
	
}

public boolean addtoCart(int id,String image,String dishname,String description,String price,int uid)
{
	boolean f=false;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodhunt","root","root");
		
		
		String qu="insert into cart(id,image,dishname,description,price,uid) values(?,?,?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(qu);
		
		ps.setInt(1,id);
		ps.setString(2,image);
		ps.setString(3,dishname);
		ps.setString(4,description);
		ps.setString(5,price);
		ps.setInt(6, uid);
				
		
		
		
		
		int i=ps.executeUpdate();
		if(i>0)
		{
			f=true;
			System.out.print("insert");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
	
}



public List<Cart> getCart(int id){
	
	List<Cart> products=new ArrayList<Cart>();
	Cart row =null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodhunt","root","root");
		String query="select * from cart where uid=?";
		
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1,id);
				
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{		
			row=new Cart();
			row.setId(rs.getInt(1));
			row.setImage(rs.getString(2));
			row.setDishname(rs.getString(3));
			row.setDescription(rs.getString(4));
			row.setPrize(rs.getString(5));
			row.setUid(rs.getInt(6));
			
			
			
			products.add(row);
			
			
		}
		
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return products;
	
}

public boolean deleteFromCart(int id) {
	
	boolean f=false;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodhunt","root","root");
		String qu="delete from cart where id=?";
		PreparedStatement ps=con.prepareStatement(qu);
		
		ps.setInt(1,id);
		System.out.print(id);
		int x=ps.executeUpdate();
		
		if(x>0) {
			f=true;
			System.out.print("delete");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	return f;
	
	
}
}
