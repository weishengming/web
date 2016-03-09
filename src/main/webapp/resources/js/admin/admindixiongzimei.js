var AdminDiXiongZiMei = {};

AdminDiXiongZiMei.dixiongzimei_ajax = function(dixiongzimeiid){
	 var aj = $.ajax({ 
		    url:'/admin/dixiongzimei/dixiongzimei_ajax',// 跳转到 action 
		    data:{ 
		             id : dixiongzimeiid
		    }, 
		    type:'post', 
		    cache:false, 
		    dataType:'html', 
		    success:function(data) { 
                $("#dixiongzimei_div").html(data);
		     }
		});
}


AdminDiXiongZiMei.dixiongzimei_update_ajax = function(){
	 var id=$("#id_input").val();
	 var xingming=$("#xingming_input").val();
	 var xingbie=$('input:radio[name="xingbie_input"]:checked' ).val();
	 var nianling=$("#nianling_input").val();
	 var shoujihao=$("#shoujihao_input").val();
	 var qq=$("#qq_input").val();
	 var weixinhao=$("#weixinhao_input").val();
	 var shenfen=$('input:radio[name="shenfen_input"]:checked' ).val();
	 var qita=$("#qita_input").val();
	 var suoding=$('input:radio[name="suoding_input"]:checked' ).val();
//	 alert(id+"-"+xingming+"-"+xingbie+"-"+nianling+"-"+shoujihao+"-"+qq+"-"+weixinhao+"-"+shenfen+"-"+qita);
	 var aj = $.ajax({ 
		    url:'/admin/dixiongzimei/dixiongzimei_update_ajax',// 跳转到 action 
		    data:{ 
		    	id : id, 
		    	xingming : xingming,
		    	xingbie : xingbie, 
		    	nianling : nianling,
		    	shoujihao : shoujihao, 
		    	xingming : xingming,
		    	qq : qq, 
		    	weixinhao : weixinhao,
		    	shenfen : shenfen, 
		    	qita : qita,
		    	suoding:suoding
		    }, 
		    type:'post', 
		    cache:false, 
		    dataType:'json', 
		    success:function(data) { 
               if (data.success) {
                   alert(data.data);
                   window.location.reload();
               } else {
                   alert(data.errorMessage);
               }
		     }
		});
}


AdminDiXiongZiMei.dixiongzimeidizhi_ajax = function(dixiongzimeiid){
	 var aj = $.ajax({ 
		    url:'/admin/dixiongzimei/dixiongzimeidizhi_ajax',// 跳转到 action 
		    data:{ 
		             id : dixiongzimeiid
		    }, 
		    type:'post', 
		    cache:false, 
		    dataType:'html', 
		    success:function(data) { 
               $("#dixiongzimeidizhi_div").html(data);
		     }
		});
}

AdminDiXiongZiMei.dixiongzimeidizhi_update_ajax = function(){
	 var openID=$("#openID_dizhi_input").val();
	 var nickname=$("#nickname_dizhi_input").val();
	 var dixiongzimeiid=$("#dixiongzimeiid_dizhi_input").val();
	 var dixiongzimeixingming=$("#dixiongzimeixingming_dizhi_input").val();
	 var leixing=$('input:radio[name="leixing_dizhi_input"]:checked' ).val();
	 var areaId=$("#areaId").val();
	 var areaName=$("#areaName").val();
	 var area1Id=$("#area1Id").val();
	 var area1Name=$("#area1Name").val();
	 var area2Id=$("#area2Id").val();
	 var area2Name=$("#area2Name").val();
	 var area3Id=$("#area3Id").val();
	 var area3Name=$("#area3Name").val();
	 var xiangxidizhi=$("#xiangxidizhi_dizhi_input").val();
//	 alert(openID+"-"+nickname+"-"+dixiongzimeiid+"-"+dixiongzimeixingming+"-"+
//			 leixing+"-"+areaId+"-"+areaName+"-"+area1Id+"-"+
//			 area1Name+"-"+area2Id+"-"+area2Name+"-"+area3Id+"-"+
//			 area3Name+"-"+xiangxidizhi
//	       );
	 var aj = $.ajax({ 
		    url:'/admin/dixiongzimei/dixiongzimeidizhi_update_ajax',// 跳转到 action 
		    data:{ 
		    	openID : openID, 
		    	nickname : nickname,
		    	dixiongzimeiid : dixiongzimeiid, 
		    	dixiongzimeixingming : dixiongzimeixingming,
		    	leixing : leixing, 
		    	areaId : areaId,
		    	areaName : areaName, 
		    	area1Id : area1Id, 
		    	area1Name : area1Name,
		    	area2Id : area2Id, 
		    	area2Name : area2Name,
		    	area3Id : area3Id,
		    	area3Name : area3Name, 
		    	xiangxidizhi : xiangxidizhi
		    }, 
		    type:'post', 
		    cache:false, 
		    dataType:'json', 
		    success:function(data) { 
              if (data.success) {
                  alert(data.data);
                  window.location.reload();
              } else {
                  alert(data.errorMessage);
              }
		     }
		});
}

AdminDiXiongZiMei.dixiongzimeidizhi_delete_ajax = function(dixiongzimeiid){
	 var aj = $.ajax({ 
		    url:'/admin/dixiongzimei/dixiongzimeidizhi_delete_ajax',// 跳转到 action 
		    data:{ 
		             id : dixiongzimeiid
		    }, 
		    type:'post', 
		    cache:false, 
		    dataType:'json', 
		    success:function(data) { 
		    	if (data.success) {
	                  alert(data.data);
	                  window.location.reload();
	              } else {
	                  alert(data.errorMessage);
	              }
		     }
		});
}



AdminDiXiongZiMei.jiaohuidizhi_ajax = function(dixiongzimeiid){
	 var aj = $.ajax({ 
		    url:'/admin/dixiongzimei/jiaohuidizhi_ajax',// 跳转到 action 
		    data:{ 
		             id : dixiongzimeiid
		    }, 
		    type:'post', 
		    cache:false, 
		    dataType:'html', 
		    success:function(data) { 
              $("#jiaohuidizhi_div").html(data);
		     }
		});
}

AdminDiXiongZiMei.jiaohuidizhi_update_ajax = function(){
	 var openID=$("#openID_dizhi_input").val();
	 var nickname=$("#nickname_dizhi_input").val();
	 var dixiongzimeiid=$("#dixiongzimeiid_dizhi_input").val();
	 var dixiongzimeixingming=$("#dixiongzimeixingming_dizhi_input").val();
	 var mingzi=$("#mingzi_dizhi_input").val();
	 var areaId=$("#areaId").val();
	 var areaName=$("#areaName").val();
	 var area1Id=$("#area1Id").val();
	 var area1Name=$("#area1Name").val();
	 var area2Id=$("#area2Id").val();
	 var area2Name=$("#area2Name").val();
	 var area3Id=$("#area3Id").val();
	 var area3Name=$("#area3Name").val();
	 var xiangxidizhi=$("#xiangxidizhi_dizhi_input").val();
//	 alert(openID+"-"+nickname+"-"+dixiongzimeiid+"-"+dixiongzimeixingming+"-"+
//			 mingzi+"-"+areaId+"-"+areaName+"-"+area1Id+"-"+
//			 area1Name+"-"+area2Id+"-"+area2Name+"-"+area3Id+"-"+
//			 area3Name+"-"+xiangxidizhi
//	       );
	 var aj = $.ajax({ 
		    url:'/admin/dixiongzimei/jiaohuidizhi_update_ajax',// 跳转到 action 
		    data:{ 
		    	openID : openID, 
		    	nickname : nickname,
		    	dixiongzimeiid : dixiongzimeiid, 
		    	dixiongzimeixingming : dixiongzimeixingming,
		    	mingzi : mingzi, 
		    	areaId : areaId,
		    	areaName : areaName, 
		    	area1Id : area1Id, 
		    	area1Name : area1Name,
		    	area2Id : area2Id, 
		    	area2Name : area2Name,
		    	area3Id : area3Id,
		    	area3Name : area3Name, 
		    	xiangxidizhi : xiangxidizhi
		    }, 
		    type:'post', 
		    cache:false, 
		    dataType:'json', 
		    success:function(data) { 
             if (data.success) {
                 alert(data.data);
                 window.location.reload();
             } else {
                 alert(data.errorMessage);
             }
		     }
		});
}

AdminDiXiongZiMei.jiaohuidizhi_delete_ajax = function(dixiongzimeiid){
	 var aj = $.ajax({ 
		    url:'/admin/dixiongzimei/jiaohuidizhi_delete_ajax',// 跳转到 action 
		    data:{ 
		             id : dixiongzimeiid
		    }, 
		    type:'post', 
		    cache:false, 
		    dataType:'json', 
		    success:function(data) { 
		    	if (data.success) {
	                  alert(data.data);
	                  window.location.reload();
	              } else {
	                  alert(data.errorMessage);
	              }
		     }
		});
}




$(document).ready(function() {	
	
})