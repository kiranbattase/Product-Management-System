package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Read the from data
		String proId = request.getParameter("proId");
		String proName = request.getParameter("proName");
		double proPrice = Double.parseDouble(request.getParameter("proPrice"));
		String proBrand = request.getParameter("proBrand");
		String proMadeIn = request.getParameter("proMadeIn");
		Date proMfgDate = Date.valueOf(request.getParameter("proMfgDate"));
		Date proExpDate = Date.valueOf(request.getParameter("proExpDate"));
		Part part = request.getPart("proImage");
		Part part1 = request.getPart("oldProAudio");
		Part part2 = request.getPart("oldProVideo");

		Product product = new Product();

		if (part.getSize() != 0) {
			InputStream inputStream = part.getInputStream();
			byte[] proImage = IOUtils.toByteArray(inputStream);
			product.setImageWork(proImage);
		} else {
			String s = request.getParameter("oldProImage");
			byte[] proImage = Base64.getDecoder().decode(s);
			product.setImageWork(proImage);
		}
		
		
			String s1 = request.getParameter("oldProAudio");
			byte[] proAudio = Base64.getDecoder().decode(s1);
			product.setProAudio(proAudio);
		
			String s2 = request.getParameter("oldProVideo");
			byte[] proVideo = Base64.getDecoder().decode(s2);
			product.setProVideo(proVideo);

		// Using above details create Product object

		product.setProid(proId);
		product.setProname(proName);
		product.setProPrice(proPrice);
		product.setProBrand(proBrand);
		product.setProMadein(proMadeIn);
		product.setProMfgDate(proMfgDate);
		product.setProExpDate(proExpDate);

		// Giving the product object to ProductDAO layer save method to save the data
		// into database
		ProductDAO productDAO = new ProductDAO();
		int result = productDAO.updatebyid(product);

		if (result == 1) {
			request.setAttribute("saveResult", result);

			RequestDispatcher dispatcher = request.getRequestDispatcher("ListOfProduct.jsp");
			dispatcher.forward(request, response);
		} else {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("<h2 class='font-italic font-weight-bold text-danger text-center'>Product Saving Failed..."
					+ result + "</h2>");
			writer.println("</body>");
			writer.println("</html>");
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("ProApp.html");
			dispatcher1.include(request, response);
		}
	}

}
