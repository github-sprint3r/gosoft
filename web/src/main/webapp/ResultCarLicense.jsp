<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="span12" id="ResultCarLicense">
	<table cellpadding="5">
		<tr>
			<td>หมายเลขทะเบียนรถ :</td>
			<td><input type="text" id="carlicenseresulttxt" name="carlicenseresulttxt" /></td>
			<td></td>
		</tr>
		<tr>
			<td>วันเข้าจอด :</td>
			<td><input type="text" id="startdateresulttxt" name="startdateresulttxt" /></td>
			<td></td>
		</tr>
		<tr>
			<td>วันออกจอด :</td>
			<td><input type="text" id="enddateresulttxt" name="enddateresulttxt" /></td>
			<td></td>
		</tr>
		<tr>
			<td>รวมเวลาจอด :</td>
			<td><input type="text" id="totalhoursresulttxt" name="totalhoursresulttxt"
				style="width: 30px;" /> ชั่วโมง <input type="text" id="totalminresulttxt"
				name="totalminresulttxt" style="width: 30px;" /> นาที</td>
			<td></td>
		<tr>
		<tr>
			<td>ค่าที่จอดรวม:</td>
			<td><input type="text" id="netpriceresulttxt" name="netpriceresulttxt" />
				บาท</td>
			<td></td>
		<tr>
			<td>ส่วนลด:</td>
			<td><select name="promotionddl" id="promotionddl">
					<option value="0">..กรุณาเลือก..</option>
					<option value="1">ส่วนลดตั๋วหนัง</option>
			</select></td>
		</tr>
		<tr>
			<td>จำนวนเงินที่รับ:</td>
			<td><input type="text" id="receiveamountresulttxt"
				name="receiveamountresulttxt" onkeypress="formatCurrency(this)" /> บาท</td>
			<td></td>
		</tr>
		<tr>
			<td>เงินทอน:</td>
			<td><input type="text" id="changeamountresulttxt"
				name="changeamountresulttxt"  /> บาท</td>
			<td></td>
		</tr>

	</table>
    <button id="finishresultbtn" onclick = "window.location(SearchCarLicense.jsp);">เสร็จ</button>



</div>

