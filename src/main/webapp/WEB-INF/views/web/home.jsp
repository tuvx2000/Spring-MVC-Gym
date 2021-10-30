<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Trang chu nguoi dung</title>


 
</head>

<body>
	<!-- ***** Main Banner Area Start ***** -->
	<div class="main-banner" id="top">
		<video autoplay muted loop id="bg-video">
			<source
				src="<c:url value='/template/web/assets/images/gym-video.mp4'/>"
				type="video/mp4" />




		</video>

		<div class="video-overlay header-text">
			<div class="caption">
				<h6>work harder, get stronger</h6>
				<h2>
					easy with our <em>gym</em>
				</h2>
				<div class="main-button scroll-to-section">
					<a href="#features">Become a member</a>
				</div>
			</div>
		</div>
	</div>
	<!-- ***** Main Banner Area End ***** -->

	<!-- ***** Features Item Start ***** -->
	<section class="section" id="features">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 offset-lg-3">
					<div class="section-heading">
						<h2>
							Choose <em>Program</em>
						</h2>
						<img
							src="<c:url value='/template/web/assets/images/line-dec.png'/>"
							alt="waves">
						<p>Let's Choose Program suitable for you.</p>
					</div>
				</div>
				<div class="col-lg-6">
					<ul class="features-items">
						<li class="feature-item">
							<div class="left-icon">
								<img
									src="<c:url value='/template/web/assets/images/features-first-icon.png'/>"
									alt="First One">
							</div>
							<div class="right-content">
								<h4>Basic Fitness SERIES</h4>
								<p>Free course for all user. This provide all information for beginer, let jump on it....
								</p>
								<a href="#" class="text-button">Discover More</a>
							</div>
						</li>

						<li class="feature-item">
							<div class="left-icon">
								<img
									src="/spring-mvc/template/web/assets/images/features-first-icon.png"
									alt="second one">
							</div>
							<div class="right-content">
								<h4>New Gym Training SERIES</h4>
								<p>Free course for all user. This provide all information for beginer, let jump on it....
								</p>
								<a href="#" class="text-button">Discover More</a>
							</div>
						</li>
						<li class="feature-item">
							<div class="left-icon">
								<img
									src="/spring-mvc/template/web/assets/images/features-first-icon.png"
									alt="third gym training">
							</div>
							<div class="right-content">
								<h4>Basic Muscle Course SERIES</h4>
								<p>
									Free course for all user. This provide all information for beginer, let jump on it....
								</p>
								<a href="#" class="text-button">Discover More</a>
							</div>
						</li>
					</ul>
				</div>
				<div class="col-lg-6">
					<ul class="features-items">
						<li class="feature-item">
							<div class="left-icon">
								<img
									src="/spring-mvc/template/web/assets/images/features-first-icon.png"
									alt="fourth muscle">
							</div>
							<div class="right-content">
								<h4>Advanced Muscle Course SERIES</h4>
								<p>
									This series provide more information for only Register member. Let's Register now.....
								</p>
								<a href="#" class="text-button">Discover More</a>
							</div>
						</li>
						<li class="feature-item">
							<div class="left-icon">
								<img
									src="/spring-mvc/template/web/assets/images/features-first-icon.png"
									alt="training fifth">
							</div>
							<div class="right-content">
								<h4>Advanced Yoga Training SERIES</h4>
								<p>This series provide more information for only Register member. Let's Register now.....
								</p>
								<a href="#" class="text-button">Discover More</a>
							</div>
						</li>
						<li class="feature-item">
							<div class="left-icon">
								<img
									src="/spring-mvc/template/web/assets/images/features-first-icon.png"
									alt="gym training">
							</div>
							<div class="right-content">
								<h4> Advanced Body Building Course SERIES</h4>
								<p>This series provide more information for only Register member. Let's Register now.....
								</p>
								<a href="#" class="text-button">Discover More</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Features Item End ***** -->

	<!-- ***** Call to Action Start ***** -->
	<section class="section" id="call-to-action">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 offset-lg-1">
					<div class="cta-content">
						<h2>
							Don’t <em>think</em>, begin <em>today</em>!
						</h2>
						<p>10Real Gymcenter</p>
						<div class="main-button scroll-to-section">
							<a href="#our-classes">Become a member</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Call to Action End ***** -->

	<!-- ***** Our Classes Start ***** -->
	<section class="section" id="our-classes">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 offset-lg-3">
					<div class="section-heading">
						<h2>
							Our <em>Recommend for Gymmer.</em>
						</h2>
						<img src="/spring-mvc/template/web/assets/images/line-dec.png"
							alt="">
						<p>10Real Gymcenter.</p>
					</div>
				</div>
			</div>
			<div class="row" id="tabs">
				<div class="col-lg-4">
					<ul>
						<li><a href='#tabs-1'><img
								src="/spring-mvc/template/web/assets/images/tabs-first-icon.png"
								alt="">First Recommend</a></li>
						<li><a href='#tabs-2'><img
								src="/spring-mvc/template/web/assets/images/tabs-first-icon.png"
								alt="">Second Recommend</a></a></li>
						<li><a href='#tabs-3'><img
								src="/spring-mvc/template/web/assets/images/tabs-first-icon.png"
								alt="">Third Recommend</a></a></li>
						<li><a href='#tabs-4'><img
								src="/spring-mvc/template/web/assets/images/tabs-first-icon.png"
								alt="">Fourth Recommend</a></a></li>
						<div class="main-rounded-button">
							<a href="#">View Our Courses</a>
						</div>
					</ul>
				</div>
				<div class="col-lg-8">
					<section class='tabs-content'>
						<article id='tabs-1'>
							<img
								src="/spring-mvc/template/web/assets/images/training-image-01.jpg"
								alt="First Class">
							<h4>First Recommend</h4>
							<p>Bodybuilding is centered around building your body’s muscles through weightlifting and nutrition.
							Whether recreational or competitive, bodybuilding is often referred to as a lifestyle.
							</p>
							<div class="main-button">
								<a href="#">View Our Courses</a>
							</div>
						</article>
						<article id='tabs-2'>
							<img
								src="/spring-mvc/template/web/assets/images/training-image-02.jpg"
								alt="Second Training">
							<h4>Second Recommend</h4>
							<p>In order to maximize your results from the gym, you must focus on your diet, as eating the wrong foods can be detrimental to your bodybuilding goals.
								Bodybuilding differs from powerlifting or Olympic lifting in that it’s judged on a competitor’s physical appearance rather than physical strength.</p>
							<div class="main-button">
								<a href="#">View Our Courses</a>
							</div>
						</article>
						<article id='tabs-3'>
							<img
								src="/spring-mvc/template/web/assets/images/training-image-03.jpg"
								alt="Third Class">
							<h4>Third Recommend</h4>
							<p>As such, bodybuilders aspire to develop and maintain a well-balanced, lean and muscular physique.
									To do this, many bodybuilders start with an off-season followed by an in-season way of eating — referred to as a bulking and cutting phase, respectively.
							</p>
							<div class="main-button">
								<a href="#">View Our Courses</a>
							</div>
						</article>
						<article id='tabs-4'>
							<img
								src="/spring-mvc/template/web/assets/images/training-image-04.jpg"
								alt="Fourth Training">
							<h4>Fourth Recommend</h4>
							<p>Resistance training increases muscle strength and size. Muscle strength is highly correlated with a lower risk of dying from cancer, heart and kidney disease, as well as several other critical illnesses.
							</p>
							<div class="main-button">
								<a href="#">View Our Courses</a>
							</div>
						</article>
					</section>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Our Classes End ***** -->

	<section class="section" id="schedule">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 offset-lg-3">
					<div class="section-heading dark-bg">
						<h2>
							Classes <em>Schedule</em>
						</h2>
						<img src="/spring-mvc/template/web/assets/images/line-dec.png"
							alt="">
						<p>This is SCHEDULE for famous PT on weeks in our On Site</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="filters">
						<ul class="schedule-filter">
							<li class="active" data-tsfilter="monday">Monday</li>
							<li data-tsfilter="tuesday">Tuesday</li>
							<li data-tsfilter="wednesday">Wednesday</li>
							<li data-tsfilter="thursday">Thursday</li>
							<li data-tsfilter="friday">Friday</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-10 offset-lg-1">
					<div class="schedule-table filtering">
						<table>
							<tbody>
								<tr>
									<td class="day-time">Fitness Class</td>
									<td class="monday ts-item show" data-tsmeta="monday">10:00AM
										- 11:30AM</td>
									<td class="tuesday ts-item" data-tsmeta="tuesday">2:00PM -
										3:30PM</td>
									<td>William G. Stewart</td>
								</tr>
								<tr>
									<td class="day-time">Muscle Training</td>
									<td class="friday ts-item" data-tsmeta="friday">10:00AM -
										11:30AM</td>
									<td class="thursday friday ts-item" data-tsmeta="thursday"
										data-tsmeta="friday">2:00PM - 3:30PM</td>
									<td>Paul D. Newman</td>
								</tr>
								<tr>
									<td class="day-time">Body Building</td>
									<td class="tuesday ts-item" data-tsmeta="tuesday">10:00AM
										- 11:30AM</td>
									<td class="monday ts-item show" data-tsmeta="monday">2:00PM
										- 3:30PM</td>
									<td>Boyd C. Harris</td>
								</tr>
								<tr>
									<td class="day-time">Yoga Training Class</td>
									<td class="wednesday ts-item" data-tsmeta="wednesday">10:00AM
										- 11:30AM</td>
									<td class="friday ts-item" data-tsmeta="friday">2:00PM -
										3:30PM</td>
									<td>Hector T. Daigle</td>
								</tr>
								<tr>
									<td class="day-time">Advanced Training</td>
									<td class="thursday ts-item" data-tsmeta="thursday">10:00AM
										- 11:30AM</td>
									<td class="wednesday ts-item" data-tsmeta="wednesday">2:00PM
										- 3:30PM</td>
									<td>Bret D. Bowers</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- ***** Testimonials Starts ***** -->
	<section class="section" id="trainers">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 offset-lg-3">
					<div class="section-heading">
						<h2>
							Expert <em>Trainers</em>
						</h2>
						<img src="/spring-mvc/template/web/assets/images/line-dec.png"
							alt="">
						<p>Famous PT of our Gymcenter</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4">
					<div class="trainer-item">
						<div class="image-thumb">
							<img
								src="/spring-mvc/template/web/assets/images/first-trainer.jpg"
								alt="">
						</div>
						<div class="down-content">
							<span>Strength Trainer</span>
							<h4>Bret D. Bowers</h4>
							<p>Bitters cliche tattooed 8-bit distillery mustache. Keytar
								succulents gluten-free vegan church-key pour-over seitan
								flannel.</p>
							<ul class="social-icons">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-behance"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="trainer-item">
						<div class="image-thumb">
							<img
								src="/spring-mvc/template/web/assets/images/second-trainer.jpg"
								alt="">
						</div>
						<div class="down-content">
							<span>Muscle Trainer</span>
							<h4>Hector T. Daigl</h4>
							<p>Bitters cliche tattooed 8-bit distillery mustache. Keytar
								succulents gluten-free vegan church-key pour-over seitan
								flannel.</p>
							<ul class="social-icons">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-behance"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="trainer-item">
						<div class="image-thumb">
							<img
								src="/spring-mvc/template/web/assets/images/third-trainer.jpg"
								alt="">
						</div>
						<div class="down-content">
							<span>Power Trainer</span>
							<h4>Paul D. Newman</h4>
							<p>Bitters cliche tattooed 8-bit distillery mustache. Keytar
								succulents gluten-free vegan church-key pour-over seitan
								flannel.</p>
							<ul class="social-icons">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-behance"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Testimonials Ends ***** -->

	<!-- ***** Contact Us Area Starts ***** -->
	<section class="section" id="contact-us">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-xs-12">
					<div id="map">
						<iframe
							src="https://maps.google.com/maps?q=Av.+L%C3%BAcio+Costa,+Rio+de+Janeiro+-+RJ,+Brazil&t=&z=13&ie=UTF8&iwloc=&output=embed"
							width="100%" height="600px" frameborder="0" style="border: 0"
							allowfullscreen></iframe>
					</div>
				</div>
<!-- 				<div class="col-lg-6 col-md-6 col-xs-12"> -->
<!-- 					<div class="contact-form"> -->
<!-- 						<form id="contact" action="" method="post"> -->
<!-- 							<div class="row"> -->
<!-- 								<div class="col-md-6 col-sm-12"> -->
<!-- 									<fieldset> -->
<!-- 										<input name="name" type="text" id="name" -->
<!-- 											placeholder="Your Name*" required=""> -->
<!-- 									</fieldset> -->
<!-- 								</div> -->
<!-- 								<div class="col-md-6 col-sm-12"> -->
<!-- 									<fieldset> -->
<!-- 										<input name="email" type="text" id="email" -->
<!-- 											pattern="[^ @]*@[^ @]*" placeholder="Your Email*" required=""> -->
<!-- 									</fieldset> -->
<!-- 								</div> -->
<!-- 								<div class="col-md-12 col-sm-12"> -->
<!-- 									<fieldset> -->
<!-- 										<input name="subject" type="text" id="subject" -->
<!-- 											placeholder="Subject"> -->
<!-- 									</fieldset> -->
<!-- 								</div> -->
<!-- 								<div class="col-lg-12"> -->
<!-- 									<fieldset> -->
<!-- 										<textarea name="message" rows="6" id="message" -->
<!-- 											placeholder="Message" required=""></textarea> -->
<!-- 									</fieldset> -->
<!-- 								</div> -->
<!-- 								<div class="col-lg-12"> -->
<!-- 									<fieldset> -->
<!-- 										<button type="submit" id="form-submit" class="main-button">Send -->
<!-- 											Message</button> -->
<!-- 									</fieldset> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</form> -->
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
		</div>
	</section>
	<!-- ***** Contact Us Area Ends ***** -->
</body>

</html>