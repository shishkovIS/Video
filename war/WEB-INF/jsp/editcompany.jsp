<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<form action="<c:url value="/savecompany"/>" method="post">
  <input type=text name=companyName value="${company.companyName}" size = 20>
  <input type="hidden" name="id" value="<c:out value="${company.id}"/>">
  <input type=submit value = "Сохранить">
  <a href="<c:url value="/company?id=${company.id}"/>">Отменить</a>
</form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>