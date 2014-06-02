<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<div class="movie">
  <ul>
   <li>
   <c:out value="${movie.title}"/></li>
    <li><c:out value="${movie.year}"/></li>
   <li><c:out value="${movie.director.directorName}"/></li>
   <li><c:out value="${movie.company.companyName}"/></li>
   <c:forEach items="${copies}" var="cp">
       <li> Общее количество <c:out value="${cp.copyType.typeName}"/> - <c:out value="${cp.count}"/> </li>
       <li> Доступное количество <c:out value="${cp.copyType.typeName}"/> - <c:out value="${cp.countAvailable}"/> </li>
    </c:forEach>
    <li><a href= "<c:url value="/editcopycount?movieid=${movie.id}"/>"> Добавить копии </a></li>
    
    <li><a href= "<c:url value="/editmovie?id=${movie.id}"/>"> Редактировать </a></li>
   <li><a href= "<c:url value="/orderhistory?movieid=${movie.id}&moveid=&opened="/>"> Показать историю проката </a></li>
   <li><a href= "<c:url value="/orderhistory?movieid=${movie.id}&opened=1"/>"> Показать открытые заказы </a></li>
   <li><a href= "<c:url value="/deletemovie?id=${movie.id}"/>">Удалить фильм </a></li>
   </ul>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>