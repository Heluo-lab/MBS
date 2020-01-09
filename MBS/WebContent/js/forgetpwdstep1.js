//刷新页面，错误提示无#nextMsg.html(''),框也去掉
//$(function(){
//	$('#nextMsg').html('');
//	$('#nextMsg').css('border','0');
//});

//聚焦事件
//所有输入框聚焦时无默认颜色
//邮箱输入框聚焦事件
$('.i_text').focus(function(){
	$(this).css('outline', 'none');
});
//验证码输入框聚焦事件
$('.i_text_checkcode').focus(function(){
	$(this).css('outline', 'none');
});
//下一步#btnnext按钮聚焦事件
$('#btnnext').focus(function(){
	$(this).css('outline', 'none');
});
//取消#btncancel聚焦事件
$('#btncancel').focus(function(){
	$(this).css('outline', 'none');
});


//失焦事件
//邮箱输入框失焦时判断
$('.i_text').blur(function(){
	//获取邮箱输入框填的值
	var email =$(this).val().trim();
	//输入框为空时
	if (email =='') {
		//邮箱输入框'.i_text'添加类.i_text_error，边框为红色
		$(this).addClass('i_text_error');
		//提示内容#emailTip邮箱/手机号/会员卡号不能为空,文本解释添加类.f-explain
		$('#emailTip').addClass('f_explain').html('邮箱不能为空');
		//去掉正确图标
		$('#emailCorrent').removeClass('i_correct');
		return;
	}
	//获取的值与邮箱、手机号、会员卡号正则匹配
	//邮箱正则表达式
	var mail =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/g;
	if (!mail.test(email)) {
		//账号输入框。i_text添加类.i_text_error，边框为红色
		$(this).addClass('i_text_error');
		//账号输入错误时#emailTip邮箱/手机号/会员卡号错误，
		//请重新输入, 文本解释添加类.f-explain
		$('#emailTip').addClass('f_explain').html('邮箱输入错误,请重新输入');
		//去掉正确图标
		$('#emailCorrent').removeClass('i_correct');
		return;
	}
	//输入正确则去掉文本解释，加上正确图标
	//if (mail.test(email)) {
		//邮箱输入框.i_text添加类.i_text_error
		$(this).removeClass('i_text_error');
		//文本解释去掉类.f-explain
		$('#emailTip').removeClass('f_explain').html('');
		//加上正确图标
		$('#emailCorrent').addClass('i_correct');
		return;
	//}
});



//点击事件
//点击.checkcode-link换一张,刷新.code_img验证码
$('.checkcode-link').click(function(){
	$('.code_img').attr("src","codeImage?d="+new Date().getTime());
}); 
//点击#container图片部分,刷新.code_img验证码
$('.code_img').click(function(){
	$('.code_img').attr("src","codeImage?d="+new Date().getTime());
}); 
//点击取消#btncancel回到登录界面
$('#btncancel').click(function(){
	location.href = 'login.jsp'; 
});
/*//点击下一步#btnnext到forgetpwdstep2.jsp，
$('#btnnext').click(function(){
	location.href = 'forgetpwdstep2'; 
});*/
  
	

	
