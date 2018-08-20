<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>CapStore | home</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/style5.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css">
		     <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
<style>
/*
    DEMO STYLE
*/
@import "https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";


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

#sidebar ul li.active > a, a[aria-expanded="true"] {
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
@media (max-width: 768px) {
    #sidebar {
        margin-left: -250px;
        transform: rotateY(90deg);
    }
    #sidebar.active {
        margin-left: 0;
        transform: none;
    }
    #sidebarCollapse span:first-of-type,
    #sidebarCollapse span:nth-of-type(2),
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
	
	<script>
function check(){
alert("merchant deleted successfully");
}
</script>
</head>

<body>

    <div class="wrapper">
        <!-- Sidebar Holder -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3>CapSTORE</h3>
            </div>

            <ul class="list-unstyled components">
              <li align="center"> <h4><b>ADMIN</b></h4></li>
				 <li >
                    <a href="#">Home</a>
                </li>
                <li>
                    <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Order Status</a>
                    <ul class="collapse list-unstyled" id="homeSubmenu">
                        <li>
                            <a href="admin_order_deliver">Delivered</a>
                        </li>
                        <li>
                            <a href="admin_order_confirmed">Confirmed</a>
                        </li>
                        <li>
                            <a href="admin_order_returned">Return</a>
                        </li>
						
                    </ul>
                </li>
				
				
				<li>
                    <a href="#merSubmenu" data-toggle="collapse" aria-expanded="true" class="dropdown-toggle">Manage Merchants</a>
                    <ul class="collapse list-unstyled" id="merSubmenu">
                        <li >
                            <a href="admin_add_merchant">Add Merchant</a>
                        </li>
                        <li class="active">
                            <a href="admin_delete_merchant">Delete Merchant</a>
                        </li>
                       						
                    </ul>
                </li>
				
				<li>
                    <a href="#catSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Product Category</a>
                    <ul class="collapse list-unstyled" id="catSubmenu">
                        <li>
                            <a href="admin_add_category">Add Category</a>
                        </li>
                        <li>
                            <a href="admin_delete_category">Delete Category</a>
                        </li>
                        
						
                    </ul>
				
				
				
				
				<li >
                    <a href="admin_remove_products">Remove Products</a>
                </li>
               
                <li>
                    <a href="admin_all_merchants">Get Merchant Details</a>
                </li>
                <li>
                    <a href="admin_all_customers">Get Customer Details</a>
                </li>
				<li>
					<a href="admin_all_products">Get Product Details</a>
            </ul>

           
        </nav>

        <!-- Page Content Holder -->
        <div id="content">

            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <button type="button" id="sidebarCollapse" class="navbar-btn">
                        <span></span>
                        <span></span>
                        <span></span>
                    </button>
                    <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-align-justify"></i>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="nav navbar-nav ml-auto">
             
                            <li class="nav-item">
                                <a class="nav-link" href="#">Sign Out</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            
            <form action="admin_delete_merchant">
             <table id="product" class="table table-striped table-bordered" style="width:100%">
                <thead>
				<tr>
				<th>merchant id</th>
				<th>Merchant name</th>
								<th>REMOVE</th>
				</tr>
				</thead>
				<tbody>
				<a:forEach items="${Category}" var="cat">
				
				<td>${mer.merchantId}</td>
				<td>${mer.merchantName}</td>
			
				<td><button type="button" class="btn btn-danger" onclick="check()">Remove</button></a></td>
				</tbody>
			
				</a:forEach>
              </table>
			  </form>
			  </div>
    </div>

    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
	<!-- sidebar navigation-->

	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
				<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
					<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>



		<script>
  $(function () {
    $('#product').DataTable({
      'paging'      : true,
      'lengthChange': true,
      'searching'   : true,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : true
    })
  })
</script> 
<script>
 $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
                $(this).toggleClass('active');
            });
        });
</script>
</body>

</html>
</body>
</html>