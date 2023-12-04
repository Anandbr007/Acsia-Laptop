package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.sellerReg;

import service.sellerReg_service;

/**
 * Servlet implementation class sellerReg_servlet
 */
public class sellerReg_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sellerReg_servlet() {
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
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phno=request.getParameter("phone");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		sellerReg r=new sellerReg();
		
		r.setName(name);
		r.setEmail(email);
		r.setPhno(phno);
		r.setUsername(uname);
		r.setPassword(pass);

		
        sellerReg_service r1=new sellerReg_service();
        int f=r1.add(r);
        if(f==1) {
        	response.sendRedirect("login.html");
        }
	}

}
