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

      @media (max-width: 980px) {
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
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="assets/ico/favicon.png">
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <button type="button"  class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Park-Ko</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              Logged in as <a href="#" class="navbar-link">karan</a>
            </p>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">ตั้งค่า</li>
              <li class="active"><a href="park-ko_fee.jsp">กำหนดอัตรค่าจอดรถ</a></li>
               <li class><a href="park-ko_promotion.jsp">กำหนดส่วนลด</a></li>
              <li class="nav-header">การจัดการ</li>
              <li><a href="#">คิดราคาค่าจอดรถ</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span9">
          <div class="hero-unit">
            <h1>สวัสดี, กรัณย์</h1>
          </div>
          <div class="row-fluid">
            <div class="span12">
              <h2>กำหนดอัตราค่าจอดรถ</h2>
              
              <select name="fee_type_name" id="fee_type_name">
			    <option>ราคาปกติ</option>
			    <option>ราคาค้างคืน</option>
			  </select>
              <br>
              ช่วงเวลา <input name = "start_time"  id = "start_time" input_type = "text"> - <input name = "end_time"  id = "end_time" input_type = "text">
              <hr> 
              <table>
              			<tr>
              					<td>
              						 ชื่อ
              					</td>
              					<td>
              						 จำนวนชั่วโมง
              					</td>
              					<td>
              						 ราคา/ชั่วโมง
              					</td>
              			</tr>
              			<tr>
              					<td>
              							<input name = "FEE_NAME_1"  id = "FEE_NAME_1" input_type = "text"> 				
              					</td>
              					<td>
              							<input name = "HOUR_START_1"  id = "HOUR_START_1" input_type = "text"> - 				
              							<input name = "HOUR_END_1"  id = "HOUR_END_1" input_type = "text">
              					</td>
              					<td>
              							<input name = "FEE_PER_HOUR_1"  id = "FEE_PER_HOUR_1"  input_type = "text"> 				
              					</td>
              			</tr>
              			<tr>
              					<td>
              							<input name = "FEE_NAME_2"  id = "FEE_NAME_2" input_type = "text"> 				
              					</td>
              					<td>
              							<input name = "HOUR_START_2"  id = "HOUR_START_2" input_type = "text"> - 				
              							<input name = "HOUR_END_2"  id = "HOUR_END_2" input_type = "text">
              					</td>
              					<td>
              							<input name = "FEE_PER_HOUR_2"  id = "FEE_PER_HOUR_2"  input_type = "text"> 				
              					</td>
              			</tr>
              			<tr>
              					<td>
              							<input name = "FEE_NAME_3"  id = "FEE_NAME_3" input_type = "text"> 				
              					</td>
              					<td>
              							<input name = "HOUR_START_3"  id = "HOUR_START_3" input_type = "text"> - 				
              							<input name = "HOUR_END_3"  id = "HOUR_END_3" input_type = "text">
              					</td>
              					<td>
              							<input name = "FEE_PER_HOUR_3"  id = "FEE_PER_HOUR_3"  input_type = "text"> 				
              					</td>
              			</tr>
              </table>
              <br>
              <a class="btn" href="#" name = "REGISTER_FEE"  id = "REGISTER_FEE"  >บันทึก &raquo;</a> 	
              </div><!--/span-->
          </div><!--/row-->
        </div><!--/span-->
      </div><!--/row-->

      <hr>

      <footer>
        <p>&copy; Park-Ko 2557</p>
      </footer>

    </div><!--/.fluid-container-->

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