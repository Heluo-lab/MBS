<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${goods}" var="WindowPicture" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品详情</title>
	<link rel="stylesheet" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/index.css"/>
	<link rel="stylesheet" href="css/mbs-spxq.css" />
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
						<div class="header-top-list-coll no-user">
							<a href="register.html">注册</a>
							<span>|</span>
						</div>
						<div class="header-top-list-coll no-user">
							<a href="login.html">登录</a>
							<span>|</span>
						</div>
						<div class="header-top-list-coll yes-user">
							<a href="javascript:void(0)" id="exitLogin">退出登录</a>
							<span>|</span>
						</div>
						<div class="header-top-list-coll yes-user">
							<!--<a href="#">你好，XXX</a>-->
							<a href="self_center.html" id="username"></a>
							<span>|</span>
						</div>
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
		<div class="nr">
			<div class="Korirl">
				<a href=""></a>
			</div>
			<div class="dh-bg">
				<ul class="muen">
					<li><a href="">首页</a></li>
					<li><a href="">热销新品</a></li>
					<li><a href="">外套</a></li>
					<li><a href="">连衣裙</a></li>
					<li><a href="">T恤</a></li>
					<li><a href="">毛衫</a></li>
					<li><a href="">衬衫/小衫</a></li>
					<li><a href="">卫衣</a></li>
					<li><a href="">半裙</a></li>
					<li><a href="">裤子</a></li>
					<li><a href="">折扣专区</a></li>
				</ul>
			</div>
		<!--侧栏-->
		<div class="menu-right">
			<div class="menu-right-main">
				<div class="menu-myifo">
					<div class="list-myinfo">
						请登录
					</div>
					<a href="">
						<img src="img/info.png" >
					</a>
				</div>
				<div class="menu-car">
					<div class="list-car">
						购物车
					</div>
					<a href="">
						<img src="img/cart.png" >
						<span>购物车</span>
						<span class="count">0</span>
					</a>
				</div>
				
				<div class="addmsg">
					<span>添加购物车成功</span>
				</div>
				
				
				<div class="menu-heart">
					<a href="">
						<img src="img/heart.png" >
					</a>
				</div>
				<div class="menu-weichat">
					<a href="">
						<img src="img/weichat.png" >
					</a>
				</div>
				<div class="menu-service">
					<a href="">
						<img src="img/service_out.png" >
					</a>
				</div>
			</div>
			<div class="return-top">
				<div class="hovertop">
					<span>返回顶部</span><img src="img/foc_po.png" >
				</div>
				<a href="javascript:;">
					<img src="img/menu_top.png" >
				</a>
			</div>
		</div>
			<!--信息-->

			<div class="clear"></div>
			<div class="myShopping">
				<div class="Shopping-zuo">
					<!--面包屑-->
					<div class="page">
						<a rel="nofollow" href="">首页</a>
						>
						<a href="">热销排行</a>
						>
						<a href="">全部商品</a>
						>
						<a href="">上装</a>
					</div>
					<!--商品图片-->
					<div class="Shopping-zuo-tu">
						<!--滚动图-->
						<ul>
							<div class="zoomPad">
						<!--<c:forEach items="${imgurl}" var="falg" varStatus="img">
							<li>
								<img src="${falg}"/>
							</li>
						</c:forEach>-->
								<!--滑块-->
								<div class="slide"></div>
							</div>						
						</ul>
						<!--滚动小图界面-->
						<div class="tp-xiaomianb">
				<!--	<ul>
						<c:forEach items="${imgurl}" var="falg" varStatus="img">
							<li>
								<img src="${falg}"/>
							</li>
						</c:forEach>
						</ul> -->

						</div>
						<div class="Shopping-zuo-xia">
							<p>商品编码：${goods.id}</p>
							<a href="" class="shoucang"><span>收藏</span></a>
						</div>
						<div class="tu-big">
						<!--<img class="big-img" src="img/430917402-116-01-H.jpg" />-->
						</div>
					</div>
				</div>
				<div class="Shopping-zhong">
					<!--<h2>韩伊儿日韩时尚休闲趣味绣花带帽大衣</h2>-->
					<h2>${goods.goodsName}</h2>
				<div class="lookp">
					<div class="shouji">
						<img class="ewm-dt" src="img/move01.gif"/>	
						<div class="ewm-p">
							<p>手机便捷购买</p>
						</div>
					<div class="ewm-zhankai">
						
					</div>
				</div>
					
					<div class="price">
						<span class="jiage">
							<i class="renBox">￥</i>
							<!--<b>398</b>-->
							<b>${goods.price}</b>
							<p class="ppp"></canvas> <a href="">评论|梦芭莎自营</a></p>
						</span>
						
					
					</div>
						<div class="zhekou">
							<span class="discountBox">7.0折</span>
							<span class="marketBox">
								<!--￥<del>569</del>-->
								￥<del>${goods.price}</del>
							</span>
						</div>
						
				</div>
				
				<div class="gouwu">
					<div class="gouwu-top">
						<div class="color">
							<ul class="c-ul">
								<li class="txt">颜色</li>
								<li class="licolork">
									<p class="dq"><img src="img/430917402-116-01-H.jpg"/>  卡其色</p>
									<p><img src="img/430917402-479-01-L.jpg"/>  卡其色</p>
								</li>
							</ul>
						</div>
					
						<div class="size">
							<ul>
								<li class="txt">尺码</li>
								<li class="sizebtn">
									<span>
										<a>S</a>
										<a>M</a>
										<a>L</a>
										<a>XL</a>
									</span>
								</li>
							</ul>		
						</div>
					
						<div class="num">
							<ul>
								<li>数量</li>
								<li>
									<p>
										<b id="product_num">1</b>
										<i class="add"></i>
										<i class="remove"></i>
									</p>
								</li>
							</ul>
						</div>
						
						<div class="xyd">
							<span class="gouwu-xyd">
								<img src="img/430917402-116-01-H.jpg" />
							</span>
						</div>
						
						<div class="goumai-btn">
							<span id="collect">
								<i>立刻购买</i>
							</span>
							<span class="addgouwu-btn" id="addshoppingcart">
								<i>加入购物车</i>
							</span>
						</div>
					
						<div class="mainland">
							<ul class="ms-list">
								<li>
									<div class="mt-8">
										<img src="img/16012209.png" />
										<span>7天无条件退换货</span>
									</div>
								</li>
								<li>
									<div class="mt-8">
										<img src="img/16012211.png" />
										<span>满180元免运费</span>
									</div>
								</li>
								<li>
									<div class="mt-8">
										<img src="img/16012213.png" />
										<span>梦芭莎发货</span>
									</div>
								</li>
							</ul>	
						</div>
					
					</div>
					
					
				</div>
			</div>
			
				<div class="Shopping-you">
					<div class="lb_right">
						<span class="line-l"></span>
						看了又看
						<span class="line-r"></span>
					</div>
					<div class="lb-carrier">
						<ul id="lb-con">
							<li>
								<a><img src="img/430917401-S08-01-S.jpg"/></a>
								<p class="jzjg">￥400</p>
							</li>
							<li>
								<a><img src="img/430917401-S08-01-S.jpg"/></a>
								<p class="jzjg">￥400</p>
							</li>
							<li>
								<a><img src="img/430917401-S08-01-S.jpg"/></a>
								<p class="jzjg">￥400</p>
							</li>
						</ul>
					</div >
					
				</div>
			</div>
			<div class="nr-btool">
				<div class="left">
					<div class="left-same">
						<div class="hotrecommend">
							<a>
								<img src="img/M9_24_192617.jpg" />
							</a>
						</div>
					</div>
				</div>
				<div class="right">
					<div id="item-d-nav">
						<h2>
							<a>商品详情</a>
							<a>评价</a>
							<a>如何支付</a>
							<a>7天无条件退换货</a>
						</h2>
					</div>
					<div class="Itemtb">
						<div data="商品属性" class="spsx">
							<div class="Itemtb-tl">
								<img src="img/t_02.png"/>
							</div>
							
					<div class="detali_destrct">
						<c:forEach items="${imgurl}" var="falg" varStatus="img">
							<span>
								<img src="${falg}"/>
							</span>
						</c:forEach>
					</div>
										
									</div>
								</div>
							</div>
						</div> 
					</div>
				</div>
			</div>
		</div>
</body>
</html>
<script src="js/isLogin.js"></script>
<script type="text/javascript" src="js/product.js" ></script>
<script src="js/jquery-1.8.3.min.js"></script>
<script src="js/addcar.js"></script>
<script src="js/jquery.mousewheel.min.js" type="text/javascript"
charset="utf-8"></script>
<!-- 回到顶部 -->
<script type="text/javascript">
	$('.return-top').click(function() {
		//闪现到顶部
		// $(document).scrollTop(0);
		$('body , html').animate({
			'scrollTop' : 0
		}, 2000);
	});
	$(document).scroll(function() {
		if ($(document).scrollTop() > 300) {
			$('.return-top').fadeIn();
		} else {
			$('.return-top').fadeOut();
		}
	});
</script>