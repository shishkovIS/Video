<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<form action="<c:url value="/savecopycount"/>" method="post">
 
 
 <c:forEach items="${copy}" var="cp">
   <input type=number name="a${cp.copyType.id}" value="">
   
</c:forEach>
 
 
  <input type=submit value = "Добавить">
    <input type="hidden" name="movieid" value="${movieid}">
  <a href="<c:url value="/companies"/>">Отменить</a>
</form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>