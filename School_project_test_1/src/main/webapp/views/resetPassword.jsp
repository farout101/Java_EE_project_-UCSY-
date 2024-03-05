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
				<%
				if (request.getParameter("passError") != null && request.getParameter("passError").equals("true")) {
				%>
				<div class="warning" style="color: red; justify-content: center; align-items: center;">Operation Failed Try again</div>
				<%
				}
				%>
				<h2>Register</h2>
				<form method="post"
					action="${pageContext.request.contextPath}/resetPassword"
					onsubmit="showNotification()">
					<div class="input-field" style="display: flex;">
						<input name="userPassword1" id="password1" type="password"
							required style="border-radius: 3px 0 0 3px; border-right: none;"
							oninput="checkPasswordStrength(this.value, 'passwordStrength1')">
						<div class="pass">
							<span class="password-eye show-password1" id="eye1"
								onclick="togglePasswordVisibility('password1', 'eye1')"
								data-toggle="tooltip" data-placement="top" title="show password"
								style="display: inline-block;"></span> <span
								class="password-eye hide-password1" id="eye1"
								onclick="togglePasswordVisibility('password1', 'eye1')"
								data-toggle="tooltip" data-placement="top" title="hide password"
								style="display: none;"></span>
						</div>
						<label>Password 1</label>
					</div>
					<div id="passwordStrength1"
						style="color: red; opacity: 0; transition: opacity 0.3s;"></div>

					<div class="input-field" style="display: flex;">
						<input name="userPassword2" id="password2" type="password"
							required style="border-radius: 3px 0 0 3px; border-right: none;"
							oninput="checkPasswordStrength(this.value, 'passwordStrength2')">
						<div class="pass">
							<span class="password-eye show-password2" id="eye2"
								onclick="togglePasswordVisibility('password2', 'eye2')"
								data-toggle="tooltip" data-placement="top" title="show password"></span>
							<span class="password-eye hide-password2 hide" id="eye2"
								onclick="togglePasswordVisibility('password2', 'eye2')"
								data-toggle="tooltip" data-placement="top" title="hide password"></span>
						</div>
						<label>Password 2</label>
					</div>
					<div id="passwordStrength2"
						style="color: red; opacity: 0; transition: opacity 0.3s;"></div>

					<button type="submit" onclick="toggle()">Register</button>
				</form>
				<%
				if (request.getParameter("passError") != null && request.getParameter("passError").equals("true")) {
				%>
				<div class="warning" style="color: red;">Password doesn't
					match</div>
				<%
				}
				%>
			</div>
		</div>


	</div>


</body>

</html>

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>
<script>
	function checkPasswordStrength(password, strengthId) {
		var passwordStrength = document.getElementById(strengthId);
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

	function togglePasswordVisibility(passwordId, eyeId) {
		const passwordField = document.getElementById(passwordId);
		const eyeIcon = document.getElementById(eyeId);

		if (passwordField.type === "password") {
			passwordField.type = "text";
			eyeIcon.classList.remove("show-password");
			eyeIcon.classList.add("hide-password");
		} else {
			passwordField.type = "password";
			eyeIcon.classList.remove("hide-password");
			eyeIcon.classList.add("show-password");
		}
	}
</script>
<%@ include file="footer.jsp"%>