var WeiShengMingIndex = {};

WeiShengMingIndex.validator = {};
WeiShengMingIndex.initLoginFormValidator = function () {
	WeiShengMingIndex.validator = new Clover.validator.Validator("#kehuLoginForm");
//	WeiShengMingIndex.validator.addValidation("#zhanghao", "required", "请输入手机号或邮箱");
//	WeiShengMingIndex.validator.addValidation("#mima", "required", "请输入密码");
    return WeiShengMingIndex.validator;
}
WeiShengMingIndex.login =function(){
	 WeiShengMingIndex.initLoginFormValidator() 
	    if(WeiShengMingIndex.validator.validate()) {
	    	/*var mima = $.trim($("#mima").val());
	    	var mima_md5=md5(md5(mima));
	    	$("#mima_md5").val(mima_md5);*/
	        $("#kehuLoginForm").submit(); 
	    }
}

$(function () {
	WeiShengMingIndex.initLoginFormValidator();
});
