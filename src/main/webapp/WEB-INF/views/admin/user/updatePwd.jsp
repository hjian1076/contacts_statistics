<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/23
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <!--头部-->
    <jsp:include page="/template/header.jsp" />
    <!--头部结束-->
</head>
<body class="gray-bg">
<div ng-app="myApp" ng-controller="updatePwdController" class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <form method="get" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-10">
                                <input type="text" value="${user.username}" maxlength="11" readonly class="form-control">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">旧密码</label>

                            <div class="col-sm-10">
                                <input  ng-model="param.password" type="password" class="form-control">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">新密码</label>

                            <div class="col-sm-10">
                                <input  ng-model="param.new_password" type="password" class="form-control">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">确认新密码</label>

                            <div class="col-sm-10">
                                <input  ng-model="param.new_password2" type="password" class="form-control">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" ng-click="save()" id="subBtn" type="button">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 导入尾部公共js -->
<jsp:include page="/template/tail.jsp" />

<script>
//    $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});

    app.controller('updatePwdController', function($scope,$http) {

        $scope.param = {
            password:'',
            new_password:'',
            new_password2:''
        };

        //保存
        $scope.save = function(){

            if(isNull($scope.param.password)){
                layer.msg("请输入旧密码");
                return false;
            }
            if(isNull($scope.param.new_password)){
                layer.msg("请输入新密码");
                return false;
            }
            if($scope.param.new_password!=$scope.param.new_password2){
                layer.msg("两次输入的新密码不相同,请重新输入");
                return false;
            }

            $('#subBtn')[0].disabled = true;

            //提交数据
            $http({method : 'POST', data:$scope.param, url : "/admin/user/updatePassword"})
                .success(function(data,status,headers,config){
                    //console.log(data);
                    $('#subBtn')[0].disabled = false;
                    layer.msg(data.msg);
                    if(data.code==0){
                        alert(data.msg);
                        window.parent.location.href = "/loginOut";
                    }
                }).error(function(data,status,headers,config){
                $('#subBtn')[0].disabled = false;
                console.log('error..........');
                console.log(data);
            });
        }


    });

</script>

</body>
</html>
