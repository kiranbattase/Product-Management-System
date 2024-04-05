<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Base64"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CDN(Content Delivery Network) link to get support of BootStrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" />

<!-- This is JavaScript validation code location -->
<script src="formValidation.js"></script>
<title>Product Management</title>
</head>
<body>=
	<div class="container mt-5 text-center">
		<h2 class="text-center font-italic mb-1">Save Product Details...</h2>
		<form method="post" action="UpdateProductServlet"
			enctype="multipart/form-data" onsubmit="return validateForm()">

			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proId">Product
					Id:</label> <input type="text" class="form-control-sm" name="proId"
					id="proId" value="${existingProduct.proid}" required>
			</div>

			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proName">Product
					Name:</label> <input type="text" class="form-control-sm" name="proName"
					id="proName" value="${existingProduct.proname}" required>
			</div>

			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proPrice">Product
					Price:</label> <input type="text" class="form-control-sm" name="proPrice"
					id="proPrice" value="${existingProduct.proPrice}" required>
			</div>

			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proBrand">Product
					Brand:</label> <input type="text" class="form-control-sm" name="proBrand"
					id="proBrand" value="${existingProduct.proBrand}" required>
			</div>

			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proMadeIn">Product
					Made In:</label> <input type="text" class="form-control-sm"
					name="proMadeIn" id="proMadeIn"
					value="${existingProduct.proMadein}" required>
			</div>

			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proMfgDate">MFG.
					Date:</label> <input type="date" class="form-control-sm" name="proMfgDate"
					id="proMfgDate" value="${existingProduct.proMfgDate}" required>
			</div>

			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proExpDate">Exp.
					Date:</label> <input type="date" class="form-control-sm" name="proExpDate"
					id="proExpDate" value="${existingProduct.proExpDate}" required>
			</div>

			<div class="form-group">
				<label class="font-italic font-weight-bold" for="oldProImage">Current
					Product Image:</label> <img id="currentImage"
					src="data:image/jpeg; base64, ${Base64.getEncoder().encodeToString(existingProduct.imageWork) }"
					alt="Current Product image" width="100px"> 
					<input
						type="hidden" id="oldProImage" name="oldProImage"
						value="${Base64.getEncoder().encodeToString(existingProduct.imageWork)}">
			</div>
			
			<div>
			 <input
					type="hidden" id="oldProAudio" name="oldProAudio"
					value="${Base64.getEncoder().encodeToString(existingProduct.proAudio)}">
			</div>
			<div>
			 <input
					type="hidden" id="oldProVideo" name="oldProVideo"
					value="${Base64.getEncoder().encodeToString(existingProduct.proVideo)}">
			</div>



			<div class="form-group">
				<label class="font-italic font-weight-bold" for="newProImage">New
					Product Image:</label> <input type="file" class="form-control-file-sm"
					name="proImage" id="proImage" accept="image/*">
			</div>

			<div>
				<input type="submit" class="btn btn-success" value="Update" /> <a
					href="productList.jsp" class="btn btn-primary">Cancel</a>
			</div>
		</form>
	</div>
</body>
</html>