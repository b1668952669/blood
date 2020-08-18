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
        background-color: greenyellow;
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
        <h1 style="color: red;">献血信息查询</h1>
        <a href="index.jsp">返回主页</a>
        <form action="BloodListServlet?method=getbloodlistbyname" method="post" onsubmit="return check()">
            <div class="a">
                献血人名称<input type="text" id="name" name="name"/>
            </div>
            <div class="a">
                <button type="submit" class="b" style="color:black;background-color:#66ccff">查   找</button>
            </div>
        </form>
    </div>
    <script type="text/javascript">
        function check() {
            var name = document.getElementById("name");;
             
            //非空
            if(name.value == '') {
                alert('献血人名称为空');
                name.focus();
                return false;
            }
        }
    </script>
</body>
</html>