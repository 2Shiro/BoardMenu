<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" type="image/png" href="/img/favicon.png" />
<link rel="stylesheet"  href="/css/common.css" />
<script src="https://cdn.jsdelivr.net/npm/sass@1.72.0/sass.default.min.js"></script>
<style>
	td {
		padding : 10px;
		width : 150px;
		text-align : center;
	}
	
	tr:first-child {
		background-color:black;
		color: white;
		font-weight: bold;
		
		td {
			border-color : white;
		}
	}
	
	/*
	tr:first-child td {
		border-color : white;
	}
	*/
	
	tr:nth-child(2) td {
		text-align : right;
	}
</style>
</head>
<body>
	<main>
		<h2>메뉴 목록(수정)</h2>
		<table>
			<tr>
				<td>MENU_ID</td>
				<td>MENU_NAME</td>
				<td>MENU_SEQ</td>
				<td>수정</td>
            	<td>삭제</td>
			</tr>
			<tr>
				<td colspan="5">
					[<a href="/Menus/WriteForm">메뉴 등록</a>]
				</td>
			</tr>
			<c:forEach var="menu" items="${menuList}">
				<tr>
					<td>${menu.menu_id}</td>
					<td>${menu.menu_name}</td>
					<td>${menu.menu_seq}</td>
					<td><a href="">수정</a></td>
					<td><a href="">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
	</main>
</body>
</html>