var AdminDiXiongZiMei = {};

AdminDiXiongZiMei.dixiongzimei_ajax = function(){
	var sexval=$('input:radio[name="xingbie"]:checked').val();
	 var user_id=$("#user_id").val();
	 var aj = $.ajax({ 
		    url:'/user/gengxinxingbie_ajax',// 跳转到 action 
		    data:{ 
		             xingbie : sexval, 
		             user_id : user_id 
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