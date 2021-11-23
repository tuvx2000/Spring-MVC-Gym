<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import= "com.xuantujava.util.SecurityUtils" %>
<c:url var ="userName" value="<%= SecurityUtils.getPrincipal().getFullName() %>"/>


<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div style="width:900px;height:600px;border: 2px solid red;
 					  border-radius: 20px;
					  text-align:center;align-items:center;align-self:center;justify-items:center;position:absolute;left:50%;top:50%;transform:translate(-50%,-50%);
					  background-color:#bdc3c7;
					  ">
		<form method="post" action="<c:url value='/quan-tri/chat'/>" enctype="multipart/form-data">
			<!--  start a unit -->
			  <div class="form-group">
			        <label style="font-size: 150%" class="col-sm-3 control-label no-padding-right">Your Link Video(S3):</label>
			        <div class="col-sm-9">
			  			<input type="text" name="linkvideo" class="form-control"  placeholder="linkvideo" />
			        </div>
			  </div>        
				<br><br><br><br><br><br><br><br><br><br>
				
				<div style="background-color:#ecf0f1;">
					  <input style="height: 100px;width: 200px;font-size: 200%" type="submit" value="Create New livestym"  
					  />
				</div>
		</form>	
</div>
</body>
</html>