<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>收货地址</title>
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/self.css" />
		<link rel="stylesheet" href="css/self_address.css"/>
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
								<li><a href="self_userinfo.jsp">基本信息</a></li>
								<li><a href="javascript:void(0)" class="active">收获地址</a></li>
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
						填写地址
					</div>
					<div class="bottom">
						<div class="close" id="add">新增收获地址</div>
						<div class="new-address" style="display: none;">
							<table id="addRece">
								<tr>
									<td><span>*</span>收货姓名：</td>
									<td>
										<input type="hidden" value="" class="hid">
										<input type="text" name="receName" />
										<span id="receNameSpan"></span>
									</td>
								</tr>
								<tr>
									<td><span>*</span>省/市/区县：</td>
									<td>
										<select id="prov" onchange="showCity(this)">
											<option>-请选择省份-</option>
										</select>
										<select id="city" onchange="showCountry(this)">
											<option>-请选择城市-</option>
										</select>
										<select id="country" onchange="selectCountry(this)">
											<option>-请选择区域-</option>
										</select>
										<span id="receAddSpan"></span>
									</td>
								</tr>
								<tr>
									<td><span>*</span>联系地址：</td>
									<td>
										<input type="text" name="receAddressDetaile"/>&nbsp;为能精确配送，请详细录入街道/路段
										<span id="detaile"></span>
									</td>
								</tr>
								<tr>
									<td><span>*</span>电话：</td>
									<td>
										<input type="text" name="recePhone" />
										<span id="recePhoneSpan"></span>
									</td>
								</tr>
								<tr>
									<td></td>
									<td>
										<input type="button" value="保存新增" id="saveReceBtn" status="0"/>
										<span id="checkAddInfo"></span>
									</td>
								</tr>
							</table>
						</div>
						<div class="my-address">
							<table cellpadding="0" cellspacing="0" id="receAddressTable">
								<thead>
									<tr>
										<th>收货人</th>
										<th>省/市/县区</th>
										<th>联系地址</th>
										<th>电话/手机</th>
										<th>操作</th>
										<th>默认地址</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${receList }" var="rece"> 
										<tr class="addressInfo">
											<td class="receNameTd">${rece.receName }</td>
											<td class="receAddTd">${rece.receAddressProv } ${rece.receAddressCity } ${rece.receAddressCountry }</td>
											<td class="receDetaileTd">${rece.receAddressDetaile }</td>
											<td class="recePhoneTd">${rece.recePhone }</td>
											<td><a href="javascript:void(0)" onclick="updateRece(this)">修改</a>|<a href="javascript:void(0)" onclick="deleteRece('${rece.receId }')">删除</a></td>
											<td>
												<c:if test="${rece.isDefault==1 }">
													<input type="radio" name="isDefault" checked />
												</c:if>
												<c:if test="${rece.isDefault==0 }">
													<input type="radio" name="isDefault" />
												</c:if>
												<input type="hidden" value="${rece.receId }" class="hid">
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
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
<script src="js/province.js"></script>
<script>
	$('#add').click(function(){
		if($('.new-address').css('display') == 'none'){
			$(this).removeClass('close').addClass('open');
			$('.new-address').slideDown();
			return;
		}
		$(this).removeClass('open').addClass('close');
		$('.new-address').slideUp();
		$(this).html("新增收货地址");
		clearInfo();
	});
	//清空填入的信息
	function clearInfo(){
		$("#addRece input[type='button']").val("保存新增");
		$("#addRece input[name='receName']").val("");
		$("#prov option").each(function(i){
			if($(this).html()=="-请选择省份-"){
				$(this).prop("selected",true);
				showCity($(this).parent().get(0));
				return;
			}
		});
		$("#addRece input[name='receAddressDetaile']").val("");
		$("#addRece input[name='recePhone']").val("");
	}
	//收货人校验正则表达式
	var nameRegex = /^(\w|[\u4e00-\u9fa5]){2,8}$/;
	//收货电话校验正则表达式
	var phoneRegex = /1\d{10}/;
	//保存地址
	$("#saveReceBtn").click(function(){
		$("#receNameSpan").html("");
		$("#recePhoneSpan").html("");
		$("#receAddSpan").html("");
		$("#detaile").html("");
		//$("#receNameSpan").css("color","red");
		//$("#recePhoneSpan").css("color","red");
		//$("#receAddSpan").css("color","red");
		//校验收货人
		var receName = $("#addRece input[name='receName']").val().trim();
		if(""==receName){
			$("#receNameSpan").html("请输入收货人");
			return;
		}
		if(!nameRegex.test(receName)){
			//console.log(receName.length);
			$("#receNameSpan").html("限输入2至8位由数字字母或汉字组成的收货名");
			return;
		}
		//校验收货地址
		var prov = $("#prov").find('option:selected').html();
		var city = $("#city").find('option:selected').html();
		var country = $("#country").find('option:selected').html();
		if("-请选择省份-"==prov || "-请选择城市-"==city || "-请选择区域-"==country){
			$("#receAddSpan").html("请选择收货地址");
			return;
		}
		//校验详细街道
		var receAddressDetaile = $("#addRece input[name='receAddressDetaile']").val().trim();
		if(""==receAddressDetaile){
			$("#detaile").html("请填写详细街道/路段");
			return;
		}
		//校验收货电话
		var recePhone = $("#addRece input[name='recePhone']").val().trim();
		if(""==recePhone){
			$("#recePhoneSpan").html("请输入收货号码");
			return;
		}
		if(!phoneRegex.test(recePhone)){
			$("#recePhoneSpan").html("请输入正确的电话号码");
			return;
		}
		//console.log(receName);
		//console.log(prov+"==="+city+"==="+country);
		//console.log(receAddressDetaile+"==="+recePhone);
		var status = $(this).attr("status");
		if(status == 0){
			$.ajax({
				url:"self.power?method=insertReceAddressByUsersId",
				type:"post",
				data:{"receName":receName,"recePhone":recePhone,"receAddressProv":prov,"receAddressCity":city,"receAddressCountry":country,"receAddressDetaile":receAddressDetaile},
				success:function(result){
					var reces = JSON.parse(result);
					//console.log(result.length);
					$(".my-address tbody").html("");
					var str = "";
					for(var i = 0 ; i <reces.length; i++ ){
						str = "<tr class='addressInfo'><td class='receNameTd'>"+reces[i].receName+"</td><td class='receAddTd'>"+reces[i].receAddressProv+" "+reces[i].receAddressCity+" "+reces[i].receAddressCountry+"</td><td class='receDetaileTd'>"+reces[i].receAddressDetaile+"</td><td class='recePhoneTd'>"+reces[i].recePhone+"</td><td><a href='javascript:void(0)' onclick='updateRece(this)'>修改</a>|<a href='javascript:void(0)' onclick='deleteRece(this)'>删除</a></td><td>";
						if(reces[i].isDefault==1){
							str = str + "<input type='radio' name='isDefault' checked  />"
						}else{
							str = str + "<input type='radio' name='isDefault' />"
						}
						str = str + "<input type='hidden' value="+reces[i].receId+" class='hid'></td></tr>"	
						$(str).appendTo($(".my-address tbody"));
					}
					$("#add").removeClass('open').addClass('close');
					$('.new-address').slideUp();
					clearInfo();
					$(".my-address tbody input[name='isDefault']").each(function(){
						$(this).bind("click",setDefultAddress);
					});
				},
				error:function(){
					//console.log("添加失败");
				}
			});
		}else if(status == 1){
			var receId = $("#addRece .hid").val().trim();
			$.ajax({
				url:"self.power?method=updateReceAddressByUsersIdAndReceId",
				type:"post",
				data:{"receName":receName,"recePhone":recePhone,"receAddressProv":prov,"receAddressCity":city,"receAddressCountry":country,"receAddressDetaile":receAddressDetaile,"receId":receId},
				success:function(result){
					reces = JSON.parse(result);
					//console.log(result.length);
					$(".my-address tbody").html("");
					var str = "";
					for(var i = 0 ; i <reces.length; i++ ){
						str = "<tr class='addressInfo'><td class='receNameTd'>"+reces[i].receName+"</td><td class='receAddTd'>"+reces[i].receAddressProv+" "+reces[i].receAddressCity+" "+reces[i].receAddressCountry+"</td><td class='receDetaileTd'>"+reces[i].receAddressDetaile+"</td><td class='recePhoneTd'>"+reces[i].recePhone+"</td><td><a href='javascript:void(0)' onclick='updateRece(this)'>修改</a>|<a href='javascript:void(0)' onclick='deleteRece(this)'>删除</a></td><td>";
						if(reces[i].isDefault==1){
							str = str + "<input type='radio' name='isDefault' checked  />"
						}else{
							str = str + "<input type='radio' name='isDefault' />"
						}
						str = str + "<input type='hidden' value="+reces[i].receId+" class='hid'></td></tr>"	
						$(str).appendTo($(".my-address tbody"));
					}
					$("#add").removeClass('open').addClass('close');
					$('.new-address').slideUp();
					clearInfo();
					$(".my-address tbody input[name='isDefault']").each(function(){
						$(this).bind("click",setDefultAddress);
					});
				},
				error:function(){
					console.log("修改失败");
				}
			});
			$(this).attr("status","0");
			
		}
		$('#add').html("新增收货地址");
	});
	
	//修改收货地址
	function updateRece(obj){
		$("#saveReceBtn").attr("status","1");
		var tr = $(obj).parent().parent();
		var receId = tr.find(".hid").val();
		$("#addRece .hid").val(receId);
		var receName = tr.find(".receNameTd").html().trim();
		var receAdd = tr.find(".receAddTd").html().trim();
		var addArr = receAdd.split(" ");
		var prov = addArr[0];
		var city = addArr[1];
		var country = addArr[2];
		var receDetaile = tr.find(".receDetaileTd").html().trim();
		var recePhone = tr.find(".recePhoneTd").html().trim();
		$("#addRece input[name='receName']").val(receName);
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
		$("#addRece input[name='receAddressDetaile']").val(receDetaile);
		$("#addRece input[name='recePhone']").val(recePhone);
		
		$("#add").html("取消修改");
		$("#add").removeClass('colse').addClass('open');
		$('.new-address').slideDown();
		$("#addRece input[type='button']").val("保存修改");
		//var prov = $("#prov").find('option:selected').html();
		//var city = $("#city").find('option:selected').html();
		//var country = $("#country").find('option:selected').html();
	}
	
	//删除收货地址
	function deleteRece(obj){
		if(confirm("您确定要删除该收货地址吗?")){
			var tr = $(obj).parent().parent();
			var receId = tr.find(".hid").val();
			$.ajax({
				url:"self.power?method=deleteReceAddressByUsersIdAndReceId",
				data:"receId="+receId,
				type:"post",
				success:function(result){
					reces = JSON.parse(result);
					//console.log(result.length);
					$(".my-address tbody").html("");
					var str = "";
					for(var i = 0 ; i <reces.length; i++ ){
						str = "<tr class='addressInfo'><td class='receNameTd'>"+reces[i].receName+"</td><td class='receAddTd'>"+reces[i].receAddressProv+" "+reces[i].receAddressCity+" "+reces[i].receAddressCountry+"</td><td class='receDetaileTd'>"+reces[i].receAddressDetaile+"</td><td class='recePhoneTd'>"+reces[i].recePhone+"</td><td><a href='javascript:void(0)' onclick='updateRece(this)'>修改</a>|<a href='javascript:void(0)' onclick='deleteRece(this)'>删除</a></td><td>";
						if(reces[i].isDefault==1){
							str = str + "<input type='radio' name='isDefault' checked  />"
						}else{
							str = str + "<input type='radio' name='isDefault' />"
						}
						str = str + "<input type='hidden' value="+reces[i].receId+" class='hid'></td></tr>"	
						$(str).appendTo($(".my-address tbody"));
					}
					$(".my-address tbody input[name='isDefault']").click(setDefultAddress);
				},
			});
		}
	}
	$(".my-address tbody input[name='isDefault']").click(setDefultAddress);
	function setDefultAddress(){
		var receId = $(this).siblings(".hid").val();
		$.ajax({
			url:"self.power",
			data:{"receId":receId,"method":"setDefaultAddressByUsersIdAndReceId"},
			type:"post",
			success:function(result){
				if(result=='true'){
					alert("修改默认地址成功");
				}else if(result=='false'){
					alert("修改默认地址失败");
				}
			}
		});
	}
</script>