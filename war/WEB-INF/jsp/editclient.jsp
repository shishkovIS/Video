<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<form action="<c:url value="/saveclient"/>" method="post">
  <input type=text name=name value="${client.name}" size = 20>
  <input type=text name=email value="${client.email}" size = 20>
  <input type=text name=adress value="${client.adress}" size = 20>
  <input type="hidden" name="id" value="<c:out value="${client.id}"/>">
  <input type=submit value = "Сохранить">
  <a href="<c:url value="/client?id=${client.id}"/>">Отменить</a>
</form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>