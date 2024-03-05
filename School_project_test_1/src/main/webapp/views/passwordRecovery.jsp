<%@ include file="header.jsp"%>

<title>User Login Page</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/home_style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/userLogin_style.css" />
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
	<div class="form-popup">
		<div class="form-box login">
			<div class="form-content">
				<h3>Recovery</h3>
				<ol>
					<li><strong>Input Your Email</strong></li>
					<li><strong>Copy the code:</strong> Copy the code from the
						sent email.</li>
					<li><strong>Paste and reset:</strong> Paste the code in the
						box below and submit.</li>
				</ol>
				<form method="post"
					action="${pageContext.request.contextPath}/passwordRecovery">
					<div class="input-field">
						<input type="text" required name="recoveryGmail"> <label>Enter
							your recovery Email</label>
					</div>
					<%
					if (request.getParameter("emailError") != null && request.getParameter("emailError").equals("true")) {
					%>
					<div class="warning" style="color: red;">The email does not
						exit!</div>
					<%
					}
					%>
					<!-- Include a hidden input field to specify the action -->
					<input type="hidden" name="action" value="recovery">
					<!-- Add a button to trigger the recoverEmail action -->
					<button type="submit">Recover Email</button>
				</form>

				<form method="post"
					action="${pageContext.request.contextPath}/passwordRecovery">
					<div class="input-field">
						<input type="text" required name="otp"><label>Enter
							your OTP</label>
					</div>
					<%
					if (request.getParameter("otpError") != null && request.getParameter("otpError").equals("true")) {
					%>
					<div class="warning" style="color: red;">Wrong OTP!</div>
					<%
					}
					%>
					<!-- Include a hidden input field to specify the action -->
					<input type="hidden" name="action" value="submitOTP">
					<!-- Add a button to trigger the submitOTP action -->
					<button type="submit">Submit OTP</button>
				</form>

				<div class="bottom-link">
					Don't have an account? <a
						href="${pageContext.request.contextPath}/views/userRegistration.jsp"
						id="signup-link">Register</a>
				</div>

			</div>
		</div>
	</div>

	<!-- End -->

	<%@ include file="footer.jsp"%>
</html>
