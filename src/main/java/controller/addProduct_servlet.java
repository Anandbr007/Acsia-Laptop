package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.addProduct;
import service.addProduct_service;

/**
 * Servlet implementation class addProduct_servlet
 */
public class addProduct_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProduct_servlet() {
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
		
		String productName=request.getParameter("name");
		String modelno=request.getParameter("modelno");
		String description=request.getParameter("description");
		String price=request.getParameter("price");
		String quantity=request.getParameter("quantity");
		
//		  Part filePart = request.getPart("file"); 
//		  byte[] image=fileContent.readAllBytes();
//	      String fileName = filePart.getSubmittedFileName();
//	      InputStream fileContent = filePart.getInputStream();
		
		addProduct ap=new addProduct();
		
		ap.setProduct_name(productName);
		ap.setModel_no(modelno);
		ap.setDescription(description);
		ap.setPrice(price);
		ap.setQuantity(quantity);
		
		addProduct_service as=new addProduct_service();
		
		int f=as.add(ap);
        if(f==1) {
        	response.sendRedirect("addproduct.html");
        }
		
	}

}
