<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href="<c:url value="/adddirector"/>"> Добавить режисера</a>
<div class="directors">
   <ul> 
     <c:forEach items="${directors}" var="dr">
         <li><a href="<c:url value="/director?id=${dr.id}"/>"><c:out value="${dr.directorName}"/></a></li>
     </c:forEach>
   </ul>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>