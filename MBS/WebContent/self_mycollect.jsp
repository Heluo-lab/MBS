<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的收藏</title>
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/self.css" />
		<link rel="stylesheet" href="css/self_mycollect.css"/>
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
							<a href="cart.html">购物车</a>
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
					<a href="index.html"><img src="img/logo.jpg"/></a>
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
								<li><a href="self.power?method=queryAllOrdersByUsersId">我的订单</a></li>
								<li><a href="shop_order.html">门店订单</a></li>
								<li><a href="self_mypointment.html">我的预约</a></li>
								<li><a href="javasrcpt:void(0)" class="active">我的收藏</a></li>
								<li><a href="shop_apply.html">商家申请</a></li>
							</ul>
						</div>
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
								<li><a href="club_privilege.html">会员特权	</a></li>
								<li><a href="privilege_intro.html">特权介绍</a></li>
								<li><a href="self_value.html">我的成长值</a></li>
							</ul>
						</div>
						<div class="lelf-menu">
							<h1 class="showoff option" status='0'>个人信息</h1>
							<ul>
								<li><a href="self_userinfo.jsp">基本信息</a></li>
								<li><a href="self.power?method=queryReceAddress">收获地址</a></li>
								<li><a href="privilege_security.html">安全验证</a></li>
							</ul>
						</div>
						<div class="lelf-menu">
							<h1 class="showoff option" status='0'>我的分享</h1>
							<ul>
								<li><a href="pro_share.html">制作分享</a></li>
								<li><a href="share_rebate.html">分享返利</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="section-self-right">
					<div class="top">
						<a href="javascript:void(0)" class="on">收藏的商品</a>
						<!-- 
							<span>|</span>
							<a href="javascript:void(0)">收藏的品牌</a>
							
						 -->
						 <form action="self.power?method=queryCollectGoodsByUsersIdAndGoodsName" method="post">
							<input type="text" name="goodsName" value="${goodsName }" />
							<input type="submit" value="查询"/>
						 </form>
					</div>
					<div class="collection">
						<!-- 没收藏的时候 -->
						<c:if test="${empty goodsList }">
							<div class="collection-no">
								<img src="img/nodata_03.jpg" />
							</div>
						</c:if>
						<div class="collection-no-always">
								<img src="img/nodata_03.jpg" />
							</div>
						<!--有收藏的时候-->
						<c:if test="${!empty goodsList }">
							<div class="collection-yes">
								<ul id="collect-ul">
									<c:forEach items="${goodsList }" var="goods">
										<li class="collect-list">
											<a href="#">	
												<img src="${goods.showImage }"/>
												<div class="pro_title">${goods.goodsName }</div>
												<span class="afterDiscount">￥${goods.price*0.7 }</span>
												<span>￥${goods.price }</span>	
											</a>
											<div class="collect-operation">
												<div class="collect-joincart" onclick="toCart(this)">加入购物车</div>
												<div class="collect-delete" onclick="deleteCollect(this)">删除</div>
												<input type="hidden" value="${goods.id }" />
											</div>
										</li>
									</c:forEach>
									<!-- 
										<li class="collect-list">
											<a>	
												
												<img src="img/nodata_01.jpg"/>
												<div class="pro_title">梦芭莎精裁格纹拼接优雅收腰A摆连衣裙式中长款马甲</div>
												<span>￥169</span>
												<span>￥339</span>	
											</a>
											<div class="collect-operation">
												<div class="collect-joincart">加入购物车</div>
												<div class="collect-delete" onclick="deleteCollect(this)">删除</div>
												<input type="hidden" value="1" />
											</div>
										</li>
										<li>
											<img src="img/nodata_01.jpg"/>
											<div class="pro_title">梦芭莎精裁格纹拼接优雅收腰A摆连衣裙式中长款马甲</div>
											<span>￥169</span>
											<span>￥339</span>
										</li>
										<li>
											<img src="img/nodata_01.jpg"/>
											<div class="pro_title">梦芭莎精裁格纹拼接优雅收腰A摆连衣裙式中长款马甲</div>
											<span>￥169</span>
											<span>￥339</span>
										</li>
										<li>
											<img src="img/nodata_01.jpg"/>
											<div class="pro_title">梦芭莎精裁格纹拼接优雅收腰A摆连衣裙式中长款马甲</div>
											<span>￥169</span>
											<span>￥339</span>
										</li>
										<li>
											<img src="img/nodata_01.jpg"/>
											<div class="pro_title">梦芭莎精裁格纹拼接优雅收腰A摆连衣裙式中长款马甲</div>
											<span>￥169</span>
											<span>￥339</span>
										</li>
										<li>
											<img src="img/nodata_01.jpg"/>
											<div class="pro_title">梦芭莎精裁格纹拼接优雅收腰A摆连衣裙式中长款马甲</div>
											<span>￥169</span>
											<span>￥339</span>
										</li>
									 -->
								</ul>
							</div>
							
						</c:if>
					</div>
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
<script src="js/jquery.min.js"></script>
<script src="js/self_base.js"></script>
<script src="js/exitLogin.js"></script>
<script>
	$('.top a').each(function(){
		$(this).click(function(){
			$(this).addClass('on').siblings('a').removeClass('on');
			//进行ajax请求 对数据进行渲染
		});
	});
	function checkDiscount(){
		$(".afterDiscount").each(function(){
			var price = $(this).html();
			price = price.substr(1);
			price = Math.round(price);
			$(this).html("￥"+price);
		});
	}
	function toCart(obj) {
		location.href="product?id="+$(obj).siblings("input").val();
	}
	$(function(){
		checkDiscount();
	});
	function deleteCollect(obj){
		if(confirm("您确定要从收藏中移除该商品吗？")){
			$.ajax({
				type:"post",
				url:"self.power",
				data:{"method":"deleteCollectByGoodsId","id":$(obj).siblings("input").val()},
				success:function(data){
					var arr = JSON.parse(data);
					$("#collect-ul").html("");
					for(var i = 0; i < arr.length ; i++){
						var str = "<li class='collect-list'><a href='#'><img src='"+arr[i].showImage+"'/><div class='pro_title'>"+arr[i].goodsName+"</div><span class='afterDiscount'>￥"+(arr[i].price*0.7)+"</span><span>￥"+arr[i].price+"</span>	</a><div class='collect-operation'><div class='collect-joincart' onclick='toCart(this)'>加入购物车</div><div class='collect-delete' onclick='deleteCollect(this)'>删除</div><input type='hidden' value='"+arr[i].id+"' /></div></li>";
						$(str).appendTo($("#collect-ul"));
					}
					if(""==$("#collect-ul").html()){
						$(".collection-no-always").css("display","block");
					}
					checkDiscount();
				},
				error:function(){
					//alert("fail");
				}
			});
		}
	}
</script>