package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.sellerReg;

public class sellerReg_service {

	public int add(sellerReg r){ 
		int i=0,j=0;
		try {
			String role="seller";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/laptop_store","root","root");
			String sql="insert into login(username,password,role)values('"+r.getUsername()+"','"+r.getPassword()+"','"+role+"')";
			PreparedStatement stmt=con.prepareStatement(sql);
			i=stmt.executeUpdate();
			if(i==1) 
			{
				String sql2="select max(id) from login"; 
				ResultSet rs=stmt.executeQuery(sql2);
				while(rs.next()) 
				{
					 String sql1="insert into seller_reg(name,email,phone,username,pass,loginid)values('"+r.getName()+"','"+r.getEmail()+"','"+r.getPhno()+"','"+r.getUsername()+"','"+r.getPassword()+"','"+rs.getInt("max(id)")+"')";
					 stmt=con.prepareStatement(sql1);
					 j=stmt.executeUpdate();
				
				}
			}
				 
		} catch (Exception e) {
			System.out.println(e);
		}
		return j;
	}
}
