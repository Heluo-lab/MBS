<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/order.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="css/cartbase.css"/>
	</head>
	<body>
		<div class="backtotop"><a href="javascript:;"><img src="img/r5.jpg"/></a></div>
		<!--头部-->
		<div class="nav">
			<div class="container">
				<a href="" class="logo"><img src="img/cartlogo.jpg"/></a>
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
				<div id="stepby"></div>
			</div>
		</div>
		
		<!--主体-->
		<div class="container">
			<div class="order-body">
				<div class="order-title">
					<span class="title-address"></span>
					<a href="javascript:;" id="changeaddress" onclick="changeAddress()">[修改]</a>
				</div>
				<div class="address">
					<c:if test="${ param.hasmsg==true }">
						${receName } ${receAddressProv } ${receAddressCity } ${receAddressDetaile } ${recePhone }
					</c:if>
					<c:if test="${ param.hasmsg==false }">
						<form action="javascript:;" onsubmit="javascript:return submitAll();" id="allrecemsg">
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
					</c:if>
				</div>
				
				
				<div class="order-title">
					<span class="pay-message"></span>
					<a href="javascript:;">[修改]</a>
				</div>
				<div class="pay">
					<p><a href="">礼品卡激活 </a>账户余额/礼券抵扣： 礼品卡激活<span> +</span></p>
					<p>您选择使用 <span>在线支付</span></p>
					<p><span>3样商品</span>：梦芭莎快递运输	</p>				
				</div>
				<div class="order-title">
					<span class="shop-message"></span>
					<a href="cart" class="backtoshop">返回修改购物车》</a>
				</div>

				<div class="buygoods">
					<span>以下商品由 梦芭莎 发货 配送费10.00元</span>
					<div class="paygoods">
						<table border="1">
							<tr class="firsttr">
								<td>
									商品名称
								</td>	
								<td>
									梦芭莎价
								</td>
								<td>
									数量
								</td>
								<td>
									小计
								</td>
							</tr>
							<c:forEach items="${goodslist }" var="goods">
								<tr>
									<input type="hidden" class="cartgoodsid" value="${goods.goodsId}" />
									<td class="firsttd">
										<img src="${goods.showImage} " />
										<div>
											<p>${goods.goodsName}</p>
											<p>尺寸：${goods.size}　颜色：${goods.color}</p>
										</div>
									</td>
									<td class="othertd"><span>${goods.price}</span></td>
									<td class="othertd"><span>${goods.goodsNum}</span></td>
									<td class="othertd"><span>${goods.goodsNum*goods.price}</span></td>
								</tr>
							</c:forEach>
						</table>
						<div class="order-price-all">
							<div class="order-price-all-left">
								优惠码：
								<input type="text" placeholder="请输入您获得的优惠码" class="text"/>
								<a href="javascript:;">提交</a>
							</div>
							<div class="order-price-all-right">
								<table>
									<tr>
										<td>商品总价：</td>
										<td>￥${money }</td>
									</tr>
									<tr>
										<td>配送费：</td>
										<td>￥10.00</td>
									</tr>
									<tr>
										<td>应付金额：</td>
										<td id="price-all">￥ ${money+10 }</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="order-line"></div>
						<p>如需开具发票，请在订单签收7天后联系客服开具</p>
					</div>
				</div>
				<div class="order-last">
					请核对以上信息，确认无误后点击"提交订单"
					<a href="submitoreder" a{text-decoration:none;}>提交订单</a>
				</div>
			</div>
				
		</div>


		
		<!--底部-->
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
<script type="text/javascript" src="js/jquery.min.js" ></script>
<script type="text/javascript" src="js/city.js" ></script>
<script type="text/javascript" src="js/order.js" ></script>
<script type="text/javascript" src="js/ydxLazyLoad.js" ></script>
<script src="js/exitLogin.js"></script>