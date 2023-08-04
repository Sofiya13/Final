<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Registration</title>
<link rel="stylesheet" id="style.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
</head>

<style>
@import
	url('https://fonts.googleapis.com/css2?family=poppins:wght#300;400;500;600;700;800;900&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

body {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	background: black;
}

.wrapper {
	position: relative;
	width: 750px;
	height: 650px;
	background: transparent;
	border: 2px solid #0ef;
	overflow: hidden;
	box-shadow: 0 0 25px #0ef;
}

.wrapper .form-box {
	position: absolute;
	top: 0;
	width: 50%;
	height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.wrapper .form-box.register {
	right: 0;
	padding: 0 40px 0 60px;
}

.form-box h2 {
padding-top: 50px;

	font-size: 32px;
	color: #fff;
	text-align: center;
}

.form-box .input-box {
	position: relative;
	width: 100%;
	height: 50px;
	margin: 25px 0;
}

.input-box input {
	width: 100%;
	height: 111%;
	background: black;
	border: none;
	outline: none;
	border-bottom: 2px solid #fff;
	margin-top: 7px;
	font-size: 23px;
	transition: .5s;
	color: maroon;
	font-weight: 500;
	padding-right: 23px;
}

.input-box input:focus, .input-box input:valid {
	border-bottom-color: #0ef;
}

.input-box label {
	position: absolute;
	top: 50%;
	left: 43px;
	transform: translate(-50%);
	font-size: 18px;
	color: #fff;
	pointer-events: none;
	transition: .5s;
}

.input-box input:focus~label, .input-box input:valid~label {
	top: -5px;
	color: #Oef;
}

.input-box i {
	position: absolute;
	top: 50%;
	right: 0;
	transform: translate(-50%);
	font-size: 18px;
	color: #fff;
	transition: .5s;
}

.input-box input:focus~i,
 .input-box input:valid~i {
	color: #0ef;
}

.btn {
	margin-top: 10px; position : relative;
	width: 100%;
	height: 45px;
	background: transparent;
	border: 2px solid #0ef;
	outline: none;
	border-radius: 40px;
	cursor: pointer;
	font-size: 18px;
	color: #fff;
	font-weight: 600;
	z-index: 1;
	overflow: hidden;
	position: relative;
}

.btn::before {
	content: '';
	position: absolute;
	top: -100%;
	left: 0;
	width: 100%;
	height: 300%;
	background: linear-gradient(black, cyan, black, aqua);
	z-index: -1;
	transition: .5s;
}

.btn:hover::before {
	top: 0;
}

.form-box .logreg-link {
	font-size: 14.5px;
	color: #fff;
	text-align: center;
	margin: 30px 0 20px;
}

.logreg-link p a {
	color: #0ef;
	text-decoration: none;
	font-weight: 600;
}

.logreg-link p a:hover {
	text-decoration: underline;
}

.wrapper .info-text {
	position: absolute;
	top: 0;
	width: 50%;
	height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.wrapper .info-text.register {
	left: 0;
	text-align: left;
	padding: 0 150px 60px 40px;
}

.info-text h2 {
	font-size: 36px;
	color: #fff;
	line-height: 1.3;
	text-transform: uppercase;
}

.info-text p {
	font-size: 16px;
	color: #fff;
}

span {
	padding-bottom: 16px;
	width: 60%;
}

.wrapper .bg-animate2 {
	position: absolute;
	top: 100px;
	left: -50px;
	width: 850px;
	height: 600px;
	background: linear-gradient(45deg, black, aqua);
	border-bottom: 3px solid aqua;
	transform: rotate(-11deg) skewY(-41deg);
	transform-origin: bottom left;
}
</style>

<body>
	<div class="wrapper">
		<span class="bg-animate2"></span>
		<div class="form-box register">
			<h2>Sign Up</h2>
			<form action="RegistrationController" method="post">
				<div class="input-box">
					<input type="text" name="username" required> <label>Username</label> <i
						class='bx bxs-user'></i>
				</div>
				<div class="input-box">
					<input type="password" name="password" required> <label>Password</label> <i
						class='bx bxs-lock-alt'></i>
				</div>
				<div class="input-box">
					<input type="text" required name="email" > <label style="left:25px">Email</label> <i
						class='bx bxs-envelope'></i>
				</div>
				
				<div class="input-box">
					<input type="text" name="fullname" required> <label>Full Name</label> <i class='bx bxs-edit-alt'></i>
				</div>
				<div class="input-box">
					<input type="text" name="contact" required  maxlength="10"> <label style="left:30px" >Contact</label> <i
						class='bx bx-phone'></i>
				</div>
				<button type="submit" class="btn">Sign up</button>

				<div class="logreg-link">
					<span style="width: 48%; text-align: left; display: inline-block;"><a
						class="small-text" href="#">Forgot password?</a></span>
					<p>
						Already have an account? <a href="Login.jsp"> Login</a>
					</p>
				</div>
			</form>
		</div>
		<div class="info-text register">
			<h2 style="color: black">Welcome Back!</h2>
			<p>Please fill in this form to create an account!</p>
		</div>
	</div>
</body>

</html>