<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import= "com.xuantujava.util.SecurityUtils" %>
<c:url var ="userName" value="<%= SecurityUtils.getPrincipal().getFullName() %>"/>


<!DOCTYPE html>
<html>
<body style="background-color:#bdc3c7 ">
<h1>ADMIN PAGE</h1>

<br><br><br>

<h1>The DEMO LiveStream Class</h1>

<!-- <iframe width="560" height="315" src="https://www.youtube.com/embed/s8taXR3mYa8" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen=""></iframe> -->

<video id="myVideo" width="560" height="315" controls>
  <source src="https://xuantu-spring-db.s3.ap-southeast-1.amazonaws.com/Snaptik_7007967422011493638_ach.mp4" type="video/mp4">
</video>

<h1 id="cc">cccc</h1>











'<img alt="" src="https://kenh14cdn.com/thumb_w/600/pr/2020/1607432797539-0-111-669-1181-crop-1607432803997-63743074283293.jpg">

   <h1>Live Chat updates</h1>

<div>
    <div id="chat" class="chat"></div>
    <div>
	<input type="text" name="msg" id="msg" placeholder="Enter message here"/>
        <button onclick="return sendMsg();">Enter</button>
    </div>
</div>




<script>
var vid = document.getElementById("myVideo");
vid.onplay = (event) => {
  document.getElementById("cc").innerHTML = "onplay: "+ vid.currentTime;
 	var message = "adminOnPlay=" + vid.currentTime;
  
  ws.send(message);

};

vid.onpause = (event) => {
 	var message = "adminOnPause=" + vid.currentTime;
 	  ws.send(message);

};
//// RESPONE
    var wsUrl;
    if (window.location.protocol == 'http:') {
        wsUrl = 'ws://';
    } else {
        wsUrl = 'wss://';
    }
    console.log("usURL: " + wsUrl);
    
    var ws = new WebSocket(wsUrl + window.location.host + "/spring-mvc/chat/ADMIN");
       
    console.log("ws: " + ws);
        
    ///// ONMESSAGE
    ws.onmessage = function(event) {
        	
        	
    var mySpan = document.getElementById("chat");
  	var text = event.data; //// respone message
   	
    var temp = text.slice(text.indexOf("adminOnPlay=")+12,50);
    checkParam = isNumeric(temp);

	if(checkParam){
		  document.getElementById("myvid").currentTime = temp;
		  document.getElementById("myvid").play();
	}else if(isNumeric(text.slice(text.indexOf("adminOnPause=")+13,50))){
	    document.getElementById("myvid").pause();
		}else{
			mySpan.innerHTML+=text+"<br/>"+checkParam+"<br/>";

		}
    	
    	
    	
      
    };
     
    ws.onerror = function(event){
        console.log("Error ", event)
    } 
    function sendMsg() {
        var msg = document.getElementById("msg").value;
        if(msg)
        {
            ws.send(msg);
        }
        document.getElementById("msg").value="";
    }
</script>

</body>
</html>

