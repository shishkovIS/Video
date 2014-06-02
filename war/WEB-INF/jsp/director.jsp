<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<div class="director">
  <ul>
   <li>
    <c:out value="${director.directorName}"/></li>
    <li><a href= "<c:url value="/editdirector?id=${director.id}"/>"> Редактировать </a></li>
    <li><a href= "<c:url value="/movies?directorid=${director.id}"/>"> Просмотреть фильмы режисера </a></li>
   </ul>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>