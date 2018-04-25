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
    Integer pid = (Integer)request.getAttribute("pid");
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

    <div ng-app="myApp" ng-controller="addController"  class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <form class="m-t">
                <div class="form-group">
                    <input type="text" class="form-control"  ng-model="param.person"  placeholder="联系人">
                </div>
                 <div class="form-group">
                    <input type="text" maxlength="11" class="form-control"  ng-model="param.iphone"  placeholder="联系人电话">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control"  ng-model="param.address"  placeholder="联系人地址">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b" ng-click="save()" >下一步</button>

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
    app.controller('addController', function($scope,$http) {

        $scope.param = {
            person:'',
            iphone:'',
            address:'',
            pid:${pid}
        };

        //保存
        $scope.save = function(){

           if(isNull($scope.param.person)){
                layer.msg("请输入联系人名字");
               return false;
           }
            if(!validatemobile($scope.param.iphone)){
                layer.msg(common.ERR_MSG.PHONE_ERROR_MSG);
                return false;
            }
           if(isNull($scope.param.address)){
                layer.msg("请输入联系人地址");
               return false;
           }
            //提交数据
            $http({method : 'POST', data:$scope.param, url : "/addStaUser"})
                .success(function(data,status,headers,config){
                    console.log(data);
                    if(data.code==0){
                       window.parent.location.href = data.data;
                    }else{
                         layer.msg(data.msg);
                    }
                }).error(function(data,status,headers,config){
                $('#subBtn')[0].disabled = false;
                console.log('error..........');
                console.log(data);
            });
        }


    });
</script>

</html>
