<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href="<c:url value="/addclient"/>"> Добавить клиента</a>
<div class="clients">
   <ul> 
     <c:forEach items="${allclients}" var="cl">
         <li><a href="<c:url value="/client?id=${cl.id}"/>"><c:out value="${cl.name}"/></a></li>
     </c:forEach>
   </ul>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>