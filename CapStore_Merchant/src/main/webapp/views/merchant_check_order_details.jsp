<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>CapSTORE | Merchant | Check Order Details</title>

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<!-- Our Custom CSS -->
<style>
* {
	box-sizing: border-box;
}

/* Add padding to containers */
.container {
	padding: 16px;
	background-color: white;
}

/* Full-width input fields */
input[type=text] {
	width: 200%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus {
	background-color: #ddd;
	outline: none;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for the submit button */
.add {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.add:hover {
	opacity: 1;
}

/*
    DEMO STYLE
*/
@import
	"https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";

body {
	font-family: 'Poppins', sans-serif;
	background: #fafafa;
}

p {
	font-family: 'Poppins', sans-serif;
	font-size: 1.1em;
	font-weight: 300;
	line-height: 1.7em;
	color: #999;
}

a, a:hover, a:focus {
	color: inherit;
	text-decoration: none;
	transition: all 0.3s;
}

.navbar {
	padding: 15px 10px;
	background: #fff;
	border: none;
	border-radius: 0;
	margin-bottom: 40px;
	box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1);
}

.navbar-btn {
	box-shadow: none;
	outline: none !important;
	border: none;
}

.line {
	width: 100%;
	height: 1px;
	border-bottom: 1px dashed #ddd;
	margin: 40px 0;
}

/* ---------------------------------------------------
    SIDEBAR STYLE
----------------------------------------------------- */
.avatar {
	vertical-align: middle;
	width: 100px;
	height: 100px;
	border-radius: 50%;
}

.wrapper {
	display: flex;
	width: 100%;
	align-items: stretch;
	perspective: 1500px;
}

#sidebar {
	min-width: 250px;
	max-width: 250px;
	background: #000000;
	color: #fff;
	transition: all 0.6s cubic-bezier(0.945, 0.020, 0.270, 0.665);
	transform-origin: bottom left;
}

#sidebar.active {
	margin-left: -250px;
	transform: rotateY(100deg);
}

#sidebar .sidebar-header {
	padding: 20px;
	background: #6d7fcc;
}

#sidebar ul.components {
	padding: 20px 0;
	border-bottom: 1px solid #47748b;
}

#sidebar ul p {
	color: #fff;
	padding: 10px;
}

#sidebar ul li a {
	padding: 10px;
	font-size: 1.1em;
	display: block;
}

#sidebar ul li a:hover {
	color: #7386D5;
	background: #fff;
}

#sidebar ul li.active>a, a[aria-expanded="true"] {
	color: #fff;
	background: #6d7fcc;
}

a[data-toggle="collapse"] {
	position: relative;
}

.dropdown-toggle::after {
	display: block;
	position: absolute;
	top: 50%;
	right: 20px;
	transform: translateY(-50%);
}

ul ul a {
	font-size: 0.9em !important;
	padding-left: 30px !important;
	background: #6d7fcc;
}

ul.CTAs {
	padding: 20px;
}

ul.CTAs a {
	text-align: center;
	font-size: 0.9em !important;
	display: block;
	border-radius: 5px;
	margin-bottom: 5px;
}

a.download {
	background: #fff;
	color: #7386D5;
}

a.article, a.article:hover {
	background: #6d7fcc !important;
	color: #fff !important;
}

/* ---------------------------------------------------
    CONTENT STYLE
----------------------------------------------------- */
#content {
	width: 100%;
	padding: 20px;
	min-height: 100vh;
	transition: all 0.3s;
}

#sidebarCollapse {
	width: 40px;
	height: 40px;
	background: #f5f5f5;
	cursor: pointer;
}

#sidebarCollapse span {
	width: 80%;
	height: 2px;
	margin: 0 auto;
	display: block;
	background: #555;
	transition: all 0.8s cubic-bezier(0.810, -0.330, 0.345, 1.375);
	transition-delay: 0.2s;
}

#sidebarCollapse span:first-of-type {
	transform: rotate(45deg) translate(2px, 2px);
}

#sidebarCollapse span:nth-of-type(2) {
	opacity: 0;
}

#sidebarCollapse span:last-of-type {
	transform: rotate(-45deg) translate(1px, -1px);
}

#sidebarCollapse.active span {
	transform: none;
	opacity: 1;
	margin: 5px auto;
}

/* ---------------------------------------------------
    MEDIAQUERIES
----------------------------------------------------- */
@media ( max-width : 768px) {
	#sidebar {
		margin-left: -250px;
		transform: rotateY(90deg);
	}
	#sidebar.active {
		margin-left: 0;
		transform: none;
	}
	#sidebarCollapse span:first-of-type, #sidebarCollapse span:nth-of-type(2),
		#sidebarCollapse span:last-of-type {
		transform: none;
		opacity: 1;
		margin: 5px auto;
	}
	#sidebarCollapse.active span {
		margin: 0 auto;
	}
	#sidebarCollapse.active span:first-of-type {
		transform: rotate(45deg) translate(2px, 2px);
	}
	#sidebarCollapse.active span:nth-of-type(2) {
		opacity: 0;
	}
	#sidebarCollapse.active span:last-of-type {
		transform: rotate(-45deg) translate(1px, -1px);
	}
}
</style>

<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
	integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
	crossorigin="anonymous"></script>

</head>

<body>

	<div class="wrapper">
		<!-- Sidebar Holder -->
		<nav id="sidebar">
		<div class="sidebar-header">
			<h3>CapSTORE</h3>
		</div>

		<ul class="list-unstyled components">
			<li align="center">
				<h4>Merchant</h4>
			</li>
			<li><a href="merchant_home">Home</a></li>
			<li><a href="#productSubmenu" data-toggle="collapse"
				aria-expanded="false" class="dropdown-toggle">Manage Products</a>
				<ul class="collapse list-unstyled" id="productSubmenu">
					<li><a href="merchant_add_product">Add Product</a></li>
					<li><a href="merchant_delete_product">Delete Product</a></li>
					<li><a href="merchant_update_product">Update Product</a></li>
					<li><a href="merchant_display_products">Display Products</a></li>
				</ul></li>
			<li class="active"><a href="merchant_check_order_details">Check
					Order Details</a></li>
			<li><a href="merchant_discounts">Discounts</a></li>
			<li><a href="merchant_promos">Promos</a></li>
			<li><a href="merchant_change_password">Change Password</a>
		</ul>

		</nav>

		<!-- Page Content Holder -->
		<div id="content">

			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">

				<button type="button" id="sidebarCollapse" class="navbar-btn">
					<span></span> <span></span> <span></span>
				</button>
				<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
					type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="fas fa-align-justify"></i>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">

						<li class="nav-item"><a class="nav-link" href="#">Sign
								Out</a></li>
					</ul>
				</div>
			</div>
			</nav>

			<table>
				<tr>
					<td>Enter Order Id</td>
					<td><input type="text" name="orderId" /></td>
				</tr>

			</table>



			<c:choose>
				<c:when test="${OrderDetails}==null">
			order not found
		</c:when>
				<c:otherwise>


					<form method="GET">
						<div class="container">
							<br />
							<br />

							<h1>Order Details</h1>
							<br />
							<hr>
							<table>

								<tr>
									<td>Product Name</td>
									<td><input type="text" name="productName"
										value="${OrderDetails.product.productName}" /></td>
								</tr>
								<tr>
									<td>Product Description</td>
									<td><input type="text" name="productDesc"
										value="${OrderDetails.product.productDesc}" /></td>
								</tr>
								<tr>
									<td>Product Category</td>
									<td><input type="text" name="productCategory"
										value="${OrderDetails.product.productCategory}" /></td>
								</tr>
								<tr>
									<td>Delivery Status</td>

									<td><input type="text"
										value="${OrderDetails.deliveryStatus}" /></td>
								</tr>
								<tr>
								<tr>
								
							</table>
					</form>
				</c:otherwise>
			</c:choose>




		</div>
	</div>

	<!-- jQuery CDN - Slim version (=without AJAX) -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<!-- Popper.JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<!-- Bootstrap JS -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>
	<!-- sidebar navigation-->
	<script> 
	$(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
                $(this).toggleClass('active');
            });
        });</script>
</body>

</html>