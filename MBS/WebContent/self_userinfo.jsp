<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>个人基本信息</title>
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/self.css" />
		<link rel="stylesheet" href="css/self_userinfo.css"/>
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
		<!--主体-->
		<section>
			<div class="member-label">
				<a href="self.power?method=querySingleUser">首页</a>>
				<a href="self.power?method=querySingleUser">个人中心</a>
			</div>
			<div class="section-self">
				<div class="section-self-left">
					<div class="section-self-left-content">
						<div class="lelf-menu">
							<ul>
								<li><a href="cart.html">我的购物车</a></li>
								<li><a href="self_order.html">我的订单</a></li>
								<li><a href="shop_order.html">门店订单</a></li>
								<li><a href="self_mypointment.html">我的预约</a></li>
								<li><a href="self.power?method=queryCollectGoodsByUsersId">我的收藏</a></li>
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
							<h1 class="showon option" status='0'>个人信息</h1>
							<ul style="display: block;">
								<li><a href="javascript:void(0)" class="active">基本信息</a></li>
								<li><a href="self_address.html">收获地址</a></li>
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
					<div class="menu">
						<ul>
							<li class="on"><a href="javascript:void(0)">基本资料</a></li>
							<!-- 
								<li><a href="javascript:void(0)">个人资料</a></li>
								<li><a href="javascript:void(0)">个人尺码资料</a></li>
							 -->
						</ul>
					</div>
					<div class="info">
						<form id="self_form" method="post" action="upload" enctype="multipart/form-data" status="1">
							<div class="info-header">
								<table>
									<tr>
										<td rowspan="3" class="in-img"  style="position:relative">
										  <img src="${usersInfo.usersPic }" class="header-img" id="img" style="width:100px;height:100px;border-radius:50%;position:absolute;left:20px;top:20px"/>
										  <input type="file" id="file" name="usersPic" onchange="show(this)" style="width:100px;height:100px;;border-radius:50%;position:absolute;left:20px;top:20px;opacity:0">
										</td>
										<td><span></span>邮件：</td>
										<td>${usersInfo.accountEmail }</td>
									</tr>
									<tr>
										<!--<td></td>-->
										<td><span></span>手机：</td>
										<td>${usersInfo.usersPhone } </td>
									</tr>
									<tr>
										<!--<td></td>-->
										<td><span>&nbsp;</span>生日：</td>
										<td>
										<!-- 
											<select>
												<option>-请选择年份-</option>
												<option>1990</option>
												<option>2000</option>
												<option>2010</option>
											</select>
											<select>
												<option>-请选择月份-</option>
												<option>1月</option>
												<option>2月</option>
												<option>3月</option>
											</select>
											<select>
												<option>-请选择日期-</option>
												<option>1日</option>
												<option>11日-</option>
												<option>21日</option>
											</select>
										 -->
										 <input type="date" name="usersBirth" value="${usersInfo.usersBirth }">
										</td>
									</tr>
								</table>
							</div>
							<div class="info-body">
								<table>
									<tr>
										<td><span>*</span>用户名：</td>
										<%-- begin 表示初始账号呢称 --%>
										<td>
											<input type="text" name="accountName" value="${usersInfo.accountName }" id="accountName" begin="${usersInfo.accountName }"/>
											<span style="dispaly:none" id="checkNameSpan"></span>
										</td>
									</tr>
									<tr>
										<td><span>*</span>省/市/区县：</td>
										<td>
											<input type="hidden" id="info" sex="${usersInfo.usersSex }" prov="${usersInfo.usersAddressProv }" city="${usersInfo.usersAddressCity }" country="${usersInfo.usersAddressCountry }">
											<select id="prov" onchange="showCity(this)">
												<option>-请选择省份-</option>
												<!-- 
													<option>湖南省</option>
													<option>湖北省</option>
													<option>浙江省</option>
												 -->
											</select>
											<select id="city" onchange="showCountry(this)">
												<option>-请选择城市-</option>
												<!-- 
													<option></option>
													<option></option>
													<option></option>
												 -->
											</select>
											<select id="country" onchange="selectCountry(this)">
												<option>-请选择区域-</option>
												<!-- 
													<option></option>
													<option></option>
													<option></option>
												 -->
											</select>
											<input type="hidden" name="usersAddressProv" value="">
											<input type="hidden" name="usersAddressCity" value="">
											<input type="hidden" name="usersAddressCountry" value="">
										</td>
									</tr>
									<tr>
										<td><span>*</span>性别：</td>
										<td style="font-size: 16px;">
											<label style="margin-right: 10px;">男：<input type="radio" name="usersSex" value="男"/></label>
											<label>女：<input type="radio" name="usersSex" value="女"/></label>
										</td>
									</tr>
									<tr>
										<td><span>&nbsp;&nbsp;</span>电话：</td>
										<td>
											<input type="text" name="usersPhone" value="${usersInfo.usersPhone }" id="usersPhone" begin="${usersInfo.usersPhone }"/>
											<span id="checkPhoneSpan"></span>
										</td>
									</tr>
									<tr>
										<td></td>
										<td><input type="button" value="提交" id="form_submit"/><span id="no-submit"></span></td>
									</tr>
								</table>
							</div>
						</form>
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
<script src="js/isLogin.js"></script>
<script src="js/province.js"></script>
<script>
	$("#accountName").blur(function(){
		var begin = $(this).attr("begin");
		var val = $(this).val().trim();
		if(val==""){
			$("#checkNameSpan").css("color","red");
			$("#checkNameSpan").html("请填写用户名");
			return;
		}
		$("#self_form").attr("status","1");
		if(begin != val){
			$.ajax({
				url:"accountName",
				type:"post",
				data:"registername="+val,
				success:function(result){
					$("#checkNameSpan").css("display","inline-block");
					if(result==true){
						$("#checkNameSpan").css("color","red");
						$("#checkNameSpan").html("此用户名已存在");
						$("#self_form").attr("status","0");
					}
					if(result==false){
						$("#checkNameSpan").css("color","green");
						$("#checkNameSpan").html("用户名可用");
					}
				}
			});
		}else{
			$("#checkNameSpan").html("");
		}
	});
	$("#usersPhone").blur(function(){
		//11位的电话号码
		$("#self_form").attr("status","1");
		var regex = /^\d{11}$/g;
		var begin = $(this).attr("begin");
		var val = $(this).val().trim();
		if(begin == val){
			$("#checkPhoneSpan").html("");
			return;
		}
		if(!regex.test(val)){
			$("#checkPhoneSpan").html("请填写正确的手机号");
			$("#self_form").attr("status","0");
		}else{
			$("#checkPhoneSpan").html("");
		}
	});
	$("#form_submit").click(function(){
		var status = $("#self_form").attr("status");
		if(status=="0"){
			$("#no-submit").css("color","red");
			$("#no-submit").html("请确定信息是否填写正确");
			return;
		}
		$("#no-submit").html("");
		var self_form = $("#self_form");
		var form_prov = $("#prov").find('option:selected').html();
		var form_city = $("#city").find('option:selected').html();
		var form_country = $("#country").find('option:selected').html();
		$("[name='usersAddressProv']").val(form_prov);
		$("[name='usersAddressCity']").val(form_city);
		$("[name='usersAddressCountry']").val(form_country);
		$("#self_form").submit();
	});
	//将查询到的用户信息展示
	$(function(){
		var prov = $("#info").attr("prov");
		var city = $("#info").attr("city");
		var country = $("#info").attr("country");
		var sex = $("#info").attr("sex");
		$("[name='usersSex']").each(function(){
			if($(this).val()==sex){
				$(this).prop("checked",true);
				return;
			}
		});
		//$("#city").css("display","inline-block");
		//$("#country").css("display","inline-block");
		$("#prov option").each(function(i){
			if($(this).html()==prov){
				$(this).prop("selected",true);
				showCity($(this).parent().get(0));
				return;
			}
		});
		$("#city option").each(function(i){
			if($(this).html()==city){
				$(this).prop("selected",true);
				showCountry($(this).parent().get(0));
				return;
			}
		});
		$("#country option").each(function(i){
			if($(this).html()==country){
				$(this).prop("selected",true);
				return;
			}
		});
	})
	//头像本地加载
	function show(o){
		var read = new FileReader();
		var file = o.files[0];
		read.readAsDataURL(file);
		read.onload = function(e){
			var content = e.target.result;
			document.getElementById("img").src=content;
		};
	}

</script>