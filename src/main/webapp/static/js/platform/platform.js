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
    var url = "/admin/platform/getPlatformAll";
    var table = $('#demo-table');
    //var showExport = false;
    var columns = [
        {
            field : 'id',
            title : '品牌ID',
            align : 'center',
            valign : 'middle'
        }, {
            field : 'platformName',
            title : '品牌名称',
            align : 'center',
            valign : 'middle'
        }, {
            field : 'website',
            title : '品牌地址',
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
            title:'操作',
            align : 'center',
            valign : 'middle',
            formatter:function (value,row,index) {

                return '<a onclick="createCode(+\'' +row.id+ '\')" class="btn btn-sm btn-primary">生成二维码</a>';
            }
        }

    ];
    tableUtil.initTable(table,url,columns);
}
function openCode(id) {

}
function createCode(id) {

        var html = '<div id="qrcode" class="ibox-content" style="align-content: center">'+'</div>';
        layer.open({
                title:'生成二维码',
                type: 1,
                skin: 'layui-layer-rim', //加上边框
                area: ['300px', '330px'], //宽高
                content: html})
        var qcodepath = path+"/getPlatformById?p="+id;
        var qrcode = new QRCode(document.getElementById("qrcode"), {
            width : 200,
            height : 200
        });
        qrcode.makeCode(qcodepath);
    // $.ajax({
    //     url:'admin/platform/createCode',
    //     type:'POST',
    //     async:false,
    //     data:{
    //         id:id
    //     },
    //     timeout:5000,
    //     dataType:'json',
    //     success:function (data,textStatus,jqXHR) {
    //         layer.msg(data.msg);
    //         if(data.code==0){
    //             alert(data.msg);
    //         }
    //     },
    //     error:function(xhr,textStatus){
    //         console.log('错误')
    //         console.log(xhr)
    //         console.log(textStatus)
    //     }
    // })
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