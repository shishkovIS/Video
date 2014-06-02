<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href="<c:url value="/addmovie"/>"> Добавить фильм</a>


<form action="<c:url value="/movies"/>" method="post">
  <input type=text name="name" value="" size=20>
  <input type=number value="" name="year" size =20>
  <input type=submit name="submit" value="Поиск по критериям">
</form>
<ul>
<c:forEach items="${movies}" var="mv">
   <li>

     <a href="<c:url value="/movie?id=${mv.id}"/>"><c:out value="${mv.title}"/></a>
   </li>
</c:forEach>
</ul>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>