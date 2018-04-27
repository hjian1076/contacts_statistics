
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
            <h2>免费领机</h2>
        </div>
        <div>
            <form class="m-t">
                <div class="form-group">
                    <input type="text" class="form-control"  ng-model="param.person"  placeholder="联系人">
                </div>
                 <div class="form-group">
                    <input type="text" maxlength="11" class="form-control"  ng-model="param.iphone"  placeholder="联系人电话">
                </div>
                 <div class="form-group">
                                            <div class="input-group" >
                                                <input class="form-control date-picker" name="dateTimeRange"  ng-model="param.birthDate" placeholder="出生年月"  readonly id="dateTimeRange" value="" type="text">
                                                <span class="input-group-addon">
                                                <i class="fa fa-calendar bigger-110"></i>
                                            </span>
                                            </div>
                     <%--<div class="input-group">--%>
                          <%--<input class="form-control date-picker" name="dateTimeRange" readonly id="dateTimeRange" value="" type="text">--%>
                        <%--&lt;%&ndash;//   <input class="form-control date-picker" name="dateTimeRange" ng-model="param.birthDate" placeholder="出生年月" readonly id="dateTimeRange" value="" type="text">&ndash;%&gt;--%>
                           <%--<span class="input-group-addon">--%>
                            <%--<i class="fa fa-calendar bigger-110"></i>--%>
                        <%--</span>--%>
                    <%--</div>--%>
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
    <link rel="stylesheet" href="<%=basePath%>static/js/plugins/datepicker/css/bootstrap-datepicker.css" />
    <script src="<%=basePath%>static/js/plugins/datepicker/js/bootstrap-datepicker.min.js"></script>
    <script src="<%=basePath%>static/js/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.min.js" charset="UTF-8"></script>
    <script src="<%=basePath%>static/js/plugins/angular/angular.min.js"></script>
    <script src="<%=basePath%>static/js/plugins/angular/app.js"></script>
</body>
<script>
       $(function () {
            common.initSingleDateRange();
        })
//      $('#birthDate .input-group.date').datepicker({
//            startView: 2,
//            maxViewMode: 2,
//            language: "zh-CN"
//      });
//    $.fn.datepicker.dates['cn'] = {   //切换为中文显示
//    days: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
//            daysShort: ["日", "一", "二", "三", "四", "五", "六", "七"],
//            daysMin: ["日", "一", "二", "三", "四", "五", "六", "七"],
//            months: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
//            monthsShort: ["1月  ", "2月  ", "3月  ", "4月  ", "5月  ", "6月  ", "7月  ", "8月  ", "9月  ", "10月  ", "11月  ", "12月  "],
//            today: "今天",
//            clear: "清除"
//    };
//    $('.selectDate').datepicker({
//        autoclose:true,
//        beforeShowDay: $.noop,    //在显示日期之前调用的函数
//        calendarWeeks: false,     //是否显示今年是第几周
//        clearBtn: false,          //显示清除按钮
//        daysOfWeekDisabled: [],   //星期几不可选
//        endDate: Infinity,        //日历结束日期
//        forceParse: true,         //是否强制转换不符合格式的字符串
//        format: 'yyyy-mm-dd',     //日期格式
//        keyboardNavigation: true, //是否显示箭头导航
//        language: 'cn',           //语言
//        minViewMode: 0,
//        orientation: "auto",      //方向
//        rtl: true,
//        startDate: -Infinity,     //日历开始日期
//        startView: 0,             //开始显示
//        todayBtn: false,          //今天按钮
//        todayHighlight: false,    //今天高亮
//        weekStart: 0              //星期几是开始
//
//    });
    $(function() {
        var errorMsg = '${errorMsg}';
        if(errorMsg!=null&&errorMsg!=""){
            sweetAlert("warn", errorMsg, "error");
        }
    });
    app.controller('addController', function($scope,$http) {

        $scope.param = {
            person:'',
            birthDate:'',
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
           if(isNull($scope.param.birthDate)){
                 layer.msg("请输入出生年月");
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
