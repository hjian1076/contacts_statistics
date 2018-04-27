/**
 * Created by 追风少年 on 2017/5/25.
 */

var common = {
    initDateTimeRange:function(){
        $('#dateTimeRange').daterangepicker({
            applyClass : 'btn-sm btn-success',
            cancelClass : 'btn-sm btn-default',
            locale: {
                applyLabel: '确认',
                cancelLabel: '取消',
                fromLabel : '起始时间',
                toLabel : '结束时间',
                customRangeLabel : '自定义',
                firstDay : 1
            },
            ranges : {
                //'最近1小时': [moment().subtract('hours',1), moment()],
                '今日': [moment().startOf('day'), moment()],
                '昨日': [moment().subtract('days', 1).startOf('day'), moment().subtract('days', 1).endOf('day')],
                '最近7日': [moment().subtract('days', 6), moment()],
                '最近30日': [moment().subtract('days', 29), moment()],
                '本月': [moment().startOf("month"),moment().endOf("month")],
                '上个月': [moment().subtract(1,"month").startOf("month"),moment().subtract(1,"month").endOf("month")]
            },
            opens : 'left',	// 日期选择框的弹出位置
            separator : ' 至 ',
            showWeekNumbers : true,		// 是否显示第几周


            //timePicker: true,
            //timePickerIncrement : 10,	// 时间的增量，单位为分钟
            //timePicker12Hour : false,	// 是否使用12小时制来显示时间


            //maxDate : moment(),			// 最大时间
            format: 'YYYY-MM-DD'

        }, function(start, end, label) { // 格式化日期显示框
            $('#beginTime').val(start.format('YYYY-MM-DD'));
            $('#endTime').val(end.format('YYYY-MM-DD'));
        })
            .next().on('click', function(){
            $(this).prev().focus();
        });
    },
      initSingleDateRange:function(){
          $('#dateTimeRange').datepicker({
                startView: 2,
                maxViewMode: 2,
                autoclose: true,
                language: "zh-CN"
          },function(start, end, label) {
                 console.log('New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')');
          });
        //        $('#dateTimeRange').daterangepicker({
        //     applyClass : 'btn-sm btn-success',
        //     cancelClass : 'btn-sm btn-default',
        //     locale: {
        //         applyLabel: '确认',
        //         cancelLabel: '取消',
        //         fromLabel : '起始时间',
        //         toLabel : '结束时间',
        //         customRangeLabel : '自定义',
        //         firstDay : 1
        //     },
        //     ranges : {
        //         //'最近1小时': [moment().subtract('hours',1), moment()],
        //         '今日': [moment().startOf('day'), moment()],
        //         '昨日': [moment().subtract('days', 1).startOf('day'), moment().subtract('days', 1).endOf('day')],
        //         '最近7日': [moment().subtract('days', 6), moment()],
        //         '最近30日': [moment().subtract('days', 29), moment()],
        //         '本月': [moment().startOf("month"),moment().endOf("month")],
        //         '上个月': [moment().subtract(1,"month").startOf("month"),moment().subtract(1,"month").endOf("month")]
        //     },
        //     opens : 'left',	// 日期选择框的弹出位置
        //     separator : ' 至 ',
        //     showWeekNumbers : true,		// 是否显示第几周
        //
        //
        //     //timePicker: true,
        //     //timePickerIncrement : 10,	// 时间的增量，单位为分钟
        //     //timePicker12Hour : false,	// 是否使用12小时制来显示时间
        //
        //
        //     //maxDate : moment(),			// 最大时间
        //     format: 'YYYY-MM-DD'
        //
        // }, function(start, end, label) { // 格式化日期显示框
        //     $('#beginTime').val(start.format('YYYY-MM-DD'));
        //     $('#endTime').val(end.format('YYYY-MM-DD'));
        // })
        //     .next().on('click', function(){
        //     $(this).prev().focus();
        // });
      },

    init24HDateTimeRange:function(){
        $('#dateTimeRange').daterangepicker({
            applyClass : 'btn-sm btn-success',
            cancelClass : 'btn-sm btn-default',
            locale: {
                applyLabel: '确认',
                cancelLabel: '取消',
                fromLabel : '起始时间',
                toLabel : '结束时间',
                customRangeLabel : '自定义',
                firstDay : 1
            },
            opens : 'right',	// 日期选择框的弹出位置
            separator : ' 至 ',
            showWeekNumbers : true,		// 是否显示第几周


            timePicker: true,
            timePickerIncrement : 1,	// 时间的增量，单位为分钟
            timePicker12Hour : false,	// 是否使用12小时制来显示时间


            //maxDate : moment(),			// 最大时间
            format: 'YYYY-MM-DD HH:mm:ss'

        }, function(start, end, label) { // 格式化日期显示框
            $('#beginTime').val(start.format('YYYY-MM-DD'));
            $('#endTime').val(end.format('YYYY-MM-DD'));
        })
            .next().on('click', function(){
            $(this).prev().focus();
        });
    },
    initDateTimeRangeByOpt:function(opt){
        var position = "left"; // 默认设置
        if(!isNull(opt.opens)){
            position = opt.opens;
        }
        $('#dateTimeRange').daterangepicker({
            applyClass : 'btn-sm btn-success',
            cancelClass : 'btn-sm btn-default',
            locale: {
                applyLabel: '确认',
                cancelLabel: '取消',
                fromLabel : '起始时间',
                toLabel : '结束时间',
                customRangeLabel : '自定义',
                firstDay : 1
            },
            ranges : {
                //'最近1小时': [moment().subtract('hours',1), moment()],
                '今日': [moment().startOf('day'), moment()],
                '昨日': [moment().subtract('days', 1).startOf('day'), moment().subtract('days', 1).endOf('day')],
                '最近7日': [moment().subtract('days', 6), moment()],
                '最近30日': [moment().subtract('days', 29), moment()],
                '本月': [moment().startOf("month"),moment().endOf("month")],
                '上个月': [moment().subtract(1,"month").startOf("month"),moment().subtract(1,"month").endOf("month")]
            },
            opens : position,	// 日期选择框的弹出位置
            separator : ' 至 ',
            showWeekNumbers : true,		// 是否显示第几周


            //timePicker: true,
            //timePickerIncrement : 10,	// 时间的增量，单位为分钟
            //timePicker12Hour : false,	// 是否使用12小时制来显示时间


            //maxDate : moment(),			// 最大时间
            format: 'YYYY-MM-DD'

        }, function(start, end, label) { // 格式化日期显示框
            $('#beginTime').val(start.format('YYYY-MM-DD'));
            $('#endTime').val(end.format('YYYY-MM-DD'));
        })
            .next().on('click', function(){
            $(this).prev().focus();
        });
    },
    ERR_MSG:{
        PHONE_ERROR_MSG:"请输入有效的电话号码",
        EMAIL_ERROR_MSG:"邮箱格式错误"
    },
    HUNDRED : 100,//上下分比例
    GAME_CURRENCY_RATIO:100,//所有显示比例
    PAGE_SIZE:10,
    PLAN_TYPE:{
        NORMAL_PLAN:0,  //普通策略枚举值
        UNUSUAL_PLAN:1  //控制策略枚举值
    }
};

/**
 * 清除时间
 */
function begin_end_time_clear() {
    $('#dateTimeRange').val('');
    $('#beginTime').val('');
    $('#endTime').val('');
}

/**
 * 数字工具类
 * @type {{zzsReg: RegExp, validateZzs: numberUtils.validateZzs}}
 */
var numberUtils = {
    zzsReg:/^\+?[0-9][0-9]*$/,
    validateZzs:function(str){ // 验证正整数
        if(isNull(str)) return false;
        return numberUtils.zzsReg.test(str);
    },
    validateZeroAndZzs:function (str) { // 验证0或正整数
        if(!isNull(str +"") && str == 0) return true;
        return numberUtils.validateZzs(str);
    }
};

/**
 * jquery获取复选框值
 */
function getCheckBoxVal(checkboxName){
    var chk_value =[];
    $('input[name='+checkboxName+']:checked').each(function(){
        chk_value.push($(this).val());
    });
    return chk_value;
}

/**
 *  jquery清除选中复选框
 */
function cleanSelectedBox(checkboxName) {
    $('input[name='+checkboxName+']:checked').each(function(){
        $(this).attr("checked",false);
    });
}

/**
 * 判断输入字符串是否为空或者全部都是空格
 * @param str
 * @returns {boolean} is null|undefined true else false
 */
function isNull(str){
    if ( str == "" ) return true;
    if ( str == undefined ) return true;
    var regu = "^[ ]+$";
    var re = new RegExp(regu);
    return re.test(str);
}

/**
 * 验证手机号码
 * @param mobile
 * @return is mobile return true else return false
 */
function validatemobile(mobile){
    if(isNull(mobile)){
        return false;
    }
    var myreg = /^(((13[0-9]{1})|(17[0-9])|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    if(!myreg.test(mobile)){
        return false;
    }
    return true;
}

/**
 * 验证网址
 * @param website
 */
function validateWebsite(website) {
    if(isNull(website)){
        return false;
    }
    var myreg = /^[hH][tT][tT][pP]([sS]?):\/\/(\S+\.)+\S{2,}$/;
    if(!myreg.test(website)){
        return false;
    }
    return true;
}
/**
 * 验证邮箱
 * @param email
 * @return is email return true else return false
 */
function validateEmail(email){
    if(isNull(email)){
        return false;
    }
    var myreg =  /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if(!myreg.test(email)){
        return false;
    }
    return true;
}

/**
 * 去掉字符串中所有空格(包括中间空格)
 * @param str
 * @returns string
 * @constructor
 */
function clearAllSpace(str){
    var result = str.replace(/\s/g,"");
    return result;
}

/**
 * 获取当前的日期时间 格式“yyyy-MM-dd”
 * @returns {string}
 */
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

/**
 * 格式化日期时间 格式“yyyy-MM-dd HH:MM:SS”
 * @param long timer
 * @returns {string}
 */
function formatTime(time) {
    if(isNull(time)) return "";
    var date = new Date(time);
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var hours = addPrefixZero(date.getHours());
    var seconds =  addPrefixZero(date.getSeconds());
    var minutes =  addPrefixZero(date.getMinutes());
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + hours + seperator2 + minutes
        + seperator2 + seconds;
    return currentdate;
}

function formatUnusualTime(time) {
    if(isNull(time)) return "";
    var nowDate = getNowFormatDate();
    var date = new Date(time);
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var hours = addPrefixZero(date.getHours());
    var minutes =  addPrefixZero(date.getMinutes());
    if(nowDate == (date.getFullYear() + seperator1 + month + seperator1 + strDate)){
        return "今天 " + hours + seperator2 + minutes;
    }else {

        var currentDate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + hours + seperator2 + minutes;
        return currentDate;
    }
}

/**
 * 格式化日期时间 格式“yyyy-MM-dd HH:MM:SS”
 * @param long timer
 * @returns {string}
 */
function formatSimpleTime(time) {
    if(isNull(time)) return "";
    var date = new Date(time);
    var seperator1 = "-";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

// if num < 10 add prefix '0'
function addPrefixZero(num){
    if(num<10){
        return "0"+num;
    }
    return num;
}

/**
 * 获取当前的日期时间 格式“yyyy-MM-dd HH:MM:SS”
 * @returns {string}
 */
function getNowFormatTime() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes()
        + seperator2 + date.getSeconds();
    return currentdate;
}

/**
 * 给日期减30天  格式“yyyy-MM-dd HH:MM:SS”
 * @param day
 */
function minusThirtyDay() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth();
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    if(month == 0){
        year  = year - 1;
        month = "12";
    }
    var currentDate = year + seperator1 + month + seperator1 + strDate;
    return currentDate;
}

/**
 * 根据浏览器的长宽打开input窗口
 * @param url
 * @param title
 */
function openInputWin(url,title){
    //获取当前网页可见区域宽
    var offsetWidth = document.body.offsetWidth;  // pc:1694 ipad:798(比较大的ipad,不是最大的那种)
    if(offsetWidth<860){
        //则为移动端登录
        layer.open({
            type: 2,
            title: title,
            area: ['90%', '80%'],    //宽和高 原来为：90% 80%
            anim:1,//出场动画全部采用CSS3。这意味着除了ie6-9，其它所有浏览器都是支持的。目前anim可支持的动画类型有0-6 如果不想显示动画，设置 anim: -1 即可
            content: url, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            success: function(layero) {
                $(layero).addClass("scroll-wrapper"); //苹果 iframe 滚动条失效解决方式 经测试 无效
            }
        });
    }else{
        //PC网页端
        layer.open({
            type: 2,
            title: title,
            // area: ['800px', '500px'],    //宽和高
            area: ['1000px', '700px'],    //宽和高
            anim:1,//出场动画全部采用CSS3。这意味着除了ie6-9，其它所有浏览器都是支持的。目前anim可支持的动画类型有0-6 如果不想显示动画，设置 anim: -1 即可
            content: url, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            success: function(layero) {
                $(layero).addClass("scroll-wrapper"); //苹果 iframe 滚动条失效解决方式 经测试 无效
            }
        });
    }
}

function doClean() {    //清除输入的数据
    checkType($("#userId"));
    checkType($("#keyword"));
    checkType($("#userAction"));
    checkType($("#gameType"));
    checkType($("#selectType1"));
    checkType($("#selectType2"));
    checkType($("#selectType3"));
    checkType($("#roleId"));
    checkType($("#groupId"));
    checkType($("#dateTimeRange"));
}

function checkType(tag) {
    if(tag.attr("type")){
        tag.val('');
    }else {
        tag.val(-1);
    }
}

/**
 * 把小数转换成百分数
 * @param num
 * @returns {*}
 */
function getPercent(num) {
    return (num * 100).toFixed(2) + "%";
}

/**
 * 把数字除以显示的比例
 * @param num
 * @returns {number}
 */
function divideHundred(num) {
    return num/common.GAME_CURRENCY_RATIO;
}

/**
 * 两个数相乘，解决浮点数的问题
 * @param a
 * @param b
 * @returns {number}
 */
function mul(a, b) {
    var c = 0, d = a.toString(), e = b.toString();
    try {
        c += d.split(".")[1].length;
    } catch (f) {}
    try {
        c += e.split(".")[1].length;
    } catch (f) {}
    return Number(d.replace(".", "")) * Number(e.replace(".", "")) / Math.pow(10, c);
}

/**
 * 两个数相除，解决浮点数的问题
 * @param a
 * @param b
 */
function divide(a, b) {
    var c, d, e = 0, f = 0;
    try { e = a.toString().split(".")[1].length;
    } catch (g) {}
    try {
        f = b.toString().split(".")[1].length;
    } catch (g) {}
    return c = Number(a.toString().replace(".", "")), d = Number(b.toString().replace(".", "")), c / d * Math.pow(10, f - e);
}

/**
 * 处理数字运算产生的不准确浮点数
 * @param num   待处理的数字
 * @param digit 保留几位小数
 * @returns {number}
 */
function handleNum(num,digit) {
    var a = 0;
    try {
        a = num.toString().split(".")[1].length;
        if(a <= digit){
            return num;
        }else {
            return Number(num.toFixed(digit));
        }
    } catch (g) {
        return num;
    }
}