<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<div class="client">
  <ul>
   <li>
   <c:out value="${client.name}"/></li>
   <li><c:out value="${client.email}"/></li>
   <li><c:out value="${client.adress}"/></li>
   <li><a href= "<c:url value="/editclient?id=${client.id}"/>"> Редактировать </a></li>
   <li><a href= "<c:url value="/orderhistory?clientid=${client.id}&moveid=&opened="/>"> Показать историю проката </a></li>
   <li><a href= "<c:url value="/orderhistory?clientid=${client.id}&opened=1"/>"> Показать открытые заказы </a></li>
   <li><a href= "<c:url value="/deleteclient?id=${client.id}"/>">Удалить клиента </a></li>
  
   </ul>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>