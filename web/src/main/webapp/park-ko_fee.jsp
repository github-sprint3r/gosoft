<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/feeJson.js"></script>
<meta charset="utf-8">
<title>Park-Ko</title>
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
						<li class="active"><a href="park-ko_fee.jsp">กำหนดอัตราค่าจอดรถ</a></li>
						<li class><a href="park-ko_promotion.jsp">กำหนดส่วนลด</a></li>
						<li class="nav-header">การจัดการ</li>
						<li><a href="SearchCarLicense.jsp">คิดราคาค่าจอดรถ</a></li>
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
					<div class="span12">
						<h2>กำหนดอัตราค่าจอดรถ</h2>

						<select name="FEE_TYPE_NAME" id="FEE_TYPE_NAME"
							onchange="requestFeeData();">
							<option value="DAY_TIME">ราคาปกติ</option>
							<option value="NIGHT_TIME">ราคาค้างคืน</option>
						</select> 
						<br> ช่วงเวลา <span name="START_TIME" id="START_TIME"
							style="width: 40px;"></span> - <span name="END_TIME"
							id="END_TIME" style="width: 40px;"></span> <label for="Foo"
							id="Label_Foo" />
						<hr>
						<table cellpadding="10">
							<tr>
								<td>ชื่อ</td>
								<td>จำนวนชั่วโมง</td>
								<td>ราคา/ชั่วโมง</td>
							</tr>
							<tr>
								<td><input name="FEE_NAME_1" id="FEE_NAME_1" maxlength="50"
									type="text" /></td>
								<td><input name="HOUR_START_1" id="HOUR_START_1"
									type="text" maxlength="2" style="width: 20px;" /> - <input
									name="HOUR_END_1" id="HOUR_END_1" type="text" maxlength="2"
									style="width: 20px;" /></td>
								<td><input name="FEE_PER_HOUR_1" id="FEE_PER_HOUR_1"
									type="text" maxlength="3" style="width: 30px;" /></td>
							</tr>
							<tr>
								<td><input name="FEE_NAME_2" id="FEE_NAME_2" maxlength="50"
									type="text" /></td>
								<td><input name="HOUR_START_2" id="HOUR_START_2"
									type="text" maxlength="2" style="width: 20px;" /> - <input
									name="HOUR_END_2" id="HOUR_END_2" type="text" maxlength="2"
									style="width: 20px;" /></td>
								<td><input name="FEE_PER_HOUR_2" id="FEE_PER_HOUR_2"
									type="text" maxlength="3" style="width: 30px;" /></td>
							</tr>
							<tr>
								<td><input name="FEE_NAME_3" id="FEE_NAME_3" maxlength="50"
									type="text" /></td>
								<td><input name="HOUR_START_3" id="HOUR_START_3"
									type="text" maxlength="2" style="width: 20px;" /> - <input
									name="HOUR_END_3" id="HOUR_END_3" type="text" maxlength="2"
									style="width: 20px;" /></td>
								<td><input name="FEE_PER_HOUR_3" id="FEE_PER_HOUR_3"
									type="text" maxlength="3" style="width: 30px;" /></td>
							</tr>
						</table>
						<br>
						<button type="button" name="REGISTER_FEE" id="REGISTER_FEE" onClick="requestSaveFee();">บันทึก</button>
					</div>
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