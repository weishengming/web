var AdminUser = {};
AdminUser.user_ajax = function(userid){
	 var aj = $.ajax({ 
		    url:'/admin/user/user_ajax',// 跳转到 action 
		    data:{ 
		             id : userid
		    }, 
		    type:'post', 
		    cache:false, 
		    dataType:'html', 
		    success:function(data) { 
                $("#user_div").html(data);
		     }
		});
}
AdminUser.user_update_ajax = function(){
	 var id=$("#id_input").val();
	 var name=$("#name_input").val();
	 var age=$("#age_input").val();
	 var aj = $.ajax({ 
		    url:'/admin/user/user_update_ajax',// 跳转到 action 
		    data:{ 
		    	id : id, 
		    	name : name,
		    	age : age 
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

 
AdminUser.user_delete_ajax = function(userid){
	 var aj = $.ajax({ 
		    url:'/admin/user/user_delete_ajax',// 跳转到 action 
		    data:{ 
		             id : userid
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