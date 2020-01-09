//用于判断注册按钮是否可用
var isName =false;
var isUser = false;
var isPwd = false;
var isCode =false;
var isConfirmPwd =false;

//动态按钮无默认边框
$('.i_btn_getCode').click(function(){
	$(this).css('outline', 'none');
});
//动态按钮按下无默认边框
$('.i_btn_getCode').mousedown(function(){
	$(this).css('outline', 'none');
});
//注册按钮无默认边框
$('.i_btn_ok').click(function(){
	$(this).css('outline', 'none');
});
//注册按钮按下无默认边框
$('.i_btn_ok').mousedown(function(){
	$(this).css('outline', 'none');
});


//所有输入框聚焦时无默认颜色
//聚焦时无文本解释
$('.i_text').each(function(i){
	$(this).focus(function(){
		$(this).css('outline', 'none');
	})
});
//动态验证输入框无默认颜色
$('.code_i_text').focus(function(){
	$(this).css('outline', 'none');
});

//失焦事件
//注册昵称输入框失焦时判断
$('#txtRegisterName').blur(function(){
	//获取昵称账号输入框填的值
	var registername =$(this).val().trim();
	//输入框为空时
	if (registername =='') {
		//注册昵称输入框#txtRegisterName添加类.i_text_error，边框为红色
		$(this).addClass('i_text_error');
		//提示内容#txtRegisterNameTip昵称不能为空,文本解释添加类.f-explain
		$('#txtRegisterNameTip').addClass('f_explain').html('昵称不能为空');
		//设置不能注册
        isName = false;
		return;
	}
	//昵称格式匹配
	var re =/^[a-z0-9A-Z\u4e00-\u9fa5]+$/g;
	if (!re.test(registername)) {
		//文本解释
		$('#txtRegisterNameTip').addClass('f_explain').html('昵称格式错误,必须为数字或字母或中文');
		//注册账号输入框#txtLoginID添加类.i_text_error，边框为红色
		$(this).addClass('i_text_error');
		//设置不能注册
        isName = false;
		return;
	}
	//昵称格式正确，但是后台已存在
	registername =encodeURI(encodeURI(registername));
    $.post('accountName', {'registername':registername},function(result){
    	//昵称存在
    	if (result==true) {
    		//文本解释
			$('#txtRegisterNameTip').addClass('f_explain').html('昵称已存在');
			//注册昵称输入框#txtLoginName添加类.i_text_error，边框为红色
			$('#txtRegisterName').addClass('i_text_error');
			//设置不能注册
            isName = false;
			return;
    	}else{
    		//注册昵称输入框#txtRegisterName去掉类.i_text_error
			$('#txtRegisterName').removeClass('i_text_error');
			//文本解释去掉类.f-explain
			$('#txtRegisterNameTip').removeClass('f_explain').html('');
			//设置能注册
            isName = true;
            return;
    	}
    });
});
//注册邮箱输入框失焦时判断
$('#txtRegisterID').blur(function(){
	//获取注册邮箱输入框填的值
	var registerid =$(this).val().trim();
	//输入框为空时
	if (registerid =='') {
		//注册账号输入框#txtRegisterID添加类.i_text_error，边框为红色
		$(this).addClass('i_text_error');
		//提示内容#txtRegisterIDTip邮箱/手机号/会员卡号不能为空,文本解释添加类.f-explain
		$('#txtRegisterIDTip').addClass('f_explain').html('邮箱不能为空');
		//设置不能注册
        isUser = false;
		return;
	}
	//邮箱格式匹配
	var re =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/g;
	if (!re.test(registerid)) {
		//文本解释
		$('#txtRegisterIDTip').addClass('f_explain').html('邮箱格式错误');
		//注册账号输入框#txtLoginID添加类.i_text_error，边框为红色
		$(this).addClass('i_text_error');
		//设置不能注册
        isUser = false;
		return;
	}
	//邮箱格式正确，但是后台已存在
	registerid =encodeURI(encodeURI(registerid));
    $.post('accountEmail', {'registerid':registerid},function(result){
    	//用户存在
    	if (result==true) {
    		//文本解释
			$('#txtRegisterIDTip').addClass('f_explain').html('该邮箱已注册');
			//注册邮箱输入框#txtLoginID添加类.i_text_error，边框为红色
			$('#txtRegisterID').addClass('i_text_error');
			//设置不能注册
            isUser = false;
			return;
    	}else{
    		//注册邮箱输入框#txtRegisterID去掉类.i_text_error
			$('#txtRegisterID').removeClass('i_text_error');
			//文本解释去掉类.f-explain
			$('#txtRegisterIDTip').removeClass('f_explain').html('');
			//设置能注册
            isUser = true;
            return;
    	}
    });
});


//动态验证码输入框失焦事件
$('#txtCode').blur(function(){
	//获取动态验证码输入框的值
	var registercode =$(this).val().trim();
	//输入框为空时
	if (registercode =='') {
		//动态验证码输入框#txtCode添加类.i_text_error
		$(this).addClass('i_text_error');
		//提示内容#mtxtCodeTip请输入动态验证码,文本解释添加类.f-explain
		$('#txtCodeTip').addClass('f_explain').html('请输入动态验证码');
		//设置不能注册
		isCode =false;
		return;
	}
	if (registercode.length !=4) {
		//动态验证码输入框#txtCode添加类.i_text_error
		$(this).addClass('i_text_error');
		//提示内容#mtxtCodeTip请输入动态验证码,文本解释添加类.f-explain
		$('#txtCodeTip').addClass('f_explain').html('请输入四位验证码');
		//设置不能注册
		isCode =false;
		return;
	}
	//动态验证码输入框.code_i_text去掉类.i_text_error
	$(this).removeClass('i_text_error');
	//提示内容#mtxtCodeTip请输入动态验证码,文本解释添加类.f-explain
	$('#txtCodeTip').removeClass('f_explain').html('');
	isCode =true;
});
	
//密码输入框失焦事件
$('#txtRegisterPwd').blur(function(){
	//获取密码输入框填的值
	var registerpwd =$(this).val();
	//输入框为空时
	if (registerpwd =='') {
		//密码输入框#txtRegisterPwd添加类.i_text_error
		$(this).addClass('i_text_error');
		//提示内容#txtRegisterPwdTip密码不能为空,文本解释添加类.f-explain
		$('#txtRegisterPwdTip').addClass('f_explain').html('请输入8-20位数字和字母,区分大小写');
		//去掉强弱程度图片
		$('#txtRegisterPwdTip').removeChild('.pwd_level');
		//去掉正确图标
		$('#txtRegisterPwdCorrent').removeClass('i_correct');
		//设置不能注册
        isPwd = false;
		return;
	}
	//输入格式错误
	//8-20位数字和字母  定正则
    var re = /^[a-z0-9A-Z]{8,20}$/g;
	if (registerpwd !='' && !re.test(registerpwd)) {
		//密码输入框#txtRegisterPwd添加类.i_text_error
		$(this).addClass('i_text_error');
		//文本解释添加类.f-explain,
		$('#txtRegisterPwdTip').addClass('f_explain').html('请输入8-20位数字和字母,区分大小写');
		//去掉正确图标
		$('#txtRegisterPwdCorrent').removeClass('i_correct');
		//设置不能注册
        isPwd = false;
		return;
	}

	//输入正确
	//密码程度判断
	//密码为单个样式，且为8位,弱
    var re_weak =/^(([a-z]{8,10}$)|([A-Z]{8,10}$)|([0-9]{8,10}$))/g;
    if (re_weak.test(registerpwd)) {
    	//密码输入框#txtRegisterPwd去掉类.i_text_error
		$(this).removeClass('i_text_error');
		//文本解释去掉类.f-explain
		$('#txtRegisterPwdTip').removeClass('f_explain').html('');
		//#txtRegisterPwdTip添加儿子.pwd_weak图标
		$('#txtRegisterPwdTip').append("<div class='pwd_level pwd_weak'></div>");
		//增加正确图标
		$('#txtRegisterPwdCorrent').addClass('i_correct');
		isPwd = true;
		return;
    }
    var re_middle =/^(([a-z]{11,20}$)|([A-Z]{11,20}$)|([0-9]{11,20}$))/g
     if (re_middle.test(registerpwd)) {
    	//密码输入框#txtRegisterPwd去掉类.i_text_error
		$(this).removeClass('i_text_error');
		//文本解释去掉类.f-explain
		$('#txtRegisterPwdTip').removeClass('f_explain').html('');
		//#txtRegisterPwdTip添加儿子.pwd_middle图标
		$('#txtRegisterPwdTip').append("<div class='pwd_level pwd_middle'></div>");
		//增加正确图标
		$('#txtRegisterPwdCorrent').addClass('i_correct');
		isPwd = true;
		return;
    }
	//密码输入框#txtRegisterPwd去掉类.i_text_error
	$(this).removeClass('i_text_error');
	//文本解释去掉类.f-explain
	$('#txtRegisterPwdTip').removeClass('f_explain').html('');
	//#txtRegisterPwdTip添加儿子.pwd_strong图标
	$('#txtRegisterPwdTip').append("<div class='pwd_level pwd_strong'></div>")
	//增加正确图标
	$('#txtRegisterPwdCorrent').addClass('i_correct');
	//设置能注册
    isPwd = true;
});

//再次输入密码输入框失焦事件
$('#txtConfirmPwd').blur(function(){
	//获取确认密码输入框填的值
	var confirmpwd =$(this).val();
	//获取密码输入框填的值
	var registerpwd =$('#txtRegisterPwd').val();
	//输入框为空时
	if (confirmpwd =='') {
		//确认密码输入框#txtConfirmPwd添加类.i_text_error
		$(this).addClass('i_text_error');
		//提示内容#txtConfirmPwdTip请再次输入密码,文本解释添加类.f-explain
		$('#txtConfirmPwdTip').addClass('f_explain').html('请再次输入密码');
		//去掉正确图标
		$('#txtConfirmPwdCorrent').removeClass('i_correct');
		//设置不能注册
        isConfirmPwd = false;
		return;
	}
	//确认密码与密码输入错误
	if (registerpwd !=confirmpwd) {
		//确认密码输入框#txtConfirmPwd添加类.i_text_error
		$(this).addClass('i_text_error');
		//文本解释添加类.f-explain,两次输入的密码不一致
		$('#txtConfirmPwdTip').addClass('f_explain').html('两次输入的密码不一致');
		//去掉正确图标
		$('#txtConfirmPwdCorrent').removeClass('i_correct');
		//设置不能注册
        isConfirmPwd = false;
		return;
		}
	//输入正确
	if (registerpwd ==confirmpwd) {
		//确认密码输入框#txtConfirmPwd去掉类.i_text_error
		$(this).removeClass('i_text_error');
		//文本解释去掉类.f-explain
		$('#txtConfirmPwdTip').removeClass('f_explain').html('');
		//加上正确图标
		$('#txtConfirmPwdCorrent').addClass('i_correct');
		//设置不能注册
        isConfirmPwd = true;
		return;
	}
});
var t;
//点击事件
//点击获取动态验证码按钮
$('#getCode').click(function(){
	//如果邮箱输入框 isUser = true;，则.i_btn_getCode中value为正在发送...，且禁用
	if (isUser == true) {
		$(this).val('验证码正在发送...');
		$(this).attr('disabled', 'disabled');
		//该按钮手势为no-drop
		$(this).css('cursor','no-drop');
		//获取客户填入的邮箱值
		var email =$('#txtRegisterID').val().trim();
		//获取生成的邮箱验证码
		$.post('emailCode',{'email':email}, function(result){
			//获取#getCode中data-time的值
			var second =parseInt($('#getCode').attr('data-time'));
			//每隔一秒,属性为data-time的值就-1,减到0就停止
			t =setInterval(function(){
				second =second-1;
				//#getCode中data-time的值位second秒
				$('#getCode').attr("data-time", second);
				//#getCode中value为120秒后重新发送
				$('#getCode').val(second+'秒后重新发送');
				if (second==1) {
					//#getCode中value为获取动态验证码
					$('#getCode').val('获取动态验证码');
					//#getCode中data-time的值位120秒
					$('#getCode').attr('data-time','120');
					//#getCode可用
					$('#getCode').removeAttr('disabled');
					//该按钮手势cursor: pointer;
					$('#getCode').css('cursor','pointer');
					//清除定时器
					clearInterval(t);
				}
			},1000);
		});
	}
	else{
		return;
	}
});

 //点击注册
$('.reg_btn').click(function(){
	//#getCode中value为获取动态验证码
	$('#getCode').val('获取动态验证码');
	//#getCode中data-time的值位120秒
	$('#getCode').attr('data-time','120');
	//#getCode可用
	$('#getCode').removeAttr('disabled');
	//该按钮手势cursor: pointer;
	$('#getCode').css('cursor','pointer');
	//清除定时器
	clearInterval(t);
	//#registerMsg中display不可见
	  $('#registerMsg').css('display','none');
	//获取注册昵称输入框的值
	var registername =$('#txtRegisterName').val().trim();
	//获取注册邮箱输入框填的值
	var registerid =$('#txtRegisterID').val().trim();
	//获取密码输入框填的值
	var registerpwd =$('#txtRegisterPwd').val();
	//获取动态输入框填的值
	var registercode =$('#txtCode').val().trim();
	//获取用户创建时间
	//创建时间对象
	var date =new Date();
	//获取年
	var year =''+date.getFullYear();
	//获取月
	var month =date.getMonth()+1;
	//获取日
	var day =date.getDate();
	//添加0
	function addZero(n){
		return n<10 ? '0'+n :''+n;
	};
	var registerbirth =year+'-'+addZero(month)+'-'+addZero(day);
	//点击注册按钮时候看所有项都为true才能请求后台
	if(isName == false || isUser == false || isPwd == false || isConfirmPwd ==false || isCode ==false){
		return;
	};
	//请求注册之前查看每项都OK发起请求
	registername =encodeURI(encodeURI(registername));
	registerid =encodeURI(encodeURI(registerid));
	registerpwd =encodeURI(encodeURI(registerpwd));
	registercode =encodeURI(encodeURI(registercode));
	registerbirth =encodeURI(encodeURI(registerbirth));
	
	$.ajax({
	 type: 'post',
	 async :false,
	 url: 'registerBtn',
	 data:{
	  'registername' : registername,
	  'registerid' : registerid,
	  'registerpwd' : registerpwd,
	  'registercode' : registercode,
	  'registerbirth' : registerbirth
	  },  
	 success :function(result){
		  //验证码错误
		  if(result=='code'){
			//动态验证码输入框#txtCode添加类.i_text_error
			$('#txtCode').addClass('i_text_error');
			//提示内容#mtxtCodeTip请输入动态验证码,文本解释添加类.f-explain
			$('#txtCodeTip').addClass('f_explain').html('动态验证码错误！');
			//设置不能注册
			isCode =false;
			return;
		  };
		  if (result==false) {
			//#registerMsg中display可见
			  $('#registerMsg').css('display','block');
			  return;
		 }
		  if(result==true){
			  var loginemail =$('#txtRegisterID').val().trim();
			  //注册成功 把文本框清空,设置不能注册
			  $('#txtRegisterName').val('');    
			  $('#txtRegisterID').val('');
			  $('#txtCode').val('');
			  $('#txtRegisterPwd').val('');
			  $('#txtConfirmPwd').val('');
			  //去掉正确图标
			  $('#txtConfirmPwdCorrent').removeClass('i_correct');
			  $('#txtRegisterPwdCorrent').removeClass('i_correct');
			  //设置不能注册
			  isName == false
			  isUser = false;
			  isPwd = false;
			  isConfirmPwd ==false;
			  isCode ==false;
			  //跳转到登录页面
			  alert('注册成功，2秒之后跳转登录页面');
			//把用户名和token存到本地
			  localStorage.setItem('registerid', loginemail);
			  setTimeout(function(){
			    //跳转到登录页面
			    window.location.href = 'login.jsp';
			      },2000);
			  return;
		  	}
		 }
	 });
 });

//获得地址栏参数值
function getUrlVal(property){
	var urlStr =window.location.search.substring(1);
	var re =new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
	var result =urlStr.match(re);
	if (result == null) {return null};
	return result[2];
};