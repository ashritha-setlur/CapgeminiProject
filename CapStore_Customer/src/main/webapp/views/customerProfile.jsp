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
    <title>CapStore | Customer Profile</title>

    <!-- Favicon  -->
    <link rel="icon" href="../resources/img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="../resources/css/core-style.css">
    <link rel="stylesheet" href="../resources/css/style.css">

</head>

<body>
    <!-- ##### Header Area Start ##### -->
    <header class="header_area">
        <div class="classy-nav-container breakpoint-off d-flex align-items-center justify-content-between">
            <!-- Classy Menu -->
            <nav class="classy-navbar" id="essenceNav">
                <!-- Logo -->
                <a class="nav-brand" href="index.html">CapStore</a>
                <!-- Navbar Toggler -->
                <div class="classy-navbar-toggler">
                    <span class="navbarToggler"><span></span><span></span><span></span></span>
                </div>
                <!-- Menu -->
                <div class="classy-menu">
                    <!-- close btn -->
                    <div class="classycloseIcon">
                        <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                    </div>
                    <!-- Nav Start -->
                    <div class="classynav">
                        <ul>
                           <li><a href="#">Categories</a>
                                <ul class="dropdown">
                                    <li><a href="index.html">Home</a></li>
                                    <li><a href="shop.html">Shop</a></li>
                                    <li><a href="single-product-details.html">Product Details</a></li>
                                    <li><a href="checkout.html">Checkout</a></li>
                                    <li><a href="blog.html">Blog</a></li>
                                    <li><a href="single-blog.html">Single Blog</a></li>
                                    <li><a href="regular-page.html">Regular Page</a></li>
                                    <li><a href="contact.html">Contact</a></li>
                                </ul>
                            </li>
                            
                            <li><a href="contact.html">Contact</a></li>
                        </ul>
                    </div>
                    <!-- Nav End -->
                </div>
            </nav>

            <!-- Header Meta Data -->
            <div class="header-meta d-flex clearfix justify-content-end">
                <!-- Search Area -->
                <div class="search-area">
                    <form action="searchProduct" method="post">
                        <input type="search" name="searchProduct" id="headerSearch" placeholder="Type for search">
                        <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                    </form>
                </div>
                <!-- Favourite Area -->
                <div class="favourite-area">
                    <a href="#" data-toggle="modal" data-target="#registerModal">Register</a>
                </div>
                <!-- User Login Info -->
                <div class="user-login-info">
                    <a href="login">Sign In</a>
                </div>
                <!-- Cart Area -->
                <div class="cart-area">
                    <a href="#" id="essenceCartBtn"><img src="../resources/img/core-img/bag.svg" alt=""> <span></span></a>
                </div>
            </div>

        </div>
    </header>
    <!-- ##### Header Area End ##### -->

    <!-- ##### Right Side Cart Area ##### -->
    <div class="cart-bg-overlay"></div>

    <div class="right-side-cart-area">

        <!-- Cart Button -->
        <div class="cart-button">
            <a href="#" id="rightSideCart"><img src="../resources/img/core-img/bag.svg" alt=""> <span><!--add product quantity--></span></a>
        </div>

        <div class="cart-content d-flex">

            <!-- Cart List Area -->
            <div class="cart-list">
                <!-- Single Cart Item -->
                <div class="single-cart-item">
                    <a href="#" class="product-image">
                        <img src="../resources/img/product-img/product-1.jpg" class="cart-thumb" alt="">
                        <!-- Cart Item Desc -->
                        <div class="cart-item-desc">
                          <span class="product-remove"><i class="fa fa-close" aria-hidden="true"></i></span>
                            <span class="badge">Mango</span>
                            <h6>Button Through Strap Mini Dress</h6>
                            <p class="size">Size: S</p>
                            <p class="color">Color: Red</p>
                            <p class="price">$45.00</p>
                        </div>
                    </a>
                </div>

                <!-- Single Cart Item -->
                

                <!-- Single Cart Item -->
            
            </div>

            <!-- Cart Summary -->
            <div class="cart-amount-summary">

                <h2>Summary</h2>
                <ul class="summary-table">
                    <li><span>subtotal:</span> <span>$274.00</span></li>
                    <li><span>delivery:</span> <span>Free</span></li>
                    <li><span>discount:</span> <span>-15%</span></li>
                    <li><span>total:</span> <span>$232.00</span></li>
                </ul>
                <div class="checkout-btn mt-100">
                    <a href="checkout.html" class="btn essence-btn">check out</a>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Right Side Cart End ##### -->

   

    <!-- ##### Checkout Area Start ##### -->
    <div class="checkout_area section-padding-80">
        <div class="container">
		
		
		<!-- Modal -->
			  <div class="modal fade" id="registerModal" role="dialog">
				<div class="modal-dialog modal-lg">
				
				  <!-- Modal content-->
				  <div class="modal-content">
					
					<div class="modal-body">
					  <div class="merchantBtn pull-right">
						<a href="#" class="btn essence-btn">Register as Merchant</a>
					  </div>
					  <div class="customerBtn pull-left">
						<a href="#" class="btn essence-btn">Register as Customer</a>
					  </div>
					</div>
					<div class="modal-footer">
					  <button type="button" class="btn essence-btn" data-dismiss="modal">Close</button>
					</div>
				  </div>
				  
				</div>
			  </div>
		
		
            <div class="row">

                

                        <div class="cart-page-heading mb-30">
                            <h5>Edit Profile</h5>
                        </div>
                           
									
				<div class="col-md-6">
					<form name="customerUpdate" class="form-horizontal" action="#" onsubmit="return checkForm(this);" method="GET">
					  <div class="box-body">
					  <div class="form-group">
						  <label for="merchantName" class="col-sm-6 control-label">Name</label>
						  <div class="col-sm-10">
							<input type="text" class="form-control" name="merchantName" placeholder="Enter Your Name" required>
						  </div>
						</div>
						<div class="form-group">
						  <label for="merchantEmail" class="col-sm-6 control-label">Email ID</label>

						  <div class="col-sm-10">
							<input type="email" class="form-control" name="merchantEmail" placeholder="Enter Your Email" required>
						  </div>
						</div>
						<div class="form-group">
						  <label for="mobileNo" class="col-sm-6 control-label">Mobile Number</label>

						  <div class="col-sm-10">
							<input type="text" class="form-control" name="mobileNo" pattern="^\d{10}$" placeholder="Enter Your Mobile Number" required>
						  </div>
						</div>
						
						  
					 <div class="form-group">
						  <label for="addressLine1" class="col-sm-6 control-label">Address Line 1</label>
						  <div class="col-sm-10">
							<input type="text" class="form-control" name="addressLine1" placeholder="Enter Your Address" required>
						  </div>
					</div>
					<div class="form-group">
					  <label for="addressLine2" class="col-sm-6 control-label">Address Line 2</label>
					  <div class="col-sm-10">
						<input type="text" class="form-control" name="addressLine2" placeholder="Enter Your Address" required>
					  </div>
					</div>
					<div class="form-group">
					  <label for="city" class="col-sm-6 control-label">City</label>
					  <div class="col-sm-10">
						<input type="text" class="form-control" name="city" placeholder="Enter Your City" required>
					  </div>
						</div>
						<div class="form-group">
						  <label for="state" class="col-sm-6 control-label">State</label>
						  <div class="col-sm-10">
							<input type="text" class="form-control" name="state" placeholder="Enter Your State" required>
						  </div>
						</div>
						<div class="form-group">
						  <label for="country" class="col-sm-6 control-label">Country</label>
						  <div class="col-sm-10">
							<input type="text" class="form-control" name="country" placeholder="Enter Your Country" required>
						  </div>
						</div>
						<div class="form-group">
						  <label for="pincode" class="col-sm-6 control-label">Pin Code</label>
						  <div class="col-sm-10">
							<input type="text" class="form-control" name="pincode" pattern="^[1-9][0-9]{5}$" placeholder="Enter Your Pin Code" required>
						  </div>
						</div>
					 </div> 
					  <div id="RegisterBtn" class="box-footer">
						<button type="submit" class="col-sm-10 btn essence-btn">Update Profile</button>
					  </div>
					  </form>
			
				</div>
										
											
								   

                <div class="col-md-6">
                    <div class="order-details-confirmation">

                        <div class="cart-page-heading">
                            <h5>YOUR ORDERS</h5>
                            <p>THE DETAILS</p>
                        </div>

                        <ul class="order-details-form mb-4">
                            <li><span>Product</span> <span>Total</span></li>
                            <li><span>${product.productName}</span> <span>Rs.${product.productPrice}</span></li>
                            <li><span>Quantity</span> <span>${product.productQuantity}</span></li>
                            <li><span>Shipping</span> <span>Free</span></li>
                            <li><span>Total</span> <span><c:out value = "${product.productPrice}*${product.productQuantity}"/></span></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Checkout Area End ##### -->

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