<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>添加广告位</title>
    <!--头部-->
    <jsp:include page="/template/header.jsp" />

    <!--头部结束-->
</head>
<body class="gray-bg">
<div ng-app="myApp" ng-controller="addAdSpaceController" class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">广告位名称<span style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input  ng-model="adSpace.adSpaceName" type="text" class="form-control">
                            </div>
                        </div>

                       <div class="form-group">
                            <label class="col-sm-2 control-label">图片上传<span style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input ng-model="adSpace.image" type="text" readonly="readonly" id="imageUrl" class="form-control">
                                <form id="imageForm">
                                    <img id='img' width='120px' height='100px' src=''/><br>
                                    <input type="file" name="file" onchange="SelectImage(this);"/><br>
                                    <input type="button" onclick="uploadImage();" value="上传图片"/>
                                </form>
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
                     </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 导入尾部公共js -->
<jsp:include page="/template/tail.jsp" />
<script>
    $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
    app.controller('addAdSpaceController', function($scope,$http) {

        $scope.adSpace,
        $scope.url
       if('${update}'=='6'){
            // 修改用户
            $scope.adSpace = angular.fromJson('${adSpace}');
            $scope.url = "/admin/adSpace/update";
            document.getElementById("img").src = $scope.adSpace.image;
        }else{
            $scope.adSpace = {
                adSpaceName:'',
                image:'',
            };
            $scope.url = "/admin/adSpace/add";
        }

        //保存
        $scope.save = function(){
            $scope.adSpace.image = $("#imageUrl").val();
            if(isNull($scope.adSpace.adSpaceName)){
                layer.msg("请输入广告位名称");
                return false;
            }
            if(isNull($scope.adSpace.image)){
                layer.msg("上传图片不能为空");
                return false;
            }
            $('#subBtn')[0].disabled = true;
            var jsonStr = angular.toJson($scope.adSpace,true);
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
    function SelectImage(imgFile) {
       var file =  imgFile.value.substring(imgFile.value.lastIndexOf("."),imgFile.value.length);
       file = file.toLowerCase();
       if((file!='.jpg')&&(file!='.gif')&&(file!='.jpeg')&&(file!='.png')&&(file!='.bmp')){
           alert("对不起，图片格式错误，请重新上传");
           imgFile.value="";
       }
       var reader = new FileReader();
       reader.readAsDataURL(imgFile.files[0]);
       reader.onload=function (evt) {
           document.getElementById('img').src = evt.target.result;
       }
    }
      function uploadImage() {
        var formData = new FormData(document.getElementById('imageForm'));
        console.log(formData);
        $.ajax({
            type:'POST',
            url:'/admin/adSpace/uploadImage',
            data:formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success:function (data) {
                if(data.code==0){
                    var imageUrl = data.data;
                    $("#imageUrl").val(imageUrl);
                    alert('上传成功');
                }else {
                    layer.msg(data.msg);
                }
            },
            error:function () {
                alert('网络故障');
            }
        });
    }
</script>

</body>
</html>
