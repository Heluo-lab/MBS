//点击上边登录.register-txt1跳转到登录界面

/*//点击.articles梦芭莎注册条款,父级兄弟.deal去掉类名.hide
$('.articles').click(function(){
	$(this).parent('.tick_txt').siblings('.deal').removeClass('.hide');
});*/

//公共的前缀
var URL ='http://www.wjian.top/shop/';

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
//验证码输入框聚焦时无默认颜色
$('.i_text_checkcode').focus(function(){
	$(this).css('outline', 'none');
});
//动态验证输入框无默认颜色
$('.code_i_text').focus(function(){
	$(this).css('outline', 'none');
});

//失焦事件
//注册账号输入框失焦时判断
$('#txtRegisterID').blur(function(){
	//获取注册账号输入框填的值
	var registerid =$(this).val().trim();
	//输入框为空时
	if (registerid =='') {
		//注册账号输入框#txtRegisterID添加类.i_text_error，边框为红色
		$(this).addClass('i_text_error');
		//提示内容#txtRegisterIDTip邮箱/手机号/会员卡号不能为空,文本解释添加类.f-explain
		$('#txtRegisterIDTip').addClass('f_explain').html('邮箱/手机号不能为空');
		//设置不能注册
        isUser = false;
		return;
	}
	//用户名格式匹配
	var re =/^[a-z0-9_]{3,20}/g;
	if (!re.test(registerid)) {
		//文本解释
		$('#txtRegisterIDTip').addClass('f_explain').html('用户名格式错误,必须为3-20位数字字母下划线');
		//注册账号输入框#txtLoginID添加类.i_text_error，边框为红色
		$(this).addClass('i_text_error');
		//设置不能注册
        isUser = false;
		return;
	}
	//用户名格式正确，但是后台已存在
    $.post(URL +'api_user.php', {'status':'check','username':registerid},function(re){
    	var obj =JSON.parse(re);
    	//用户存在
    	if (obj.code ==2001) {
    		//文本解释
			$('#txtRegisterIDTip').addClass('f_explain').html('账号已存在');
			//注册账号输入框#txtLoginID添加类.i_text_error，边框为红色
			$(this).addClass('i_text_error');
			//设置不能注册
            isUser = false;
			return;
    	}else{
    		//注册账号输入框#txtRegisterID去掉类.i_text_error
			$(this).removeClass('i_text_error');
			//文本解释去掉类.f-explain
			$('#txtRegisterIDTip').removeClass('f_explain').html('');
			//设置能注册
            isUser = true;
    	}
    });
});

//验证码输入框失去焦点
$('.i_text_checkcode').blur(function(){
	//获取验证码输入框填的值
	var checkcode =$(this).val();
	//输入框为空时
	if (checkcode =='') {
		//验证码输入框.i_text_checkcode添加类.i_text_error
		$(this).addClass('i_text_error');
		//提示内容#member_register_codeTip验证码不能为空,文本解释添加类.f-explain
		$('#member_register_codeTip').addClass('f_explain').html('请输入验证码');
		//设置不能注册
        isCode = false;
		return;
	}
	//验证码不是四位
	if (checkcode.length != 4) {
		//验证码输入框.i_text_checkcode添加类.i_text_error
		$(this).addClass('i_text_error');
		//提示内容#member_login_codeTip请输入四位验证码,文本解释添加类.f-explain
		$('#member_register_codeTip').addClass('f_explain').html('请输入四位验证码');
		//设置不能注册
        isCode = false;
		return;
		}
	//输入四位验证码错误
	if (checkcode.length == 4 && checkcode !='WDGF') {
		//验证码输入框.i_text_checkcode添加类.i_text_error
		$(this).addClass('i_text_error');
		//文本解释添加类.f-explain，提示内容请输入正确的验证码
		$('#member_register_codeTip').addClass('f_explain').html('请输入正确的验证码');
		//设置不能注册
        isCode = false;
		return;
	}
	if (checkcode =='WDGF') {
		//验证码输入框.i_text_checkcode去掉类.i_text_error
		$(this).removeClass('i_text_error');
		//文本解释去掉类.f-explain
		$('#member_register_codeTip').removeClass('f_explain').html('');
		//设置能注册
        isCode = true;
		return;
	}
});

//动态验证码输入框失焦事件
$('.code_i_text').blur(function(){
	//获取动态验证码输入框的值
	var dyncode =$(this).val().trim();
	//输入框为空时
	if (dyncode =='') {
		//动态验证码输入框.code_i_text添加类.i_text_error
		$(this).addClass('i_text_error');
		//提示内容#mtxtCodeTip请输入动态验证码,文本解释添加类.f-explain
		$('#txtCodeTip').addClass('f_explain').html('请输入动态验证码');
		return;
	}
	//动态验证码输入框.code_i_text去掉类.i_text_error
	$(this).removeClass('i_text_error');
	//提示内容#mtxtCodeTip请输入动态验证码,文本解释添加类.f-explain
	$('#txtCodeTip').removeClass('f_explain').html('');
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
		$('#txtRegisterPwdTip').addClass('f_explain').html('请输入6-20位数字');
		//去掉正确图标
		$('#txtRegisterPwdCorrent').removeClass('i_correct');
		//设置不能注册
        isPwd = false;
		return;
	}
	//输入格式错误
	//6-20位数字  定正则
    var re = /^[0-9]{6,20}$/g;
	if (registerpwd !='' && !re.test(registerpwd)) {
		//密码输入框#txtRegisterPwd添加类.i_text_error
		$(this).addClass('i_text_error');
		//文本解释添加类.f-explain,
		$('#txtRegisterPwdTip').addClass('f_explain').html('密码设置错误，请输入6-20位数字');
		//去掉正确图标
		$('#txtRegisterPwdCorrent').removeClass('i_correct');
		//设置不能注册
        isPwd = false;
		return;
		}

//输入正确
//	alert(re.test(registerpwd));
//	if (re.test(registerpwd)) {
		//密码输入框#txtRegisterPwd去掉类.i_text_error
		$(this).removeClass('i_text_error');
		//文本解释去掉类.f-explain
		$('#txtRegisterPwdTip').removeClass('f_explain').html('');
		//加上正确图标
		$('#txtRegisterPwdCorrent').addClass('i_correct');
		//设置能注册
        isPwd = true;
//		return;
//	}
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
		$('#ttxtConfirmPwdCorrent').removeClass('i_correct');
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


 //点击注册
$('.reg_btn').click(function(){
	//获取注册账号输入框填的值
	var registerid =$('#txtRegisterID').val().trim();
	//获取密码输入框填的值
	var registerpwd =$('#txtRegisterPwd').val();
	//点击注册按钮时候看所有项都为true才能请求后台
	if(isUser == false || isPwd == false || isConfirmPwd ==false || isCode ==false){
	  return;
	};
	console.log('可以注册了')
	//请求注册之前查看每项都OK发起请求
	$.post(URL + 'api_user.php', {
	  status : 'register',
	  username : registerid,
	  password : registerpwd
	}, function(re){
	  var obj = JSON.parse(re);
	  console.log(obj);
	  //验证
	  if(obj.code == 2001){
	  //文本解释
		$('#txtRegisterIDTip').addClass('f_explain').html('账号已存在');
		//注册账号输入框#txtLoginID添加类.i_text_error，边框为红色
		$('#txtRegisterID').addClass('i_text_error');
	    //设置不能注册
	    isUser = false;
	    return;
	  };
	  
	  if(obj.code != 0){return;}
	  //注册成功 把文本框清空,设置不能注册
	  $('.i_text').val('');    
	  $('.code_i_text').val('');
	  $('.i_text_checkcode').val('');
	  isUser = false;
	  isPwd = false;
	  //跳转到登录页面
	  alert('注册成功，2秒之后跳转登录页面');
	  setTimeout(function(){
	    //跳转到登录页面
	    window.location.href = 'login.html';
	      },2000);
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