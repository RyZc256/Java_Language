<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>输入ab的值</title>
</head>
<body>
	<form action="sumab.jsp" method="post">
	第一个数：<input type="text" name="a"/><br/><br/>
	第二个数：<input type="text"  name="b"/><br/><br/>
	<input type="submit" value="+"/>
	<input type="submit" value="-" formaction="subab.jsp"/>
	<input type="submit" value="*" formaction="mulab.jsp"/>
	<input type="submit" value="/" formaction="divab.jsp"/>
	<input type="submit" value="%" formaction="modab.jsp"/>
	</form>
</body>
</html>
