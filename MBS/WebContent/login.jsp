<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>梦芭莎登录</title>
		<link rel="stylesheet" href="css/login.css" />
	</head>
	<body>
		<!--头部添加图片-->
		<div class="head">
			<a href="index.jsp" target="_blank">
				<img src="img/tubiao1.jpg" />
			</a>
		</div>
		<!--身体内容-->
		<div class="section">
			<!--左边图片-->
			<div class="left">
				<img src="img/login.jpg" />
			</div>
			<!--右边内容-->
			<div class="right">
				<!--上边-->
				<div class="login-header">
					<span class="login-txt1 login-active">普通登录
						<span class="login-txt1-line"></span>
					</span>
					<span class="login-txt2">无密码登录
						<span class="login-txt2-line"></span>
					</span>
				</div>
				<!--上边扫描块选项-->
				<div class="login-header-scan">
					<span class="login-txt1 login_active">普通登录</span>
					<span class="login-txt-scan-line">|</span>
					<span class="login-txt2">无密码登录</span>
				</div>
				<!--下边-->
				<div class="login-form">
					<form class="login_input_main" id="form">
						<!-- 判断是否登录成功 -->
						<div class="user_item" id="loginMsg">用户名或密码不正确，请重新登录！</div>
						<!--普通登录第一块输入部分-->
						<div class="input_block_1">
							<!--邮箱输入-->
							<div class="user_item">
								<label class="i_lable name-lable" for="txtLoginID"></label>
								<input type="text" name="txtLoginMail" title="请输入邮箱" placeholder="邮箱" class="i_text"  id="txtLoginID"/>
								<!--输入正确时图标-->
								<label id="txtLoginIDCorrent"></label>
								<!--账号为空，错误时图标文字解释-->
								<div id="txtLoginIDTip"></div>
							</div>
							<!--密码输入-->
							<div class="user_item">
								<label class="i_lable pwd-lable" for="txtLoginPwd"></label>
							    <input type="password" name="txtLoginPwd" title="请输入密码" placeholder="密码" class="i_text" id="txtLoginPwd" />
								<!--输入正确时图标-->
								<label id="txtLoginPwdCorrent"></label>
								<!--密码为空，错误时图标文字解释-->
								<div id="txtLoginPwdTip"></div>
							</div>
						</div>
						<!--无密码登录第二块输入部分-->
						<div class="input_block_2">
							<!--邮箱输入-->
							<div class="user_item">
								<label class="i_lable name-lable" for="txtLoginID"></label>
								<input type="text" name="txtLoginMob" title="请输入邮箱" class="i_text" id="txtLoginMob" placeholder="请输入邮箱" />
								<!--输入正确时图标-->
								<label id="txtLoginMobCorrent"></label>
								<!--邮箱号为空时的解释-->
								<div id="txtLoginMobTip"></div>
							</div>
						</div>
						<!--动态验证部分与密码输入一样-->
						<div class="input_block_2 dymatic">
							<!--动态输入框-->
							<label class="i_lable pwd-lable" for="txtLoginDpwd"></label>
							<input type="text" name="member_mail_code" title="请输入动态口令" class="i_text" id="txtLoginDpwd" placeholder="邮箱验证码" />
							<!--动态按钮-->
							<input type="button" value="获取动态口令" class="getDpwd" data-time="60" />
							<!--动态输入框为空时的解释-->
							<div id="txtLoginDpwdTip"></div>
						</div>
						<!--两个链接和按钮-->
						<div class="btn-a">
							<a href="forgetpwdstep1.jsp" class="forget-pwd">忘记密码？</a>
							<input type="radio" id="remember_pwd" name="remember_pwd" value="记住密码"/>
							<label for="remember_pwd" id="txt_remember">记住密码</label>
							<input type="radio"  id="auto_login" name="auto_login" value="自动登录"/>
							<label for="auto_login" id="txt_auto">自动登录</label>
							<a href="register.jsp" class="login_reg">注册</a>
							<!--按钮-->
							<div class="btn">
								<input type="button" name="btnLogin" id="btnLogin" class="i_btn_ok" value="立即登录"/>
								<input type="button" name="btnLogin" id="btnSmsLogin" class="i_btn_ok" value="立即登录"/>
							</div>
						</div>
					</form>
					<!--右边内容下面其他方式-->
					<div class="user_item_otherWay">
						<span>其他登录方式：</span>
						<a title="微信登录" href="#" class="login-wx">
							<img src="img/wx.jpg" />
						</a>
						<a title="QQ登录" href="#" class="login-qq">
							<img src="img/qqlogo.jpg" />
						</a>
						<a title="支付宝登录" href="#" class="login-alipay">
							<img src="img/alipay.jpg" />
						</a>
						<a title="微博登录" href="#" class="login-weibo">
							<img src="img/weibologo.jpg" />
						</a>
					</div>
					<!--二维码扫描-->
					<!--二维码扫描登录块-->
					<div class="login_scan">
						<!--左边图片-->
						<div class="login_scan_code">
							<img id="imgscanok" class="login_scan_code_pic" src="img/scantu.jpg" />
							<img id="imgscanfailure" class="login_scan_code_pic cover" src="img/scaninvalid.png" />
							<!--二维码失效-->
							<div class="login_code_lose">
								<p>二维码已失效</p>
								<p><a href="javascript:;">请点击刷新</a></p>
							</div>
						</div>
						<!--右边文字-->
						<div class="login_scan_right">
							<p class="title1">手机扫码　快速登录</p>
							<!--中间-->
							<p class="title2">使用
								<span class="tip">梦芭莎APP</span>
								扫描
							</p>
							<!--下边链接-->
							<a class="login_scan_right_btn" href="#">点击下载APP</a>
						</div>
					</div>
					<!--二维码扫描登录点击-->
					<div class="login_scan_click"></div>
				</div>
			</div>
		</div>
		
		<!--尾部内容-->
		<div class="footer-txt">
			<a href="index.html">首页</a>
			<a href="">旗下品牌</a>
			<a href="">零售店址</a>
			<a href="">梦芭莎网盟 </a>
			<a href="">网店代理</a>
			<a href="">网站地图</a>
			<a href="">友情链接</a>
			<a href="">关于我们</a>
			<div class="footer-txt-copyright">
                Copyright © 2010-2019 梦芭莎官方网站，广州摩拉网络科技有限公司 All Rights Reserved 粤B2-20080069号
			</div>
		</div>
	</body>
</html>
<script src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/login.js" ></script>
