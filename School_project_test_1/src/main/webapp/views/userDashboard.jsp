<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cashnex.controller.adminDashboardController"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="com.cashnex.model.User"%>
<%@ page import="com.cashnex.dao.UserDao"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<title>User Account Dashboard</title>

<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
  crossorigin="anonymous">
<link
  href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
  rel="stylesheet" />
<link
  href="${pageContext.request.contextPath}/resources/css/userDashboard.css?version=2"
  rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
  crossorigin="anonymous"></script>

<style>
header, .logo {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.mc-card-container {
  background-image:
    url("${pageContext.request.contextPath}/resources/images/bg.png");
  background-size: cover;
  position: relative;
  background-color: #ffff;
  padding: 25px;
  border-radius: 28px;
  max-width: 330px;
  width: 100%;
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
  max-height: 250px;
  margin-right: auto; /* Move the container to the left */
  margin-left: 0; /* Reset margin-left */
}

h6.number {
  margin-top: 0px;
  font-size: 15px;
  letter-spacing: 1px;
}

h5.name {
  margin-top: 20px;
  font-size: 18px;
}

.container .card-details {
  margin-top: 20px;
  display: flex;
  justify-content: space-between;
  align-items: flex-end;
}

h7 {
  font-size: 12px;
}

.userdata-heading {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

.side-main-wrapper {
  width: 60%;
}

.indiv-balance {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
</style>

</head>
<body class="sb-nav-fixed">

  <!-- JSTL Setup -->
  <c:set var="userId" value="${sessionScope.userId}" />
  <c:set var="userDao" value="<%=new UserDao()%>" />
  <c:set var="user" value="${userDao.getUserByUserId(userId)}" />

  <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <!-- Navbar Brand-->
    <a class="navbar-brand ps-3" href="#" id="logo"><span
      class="brand">C</span>ash<span class="brand">N</span>ex</a>
    <!-- Sidebar Toggle-->
    <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
      id="sidebarToggle" href="#!">
      <i class="fas fa-bars"></i>
    </button>
    <!-- Navbar Search-->

    <!-- Navbar-->
    <ul class="navbar-nav ms-auto me-3 me-lg-4">
      <!-- Changed ms-md-0 to ms-auto -->
      <li class="nav-item dropdown"><a
        class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
        role="button" data-bs-toggle="dropdown" aria-expanded="false"> <i
          class="fas fa-user fa-fw"></i>
      </a>
        <ul class="dropdown-menu dropdown-menu-end"
          aria-labelledby="navbarDropdown">
          <li><a class="dropdown-item" href="#!">Settings</a></li>
          <li><a class="dropdown-item" href="#!">Activity Log</a></li>
          <li><hr class="dropdown-divider" /></li>
          <li><a class="dropdown-item"
            href="${pageContext.request.contextPath}/views/userLogin.jsp">Logout</a></li>
        </ul></li>
    </ul></nav>
  <div id="layoutSidenav" class="d-flex flex-column">
    <div id="layoutSidenav_nav">
      <nav class="sb-sidenav accordion sb-sidenav-dark"
        id="sidenavAccordion">
        <div class="sb-sidenav-menu">
          <div class="nav">
            <div class="sb-sidenav-menu-heading">Core</div>
            <a class="nav-link" href="index.html">
              <div class="sb-nav-link-icon">
                <i class="fas fa-tachometer-alt"></i>
              </div> Dashboard
            </a>
            <div class="sb-sidenav-menu-heading">About Me</div>
            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
              data-bs-target="#collapseLayouts" aria-expanded="false"
              aria-controls="collapseLayouts">
              <div class="sb-nav-link-icon">
                <i class="fas fa-columns"></i>
              </div> My Account
              <div class="sb-sidenav-collapse-arrow">
                <i class="fas fa-angle-down"></i>
              </div>
            </a>
            <div class="collapse" id="collapseLayouts"
              aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
              <nav class="sb-sidenav-menu-nested nav">
                <a class="nav-link" href="layout-static.html">My Profile</a> <a
                  class="nav-link" href="layout-sidenav-light.html">
                  Transactions</a>
              </nav>
            </div>
            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
              data-bs-target="#collapsePages" aria-expanded="false"
              aria-controls="collapsePages">
              <div class="sb-nav-link-icon">
                <i class="fas fa-book-open"></i>
              </div> Pages
              <div class="sb-sidenav-collapse-arrow">
                <i class="fas fa-angle-down"></i>
              </div>
            </a>
            <div class="collapse" id="collapsePages"
              aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
              <nav class="sb-sidenav-menu-nested nav accordion"
                id="sidenavAccordionPages">
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                  data-bs-target="#pagesCollapseAuth" aria-expanded="false"
                  aria-controls="pagesCollapseAuth"> Authentication
                  <div class="sb-sidenav-collapse-arrow">
                    <i class="fas fa-angle-down"></i>
                  </div>
                </a>
                <div class="collapse" id="pagesCollapseAuth"
                  aria-labelledby="headingOne"
                  data-bs-parent="#sidenavAccordionPages">
                  <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="login.html">Login</a> <a
                      class="nav-link" href="register.html">Register</a> <a
                      class="nav-link" href="password.html">Forgot Password</a>
                  </nav>
                </div>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                  data-bs-target="#pagesCollapseError" aria-expanded="false"
                  aria-controls="pagesCollapseError"> Error
                  <div class="sb-sidenav-collapse-arrow">
                    <i class="fas fa-angle-down"></i>
                  </div>
                </a>
                <div class="collapse" id="pagesCollapseError"
                  aria-labelledby="headingOne"
                  data-bs-parent="#sidenavAccordionPages">
                  <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="401.html">401 Page</a> <a
                      class="nav-link" href="404.html">404 Page</a> <a
                      class="nav-link" href="500.html">500 Page</a>
                  </nav>
                </div>

              </nav>
            </div>

          </div></div>
        <div class="sb-sidenav-footer mt-auto">
          <div class="small">Logged in as:</div>
          <span class="username">${user.username}</span>
        </div>

      </nav>
    </div>
    <div id="layoutSidenav_content" class="flex-grow-1"></div>
  </div>
  <div class="container mt-5 userdata-heading">
    <div class="mt-5">
      <div class="card" style="width: 20rem; border-radius: 10px">
        <div class="card-body">
          <h5 class="card-title">${user.username}</h5>
          <p class="card-text">${user.career}</p>
        </div>
        <ul class="list-group list-group-flush">
          <li class="list-group-item"><strong>Email:</strong>
            ${user.email}</li>
          <li class="list-group-item"><strong>Phone:</strong> (555)
            123-4567</li>
          <li class="list-group-item"><strong>Location:</strong> City,
            Country</li>
        </ul>

        <main class="card_section">
          <div class="">

            <div class="mc-card-container mt-3">
              <header style="display: flex; align-items: center;">
                <span class="master_logo"
                  style="display: flex; align-items: center;"> <img
                  src="${pageContext.request.contextPath}/resources/images/logo.png"
                  s alt="" style="width: 38px;" />
                  <h6 style="margin-left: 10px; color: white;">Master Card</h6>
                </span> <img
                  src="${pageContext.request.contextPath}/resources/images/chip.png"
                  alt="" class="chip" style="width: 50px;" />
              </header>

              <div class="card-details">
                <div class="name-number">
                  <h5 class="text-white" style="font-size: 0.8rem; color: white;">Card
                    Number</h5>
                  <h6 class="number" style="font-size: 0.6rem; color: white">
                    <c:set var="accountNumber" value="${user.accountNumber}" />
                    <c:out value="${fn:substring(accountNumber, 0, 4)}" />
                    &hairsp;
                    <c:out value="${fn:substring(accountNumber, 4, 8)}" />
                    &hairsp;
                    <c:out value="${fn:substring(accountNumber, 8, 12)}" />
                    &hairsp;
                    <c:out value="${fn:substring(accountNumber, 12, 16)}" />
                  </h6>

                  <h5 class="name text-white">${user.username}</h5>
                </div>
                <div class="valid-date" style="font-size: 0.6rem; color: white">
                  <span>Exp Date</span> <span>05/28</span>
                </div>
              </div>

            </div>

          </div>
          <div>
          <c:out value="${userId}" />
            <c:out value="${user.username}" />
            <c:out value="${user.email}" />
          </div>
        </main>
      </div>
    </div>
    <div class="mt-5 side-main-wrapper">
      <div class="search-wrapper">
        <div class="search-2">
          <i class="bx bxs-map"></i> <input type="text"
            class="border rounded" placeholder="Serach">
          <button class="btn">
            <svg fill="#000000" height="20px" width="20px" version="1.1"
              id="Capa_1" xmlns="http://www.w3.org/2000/svg"
              xmlns:xlink="http://www.w3.org/1999/xlink"
              viewBox="0 0 490.4 490.4" xml:space="preserve">
              <g>
                <path
                d="M484.1,454.796l-110.5-110.6c29.8-36.3,47.6-82.8,47.6-133.4c0-116.3-94.3-210.6-210.6-210.6S0,94.496,0,210.796
                  s94.3,210.6,210.6,210.6c50.8,0,97.4-18,133.8-48l110.5,110.5c12.9,11.8,25,4.2,29.2,0C492.5,475.596,492.5,463.096,484.1,454.796z
                   M41.1,210.796c0-93.6,75.9-169.5,169.5-169.5s169.6,75.9,169.6,169.5s-75.9,169.5-169.5,169.5S41.1,304.396,41.1,210.796z" />
              </g>
            </svg>
          </button>
        </div>
      </div>
      <div class="balance-wrapper mt-4 border p-4 rounded-3">
        <h4>Balance</h4>
        <div class="row  ">
          <div class="col-sm-3 indiv-balance rounded-2">
            <span>Amount</span>
            <h5>
              2000 <sub>MMK</sub>
            </h5>
          </div>
          <div class="col-sm-3 indiv-balance rounded-2">
            <span>Interest Amount</span>
            <h5>3%</h5>
          </div>
          <div class="col-sm-3 indiv-balance rounded-2">
            <span>Owe </span>
            <h5>
              0 <sub>MMK</sub>
            </h5>
          </div>
          <div class="col-sm-3 indiv-balance rounded-2">
            <button class="btn"
              style="background-color: var(--brand-color); color: white">Transfer</button>
            <div class="dropdown">
              <button type="button" class="btn dropdown-toggle"
                style="width: 100%" data-bs-toggle="dropdown"></button>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Link 1</a></li>
                <li><a class="dropdown-item" href="#">Link 2</a></li>
                <li><a class="dropdown-item" href="#">Link 3</a></li>
              </ul>
            </div>
          </div>
        </div>

      </div>


      <div class="card mt-4" style="width:100%; box-shadow: none;">
        <div class="card-header" style="background-color: inherit;">
          <i class="fas fa-table me-1"></i> Transaction
        </div>
        <div class="card-body">
          <div
            class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
            <div class="datatable-top">
              <div class="datatable-dropdown">
                <label> <select id="entriesPerPage"
                  class="datatable-selector">
                    <option value="5">5</option>
                    <option value="10" selected="">10</option>
                    <option value="15">15</option>
                    <option value="20">20</option>
                    <option value="25">25</option>
                </select> entries per page
                </label>

              </div>
              <div class="datatable-search">
                <input class="datatable-input" placeholder="Search..."
                  type="search" title="Search within table"
                  aria-controls="datatablesSimple">
              </div>

            </div><div class="datatable-container">
              <table class="datatable-table" id="datatablesSimple">
                <thead>
                  <tr>
                    <th>User Name</th>
                    <th>Gmail</th>
                    <th>Career</th>
                    <th>Balance</th>
                    <th>Account Number</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <!--  Following needs to be configured -->
                <!-- <tfoot>
                <tr>
                  <th>User Name</th>
                  <th>Gmail</th>
                  <th>Career</th>
                  <th>Balance</th>
                  <th>Actions</th>
                </tr>
                </tfoot> -->
                <tbody>
                  <c:forEach items="${userList}" var="user">
                    <tr>
                      <td>${user.username}</td>
                      <td>${user.email}</td>
                      <td>${user.career}</td>
                      <td>${user.balance}</td>
                      <td>${user.accountNumber}</td>
                      <td>
                        <div
                          onclick='preloadPopup(${user.id}, "${user.username}", "${pageContext.request.contextPath}")'>
                          <a href="#popup" data-bs-target="#demo">Add Balance</a>
                        </div> |<a
                        href="${pageContext.request.contextPath}/adminDashboardController?action=DELETE&id=${user.id}">Delete</a>
                      </td>
                    </tr>

                  </c:forEach>
                </tbody>
              </table>
            </div>

          </div>
          <div class="datatable-bottom">
            <div class="datatable-info">Showing 1 to 10 of 17 entries</div>
            <nav class="datatable-pagination">
              <ul class="datatable-pagination-list">
                <li
                  class="datatable-pagination-list-item datatable-hidden datatable-disabled"><a
                  data-page="1" class="datatable-pagination-list-item-link">&lsaquo;</a></li>
                <li class="datatable-pagination-list-item datatable-active"><a
                  data-page="1" class="datatable-pagination-list-item-link">1</a></li>
                <li class="datatable-pagination-list-item"><a data-page="2"
                  class="datatable-pagination-list-item-link">2</a></li>
                <li class="datatable-pagination-list-item"><a data-page="3"
                  class="datatable-pagination-list-item-link">3</a></li>
                <li class="datatable-spagination-list-item"><a
                  data-page="4" class="datatable-pagination-list-item-link">4</a></li>
                <li class="datatable-pagination-list-item"><a data-page="5"
                  class="datatable-pagination-list-item-link">5</a></li>
                <li class="datatable-pagination-list-item"><a data-page="6"
                  class="datatable-pagination-list-item-link">6</a></li>
                <li class="datatable-pagination-list-item"><a data-page="2"
                  class="datatable-pagination-list-item-link">&rsaquo;</a></li>
              </ul>
            </nav>
          </div>

        </div>
        <footer class="py-4 bg-light mt-auto">
          <div class="container-fluid px-4">
            <div
              class="d-flex align-items-center justify-content-between small">
              <div class="text-muted">Copyright &copy; CashNex</div>
              <div>
                <a href="#">Privacy Policy</a> &middot; <a href="#">Terms
                  &amp; Conditions</a>
              </div>
            </div>
          </div>
        </footer>
      </div>

    </div>


  </div>
</body>


<script
  src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
  crossorigin="anonymous"></script><script
  src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
  crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
<script
  src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
  crossorigin="anonymous"></script>
<script
  src="${pageContext.request.contextPath}/resources/js/chart-area-demo.js"></script>
<script
  src="${pageContext.request.contextPath}/resources/js/chart-bar-demo.js"></script>
<script
  src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
  crossorigin="anonymous"></script>
<script
  src="${pageContext.request.contextPath}/resources/js/datatables-simple-demo.js"></script>
<%@ include file="footer.jsp"%>					