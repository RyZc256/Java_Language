<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2022/5/19
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="sensor" id="abc" method="post">
        <input type="hidden" name="method" value="getData">
        <input type="hidden" name="S_ID" value=<%=request.getParameter("S_ID")%>>
    </form>
    <script>
        document.getElementById("abc").submit();
    </script>
</body>
</html>
