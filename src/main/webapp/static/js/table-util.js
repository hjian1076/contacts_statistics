/**
 * Created by hejx on 2017/6/12.
 */

var tableUtil = {
    EXCEL_NAME:{
        STATISTICS_TABLE:"信息统计列表"
    },
    initTableShowExport:function(node,url,excelName,columns){
        node.bootstrapTable({
            method:'POST',
            dataType:'json',
            contentType: "application/x-www-form-urlencoded",
            //toolbar: '#toolbar', //可以在table上方显示的一条工具栏
            //toolbarAlign:'left',//指定 toolbar 水平方向的位置。'left' or 'right'
            cache: false,
            striped: true,                              //是否显示行间隔色
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            search:false,    //显示查询框
            //searchOnEnterKey:true,  //设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
            url:url,
            cardView:false,     //设置为 true将显示card视图，适用于移动设备。否则为table试图，适用于pc
            // height: $(window).height() - 110,
            // width:$(window).width(),
            showColumns:false,               //是否显示 内容列下拉框
            showExport: true,                     //是否显示导出
            exportDataType: "all",              //basic', 'all', 'selected'. 当前页、所有数据还是选中数据。
            exportTypes:['excel'],  //default: ['json', 'xml', 'csv', 'txt', 'sql', 'excel']
            exportOptions:{
                fileName: excelName
            },
            resizable:true, //设置为true，允许在每个列的大小调整. default: false
            pagination:true,    //设置为 true 会在表格底部显示分页条 默认false
            queryParams : queryParams,
            minimumCountColumns:10,             //当列数小于此值时，将隐藏内容列下拉框。
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            checkboxHeader: false,                  //设置false 将在列头隐藏check-all checkbox .
            singleSelect:false,         //设置True 将禁止多选
            selectItemName: "pkId",     //radio or checkbox 的字段名
            clickToSelect:false,        //设置true 将在点击行时，自动选择rediobox 和 checkbox
            responseHandler: responseHandler,   //在加载列表前处理获取到的数据
            columns: columns
        });
    },
    initTable:function(node,url,columns){
        node.bootstrapTable({
            method:'POST',
            dataType:'json',
            contentType: "application/x-www-form-urlencoded",
            //toolbar: '#toolbar', //可以在table上方显示的一条工具栏
            //toolbarAlign:'left',//指定 toolbar 水平方向的位置。'left' or 'right'
            cache: false,
            striped: true,                              //是否显示行间隔色
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            search:false,    //显示查询框
            //searchOnEnterKey:true,  //设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
            url:url,
            cardView:false,     //设置为 true将显示card视图，适用于移动设备。否则为table试图，适用于pc
            // height: $(window).height() - 110,
            // width:$(window).width(),
            showColumns:false,               //是否显示 内容列下拉框
            resizable:true, //设置为true，允许在每个列的大小调整. default: false
            pagination:true,    //设置为 true 会在表格底部显示分页条 默认false
            queryParams : queryParams,
            minimumCountColumns:10,             //当列数小于此值时，将隐藏内容列下拉框。
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            checkboxHeader: true,                  //设置false 将在列头隐藏check-all checkbox .
            singleSelect:false,         //设置True 将禁止多选
            selectItemName: "pkId",     //radio or checkbox 的字段名
            clickToSelect:true,        //设置true 将在点击行时，自动选择rediobox 和 checkbox
            responseHandler: responseHandler,   //在加载列表前处理获取到的数据
            columns: columns
        });
    }
};