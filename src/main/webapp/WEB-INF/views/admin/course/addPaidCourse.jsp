<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>



<!DOCTYPE html> 
<html> 
<head> 
<title> Java File Upload Servlet Example </title> 
</head> 
<body>

  <form method="post" action="<c:url value='/quan-tri/bai-hoc/them-moi'/>" enctype="multipart/form-data">
  <div><h4>Video: </h4><input type="file" name="file"/></div>
  <div><input type="text" name="name"  placeholder="Course Name" /></div>

  <div> <input type="text" name="description"  placeholder="Course description" /></div>
  <div> <input type="text" name="shortdescription"   placeholder="Course shortdescription" /></div>
  <div>  <input type="text" name="topic"  placeholder="Course topic"  />
  <input type="text" name="thumbnail" placeholder="Course tothumbnailpic" /></div>

    
    
   
    
   
   
    <input type="submit" value="Upload" />
  </form>

</body>
</html>