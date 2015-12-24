var WeiShengMingReg = {};

WeiShengMingReg.validator = {};
WeiShengMingReg.initRegFormValidator = function () {
	WeiShengMingReg.validator = new Clover.validator.Validator("#keHuRegForm");
	WeiShengMingReg.validator.addAsyncValidation("#zhanghao", function (target, inform) {
        alert('aa');
        
		if(target.val() != ""){
            var zhanghao = $("#zhanghao").val();
            $.ajax({
                type: "POST",
                async:false,
                data:{
                	zhanghao:zhanghao
                },
                dataType: "json",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: '/check_zhanghao_unique_ajax',
                success: function (isValid) {
                    inform(isValid);
                }
            })
        }
    }, "该账号已经存在，请登录！");
    return WeiShengMingReg.validator;
}
WeiShengMingReg.reg =function(){
	 WeiShengMingReg.initRegFormValidator();
	 alert(WeiShengMingReg.validator.validate());
	   /* if(WeiShengMingReg.validator.validate()) {
	    	var mima = $.trim($("#mima").val());
	    	var mima_md5=md5(md5(mima));
	    	$("#mima_md5").val(mima_md5);
	       // $("#kehuLoginForm").submit(); 
	    }*/
}

$(function () {
	WeiShengMingReg.initRegFormValidator();
});
