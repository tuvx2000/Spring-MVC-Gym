<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>

<c:url var ="SentimentAPIFREECOURSE" value="/api/admin_sentiment_freecourses"/>
<c:url var ="SentimentAPIPAIDCOURSE" value="/api/admin_sentiment_paidcourses"/>



<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>

<body>


<div >
	<div class="container" style="background-color: #ecf0f1;width: 400px;float: left;margin-left: 150px;">
		<div style="text-align:center;padding-top: 15px;padding-bottom: 15px">
			<button class="btn btn-dark" class="btn btn-warning" onClick="SentimentAPIFREECOURSE()"> Analyzed FreeCourses</button>
		</div>
		
	
		<h4>User Sentiment Free Courses:</h4>
		<canvas id="myChart"  style="transform: scale(0.9,0.9);"></canvas>
		
		<div style="text-align:center;padding-top: 15px;padding-bottom: 15px">
			<h3 style="color:#e67e22">Status: <h3 id="title1" style="color:green"> READY</h3></h3>
		</div>
	</div>
	<div class="container" style="background-color: #ecf0f1;width: 400px;float: left;margin-left: 200px;">
		<div style="text-align:center;padding-top: 15px;padding-bottom: 15px">
			<button class="btn btn-dark" onClick="SentimentAPIPAIDCOURSE()"> Analyzed PaidCourses</button>
		</div>
		
		<h4>User Sentiment Paid Courses:</h4>
		<canvas id="myChartx"  style="transform: scale(0.9,0.9);"></canvas>
		
		<div style="text-align:center;padding-top: 15px;padding-bottom: 15px">
			<h3 style="color:#e67e22">Status: <h3 id="title2" style="color:green"> READY</h3></h3>			
		</div>
	</div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.6.0/chart.min.js" integrity="sha512-GMGzUEevhWh8Tc/njS0bDpwgxdCJLQBWG3Z2Ct+JGOpVnEmjvNx6ts4v6A2XJf1HOrtOsfhv3hBKpK9kE5z8AQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script>
//////////////// Start analyzed
var timeOutId = 0;

function SentimentAPIFREECOURSE() {
	console.log("Submited");
	document.getElementById("title1").innerHTML = "ANALYZING";
	document.getElementById("title1").style.color = "red";
	const data = {status: "analyzedfreeCourses"};
			
	
	console.log("JSON Submited: " + JSON.stringify(data));


	
    $.ajax({
        url: '${SentimentAPIFREECOURSE}',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        async: !1,
        success: function (result) {
//         	window.location.href = "${editURL}?page=1&limit=2?id=" +result.id +"&message=insert_success";
        	//?type=edit&id="+result.id+"&message=insert_success";
        	console.log("Submited: " + result.userSentiment);
        	document.getElementById("title1").innerHTML = "READY";
        	clearTimeout(timeOutId);
//         	updateChartSentiment(result.userSentiment);
        	
        },
        error: function (Submited) {
//         	window.location.href = "${NewURL}?page=1&limit=2"+"&message=error_system";
        	//?type=list&maxPageItem=2&page=1&message=error_system";
        	console.log("Submited: " + result.userSentiment);
        	clearTimeout(timeOutId);

        }
    });
}
function SentimentAPIPAIDCOURSE() {
	console.log("Submited");
	document.getElementById("title2").innerHTML = "ANALYZING";
	document.getElementById("title2").style.color = "red";
	const data = {status: "analyzedpaidCourses"};
			
	
	console.log("JSON Submited: " + JSON.stringify(data));

	
    $.ajax({
        url: '${SentimentAPIPAIDCOURSE}',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        async: !1,
        success: function (result) {
//         	window.location.href = "${editURL}?page=1&limit=2?id=" +result.id +"&message=insert_success";
        	//?type=edit&id="+result.id+"&message=insert_success";
        	console.log("Submited: " + result.userSentiment);
        	clearTimeout(timeOutId);
        	document.getElementById("title2").innerHTML = "READY";

//         	updateChartSentiment(result.userSentiment);
        	
        },
        error: function (Submited) {
//         	window.location.href = "${NewURL}?page=1&limit=2"+"&message=error_system";
        	//?type=list&maxPageItem=2&page=1&message=error_system";
        	console.log("Submited: " + result.userSentiment);
        	clearTimeout(timeOutId);

        }
    });
}
timeOutId = setTimeout(SentimentAPIFREECOURSE, 100000000);













///////////// end
const ctxx = document.getElementById('myChartx');
const myChartx = new Chart(ctxx, {
    type: 'doughnut',
    data: {
        labels: ['Negative', 'Neutral' ,'Positive'],
        datasets: [{
            label: '# of Votes',
            data: [${POSITIVE1}, ${NEUTRAL1}, ${NEGATIVE1}],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(140, 252, 66, 0.2)',
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(92, 201, 18, 0.2)',
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        },
        plugins: {
            legend: {
                position: 'top',
              },
              title: {
                display: true,
                text: 'User Sentiment Chart'
              }
        }
    }
});


const ctx = document.getElementById('myChart');
const myChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ['Negative', 'Neutral' ,'Positive'],
        datasets: [{
            label: '# of Votes',
            data: [${POSITIVE}, ${NEUTRAL}, ${NEGATIVE}],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(140, 252, 66, 0.2)',
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(92, 201, 18, 0.2)',
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        },
        plugins: {
            legend: {
                position: 'top',
              },
              title: {
                display: true,
                text: 'User Sentiment Chart'
              }
        }
    }
});
</script>


	
<script>

</script>
</body>
</html>
