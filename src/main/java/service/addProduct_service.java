package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



import model.addProduct;

public class addProduct_service {

	int i=0;
	public int add(addProduct p) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/laptop_store","root","root");
			String sql="insert into product(prod_name,model_no,description,price,quantity) values('"+p.getProduct_name()+"','"+p.getModel_no()+"','"+p.getDescription()+"','"+p.getPrice()+"','"+p.getQuantity()+"')";
			PreparedStatement stmt=con.prepareStatement(sql);
			i=stmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return i;
	}
}
