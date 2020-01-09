<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>找回密码第一步</title>
		<link rel="stylesheet" href="css/forgetpwdstep1.css" />
	</head>
	<body>
		<!--头部添加图片-->
		<div class="head">
			<a href="index" target="_blank">
				<img src="img/tubiao1.jpg" />
			</a>
		</div>
		<!--身体内容-->
		<div class="section">
			<div class="user_info">
				<!--上边步骤图块-->
				<div class="pwd_step">
					<img src="img/forgetpwd_step1.jpg" />
				</div>
				<!--中间表单部分-->
				<form action="next" method="post">
					<div class="forgetpwd_form">
						<!-- 下一步失败 -->
						<div id="nextMsg">${msg }</div>
						<ul class="input_block">
							<!--邮箱输入-->
							<li class="email_block">
								<!--邮箱输入框图标-->
								<label class="i_lable name-lable" for="email"></label>
								<!--邮箱输入框-->
								<input type="text" name="email" placeholder="邮箱" class="i_text"  id="email" />
								<!--输入正确时图标-->
								<label id="emailCorrent"></label>
								<!--账号为空，错误时图标文字解释-->
								<div id="emailTip"></div>
							</li>
							<!--验证码部分-->
							<li>
								<div class="code" id="securityCode">
									<span class="checkcode-notice">点击下方图片，转到正确方向</span>
									<span class="checkcode-link">换一张</span>
									<!--验证码输入框部分-->
									<div class="code-line">
										<!--验证码输入框-->
										<input type="text" name="reset_code" id="reset_code" class="i_text_checkcode" placeholder="验证码"/>
										<!--验证码图片部分-->
										<div id="container">
												<img src="codeImage" class="code_img" name="codeImg" id="codeImg" />
										</div>
										<!--输入有效时-->
										<label id="codeCorrect"></label>
										<!--验证错误时的解释-->
										<div id="codeTip"></div>
									</div>
								</div>
							</li>
							<!--按钮部分-->
							<span class="inpu">
								<input type="submit" class="reset-next-btn" name="btnnext" id="btnnext" value="下一步"/>
								<input type="button" class="reset-cancel-btn" name="btncancel" id="btncancel" value="取消" />
							</span>
						</ul>
					</div>
				</form>
				<!--下边文字部分-->
				<div class="forgetpwd_info">
					如有困难，请联系客服中心：400-716-2828 或 E-mail:
					<a href="">service@moonbasa.com</a>
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
<script type="text/javascript" src="js/forgetpwdstep1.js" ></script>
