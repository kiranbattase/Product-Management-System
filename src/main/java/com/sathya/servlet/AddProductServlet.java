package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/AddProductServlet")
@MultipartConfig

public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public AddProductServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Pid= request.getParameter("proId");
		String PName=request.getParameter("Proname");
		double PPrice=Double.parseDouble(request.getParameter("ProPrice"));
		String PBrand=request.getParameter("ProBrand");
		String PMadeIn=request.getParameter("ProMadeIN");
		Date PMfgDate=Date.valueOf(request.getParameter("ProMFDdate"));
		Date PExpDate=Date.valueOf(request.getParameter("ProExpDate"));
		Part part=request.getPart("ProIMAGE");
		InputStream PImage=part.getInputStream();
		byte[] ProIMAGE = IOUtils.toByteArray(PImage);
		
		
		Part part1 = request.getPart("audio");
		InputStream audio = part1.getInputStream();
		//call the toByteArray method to convert inputstream to byte form
		byte[] proAudio = IOUtils.toByteArray(audio);
		
		Part part2 = request.getPart("video");
		InputStream video = part2.getInputStream();
		//call the toByteArray method to convert inputstream to byte form
		byte[] proVideo = IOUtils.toByteArray(video);
		
		
		Product product = new Product();
		
		product.setProid(Pid);
		product.setProname(PName);
		product.setProPrice(PPrice);
		product.setProBrand(PBrand);
		product.setProMadein(PMadeIn);
		product.setProMfgDate(PMfgDate);
		product.setProExpDate(PExpDate);
		product.setImageWork(ProIMAGE);
		product.setProAudio(proAudio);
		product.setProVideo(proVideo);
				
		
		int result=new ProductDAO().save(product);
		
		if(result==1) {
			request.setAttribute("saveResult", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ListOfProduct.jsp");
			dispatcher.forward(request, response);			
		}
		else {
			response.setContentType("text/html");
			PrintWriter writer =response.getWriter();
			writer.println("<html");
			writer.println("<h1>Id already exist.....Data insertion cannot done</h1>");
			writer.println("</html>");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("ProApp.html");
			dispatcher.include(request, response);
		}
	}

}