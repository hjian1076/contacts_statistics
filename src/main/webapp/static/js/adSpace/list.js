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
    var url = "/admin/adSpace/getAdSpaceAll";
    var table = $('#demo-table');
    //var showExport = false;
    var columns = [
        {
            field : '',
            title : '',
            checkbox: true
        },
        {
            field : 'id',
            title : '广告位ID',
            align : 'center',
            valign : 'middle'
        }, {
            field : 'adSpaceName',
            title : '广告位名称',
            align : 'center',
            valign : 'middle'
        },{
            field : 'createTime',
            title : '创建时间',
            align : 'center',
            formatter: function (value, row, index) {
                return formatTime(value);
            }
         }
         ,{
            field:'operate',
            title:'操作1',
            align : 'center',
            valign : 'middle',
            formatter:function (value,row,index) {

                return '<a onclick="createCode(+\'' +row.id+ '\')" class="btn btn-sm btn-primary">链接地址</a>';
            }
        },{
            field:'operate',
            title:'操作2',
            align : 'center',
            valign : 'middle',
            formatter:function (value,row,index) {

                return '<button id="copyPath" onclick="copyCode(+\'' +row.id+ '\')"  >复制链接</button>';
            }
        }

    ];
    tableUtil.initTable(table,url,columns);
}
function copyCode(id) {
     var path = webPath+"/getAdSpaceById?p="+id;
    var clipboard = new Clipboard('#copyPath', {
        text: function() {
            return path;
        }
    });
    clipboard.on('success', function() {
        alert("复制成功！！！");
    });
}
function queryParams(params) {
    var param = {
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