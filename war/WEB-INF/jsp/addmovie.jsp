<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<form action="<c:url value="/savemovie"/>" method="post">
  <input type=text name=title value="" size = 20>
  <input type=number name=year value="" size = 20>
  
  
  <select name="company">
     <c:forEach items="${companies}" var="companies">
         <option value="${companies.id}"><c:out value="${companies.companyName}"/></option>
     </c:forEach>
  </select>
  <select name="director">
     <c:forEach items="${directors}" var="directors">
         <option value="${directors.id}" ><c:out value="${directors.directorName}"/></option>
     </c:forEach>
  </select>
  

  <input type="hidden" name="id" value=""/>">
  <input type=submit value = "Сохранить">
  <a href="<c:url value="/movies"/>">Отменить</a>
</form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>