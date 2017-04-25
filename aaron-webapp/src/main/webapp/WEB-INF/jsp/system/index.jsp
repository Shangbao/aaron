<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>后台系统主页</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="../include/base_css.jsp"%>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <!--left-->
        <%@include file="../include/left.jsp"%>
        <!-- top navigation -->
        <%@include file="../include/top.jsp"%>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            欢迎来到后台管理系统
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <%@include file="../include/footer.jsp"%>
        <!-- /footer content -->
    </div>
</div>
<%@include file="../include/base_js.jsp"%>
<script type="text/javascript">
    $(function(){
        initMenuStatus();
    });
</script>
</body>
</html>
