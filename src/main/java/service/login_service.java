package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class login_service {

	
	
	public List login(model.login l) {
		int i=0;
		ArrayList al=new ArrayList();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/laptop_store","root","root");
		String sql=" select * from login where username='"+l.getUser()+"' and password='"+l.getPass()+"' ";
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery(sql);
	
		while(rs.next()) {
			al.add(rs.getInt("id"));
			String role=rs.getString("role");
			
			switch(role) {
			case "seller": 
					i=1;
					al.add(i);
					return al;
			case "customer":
					i=2;
					al.add(i);
					return al;
			}

		}
		

	} catch (Exception e) {
		System.out.println(e);
	}
	return al;
}
}
