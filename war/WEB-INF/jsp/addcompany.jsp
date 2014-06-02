<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<form action="<c:url value="/savecommpany"/>" method="post">
  <input type=text name=companyName value="" size = 20>
  <input type=submit value = "Добавить">
    <input type="hidden" name="id" value="">
  <a href="<c:url value="/companies"/>">Отменить</a>
</form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>