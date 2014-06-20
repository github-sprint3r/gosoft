<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<script type="text/javascript"> 
	function backToSearchCarLicense() {
		$('#SearchCarLicense').show();
     	$('#ResultCarLicense').hide();
     	$('#carlicensemassage').html("");
		$('#provincemassage').html(""); 
		$('#carlicensetxt').val("");
		$('#provinceddl').val("");
 	}
	
	function selectDiscount() {
		if ($('#promotionddl').val() == '1') {
			$('#netpriceresulttxt').val(parseFloat($('#discountpriceresulttxt').val()));
		}
	}
	
	
	function calculateChange(event) {
		if (event.keyCode == 13) {				
			if (!isNaN($('#receiveamountresulttxt').val())) {
				var netprice = parseFloat($('#netpriceresulttxt').val());
				if ($('#promotionddl').val() == '1') {
					netprice =  parseFloat($('#discountpriceresulttxt').val());
				}				
				var receiveamount = parseFloat($('#receiveamountresulttxt').val());  
				var cashchange = receiveamount - netprice;
				$('#changeamountresulttxt').val(cashchange);
			}
	    }
 	}
	
</script>		
<div class="span12" id="ResultCarLicense">
	<table cellpadding="5">
		<tr>
			<td>หมายเลขทะเบียนรถ :</td>
			<td><input type="text" id="carlicenseresulttxt" name="carlicenseresulttxt" /></td>
			<td></td>
		</tr>
		<tr>
			<td>วันเข้าจอด :</td>
			<td><input type="text" id="startdateresulttxt" name="startdateresulttxt" style="width: 400px;"/></td>
			<td></td>
		</tr>
		<tr>
			<td>วันออกจอด :</td>
			<td><input type="text" id="enddateresulttxt" name="enddateresulttxt" style="width: 400px;"/></td>
			<td></td>
		</tr>
		<tr>
			<td>รวมเวลาจอด :</td>
			<td><input type="text" id="totalhoursresulttxt" name="totalhoursresulttxt"
				style="width: 30px;" /> ชั่วโมง <input type="text" id="totalminresulttxt"
				name="totalminresulttxt" style="width: 30px;" value="00" /> นาที</td>
			<td></td>
		<tr>
		<tr>
			<td>ค่าที่จอดรวม:</td>
			<td><input type="text" id="netpriceresulttxt" name="netpriceresulttxt" />
			<input type="hidden" id="discountpriceresulttxt" name="discountpriceresulttxt" />
				บาท</td>
			<td></td>
		<tr>
			<td>ส่วนลด:</td>
			<td><select name="promotionddl" id="promotionddl" onchange="selectDiscount();">
					<option value="0">..กรุณาเลือก..</option>
					<option value="1">ส่วนลดตั๋วหนัง</option>
			</select></td>
		</tr>
		<tr>
			<td>จำนวนเงินที่รับ:</td>
			<td><input type="text" id="receiveamountresulttxt"
				name="receiveamountresulttxt" onkeypress="calculateChange(event)" onKeyUp="if(isNaN(this.value)){ this.value='';}"/> บาท</td>
			<td></td>
		</tr>
		<tr>
			<td>เงินทอน:</td>
			<td><input type="text" id="changeamountresulttxt"
				name="changeamountresulttxt"  /> บาท</td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><button id="finishbtn" onclick = "backToSearchCarLicense();">เสร็จ</button></td>
			<td></td>
		</tr>
	</table>
    



</div>

