<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<h2 align="center">登 录</h2>
<form name="form1" action="login_validate.jsp" method="post">
<table align="center">
<tbody ><tr>
<td>用户名：</td>
<td><input type="text" name="username1" value="${param.username1}"></td>
</tr>
<tr>
<td>密码：</td>
<td><input type="password" name="password1"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="登陆">
<input type="reset" value="取消"></td>
</tr>
</tbody></table>
</form>