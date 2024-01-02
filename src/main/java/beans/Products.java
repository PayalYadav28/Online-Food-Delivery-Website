package beans;

import beans.User;

public class Products {

	private int id;
	private String image;
	private String dishname;
	private String description;
	private String prize;
	private User user;
	
	
	public Products() {
		
	}

	public Products(int id, String image, String dishname, String description, String prize, User user) {
		super();
		this.id = id;
		this.image = image;
		this.dishname = dishname;
		this.description = description;
		this.prize = prize;
		this.user = user;
	}






	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", image=" + image + ", dishname=" + dishname + ", description=" + description
				+ ", prize=" + prize + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getDishname() {
		return dishname;
	}


	public void setDishname(String dishname) {
		this.dishname = dishname;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPrize() {
		return prize;
	}


	public void setPrize(String prize) {
		this.prize = prize;
	}
	
	
	
}
