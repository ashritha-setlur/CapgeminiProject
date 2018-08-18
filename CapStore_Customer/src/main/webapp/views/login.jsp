<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>CapStore | Login</title>

    <!-- Favicon  -->
    <link rel="icon" href="../resources/img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="../resources/css/core-style.css">
    <link rel="stylesheet" href="../resources/style.css">

</head>

<body>
    <!-- ##### Header Area Start ##### -->
    <header class="header_area">
        <div class="classy-nav-container breakpoint-off d-flex align-items-center justify-content-between">
            <!-- Classy Menu -->
            <nav class="classy-navbar" id="essenceNav">
                <!-- Logo -->
                <a class="nav-brand" href="index">CapStore</a>
                <!-- Navbar Toggler -->
                <div class="classy-navbar-toggler">
                    <span class="navbarToggler"><span></span><span></span><span></span></span>
                </div>
                <!-- Menu -->
               
            </nav>

            <!-- Header Meta Data -->
            <div class="header-meta d-flex clearfix justify-content-end">
                <!-- Search Area -->
                <div class="search-area">
                    <form action="#" method="post">
                        <input type="search" name="search" id="headerSearch" placeholder="Type for search">
                        <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                    </form>
                </div>
                <!-- Favourite Area -->
                <div class="favourite-area">
                     <a href="#" data-toggle="modal" data-target="#registerModal">Register</a>
                </div>
                <!-- User Login Info -->
                <div class="user-login-info">
                    <a class="active" href="getLogin">Sign In</a>
                </div>
            </div>

        </div>
    </header>
    <!-- ##### Header Area End ##### -->
<div class="checkout_area section-padding-80">
	    <div class="container">
	    
	             <!-- Modal -->
			  <div class="modal fade" id="registerModal" role="dialog">
				<div class="modal-dialog modal-lg">
				
				  <!-- Modal content-->
				  <div class="modal-content">
					
					<div class="modal-body">
					  <div class="merchantBtn pull-right">
						<a href="registerAsMerchant" class="btn essence-btn">Register as Merchant</a>
					  </div>
					  <div class="customerBtn pull-left">
						<a href="registerAsCustomer" class="btn essence-btn">Register as Customer</a>
					  </div>
					</div>
					<div class="modal-footer">
					  <button type="button" class="btn essence-btn" data-dismiss="modal">Close</button>
					</div>
				  </div>
				  
				</div>
			  </div>
	    
            <div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
				<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Login</h3>
            </div>
			<div><br><br></div>
				</div>
				<form class="form-horizontal" action="#" method="POST">
              <div class="box-body">
                <div class="form-group">
                  <label for="mobileNo" class="col-sm-6 control-label">Mobile Number</label>

                  <div class="col-sm-10">
                    <input type="email" class="form-control" name="mobileNo" placeholder="Enter Your Mobile Number">
                  </div>
                </div>
                <div class="form-group">
                  <label for="password" class="col-sm-6 control-label">Password</label>
                  <div class="col-sm-10">
                    <input type="password" class="form-control" name="password" placeholder="Enter Your Password">
                  </div>
                </div>
              </div>
			  <div><br><br></div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button type="submit" class="col-sm-10 btn essence-btn">Sign in</button>
              </div>
              <!-- /.box-footer -->
            </form>
            </div>
			<div class="col-md-3"></div>
		   </div>
		</div>    
     </div>
    <!-- ##### Footer Area Start ##### -->
    <footer class="footer_area clearfix">
        <div class="container">
            <div class="row">
                <!-- Single Widget Area -->
                <div class="col-12 col-md-6">
                    <div class="single_widget_area d-flex mb-30">
                        <!-- Logo -->
                        <div class="footer-logo mr-50">
                            <a href="#">CapStore</a>
                        </div>
                        <!-- Footer Menu -->
                        <div class="footer_menu">
                            <ul>
                                <li><a href="shop.html">Category</a></li>
                                <li><a href="contact.html">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Single Widget Area -->
                <div class="col-12 col-md-6 text-center">
                    <p>
                       Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | CapStore</a>
                    </p>
                </div>
            </div>

        </div>
 </footer>
    <!-- ##### Footer Area End ##### -->

    <!-- jQuery (Necessary for All JavaScript Plugins) -->
    <script src="../resources/js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="../resources/js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="../resources/js/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="../resources/js/plugins.js"></script>
    <!-- Classy Nav js -->
    <script src="../resources/js/classy-nav.min.js"></script>
    <!-- Active js -->
    <script src="../resources/js/active.js"></script>

</body>

</html>
