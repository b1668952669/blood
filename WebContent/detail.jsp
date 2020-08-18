<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    }
    .tb, td {
        border: 1px solid black;
        font-size: 22px;
    }
</style>
</head>
<body>
    <div align="center">
        <h1 style="color: red;">献血信息</h1>
        <a href="index.jsp">返回主页</a>
        <table class="tb">
        	<tr>
                <td>序号</td>
                <td>${bloodlist.id}</td>
            </tr>
            <tr>
                <td>献血人名称</td>
                <td>${bloodlist.name}</td>
            </tr>
            <tr>
                <td>血型</td>
                <td>${bloodlist.type}</td>
            </tr>
            <tr>
                <td>献血量(/ml)</td>
                <td>${bloodlist.volume}</td>
            </tr>
            <tr>
                <td>献血日期</td>
                <td>${bloodlist.date}</td>
            </tr>
        </table>
        <div class="a">
            <a onclick="return check()" href="BloodListServlet?method=del&id=${bloodlist.id}">删   除</a>
        </div>
    </div>
    <script type="text/javascript">
        function check() {
            if (confirm("真的要删除吗？")){
                return true;
            }else{
                return false;
            }
        }
    </script>
</body>
</html>