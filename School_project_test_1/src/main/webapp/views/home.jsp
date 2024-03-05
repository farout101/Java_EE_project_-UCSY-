<%@ include file="header.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/home_style.css" />

<title>Home Page</title>

<style>
/* Custom styling for the banner */
#banner {
	background-color: var(--inquiry-box);
	padding: 20px 0;
	text-align: center;
	margin-top: 20px;
	border-radius: 10px;
}

#banner-row {
	position: relative;
	display: flex;
	justify-content: space-evenly;
}

.bank {
	max-width: 15%;
	height: 100px;
}

.loan {
	max-width: 15%;
	height: 100px;
}

.transaction {
	max-width: 15%;
	height: 100px;
}

.wallet {
	max-width: 15%;
	height: 100px;
}
</style>

</head>
<body>
	<!-- Below For Eclipse-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<div class="container">

			<a class="navbar-brand" href="#" id="logo"><span class="brand">C</span>ash<span
				class="brand">N</span>ex</a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0" id="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Dashboard</a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Accounts </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">Loans</a></li>
							<li><a class="dropdown-item" href="#">Transactions</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Log in</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link" href="#">Location</a>
					</li>

				</ul>
			</div>
		</div>

	</nav>

	<!-- Header and paragraph-->

	<div class="container mt-5" id="header_text">

		<div class="row">
			<div class="col-6">
				<h1>
					Tailored solutions aligning <br> with trusted services and
					secure transactions
				</h1>
				<p class="mt-3">
					<span class="checkmark"></span> Customized solutions that match
					your financial <br> &emsp;&ensp;&nbsp; goals securely.
				</p>

				<p class="mt-3">
					<span class="checkmark"></span> Dedicated to fostering financial
					success for <br> &emsp;&ensp;&nbsp; individuals and
					businesses.
				</p>

				<div class="inquiry">
					<div class="inquiryText">
						<h5>You need Money for :</h5>

						<div class="bigBox">
							<div class="boxItems">
								<button class="btn-cars">Cars</button>
							</div>
							<div class="boxItems">
								<button class="btn-land">Land</button>
							</div>
							<div class="boxItems">
								<button>Houses</button>
							</div>
							<div class="boxItems">
								<button>Gold</button>
							</div>
							<div class="boxItems">
								<button>Watches</button>
							</div>
							<div class="boxItems">
								<button>Rings</button>
							</div>
						</div>

						<div class="money">
							<input type="number" class="number"> <span
								class="dollar-sign">$</span>
							<button class="btn btn-success" id="iqbtn">Inquire Now</button>
						</div>
					</div>


				</div>
			</div>

			<div class="col-6">
				<!-- Photo Gallery -->
				<div class="gallery-container">

					<div class="parent">

						<div class="div3">
							<img
								src="${pageContext.request.contextPath}/resources/images/big_one.JPG">
						</div>
						<div class="div4">
							<img
								src="${pageContext.request.contextPath}/resources/images/small_right.JPG">
						</div>
						<div class="div5">
							<img
								src="${pageContext.request.contextPath}/resources/images/small_bot.JPG">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Banner -->

	<div class="container" id="banner">
		<div class="container">
			<div class="row">
				<div class="col-md-12" id="banner-row">
					<!-- Replace the src attribute with your banner image URL -->

					<img
						src="${pageContext.request.contextPath}/resources/images/bank.png"
						alt="Bank Image" class="bank"> <img
						src="${pageContext.request.contextPath}/resources/images/loan2.png"
						alt="Loan Image" class="loan"> <img
						src="${pageContext.request.contextPath}/resources/images/transaction.png"
						alt="Transaction Image" class="transaction"> <img
						src="${pageContext.request.contextPath}/resources/images/wallet.png"
						alt="Wallet Image" class="wallet">
				</div>
			</div>
		</div>
	</div>

	<!-- Video Section -->


	<!-- End -->

	<%@ include file="footer.jsp"%>