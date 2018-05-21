<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>添加品牌</title>
    <!--头部-->
    <jsp:include page="/template/header.jsp" />
    <link href="<%=basePath%>static/css/fileinput.min.css" rel="stylesheet">

    <!--头部结束-->
</head>
<body class="gray-bg">
<div ng-app="myApp" ng-controller="addPlatformController" class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <form method="post" class="form-horizontal" enctype="multipart/form-data">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">品牌名称<span style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input  ng-model="platform.platformName" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">品牌地址<span style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input  ng-model="platform.website"  type="text" class="form-control">
                            </div>
                        </div>

                       <div class="form-group">
                            <label class="col-sm-2 control-label">图片上传<span style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input id="itemImagers" name="itemImagers"  type="file" >
                            </div>
                        </div>


                        <div class="hr-line-dashed"></div>


                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" ng-click="save()" id="subBtn" type="button">保存</button>
                                <button class="btn btn-white" onclick="parent.closeWin()" type="button">取消</button>
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
<script src="<%=basePath%>static/js/fileinput.min.js"></script>
<script src="<%=basePath%>static/js/locales/zh.js"></script>
<script>
    $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
     function initFileInput(ctrlName, uploadUrl) {
        var control = $('#' + ctrlName);
        control.fileinput({
            language: 'zh', //设置语言
            uploadUrl: uploadUrl, //上传的地址
            allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀
            dropZoneEnabled:false
            //uploadAsync: false, //插件支持同步和异步
            //showUpload: false, //是否显示上传按钮
        }).on("fileuploaded", function(event, data) {
            //上传图片后的回调函数，可以在这做一些处理
            console.log(data);
        });
    }


$(function(){
    //指定上传controller访问地址
    var path = 'http://localhost:8080/admin/platform/uploadFile';
    //页面初始化加载initFileInput()方法传入ID名和上传地址
    initFileInput("itemImagers",path);
})
    app.controller('addPlatformController', function($scope,$http) {

        $scope.platform,
        $scope.url
       if('${update}'=='6'){
            // 修改用户
            $scope.platform = angular.fromJson('${platform}');
            $scope.url = "/admin/platform/update";
        }else{
            $scope.platform = {
                platformName:'',
                website:'',
            };
            $scope.url = "/admin/platform/add";
        }

        //保存
        $scope.save = function(){

            if(isNull($scope.platform.platformName)){
                layer.msg("请输入品牌名称");
                return false;
            }
            if(isNull($scope.platform.website)){
                layer.msg("请输入品牌网址");
                return false;
            }
            if(!validateWebsite($scope.platform.website)){
                layer.msg("输入的网址格式不正确");
                return false;
            }
            $('#subBtn')[0].disabled = true;
            var jsonStr = angular.toJson($scope.platform,true);
            console.log(jsonStr);
            //提交数据
            $http({method : 'POST', data:{jsonParam:jsonStr}, url : $scope.url})
                .success(function(data,status,headers,config){
                    //console.log(data);
                    $('#subBtn')[0].disabled = false;
                    layer.msg(data.msg);
                    console.log(data);
                    if(data.code==0){
                        alert(data.msg);
                        parent.closeWinAndFlush();
                       // $('#subBtn').qrcode($scope.param.website);
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
