/**
 * 联系人信息统计列表
 */
$(function () {
    initTable();
});

function doQuery(){
    $('#demo-table').bootstrapTable('destroy');    //销毁表格
    initTable();
}

function initTable(){
    //
    var url = "/admin/statisticsUser/getStatisticsAll";
    var table = $('#demo-table');
    //var showExport = false;
    var columns = [
        {
            field : '',
            title : '',
            checkbox: true
        }, {
            field : 'id',
            title : '联系人ID',
            align : 'center',
            valign : 'middle'
        }, {
            field : 'person',
            title : '联系人',
            align : 'center',
            valign : 'middle'
        }, {
            field : 'iphone',
            title : '联系人电话',
            align : 'center',
            valign : 'middle'
        }, {
            field : 'platformName',
            title : '品牌',
            align : 'center',
            valign : 'middle'
        },{
            field : 'address',
            title : '联系人地址',
            align : 'center',
            valign : 'middle'
        },{
            field : 'createTime',
            title : '创建时间',
            align : 'center',
            valign : 'middle',
            formatter: function (value, row, index) {
                return formatTime(value);
            }
        }

    ];
    tableUtil.initTable(table,url,columns);
}

function queryParams(params) {
   var time = $('#dateTimeRange').val();
    var beginTime,endTime;
    if(time.length==23){
        //2017-05-26 至 2017-05-26
        beginTime = time.substring(0,10);
        endTime = time.substring(13);
    }


    var param = {
        beginTime : beginTime,
        endTime : endTime,
        keyword : $("#keyword").val(),  //关键字：联系人名称
        pfId:$("#pfId").val(),
        limit : params.limit, // 页面大小
        offset : params.offset // 页码
    }
    return param;
}

// 用于server 分页，表格数据量太大的话 不想一次查询所有数据，可以使用server分页查询，
// 数据量小的话可以直接把sidePagination: "server"  改为 sidePagination: "client"
// ，同时去掉responseHandler: responseHandler就可以了，
function responseHandler(res) {
    console.log("获取到列表数据");
    console.log(res);
    if (res) {
        return {
            "rows" : res.data.dataList,  //显示的数据集合
            "total" : res.data.totalSize   //总记录条数
        };
    } else {
        return {
            "rows" : [],
            "total" : 0
        };
    }
}