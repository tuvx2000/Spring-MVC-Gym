<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.xuantujava.util.SecurityUtils"%>
<%@include file="/common/taglib.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="navbar" class="navbar navbar-default          ace-save-state">
	<div class="navbar-container ace-save-state" id="navbar-container">
		<div class="navbar-header pull-left">
			<a href="<c:url value='/quan-tri/trang-chu'/>" class="navbar-brand"> <small> <i
					class="fa fa-leaf"></i> Trang quản trị
			</small>
			</a>
		</div>
		<div
			class="navbar-buttons navbar-header pull-right collapse navbar-collapse" role="navigation">
			<ul class="nav ace-nav">
						<li class="main-button"><a href="#">Wellcome <%=SecurityUtils.getPrincipal().getFullName()%> </a> </li>
				
						<li class="main-button"><a href="<c:url value='/dang-xuat'/>">SignOut </a></li>
			</ul>
		</div>
	</div>
</div>
