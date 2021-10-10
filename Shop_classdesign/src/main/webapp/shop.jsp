<%--
  Created by IntelliJ IDEA.
  User: yang97
  Date: 2020/6/17
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"   isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
    %>
    <title>Title</title>
    <script src="<%=basePath %>js/jquery.min.js"></script>

    <script>

        $(function () {
            $("#advice").click(function () {
                var datas={"part1":$("#part1 option:selected").text(),"number1":$("#number1").val(),"supplier1":$("#supplier1 option:selected").text(),
                    "part2":$("#part2 option:selected").text(),"number2":$("#number2").val(),"supplier2":$("#supplier2 option:selected").text(),
                    "part3":$("#part3 option:selected").text(),"number3":$("#number3").val(),"supplier3":$("#supplier3 option:selected").text()}
                $.ajax({
                    url:"adviceOrder",
                    contentType:"application/json;charset=UTF-8",
                    data:JSON.stringify(datas),
                    dataType:"text",
                    type:"post",
                    async: false,
                    success:function (data) {
                        alert(data.toString());
                    }
                })

            })
        })
    </script>
</head>
<body>
    <h1 align="center">电脑零件商铺</h1>
    <h3 align="center" >欢迎${username}！</h3>
    <form action="findPartsAll" method="post">
        <input type="text" name="username" value="${username}" style="display:none">
        <input type="submit" value="查看零件信息" align="center">
    </form>

<%--    readonly="true" size="5" style= "background-color:transparent;border:0;"--%>
<%--    <input type="text" name="username" value="${username}"  >--%>
    <table border="1" width="100%" align="center">
        <tr>
            <th>供应商名称</th>
            <th>零件名称</th>
            <th>价格</th>
            <th>库存数量</th>
        </tr>
        <c:forEach items="${list}" var="parts">
            <tr align="center">
                <td>${parts.suppliers}</td>
                <td>${parts.part}</td>
                <td>${parts.price}</td>
                <td>${parts.number}</td>
            </tr>
        </c:forEach>
    </table>
<br>
<br>
<br>
<form action="saveOrders" method="post">
    <table border="1" width="100%" align="center">
            <input type="text" name="username" value="${username}" style="display:none">
        <tr>
            <th>选择你想要下单的零件名称：</th>
            <th>输入你想要下单的零件数量：</th>
            <th>选择你想要下单的零件供应商：</th>
        </tr>
        <tr>
            <td align="center">
                <select name="part1" id="part1">
                    <option>cpu</option>
                    <option>显卡</option>
                    <option>硬盘</option>
                    <option>显示器</option>
                </select>
            </td>
            <td align="center">
                <input type="text" name="number1" id="number1">
            </td>
            <td align="center">
                <select  name="supplier1" id="supplier1">
                    <option>甲</option>
                    <option>乙</option>
                    <option>丙</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="center">
                <select name="part2" id="part2">
                    <option>cpu</option>
                    <option>显卡</option>
                    <option>硬盘</option>
                    <option>显示器</option>
                </select>
            </td>
            <td align="center">
                <input type="text" name="number2" id="number2">
            </td>
            <td align="center">
                <select  name="supplier2" id="supplier2">
                    <option>甲</option>
                    <option>乙</option>
                    <option>丙</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="center">
                <select name="part3" id="part3" style="width:100px;">
                    <option>cpu</option>
                    <option>显卡</option>
                    <option>硬盘</option>
                    <option>显示器</option>
                </select>
            </td>
            <td align="center">
                <input type="text" name="number3" id="number3" size="20">
            </td>
            <td align="center">
                <select  name="supplier3" id="supplier3" style="width:100px;">
                    <option>甲</option>
                    <option>乙</option>
                    <option>丙</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="center">
                <input type="button" id="advice" value="推荐订单" >
            </td>
            <td>

            </td>
            <td align="center">
                <input type="submit" value="下单">
            </td>
        </tr>
    </table>
</form>


</body>
</html>
