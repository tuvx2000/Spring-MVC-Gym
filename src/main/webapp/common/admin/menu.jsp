<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar"
	class="sidebar                  responsive                    ace-save-state">
	<script type="text/javascript">
		try {
			ace.settings.loadState('sidebar')
		} catch (e) {
		}
	</script>
	<div class="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="ace-icon fa fa-signal"></i>
			</button>

			<button class="btn btn-info">
				<i class="ace-icon fa fa-pencil"></i>
			</button>

			<button class="btn btn-warning">
				<i class="ace-icon fa fa-users"></i>
			</button>

			<button class="btn btn-danger">
				<i class="ace-icon fa fa-cogs"></i>
			</button>
		</div>
		<div class="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> <span class="btn btn-info"></span>

			<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
		</div>
	</div>
<!-- 			0 -->
	<ul class="nav nav-list">					
		<li>
			<a href="#" class="dropdown-toggle"> 
				<i class="menu-icon fa fa-list"></i> 
				<span class="menu-text"> 
					Quản lý bài viết 
				</span>
				<b></b>
			</a> 
			<b class="arrow"></b>
			<ul class="submenu">
				<li>
					<a href="<c:url value='/quan-tri/bai-viet/danh-sach?page=1&limit=5' />" >
						 DS bài viết
					</a> 
				</li>
			</ul>
		</li>	
<!-- 			1 -->
		<li>
			<a href="#" class="dropdown-toggle"> 
				<i class="menu-icon fa fa-list"></i> 
				<span class="menu-text"> 
					Quản lý Paid Course 
				</span>
				<b></b>
			</a> 
			<b class="arrow"></b>
			<ul class="submenu">
				<li>
<%-- 					<a href="<c:url value='/quan-tri/bai-hoc-tra-phi/them-moi' />" > --%>
<!-- 						 DS Paid Course -->
<!-- 					</a>  -->
						<a href="<c:url value='/quan-tri/bai-hoc-tra-phi/danh-sach?page=1&limit=5' />" >
						 DS Paid Course
					</a> 
				</li>
			</ul>
		</li>	
<!-- 			2 -->
		<li>
			<a href="#" class="dropdown-toggle"> 
				<i class="menu-icon fa fa-list"></i> 
				<span class="menu-text"> 
					Quản lý Free Course 
				</span>
				<b></b>
			</a> 
			<b class="arrow"></b>
			<ul class="submenu">
				<li>
					<a href="<c:url value='/quan-tri/bai-hoc-mien-phi/danh-sach?page=1&limit=5' />" >
						 DS Free Course
					</a> 
				</li>
			</ul>
		</li>	
<!-- 			3 -->
		<li>
			<a href="#" class="dropdown-toggle"> 
				<i class="menu-icon fa fa-list"></i> 
				<span class="menu-text"> 
					Quản lý Comment 
				</span>
				<b></b>
			</a> 
			<b class="arrow"></b>
			<ul class="submenu">
				<li>
					<a href="<c:url value='/quan-tri/binh-luan/danh-sach?page=1&limit=5' />" >
						 DS Comment
					</a> 
				</li>
			</ul>
		</li>	
<!-- 			4 -->
<li>
			<a href="#" class="dropdown-toggle"> 
				<i class="menu-icon fa fa-list"></i> 
				<span class="menu-text"> 
					Quản lý User 
				</span>
				<b></b>
			</a> 
			<b class="arrow"></b>
			<ul class="submenu">
				<li>
					<a href="<c:url value='/quan-tri/nguoi-dung/danh-sach?page=1&limit=5' />" >
						 DS User
					</a> 
				</li>
			</ul>
		</li>	
<!-- 			4 -->
			
<li>
			<a href="#" class="dropdown-toggle"> 
				<i class="menu-icon fa fa-list"></i> 
				<span class="menu-text"> 
					Quản lý LiveStrym
				</span>
				<b></b>
			</a> 
			<b class="arrow"></b>
			<ul class="submenu">
				<li>
					<a href="<c:url value='/quan-tri/chatcreate' />" >
						 LiveStrym Page
					</a> 
				</li>
			</ul>
		</li>	
<!-- 			4 -->		
<!-- 			4 -->
			
		<li>
			<a href="#" class="dropdown-toggle"> 
				<i class="menu-icon fa fa-list"></i> 
				<span class="menu-text"> 
					Quản lý Giao Dịch
				</span>
				<b></b>
			</a> 
			<b class="arrow"></b>
			<ul class="submenu">
				<li>
					<a href="<c:url value='/quan-tri/momo?page=1&limit=5' />" >
						 Transaction Page
					</a> 
				</li>
			</ul>
		</li>	
<!-- 			4 -->		
			
			
			
<%-- 		<li><a href="<c:url value='/quan-tri/bai-hoc/them-moi' />" class="dropdown-toggle"> <i --%>
<!-- 				class="menu-icon fa fa-list"></i> <span class="menu-text"></span> -->
<%-- 				<a href="<c:url value='/quan-tri/bai-hoc/them-moi' />" >Quản lý Paid course </a><b class="arrow fa fa-angle-down"></b> --%>
<!-- 		</a></li> -->
	</ul>
	<div class="sidebar-toggle sidebar-collapse">
		<i class="ace-icon fa fa-angle-double-left ace-save-state"
			data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>
</div>