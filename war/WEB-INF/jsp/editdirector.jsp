<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<form action="<c:url value="/savedirector"/>" method="post">
  <input type=text name=directorName value="${director.directorName}" size = 20>
  <input type="hidden" name="id" value="<c:out value="${director.id}"/>">
  <input type=submit value = "Сохранить">
  <a href="<c:url value="/director?id=${director.id}"/>">Отменить</a>
</form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>