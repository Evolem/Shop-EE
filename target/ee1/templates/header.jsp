<%--
  Created by IntelliJ IDEA.
  User: Seph
  Date: 31-Mar-20
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=application.getAttribute("title")%></title>
</head>
<body>
<header style="background-color: #51ccff;">
    <div class="logo" style="overflow: hidden;"><h3>HEADER</h3></div>
</header>

<div class="menu-bar">
    <%@include file= "menu.jsp"%>
</div>


