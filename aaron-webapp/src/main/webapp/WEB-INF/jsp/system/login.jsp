<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>管理员登录</title>
    <link rel="stylesheet" href="<c:url value="/api/vendors/bootstrap/dist/css/bootstrap.min.css"/>"/>
    <link href="<c:url value="/assets/system/home/css/signin.css"/> " rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/api/vendors/bootstrapvalidator/dist/css/bootstrapValidator.css" />"/>
</head>
<body>
<div class="container">
    <div class="signin">
        <div class="signin-head"><img src="<c:url value="/images/system/login_headImg.jpg"/>"  class="img-circle"></div>
        <form  class="form-signin" id="login-form" action="<c:url value="/sys/login"/>" method="post">
            <div class="form-group">
                <input type="text" class="form-control" name="username" placeholder="用户名"/>
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password" placeholder="密码"/>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-lg btn-warning btn-block" id="loginBtn">登录</button>
            </div>
            <div class="form-group">
                <label class="checkbox">
                    <input type="checkbox"  name="rememberMe" id="isRemembered" >记住我
                </label>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript" src="<c:url value="/api/vendors/jquery/dist/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/api/vendors/bootstrap/dist/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/api/vendors/bootstrapvalidator/dist/js/bootstrapValidator.js"/>"></script>
<script type="text/javascript">
    $(document).ready(function() {
        /*$('.form-signin').bootstrapValidator({
            message: 'This value is not valid',
            container: 'tooltip',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                username: {
                    message: '用户名不为空',
                    validators: {
                        notEmpty: {
                            message:'用户不能为空'
                        },
                        stringLength: {
                            min: 5,
                            max: 20,
                            message:'用户名长度为5-20'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_\.]+$/,
                            message: 'The username can only consist of alphabetical, number, dot and underscore'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        }
                    }
                }
            }
        });*/
        $('.form-signin').keypress(function(e) {
            if (e.which == 13) {
                login();
                return false;
            }
        });

        $("#loginBtn").bind('click',login);
        /*function login(){
            var bootstrapValidator = $(".form-signin").data('bootstrapValidator');
            bootstrapValidator.validate();
            if(bootstrapValidator.isValid()){
                alert($(".form-signin"));
                $("#login-form").submit();
            }else{
                return;
            }
        }*/
        function login() {
            $("#login-form").submit();
        }

        /*$("#loginBtn").bind('click',login);
        function login() {
            $("#login-form").submit();
        }*/
    });
</script>
</body>
</html>