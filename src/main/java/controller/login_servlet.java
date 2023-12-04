package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.login;
import service.login_service;

/**
 * Servlet implementation class login_servlet
 */
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_servlet() {
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
		
		String name=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String role="customer";
				
		
		login l=new login();
		l.setUser(name);
		l.setPass(pass);
		l.setRole(role);		
		
		
		login_service ls=new login_service();
		ArrayList al1=new ArrayList();
		al1.addAll(ls.login(l));
		int f=(int) al1.get(1);
		int id=(int)al1.get(0);
		
		
		if(f==1) {
			HttpSession session=request.getSession();
			session.setAttribute("sellerid",id);
			response.sendRedirect("index.html");
		}
		else if(f==2) {
			HttpSession session=request.getSession();
			session.setAttribute("custid",id);
			response.sendRedirect("index.html");
		}
		

	}
		
		
	}


