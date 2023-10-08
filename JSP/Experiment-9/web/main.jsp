<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bean.Book" %>
<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/5/6
  Time: 08:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function deleteBook(id){
            window.location = "handle.jsp?action=delete&id="+id;
        }
    </script>
</head>
<body>
<jsp:useBean id="bookDAO" class="com.dao.BookDAO"></jsp:useBean>

<%
    request.setCharacterEncoding("utf-8");
    String keyword = request.getParameter("keyword");
    request.setAttribute("keyword",keyword);
    ArrayList<Book> books = bookDAO.getByName(keyword);
    request.setAttribute("books",books);
%>

<%
    if(session.getAttribute("username")==null || session.getAttribute("username").equals("")){
        out.print("请先登录，等待5秒自动返回登录界面");
        response.setHeader("Refresh","5;URL=login.jsp");
    }else{

%>

<form action="main.jsp" method="post">
    <input type="text" name="keyword" size="40" value="${requestScope.keyword}" placeholder="请输入书名关键字">
    <input type="submit" value="搜索">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="addBook.jsp">添加图书</a>
</form>
<br>
<table border="1">
    <tr>
        <th> 序号 </th>
        <th> 书名 </th>
        <th> 作者 </th>
        <th> 出版社 </th>
        <th> 出版时间 </th>
        <th> 价格(元) </th>
        <th> ISBN号 </th>
        <th> 操作 </th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.bookname}</td>
            <td>${book.author}</td>
            <td>${book.press}</td>
            <td>${book.pubdate}</td>
            <td>${book.price}</td>
            <td>${book.isbn}</td>
            <td>
                <a href="handle.jsp?action=update&id=${book.id}">修改</a>
                <a href="javascript:void(0);" onclick="deleteBook(${book.id})">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%
}
%>
</body>
</html>
