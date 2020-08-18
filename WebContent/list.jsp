<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .a{
        margin-top: 20px;
    }
    .b{
        font-size: 20px;
        width: 160px;
        color: white;
        background-color: greenyellow;
    }
    .tb, td {
        border: 1px solid black;
        font-size: 22px;
    }
</style>
</head>
<body>
    <%
         Object message = request.getAttribute("message");
         if(message!=null && !"".equals(message)){
      
    %>
         <script type="text/javascript">
              alert("<%=request.getAttribute("message")%>");
         </script>
    <%} %>
    <div align="center">
        <h1 style="color: red;">献血信息列表</h1>
        <a href="index.jsp">返回主页</a>
        <table class="tb">
            <tr>
                <td>序号</td>
                <td>献血人名称</td>
                <td>血型</td>
                <td>献血量(/ml)</td>
                <td>献血日期</td>
                <td align="center" colspan="2">操作</td>
            </tr>
            <c:forEach items="${bloodlists}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.type}</td>
                    <td>${item.volume}</td>
                    <td>${item.date}</td>
                    <td><a href="BloodListServlet?method=getbloodlistbyid&id=${item.id}">修改</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>