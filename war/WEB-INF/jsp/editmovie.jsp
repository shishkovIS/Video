<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<form action="<c:url value="/savemovie"/>" method="post">
  <input type=text name=title value="${movie.title}" size = 20>
  <input type=number name=year value="${movie.year}" size = 20>
  
  
  <select name="company">
     <c:forEach items="${companies}" var="companies">
         <option value="${companies.id}" <c:if test="${movie.company.id==companies.id}">selected</c:if>><c:out value="${companies.companyName}"/></option>
     </c:forEach>
  </select>
  <select name="director">
     <c:forEach items="${directors}" var="directors">
         <option value="${directors.id}" <c:if test="${movie.director.id==directors.id}">selected</c:if> ><c:out value="${directors.directorName}"/></option>
     </c:forEach>
  </select>
  

  <input type="hidden" name="id" value="<c:out value="${movie.id}"/>">
  <input type=submit value = "Сохранить">
  <a href="<c:url value="/movie?id=${movie.id}"/>">Отменить</a>
</form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>