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
				<h2>Get your verification Code!</h2>
				<h6>Instructions for Obtaining verification code</h6>

				<ol>
					<li><strong>Check Your Email:</strong> Look for the code in your email.</li>
					<li><strong>Copy the code:</strong> Copy the code from the email.</li>
					<li><strong>Paste and Verify:</strong> Paste the code into the application and submit.</li>
				</ol>
				<form method="post"
					action="${pageContext.request.contextPath}/URGSPart2"
					onsubmit="showNotification()">
					<div class="input-field">
						<input type="text" name="OTP" required> <label>Fill
							the verification code here</label>
					</div>

					<button type="submit" onclick="toggle()">Submit</button>
					<%
					String otpError = request.getParameter("otpError");
					if (otpError != null && otpError.equals("true")) {
					%>
					<p style="color: red;">The OTP you entered is incorrect. Please
						try again.</p>
					<%
					} 
					%>
				</form>
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