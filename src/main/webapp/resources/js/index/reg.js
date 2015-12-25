var WeiShengMingReg = {};

WeiShengMingReg.validator = {};
WeiShengMingReg.initRegFormValidator = function () {
	
	WeiShengMingReg.validator = new Clover.validator.Validator("#keHuRegForm");
	WeiShengMingReg.validator.addAsyncValidation("#zhanghao", function (target, inform) {
		if(target.val() != ""){
            var zhanghao = $("#zhanghao").val();
            $.ajax({
                type: "POST",
                async:false,
                dataType: "json",//x-www-form-urlencoded
                contentType: "application/json; charset=utf-8",
                url: '/check_zhanghao_unique_ajax?zhanghao='+zhanghao,
                success: function (data) {
                     inform(data.data);
                }
            })
        }
    }, "该账号已经存在，可以直接登录！");
    return WeiShengMingReg.validator;
}
WeiShengMingReg.reg =function(){
	 WeiShengMingReg.initRegFormValidator();
	 alert(WeiShengMingReg.validator.validate());
	     if(WeiShengMingReg.validator.validate()) {
	    	var mima = $.trim($("#mima").val());
	    	var mimamd5=md5(md5(mima));
	    	$("#mimamd5").val(mimamd5);
	        $("#keHuRegForm").submit(); 
	    } 
}

$(function () {
	WeiShengMingReg.initRegFormValidator();
});
