//点击事件
//点击无密码登录时
$('.login-txt2').click(function(){
	$('.login_scan_click').css('display', 'block');
	/*文本添加类login-active,横线添加display为inline*/
	$(this).addClass('login-active').children().css('display', 'inline');
	/*普通登录去掉类login-active,横线改display为none*/
	$(this).siblings('.login-txt1').removeClass('login-active').children().css('display', 'none');
	/*无密码输入部分可见.input_block_2中display*/
	$('.input_block_2').css('display', 'block');
	/*验证部分可见.code中display*/
	/*$('.code').css('display', 'block');*/
	/*动态口令可见input_block_2.dymatic中display*/
	$('.input_block_2.dymatic').css('display', 'block');
	/*普通登录输入部分不可见.input_block_1中display*/
	$('.input_block_1').css('display', 'none')
});

/*点击普通登录时*/
$('.login-txt1').click(function(){
	$('.login_scan_click').css('display', 'block');
	/*文本添加类login-active,横线添加display为block*/
	$(this).addClass('login-active').children().css('display', 'block');
	/*普通登录去掉类login-active,横线改display为none*/
	$(this).siblings('.login-txt2').removeClass('login-active').children().css('display', 'none');
	/*普通登录输入部分可见.input_block_1中display*/
	$('.input_block_1').css('display', 'block');
	/*无密码输入部分不可见.input_block_2中display*/
	$('.input_block_2').css('display', 'none');
	/*动态口令不可见input_block_2.dymatic中display*/
	$('.input_block_2.dymatic').css('display', 'none')
});

//二维码扫描登录点击.login_scan_click
$('.login_scan_click').click(function(){
	$(this).css('display', 'none');
	//二维码扫描登录块出现.login_scan中display
	$('.login_scan').css('display', 'block');
	//失效图片#imgscanfailure和文字不出现.login_code_lose中display为none
	$('#imgscanfailure').css('display', 'none');
	$('.login_code_lose').css('display', 'none');
	//上边扫描块选项出现.login-header-scan
	$('.login-header-scan').css('display', 'block');
   //上边文字不出现.login-header, 中间 内容不出现.login_input_main
    //中display
    $('.login-header').css('display', 'none');
    $('.login_input_main').css('display', 'none')
});

//上边扫描处的选项
//普通登录
$('.login-header-scan>.login-txt1').click(function(){
	$('.login_scan_click').css('display', 'block');
	//二维码扫描登录块不出现.login_scan中display
	$('.login_scan').css('display', 'none');
	//上边扫描块选项不出现.login-header-scan
	$('.login-header-scan').css('display', 'none');
	//上边文字出现.login-header, 中间 内容出现.login_input_main
    //中display
    $('.login-header').css('display', 'block');
    $('.login_input_main').css('display', 'block');
	/*文本添加类login-active,横线添加display为block*/
	$('.login-header>.login-txt1').addClass('login-active').children().css('display', 'block');
	/*普通登录去掉类login-active,横线改display为none*/
	$('.login-header>.login-txt1').siblings('.login-txt2').removeClass('login-active').children().css('display', 'none');
	/*普通登录输入部分可见.input_block_1中display*/
	$('.input_block_1').css('display', 'block');
	/*无密码输入部分不可见.input_block_2中display*/
	$('.input_block_2').css('display', 'none');
	/*动态口令不可见input_block_2.dymatic中display*/
	$('.input_block_2.dymatic').css('display', 'none')
});
//无密码登录
$('.login-header-scan>.login-txt2').click(function(){
	$('.login_scan_click').css('display', 'block');
	//二维码扫描登录块不出现.login_scan中display
	$('.login_scan').css('display', 'none');
	//上边扫描块选项不出现.login-header-scan
	$('.login-header-scan').css('display', 'none');
	//上边文字出现.login-header, 中间 内容出现.login_input_main
    //中display
    $('.login-header').css('display', 'block');
    $('.login_input_main').css('display', 'block');
	/*文本添加类login-active,横线添加display为inline*/
	$('.login-header>.login-txt2').addClass('login-active').children().css('display', 'inline');
	/*普通登录去掉类login-active,横线改display为none*/
	$('.login-header>.login-txt2').siblings('.login-txt1').removeClass('login-active').children().css('display', 'none');
	/*无密码输入部分可见.input_block_2中display*/
	$('.input_block_2').css('display', 'block');
	/*验证部分可见.code中display*/
//	$('.code').css('display', 'block');
	/*动态口令可见input_block_2.dymatic中display*/
	$('.input_block_2.dymatic').css('display', 'block');
	/*普通登录输入部分不可见.input_block_1中display*/
	$('.input_block_1').css('display', 'none')
});
//点击记住密码
$('#remember_pwd').click(function(){	                
	// 如果是选中，则取消
	if ($(this).data('waschecked') == true){
		//如果是记住密码，则自动登录取消
		$('#auto_login').prop('checked', false);
		$('#auto_login').data('waschecked', false);
	  	$(this).prop('checked', false);	                    
		$(this).data('waschecked', false);
	} else {
		//如果未选中，则选中
	   $(this).prop('checked', true);
	  $(this).data('waschecked', true);
	}
});
//点击自动登录
$('#auto_login').click(function(){	                
	// 如果是选中，则取消
	if ($(this).data('waschecked') == true){
	  	$(this).prop('checked', false);	                    
		$(this).data('waschecked', false);
	} else {
		//如果未选中，则选中
		//如果是自动登录，则记住密码选中
		$('#remember_pwd').prop('checked', true);
	   $(this).prop('checked', true);
	  $(this).data('waschecked', true);
	}

});


//聚焦事件
//所有输入框聚焦时无默认颜色
//聚焦时无文本解释
$('.i_text').each(function(i){
	$(this).focus(function(){
		$(this).css('outline', 'none');
	})
});
//验证码输入框聚焦时无默认颜色
//$('.i_text_checkcode').focus(function(){
//	$(this).css('outline', 'none');
//});

//失焦事件
//普通登录邮箱输入框失焦时判断
$('#txtLoginID').blur(function(){
	//获取账号输入框填的值
	var loginid =$(this).val().trim();
	//输入框为空时
	if (loginid =='') {
		//账号输入框#txtLoginID添加类.i_text_error，边框为红色
		$(this).addClass('i_text_error');
		//提示内容#txtLoginIDTip邮箱/手机号/会员卡号不能为空,文本解释添加类.f-explain
		$('#txtLoginIDTip').addClass('f_explain').html('邮箱不能为空');
		//去掉正确图标
		$('#txtLoginIDCorrent').removeClass('i_correct');
		return;
	}
	//获取的值与邮箱、手机号、会员卡号正则匹配
	//邮箱正则表达式
	var mail =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/g;
	if (!mail.test(loginid)) {
		//账号输入框#txtLoginID添加类.i_text_error，边框为红色
		$(this).addClass('i_text_error');
		//账号输入错误时#txtLoginIDTip邮箱/手机号/会员卡号错误，
		//请重新输入, 文本解释添加类.f-explain
		$('#txtLoginIDTip').addClass('f_explain').html('邮箱输入错误,请重新输入');
		//去掉正确图标
		$('#txtLoginIDCorrent').removeClass('i_correct');
		return;
	}
	//输入正确则去掉文本解释，加上正确图标
	if (mail.test(loginid)) {
		//账号输入框#txtLoginID添加类.i_text_error
		$(this).removeClass('i_text_error');
		//文本解释去掉类.f-explain
		$('#txtLoginIDTip').removeClass('f_explain');
		//加上正确图标
		$('#txtLoginIDCorrent').addClass('i_correct');
		return;
	}
	
	/*//用户名匹配
	var re =/^[a-z0-9_]{3,20}/g;
	if (!re.test(loginid)) {
		//文本解释
		$('#txtLoginIDTip').addClass('f_explain').html('用户名错误,必须为3-20位数字字母下划线');
		//账号输入框#txtLoginID添加类.i_text_error，边框为红色
		$(this).addClass('i_text_error');
		//去掉正确图标
		$('#txtLoginIDCorrent').removeClass('i_correct');
	}
	else{
		//账号输入框#txtLoginID去掉类.i_text_error
		$(this).removeClass('i_text_error');
		//文本解释去掉类.f-explain
		$('#txtLoginIDTip').removeClass('f_explain').html('');
		//加上正确图标
		$('#txtLoginIDCorrent').addClass('i_correct');
		//验证码部分出现
        $('.code').css('display', 'block');
	}*/
});
	
//密码输入框失焦事件
$('#txtLoginPwd').blur(function(){
	//获取密码输入框填的值
	var loginpwd =$(this).val();
	
	//输入框为空时
	if (loginpwd =='') {
		//密码输入框#txtLoginPwd添加类.i_text_error
		$(this).addClass('i_text_error');
		//提示内容#txtLoginPwdTip密码不能为空,文本解释添加类.f-explain
		$('#txtLoginPwdTip').addClass('f_explain').html('密码不能为空');
		//去掉正确图标
		$('#txtLoginPwdCorrent').removeClass('i_correct');
		return;
	}
	//密码输入框#txtLoginPwd去掉类.i_text_error
	$(this).removeClass('i_text_error');
	//文本解释去掉类.f-explain
	$('#txtLoginPwdTip').removeClass('f_explain').html('');
	//加上正确图标
	$('#txtLoginPwdCorrent').addClass('i_correct');
	return;
});

//无密码登录邮箱输入框失去焦点
$('#txtLoginMob').blur(function(){
	//获取邮箱输入框填的值
	var loginmob =$(this).val().trim();
	//输入框为空时
	if (loginmob=='') {
		//邮箱输入框#txtLoginMob添加类.i_text_error，边框为红色
		$(this).addClass('i_text_error');
		//提示内容#txtLoginMobTip邮箱不能为空,文本解释添加类.f-explain
		$('#txtLoginMobTip').addClass('f_explain').html('邮箱不能为空');
		//去掉正确图标
		$('#txtLoginMobCorrent').removeClass('i_correct');
		return;
	}
	//获取的值与邮箱、手机号、会员卡号正则匹配
	//邮箱正则表达式
	var mail =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/g;
	if (!mail.test(loginmob)) {
		//邮箱输入框#txtLoginMob添加类.i_text_error，边框为红色
		$(this).addClass('i_text_error');
		//账号输入错误时#txtLoginMobTip邮箱/手机号/会员卡号错误，
		//请重新输入, 文本解释添加类.f-explain
		$('#txtLoginMobTip').addClass('f_explain').html('邮箱错误,请重新输入');
		//去掉正确图标
		$('#txtLoginMobCorrent').removeClass('i_correct');
		return;
	}
	//输入正确则去掉文本解释，加上正确图标
	if (mail.test(loginmob)) {
		//邮箱输入框#txtLoginMob添加类.i_text_error
		$(this).removeClass('i_text_error');
		//文本解释去掉类.f-explain
		$('#txtLoginMobTip').removeClass('f_explain');
		//加上正确图标
		$('#txtLoginMobCorrent').addClass('i_correct');
		return;
	}
	
	/*//用户名匹配
	var re =/^[a-z0-9_]{3,20}/g;
	if (!re.test(loginid)) {
		//文本解释
		$('#txtLoginIDTip').addClass('f_explain').html('用户名错误,必须为3-20位数字字母下划线');
		//账号输入框#txtLoginID添加类.i_text_error，边框为红色
		$(this).addClass('i_text_error');
		//去掉正确图标
		$('#txtLoginIDCorrent').removeClass('i_correct');
	}
	else{
		//账号输入框#txtLoginID去掉类.i_text_error
		$(this).removeClass('i_text_error');
		//文本解释去掉类.f-explain
		$('#txtLoginIDTip').removeClass('f_explain').html('');
		//加上正确图标
		$('#txtLoginIDCorrent').addClass('i_correct');
		//验证码部分出现
        $('.code').css('display', 'block');
	}*/
});

//无密码登录邮箱口令失去焦点
$('#txtLoginDpwd').blur(function(){
	//获取口令输入框填的值
	var checkcode =$(this).val();
	//输入框为空时
	if (checkcode =='') {
		//验证码输入框#txtLoginDpwd添加类.i_text_error
		$(this).addClass('i_text_error');
		//提示内容##txtLoginDpwd验证码不能为空,文本解释添加类.f-explain
		$('#txtLoginDpwdTip').addClass('f_explain').html('请输入动态口令');
		return;
	}
	//动态口令输入错误
	
	//动态口令输入框#txtLoginDpwd去掉类.i_text_error
	$(this).removeClass('i_text_error');
	//提示内容#txtLoginDpwdTip请输入动态验证码,文本解释添加类.f-explain
	$('#txtLoginDpwd').removeClass('f_explain').html('');
});

//公共的前缀
var URL ='http://www.wjian.top/shop/';

//拿地址栏参数
var goodsId = getUrlVal('goods_id');
console.log(goodsId);

//账号输入框#txtLoginID，密码输入框#txtLoginPwd，
//验证码输入框.i_text_checkcode无类.i_text_error，且都不为空则按钮可用
$(function(){
	$('.btn').click(function(){
		//获取账号输入框填的值
	    var loginid =$('#txtLoginID').val().trim();
	    //获取密码输入框填的值
	    var loginpwd =$('#txtLoginPwd').val().trim();
	    //获取验证码输入框填的值
	    var checkcode =$('.i_text_checkcode').val().trim();
	    //账号输入判断
	    if (loginid=='' || $('#txtLoginID').hasClass('i_text_error')) {
	         return;
	    }
	    //密码输入判断
	    if (loginpwd=='' || $('#txtLoginPwd').hasClass('i_text_error')) {
	         return;
	    }
	    //验证码输入判断
	    if (checkcode=='' || $('.i_text_checkcode').hasClass('i_text_error')) {
	         return;
	    }
	    //发起登录请求
	    $.post(URL + 'api_user.php', {
	    	status : 'login',
	    	username : loginid,
	    	password : loginpwd
	    }, function(re){
	    	var obj =JSON.parse(re);
	    	console.log(obj);
	    	//验证
	    	//用户名不存在，添加文本解释
	    	if (obj.code ==2002) {
	    		//文本解释
				$('#txtLoginIDTip').addClass('f_explain').html('用户名不存在');
				//账号输入框#txtLoginID添加类.i_text_error，边框为红色
				$('#txtLoginID').addClass('i_text_error');
				/*//去掉正确图标
				$('#txtLoginIDCorrent').removeClass('i_correct');*/
				return;
	    	}
	    	//密码错误
	    	if (obj.code ==1001) {
	    		//密码输入框#txtLoginPwd添加类.i_text_error
				$('#txtLoginPwd').addClass('i_text_error');
				//提示内容#txtLoginPwdTip密码不能为空,文本解释添加类.f-explain
				$('#txtLoginPwdTip').addClass('f_explain').html('密码错误！');
				//去掉正确图标
				$('#txtLoginPwdCorrent').removeClass('i_correct');
	    	}
	    	//不成功
	    	if (obj.code != 0) {
	    		console.log(obj.message);
	    		return;
	    	}
	    	//登录成功
	    	//把用户名和token存到本地
	    	localStorage.setItem('username', obj.data.username);
	    	localStorage.setItem('token', obj.data.token);
	    	//跳首页还是详情
	    	if (goodsId) {
	    		location.href ='product.html?goods_id='+goodsId;
	    	}else{
	    		location.href = 'index.html'; 
	    	}
	    });
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

//普通登录
//设置cookie  
function setCookie(){   
	/*获取用户信息 */ 
	var loginid =$('#txtLoginID').val().trim();
	//获取登陆密码信息
	var loginpwd =$('#txtLoginPwd').val();
	//获取“记住密码”单选框
    var checked = $('#auto_login').is(':checked');  
    console.log("记住密码"+checked);   
     //判断是否选中记住密码  
	if (checked) {
		//设置cookie过期时间
		var date =new Date();
		//60表示60秒
		date.setTime(date.getTime()+60*1000);
		console.log('cookie'+date);
		//调用jquery.cookie.js中的方法设置cookie中的用户名 
		$.cookie('login_id',loginid,{expires:date, path:'/'});
		//调用jquery.cookie.js中的方法设置cookie中的登陆密码，并使用base64（jquery.base64.js）进行加密
		$.cookie('login_pwd',$.base64.encode(loginpwd),{expires:date, path:'/'});
	}else{
		$.cookie('login_id',null);
		$.cookie('login_pwd',null);
	}
}
