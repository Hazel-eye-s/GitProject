<%--
  Created by IntelliJ IDEA.
  User: yu
  Date: 2018/11/17
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thhh</title>
</head>
<body>
你好，主人！
<form action="/uploadMultity" method="post" enctype="multipart/form-data">

    <input type="file" name="file" value="121"><br>
    <input type="file" name="file" value="123"><br>
    <input type="submit" name="上传图片">
    <img src="${filename }"/>
</form>
</body>
</html>
