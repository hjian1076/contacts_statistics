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
<script src="<%=basePath%>static/js/plugins/bootstrap-table/bootstrap-table-update.min.js"></script>
<script src="<%=basePath%>static/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/extensions/export/bootstrap-table-export.min.js"></script>
<script src="<%=basePath%>static/js/plugins/bootstrap-table/tableExport.js"></script>


<script src="<%=basePath%>static/js/layer/laydate/laydate.js"></script>
<script src="<%=basePath%>static/plugins/layer/layer.js"></script>
<%--<script src="<%=basePath%>static/plugins/layer/mobile/layer.js"></script>--%>

<script src="<%=basePath%>static/js/util.js?rand=<%=rand%>"></script>
<script src="<%=basePath%>static/js/table-util.js?rand=<%=rand%>"></script>

<script>
    /******************为了解决IOS中table横向的滑动*******************/
    //获取当前网页可见区域宽
    var offsetWidth = window.screen.width;  // pc:1694 ipad:798(比较大的ipad,不是最大的那种)
    var offsetHeight = window.screen.height;
    if(offsetWidth<860){
        //则为移动端登录
        $("#tableDiv").width(offsetWidth-20); // 如果不减的话怕出现滚动条
        //判断手机横竖屏状态：
        window.addEventListener("onorientationchange" in window ? "orientationchange" : "resize", function() {
            if (window.orientation === 180 || window.orientation === 0) {   //横屏
                if(offsetWidth > offsetHeight){    //竖屏刷新
                    document.getElementsByTagName('body')[0].style.height = offsetWidth + 'px';
                    document.getElementsByTagName('body')[0].style.width = offsetHeight + 'px';
                    $("#tableDiv").width(offsetHeight-20);
                }else {
                    $("#tableDiv").width(offsetWidth-20);
                }
            }
            if (window.orientation === 90 || window.orientation === -90 ){    //竖屏
                if(offsetHeight > offsetWidth){    //横屏刷新
                    document.getElementsByTagName('body')[0].style.height = offsetWidth + 'px';
                    document.getElementsByTagName('body')[0].style.width = offsetHeight + 'px';
                    $("#tableDiv").width(offsetHeight-20);
                }else {
                    $("#tableDiv").width(offsetWidth-20);
                }
            }
        }, false);
    }
    //alert(offsetWidth);

</script>

