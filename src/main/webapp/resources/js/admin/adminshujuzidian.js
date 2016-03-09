var AdminShuJuZiDian = {};

AdminShuJuZiDian.shujuzidian_ajax = function(id){
	 var aj = $.ajax({ 
		    url:'/admin/shujuzidian/shujuzidian_ajax',// 跳转到 action 
		    data:{ 
		             id : id
		    }, 
		    type:'post', 
		    cache:false, 
		    dataType:'html', 
		    success:function(data) { 
                $("#shujuzidian_div").html(data);
		     }
		});
}


AdminShuJuZiDian.shujuzidian_update_ajax = function(){
	 var id=$("#id_input").val();
	 var fuid=$("#fuid_input").val();
	 var neirong=$("#neirong_input").val();
	 var paixu=$("#paixu_input").val();
//	 alert(id+"-"+fuid+"-"+neirong+"-"+paixu);
	 var aj = $.ajax({ 
		    url:'/admin/shujuzidian/shujuzidian_update_ajax',// 跳转到 action 
		    data:{ 
		    	id : id, 
		    	fuid : fuid,
		    	neirong : neirong,
		    	paixu : paixu
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

AdminShuJuZiDian.shujuzidian_delete_ajax = function(id){
	 var aj = $.ajax({ 
		    url:'/admin/shujuzidian/shujuzidian_delete_ajax',// 跳转到 action 
		    data:{ 
		             id : id
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



AdminShuJuZiDian.shujuzidian_zi_ajax = function(id,neirong){
	 var aj = $.ajax({ 
		    url:'/admin/shujuzidian/shujuzidian_zi_ajax',// 跳转到 action 
		    data:{ 
		             id : id
		    }, 
		    type:'post', 
		    cache:false, 
		    dataType:'html', 
		    success:function(data) { 
		       $("#zileixingmingzi").html(neirong);
               $("#shujuzidian_zi_div").html(data);
		     }
		});
}

AdminShuJuZiDian.shujuzidian_zi_update_ajax = function(){
	 var id=$("#id_zi_input").val();
	 var fuid=$("#fuid_zi_input").val();
	 var neirong=$("#neirong_zi_input").val();
	 var paixu=$("#paixu_zi_input").val();
//	 alert(id+"-"+fuid+"-"+neirong+"-"+paixu);
	 var aj = $.ajax({ 
		    url:'/admin/shujuzidian/shujuzidian_zi_update_ajax',// 跳转到 action 
		    data:{ 
		    	id : id, 
		    	fuid : fuid,
		    	neirong : neirong,
		    	paixu : paixu
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

AdminShuJuZiDian.shujuzidian_zi_delete_ajax = function(id){
	 var aj = $.ajax({ 
		    url:'/admin/shujuzidian/shujuzidian_zi_delete_ajax',// 跳转到 action 
		    data:{ 
		             id : id
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