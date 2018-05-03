<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/22
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    double rand = Math.random();
%>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="renderer" content="webkit">
<!-- UC强制全屏 -->
<meta name="full-screen" content="yes">
<!-- QQ强制全屏 -->
<meta name="x5-fullscreen" content="true">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!-- 网址图标 -->
<%--<link rel="shortcut icon" href="<%=basePath%>static/img/icon.png">--%>


<!--[if lt IE 9]>
<meta http-equiv="refresh" content="0;ie.html" />
<![endif]-->

<style>
    .scroll-wrapper{
        height:100%;-webkit-overflow-scrolling:touch;overflow:auto;
    }
    .clear{
        clear: both;
    }
</style>


<link href="<%=basePath%>static/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="<%=basePath%>static/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
<link href="<%=basePath%>static/css/animate.min.css" rel="stylesheet">
<link href="<%=basePath%>static/css/style.min862f.css?v=4.1.0" rel="stylesheet">
<link href="<%=basePath%>static/css/web.css?rand=<%=rand%>" rel="stylesheet">

<link rel="stylesheet" media="all and (orientation:portrait)" href="<%=basePath%>static/css/web.css?rand=<%=rand%>">
<link rel="stylesheet" media="all and (orientation:landscape)" href="<%=basePath%>static/css/web.css?rand=<%=rand%>">

