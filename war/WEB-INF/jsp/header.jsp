<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<!doctype html>

<html>  
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="<c:url value="/css/style.css"/>" type="text/css">
	<title><c:out value="${title}"/> | Video</title>
	
</head>
  
<body>
 
			<ul class="navigation">
					<li <c:if test="${active == 'Movie'}">class="active"</c:if>><a href="<c:url value="/movies"/>">Фильмы</a></li>
					<li <c:if test="${active == 'Client'}">class="active"</c:if>><a href="<c:url value="/clients"/>">Клиенты</a></li>
					<li <c:if test="${active == 'OrderHistory'}">class="active"</c:if>><a href="<c:url value="/orderhistory"/>">История заказов</a></li>
					<li <c:if test="${active == 'Directors'}">class="active"</c:if>><a href="<c:url value="/directors"/>">Режисеры</a></li>
					<li <c:if test="${active == 'Companies'}">class="active"</c:if>><a href="<c:url value="/companies"/>">Кинокомпании</a></li>
					
					
					
				</ul>

	