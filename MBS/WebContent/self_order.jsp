<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的订单</title>
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/self.css" />
		<link rel="stylesheet" href="css/self_order.css"/>
	</head>
	<body>
		<!--头部-->
		<header>
			<div class="header-top-bg">
				<div class="header-top">
					<div class="header-top-aboutUs">
						㊣ 100%正品保证&nbsp;&nbsp;创立于2006年
					</div>
					<div class="header-top-list">
						<div class="header-top-list-cart">
							<a href="cart">购物车</a>
							<div class="header-cart-no">
								购物车里还没有任何商品，快去选购吧!
							</div>
							<div class="header-cart-yes">
								<ul>
									<li>
										<a href="#" target="_blank">
											<img width="40" height="55" alt="休闲舒适柔软全棉磨毛牛津纺男士修身版长袖衬衫" src="http://images.monteamor.com/ProductImg/3/1903/middle/062022305-010-01-M.jpg">
										</a>
										<a href="#" class="pro_info" target="_blank">休闲舒适柔软全棉磨毛牛津纺男士修身版长袖衬衫</a>
										<span>￥198.00</span>
										<div>
											<label type="text" class="minicart_num">×1</label>
											<a href="javascript:void(0)" class="del">删除</a>
										</div>
									</li>
									<li>
										<a href="#" target="_blank">
											<img width="40" height="55" alt="休闲舒适柔软全棉磨毛牛津纺男士修身版长袖衬衫" src="http://images.monteamor.com/ProductImg/3/1903/middle/062022305-010-01-M.jpg">
										</a>
										<a href="#" class="pro_info" target="_blank">休闲舒适柔软全棉磨毛牛津纺男士修身版长袖衬衫</a>
										<span>￥198.00</span>
										<div>
											<label type="text" class="minicart_num">×1</label>
											<a href="javascript:void(0)" class="del">删除</a>
										</div>
									</li> 
								</ul>
								<div class="checkout_box">
									<br>
									<p>
										<span class="fl">共<strong>1</strong>件商品</span>
										<span>合计：<strong>¥198.00</strong></span>
									</p>
									<a class="checkout_btn" href="#">去结算</a>
								</div>
							</div>
						</div>
						<div class="header-top-list-coll">
							<a href="#">收藏梦芭莎</a>
							<span>|</span>
						</div>
						<div class="header-top-list-coll">
							<a href="#">手机版</a>
							<span>|</span>
						</div>
						<div class="header-top-list-coll">
							<a href="#">微博</a>
							<span>|</span>
						</div>
						<div class="header-top-list-coll">
							<a href="#">微信</a>
							<span>|</span>
						</div>
						<c:if test="${empty usersInfo }">
							<div class="header-top-list-coll no-user">
								<a href="register.jsp">注册</a> <span>|</span>
							</div>
							<div class="header-top-list-coll">
								<a href="login.jsp">登录</a> <span>|</span>
							</div>
						</c:if>
						<c:if test="${!empty usersInfo }">
							<div class="header-top-list-coll">
								<a href="javascript:void(0)" id="exitLogin">退出登录</a> <span>|</span>
							</div>
							<div class="header-top-list-coll">
								<!--<a href="#">你好，XXX</a>-->
								<a href="self_center.jsp" id="username">你好，${usersInfo.accountName }</a> <span>|</span>
							</div>
						</c:if>
					</div>
				</div>
			</div>
			<div class="header-category-bg">
				<div class="header-category">
					<ul>
						<li><a href="#"><img src="img/top_case01.jpg"/></a></li>
						<li><a href="#"><img src="img/top_case01.jpg"/></a></li>
						<li><a href="#"><img src="img/top_case01.jpg"/></a></li>
						<li><a href="#"><img src="img/top_case01.jpg"/></a></li>
						<li><a href="#"><img src="img/top_case01.jpg"/></a></li>
					</ul>
				</div>
			</div>
			<div class="header-bottom">
				<div class="logo">
					<a href="index"><img src="img/logo.jpg"/></a>
				</div>
				<div class="header-bottom-search">
					<input type="text" placeholder="请输入宝贝" name="search"/>
					<button value="">搜索</button>
				</div>
				<div class="header-bottom-recommend">
					<a><img src="img/recommend.gif"/></a>
				</div>
			</div>
		</header>
		<!--主体-->
		<section>
			<div class="member-label">
				<a href="self_center.jsp">首页</a>>
				<a href="self_center.jsp">个人中心</a>
			</div>
			<div class="section-self">
				<div class="section-self-left">
					<div class="section-self-left-content">
						<div class="lelf-menu">
							<ul>
								<li><a href="cart">我的购物车</a></li>
								<li><a href="javascript:void(0)" class="active">我的订单</a></li>
								<li><a href="shop_order.html">门店订单</a></li>
								<li><a href="self_mypointment.html">我的预约</a></li>
								<li><a href="self.power?method=queryCollectGoodsByUsersId">我的收藏</a></li>
								<li><a href="shop_apply.html">商家申请</a></li>
							</ul>
						</div>
						<!-- 
							<div class="lelf-menu">
								<h1 class="showoff option" status='0'>我的资产</h1>
								<ul>
									<li><a href="self_moeny.html">我的余额</a></li>
									<li><a href="self_voucher.html">我的礼卷</a></li>
									<li><a href="self_discount.html">我的优惠</a></li>
									<li><a href="self_integral.html">我的积分</a></li>
									<li><a href="money_apply.html">申请提现</a></li>
									<li><a href="add_order.html">充值订单</a></li>
								</ul>
							</div>
							<div class="lelf-menu">
								<ul>
									<li><a href="self_message.html">我的消息</a></li>
									<li><a href="self_comment.html">我的评论</a></li>
									<li><a href="operate_goods.html">退换货</a></li>
								</ul>
							</div>
							<div class="lelf-menu">
								<h1 class="showoff option" status='0'>会员俱乐部</h1>
								<ul>
									<li><a href="club_index.html">俱乐部首页</a></li>
									<li><a href="club_privilege.html">会员特权</a></li>
									<li><a href="privilege_intro.html">特权介绍</a></li>
									<li><a href="self_value.html">我的成长值</a></li>
								</ul>
							</div>
							<div class="lelf-menu">
								<h1 class="showoff option" status='0'>我的分享</h1>
								<ul>
									<li><a href="pro_share.html">制作分享</a></li>
									<li><a href="share_rebate.html">分享返利</a></li>
								</ul>
							</div>
						
						 -->
						<div class="lelf-menu">
							<h1 class="showoff option" status='0'>个人信息</h1>
							<ul>
								<li><a href="self_userinfo.jsp">基本信息</a></li>
								<li><a href="self.power?method=queryReceAddress">收获地址</a></li>
								<li><a href="privilege_security.html">安全验证</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="section-self-right">
					<div class="right-top">
						<!-- 
							<div class="menu">
								<ul>
									<li class="on"><a href="javascript:void(0)">全部订单</a></li>
									<li><a href="javascript:void(0)">待付款(0)</a></li>
									<li><a href="javascript:void(0)">待发货(0)</a></li>
									<li><a href="javascript:void(0)">待收货(0)</a></li>
									<li><a href="javascript:void(0)">待评价(0)</a></li>
									<li><a href="javascript:void(0)">分阶段(0)</a></li>
								</ul>
							</div>
						 -->
						<div class="search">
							<form action="self.power?method=queryOrdersByCondition" method="post">
								<div class="order-time" val="${ordersTime }">
									<select name="ordersTime">
										<option value="0">所有时间的订单</option>
										<option value="1">三月内订单</option>
										<option value="2">六月内订单</option>
										<option value="3">一年内订单</option>
									</select>
								</div>
								<div class="order-status" val="${ordersStatus }">
									<select name="ordersStatus">
										<option value="0">所有订单状态</option>
										<option value="1">未付款</option>
										<option value="2">已付款</option>
										<option value="3">已发货</option>
										<option value="4">已完成</option>
									</select>
								</div>
								<div class="order-search">
									<input type="text" name="ordersNum" placeholder="请输入订单号" value="${ordersNum }"/>
									<input type="submit" value="查询"/>
								</div>
							</form>
						</div>
					</div>
					<c:if test="${empty ordersDTOList}">
						<div class="right-bottom-no">
							<div class="order-info-no">
								<p>没有效订单，快去挑选心仪的产品吧！</p>
								<a href="index">去首页逛逛</a>
							</div>
						</div>
					</c:if>
					<c:if test="${!empty ordersDTOList}">
						<div class="right-bottom-yes">
							<!--展示订单详情-->
							<div class="order-info-yes">
								
								<c:forEach items="${ordersDTOList }" var="ordersDTO">
									<!-- 每个订单 -->
									<div class="order-item">
										<div class="order-id">订单编号：${ordersDTO.ordersNum }</div>
										<!-- 订单项中的单一数据 -->
										<div class="item-pro">
											<table border="1" cellspacing="0" cellpadding="0" style="border:1px solid #ddd;text-align: center;width:980px">
												<tr>
													<th style="width:340px">宝贝</th>
													<th>宝贝属性</th>
													<th class="item-smart">状态</th>
													<th class="item-smart">服务</th>
													<th class="item-smart">单价</th>
													<th class="item-smart">数量</th>
													<th class="item-smart">优惠</th>
													<th class="item-smart price-total" total="${ordersDTO.ordersTotalMoney }">商品总价</th>
												</tr>
												<c:forEach items="${ordersDTO.itemsList }" var="ordersItemDTO" varStatus="i">
													<tr>
														<td>
															<img src="${ordersItemDTO.goods.showImage }"/>
															<div class="item-pro-info">${ordersItemDTO.goods.goodsName }</div>
														</td>
														<td>
															<c:if test="${!empty ordersItemDTO.color }">
																<p>颜色分类：${ordersItemDTO.color }</p>
															</c:if>
															<c:if test="${!empty ordersItemDTO.size }">
																<p>尺寸：${ordersItemDTO.size }</p>
															</c:if>
														</td>
														<c:if test="${ordersDTO.ordersStatus==1 }">
															<td>未付款</td>
														</c:if>
														<c:if test="${ordersDTO.ordersStatus==2 }">
															<td>已付款</td>
														</c:if>
														<c:if test="${ordersDTO.ordersStatus==3 }">
															<td>已发货</td>
														</c:if>
														<c:if test="${ordersDTO.ordersStatus==4 }">
															<td>已完成</td>
														</c:if>
														<td></td>
														<td>${ordersItemDTO.goods.price }</td>
														<td>${ordersItemDTO.goodsNum }</td>
														<td>无</td>
														<c:if test="${i.count==1 }">
															<td class="showTotal" rowspan="2"></td>
														</c:if>
													</tr>
												</c:forEach>
												<!-- 
													<tr>
														<td>
															<img src="img/060122303-035-01-L.jpg"/>
															<div class="item-pro-info">森麦 SM-IH852耳机挂耳式 运动跑步电脑手机耳麦K歌游戏头戴耳挂</div>
														</td>
														<td>
															<p>颜色分类：白色</p>
															<p>尺寸：大尺寸</p>
														</td>
														<td>未发货</td>
														<td></td>
														<td>99.0</td>
														<td>1</td>
														<td>无</td>
													</tr>
												 -->
											</table>
										</div>
									</div>
								</c:forEach>
								
								
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</section>
			
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
				<a href="index">首页</a>
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
<script src="js/jquery.min.js"></script>
<script src="js/self_base.js"></script>
<script src="js/exitLogin.js"></script>
<script>
	$(function(){
		var orderTime = $(".order-time").attr("val");
		var orderStatus = $(".order-status").attr("val");
		console.log(orderTime+"==="+orderStatus+"===");
		$("[name='ordersTime'] option").each(function(){
			if($(this).val()==orderTime){
				$(this).prop("selected",true);
				return;
			}
		});
		$("[name='ordersStatus'] option").each(function(){
			if($(this).val() == orderStatus){
				$(this).prop("selected",true);
				return;
			}
		});
	})
	$('.menu li').each(function(){
		$(this).click(function(){
			$(this).addClass('on').siblings('li').removeClass('on');
			//ajax向服务器请求数据  设置$('.order-info-no').css('display','none').siblings('div').css('display','block');
		});
	});
	$(function(){
		$("table").each(function(){
			$(this).find('.showTotal').html($(this).find('.price-total').attr("total"));
		});
	})
	
</script>