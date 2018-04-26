<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/22
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String websiteBasePath =  request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
    double rand = Math.random();
%>
<html>
<head>
    <!--头部-->
    <title>品牌信息</title>

    <link rel="stylesheet" href="<%=basePath%>static/css/plugins/bootstrap-table/bootstrap-table.min.css">
    <link rel="stylesheet" href="<%=basePath%>static/js/plugins/daterangepicker/css/daterangepicker.css" />
    <jsp:include page="/template/header.jsp" />
    <!--头部结束-->
</head>
<body class="gray-bg">
    <div class="container" style="width: 100%">
        <div id="toolbar" style="margin:10px auto;">
            <div class="form-inline" role="form" style=" width: 100%">
                <div class="form-group" style="float: left;margin-left: 5px;">
                    <button type="button" onclick="openAddWin()" class="btn btn-primary">
                          <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增
                    </button>
                  <button type="button" onclick="openUpdateWin()"  class="btn btn-primary">
                        <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 修改
                    </button>
                </div>
            </div>
        </div>
        <div class="clear" style="height: 10px;"></div>
        <div id="tableDiv" style="overflow-y:auto;overflow-x:auto;">
            <table id="demo-table" >
            </table>
        </div>
    </div>

    <jsp:include page="/template/list_tail.jsp" />
    <script src="<%=basePath%>static/js/jquery/qrcode/qrcode.js"></script>
    <script src="<%=basePath%>static/js/platform/platform.js?rand=<%=rand%>"></script>
    <script src="<%=basePath%>static/js/plugins/daterangepicker/js/common.js"></script>
    <script src="<%=basePath%>static/js/plugins/daterangepicker/js/date-time/moment.js?ver=1" type="text/javascript"></script>
    <script src="<%=basePath%>static/js/plugins/daterangepicker/js/date-time/daterangepicker.zh-CN.js?ver=1" type="text/javascript"></script>
    <script src="<%=basePath%>static/js/plugins/daterangepicker/js/date-time/daterangepicker.js?ver=1" type="text/javascript"></script>
    <script src="<%=basePath%>static/js/plugins/angular/angular.min.js"></script>
    <script src="<%=basePath%>static/js/plugins/angular/app.js"></script>
</body>

    <script>
        var path = "<%=websiteBasePath%>";
        $(function () {
            common.initDateTimeRange();
        })
        //关闭iframe窗口
        function closeWin(){
            layer.closeAll('iframe'); //关闭所有的iframe层
        }

        //关闭iframe窗口刷新列表
        function closeWinAndFlush(){
            closeWin();
            $('#demo-table').bootstrapTable('refresh');    //刷新表格
        }

        function openAddWin(){
            openInputWin('/admin/platform/addList','添加平台');
        }

         function openUpdateWin(){
            var row = $.map($("#demo-table").bootstrapTable('getSelections'),function(row){
                return row.id ;
            });//只得到其中的ID
            if(row.length==0){
                layer.msg("请选择需要修改的数据");
                return false;
            }
            if(row.length>1){
                layer.msg("只能选中一条数据进行修改");
                return false;
            }
            openInputWin('/admin/platform/updatePage?id='+row[0],'修改用户');
        }



    </script>

</html>
