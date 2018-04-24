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
    double rand = Math.random();
%>
<html>
<head>
    <!--头部-->
    <title>联系人信息统计</title>

    <link rel="stylesheet" href="<%=basePath%>static/css/plugins/bootstrap-table/bootstrap-table.min.css">
    <link rel="stylesheet" href="<%=basePath%>static/plugins/daterangepicker/css/daterangepicker.css" />
    <jsp:include page="/template/header.jsp" />
    <!--头部结束-->
</head>
<body class="gray-bg">
    <div class="container" style="width: 100%">
        <div id="toolbar" style="margin:10px auto;">
            <div class="form-inline" role="form" style=" width: 100%">
                <%--<div class="form-group" style="float: left;margin-left: 5px;">--%>
                    <%--<button type="button" onclick="openAddWin()" class="btn btn-primary">--%>
                        <%--  <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增--%>
                    <%--</button>--%>
                    <%--<button type="button" onclick="openUpdateWin()" class="btn btn-primary">--%>
                        <%--  <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 修改--%>
                    <%--</button>--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<select id="roleId" class="form-control" name="roleId">--%>
                        <%--<option value="-1">请选择职位</option>--%>
                        <%--<c:forEach var="role" items="${roles}">--%>
                            <%--<option value="${role.pkId}">${role.roleName}</option>--%>
                        <%--</c:forEach>--%>
                    <%--</select>--%>
                <%--</div>--%>
                    <div class="form-group">
                        <label for="dateTimeRange">日期:</label>
                        <div class="input-group" style="width: 370px;">
                            <input class="form-control date-picker" name="dateTimeRange" readonly id="dateTimeRange" value="" type="text">
                            <span class="input-group-addon">
                            <i class="fa fa-calendar bigger-110"></i>
                        </span>
                            <input name="beginTime" id="beginTime" value="" type="hidden">
                            <input name="endTime" id="endTime" value="" type="hidden">
                        </div>
                    </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="keyword" id="keyword"  placeholder="输入姓名模糊查询">
                </div>
                <div class="form-group">
                    <button type="button" id="queryBtn" onclick="doQuery();" class="btn btn-primary">查询</button>
                    <button type="button" id="cleanBtn" onclick="doClean();" class="btn btn-primary">清除</button>
                </div>
            </div>
        </div>
        <div id="tableDiv" style="overflow-y:auto;overflow-x:auto;">
            <table id="demo-table" >
            </table>
        </div>
    </div>

    <jsp:include page="/template/list_tail.jsp" />
    <script src="<%=basePath%>static/js/statisticsUser/statisticsUser.js?rand=<%=rand%>"></script>
    <script src="<%=basePath%>static/plugins/daterangepicker/js/common.js"></script>
    <script src="<%=basePath%>static/plugins/daterangepicker/js/date-time/moment.js?ver=1" type="text/javascript"></script>
    <script src="<%=basePath%>static/plugins/daterangepicker/js/date-time/daterangepicker.zh-CN.js?ver=1" type="text/javascript"></script>
    <script src="<%=basePath%>static/plugins/daterangepicker/js/date-time/daterangepicker.js?ver=1" type="text/javascript"></script>
    <script src="<%=basePath%>static/plugins/angular/angular.min.js"></script>
    <script src="<%=basePath%>static/plugins/angular/app.js"></script>
</body>

    <script>
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

//        function openAddWin(){
//            openInputWin('/admin/user/openInputPageForAdd','新增用户');
//        }

        //打开修改数据窗口
//        function openUpdateWin(){
//            var row = $.map($("#demo-table").bootstrapTable('getSelections'),function(row){
//                return row.pkId ;
//            });//只得到其中的ID
//            if(row.length==0){
//                layer.msg("请选择需要修改的数据");
//                return false;
//            }
//            if(row.length>1){
//                layer.msg("只能选中一条数据进行修改");
//                return false;
//            }
//            openInputWin('/admin/user/openInputPageForUpdate?id='+row[0],'修改用户');
//        }
//
//        //禁用/启用 用户
//        function disableUser(enabled){
//            var ids = $.map($("#demo-table").bootstrapTable('getSelections'),function(row){
//                return row.pkId ;
//            });//只得到其中的ID
//            if(ids.length==0){
//                layer.msg("请选择需要操作的数据");
//                return false;
//            }
//
//            $.ajax({
//                url:'/admin/user/doDisable',
//                type:'POST', //GET
//                async:false,    //或false,是否异步
//                data:{
//                    ids:ids,
//                    enabled:enabled
//                },
//                timeout:5000,    //超时时间
//                dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
//                success:function(data,textStatus,jqXHR){
//                    console.log(data);
//                    layer.msg(data.msg);
//                    if(data.code==0){
//                        $('#demo-table').bootstrapTable('refresh');    //刷新表格
//                    }
//                },
//                error:function(xhr,textStatus){
//                    console.log('错误')
//                    console.log(xhr)
//                    console.log(textStatus)
//                }
//            })
//
//        }


    </script>

</html>
