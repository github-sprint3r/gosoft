
$( document ).ready(function() {
	requestPromotionData();
	        
});


function requestPromotionData(){
	 var promotion = {
			 feeType : $('#FEE_TYPE_NAME').val()
	 };
	 console.log(JSON.stringify(promotion));
	$.ajax({
    	url: "/api/PromotionServlet",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(promotion),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
        	$('#START_TIME').text(data.startTime);
        	$('#END_TIME').text(data.endTime);
        	$('#PROMOTION_NAME_1').val(data.promotionName);
        	$('#DISCOUNT_HOUR_1').val(data.discountHours);
        	
        }
       
    });
} 
