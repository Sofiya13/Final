<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>User Request Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Merienda'
	rel='stylesheet'>

<style>
body {
	background-color: #6497b1;
	font-family: Merienda;
}

.container {
	background-color: #FBEAEB;
	padding: 20px;
	border-radius: 20px;
	box-shadow: 0 0 25px #0ef;
		margin-top: 50px;
	width: 50%;
	
}


.container h1 {
	text-align: center;
	margin-bottom: 30px;
	color: #2F3C7E;
}

.form-group label {
	font-weight: bold;
	font-size: 20px;
}

.form-group input[type="text"], .form-group input[type="number"],
	.form-group input[type="date"] {
	width: 50%;
	padding: 10px;
	font-size: 16px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.form-group input[type="text"]:focus, .form-group input[type="number"]:focus,
	.form-group input[type="date"]:focus {
	border-color: #007bff;
	box-shadow: 0 0 25px #0ef;}

.btn {
	 background-color: #2F3C7E; 
	 color: #FBEAEB; 
	 border: none;
	
	   cursor: pointer;
}
  .btn-primary{
        background-color:#2952d0;
     }
     
     .btn-primary:hover{
         background-color:#ed236f;
     }





</style>
</head>
<body>
	<div class="container">
		<h1>User Request Form</h1>
		<form
			action="RequestController?username=<%=request.getParameter("username")%>"
			method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					id="username" name="username"
					value="<%=request.getParameter("username")%>" disabled="disabled">
			</div>
			<div class="form-group">
				<label for="fabric_type">Fabric Type:</label> <input type="text"
					id="fabric_type" name="fabric_type"
					placeholder="e.g., Cotton,silk..." required>
			</div>
			<div class="form-group">
				<label for="sample_quantity">Sample Quantity:</label> <input
					type="number" id="sample_quantity" name="sample_quantity" required>
			</div>
			<div class="form-group">
				<label for="design_image">Select Design:</label> <input type="file"
					id="design_image" name="design_image"
					style="font-family: monospace" required>
			</div>
			<div class="form-group">
				<label for="hexValue">Color Hex Value:</label> <input type="color"
					id="hexValue" name="hexValue" required>
			</div>
			<div class="form-group">
				<label for="price">Price of one piece:</label> <input type="number"
					id="price" name="price" required>
			</div>
			<div class="form-group">
				<label for="contact">Contact:</label> <input type="text"
					id="contact" name="contact" required>
			</div>

			<div class="form-group">
				<label for="date">Date:</label> <input type="date" id="date"
					name="date" required>
			</div>

			<button class="btn" name="submit">Submit</button>
			


		</form>
	</div>
</body>
</html>
