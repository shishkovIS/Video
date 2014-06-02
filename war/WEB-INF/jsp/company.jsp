<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<div class="company">
  <ul>
   <li>
    <c:out value="${company.companyName}"/></li>
    <li><a href= "<c:url value="/editcompany?id=${company.id}"/>"> Редактировать </a></li>
    <li><a href= "<c:url value="/movies?companyid=${company.id}"/>"> Просмотреть фильмы киностудии </a></li>
   </ul>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>