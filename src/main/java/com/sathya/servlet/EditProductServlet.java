package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Read the product id 
		String proId = request.getParameter("proid");
		System.out.println("PI: "+proId);
		
		// Give the proId to ProductDAO layer and get the existing product object
		Product existingProduct = new ProductDAO().findbyId(proId);
		
		// Send the existing product object to editForm.jsp which will populate the existing data
		request.setAttribute("existingProduct", existingProduct);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editform.jsp");
		dispatcher.forward(request, response);
	}

}
