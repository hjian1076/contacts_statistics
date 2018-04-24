<%--
  Created by IntelliJ IDEA.
  User: hejx
  Date: 2017/5/19
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>${sessionScope.appName}-登录</title>
    <jsp:include page="/template/header.jsp" />
    <script>
        if (window != top){
            top.location.href = location.href;
        }
    </script>
</head>
<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <h3>欢迎登录${sessionScope.appName}</h3>
            <form class="m-t" role="form" id="login_form" method="post" action="/userlogin">
                <div class="form-group">
                    <input type="text" class="form-control" value="${username}" name="username" id="username" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" id="password" placeholder="密码" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b" href="JavaScript:void(0);">登 录</button>

                <p class="text-muted text-left">
                    <a href="/find_pwd">
                        <small>忘记密码了？</small>
                    </a>
                </p>
            </form>
        </div>
    </div>

    <!-- 导入尾部公共js -->
    <jsp:include page="/template/tail.jsp" />
    <!-- Sweet Alert -->
    <link href="<%=basePath%>static/css/sweetalert.css" rel="stylesheet">
    <script src="<%=basePath%>static/js/sweetalert.min.js"></script>
</body>
<script>

    $(function() {
        var errorMsg = '${errorMsg}';
        if(errorMsg!=null&&errorMsg!=""){
            sweetAlert("warn", errorMsg, "error");
        }
    });

</script>

</html>
