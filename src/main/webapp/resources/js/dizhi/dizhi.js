// 获得省
function getArea() {
	$("#areaId").html("");
	$("#area3Name").val("");
	jQuery.get("/area/load_JD_Area_by_parent_id/0", null, function(result) {
		if (result.data) {
			var data = result.data;
			if (data.length > 0) {
				var html = "";
				for (var i = 0; i < data.length; i++) {
					html += "<option value='" + data[i].code + "'>"+ data[i].name + "</option>";
				}
				$("#areaId").html(html);
				getArea1();
			}
		}
	}, "json");
}
// 获得市
function getArea1() {
	$("#area1Id").html("");
	var areaId = $("#areaId option:selected").val();
	var areaName= $("#areaId option:selected").html();
	$("#areaName").val(areaName);
	jQuery.get("/area/load_JD_Area_by_parent_id/" + areaId, null, function(result) {
		if (result.data) {
			var data = result.data;
			if (data.length > 0) {
				var html = "";
				for (var i = 0; i < data.length; i++) {
					html += "<option value='" + data[i].code + "'>"+ data[i].name + "</option>";
				}
				$("#area1Id").html(html);
				getArea2();
			}
		}
	}, "json");
}
// 获得区
function getArea2() {
	$("#area2Id").html("");
	var area1Id = $("#area1Id option:selected").val();
	var area1Name= $("#area1Id option:selected").html();
	$("#area1Name").val(area1Name);
	jQuery.get("/area/load_JD_Area_by_parent_id/" + area1Id, null, function(result) {
		if (result.data) {
			var data = result.data;
			if (data.length > 0) {
				var html = "";
				for (var i = 0; i < data.length; i++) {
					
					html += "<option value='" + data[i].code + "'>"+ data[i].name + "</option>";
				}
				$("#area2Id").html(html);
				$("#area2Span").show();
				getArea3();
			}else{
				$("#area2Name").val("");
				$("#area3Name").val("");
				$("#area2Id").html("");
				$("#area2Span").hide();
			}
		}else {
			$("#area2Name").val("");
			$("#area3Name").val("");
			$("#area2Id").html("");
			$("#area2Span").hide();
		}
	}, "json");
}

// 获得乡、镇、街道
function getArea3() {
	var area2Id = $("#area2Id option:selected").val();
	var area2Name= $("#area2Id option:selected").html();
	$("#area3Name").val("");
	$("#area2Name").val(area2Name);
	jQuery.get("/area/load_JD_Area_by_parent_id/" + area2Id, null, function(result) {
		if (result.data && result.data.length > 0) { 
			var data = result.data;
			var html = "";
			for (var i = 0; i < data.length; i++) {
				html += "<option value='" + data[i].code + "'>"
						+ data[i].name + "</option>";
			}
			$("#area3Id").html(html);
			$("#area3Span").show();
		} else {
			$("#area3Name").val("");
			$("#area3Id").html("");
			$("#area3Span").hide();
		}
	}, "json");
}
//获得乡、镇、街道
function getArea4(){
	var area3Name= $("#area3Id option:selected").html();
	$("#area3Name").val(area3Name);
}
function updateLeixingString(){
	var leixingstring= $("#leixing option:selected").html();
	$("#leixingstring").val(leixingstring);
}

function createOptionHtml(areas, areaId, areaSelId, areaSpanId) {
	var html = "";
	if(areas && areas.length > 0) {
		for (var i = 0; i < areas.length; i++) {
			/*if(areas[i].name == "新疆" || areas[i].name == "西藏"){
				continue;
			}*/
			
			if (areaId == areas[i].code) {
				html += "<option value='" + areas[i].code + "' selected='selected'>" + areas[i].name + "</option>";
			} else {
				html += "<option value='" + areas[i].code + "'>"
					+ areas[i].name + "</option>";
			}
		}
		$("#" + areaSelId).html(html);
		$("#" + areaSpanId).show();
	}else{
		$(areaSelId).html("");
		$(areaSpanId).hide();
	}
}

function clearOptionHtml() {
	$("#areaId").html("");
	$("#area1Id").html("");
	$("#area2Span").hide();
	$("#area3Span").hide();
}

//验证正则表达式
var validateRegExp = {
	mobile : "^0?(13|15|18|14|17)[0-9]{9}$",
	customerTel : "^[0-9\-()（）]{7,18}$",
};

var validateRules = {
isMobile : function(str) {
	return new RegExp(validateRegExp.mobile).test(str);
},
isCustomerTel : function(str) {
	return new RegExp(validateRegExp.customerTel).test(str);
}
	};
function saveMyAddress(){
	var address = $.trim($("#addressTemp").val());
	if (address==''){
		alert("详细地址不能为空!");
		return;
	}
	if(address.length>50) {
		alert("详细地址过长,请重新输入！");
		return;
	}

	var contacts = $.trim($("#contacts").val());
	if (contacts==''){
		alert("收货人不能为空!");
		return;
	}
	
	if(/[^\w\u4E00-\u9FA5]/g.test(contacts)){
		alert("姓名中存在非法字符！");
		return;
	}
	
	var mobile = $.trim($("#mobile").val());
	if (mobile==''){
		alert("手机号码不能为空!");
		return;
	}
	if (!validateRules.isMobile(mobile)){
		alert("手机号不合法!");
		return;
	}
	
	var customerTel = $.trim($("#customerTel").val());
	if(customerTel != ''){
		if (!validateRules.isCustomerTel(customerTel)){
			alert("电话号码不合法!");
			return;
		}
	}
	
	$("#address").val($("#addressTemp").val());

	$.ajax({
		type: 'POST',
		url:  "/user/address/updateAddressForAjax",
		data: $("#saveMyAddressForm").serialize(),
		dataType:'json',
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert('系统出现错误，请稍候再试');
		},
		success:function(response){
			if(response.success){
				window.location.reload();
			}else{
				if(response.errorMessage == 'mobileNotValid'){
					alert("收货信息与绑定银行卡信息不一致");
				}else{
					alert(response.errorMessage);
				}
			}
		}
	})
}

function updateAddressUI(id){
	clearOptionHtml();
	jQuery.get("/user/address/updateAddressUI", {id:id},
			function(result) {
				if (result.success == true) {
					var address = result.address;
					$("#addressTemp").val(address.address);
					$("#contacts").val(address.contacts);
					$("#customerTel").val(address.customerTel);
					$("#mobile").val(address.mobile);
	                $("#myAddressButton").val("修改");
	                $("#id").val(address.id);
	                
	                if(address.type) {
	                	$("#type").val(address.type);
	                }
	                
	                var areas = result.areas;
	    			createOptionHtml(areas, address.areaId, "areaId", "areaId");
	    			
	    			var area1s = result.area1s;
	    			createOptionHtml(area1s, address.area1Id, "area1Id", "area1Id");
	    			
	    			var area2s = result.area2s;
	    			createOptionHtml(area2s, address.area2Id, "area2Id", "area2Span");
	    			
	    			var area3s = result.area3s;
	    			createOptionHtml(area3s, address.area3Id, "area3Id", "area3Span");
	    			
	                $("#saveMyAddressForm").show();
				}
			}, "json");
}

$(function(){
	getArea();
});

function checkField(textId, errorTextId, errorContent){
	if($.trim($("#"+textId).val()) == ""){
		$("#"+errorTextId).css("color", "#c00");
		$("#"+errorTextId).text(errorContent);
	}
}
function clearErrorCheck(errorTextId){
	//$("#detailAddrError").css("color", "#444");
	$("#"+errorTextId).text("")
}
