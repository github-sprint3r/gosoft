<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Bootstrap, from Twitter</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="assets/ico/favicon.png">

<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>  
<script type="text/javascript">  
  
         $.ajax({   
              url:'/api/carLicenseInit',   
              type:'GET',  
              dataType: 'json',
              success: function(data) {   
            	 // $("#provinceddl").val(data.provincename);           	 
            	 console.log(data);
            	var options = '<option value ="">..กรุณาเลือก..</option>';
      			var selectedText = '';
      			$.each(data, function(index, val)
      			{
      				var selectedString = '';
      				if (val.Selected == true)
      				{
      					selectedText = val.provinceid;
      					selectedString = ' selected="selected"';
      				}
      				options += '<option value="' +val.provinceid+'">'+val.provincename+'</option>' ;
      			});  
      			
      			$('select#provinceddl').html(options);  	
      			$('#SearchCarLicense').show();
      			$('#ResultCarLicense').hide();
              },
              error:function(er) {
            	  console.log(er);
                
              }
         }); 
         
         
         function searchCarLicense() {
 		    var searchCriteria = new Object();
 		    searchCriteria.carlicensetxt = $('#carlicensetxt').val();
 		    searchCriteria.provinceddl = $('#provinceddl').val();
 		    	
 			$.ajax({   
 	            url:'/api/SearchCarLicense',   
 	            type:'POST',  
 	            dataType: 'json',
 	            data: JSON.stringify(searchCriteria),
 	            contentType: 'application/json',
 	            mimeType: 'application/json',
 	            success: function(data) {   
 	            	$('#SearchCarLicense').hide();
 	            	$('#ResultCarLicense').show();
 					
 	            	
 	            },
 	            error:function(error) {
 	                alert("error message :" + error);
 	            }
 	       }); 
 		}
    
</script>  
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="#">Park-Ko</a>
				<div class="nav-collapse collapse">
					<p class="navbar-text pull-right">
						Logged in as <a href="#" class="navbar-link">karan</a>
					</p>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">ตั้งค่า</li>
						<li class><a href="park-ko_fee.jsp">กำหนดอัตราค่าจอดรถ</a></li>
						<li ><a href="park-ko_promotion.jsp">กำหนดส่วนลด</a></li>
						<li class="nav-header">การจัดการ</li>
						<li class="active"><a href="SearchCarLicense.jsp">คิดราคาค่าจอดรถ</a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<div class="span9">
				<div class="hero-unit">
					<h1>สวัสดี, กรัณย์</h1>
				</div>
				<div class="row-fluid">
					<div class="span12" id="SearchCarLicense">

						<!-- ==================================== start content================================================================================================================================== -->
						<h2>Park-ko : Search Car license</h2>
						<fieldset>
							<legend>ค้นหา</legend>
							<table>
								<tr>
									<td>หมายเลขทะเบียนรถ(*) :</td>
									<td><input type="text" id="carlicensetxt" />&nbsp;<span
										id="carlicensemassage"></span></td>
								</tr>
								<tr>
									<td>จังหวัด(*) :</td>
									<td>
									<select id="provinceddl"></select></td>
								</tr>
								<tr>
									<td colspan="2" style="text-align: center"><button
											id="searchbtn" onclick="searchCarLicense();">ค้นหา</button></td>
									<td></td>
								</tr>
							</table>
						</fieldset>
						<!-- ==================================== end content================================================================================================================================== -->


					</div>
					
					<%@ include file="ResultCarLicense.jsp" %>
					
					<!--/span-->
				</div>
				<!--/row-->
			</div>
			<!--/span-->
		</div>
		<!--/row-->

		<hr>

		<footer>
			<p>&copy; Park-Ko 2557</p>
		</footer>

	</div>
	<!--/.fluid-container-->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="bootstrap/js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap-transition.js"></script>
	<script src="bootstrap/js/bootstrap-alert.js"></script>
	<script src="bootstrap/js/bootstrap-modal.js"></script>
	<script src="bootstrap/js/bootstrap-dropdown.js"></script>
	<script src="bootstrap/js/bootstrap-scrollspy.js"></script>
	<script src="bootstrap/js/bootstrap-tab.js"></script>
	<script src="bootstrap/js/bootstrap-tooltip.js"></script>
	<script src="bootstrap/js/bootstrap-popover.js"></script>
	<script src="bootstrap/js/bootstrap-button.js"></script>
	<script src="bootstrap/js/bootstrap-collapse.js"></script>
	<script src="bootstrap/js/bootstrap-carousel.js"></script>
	<script src="bootstrap/js/bootstrap-typeahead.js"></script>

</body>
</html>
