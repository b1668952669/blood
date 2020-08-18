<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<style>
    .a{
        font-size: 26px;
        margin-top: 20px;
    }
</style>
</head>
<body>
    <div align="center">
        <h1 style="color: red;">血站信息管理系统</h1>
        <table border="1" cellspacing="0" cellpadding="10sp" width="300sp" height="50sp">
        <tr><th>
        <div class="a">
            <a href="add.jsp">献血信息录入</a>
        </div>
        </th></tr>
        <tr><th>
        <div class="a">
            <a href="BloodListServlet?method=list">献血信息查看</a>
        </div>
        </th></tr>
        <tr><th>
        <div class="a">
            <a href="search.jsp">献血信息查询</a>
        </div>
        </th></tr>
       
</body>
</html>