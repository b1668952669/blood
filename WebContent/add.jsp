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
        <h1 style="color: red;">献血信息录入</h1>
        <a href="index.jsp">返回主页</a>
        <form action="BloodListServlet?method=add" method="post" onsubmit="return check()">
            <div class="a">
                献血人<input type="text" id="name" name="name"/>
            </div>
            <div class="a">
                血型<input type="radio" name="type" id="typeA" value="A">A
			 <input type="radio" name="type" id="typeB" value="B">B
			 <input type="radio" name="type" id="typeO" value="O">O
			 <input type="radio" name="type" id="typeAB" value="AB">AB
			</div>
            <div class="a">
            献血量<input type="radio" name="volume" id="200" value="200">200ml
			 <input type="radio" name="volume" id="400" value="400">400ml
            <div class="a">
                日期<input type="date" id="date" name="date" />
            </div>
            <div class="a">
                <button type="submit" class="b" style="color:black;background-color:#66ccff "  >保   存</button>
            </div>
        </form>
    </div>
    <script type="text/javascript">
        function check() {
            var name = document.getElementById("name");;
            var type = document.getElementById("type");
            var date = document.getElementById("date");
             
            //非空
            if(name.value == '') {
                alert('献血人名称为空');
                name.focus();
                return false;
            }
            if(type.value == '') {
                alert('血型为空');
                type.focus();
                return false;
            }
            if(date.value == '') {
                alert('日期为空');
                date.focus();
                return false;
            }
             
            //
            if(type.value != 'A' && type.value != 'B' && type.value != 'O' && type.value != 'AB' ){
                alert('血型错误');
                return false;
            }
             
            //
            
        }
    </script>
</body>
</html>