<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="span12" id="ResultCarLicense">
	<table cellpadding="5">
		<tr>
			<td>หมายเลขทะเบียนรถ :</td>
			<td><input type="text" id="carlicensetxt" name="carlicensetxt" /></td>
			<td></td>
		</tr>
		<tr>
			<td>วันเข้าจอด :</td>
			<td><input type="text" id="startdatetxt" name="startdatetxt" /></td>
			<td></td>
		</tr>
		<tr>
			<td>วันออกจอด :</td>
			<td><input type="text" id="enddatetxt" name="enddatetxt" /></td>
			<td></td>
		</tr>
		<tr>
			<td>รวยเวลาจอด :</td>
			<td><input type="text" id="totalhourstxt" name="totalhourstxt"
				style="width: 30px;" /> ชั่วโมง <input type="text" id="totalmintxt"
				name="totalmintxt" style="width: 30px;" /> นาที</td>
			<td></td>
		<tr>
		<tr>
			<td>ค่าที่จอดรวม:</td>
			<td><input type="text" id="netpricetxt" name="netpricetxt" />
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
			<td><input type="text" id="receiveamounttxt"
				name="receiveamounttxt" onkeypress="formatCurrency(this)" /> บาท</td>
			<td></td>
		</tr>



	</table>




</div>

