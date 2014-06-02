<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<form action="<c:url value="/saveorder"/>" method="post">
 <select name="movieid">
     <c:forEach items="${movies}" var="movies">
         <option value="${movies.id}"><c:out value="${movies.title}"/></option>
     </c:forEach>
  </select>
  <select name="clientid">
     <c:forEach items="${clients}" var="clients">
         <option value="${clients.id}" ><c:out value="${clients.name}"/></option>
     </c:forEach>
  </select>
  <select name="copyTypeid">
     <c:forEach items="${copyTypes}" var="copyTypes">
         <option value="${copyTypes.id}" ><c:out value="${copyTypes.typeName}"/></option>
     </c:forEach>
  </select>
  <input type="date" name="orderTime">
  <input type=submit value = "Добавить">
  <a href="<c:url value="/orderhistory"/>">Отменить</a>
</form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>