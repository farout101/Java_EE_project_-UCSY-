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
        <h2>LOGIN</h2>
        <form method="post"
          action="${pageContext.request.contextPath}/userLogin">
          <div class="input-field">
            <input type="text" required name="userGmail"> <label>Email</label>
          </div>
          <div class="input-field">
            <input type="password" required name="userPassword"> <label>Password</label>
           </div>
          <a href="passwordRecovery.jsp" class="forgot-pass-link">Forgot password?</a >
          <button type="submit">Log In</button>
        </form>
        <div class="bottom-link">
          Don't have an account? <a href="${pageContext.request.contextPath}/views/userRegistration.jsp" id="signup-link">Register</a>
        </div>
      </div>
    </div>
  </div>

<!-- End -->


<%@ include file="footer.jsp"%>

</html>
