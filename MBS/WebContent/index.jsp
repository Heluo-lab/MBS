<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>首页</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<style type="text/css">
.menu-car .header-cart-no {
	position: absolute;
	width: 358px;
	height: 646px;
	padding: 45px 0px;
	left: -358px;
	top: -145px;
	background: #FFF;
	text-align: center;
	font-size: 32px;
	display: none;
}

.menu-car:hover .header-cart-no {
	display: block;
}

.list-car ul>li {
	padding: 5px 10px 2px;
	height: 70px;
	background: white;
	border-bottom: 1px solid #f3f3f3
}

.list-car li * {
	float: left;
}

.list-car .pro_info {
	padding-left: 5px;
	width: 130px;
	float: left;
	color: black;
	font-size: 12px;
}

.list-car li span {
	color: deeppink;
	font-size: 12px;
	line-height: 50px;
	font-weight: bold;
	width: 70px;
}

.list-car li label {
	margin: 0px 10px;
	line-height: 50px;
	font-size: 14px;
}

.list-car .del {
	font-size: 14px;
	color: black;
	float: right;
	line-height: 50px;
	padding-left: 20px;
}

.list-car .checkout_box {
	background: #f2f2f2;
	height: 80px;
	font-size: 12px;
}

.list-car .checkout_box p {
	padding: 10px 0px 0px 15px;
	display: block;
}

.list-car .checkout_box span:first-child {
	float: left;
}

.list-car .checkout_box span:last-child {
	float: right;
}

.list-car .checkout_box strong {
	color: deeppink;
}

.list-car .checkout_box .checkout_btn {
	display: block;
	position: absolute;
	bottom: 40px;
	right: 10px;
	background: #e50065;
	color: white;
	width: 70px;
	height: 28px;
	text-align: center;
	line-height: 28px;
}
</style>
</head>

<body>
	<!--头部-->
	<header>
		<div class="header-top-bg">
			<div class="header-top">
				<div class="header-top-aboutUs">㊣ 100%正品保证&nbsp;&nbsp;创立于2006年
				</div>
				<div class="header-top-list">
					<div class="header-top-list-cart">
						<a href="cart">购物车</a>
						<c:if test="${!hasGoods }">
							<div class="header-cart-no">购物车里还没有任何商品，快去选购吧!</div>
						</c:if>
						<c:if test="${hasGoods }">
							<div class="header-cart-yes">
							<ul>
							<c:forEach items="${goodsMsg}" var="goodsMsg">
								<li>
									<input type="hidden" id="${goodsMsg.goodsId }"/>
									<input type="hidden" id="color" value="${goodsMsg.color }"/>
									<input type="hidden" id="size" value="${goodsMsg.size }"/>
									<a href="#" target="_blank"> <img width="40" height="55" alt="${goodsMsg.goodsName }" src="${goodsMsg.showImage }"></a> 
									<a href="#" class="pro_info" target="_blank">${goodsMsg.goodsName }</a>
									<span>${goodsMsg.price }</span>
									<div>
										<label type="text" class="minicart_num">×${goodsMsg.goodsNum }</label>
									</div>
								</li>
							</c:forEach>
							</ul>
							<div class="checkout_box">
								<br>
								<p>
									<span class="fl">共<strong>${size }</strong>件商品
									</span> <span>合计：<strong>¥${total }</strong></span>
								</p>
								<a class="checkout_btn" href="order">去结算</a>
							</div>
						</div>
						</c:if>
						
					</div>
					<div class="header-top-list-coll">
						<a href="#">收藏梦芭莎</a> <span>|</span>
					</div>
					<div class="header-top-list-coll">
						<a href="#">手机版</a> <span>|</span>
					</div>
					<div class="header-top-list-coll">
						<a href="#">微博</a> <span>|</span>
					</div>
					<div class="header-top-list-coll">
						<a href="#">微信</a> <span>|</span>
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
					<li><a href="#"><img src="img/top_case01.jpg" /></a></li>
					<li><a href="#"><img src="img/top_case01.jpg" /></a></li>
					<li><a href="#"><img src="img/top_case01.jpg" /></a></li>
					<li><a href="#"><img src="img/top_case01.jpg" /></a></li>
					<li><a href="#"><img src="img/top_case01.jpg" /></a></li>
				</ul>
			</div>
		</div>
		<div class="header-bottom">
			<div class="logo">
				<a href="index.html"><img src="img/logo.jpg" /></a>
			</div>
			<div class="header-bottom-search" style="position: relative">
				<input type="text" placeholder="请输入宝贝" name="search" id="search"
					onkeyup="searchWord(this)" onblur="clear(this)" />
				<div id="showDiv"
					style="display: none; left: 60px; top: 67px; position: absolute; z-index: 1000; background: #fff; width: 451px; border: 1px solid deeppink;"></div>
				<button value="" onclick="search()">搜索</button>
			</div>
			<div class="header-bottom-recommend">
				<a><img src="img/recommend.gif" /></a>
			</div>
		</div>
	</header>
	<!-- 右部固定导航栏 -->
	<div class="menu-right">
		<div class="menu-right-main">
			<div class="menu-myifo">
				<div class="list-myinfo">请登录</div>
				<a href=""> <img src="img/info.png">
				</a>
			</div>
			<div class="menu-car">
				<c:if test="${!hasGoods }">
					<div class="header-cart-no">购物车里还没有任何商品，快去选购吧!</div>
					<a href="cart"> <img src="img/cart.png"> <span>购物车</span> <span class="count">0</span></a>
				</c:if>
				<c:if test="${hasGoods }">
					<div class="list-car">
						<c:forEach items="${goodsMsg}" var="goodsMsg">
							<ul>
								<li>
									<input type="hidden" id="${goodsMsg.goodsId }"/>
									<input type="hidden" id="color" value="${goodsMsg.color }"/>
									<input type="hidden" id="size" value="${goodsMsg.size }"/>
									<a href="#" target="_blank"> <img width="40" height="55" alt="${goodsMsg.goodsName }" src="${goodsMsg.showImage }">
									</a>
									<a href="#" class="pro_info" target="_blank"> ${goodsMsg.goodsName }</a>
									<span>${goodsMsg.price }</span>
									<div>
										<label type="text" class="minicart_num">×${goodsMsg.goodsNum }</label>
									</div>
								</li>
							</ul>
						</c:forEach>
							<div class="checkout_box">
								<br>
								<p>
									<span class="fl">共<strong>${size }</strong>件商品
										</span> <span>合计：<strong>${total }</strong></span>
								</p>
								<a class="checkout_btn" href="order">去结算</a>
							</div>
						</div>
				<a href="cart"> <img src="img/cart.png"> <span>购物车</span> <span class="count">${size }</span></a>
				</c:if>
				
			</div>
			<div class="menu-heart">
				<a href=""> <img src="img/heart.png">
				</a>
			</div>
			<div class="menu-weichat">
				<a href=""> <img src="img/weichat.png">
				</a>
			</div>
			<div class="menu-service">
				<a href=""> <img src="img/service_out.png">
				</a>
			</div>
		</div>
		<div class="return-top">
			<div class="hovertop">
				<span>返回顶部</span><img src="img/foc_po.png">
			</div>
			<a href="javascript:;"> <img src="img/menu_top.png">
			</a>
		</div>
	</div>
	<!-- 中部导航栏 -->
	<div class="nav-wrap">
		<ul class="nav-icon">
			<li class="li0"><img src="img/商品分类.jpg"></li>
			<li>
				<div class="licon">
					<h3>
						<a href="javascript:void(0)">女装</a>
					</h3>
					<h4>
						<c:forEach items="${womanList}" var="type" varStatus="i">
							<c:if test="${i.index%2==0}">
								<a target="_blank"
									href="${pageContext.request.contextPath }/product_list?tyid=${type.id}"
									class="haveborder">${type.typeName}</a>
							</c:if>
							<c:if test="${i.index%2!=0}">
								<a target="_blank"
									href="${pageContext.request.contextPath }/product_list?tyid=${type.id}">${type.typeName}</a>
							</c:if>
						</c:forEach>
					</h4>
				</div>
			</li>
			<li>
				<div class="licon">
					<h3>
						<a href="javascript:void(0)">内衣</a>
					</h3>
					<h4>
						<c:forEach items="${underwearList}" var="type" varStatus="i">
							<c:if test="${i.index%2==0}">
								<a target="_blank"
									href="${pageContext.request.contextPath }/product_list?tyid=${type.id}"
									class="haveborder">${type.typeName}</a>
							</c:if>
							<c:if test="${i.index%2!=0}">
								<a target="_blank"
									href="${pageContext.request.contextPath }/product_list?tyid=${type.id}">${type.typeName}</a>
							</c:if>
						</c:forEach>
					</h4>
				</div>
			</li>
			<li>
				<div class="licon">
					<h3>
						<a href="javascript:void(0)">男装</a>
					</h3>
					<h4>
						<c:forEach items="${manList}" var="type" varStatus="i">
							<c:if test="${i.index%2==0}">
								<a target="_blank"
									href="${pageContext.request.contextPath }/product_list?tyid=${type.id}"
									class="haveborder">${type.typeName}</a>
							</c:if>
							<c:if test="${i.index%2!=0}">
								<a target="_blank"
									href="${pageContext.request.contextPath }/product_list?tyid=${type.id}">${type.typeName}</a>
							</c:if>
						</c:forEach>
					</h4>
				</div>
			</li>
			<li>
				<div class="licon">
					<h3>
						<a href="javascript:void(0)">鞋包</a>
					</h3>
					<h4>
						<c:forEach items="${shoesBagList}" var="type" varStatus="i">
							<c:if test="${i.index%2==0}">
								<a target="_blank"
									href="${pageContext.request.contextPath }/product_list?tyid=${type.id}"
									class="haveborder">${type.typeName}</a>
							</c:if>
							<c:if test="${i.index%2!=0}">
								<a target="_blank"
									href="${pageContext.request.contextPath }/product_list?tyid=${type.id}">${type.typeName}</a>
							</c:if>
						</c:forEach>
					</h4>
				</div>
			</li>

		</ul>
		<ul class="nav-right">
			<li class="nav-right-li"><a
				href="${pageContext.request.contextPath}/index" class="list-active">首页</a></li>
			<c:forEach items="${goodsTopTypeList}" var="type">
				<li class="nav-right-li"><a
					href="${pageContext.request.contextPath}/product_list?tyid=${type.id}"
					id="${type.id}">${type.typeName}</a>
					<div class="sublist left">
						<ul>
						</ul>
					</div></li>
			</c:forEach>
		</ul>
	</div>
	<!-- 轮播 -->
	<div class="banner">
		<div class="c-li">
			<ul>
				<li class="active">
					<div class="content">
						<img src="img/M11_9_172718.jpg">
					</div>
				</li>
				<li>
					<div class="content ">
						<img src="img/M10_23_143034.jpg">
					</div>
				</li>
				<li>
					<div class="content">
						<img src="img/M10_23_143101.jpg">
					</div>
				</li>
				<li>
					<div class="content">
						<img src="img/M11_9_172215.jpg">
					</div>
				</li>
				<li>
					<div class="content  active">
						<img src="img/M11_9_173911.jpg">
					</div>
				</li>
			</ul>
			<div class="dot">
				<span class="current"></span> <span></span> <span></span> <span></span>
				<span></span>
			</div>
		</div>
	</div>
	<!-- img展示区 -->
	<div class="img-show">
		<img src="img/M11_12_173958_02.jpg"> <img
			src="img/M11_12_173958_03.jpg">
	</div>
	<!-- 梦芭莎优选 -->
	<div class="mbs-goods">
		<img src="img/M11_12_173958_04.jpg">
		<ul>
			<li><a href=""><img src="img/011017123-009-01-L.jpg"></a>
				<a href="">
					<p>梦芭莎净色百搭无痕光面内衣无钢圈舒适...</p> <span>￥59</span> <del>￥99.00</del>
			</a></li>
			<li><a href=""><img src="img/011017311-N08-01-L.jpg"></a>
				<a href="">
					<p>梦芭莎净色百搭无痕光面内衣无钢圈舒适...</p> <span>￥59</span> <del>￥99.00</del>
			</a></li>
			<li><a href=""><img src="img/011017324-803-01-L.jpg"></a>
				<a href="">
					<p>梦芭莎净色百搭无痕光面内衣无钢圈舒适...</p> <span>￥59&nbsp;&nbsp;</span> <del>￥99.00</del>
			</a></li>
			<li><a href=""><img src="img/011017407-124-01-L.jpg"></a>
				<a href="">
					<p>梦芭莎净色百搭无痕光面内衣无钢圈舒适...</p> <span>￥59&nbsp;&nbsp;</span> <del>￥99.00</del>
			</a></li>
			<li><a href=""><img src="img/012017102-534-01-L.jpg"></a>
				<a href="">
					<p>梦芭莎简约圆领亲肤棉不倒绒保暖女士套.....</p> <span>￥69&nbsp;&nbsp;</span> <del>￥129.00</del>
			</a></li>
			<li><a href=""><img src="img/012017322-120-01-L.jpg"></a>
				<a href="">
					<p>梦芭莎简约圆领亲肤棉不倒绒保暖女士套.....</p> <span>￥69&nbsp;&nbsp;</span> <del>￥129.00</del>
			</a></li>
			<li><a href=""><img src="img/012017410-014-01-L.jpg"></a>
				<a href="">
					<p>梦芭莎简约圆领亲肤棉不倒绒保暖女士套.....</p> <span>￥69&nbsp;&nbsp;</span> <del>￥129.00</del>
			</a></li>
			<li><a href=""><img src="img/012118401-P60-01-L.jpg"></a>
				<a href="">
					<p>梦芭莎简约圆领亲肤棉不倒绒保暖女士套.....</p> <span>￥69&nbsp;&nbsp;</span> <del>￥129.00</del>
			</a></li>
			<li><a href=""><img src="img/060817408-041-01-L.jpg"></a>
				<a href="">
					<p>蒙蒂埃莫棋盘格绗缝轻便保暖微弹常规版......</p> <span>￥99&nbsp;&nbsp;</span> <del>￥189.00</del>
			</a></li>
			<li><a href=""><img src="img/061122301-041-01-L.jpg"></a>
				<a href="">
					<p>蒙蒂埃莫棋盘格绗缝轻便保暖微弹常规版......</p> <span>￥99&nbsp;&nbsp;</span> <del>￥189.00</del>
			</a></li>
			<li><a href=""><img src="img/060122303-035-01-L.jpg"></a>
				<a href="">
					<p>蒙蒂埃莫棋盘格绗缝轻便保暖微弹常规版......</p> <span>￥99&nbsp;&nbsp;</span> <del>￥189.00</del>
			</a></li>
			<li><a href=""><img src="img/060118301-009-01-L.jpg"></a>
				<a href="">
					<p>蒙蒂埃莫棋盘格绗缝轻便保暖微弹常规版......</p> <span>￥99&nbsp;&nbsp;</span> <del>￥189.00</del>
			</a></li>
			<li><a href=""><img src="img/180917393-116-01-L.jpg"></a>
				<a href="">
					<p>原创文艺简约侧开叉双面呢外套......</p> <span>￥199&nbsp;&nbsp;</span> <del>￥389.00</del>
			</a></li>
			<li><a href=""><img src="img/180917409-FF22-01-L.jpg"></a>
				<a href="">
					<p>原创文艺简约侧开叉双面呢外套......</p> <span>￥199&nbsp;&nbsp;</span> <del>￥389.00</del>
			</a></li>
			<li><a href=""><img src="img/180917416-X888-01-L.jpg"></a>
				<a href="">
					<p>原创文艺简约侧开叉双面呢外套......</p> <span>￥199&nbsp;&nbsp;</span> <del>￥389.00</del>
			</a></li>
			<li><a href=""><img src="img/180918401-M03X-01-L.jpg"></a>
				<a href="">
					<p>原创文艺简约侧开叉双面呢外套......</p> <span>￥199&nbsp;&nbsp;</span> <del>￥389.00</del>
			</a></li>
		</ul>
	</div>
	<!-- 自营品牌 -->
	<div class="self-band">
		<img src="img/自营品牌.jpg">
		<!-- 一个品牌店的开始 -->
		<div class="self-band-list">
			<img src="img/M11_12_173958_07.jpg">
			<ul>
				<li><a href=""> <img src="img/187117366-015-01-L.jpg">
						<span>NEW</span>
						<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
						<p>￥330.00</p>
				</a></li>
				<li><a href=""> <img src="img/461618304-014-01-L.jpg">
						<span>NEW</span>
						<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
						<p>￥330.00</p>
				</a></li>
				<li><a href=""> <img src="img/434017408-479-01-L.jpg">
						<span>NEW</span>
						<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
						<p>￥330.00</p>
				</a></li>
				<li><a href=""> <img src="img/187117352-295-01-L.jpg">
						<span>NEW</span>
						<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
						<p>￥330.00</p>
				</a></li>
				<li><a href=""> <img src="img/435017402-116-01-L.jpg">
						<span>NEW</span>
						<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
						<p>￥330.00</p>
				</a></li>
				<li><a href=""> <img src="img/435616403-010-01-L.jpg">
						<span>NEW</span>
						<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
						<p>￥330.00</p>
				</a></li>
				<li><a href=""> <img src="img/437117420-009-01-L.jpg">
						<span>NEW</span>
						<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
						<p>￥330.00</p>
				</a></li>
				<li><a href=""> <img src="img/437316402-JS-01-L.jpg">
						<span>NEW</span>
						<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
						<p>￥330.00</p>
				</a></li>
			</ul>
			<img src="img/more.jpg">
		</div>
		<!-- 一品牌店的结束 -->
		<!-- <div class="self-band-list">
				<img src="img/M11_12_173958_07.jpg" >
				<ul>
					<li>
						<a href="">
							<img src="img/434017408-479-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/434017408-479-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/434017408-479-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/434017408-479-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/435017402-116-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/435616403-010-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/437117420-009-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/437316402-JS-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
				</ul>
				<img src="img/more.jpg" >
			</div>
			<div class="self-band-list">
				<img src="img/M11_12_173958_07.jpg" >
				<ul>
					<li>
						<a href="">
							<img src="img/434017408-479-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/434017408-479-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/434017408-479-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/434017408-479-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/435017402-116-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/435616403-010-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/437117420-009-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/437316402-JS-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
				</ul>
				<img src="img/more.jpg" >
			</div>
			<div class="self-band-list">
				<img src="img/M11_12_173958_07.jpg" >
				<ul>
					<li>
						<a href="">
							<img src="img/434017408-479-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/434017408-479-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/434017408-479-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/434017408-479-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/435017402-116-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/435616403-010-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/437117420-009-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/437316402-JS-01-L.jpg" >
							<span>NEW</span>
							<p>韩伊儿日韩时尚翻领双排扣简约长袖毛呢</p>
							<p>￥330.00</p>
						</a>
					</li>
				</ul>
				<img src="img/more.jpg" >
			</div> -->
	</div>
	<!-- 好货推荐 -->
	<div class="goods-put">
		<img src="img/好货推荐.jpg">
		<ul class="goods-list">
			<c:forEach items="${goodsRecommendTypeList}" var="typ">
				<li><a
					href="${pageContext.request.contextPath }/product_list?tyid=${typ.id}"
					id="${typ.id}">${typ.typeName}</a></li>
			</c:forEach>

			<!--<li><a href="">优雅女装</a></li>
			<li><a href="">日韩女装</a></li>
			<li><a href="">原创女装</a></li>
			<li><a href="">淘系女装</a></li>
			<li><a href="">家居内衣</a></li>
			<li><a href="">品质男装</a></li>
			<li><a href="">护肤美妆</a></li>
			<li><a href="">鞋包配饰</a></li>
			<li><a href="">护肤美妆</a></li>
			<li><a href="">鞋包配饰</a></li>
			-->
		</ul>
		<ul class="goods">
			<c:forEach items="${goodsList}" var="goods">
				<li><img src="${goods.showImage }">
					<p>${goods.goodsName}</p>
					<h3>￥${goods.price}</h3>
					<div class="goods-top">
						<h2>
							<a
								href="${pageContext.request.contextPath }/pageConetentLoading?id=${goods.id}">${goods.goodsName}</a>
						</h2>
					</div></li>
			</c:forEach>
		</ul>
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
					<li><img src="img/Customer_service.png" /></li>
				</ul>
			</div>
		</div>
		<div class="footer-img">
			<img src="img/footer_img01.jpg" /> <img src="img/footer_img02.jpg" />
			<img src="img/footer_img03.jpg" />
		</div>
		<div class="footer-txt">
			<a href="index">首页</a> <a href="">旗下品牌</a> <a href="">零售店址</a> <a
				href="">梦芭莎网盟 </a> <a href="">网店代理</a> <a href="">网站地图</a> <a
				href="">友情链接</a>
			<div class="footer-txt-copyright">
				Copyright © 2010-2019 梦芭莎官方网站，广州摩拉网络科技有限公司 All Rights Reserved
				粤B2-20080069号 <img src="img/plice.png" />粤公网安备44010302000075
			</div>
		</div>
	</footer>
</body>

</html>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script src="js/jquery.mousewheel.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/exitLogin.js"></script>
<!-- 轮播 -->
<script type="text/javascript">
	var n = 0;
	var timer = null;
	//开启定时器(做下个次动作)
	timer = setInterval(next, 4000);
	//鼠标移入关闭定时器
	$('.banner').mouseover(function() {
		clearInterval(timer);
	});

	//鼠标移出关闭定时器
	$('.banner').mouseout(function() {
		timer = setInterval(next, 3000)
	});

	//下一次方法
	function next() {
		n++;
		if (n > 4) {
			n = 0;
		}
		$('.banner ul li').eq(n).show().siblings().hide();
		$('.dot span').eq(n).addClass('current').siblings().removeClass(
				'current');
	};

	$('.dot span').each(
			function(i) {
				$(this).click(
						function() {
							if ($('.banner ul li').eq(n).is(':animated')) {
								return;
							}
							n = i;
							$('.banner ul li').eq(n).show().siblings().hide();
							$('.dot span').eq(n).addClass('current').siblings()
									.removeClass('current');
						});
			});
</script>
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
<script type="text/javascript">
	function overFn(obj) {
		$(obj).css("background", "deeppink");
	}
	function outFn(obj) {
		$(obj).css("background", "#fff");
	}

	function clickFn(obj) {
		$("#search").val($(obj).html());
		$("#showDiv").css("display", "none");
	}
	function clickFnDle(obj) {
		$("#showDiv").css("display", "none");
	}
	function clear(obj) {
		$("#showDiv").css("display", "none");
	}
	function search() {
		var word = $("#search").val();
		window.location.href = '${pageContext.request.contextPath}/searchList?name='
				+ word;
	}

	//键盘抬起事件
	function searchWord(obj) {
		//1、获得输入框的输入的内容
		var word = $(obj).val();
		//2、根据输入框的内容去数据库中模糊查询---List<Product>
		var content = "";
		$
				.post(
						"${pageContext.request.contextPath}/searchWord",
						{
							"word" : word
						},
						function(data) {
							//3、将返回的商品的名称 现在showDiv中
							if (data.length > 0) {
								for (var i = 0; i < data.length; i++) {
									content += "<div style='padding:5px;cursor:pointer;width: 441px' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"
											+ data[i] + "</div>";
								}
								content += "<div style='padding:5px;cursor:pointer;width: 441px;height:12px;position:relative'><span style='display:inline-block;border:solid deeppink 1px;border-radius:5px;text:center;color:deeppink;font-size:15px;position:absolute;left:404px;top:-3px' onclick='clickFnDle(this)'>关闭✘</span></div>"
								$("#showDiv").html(content);
								$("#showDiv").css("display", "block");
							}

						}, "json");

	}
</script>
<script src="js/ydxLazyLoad.js" type="text/javascript" charset="utf-8"></script>
<script src="js/index.js" type="text/javascript" charset="utf-8"></script>