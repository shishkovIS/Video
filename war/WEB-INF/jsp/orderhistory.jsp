<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<a href="<c:url value="/orderhistory"/>"> Все заказы</a>
<a href="<c:url value="/orderhistory?opened=1"/>"> Открытые</a>
<a href="<c:url value="/orderhistory?opened=0"/>"> Закрытые</a>
<a href="<c:url value="/createorder"/>"> Оформить заказ </a>
<div class="orderhistory">
   <table>
      
     <c:forEach items="${orderitems}" var="oh">
        <tr>
          <td>  
             <c:out value="${oh.movie.title}"/>
          </td>
          <td>
           <c:out value="${oh.client.name}"/> 
          </td>
          <td>
             <c:out value="${oh.orderTime}"/>
          </td>
          <td>
              <c:out value="${oh.returnTime}"/>
          </td>
          
          <td>
          <c:if test="${oh.returnTime==null}">
             <a href="<c:url value="/closeorder?orderhistoryid=${oh.id}"/>"> Оформить возврат </a>             
          </c:if>
          <c:if test="${oh.returnTime!=null}">
             <c:out value="${oh.payout}"/>       
          </c:if>
          </td>
          
        </tr>
     </c:forEach>
   </table>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>