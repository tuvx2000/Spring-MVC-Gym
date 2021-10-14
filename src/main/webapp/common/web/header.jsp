<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import= "com.xuantujava.util.SecurityUtils" %>

<!-- ***** Preloader Start ***** -->
<div id="js-preloader" class="js-preloader">
	<div class="preloader-inner">
		<span class="dot"></span>
		<div class="dots">
			<span></span> <span></span> <span></span>
		</div>
	</div>
</div>
<!-- ***** Preloader End ***** -->


<!-- ***** Header Area Start ***** -->
<header class="header-area header-sticky">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<nav class="main-nav">
					<!-- ***** Logo Start ***** -->
					<a href="<c:url value='/trang-chu'/>" class="logo">Training<em> Studio</em></a>
					<!-- ***** Logo End ***** -->
					<!-- ***** Menu Start ***** -->
					<ul class="nav">
						
						<li class="active" class="scroll-to-section"><a href="<c:url value='/comprehened'/>">About</a></li>
						<li class="scroll-to-section"><a href="<c:url value='/danh-sach-bai-hoc-mien-phi'/>">Classes</a></li>
						<li class="scroll-to-section"><a href="#schedule">Schedules</a></li>
						<li class="scroll-to-section"><a href="#contact-us">Contact</a></li>

						<security:authorize  access="isAnonymous()">
						<li class="main-button"><a href="<c:url value='/dang-ky'/>">Sign Up</a></li>
						<li class="main-button"><a href="<c:url value='/dang-nhap'/>">Sign In</a></li>
						</security:authorize >

						<security:authorize  access="isAuthenticated()">
						<li class="main-button"><a href="#">Wellcome <%= SecurityUtils.getPrincipal().getFullName() %></a></li>
						<li class="main-button"  onclick="signOut();" ><a href="<c:url value='/dang-xuat'/>">Sign Out</a></li>
						<div hidden="true" class="g-signin2" data-onsuccess="onSignIn"></div>
						
						</security:authorize >





					</ul>
					<a class='menu-trigger'> <span>Menu</span>
					</a>
					<!-- ***** Menu End ***** -->
				</nav>
			</div>
		</div>
	</div>
</header>

<script>
  function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
      console.log('User signed out.');
    });
  }
</script>
<!-- ***** Header Area End ***** -->
