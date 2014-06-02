<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<form action="<c:url value="/saveclient"/>" method="post">
  <input type=text name=name value="" size = 20>
  <input type=text name=email value="" size = 20>
  <input type=text name=adress value="" size = 20>
  <input type=submit value = "Добавить">
    <input type="hidden" name="id" value="">
  <a href="<c:url value="/clients"/>">Отменить</a>
</form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>