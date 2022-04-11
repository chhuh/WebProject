$(document).ready(function(){
	const name=$.cookie("name");
	if(name){
		$("#loginSpan").html(name + "<button id='logoutBtn'>logout</button>");
		// 회원가입 -> 회원정보
		$("#memberA").html("<button id=\"memberInfoBtn\" class=\"btn\" data-toggle=\"modal\" data-target=\"#memberModal\">회원정보</button>");
		$("#contact").html("");
	}
	
	$(document).on('click','#logoutBtn',function(){
		$.post('main',{sign:"logOut"},function(){
			$.removeCookie("name");
			location.reload();
		});
	});
	
	$(document).on('click','#memberInfoBtn',function(){
		$.post('main',{name, sign:"memberInfo"},function(){
		});
	});
	
	$(document).on('click','#memberDeleteBtn',function(){
		alert();
		$.post('main',{name, sign:"memberDelete"},function(){
			$.removeCookie("name");
			location.reload();
		});
	});
	
	$(document).on('click','#memberModifyBtn',function(){
		const name=$("#name2").val();
		const email=$("#email2").val();
		const pw=$("#pw2").val();
		const fl=$("#fl2").val();
		$.post('main', {name,email,pw,fl, sign:"memberModify"}, function(data){
			location.reload();
		});
	});
	
	$("#memberInsertBtn").click(function(){
		const name=$("#name").val();
		const email=$("#email").val();
		const pw=$("#pw").val();
		const fl=$("#fl").val();
		$.post('main', {name,email,pw,fl, sign:"memberInsert"}, function(data){
			data=JSON.parse(data);
			console.log(data);
			if(data.msg){
				alert(data.msg);
			}
		});
	});
	
	$("#loginBtn").click(function(){
		const id=$("#id").val();
		const pwd=$("#pwd").val();
		$.post('main', {id,pwd,sign:"login"}, function(data){
			data=JSON.parse(data);
			console.log(data);
			if(data.msg){
				alert(data.msg);
			}else if(data.name){
				$.cookie("name",data.name);
				location.reload();
			}
		});
	});
	
	$("#noticeRefreshBtn").click(function(){
		$.post('main', {sign:"noticeRefresh"}, function(data){
			location.reload();
		});
	});
	
	$("#boardList").click(function(){
		$.post('main', {sign:"boardList"}, function(data){
			data=JSON.parse(data);
			//
		});
	});
	
});