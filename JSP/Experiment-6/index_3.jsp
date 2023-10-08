<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/4/8
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:set var="score" scope="request" value="${param.score}"></c:set>
    <c:out value="成绩${score}："></c:out>
    <c:choose>
        <c:when test="${param.score >= 90}"> <a>优秀</a> </c:when>
        <c:when test="${param.score > 90}"> <a>良好</a> </c:when>
        <c:when test="${param.score > 80}"> <a>中等</a> </c:when>
        <c:when test="${param.score > 70}"> <a>及格</a> </c:when>
        <c:otherwise> <a>不及格</a> </c:otherwise>
    </c:choose>

</body>
</html>
