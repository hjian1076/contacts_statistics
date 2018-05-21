<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2018/5/21
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/template/header.jsp" />
    <link href="<%=basePath%>static/css/fileinput.min.css" rel="stylesheet">
</head>
<body>
    <input id="input-ficons-3" name="input-ficons-3[]"  type="file" class="file-loading">
    <jsp:include page="/template/tail.jsp" />
<script src="<%=basePath%>static/js/fileinput.min.js"></script>
<script>
    $("#input-ficons-3").fileinput({
        uploadUrl: "/file-upload-batch/2",
        previewFileIcon: '<i class="fa fa-file"></i>',
        allowedPreviewTypes: ['image', 'text']
    });
</script>
</body>
</html>
