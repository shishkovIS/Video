<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<form action="<c:url value="/saveclosedorder"/>" method="post">
<table>
   <tr>
     <td>
          Название фильма
      </td>
     <td>
       <c:out value="${orderHistory.movie.title}"/>
     </td>
   </tr>
   <tr>
     <td>
          Клиент
      </td>
     <td>
       <c:out value="${orderHistory.client.name}"/>
     </td>
   </tr>
   <tr>
     <td>
          Дата выдачи копии
      </td>
     <td>
       <c:out value="${orderHistory.orderTime}"/>
     </td>
   </tr>
   <tr>
     <td>
          Дата приема копии
      </td>
     <td>
      <input type="date" name="returnTime">
     </td>
   </tr>
  <tr>
     <td>
          Тип копии
      </td>
     <td>
        <c:out value="${orderHistory.copy.copyType.typeName}"/>
     </td>
   </tr>
   <tr>
     <td>
          Сумма
      </td>
     <td>
        <input type=number name="rentCost" value="">
     </td>
   </tr>
  <tr>
     <td>
        <input type=submit value = "Подтвердить">
      </td>
     <td>
       <a href="<c:url value="/orderhistory"/>">Отменить</a>
     </td>
   </tr>
  </table>
  <input type=hidden value="${orderHistory.id}" name="orderhistoryid">
</form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>