<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href="<c:url value="/addcompany"/>"> Добавить киностудию</a>
<div class="companies">
   <ul> 
     <c:forEach items="${companies}" var="cp">
         <li><a href="<c:url value="/company?id=${cp.id}"/>"><c:out value="${cp.companyName}"/></a></li>
     </c:forEach>
   </ul>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>