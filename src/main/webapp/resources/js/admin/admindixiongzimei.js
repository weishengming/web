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
                   alert("操作成功");
                   window.location.reload();
               } else {
                   alert(data.errorMessage);
               }
		     }
		});
}

$(document).ready(function() {	
	
})