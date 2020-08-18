<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<body>
    ${msg}
	<form action="${pageContext.request.contextPath }/login"
method="POST">
		用户名或密码错误，请重新登陆<br/>
		用户名：<input type="text" name="username"/><br/>
		密&nbsp;&nbsp;&nbsp;码：
<input type="password"name="password"/><br/>
		<input type="submit"value="退出"/>
	</form>
</body>
</form>