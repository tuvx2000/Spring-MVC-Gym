<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import= "com.xuantujava.util.SecurityUtils" %>
<c:url var ="userName" value="<%= SecurityUtils.getPrincipal().getFullName() %>"/>


<!DOCTYPE html>
<html>
<body>
<br><br><br>
<h1>The DEMO LiveStream Class</h1>

<img alt="" src="https://kenh14cdn.com/thumb_w/600/pr/2020/1607432797539-0-111-669-1181-crop-1607432803997-63743074283293.jpg">

   <h1>Live Chat updates</h1>

<div>
    <div id="chat" class="chat"></div>
    <div>
	<input type="text" name="msg" id="msg" placeholder="Enter message here"/>
        <button onclick="return sendMsg();">Enter</button>
    </div>
</div>




<script>
function myFunction() {
  document.getElementById("demo").innerHTML = "Hello World";
}


    var wsUrl;
    if (window.location.protocol == 'http:') {
        wsUrl = 'ws://';
    } else {
        wsUrl = 'wss://';
    }
    console.log("usURL: " + wsUrl);
    
    var ws = new WebSocket(wsUrl + window.location.host + "/spring-mvc/chat/${userName}");
       
    console.log("ws: " + ws);
        
    ws.onmessage = function(event) {
      var mySpan = document.getElementById("chat");
      mySpan.innerHTML+=event.data+"<br/>";
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

