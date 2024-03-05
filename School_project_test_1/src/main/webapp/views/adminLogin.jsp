<%@ include file="header.jsp"%>

<title>Admin Login</title>

<!-- Link tags -->
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/home_style.css" />
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/userRegistration_style.css" />
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">

<!-- CSS for animation -->
<style>
    .error-message {
        display: none;
        animation-name: fadeIn;
        animation-duration: 0.5s;
    }

    @keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }
</style>

</head>

<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="#" id="logo"><span class="brand">C</span>ash<span
                    class="brand">N</span>ex</a>
        </div>
    </nav>

    <!-- Form Popup -->
    <div class="form-box login">
        <div class="form-content">
            <h2>Admin Login</h2>
            <form method="post" action="${pageContext.request.contextPath}/adminLogin">
                <div class="input-field">
                    <input type="text" name="adminUsername" required> <label>Name</label>
                </div>
                <div class="input-field" style="display: flex;">
                    <input name="adminPassword" id="password" type="password" required
                        style="border-radius: 3px 0 0 3px; border-right: none;">
                    <div class="pass" onclick="togglePassword()">
                        <span class="password-eye show-password" data-toggle="tooltip"
                            data-placement="top" title="show password"></span> <span
                            class="password-eye hide-password hide" data-toggle="tooltip"
                            data-placement="top" title="hide password"></span>
                    </div>
                    <label>Password</label>
                </div>
                <button type="submit">Login as Admin</button>
            </form>
            <!-- Display error message if password is incorrect -->
            <div id="errorMessage" class="error-message">
                <% Boolean loginSuccess = (Boolean) session.getAttribute("loginSuccess"); %>
                <% if (loginSuccess != null && !loginSuccess) { %>
                    Wrong Password! Please try again.
                <% } %>
            </div>
        </div>
    </div>

    <!-- JavaScript -->
    <script>
        var con = true;
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
            con = !con;
        }

        // When the document is loaded
        document.addEventListener('DOMContentLoaded', function () {
            // Check if the login was unsuccessful
            var loginSuccess = '<%= session.getAttribute("loginSuccess") %>';
            if (loginSuccess != null && loginSuccess === 'false') {
                // Show the error message with animation
                var errorMessage = document.getElementById('errorMessage');
                errorMessage.style.display = 'block';
            }
        });
    </script>

</body>
<%@ include file="footer.jsp"%>