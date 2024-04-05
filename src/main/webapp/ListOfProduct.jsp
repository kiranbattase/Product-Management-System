<%@page import="com.sathya.servlet.ProductDAO" import = "java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>List Of Products</title>

<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">



</head>
<body>
	<h1 class = "text-center text-success"> List Of Products </h1>

		<div>
			<a  href = "ProApp.html" class = "text-center btn btn-success">  Add More Product  </a>
		</div>
		
		<br>
		
		<div>
			<input type="text" placeholder ="search" ></input>
		</div>
		
		<br>
					

	<table class="table table-border table-striped">
			
	
		<c:if test="${saveResult==1 }">
			
			<h1 class = "text-success text-center">Data inserted successfully...</h1>
			
		</c:if>	
		
		<c:if test="${PResult==1 }">
			
			<h1 class = "text-success text-center">Data Delete successfully...</h1>
			
		</c:if>	
		
		<c:if test="${PResult==0 }">
			
			<h1 class = "text-success text-center">Data Deletion Failed...</h1>
			
		</c:if>	
			
			
		<thead class="thead-dark">
			<tr>
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>Product Brand</th>
				<th>Made IN</th>
				<th>Manufacturing date</th>
				<th>Expire date</th>
				<th>Product Image</th>
				<th>Audio</th>
				<th>Video</th>			
				<th>Action</th>
			</tr>
				
		</thead>
		
		<tbody>
			<c:forEach var="product" items="<%=new ProductDAO().findAll() %>">
		<tr>
			<td>${product.proid}</td>
			<td>${product.proname}</td>
			<td>${product.proPrice}</td>
			<td>${product.proBrand}</td>
			<td>${product.proMadein}</td>
			<td>${product.proMfgDate}</td>
			<td>${product.proExpDate}</td>
			
			<!-- Image -->
			
			<td> <img alt="Product Image" style = "max-width:100px; max-height:100px;" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.imageWork) }"></td>			
						
			<!-- Audio -->
				
				<td>
				
					<audio controls>
					
						<source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(product.proAudio) }" type="audio/mpeg" >
					
					</audio>
				
				</td>
				
			<!-- Video -->
				
				<td>
				
					<video controls width="200" height="200">
					
						<source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(product.proVideo) }" type="video/mp4" >
					
					</video>
				
				</td>
				
				<td>
					<a class = "btn btn-primary" 
					href="./DeleteProductServlet?proid=${product.proid}">Delete</a>
					<a class = "btn btn-primary" 
					href="./EditProductServlet?proid=${product.proid}">Edit</a>
	
				</td>
		</tr>	
		
					
		</c:forEach>	
		</tbody>		
		</table>
	

</body>
</html>