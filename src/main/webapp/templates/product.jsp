<%--
  Created by IntelliJ IDEA.
  User: Seph
  Date: 31-Mar-20
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1><%=request.getAttribute("productName")%>
</h1>
<div class="productInfo">
    id:  <%=request.getAttribute("productId")%> <br>
    price:  <%=request.getAttribute("productPrice")%>
</div>

