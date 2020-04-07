<%--
  Created by IntelliJ IDEA.
  User: Seph
  Date: 31-Mar-20
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<h1>Каталог</h1>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
    </tr>
    </thead>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td><a href="product/${product.id}">${product.name}</a> </td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>

</table>