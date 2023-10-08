<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>计算ab的和</title>
  </head>
  
  <body>
   <jsp:useBean id="compute" class="bean.Compute" scope="session"></jsp:useBean>
  <%
  int value1=Integer.parseInt(request.getParameter("a"));
  int value2=Integer.parseInt(request.getParameter("b"));
  int sum=compute.sumab(value1, value2);
  out.println(value1+"+"+value2+"="+sum);
   %>
  </body>
</html>
