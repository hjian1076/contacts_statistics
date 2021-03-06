
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    Integer pid = (Integer)request.getAttribute("pid");
    double rand = Math.random();
%>
<html>
<head>


    <title></title>
    <%--<jsp:include page="/template/header.jsp" />--%>
    <%--<script>--%>
        <%--if (window != top){--%>
            <%--top.location.href = location.href;--%>
        <%--}--%>
    <%--</script>--%>
    <style type="text/css">

			*{margin: 0;border: 0;}
			*:focus{outline: none;}
			body{font-family: "微软雅黑";background-color: #2d7fed;}
			.tit{width: 100%;height: 110px;line-height: 110px; text-align: center;font-size: 44px;color: #fff;background-color: #2d7fed;}
			img{width: 100%;}
			.item{font-size: 34px;color: #fff;position: relative;width: 70%;height: 80px;margin: 50px 15% 0;border-bottom: 1px solid #fff;}
			.item span{display: block;width: 150px;height: 80px;line-height: 80px;}
			.item input{position: absolute;left: 0;top: 0;width: 100%;height: 80px;line-height: 80px;padding: 0 0 0 150px;border: none;background: none;color: #fff;font-size: 30px;box-sizing: border-box;}
			a{display: block;width: 70%;height: 80px;margin: 80px auto;background-color: #fff;color: #2d7fed;font-size: 40px;text-align: center;line-height: 80px;text-decoration: none;border-radius: 5px;}
            input:-ms-input-placeholder{
                color: #ffffff;opacity:1;
            }

            input::-webkit-input-placeholder{
                color: #ffffff;opacity:1;
            }
    </style>
</head>
<body >
    <div ng-app="myApp" ng-controller="addController">
        <div class="tit">免费领机</div>
		<img src="<%=basePath%>/static/img/bg.jpg"/>
        <form>
            <div class="item">
			    <span>姓名</span>
                <input type="text" ng-model="param.person" placeholder="请输入姓名" />
		    </div>
		    <div class="item">
			    <span>手机号</span>
			    <input type="tel" ng-model="param.iphone" maxlength="11" placeholder="请输入手机号" />
		    </div>
		    <div class="item">
			    <span>地址</span>
			    <input type="text" ng-model="param.address"  placeholder="请输入地址" />
		    </div>
		    <a id="subBtn" ng-click="save()">下一步</a>
        </form>

    </div>


    <%--<div ng-app="myApp" ng-controller="addController"  class="middle-box text-center loginscreen  animated fadeInDown">--%>
        <%--<div class="tit">--%>
            <%--免费领机--%>
        <%--</div>--%>
        <%--<img src="/static/img/bg.jpg">--%>
        <%--<div>--%>
            <%--<form class="m-t">--%>
                <%--<div class="item">--%>
                    <%--<span>姓名</span>--%>
                    <%--<input type="text"  ng-model="param.person"  placeholder="请输入姓名">--%>
                <%--</div>--%>
                 <%--<div class="item">--%>
                     <%--<span>手机号</span>--%>
                    <%--<input type="text" maxlength="11"   ng-model="param.iphone"  placeholder="请输入手机号">--%>
                <%--</div>--%>
                <%--&lt;%&ndash;<div class="form-group item">&ndash;%&gt;--%>
                     <%--&lt;%&ndash;<div class="input-group" >&ndash;%&gt;--%>
                         <%--&lt;%&ndash;<input class="form-control date-picker" name="dateTimeRange"  ng-model="param.birthDate" placeholder="出生年月"  readonly id="dateTimeRange" value="" type="text">&ndash;%&gt;--%>
                         <%--&lt;%&ndash;<span class="input-group-addon">&ndash;%&gt;--%>
                             <%--&lt;%&ndash;<i class="fa fa-calendar bigger-110"></i>&ndash;%&gt;--%>
                         <%--&lt;%&ndash;</span>&ndash;%&gt;--%>
                     <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

                <%--<div class="item">--%>
                    <%--<span>地址</span>--%>
                    <%--<input type="text"   ng-model="param.address"  placeholder="请输入地址">--%>
                <%--</div>--%>
                <%--<a id="subBtn"15213425633   ng-click="save()" >下一步</a>--%>

            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>

    <!-- 导入尾部公共js -->
    <%--<jsp:include page="/template/tail.jsp" />--%>
    <%--<!-- Sweet Alert -->--%>
    <script src="<%=basePath%>static/js/util.js?rand=<%=rand%>"></script>
    <link href="<%=basePath%>static/css/sweetalert.css" rel="stylesheet">
    <script src="<%=basePath%>static/js/sweetalert.min.js"></script>
    <script src="<%=basePath%>static/js/jquery.min.js?v=2.1.4"></script>
    <%--&lt;%&ndash;<link rel="stylesheet" href="<%=basePath%>static/js/plugins/datepicker/css/bootstrap-datepicker.css" />&ndash;%&gt;--%>
    <%--<script src="<%=basePath%>static/js/plugins/datepicker/js/bootstrap-datepicker.min.js"></script>--%>
    <%--<script src="<%=basePath%>static/js/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.min.js" charset="UTF-8"></script>--%>
    <script src="<%=basePath%>static/js/plugins/layer/layer.js"></script>
    <script src="<%=basePath%>static/js/plugins/angular/angular.min.js"></script>
    <script src="<%=basePath%>static/js/plugins/angular/app.js"></script>
</body>
<script>
       <%--$(function () {--%>
            <%--common.initSingleDateRange();--%>
        <%--})--%>
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
                alert("请输入联系人名字");
               return false;
           }
            if(!validatemobile($scope.param.iphone)){
                alert(common.ERR_MSG.PHONE_ERROR_MSG);
                return false;
            }
           if(isNull($scope.param.address)){
                alert("请输入联系人地址");
               return false;
           }
           $('#subBtn')[0].disabled = true;
            //提交数据
            $http({method : 'POST', data:$scope.param, url : "/addStaUser"})
                .success(function(data,status,headers,config){
                    $('#subBtn')[0].disabled = false;
                    console.log(data);
                    if(data.code==0){
                        window.parent.location.href = data.data;
                    }else{
                        layer.msg(data.msg);
                    }
                }).error(function(data,status,headers,config){
                console.log('error..........');
                console.log(data);
            });
        }


    });
</script>

</html>
