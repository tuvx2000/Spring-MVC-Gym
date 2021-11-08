<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>

<body>
<div >
	<div class="container" style="background-color: #ecf0f1;width: 500px;float: left;margin-left: 150px;">
		<h4>User Sentiment Free Courses:</h4>
		<canvas id="myChart"  style="transform: scale(0.9,0.9);"></canvas>
	</div>
	<div class="container" style="background-color: #ecf0f1;width: 500px;float: left;margin-left: 200px;">
		<h4>User Sentiment Paid Courses:</h4>
		<canvas id="myChartx"  style="transform: scale(0.9,0.9);"></canvas>
	</div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.6.0/chart.min.js" integrity="sha512-GMGzUEevhWh8Tc/njS0bDpwgxdCJLQBWG3Z2Ct+JGOpVnEmjvNx6ts4v6A2XJf1HOrtOsfhv3hBKpK9kE5z8AQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script>
const ctxx = document.getElementById('myChartx');
const myChartx = new Chart(ctxx, {
    type: 'doughnut',
    data: {
        labels: ['Negative', 'Positive', 'Neutral'],
        datasets: [{
            label: '# of Votes',
            data: [${POSITIVE}, ${NEUTRAL}, ${NEGATIVE}],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
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
        labels: ['Negative', 'Positive', 'Neutral'],
        datasets: [{
            label: '# of Votes',
            data: [${POSITIVE}, ${NEUTRAL}, ${NEGATIVE}],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
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
