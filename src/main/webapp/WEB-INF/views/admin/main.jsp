<%--
  Created by IntelliJ IDEA.
  User: hejx
  Date: 2017/5/19
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>${sessionScope.appName}</title>
    <!--头部-->
    <jsp:include page="/template/header.jsp" />
    <!--头部结束-->
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div onclick="location.reload()" class="dropdown profile-element">
                        <%--<span><img alt="image" class="img-circle" src="<%=basePath%>static/img/profile_small.jpg"></span>--%>
                        <a data-toggle="dropdown" class="dropdown-toggle">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">欢迎您:${sessionScope.user.username}</strong></span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">Z+
                    </div>
                </li>
                <c:forEach var="res" items="${user.resList}">
                    <%--<c:if test="${res.resType==0}">--%>
                        <%--<!-- 功能菜单 -->--%>
                        <%--<li>--%>
                            <%--<a href="#">--%>
                                <%--<span class="nav-label">${res.resName}</span>--%>
                                <%--<span class="fa arrow"></span>--%>
                            <%--</a>--%>
                            <%--<ul class="nav nav-second-level">--%>
                                <%--<c:forEach var="res2" items="${res.childList}">--%>
                                    <%--<c:if test="${res2.resType==0}">--%>
                                        <%--<li>--%>
                                            <%--<a href="#">${res2.resName} <span class="fa arrow"></span></a>--%>
                                        <%--</li>--%>
                                    <%--</c:if>--%>
                                    <%--<c:if test="${res2.resType==1}">--%>
                                        <%--<!-- 功能点 -->--%>
                                        <%--<li>--%>
                                            <%--<a class="J_menuItem" href="${res2.resUrl}">${res2.resName}</a>--%>
                                        <%--</li>--%>
                                    <%--</c:if>--%>
                                <%--</c:forEach>--%>

                            <%--</ul>--%>
                        <%--</li>--%>
                    <%--</c:if>--%>
                    <c:if test="${res.resType==1}">
                        <!-- 功能点 -->
                        <li>
                            <a class="J_menuItem" href="${res.resUrl}"><i class="fa fa-leaf"></i> <span
                                    class="nav-label">${res.resName}</span></a>
                        </li>
                    </c:if>
                </c:forEach>
                <li>
                    <a class="J_menuItem" href="/loginOut">
                        <i class="fa fa-sign-out"></i>
                        <span class="nav-label">退出</span>
                    </a>
                </li>

            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#">
                        <i class="fa fa-bars"></i>
                    </a>

                    <a onclick="refresh();" class="minimalize-styl-2 btn btn-primary " href="#">
                        <i class="fa fa-refresh"></i>
                    </a>
                </div>
            </nav>
        </div>
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="${welcomePage}">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="/loginOut" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${welcomePage}" frameborder="0" data-id="${welcomePage}" seamless></iframe>
        </div>
    </div>
</div>
    <!--右侧部分结束-->
    <!--右侧边栏开始-->
    <!--右侧边栏结束-->
    <script src="<%=basePath%>static/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=basePath%>static/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=basePath%>static/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="<%=basePath%>static/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="<%=basePath%>static/js/layer/layer.min.js"></script>
    <script src="<%=basePath%>static/js/hplus.min.js?v=4.1.0"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/contabs.min.js"></script>
    <script src="<%=basePath%>static/plugins/pace/pace.min.js"></script>

    <!-- Sweet Alert -->
    <link href="<%=basePath%>static/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <script src="<%=basePath%>static/js/plugins/sweetalert/sweetalert.min.js"></script>


</body>

<script>
    //刷新子页面
    function refresh(){
        var iframe = $("iframe:visible")[0];
        iframe.src = iframe.src;
    }
</script>

</html>

