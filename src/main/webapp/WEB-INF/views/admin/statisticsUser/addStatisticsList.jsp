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
    String pid = (String) request.getAttribute("pid");
%>
<html>
<head>
    <title>填写联系方式</title>
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
            <form class="m-t" role="form" id="login_form" method="post" action="/addStatisticsUser">
                <div class="form-group">
                    <input type="text" class="form-control"  name="person" id="person" placeholder="联系人" required="">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control"  name="iphone" id="iphone" placeholder="联系人电话" required="">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control"  name="address" id="address" placeholder="联系人地址" required="">
                </div>
                 <div class="form-group">
                    <input type="hidden" class="form-control"  name="pid" id="pid"  value="<%=pid%>">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b"  href="JavaScript:void(0);">下一步</button>

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
