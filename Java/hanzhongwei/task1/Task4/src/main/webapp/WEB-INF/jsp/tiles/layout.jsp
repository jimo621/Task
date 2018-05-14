<%--
  Created by IntelliJ IDEA.
  User: 指缝de阳光
  Date: 2018/5/13
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
</head>
<body>
<div id="header">
    <tiles:insertAttribute name="header" />
</div>
<div id="home">
    <tiles:insertAttribute name="body" />
</div>
<div id="footer">
    <tiles:insertAttribute name="footer" />
</div>
</body>
</html>
