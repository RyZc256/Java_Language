<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/5/7
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" import="com.dao.*,com.bean.*" %>
<jsp:useBean id="bookDAO" class="com.dao.BookDAO"></jsp:useBean>
<jsp:useBean id="book" class="com.bean.Book"></jsp:useBean>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String action = request.getParameter("action");
    // 编辑图书操作
    if(action.equals("update")){
        int id = 0;
        if(request.getParameter("id") != null)
            id = Integer.parseInt(request.getParameter("id"));
        book = bookDAO.getById(id);
        request.setAttribute("book",book);
        request.getRequestDispatcher("editBook.jsp").forward(request,response);
    }else if(action.equals("delete")){
        String msg = "";
        boolean result = false;
        int id = 0;
        if(request.getParameter("id") != null)
            id = Integer.parseInt(request.getParameter("id"));
        result = bookDAO.delete(id);
        if (result == true)
            msg = "图书删除成功!";
        else
            msg = "图书删除失败!";
        session.setAttribute("msg",msg);
        response.sendRedirect("result.jsp");
    }else if(action.equals("edit")){
        Book b = new Book();
        String msg;
        b.setId(Integer.parseInt(request.getParameter("id")));
        b.setBookname(request.getParameter("bookname"));
        b.setAuthor(request.getParameter("author"));
        b.setPress(request.getParameter("press"));
        b.setPubdate(request.getParameter("pubdate"));
        b.setPrice(Float.parseFloat(request.getParameter("price")));
        b.setIsbn(request.getParameter("isbn"));
        boolean result = false;
        result = bookDAO.updateBook(b);
        if (result == true)
            msg = "图书编辑成功!";
        else
            msg = "图书编辑失败!";
        session.setAttribute("msg",msg);
        response.sendRedirect("result.jsp");
    }else if(action.equals("add")){
        Book b = new Book();
        String msg;
        b.setBookname(request.getParameter("bookname"));
        b.setAuthor(request.getParameter("author"));
        b.setPress(request.getParameter("press"));
        b.setPubdate(request.getParameter("pubdate"));
        b.setPrice(Float.parseFloat(request.getParameter("price")));
        b.setIsbn(request.getParameter("isbn"));
        boolean result = false;
        result = bookDAO.add(b);
        if (result == true)
            msg = "图书添加成功!";
        else
            msg = "图书添加失败!";
        session.setAttribute("msg",msg);
        response.sendRedirect("result.jsp");
    }
%>

</body>
</html>
