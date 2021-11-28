<%@include file="/common/taglib.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<c:url var ="PopStatusURL" value="/api/momo"/>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make Member</title>
</head>
<body>
	<br><br><br><br><br><br>
	<h1 style="text-align:center" id="statuspayment">xxxxxxxxx</h1>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<!-- 	<button onClick="PopStatus()">button</button> -->
	
	
<script>
	
	function PopStatus() {
		
		var returnUrl = window.location.href;
		console.log("cc" + returnUrl);
		var url = new URL(returnUrl);
		var c = url.searchParams.get("message");
		var d = url.searchParams.get("orderId"); 
		var e = url.searchParams.get("amount");
		var DOMpayment = document.getElementById("statuspayment");
		var descriptionValue ;
		if(c == "Success"){
			DOMpayment.innerHTML =  "Thanh Toán Thành Công";
			descriptionValue= 1;
		}
		else{
			DOMpayment.innerHTML = "Thanh Toán Thất Bại";
			descriptionValue = 0;
		}
		console.log("cc:"+ c);
		var amountValue = e;
		var orderIdValue = d;
		var userIdValue = d.slice(0, d.indexOf("N"));
		
		
		
		
		console.log("Submited1");

		const data = {amount: amountValue, orderId: orderIdValue, description: descriptionValue,userId: userIdValue};				
		console.log("JSON Submited: " + JSON.stringify(data));
		console.log("cc");
	    $.ajax({
	        url: '${PopStatusURL}',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(data),
	        dataType: 'json',
	        success: function (result) {
	        	
	        },
	        error: function (Submited) {
	        }
	    });
	}
	PopStatus() ;
	
</script>
</body>

</html>