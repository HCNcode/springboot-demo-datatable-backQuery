var tables;
$(document).ready(function() {
	tables = $('#emailrecord').DataTable({
    	fixedHeader: {
	        header: true
	    },
	    
	    "dom": '<<t>ilp>',
	    "pagingType": "simple_numbers",		// 设置分页控件的模式
        "processing": true, 				// 打开数据加载时的等待效果
        "serverSide": true,					// 打开后台分页
        "ordering" : false,
        "order": [[1, 'asc']],
        "bPaginate": true,                  // 分页设置
        "bLengthChange": true,
        "bFilter": false,                   // 搜索设置
        "bSort": false,
        "bInfo": true,
        "bAutoWidth": true,
        "bStateSave":true,
        "bDestory":true,
        paging:true,

        "ajax":{
         	"url":"email/findEmailRecordList",
         	"data":function(d){
         		var result = $("#result").val();
         		var recipientsEntity = $("#recipients").val();
         		d.result =result;
         		d.recipients = recipientsEntity;

         	},
        },
        "columns" : [
                 	/*{"data": null,"targets": 0},*/
                 {
                	 data:"erId",
                	 render:function(data, type, row) { 
   	            		 if(data == "" || data == null) {
   	            			 return "";
   	            		 }
   	            		return data;
   	            	 }
                },
   	             {
   	            	 data:"recipientsEntity",
   	            	 render:function(data, type, row) {
   	            		 if(data == "" || data == null) {
   	            			 return "不存在收件人?";
   	            		 }
   	            		
   	            		 return data.recName;
   	            	 }
   	             },
   	             {data:"comment"},
   	             {
   	            	 data:"sendTime",
   	            	 render:function(data, type, row) {
   	            		 if(data == "" || data == null) {
   	            			 return "-";
   	            		 }
   	            		return (new Date(data).Format("yyyyMMdd"));
   	            	 }
   	             },
   	             {
   	            	 data:"result",
   	            	 render:function(data, type, row) {
   	            		 if(data == 0){
   	            			 return "发送失败";
   	            		 }
   	            		 if(data == 1){
   	            			 return "发送成功";
   	            		 }
   	            		 if(data == "" || data == null) {
   	            			 return "-";
   	            		 }
   	            		 return data;
   	            	 }
   	             },
   	             {
   	            	 data:"remark",
   	            	 render:function(data, type, row) { 
   	            		 if(data == "" || data == null) {
   	            			 return "-";
   	            		 }
   	            		return data;
   	            	 }
   	            },
   	            // null
             ],
                 	"language" : {
            			"paginate" : {
            				"sFirst": "首页",
            	            "sPrevious": "前一页",
            	            "sNext": "后一页",
            			},
            			"info" : "显示_START_到_END_, 共计_TOTAL_条数据",
            			"emptyTable" : "无记录",
            			"infoEmpty" : "共计0",
            			"infoFiltered": "",
            			"lengthMenu": "每页显示 _MENU_ 记录",
            			"sZeroRecords" : "查询不到任何相关数据",
            		},
            		"fnDrawCallback": function(){
                    	var api = this.api();
                    	var startIndex= api.context[0]._iDisplayStart;//获取到本页开始的条数
                    	api.column(0).nodes().each(function(cell, i) {
                    		cell.innerHTML = startIndex + i + 1;
                    	});
                    }
        
    });
	
	
	//格式化页面展示的时间
    Date.prototype.Format = function(fmt) { //author: meizz 
        var o = { 
            "M+": this.getMonth() + 1, 
            //月份 
            "d+": this.getDate(), 
            //日 
            "h+": this.getHours(), 
            //小时 
            "m+": this.getMinutes(), 
            //分 
            "s+": this.getSeconds(), 
            //秒 
            "q+": Math.floor((this.getMonth() + 3) / 3), 
            //季度 
            "S": this.getMilliseconds() //毫秒 
        }; 
        if (/(y+)/.test(fmt)) { 
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length)); 
        } 
        for (var k in o) { 
            if (new RegExp("(" + k + ")").test(fmt)) { 
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length))); 
            } 
        } 
        return fmt; 
    } 
	
});

//搜索按钮
function clickDisTable(){
	tables.ajax.reload();
};
//清空按钮
function cleanDisSearch(){
    $("#result").val("");
    $("#recipients").val("");
    clickDisTable();
}
