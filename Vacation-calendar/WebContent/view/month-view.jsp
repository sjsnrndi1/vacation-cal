<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<title>휴가 일정표</title>
<link href="http://fonts.googleapis.com/earlyaccess/hanna.css" rel="stylesheet"> <!-- 폰트 -->
<link href = "http://sjsnrndi12.dothome.co.kr/lib/main.css" rel = "stylesheet" />
<script src = "http://sjsnrndi12.dothome.co.kr/lib/main.js"></script>
<script>
	
	function input_check() {
		vacationInputForm.vacation_input_name.value = prompt("이름");
		if(vacationInputForm.vacation_input_name.value == ""){ return false; }
		vacationInputForm.vacation_input_month.value = prompt("달");
		if(vacationInputForm.vacation_input_month.value == ""){ return false; }
		vacationInputForm.vacation_input_day.value = prompt("일[ ','는 여러개 ]");
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
		vacationDeleteForm.vacation_delete_day.value = prompt("일[ ','는 여러개 ]");
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
			
		<c:set var = "today" value = "<%= new java.util.Date() %>" />
		
		<fmt:formatDate var = "nowToday" value="${today}" pattern="yyyy-MM-dd" />
		initialDate: "${nowToday}",
		
		<c:if test = "${vacation_month eq 7}">
			initialDate: '2021-07-01',
		</c:if>
		<c:if test = "${vacation_month eq 8}">
			initialDate: '2021-08-01',
		</c:if>
		<c:if test = "${vacation_month eq 9}">
			initialDate: '2021-09-01',
		</c:if>
		<c:if test = "${vacation_month eq 10}">
			initialDate: '2021-10-01',
		</c:if>
		<c:if test = "${vacation_month eq 11}">
			initialDate: '2021-11-01',
		</c:if>
		
		editable: true,
		selectable: true,
		businessHours: true,
		dayMaxEvents: true,
		events: [
			<c:forEach items = "${vacationList}" var = "vacation"> {
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
			]

		});
		
		calendar.render();
	});

</script>
<style>

 body {
		height : 100vh;
		padding: 0;
		font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
		font-size: 14px;
		overflow : hidden;
	}
	#calendar {
		width : 100vw;
		height : 100vh;
		margin: 0 auto;
		padding-left: 15%;
		padding-right: 15%;
		float : left;
	}
	.input-delete-title {
		position : relative;
		height : auto;
		top : 0px;
		left : 0px;
		margin : 0px;
		padding : 0px;
		width : 49.1%;
		float : left;
	}
	.vacation_input_button {
		width : 3vw;
		height : 3vh;
		float : right;
		background-color : rgb(44, 62, 80);
		color : white;
		border-style : solid;
		border-radius : 3px;
		border-color : rgb(44, 62, 80);
	}
	.vacation_delete_button {
		width : 3vw;
		height : 3vh;
		background-color : rgb(44, 62, 80);
		color : white;
		border-style : solid;
		border-radius : 3px;
		border-color : rgb(44, 62, 80);
	}
	.input-delete-title input:hover {
		background-color : rgb(26, 37, 47);
		outline : rgb(26, 37, 47);
	}
	.fc-day-sat .fc-daygrid-bg-harness {
		background-color : #00BFFF;
	}
	.fc-day-sun .fc-daygrid-bg-harness {
		background-color : #CD5C5C;
	}
	.fc-day-today .fc-scrollgrid-sync-inner {
		background-color : 	#E9967A;
	}
	.fc-daygrid-day-events .fc-event-main {
		background-color : black;
		border-color : black;
	}
	.fc-daygrid-day-events .fc-sticky{
		color : yellow;
	}
</style>
</head>
<body>
	<form method = "GET" name = "vacationInputForm" action = "vacation_input_form" onsubmit="return input_check()">
		<input type = "hidden" id = "vacation_input_name" class = "vacation_input_name" name = "vacation_input_name" value = "" />
		<input type = "hidden" id = "vacation_input_month" class = "vacation_input_month" name = "vacation_input_month" value = "" />
		<input type = "hidden" id = "vacation_input_day" class = "vacation_input_day" name = "vacation_input_day" value = "" />
		<div class = "input-delete-title">
			<input type = "submit" id = "vacation_input_button" class = "vacation_input_button" value = "입력"/>
		</div>
	</form>
	<form method = "GET" name = "vacationDeleteForm" action = "vacation_delete_form" onsubmit="return delete_check()">
		<input type = "hidden" id = "vacation_delete_name" class = "vacation_delete_name" name = "vacation_delete_name" value = "" />
		<input type = "hidden" id = "vacation_delete_month" class = "vacation_delete_month" name = "vacation_delete_month" value = "" />
		<input type = "hidden" id = "vacation_delete_day" class = "vacation_delete_day" name = "vacation_delete_day" value = "" />
		<div class = "input-delete-title">
			<input type = "submit" id = "vacation_delete_button" class = "vacation_delete_button" value = "삭제"/>
		</div>
	</form>
	<div id='calendar'></div>

</body>
</html>
