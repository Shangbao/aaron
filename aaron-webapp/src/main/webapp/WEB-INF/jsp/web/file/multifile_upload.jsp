<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/20
  Time: 7:29
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传单个文件示例</title>

</head>
<body>
<div align="center">
    <h1>上传多个附件</h1>
    <form method="post" action="<%=basePath%>/file/multiUpload.do" enctype="multipart/form-data">
        <input type="file" name="file1"/>
        <br/>
        <input type="file" name="file2"/>
        <button type="submit" >提交</button>
    </form>

</div>
</body>
</html>
