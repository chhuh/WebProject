<%@ page contentType="text/html; charset=utf-8" import="java.util.ArrayList,web.vo.NoticeVO, web.dao.NoticeDAO, web.vo.MemberVO" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>Bootstrap Theme The Band</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/my.js"></script>
  <script
   src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"
   integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA=="
   crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <style>
  body {
    font: 400 15px/1.8 Lato, sans-serif;
    color: #777;
  }
  h3, h4 {
    margin: 10px 0 30px 0;
    letter-spacing: 10px;      
    font-size: 20px;
    color: #111;
  }
  .container {
    padding: 80px 120px;
  }
  .person {
    border: 10px solid transparent;
    margin-bottom: 25px;
    width: 80%;
    height: 80%;
    opacity: 0.7;
  }
  .person:hover {
    border-color: #f1f1f1;
  }
  .carousel-inner img {
    -webkit-filter: grayscale(90%);
    filter: grayscale(90%); /* make all photos black and white */ 
    width: 100%; /* Set width to 100% */
    margin: auto;
  }
  .carousel-caption h3 {
    color: #fff !important;
  }
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
    }
  }
  .bg-1 {
    background: #2d2d30;
    color: #bdbdbd;
  }
  .bg-1 h3 {color: #fff;}
  .bg-1 p {font-style: italic;}
  .list-group-item:first-child {
    border-top-right-radius: 0;
    border-top-left-radius: 0;
  }
  .list-group-item:last-child {
    border-bottom-right-radius: 0;
    border-bottom-left-radius: 0;
  }
  .thumbnail {
    padding: 0 0 15px 0;
    border: none;
    border-radius: 0;
  }
  .thumbnail p {
    margin-top: 15px;
    color: #555;
  }
  .btn {
    padding: 10px 20px;
    background-color: #333;
    color: #f1f1f1;
    border-radius: 0;
    transition: .2s;
  }
  .btn:hover, .btn:focus {
    border: 1px solid #333;
    background-color: #fff;
    color: #000;
  }
  .modal-header, h4, .close {
    background-color: #333;
    color: #fff !important;
    text-align: center;
    font-size: 30px;
  }
  .modal-header, .modal-body {
    padding: 40px 50px;
  }
  .nav-tabs li a {
    color: #777;
  }
  #googleMap {
    width: 100%;
    height: 400px;
    -webkit-filter: grayscale(100%);
    filter: grayscale(100%);
  }  
  .navbar {
    font-family: Montserrat, sans-serif;
    margin-bottom: 0;
    background-color: #2d2d30;
    border: 0;
    font-size: 11px !important;
    letter-spacing: 4px;
    opacity: 0.9;
  }
  .navbar li a, .navbar .navbar-brand { 
    color: #d5d5d5 !important;
  }
  .navbar-nav li a:hover {
    color: #fff !important;
  }
  .navbar-nav li.active a {
    color: #fff !important;
    background-color: #29292c !important;
  }
  .navbar-default .navbar-toggle {
    border-color: transparent;
  }
  .open .dropdown-toggle {
    color: #fff;
    background-color: #555 !important;
  }
  .dropdown-menu li a {
    color: #000 !important;
  }
  .dropdown-menu li a:hover {
    background-color: red !important;
  }
  footer {
    background-color: #2d2d30;
    color: #f5f5f5;
    padding: 32px;
  }
  footer a {
    color: #f5f5f5;
  }
  footer a:hover {
    color: #777;
    text-decoration: none;
  }  
  .form-control {
    border-radius: 0;
  }
  textarea {
    resize: none;
  }
  </style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#myPage">??????</a>
      <span id="loginSpan">ID<input size="3" id="id"> PW<input size="3" id="pwd"><button id="loginBtn">login</button></span>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#myPage">??? ??????</a></li>
        <li><a href="#band">????????? ??????</a></li>
        <li><a href="#tour" id="boardList">????????????</a></li>
        <li><a href="#store">????????????</a></li>
        <li><a href="#contact"  id="memberA">????????????</a></li>
      </ul>
    </div>
  </div>
</nav>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="ny.jpg" alt="New York" width="1200" height="700">
        <div class="carousel-caption">
          <h3>New York</h3>
          <p>The atmosphere in New York is lorem ipsum.</p>
        </div>      
      </div>

      <div class="item">
        <img src="chicago.jpg" alt="Chicago" width="1200" height="700">
        <div class="carousel-caption">
          <h3>Chicago</h3>
          <p>Thank you, Chicago - A night we won't forget.</p>
        </div>      
      </div>
    
      <div class="item">
        <img src="la.jpg" alt="Los Angeles" width="1200" height="700">
        <div class="carousel-caption">
          <h3>LA</h3>
          <p>Even though the traffic was a mess, we had the best time playing at Venice Beach!</p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>

<!-- Container (The Band Section) -->

<div id="band" class="container text-center">
<!-- 
<c:if test="${memberVO.userType eq 'admin' }">
	<button id="noticeRefreshBtn">??? ???????????? ????????????</button>
</c:if>
-->

 
<%-- <%
MemberVO memberVO = (MemberVO) application.getAttribute("memberInfo");
if(memberVO != null) {
	System.out.println(memberVO.getName());
}
%> --%>

${memberInfo.name}

??????????????? ?????????
<form name="pageForm" id="pageForm">
	<input type="hidden" name="act" id="act" value="list" />
	<input type="hidden" name="pg" id="pg" value="" />
	<input type="hidden" name="key" id="key" value="${key}" />
	<input type="hidden" name="word" id="word" value="${word}" />
</form>
<table class="table">
<tr><th>????????????</th><th>????????????</th></tr>
<c:forEach items="${houseList}"  var="item">    
         <tr><td>${item.aptName }</td><td>${item.dealAmount } </td></tr>
  	</c:forEach>
</table>
${navi.navigator}


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3e1794eea2e7ef8391644920bd1b4eb2"></script>
<script type="text/javascript">
	var map;
	$(function () {
		//  ????????? ?????? ??????.
		var container = document.getElementById("map"); //????????? ?????? ????????? DOM ????????????
		var options = {
			//????????? ????????? ??? ????????? ?????? ??????
			center: new kakao.maps.LatLng(37.5012743, 127.039585), //????????? ????????????. (???????????????)
			level: 3, //????????? ??????(??????, ?????? ??????)
		};

		map = new kakao.maps.Map(container, options); //?????? ?????? ??? ?????? ??????
		
		// ????????? ????????? ???????????????
		var markerPosition = new kakao.maps.LatLng(37.5012743, 127.039585);

		// ????????? ???????????????
		var marker = new kakao.maps.Marker({
			position: markerPosition,
		});

		// ????????? ?????? ?????? ??????????????? ???????????????
		marker.setMap(map);
		// HTML5??? geolocation?????? ????????? ??? ????????? ???????????????
		if (navigator.geolocation) {
			// GeoLocation??? ???????????? ?????? ????????? ???????????????
			navigator.geolocation.getCurrentPosition(function (position) {
				var lat = position.coords.latitude, // ??????
					lon = position.coords.longitude; // ??????

				var locPosition = new kakao.maps.LatLng(lat, lon), // ????????? ????????? ????????? geolocation?????? ????????? ????????? ???????????????
					message = '<div style="padding:5px;">????????? ?????????????!</div>'; // ?????????????????? ????????? ???????????????

				// ????????? ?????????????????? ???????????????
				displayMarker(locPosition, message);
			});
		} else {
			// HTML5??? GeoLocation??? ????????? ??? ????????? ?????? ?????? ????????? ??????????????? ????????? ???????????????

			var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),
				message = "geolocation??? ???????????? ?????????..";

			displayMarker(locPosition, message);
		}

		// ????????? ????????? ?????????????????? ???????????? ???????????????
		function displayMarker(locPosition, message) {
			// ????????? ???????????????
			var marker = new kakao.maps.Marker({
				map: map,
				position: locPosition,
			});

			var iwContent = message, // ?????????????????? ????????? ??????
				iwRemoveable = true;

			// ?????????????????? ???????????????
			var infowindow = new kakao.maps.InfoWindow({
				content: iwContent,
				removable: iwRemoveable,
			});

			// ?????????????????? ???????????? ???????????????
			infowindow.open(map, marker);

			// ?????? ??????????????? ??????????????? ???????????????
			map.setCenter(locPosition);
		}
	});
</script>

<div id="map" style="width: 100%; height: 500px"></div>

</div>

<!-- Container (TOUR Section) -->
<div id="tour" class="bg-1">
  <div class="container">
    <h3 class="text-center">????????????</h3>
    <c:if test="${memberVO.userType eq 'admin' }">
		<button id="noticeRefreshBtn" class="btn">??? ???????????? ????????????</button>
	</c:if>
	
	<table class="table">
	<tr><th>no</th><th>title</th><th>content</th>
	<c:if test="${memberVO.userType eq 'admin' }">
		<th></th><th></th>
	</c:if>
	</tr>

	<c:forEach items="${noticeList}"  var="item">    
          	<tr><td>${item.no}</td><td>${item.title }</td><td>${item.content } </td>
          		<c:if test="${memberVO.userType eq 'admin' }">
          		<td>
	       	    	<%--????????? ?????? ?????? --%>
					<button id="noticeEditBtn" data-toggle="modal" data-target="#myModal">??????</button>
				</td>
				<td>
					<%--????????? ?????? ?????? --%>
					<button id="noticeDelteBtn">??????</button>
				</td>
				</c:if>
          	</tr>
   	</c:forEach>
	
	</table>
	
	<c:if test="${memberVO.userType eq 'admin' }">
		<button id="newNoticeBtn" class="btn" data-toggle="modal" data-target="#myModal">???????????? ??????</button>
	</c:if>
  </div>
  
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">x</button>
          <h4>?????????</h4>
        </div>
          <div class="modal-body">
            <div>
              <form id="writeForm" name="writeForm" method="post">
                <div>
                  <div>
                    <table>
                      <tr>
                        <th>??????</th>
                        <td><input style="width: 450px" type="text" id="title" name="title" ></td>
                      </tr>
                      <tr>
                        <th>??????</th>
                        <td><textarea style="width: 450px" rows="10" cols="10" id="content" name="content"></textarea></td>
                      </tr>
                      <tr>
                        <th>?????????</th>
                        <td><input style="width: 450px" type="text" id="writer" name="writer" /></td>
                      </tr>
                    </table>
                    <div>
                      <button id="BoardInsertBtn" class="btn btn-block">
                                        ??? ??????<span class="glyphicon glyphicon-ok"></span>
                      </button>
                    </div>
            	  </div>
                </div>
              </form>
            </div>
        </div>
      </div>
    </div>
  </div>
</div>

  <!-- Modal -->
  <div class="modal fade" id="memberModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">x</button>
          <h4>????????????</h4>
        </div>
          <div class="modal-body">
            <div>
              <form id="writeForm" name="writeForm" method="post">
                <div>
                  <div>
                    <table>
                      <tr>
                        <th>??????</th>
                        <td><input  readonly style="width: 200px; border:0" type="text" id="name2" name="title" value="${memberInfo.name}" ></td>
                      </tr>
                      <tr>
                        <th>?????????</th>
                        <td><input style="width: 200px; border:0" type="text" id="email2" name="title" value="${memberInfo.email}" ></td>
                      </tr>
                      <tr>
                        <th>????????????</th>
                        <td><input style="width: 200px; border:0" type="text" id="pw2" name="writer" value="${memberInfo.pw}" ></td>
                      </tr>
                      <tr>
                        <th>????????????</th>
                        <td><input style="width: 200px; border:0" type="text" id="fl2" name="writer" value="${memberInfo.fl}" ></td>
                      </tr>
                    </table>
                    <div>
                    <div class="row">
				        <div class="col-sm-6"><button id="memberModifyBtn" class="btn btn-block">??????</button></div>
				        <div class="col-sm-6"><button id="memberDeleteBtn" class="btn btn-block">??????</button></div>
				    </div>
                      
                      
                      
                      
                    
            	  </div>
                </div>
              </form>
            </div>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Container (Store Section) -->

<div id="store" class="container">
  <h3 class="text-center">????????????</h3>
	<table class="table">
	<tr><th>?????????</th><th>????????????</th><th>????????????</th></tr>
	<c:forEach items="${storeList}"  var="item">    
	         <tr><td>${item.stname }</td><td>${item.sttype } </td><td>${item.fulljibun } </td></tr>
	  	</c:forEach>
	</table>
</div>

<!-- Container (Contact Section) -->

<div id="contact" class="bg-1">
<div id="contact" class="container">
  <h3 class="text-center">????????????</h3>
  <div class="row">
    <div class="col">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="name" name="name" placeholder="Name" type="text" value="" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
        </div>
      </div>
      
      <input class="form-control" id="pw" name="pw" placeholder="pw" type="text" required>
      <input class="form-control" id="fl" name="fl" placeholder="favorite location" type="text" required>
      <br>
      <div class="row">
        <div class="col-md-12 form-group">
          <button class="btn pull-right" id="memberInsertBtn">member insert</button>
        </div>
      </div>
    </div>  
    </div>
</div>
</div>

<!-- Image of location/map -->
<img src="map.jpg" class="img-responsive" style="width:100%">

<!-- Footer -->
<footer class="text-center">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
  <p>Made by ??????&?????????</p> 
</footer>

<script>
$(document).ready(function(){
  // Initialize Tooltip
  $('[data-toggle="tooltip"]').tooltip(); 
  
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {

      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
})
</script>

</body>
</html>
