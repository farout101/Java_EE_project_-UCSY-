<%@ include file="header.jsp"%>

<!--  Link tags -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/home_style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/userRegistration_style.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</head>

<body class="show-popup">

	<!-- Below For Eclipse-->


	<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<div class="container">
			<a class="navbar-brand" href="#" id="logo"><span class="brand">C</span>ash<span
				class="brand">N</span>ex</a>
		</div>

	</nav>

	<div class="blur-bg-overlay"></div>

	<div class="form-popup" id="blur">
		<div class="form-box login">
			<div class="form-content">
				<h2>Register</h2>
				<form method="post"
					action="${pageContext.request.contextPath}/UserRegistration"
					onsubmit="showNotification()">
					<div class="input-field">
						<input type="text" name="username" required> <label>Name</label>
					</div>
					<!-- <div class="input-field" data-toggle="tooltip"
						data-placement="auto top" title="National Registeration Card"
						style="display: flex; justify-content: space-between;">
						<input name="nrcNumber" type="text"
							style="width: 10%; padding: 7px;" pattern="[0-9]|[0-9]{2}"
							required> <span style="font-size: 2em">/</span> <select
							id="0912" class="select-form autoactivated"
							onchange="changes(this)" name="NRCTownship"
							style="width: 30%; color: #4a4646;">
							<option hidden disabled selected>XXXXXX</option>
							<option>DaGaNa</option>
							<option>MaLa</option>
						</select> <select id="1904" class="select-form" name="Nationality"
							style="width: 20%; color: #4a4646;" onchange="changes(this)">
							<option hidden disabled selected>Nationality</option>
							<option>N</option>
							<option>F</option>
						</select> <input type="text" style="width: 30%;" pattern="[0-9]{6}" name=""
							onchange="changes(this)" required> <label>NRC</label>
					</div> -->
					<div class="input-field">
						<input type="text" name="nrcNumber" id="6487" required> <label>NRC
							number</label>
					</div>

					<!-- Nrc Validation -->
					<!--<div class="input-field">
    				<input type="text" name="nrcNumber" id="6487" required pattern="[0-9]{1,2}/[a-zA-Z]\\([a-zA-Z]\\)[0-9]{6}">
    				<label>NRC number</label>
					</div>-->

					<div class="input-field">
						<input type="text" name="userGmail" id="6487" required
							pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$">
						<label>Email</label>
					</div>

					<div class="input-field">
						<select id="4721" class="select-form" name="career"
							style="height: 100%;" onchange="changes(this)">
							<option hidden disabled selected value></option>
							<option>Teacher</option>
							<option>Student</option>
							<option>Engineer</option>
							<option>Dog</option>
						</select> <label>Career</label>
					</div>
					
					
					<div class="input-field" style="display: flex;">
						<input name="userPassword" id="password" type="password" required
							style="border-radius: 3px 0 0 3px; border-right: none;"
							oninput="checkPasswordStrength(this.value)">
						<div class="pass" onclick="togglePassword()">
							<span class="password-eye show-password" data-toggle="tooltip"
								data-placement="top" title="show password"></span> <span
								class="password-eye hide-password hide" data-toggle="tooltip"
								data-placement="top" title="hide password"></span>
						</div>
						<label>Password</label>
						
						
					</div>
					<div id="passwordStrength"
						style="color: red; opacity: 0; transition: opacity 0.3s;"></div>

					<script>
						function checkPasswordStrength(password) {
							var passwordStrength = document
									.getElementById("passwordStrength");
							var strongRegex = new RegExp(
									"^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=.{8,})");
							if (password.length === 0) {
								passwordStrength.style.opacity = 0; // Hide the message if password field is empty
							} else {
								if (strongRegex.test(password)) {
									passwordStrength.innerHTML = "Password strength: Strong";
									passwordStrength.style.color = "green";
								} else {
									passwordStrength.innerHTML = "Password strength: Weak";
									passwordStrength.style.color = "red";
								}
								passwordStrength.style.opacity = 1; // Show the message if password field is filled
							}
						}
					</script>

					<button type="submit" onclick="toggle()">Register</button>
				</form>



				<div class="bottom-link">
					Already have an account? <a
						href="${pageContext.request.contextPath}/views/userLogin.jsp"
						id="signup-link">Log In</a>
				</div>
			</div>
		</div>


	</div>


</body>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>
<script>
	var con = true;
	function changes(sel) {
		document.getElementById(sel.id).classList.add("activated");
	}
	function togglePassword() {
		const pass = document.getElementById("password");
		var show = document.getElementsByClassName("show-password");
		var hide = document.getElementsByClassName("hide-password");
		if (con) {
			pass.type = "text";
			show[0].classList.add("hide");
			hide[0].classList.remove("hide");
		} else {
			pass.type = "password";
			show[0].classList.remove("hide");
			hide[0].classList.add("hide");
		}
		console.log("Hello :))")
		con = !con;

	}

	function toggle() {
		var blur
		document.getElementById('blur');
		blur.classList.toggle('active');
		var popup = document.getElementById('popup');
		popup.classList.toggle('active');
	}
</script>

</html>
<%@ include file="footer.jsp"%>