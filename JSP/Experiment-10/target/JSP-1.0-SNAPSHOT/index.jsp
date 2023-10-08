<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <title>输入ab的值</title>
</head>
<body>
<form action="Calc?op=sum" method="post" >
    第一个数:<input type="text" name="a"/><br/>
    第二个数：<input type="text" name="b"/><br/>
    <input type="submit" value="+"/>
    <input type="submit" value="-" formaction="Calc?op=sub"/>
    <input type="submit" value="*" formaction="Calc?op=mul"/>
    <input type="submit" value="/" formaction="Calc?op=div"/>
</form>
</body>
</html>
