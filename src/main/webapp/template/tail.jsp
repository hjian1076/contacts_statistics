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

<script src="<%=basePath%>static/js/jquery.min.js?v=2.1.4"></script>
<script src="<%=basePath%>static/js/bootstrap.min.js?v=3.3.6"></script>
<%--<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>--%>
<script src="<%=basePath%>static/plugins/iCheck/icheck.min.js"></script>
<script src="<%=basePath%>static/plugins/angular/angular.min.js"></script>
<script src="<%=basePath%>static/plugins/angular/app.js"></script>
<script src="<%=basePath%>static/plugins/layer/layer.js"></script>
<script src="<%=basePath%>static/js/util.js?rand=<%=rand%>"></script>
