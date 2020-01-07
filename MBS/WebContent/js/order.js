//返回顶部
$('.backtotop').hover(function(){
	$('.backtotop img').attr('src','img/r10.jpg');
},function(){
	$('.backtotop img').attr('src','img/r5.jpg');
});
//选择地址信息
$(function() {
	var html = "";
	var province_idx;
	$("#input_city").append(html);
	
	$.each(cityMessage, function(idx, item) {
		if(item.parid == '1'){
		html += "<option value='" + item.regname + "' exid='" + item.regid + "'>" + item.regname + "</option>";
        }

	});
	$("#input_province").append(html);
	$("#input_province").change(function(e) {
		var province =$(this).val();
		var cityList = [];
		if(province == "") return;
		$("#input_city option").remove();
		var html = "<option value=''>--请选择--</option>";
		
//		获取已选择的省份的数组下标
		$.each(cityMessage, function(idx, item) {
			if(province == item.regname && item.parid == '1') {
				province_idx=idx
			}
		})
		
//		获取已选择的省份的城市列表
		$.each(cityMessage, function(idx, item) {
			if(cityMessage[idx].parid == cityMessage[province_idx].regid) {
				cityList.push(cityMessage[idx])
			}
		})
		
//		添加城市信息给标签
		if(cityList instanceof Array && cityList.length>0){
			$.each(cityList, function(idx, item) {
				html += "<option value='" + item.regname + "' exid='" + item.regid + "'>" + item.regname + "</option>";
				
			});
		}else{
			html += "<option value='" + cityMessage[province_idx].regname + "' exid='" + cityMessage[province_idx].regid + "'>" + cityMessage[province_idx].regname + "</option>";
				
		}
		$("#input_city").append(html);
	});
});

$(function(){
	//滚动时间
	$(window).scroll(function(){

		if($(this).scrollTop() > 100){
			$('.backtotop').fadeIn();
		}else{
			$('.backtotop').fadeOut();
		}
	});
	
	$('.backtotop ').click(function(){
		$('html,body').animate({scrollTop:0},0);
		return false;
	});
});

function Receivinggoods(receId,receName,recePhone,receAddressProv,receAddressCity,receAddressDetaile){
	this.receId = receId;
	this.receName = receName;
	this.recePhone = recePhone;
	this.receAddressProv = receAddressProv;
	this.receAddressCity = receAddressCity;
	this.receAddressDetaile = receAddressDetaile;
}
//更新地址
function submitAll(){
	
	var receivinggoods = new Receivinggoods($('#receId').val(),$('#receName').val(),$('#recePhone').val(),$('.receAddressProv').val(),$('.receAddressCity').val(),$('#receAddressDetaile').val());
	$.ajax({
  		  type:"post",
  		  url:"addreceivinggoods",
  		  data:"receivinggoods="+JSON.stringify(receivinggoods),
  		  success:function(result){
  			  var receivinggoods = JSON.parse(result);
  			  str=`
  				  ${receivinggoods.receName } ${receivinggoods.receAddressProv } ${receivinggoods.receAddressCity } ${receivinggoods.receAddressDetaile } ${receivinggoods.recePhone }
  			  `;
  			  $(".address").html(str);
  		  }
  	  });
}
//修改地址
function changeAddress(){
	$.ajax({
		  type:"post",
		  url:"changeaddress",
		  data:"count="+1,
		  success:function(result){
			  //按钮修改
			  $("#changeaddress").html("[取消修改]");
			  $("#changeaddress").attr("onclick","cancelChange()");
			  //内容修改
			  var receivinggoods = JSON.parse(result);
			  $(".address").empty();
			  $.each(receivinggoods,function(i,receivinggoods1){
				  var re = JSON.stringify(receivinggoods1);
				  if (receivinggoods1.isDefault==1) {
					str=`
						<div><input type="hidden" id="${receivinggoods1.receId}"/><input type="hidden" id='${re}'/><input type="radio" name="selectmsg" checked/>${receivinggoods1.receName } ${receivinggoods1.receAddressProv } ${receivinggoods1.receAddressCity } ${receivinggoods1.receAddressDetaile } ${receivinggoods1.recePhone }<a class="delete" href="javascript:;" style="text-decoration:none;float:right;margin-left:30px;" onclick="deleteAddress(this)">删除</a><a class="change" href="javascript:;" style="text-decoration:none;float:right;" onclick="changeAllMsg($(this).siblings().eq(1).attr('id'))">修改</a></div>
					`;
				}else{
					str=`
						<div><input type="hidden" id="${receivinggoods1.receId}"/><input type="radio" name="selectmsg"/>${receivinggoods1.receName } ${receivinggoods1.receAddressProv } ${receivinggoods1.receAddressCity } ${receivinggoods1.receAddressDetaile } ${receivinggoods1.recePhone }<a class="delete" href="javascript:;" style="text-decoration:none;float:right;margin-left:30px;" onclick="deleteAddress(this)">删除</a><a class="change" href="javascript:;" style="text-decoration:none;float:right;" onclick="changeAllMsg(this)">修改</a></div>
						`;
				}
				  $(".address").append(str);
			  });
			  str1=`
				  <a id="new" href="javascript:;" onclick="newAddress()" style="text-decoration:none;color: #EB0067;">新增收货地址</a>
			  `;
			  $(".address").append(str1);
			  $(function(){
				  $("input[type='radio']").click(function(){
				    var id= $(this).siblings(":first").attr("id");
				    changeDefault(id);
				  });
				});
		  }
	  });
}
//取消修改
function cancelChange(){
	$.ajax({
		  type:"post",
		  url:"cancelchange",
		  data:"count="+1,
		  success:function(result){
			  $("#changeaddress").html("[修改]");
			  $("#changeaddress").attr("onclick","changeAddress()");
			  var recegoods = JSON.parse(result);
			  str=`
				  ${recegoods.receName } ${recegoods.receAddressProv } ${recegoods.receAddressCity } ${recegoods.receAddressDetaile } ${recegoods.recePhone }
			  `;
			  $(".address").html(str);
		  }
	});
}
function newAddress(){
	var newa=`
		<form action="javascript:;" onsubmit="javascript:return submitCurrent();" id="allrecemsg">
		<input type="hidden" id="receId" value="${obj.receId}"/>
		<div class="receiver">收货人：<input type="text" id="receName" class="recemsg" placeholder="请输入姓名"/></div>
		<div class="selectArea">
		<div class="province">
		选择地区：<select class="receAddressProv" id="input_province">
		<option value="">--请选择省份--</option>
		</select>
		</div>
		<div class="city">
		<select class="receAddressCity" id="input_city">
		<option value="">--请选择城市--</option>
		</select>
		</div>
		</div>
		<div class="detaile">详细地址：<input type="text" id="receAddressDetaile" class="recemsg" placeholder="请输入详细地址"/></div>
		<div class="addphone">电话：<input type="text" id="recePhone" class="recemsg" placeholder="请输入电话"/></div>
		<input type="submit" class="submitaddress" value="确定"/>
		</form>
	`;
	$(".address").append(newa);
	$(function() {
		var html = "";
		var province_idx;
		$("#input_city").append(html);
		
		$.each(cityMessage, function(idx, item) {
			if(item.parid == '1'){
			html += "<option value='" + item.regname + "' exid='" + item.regid + "'>" + item.regname + "</option>";
	        }

		});
		$("#input_province").append(html);
		$("#input_province").change(function(e) {
			var province =$(this).val();
			var cityList = [];
			if(province == "") return;
			$("#input_city option").remove();
			var html = "<option value=''>--请选择--</option>";
			
//			获取已选择的省份的数组下标
			$.each(cityMessage, function(idx, item) {
				if(province == item.regname && item.parid == '1') {
					province_idx=idx
				}
			})
			
//			获取已选择的省份的城市列表
			$.each(cityMessage, function(idx, item) {
				if(cityMessage[idx].parid == cityMessage[province_idx].regid) {
					cityList.push(cityMessage[idx])
				}
			})
			
//			添加城市信息给标签
			if(cityList instanceof Array && cityList.length>0){
				$.each(cityList, function(idx, item) {
					html += "<option value='" + item.regname + "' exid='" + item.regid + "'>" + item.regname + "</option>";
					
				});
			}else{
				html += "<option value='" + cityMessage[province_idx].regname + "' exid='" + cityMessage[province_idx].regid + "'>" + cityMessage[province_idx].regname + "</option>";
					
			}
			$("#input_city").append(html);
		});
	});
}
function submitCurrent(){
	var receivinggoods = new Receivinggoods($('#receId').val(),$('#receName').val(),$('#recePhone').val(),$('.receAddressProv').val(),$('.receAddressCity').val(),$('#receAddressDetaile').val());
	console.log(JSON.stringify(receivinggoods));
	$.ajax({
  		  type:"post",
  		  url:"newaddress",
  		  data:"receivinggoods="+JSON.stringify(receivinggoods),
  		  success:function(result){
  			  var receivinggoods = JSON.parse(result);
			  $(".address").empty();
			  $.each(receivinggoods,function(i,receivinggoods1){
				  if (receivinggoods1.isDefault==1) {
						str=`
							<div><input type="hidden" id="${receivinggoods1.receId}"/><input type="radio" name="selectmsg" checked/>${receivinggoods1.receName } ${receivinggoods1.receAddressProv } ${receivinggoods1.receAddressCity } ${receivinggoods1.receAddressDetaile } ${receivinggoods1.recePhone }<a class="delete" href="javascript:;" style="text-decoration:none;float:right;margin-left:30px;" onclick="deleteAddress(this)">删除</a><a class="change" href="javascript:;" style="text-decoration:none;float:right;" onclick="changeAllMsg(re)">修改</a></div>
						`;
					}else{
						str=`
							<div><input type="hidden" id="${receivinggoods1.receId}"/><input type="radio" name="selectmsg"/>${receivinggoods1.receName } ${receivinggoods1.receAddressProv } ${receivinggoods1.receAddressCity } ${receivinggoods1.receAddressDetaile } ${receivinggoods1.recePhone }<a class="delete" href="javascript:;" style="text-decoration:none;float:right;margin-left:30px;" onclick="deleteAddress(this)">删除</a><a class="change" href="javascript:;" style="text-decoration:none;float:right;" onclick="changeAllMsg(re)">修改</a></div>
							`;
					}
					  $(".address").append(str);
				  });
			  str1=`
				  <a id="new" href="javascript:;" onclick="newAddress()" style="text-decoration:none;color: #EB0067;">新增收货地址</a>
			  `;
			  $(".address").append(str1);
			  $(function(){
				  $("input[type='radio']").click(function(){
				    var id= $(this).siblings(":first").attr("id");
				    changeDefault(id);
				  });
				});  
  		  }
	});
}
function deleteAddress(o){
	var obj = $(o).parent();
	var receId = $(o).siblings(":first").attr("id");
	$.ajax({
		  type:"post",
		  url:"deleteaddress",
		  data:"receId="+receId,
		  success:function(result){
			  if(!confirm("你确定提交吗？")){
					return;
				}
			  obj.remove();
		  }
	});
}
function changeDefault(receId){
	$.ajax({
		type:"post",
		  url:"changedefault",
		  data:"receId="+receId,
		  success:function(result){
			  console.log("success");
		  }
	});
}
function changeAllMsg(obj){
	var obj = JSON.parse(obj);
	var str = `
		<form action="javascript:;" onsubmit="javascript:return updateAddress();" id="allrecemsg">
		<input type="hidden" id="receId" value="${obj.receId}"/>
		<div class="receiver">收货人：<input type="text" id="receName" class="recemsg" placeholder="请输入姓名" value="${obj.receName}"/></div>
		<div class="selectArea">
		<div class="province">
		选择地区：<select class="receAddressProv" id="input_province">
		<option value="">${obj.receAddressProv}</option>
		</select>
		</div>
		<div class="city">
		<select class="receAddressCity" id="input_city">
		<option value="">${obj.receAddressCity}</option>
		</select>
		</div>
		</div>
		<div class="detaile">详细地址：<input type="text" id="receAddressDetaile" class="recemsg" placeholder="请输入详细地址" value="${obj.receAddressDetaile}"/></div>
		<div class="addphone">电话：<input type="text" id="recePhone" class="recemsg" placeholder="请输入电话" value="${obj.recePhone}"/></div>
		<input type="submit" class="submitaddress" value="确定"/>
		</form>
	`;
	$(".address").append(str);
	$(function() {
		var html = "";
		var province_idx;
		$("#input_city").append(html);
		
		$.each(cityMessage, function(idx, item) {
			if(item.parid == '1'){
			html += "<option value='" + item.regname + "' exid='" + item.regid + "'>" + item.regname + "</option>";
	        }

		});
		$("#input_province").append(html);
		$("#input_province").change(function(e) {
			var province =$(this).val();
			var cityList = [];
			if(province == "") return;
			$("#input_city option").remove();
			var html = "<option value=''>--请选择--</option>";
			
//			获取已选择的省份的数组下标
			$.each(cityMessage, function(idx, item) {
				if(province == item.regname && item.parid == '1') {
					province_idx=idx
				}
			})
			
//			获取已选择的省份的城市列表
			$.each(cityMessage, function(idx, item) {
				if(cityMessage[idx].parid == cityMessage[province_idx].regid) {
					cityList.push(cityMessage[idx])
				}
			})
			
//			添加城市信息给标签
			if(cityList instanceof Array && cityList.length>0){
				$.each(cityList, function(idx, item) {
					html += "<option value='" + item.regname + "' exid='" + item.regid + "'>" + item.regname + "</option>";
					
				});
			}else{
				html += "<option value='" + cityMessage[province_idx].regname + "' exid='" + cityMessage[province_idx].regid + "'>" + cityMessage[province_idx].regname + "</option>";
					
			}
			$("#input_city").append(html);
		});
	});
}
function updateAddress(){
	var receivinggoods = new Receivinggoods($('#receId').val(),$('#receName').val(),$('#recePhone').val(),$('.receAddressProv').val(),$('.receAddressCity').val(),$('#receAddressDetaile').val());
	console.log(JSON.stringify(receivinggoods));
	$.ajax({
  		  type:"post",
  		  url:"updateaddress",
  		  data:"receivinggoods="+JSON.stringify(receivinggoods),
  		  success:function(result){
  			  var receivinggoods = JSON.parse(result);
			  $(".address").empty();
			  $.each(receivinggoods,function(i,receivinggoods1){
				  if (receivinggoods1.isDefault==1) {
						str=`
							<div><input type="hidden" id="${receivinggoods1.receId}"/><input type="radio" name="selectmsg" checked/>${receivinggoods1.receName } ${receivinggoods1.receAddressProv } ${receivinggoods1.receAddressCity } ${receivinggoods1.receAddressDetaile } ${receivinggoods1.recePhone }<a class="delete" href="javascript:;" style="text-decoration:none;float:right;margin-left:30px;" onclick="deleteAddress(this)">删除</a><a class="change" href="javascript:;" style="text-decoration:none;float:right;" onclick="changeAllMsg(re)">修改</a></div>
						`;
					}else{
						str=`
							<div><input type="hidden" id="${receivinggoods1.receId}"/><input type="radio" name="selectmsg"/>${receivinggoods1.receName } ${receivinggoods1.receAddressProv } ${receivinggoods1.receAddressCity } ${receivinggoods1.receAddressDetaile } ${receivinggoods1.recePhone }<a class="delete" href="javascript:;" style="text-decoration:none;float:right;margin-left:30px;" onclick="deleteAddress(this)">删除</a><a class="change" href="javascript:;" style="text-decoration:none;float:right;" onclick="changeAllMsg(re)">修改</a></div>
							`;
					}
					  $(".address").append(str);
				  });
			  str1=`
				  <a id="new" href="javascript:;" onclick="newAddress()" style="text-decoration:none;color: #EB0067;">新增收货地址</a>
			  `;
			  $(".address").append(str1);
			  $(function(){
				  $("input[type='radio']").click(function(){
				    var id= $(this).siblings(":first").attr("id");
				    changeDefault(id);
				  });
				});  
  		  }
	});
}