
$( document ).ready(function() {
	requestPromotionData();
	        
});


function requestPromotionData(){
	 var promotion = {
			 feeType : $('#FEE_TYPE_NAME').val()
	 };
	 console.log(JSON.stringify(promotion));
	$.ajax({
    	url: "/api/promotionServlet",
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
	
	function requestSavePromotion(){
		console.log("dfghsajkdas");
		 var promotion = {
				 feeType : $('#FEE_TYPE_NAME').val(),
				 promotionName :$('#PROMOTION_NAME_1').val(),
				 discountHours:$('#DISCOUNT_HOUR_1').val()
		 };
		 console.log(JSON.stringify(promotion));
		$.ajax({
	   	url: "/api/promotionSaveServlet",
	       type: 'POST',
	       dataType: 'json',
	       data: JSON.stringify(promotion),
	       contentType: 'application/json',
	       mimeType: 'application/json',
	       success: function (data) {
	       	alert("Completed");
	       },
		   error: function(xhr, textStatus, errorThrown) {
				alert("Error");
		  }
	   });
		
	}	

} 
