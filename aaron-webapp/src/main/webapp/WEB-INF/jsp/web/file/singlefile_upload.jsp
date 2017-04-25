<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/20
  Time: 7:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传单个文件示例</title>
</head>
<body>
<div align="center">
    ${error}
    <h1>上传附件</h1>
    <form method="post" action="<%=basePath%>/file/singleUpload.do" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <button type="submit" >提交</button>
    </form>
</div>
</body>
</html>
