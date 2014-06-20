
$( document ).ready(function() {
	 requestFeeData();
	        
});


function requestFeeData(){
	 var fee = {
			 feeType : $('#FEE_TYPE_NAME').val()
	 };
	 console.log(JSON.stringify(fee));
	$.ajax({
    	url: "/api/feeServlet",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(fee),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
        	$('#START_TIME').text(data.startTime);
        	$('#END_TIME').text(data.endTime);
        	$('#FEE_NAME_1').val(data.feeName[0]);
        	$('#FEE_NAME_2').val(data.feeName[1]);
        	$('#FEE_NAME_3').val(data.feeName[2]);
        	$('#HOUR_START_1').val(data.hourStart[0]);
        	$('#HOUR_START_2').val(data.hourStart[1]);
        	$('#HOUR_START_3').val(data.hourStart[2]);
        	$('#HOUR_END_1').val(data.hourEnd[0]);
        	$('#HOUR_END_2').val(data.hourEnd[1]);
        	$('#HOUR_END_3').val(data.hourEnd[2]);
        	$('#FEE_PER_HOUR_1').val(data.feePerHour[0]);
        	$('#FEE_PER_HOUR_2').val(data.feePerHour[1]);
        	$('#FEE_PER_HOUR_3').val(data.feePerHour[2]);
        	
        }
       
    });
} 

