<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href="http://fonts.googleapis.com/earlyaccess/hanna.css" rel="stylesheet"> <!-- 폰트 -->
<link href = "http://sjsnrndi12.dothome.co.kr/lib/main.css" rel = "stylesheet" />
<script src = "http://sjsnrndi12.dothome.co.kr/lib/main.js"></script>
<script>
	
	function input_check() {
		vacationInputForm.vacation_input_name.value = prompt("이름");
		if(vacationInputForm.vacation_input_name.value == ""){ return false; }
		vacationInputForm.vacation_input_month.value = prompt("달");
		if(vacationInputForm.vacation_input_month.value == ""){ return false; }
		vacationInputForm.vacation_input_day.value = prompt("일");
		if(vacationInputForm.vacation_input_day.value == ""){ return false; }
		
		var name = document.getElementById("vacation_input_name").value;
		var month = document.getElementById("vacation_input_month").value;
		var day = document.getElementById("vacation_input_day").value;
		
		switch(month) {
			case "1" : case "3" : case "5" : case "7" : case "8" : case "10" : case "12" :
				if(day < 1 || day > 31) { alert("일수가 틀림!"); return false; }
				else { return true;	}
			case "4" : case "6" : case "9" : case "11" :
				if(day < 1 || day > 30) { alert("일수가 틀림!"); return false; }
				else {  return true; }
			case "2" :
				if(day < 1 || day > 28) { alert("일수가 틀림!"); return false; }
				else {  return true; }v
			default : alert("월 또는 일수가 이상함!"); return false;
		}
	}
	
	function delete_check() {
		vacationDeleteForm.vacation_delete_name.value = prompt("이름");
		if(vacationDeleteForm.vacation_delete_name.value == ""){ return false; }
		vacationDeleteForm.vacation_delete_month.value = prompt("달");
		if(vacationDeleteForm.vacation_delete_month.value == ""){ return false; }
		vacationDeleteForm.vacation_delete_day.value = prompt("일");
		if(vacationDeleteForm.vacation_delete_day.value == ""){ return false; }
		
		var name = document.getElementById("vacation_delete_name").value;
		var month = document.getElementById("vacation_delete_month").value;
		var day = document.getElementById("vacation_delete_day").value;
		
		switch(month) {
			case "1" : case "3" : case "5" : case "7" : case "8" : case "10" : case "12" :
				if(day < 1 || day > 31) { alert("일수가 틀림!"); return false; }
				else { return true;	}
			case "4" : case "6" : case "9" : case "11" :
				if(day < 1 || day > 30) { alert("일수가 틀림!"); return false; }
				else {  return true; }
			case "2" :
				if(day < 1 || day > 28) { alert("일수가 틀림!"); return false; }
				else {  return true; }
			default : alert("월 또는 일수가 이상함!"); return false;
		}
	}
	
	document.addEventListener('DOMContentLoaded', function() {
		
		var calendarEl = document.getElementById('calendar');
		
		var calendar = new FullCalendar.Calendar(calendarEl, {
			headerToolbar: {
				left: 'prev,next today',
				center: 'title',
				right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
			},

			initialDate: '2021-07-08',
			navLinks: true, // can click day/week names to navigate views
			nowIndicator: true,
		
			weekNumbers: true,
			weekNumberCalculation: 'ISO',
		
			editable: true,
			selectable: true,
			dayMaxEvents: true, // allow "more" link when too many events\
			
			events: [
				<c:forEach items = "${vacationList}" var = "vacation">
				{
					title: "${vacation.name}",
					<c:choose>
						<c:when test="${vacation.month < 10 and vacation.day < 10}">
							start: '2021-0' + "${vacation.month}" + '-0' + "${vacation.day}"
						</c:when>
						<c:when test="${vacation.month < 10 and vacation.day >= 10}">
							start: '2021-0' + "${vacation.month}" + '-' + "${vacation.day}"
						</c:when>
						<c:when test="${vacation.month >= 10 and vacation.day < 10}">
							start: '2021-' + "${vacation.month}" + '-0' + "${vacation.day}"
						</c:when>
						<c:otherwise>
							start: '2021-' + "${vacation.month}" + '-' + "${vacation.day}"
						</c:otherwise>
					</c:choose>
				},
				</c:forEach>
			],
		});
		calendar.render();
	});
</script>
<style>

	body {
		margin: 40px 10px;
		padding: 0;
		font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
		font-size: 14px;
	}
	
	#calendar {
		max-width: 1100px;
		margin: 0 auto;
	}
	
	.vacation_input_button {
		position : absolute;
		top : 40px;
		left : 1183px;
		width : 62px;
		height : 35px;
		border-radius : 3px;
		background-color : white;
		color : black;
		font-size : 150%;
		font-family: 'Hanna';
	}

	.vacation_delete_button {
		position : absolute;
		top : 40px;
		left : 1245px;
		width : 62px;
		height : 35px;
		border-radius : 3px;
		background-color : white;
		color : black;
		font-size : 150%;
		font-family: 'Hanna';
	}
</style>
</head>
<body>
	<div id = "calendar"></div>
	<form method = "GET" name = "vacationInputForm" action = "vacation_input_form" onsubmit="return input_check()">
		<input type = "hidden" id = "vacation_input_name" class = "vacation_input_name" name = "vacation_input_name" value = "" />
		<input type = "hidden" id = "vacation_input_month" class = "vacation_input_month" name = "vacation_input_month" value = "" />
		<input type = "hidden" id = "vacation_input_day" class = "vacation_input_day" name = "vacation_input_day" value = "" />
		<input type = "submit" id = "vacation_input_button" class = "vacation_input_button" value = "입력"/>
	</form>
	<form method = "GET" name = "vacationDeleteForm" action = "vacation_delete_form" onsubmit="return delete_check()">
		<input type = "hidden" id = "vacation_delete_name" class = "vacation_delete_name" name = "vacation_delete_name" value = "" />
		<input type = "hidden" id = "vacation_delete_month" class = "vacation_delete_month" name = "vacation_delete_month" value = "" />
		<input type = "hidden" id = "vacation_delete_day" class = "vacation_delete_day" name = "vacation_delete_day" value = "" />
		<input type = "submit" id = "vacation_delete_button" class = "vacation_delete_button" value = "삭제"/>
	</form>
</body>
</html>
