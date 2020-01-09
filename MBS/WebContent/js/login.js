//用来判断是否可登陆
var isID=false;
var isPwd=false;
//无密码登录
var isEmail=false;
var isCode =false;

//如果从其他页面进登录页面，输入框都有值
//普通登录
//获取邮箱输入的值
var loginid =$('#txtLoginID').val().trim();
//获取密码输入框的值
var loginpwd =$('#txtLoginDpwd').val();
if (loginid !='') {
	isID=true;
}
if (loginpwd !='') {
	isPwd=true;
}
//无密码登录
//获取邮箱输入框的值
var loginmob =$('#txtLoginMob').val().trim();
if (loginmob !='') {
	 isEmail=true;
}
//获取口令输入框的值
//var checkcode =$('#txtLoginDpwd').val();


//localStorage.removeItem('registerid');
//$('#txtLoginID').val(loginemail);
////获取账号输入框填的值
//var loginid =$('#txtLoginID').val().trim();
//if (loginid!='') {
//	isID =true;
//}
//记住密码#txtLoginID，#txtLoginPwd
//获取邮箱
var loginid =localStorage.getItem('loginid');
if (loginid!=null || loginid!='') {
	$('#txtLoginID').val(loginid);
	isID =true;
}
//获取密码
var loginpwd =localStorage.getItem('loginpwd');
if (loginpwd!=null || loginpwd!='') {
	$('#txtLoginPwd').val(loginpwd);
	isPwd =true;
}
//获取记住密码的值
var checkedpwd =localStorage.getItem('checkedpwd');
if (checkedpwd=='true') {
	 $('#remember_pwd').prop('checked', true);
     $('#remember_pwd').data('waschecked', true);
}


//如果是从注册跳转过来
//if (isID=false) {
//	var loginemail =localStorage.getItem('registerid');
//	if (loginemail!=null || loginemail!='') {
//		$('#txtLoginID').val(loginemail);
//		isID =true;
//		localStorage.removeItem('registerid');
//		$('#txtLoginPwd').val('');
//	}
//}

//else{
//	//直接从登录界面
//	//保存用户的登录信息到cookie，当登录页面打开，就查询cookie
//	window.onload =function(){
//		console.log("aaa");
//		var loginidValue =getCookieValue("loginid");
//		$('#txtLoginID').val(loginidValue);
//		isID =true;
//		var loginpwdValue =getCookieValue("loginpwd");
//		$('#txtLoginPwd').val(loginpwdValue);
//		isPwd=true;
//		  $('#remember_pwd').prop('checked', true);
//		  $('#remember_pwd').data('waschecked', true);
//		  //自动登录
//		/*  console.log(localStorage.getItem('checkedauto')==true);
//		 if (localStorage.getItem('checkedauto')==true) {
//			localStorage.removeItem('checkedauto');
//		   $('#auto_login').prop('checked', true);
//		   $('#auto_login').data('waschecked', true);
//			btnlogin();
//		} */
//		 return;
//	}
//}
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
	$('.input_block_1').css('display', 'none');
    //记住密码和自动登录单选框不可见 $("input[type='radio']")#txt_remember#txt_auto
	$("input[type='radio']").css('display', 'none');
	$('#txt_remember').css('display', 'none');
	$('#txt_auto').css('display', 'none');
	//普通登录块按钮#btnLogin不可见,#btnSmsLogin可见
	$('#btnLogin').css('display','none');
	$('#btnSmsLogin').css('display','block');
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
	$('.input_block_2.dymatic').css('display', 'none');
	 //记住密码和自动登录单选框可见 $("input[type='radio']")#txt_remember#txt_auto
	$("input[type='radio']").css('display', 'inline-block');
	$('#txt_remember').css('display', 'inline-block');
	$('#txt_auto').css('display', 'inline-block');
	//普通登录块按钮#btnLogin可见,#btnSmsLogin不可见
	$('#btnLogin').css('display','block');
	$('#btnSmsLogin').css('display','none');
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



//按钮点击时边框无
$('.btn input').each(function(i){
	$(this).focus(function(){
		$(this).css('outline', 'none');
	})
});
//聚焦事件
//所有输入框聚焦时无默认颜色
//聚焦时无文本解释
$('.i_text').each(function(i){
	$(this).focus(function(){
		$(this).css('outline', 'none');
	})
});

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
		isID =false;
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
		isID =false;
		return;
	}
	//输入正确则去掉文本解释，加上正确图标
	//if (mail.test(loginid)) {
		//账号输入框#txtLoginID添加类.i_text_error
		$(this).removeClass('i_text_error');
		//文本解释去掉类.f-explain
		$('#txtLoginIDTip').removeClass('f_explain').html('');
		//加上正确图标
		$('#txtLoginIDCorrent').addClass('i_correct');
		isID =true;
		return;
	//}
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
		isPwd =false;
		return;
	}
	//密码输入框#txtLoginPwd去掉类.i_text_error
	$(this).removeClass('i_text_error');
	//文本解释去掉类.f-explain
	$('#txtLoginPwdTip').removeClass('f_explain').html('');
	//加上正确图标
	$('#txtLoginPwdCorrent').addClass('i_correct');
	isPwd =true;
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
		isEmail =false;
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
		$('#txtLoginMobTip').addClass('f_explain').html('邮箱格式错误,请重新输入');
		//去掉正确图标
		$('#txtLoginMobCorrent').removeClass('i_correct');
		isEmail =false;
		return;
	}
	//输入正确则去掉文本解释，加上正确图标
	//if (mail.test(loginmob)) {
		//邮箱输入框#txtLoginMob添加类.i_text_error
		$(this).removeClass('i_text_error');
		//文本解释去掉类.f-explain
		$('#txtLoginMobTip').removeClass('f_explain').html('');
		//加上正确图标
		$('#txtLoginMobCorrent').addClass('i_correct');
		isEmail =true;
		return;
	//}
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
		isCode =false;
		return;
	}
	if (checkcode.length !=4) {
		//动态验证码输入框#txtLoginDpwd添加类.i_text_error
		$(this).addClass('i_text_error');
		//提示内容#txtLoginDpwdTip请输入动态验证码,文本解释添加类.f-explain
		$('#txtLoginDpwdTip').addClass('f_explain').html('请输入四位验证码');
		//设置不能注册
		isCode =false;
		return;
	}
	//动态口令输入框#txtLoginDpwd去掉类.i_text_error
	$(this).removeClass('i_text_error');
	//提示内容#txtLoginDpwdTip请输入动态验证码,文本解释添加类.f-explain
	$('#txtLoginDpwdTip').removeClass('f_explain').html('');
	isCode =true;
});



//公共的前缀
//var URL ='http://www.wjian.top/shop/';
//拿地址栏参数
var goodsId = getUrlVal('id');
console.log(goodsId);
//获得地址栏参数值
function getUrlVal(property){
	var urlStr =window.location.search.substring(1);
	var re =new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
	var result =urlStr.match(re);
	if (result == null) {return null};
	return result[2];
};




//点击事件
//普通登录块
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



//立即登录点击事件
//普通登录点击事件
$('#btnLogin').click(function(){
	//#loginMsg中display不可见
	$('#loginMsg').css('display','none');
  alert("login");
	if (isID == false || isPwd == false) {
		return;
	}
	 //获取记住密码的值
	var checkedpwd =$('#remember_pwd').is(':checked');
	//获取自动登录的值
	var checkedauto =$('#auto_login').is(':checked');
		//获取账号输入框填的值
	    var loginid =$('#txtLoginID').val().trim();
	    //获取密码输入框填的值
	    var loginpwd =$('#txtLoginPwd').val().trim();
	    loginid =encodeURI(encodeURI(loginid));
	    loginpwd =encodeURI(encodeURI(loginpwd));
	  //发起登录请求
		$.ajax({
			 type: 'post',
			 async :false,
			 url: 'loginBtn',
			 data:{
			  'checkedpwd':checkedpwd,
			  'checkedauto':checkedauto,
			  'loginid' : loginid,
			  'loginpwd' : loginpwd
			  },  
			 success :function(result){
				 //接收的是error
				 if (result=='error') {
					//#loginMsg中display可见
					 $('#loginMsg').css('display','block');
					 //设置不能登录
					 isID == false;
					 isPwd == false;
					 return;
				}else{
					//登录成功
					//var obj =JSON.parse(result);
			    	//把用户昵称和token存到本地
			    	//localStorage.setItem('accountname', obj.data.accountName);
			    	//localStorage.setItem('token', obj.data.token);
					var checkedpwd =$('#remember_pwd').is(':checked');
					if (checkedpwd) {
//						//添加cookie
//						addCookie("loginid",loginid,7,"/");
//						addCookie("loginpwd",loginpwd,7,"/");
						//添加用户名到本地
						localStorage.setItem('loginid', loginid);
						//添加密码到本地
						localStorage.setItem('loginpwd', loginpwd);
						//添加记住密码单选框值到本地
						localStorage.setItem('checkedpwd', checkedpwd);
					}
					//如果点击了自动登录，存到本地
//					var checkedauto =$('#auto_login').is(':checked');
//					if (checkedauto) {
//						localStorage.setItem('checkedauto', checkedauto);
//					}
					//跳首页还是详情
			    	if (goodsId) {
			    		location.href ='pageConetentLoading?id='+goodsId;
			    	}else{
			    		location.href = 'index'; 
			    	}
			    	return;
				}
			 },
			 error:function(){
				// console.log("shibai");
			 }
			});
	  return;
});
	

//无密码登录块
//.getDpwd获取动态口令按钮点击事件
var t;
$('.getDpwd').click(function(){
	//无密码登录邮箱输入框 isEmail = true;，则.getDpwd中value为正在发送...，且禁用
	if (isEmail == true) {
		$(this).val('正在发送...');
		$(this).attr('disabled', 'disabled');
		//该按钮手势为no-drop
		$(this).css('cursor','no-drop');
		//获取客户填入的邮箱值
		var email =$('#txtLoginMob').val().trim();
		//获取生成的邮箱验证码
		$.post('emailCode',{'email':email}, function(result){
			//获取.getDpwd中data-time的值
			var second =parseInt($('.getDpwd').attr('data-time'));
			//每隔一秒,属性为data-time的值就-1,减到0就停止
			t =setInterval(function(){
				second =second-1;
				//.getDpwd中data-time的值位second秒
				$('.getDpwd').attr("data-time", second);
				//.getDpwd中value为120秒后重新发送
				$('.getDpwd').val(second+'秒后重新发送');
				if (second==1) {
					//.getDpwd中value为获取动态口令
					$('.getDpwd').val('获取动态口令');
					//.getDpwd中data-time的值位120秒
					$('.getDpwd').attr('data-time','60');
					//#getCode可用
					$('.getDpwd').removeAttr('disabled');
					//该按钮手势cursor: pointer;
					$('.getDpwd').css('cursor','pointer');
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

//无密码点击事件
$('#btnSmsLogin').click(function(){
	//.getDpwd中value为获取动态口令
	$('.getDpwd').val('获取动态口令');
	//.getDpwd中data-time的值位60秒
	$('.getDpwd').attr('data-time','60');
	//#getCode可用
	$('.getDpwd').removeAttr('disabled');
	//该按钮手势cursor: pointer;
	$('.getDpwd').css('cursor','pointer');
	//清除定时器
	clearInterval(t);
	if (isEmail ==false && isCode ==false) {
		return;
	}
		//loginsort='other';
	    //获取无密码登录块邮箱输入框的值
	    var loginmob =$('#txtLoginMob').val().trim();
	    //获取动态口令输入框填的值
	    var logincode =$('#txtLoginDpwd').val().trim();
	    loginmob =encodeURI(encodeURI(loginmob));
	    logincode =encodeURI(encodeURI(logincode));
	   //发起登录请求
		$.ajax({
			 type: 'post',
			 async :false,
			 url: 'nologinBtn',
			 data:{
			  'loginmob' : loginmob,
			  'logincode' : logincode
			  },  
			 success :function(result){
				 //接收的是error
				 if (result=='code') {
					//动态验证码输入框#txtLoginDpwd添加类.i_text_error
					$('#txtLoginDpwd').addClass('i_text_error');
					//提示内容#txtLoginDpwdTip请输入动态验证码,文本解释添加类.f-explain
					$('#txtLoginDpwdTip').addClass('f_explain').html('动态验证码错误！');
					//设置不能登录
					isCode =false;
					return;
				}else if (result=='error') {
					//#loginMsg中display可见
					 $('#loginMsg').css('display','block');
					//设置不能登录
					isCode =false;
					isEmail ==false;
					 return;
				}
				 else{
					//登录成功
//					var obj =JSON.parse(result);
//					 alert(obj);
			    	//把用户昵称和token存到本地
			    	//localStorage.setItem('accountname', obj.data.accountName);
			    	//localStorage.setItem('token', obj.data.token);
					//跳首页还是详情
					//跳首页还是详情
			    	if (goodsId) {
			    		location.href ='pageConetentLoading?id='+goodsId;
			    	}else{
			    		location.href = 'index'; 
			    	}
			    	return;
				}
			 }
			});
		return;
});


//普通登录
//添加设置cookie
function addCookie(name,value,days,path){
	var name =escape(name);
	var value =escape(value);
	var expires =new Date();
	expires.setTime(expires.getTime() +days*3600000*24);
	//path=/,表示cookie能在整个网站下使用
	path =path=="" ? "" : ";path="+path;
    //参数days只能是数字型
	var _expires =(typeof days) =="string" ? "" : ";expires="+expires.toUTCString();
	document.cookie =name +"=" +value +_expires+path;
}
//获取cookie的值，根据cookie的键获取值
function getCookieValue(name){
	//用处理字符串的方式查找到key对应value
	var name =escape(name);
	//读cookie属性，返回文档的所有cookie
	var allcookies =document.cookie;
	//查找名为name的cookie的开始位置
	name += "=";
	var pos =allcookies.indexOf(name);
	//如果找到了具有该名字的cookie，提取
	//如果pos值为-1则说明搜索"version="失败
	if (pos != -1) {
		//cookie值开始的位置
		var start =pos +name.length;
		//从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置
		var end =allcookies.indexOf(";",start);
		//如果end值为-1说明cookie列表里只有一个cookie
		if (end ==-1) {
			end =allcookies.length;
		}
		//提取cookie的值
		var value =allcookies.substring(start,end);
		//对它解码
		return value;
	}else{
		return "";
	}
}
//根据cookie的键，删除cookie
function deleteCookie(name,path){
	var name =escape(name);
	var expires =new Date(0);
	path =path=="" ? "" : ";path="+path;
	document.cookie =name+"="+";expires="+expires.toUTCString()+path;
}

//用户登录
//选中记住密码单选框，添加cookie
/*var checkedpwd =$('#remember_pwd').is(':checked');
if (checkedpwd) {
	//添加cookie
	addCookie("loginid",loginid,7,"/");
	addCookie("loginpwd",loginpwd,7,"/");
}
//自动登录
var checkedauto =$('#auto_login').is(':checked');
        if(checkedauto){
            //触发登录
			click;
        }*/
/*//普通登录
//设置cookie  
function setCookie(){   
	获取用户信息  
	var loginid =$('#txtLoginID').val().trim();
	//获取登陆密码信息
	var loginpwd =$('#txtLoginPwd').val();
	//获取“记住密码”单选框
    var checked = $('#remember_pwd').is(':checked');  
    console.log("记住密码"+checked);   
     //判断是否选中记住密码  
	if (checked) {
		//设置cookie过期时间
		var date =new Date();
		//60表示60秒
		date.setTime(date.getTime()+60*1000);
		console.log('cookie过期时间'+date);
		//调用jquery.cookie.js中的方法设置cookie中的用户名 
		$.cookie('login_id',$.base64.encode(loginid),{expires:date, path:'/'});
		//调用jquery.cookie.js中的方法设置cookie中的登陆密码，并使用base64（jquery.base64.js）进行加密
		$.cookie('login_pwd',$.base64.encode(loginpwd),{expires:date, path:'/'});
	}else{
		$.cookie('login_id',null);
		$.cookie('login_pwd',null);
	}
}

//清除所有cookie函数
function clearAllCookie() {
	var date =new Date();
	date.setTime(date.getTime()-10000);
	var keys =document.cookie.match(/[^=;]+(?=\=)/g);
	console.log("需要删除的cookie名字："+keys);
	if (keys) {
		for (var i = keys.length; i--;) {
			document.cookie =keys[i]+"=0;expire="+date.toGMTString()+"; path=/";
		}
	}
}
//获取cookie
function getCookie(){
	//获取cookie中普通登录的邮箱
	var loginid =$.cookie('login_id');
	//获取cookie中的登录密码
	var loginpwd =$.cookie('login_pwd');
	console.log('获取cookie：邮箱'+loginid+',密码'+loginpwd);
	if (!loginid || loginid==0) {
		console.log('账号'+!loginid);
	}else{
		$('#txtLoginID').val(loginid);
	}
	if (!loginpwd || loginpwd==0) {
		console.log('密码'+!loginpwd);
	}else{
		//密码存在，填充到密码文本框
		$('#txtLoginPwd').val($.base64.decode(loginpwd));
		//将#remember_pwd单选框勾选
		$('#remember_pwd').attr('checked','true');
	}
}
//立即登录按钮点击事件
$('.btn').click(function(){
	//选中记住密码单选框，添加cookie
	var checkedpwd =$('#remember_pwd').is(':checked');
	if (checkedpwd) {
		//添加cookie
		setCookie();
	}else{
		clearAllCookie();
	}
}); 
//选中记住密码单选框，添加cookie
var checkedpwd =$('#remember_pwd').is(':checked');
if (checkedpwd) {
	//添加cookie
	setCookie();
}else{
	clearAllCookie();
}
 //自动登录
var checkedauto =$('#auto_login').is(':checked');
        if(checkedauto){
            //触发登录
            $('button').click();
        }*/


