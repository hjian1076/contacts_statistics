<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    double rand = Math.random();
%>
<html>
<head>
    <title>${sessionScope.appName}-个人主页</title>
    <jsp:include page="/template/header.jsp" />
</head>
<body class="gray-bg">

<div class="middle-box loginscreen  animated fadeInDown" style="text-align: center;">
    <div id="data">
        <h2 style="color:#222222;letter-spacing: 2px;font-weight: 400;">我的信息</h2>
        <div style="margin-top: 40px;">
            <p style="margin:0 0 6px;">
                <label style="color:#616161;letter-spacing: 1px;font-size: 16px;font-weight: normal;">姓名：</label>
                <a href="javascript:void(0)" style="color:#616161;letter-spacing: 2px;font-size: 16px">${user.username}</a>
            </p>
        </div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="myModalLabel" style="text-align: center;font-size: 18px">邀请码复制成功</h4>
            </div>

            <div class="modal-footer" style="text-align: center;">
                <button type="button" class="btn btn-primary"
                        data-dismiss="modal">关闭
                </button>
            </div>
        </div>
    </div>
</div>

<!-- 导入尾部公共js -->
<jsp:include page="/template/tail.jsp" />
<!-- Sweet Alert -->
<link href="<%=basePath%>static/css/sweetalert.css" rel="stylesheet">
    <script src="<%=basePath%>static/js/sweetalert.min.js"></script>
</body>

</html>
