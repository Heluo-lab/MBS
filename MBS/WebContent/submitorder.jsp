<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="css/cartbase.css" />
	<link rel="stylesheet" href="css/submitorder.css" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
</head>
<body>
<div class="backtotop"><a href="javascript:;"><img src="img/r5.jpg"/></a></div>
		<!--头部-->
		<div class="nav">
			<div class="container">
				<a href="index.html" class="logo"><img src="img/cartlogo.jpg"/></a>
				<div class="headleft">
					<ul>
						<li>　9年品质保证<span>　|　</span></li>
						<li>7天无条件退货<span>　|　</span></li>
					</ul>
				</div>
				<div class="headright">
					<!-- 已登陆-->
					<ul class="message message-yes">
						<li class="userid">你好${account.accountName }！<span>　|</span></li>
						<li>
						<div class=" message-border">
							<a href="self_center.jsp">
							<img src="img/icon_img3.png" />我的梦芭莎
							</a>
							<ul class="myaccount">
								<li>订单查询</li>
								<li>办理退换货</li>
								<li>余额查询</li>
							</ul>
						</div>
							<span>　|</span>
							
						</li>
						<li class="exit-btn"><a href="javascript:void(0)" id="exitLogin">退出登录<span>　|</span></a></li>
					</ul>
					
					<div class="help">
						<ul>
							<li><a href="">帮助中心</a></li>
							<li>
								<a href="" class="wechat">
									微信
									<img src="img/weixin.jpg" />
								</a>
							</li>	
							<li>
								<a href="" class="phone">
									手机版
									<img src="img/download.jpg" />
								</a>
							</li>
						</ul>
					</div>
					
				</div>
				<div class="stepby" style="background: url(img/progressBar.gif) 0px -54px no-repeat;"></div>
			</div>
		</div>
		
		<div class="main">
			<div class="pay">
				<h1>提交成功</h1>
			</div>
		</div>
	<footer>
			<div class="footer-a-bg">
				<div class="footer-a">
					<ul>
						<li class="footer-a-title"><a href="">新手指南</a></li>
						<li><a href="">注册新用户</a></li>
						<li><a href="">如何订购</a></li>
						<li><a href="">如何修改订单</a></li>
						<li><a href="">尺码对照表</a></li>
					</ul>
					<ul>
						<li class="footer-a-title"><a href="">支付方式</a></li>
						<li><a href="">支付方式</a></li>
						<li><a href="">账户提现及退款时限</a></li>
						<li><a href="">查看账户余额</a></li>
					</ul>
					<ul>
						<li class="footer-a-title"><a href="">配送方式</a></li>
						<li><a href="">配送费收取标准</a></li>
						<li><a href="">配送范围及配送时效</a></li>
						<li><a href="">签收注意事项</a></li>
						<li><a href="">海外订购</a></li>
					</ul>
					<ul>
						<li class="footer-a-title"><a href="">退换货服务</a></li>
						<li><a href="">退换货政策</a></li>
						<li><a href="">退换货流程</a></li>
						<li><a href="">隐私声明</a></li>
					</ul>
					<ul>
						<li class="footer-a-title"><a href="">会员制度及优惠</a></li>
						<li><a href="">优惠活动</a></li>
						<li><a href="">VIP优惠尊享</a></li>
						<li><a href="">大宗购物</a></li>
						<li><a href="">积分制度</a></li>
					</ul>
					<ul>
						<li class="footer-a-title"><a href="">帮助中心</a></li>
						<li><a href="">忘记密码</a></li>
						<li><a href="">常见问题</a></li>
						<li><a href="">在线客服</a></li>
						<li><a href="">联系我们</a></li>
						<li><a href="">专利平台</a></li>
					</ul>
					<ul>
						<li class="footer-a-title"><a href="">咨询订购</a></li>
						<li><a href="">400-716-2828</a></li>
						<li class="black"><a href="">客户服务</a></li>
						<li><a href="">400-716-7878</a></li>
						<li class="black"><a href="">招商热线</a></li>
						<li><a href="">400-716-0266</a></li>
					</ul>
					<ul class="custom_pic">
						<li><img src="img/Customer_service.png"/></li>
					</ul>
				</div>
			</div>
			<div class="footer-img">
				<img src="img/footer_img01.jpg" />
				<img src="img/footer_img02.jpg" />
				<img src="img/footer_img03.jpg" />
			</div>
			<div class="footer-txt">
				<a href="index.html">首页</a>
				<a href="">旗下品牌</a>
				<a href="">零售店址</a>
				<a href="">梦芭莎网盟 </a>
				<a href="">网店代理</a>
				<a href="">网站地图</a>
				<a href="">友情链接</a>
				<div class="footer-txt-copyright">
					Copyright © 2010-2019 梦芭莎官方网站，广州摩拉网络科技有限公司 All Rights Reserved 粤B2-20080069号 <img src="img/plice.png"/>粤公网安备44010302000075
				</div>
			</div>
		</footer>
	</body>
</html>
<script src="js/exitLogin.js"></script>