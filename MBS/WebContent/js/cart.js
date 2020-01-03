//做公共页面的数据!!!
//公共的前缀
var URL = 'http://www.wjian.top/shop/';

$('.exit-btn').click(function(){
	localStorage.removeItem('username');
localStorage.removeItem('t	oken');
	$('.message-yes').hide();
  	$('.message-no').show();
    $('.no-sign').show();
   	$('.had-sign').hide();
});

//返回顶部
$('.backtotop').hover(function(){
	$('.backtotop img').attr('src','img/r10.jpg');
},function(){
	$('.backtotop img').attr('src','img/r5.jpg');
});
$(function(){
	//滚动时间
	$(window).scroll(function(){

		if($(this).scrollTop() > 100){
			$('.backtotop').fadeIn();
		}else{
			$('.backtotop').fadeOut();
		}
	});
	
	$('.backtotop ').click(function(){
		$('html,body').animate({scrollTop:0},0);
		console.log(1);
		return false;
	});
});



//打开页面请求热门商品
$(function(){
	  //请求当前分类 下的商品
	  $.get({
		  type:"post",
		  url:"hotgoods",
		  data:"count="+id,
		  success:function(result){
			  var obj = JSON.parse(result);
			  //清空.hot
			  $('.hot').empty('ul');
			  //数据渲染
				  var str = `
			      	<ul>
						<li><a href="product.html?goods_id=${obj.goodsId}" target="_blank">
							<img src="img/loading.gif" lazyLoadSrc="${obj.showImage}" />
							</a>
						</li>
						<li>${obj.goodsName}</li>
						<li>${obj.price}</li>
						<a href="javascript:;" class="join">加入购物车</a>
					</ul>
			      `;
			      
			      //内部组装一个添加一个
			      $('.hot').append(str);         
			    
			    //马上做图片预加载
			    $('.hot [lazyLoadSrc]').YdxLazyLoad(); 
			    $(".join").click(function(){
					$.get({
						type:"post",
						url:"addcart",
						data:"id="+obj.id,
						success:function(result){
							var obj = JSON.parse(result);
							var str1 = `
								<div class="buygoods">
								<div class="has-goods">
									<div class="goods">
										<div class="goods-title">以下商品由 梦芭莎 发货　免配送费</div>
										<table id="table">
										</table>
									</div>
									<div class="goods-priceAll">
										<div class="goods-priceAll-left">
											<img src="img/qrcodecreate.png" />
										</div>
										<div class="goods-priceAll-right">
											<p class="price-all"><span>折后商品金额总计：</span>¥0.00</p>
											<a href="order.html"><button class="buy">去结算</button></a>
										</div>
									</div>
								</div>
							 `;
							var str = `
						      	<tr>
						      		<input type="hidden" id="cartgoodsid" value="${obj.goodsId}" />
									<td><input type="checkbox" class="check" /></td>
									<td class="goods-img"><img lazyLoadSrc="${obj.showImage}" src="img/loading.gif" /></td>
									<td class="goods-content"><a href="javascript:;">${obj.goodsName}</a></td>
									<td class="goods-price">${obj.price}</td>
									<td class="goods-nub">
										<a href="javascript:;" class="minus">-</a><button class="goods-num">1</button><a href="javascript:;" class="add">+</a>
									</td>
									<td class="subtotal">${obj.price}</td>
									<td><a href="javascript:;" class="del-btn">删除</a></td>
								</tr>
						      `;
							if($('.goods-priceAll-right').html()==null){
								$('#buygoods').append(str1);
							}
							
							if ($('#cartgoodsid').val()==obj.goodsId) {
								var num = $('#cartgoodsid').siblings(".goods-nub").children('.goods-num').html();
								num++;
								$('#cartgoodsid').siblings(".goods-nub").children('.goods-num').html(num);
								var unitPrice = parseInt($('#cartgoodsid').siblings('.goods-price').html());
								var subtotal = $('#cartgoodsid').siblings('.subtotal');
							    subtotal.html(num * unitPrice + '.00');
							}else{
								//内部组装一个添加一个
								$('#table').append(str);         
							}
						    cartEvent();
						    //马上做图片预加载
						    $('#table [lazyLoadSrc]').YdxLazyLoad(); 
						    $(function(){
								if ($('#table').children().length != 0) {
							   			$('.has-goods').show();
							   			$('.no-sign').hide();
							   			$('.had-sign').hide();
							   			$('.buygoods').css('background','white');
							
							   		} else{
										$('.has-goods').hide();
							   		}
								});
						}
					});
			    });
		  }
	  });
});

var id = 69;
function shop(id){
	  //请求当前分类 下的商品
	  $.get({
		  type:"post",
		  url:"hotgoods",
		  data:"count="+id,
		  success:function(result){
			  var obj = JSON.parse(result);
			  console.log(obj.id);
			  //清空.hot
			  $('.hot').empty('ul');
			  //数据渲染
			  var str1 = `
					<div class="buygoods">
					<div class="has-goods">
						<div class="goods">
							<div class="goods-title">以下商品由 梦芭莎 发货　免配送费</div>
							<table id="table">
							</table>
						</div>
						<div class="goods-priceAll">
							<div class="goods-priceAll-left">
								<img src="img/qrcodecreate.png" />
							</div>
							<div class="goods-priceAll-right">
								<p class="price-all"><span>折后商品金额总计：</span>¥0.00</p>
								<a href="order.html"><button class="buy">去结算</button></a>
							</div>
						</div>
					</div>
				 `;
				if($('.goods-priceAll-right').html()==null){
					$('#buygoods').append(str1);
				}
				
				  var str = `
			      	<ul>
						<li><a href="product.html?goods_id=${obj.goodsId}" target="_blank">
							<img src="img/loading.gif" lazyLoadSrc="${obj.showImage}" />
							</a>
						</li>
						<li>${obj.goodsName}</li>
						<li>${obj.price}</li>
						<a href="javascript:;" class="join">加入购物车</a>
					</ul>
			      `;
			      
			      //内部组装一个添加一个
			      $('.hot').append(str);         
			    
			    //马上做图片预加载
			    $('.hot [lazyLoadSrc]').YdxLazyLoad(); 
			    $(".join").click(function(){
					$.get({
						type:"post",
						url:"addcart",
						data:"id="+obj.id,
						success:function(result){
							var obj = JSON.parse(result);
							var str = `
						      	<tr>
						      		<input type="hidden" id="cartgoodsid" value="${obj.goodsId}" />
									<td><input type="checkbox" class="check" /></td>
									<td class="goods-img"><img lazyLoadSrc="${obj.showImage}" src="img/loading.gif" /></td>
									<td class="goods-content"><a href="javascript:;">${obj.goodsName}</a></td>
									<td class="goods-price">${obj.price}</td>
									<td class="goods-nub">
										<a href="javascript:;" class="minus">-</a><button class="goods-num">1</button><a href="javascript:;" class="add">+</a>
									</td>
									<td class="subtotal">${obj.price}</td>
									<td><a href="javascript:;" class="del-btn">删除</a></td>
								</tr>
						      `;
							if ($('#cartgoodsid').val()==obj.goodsId) {
								var num = $('#cartgoodsid').siblings(".goods-nub").children('.goods-num').html();
								num++;
								$('#cartgoodsid').siblings(".goods-nub").children('.goods-num').html(num);
								var unitPrice = parseInt($('#cartgoodsid').siblings('.goods-price').html());
								var subtotal = $('#cartgoodsid').siblings('.subtotal');
							    subtotal.html(num * unitPrice + '.00');
							}else{
								//内部组装一个添加一个
								$('#table').append(str);         
							}
						    cartEvent();
						    //马上做图片预加载
						    $('#table [lazyLoadSrc]').YdxLazyLoad(); 
						    $(function(){
								if ($('#table').children().length != 0) {
							   			$('.has-goods').show();
							   			$('.no-sign').hide();
							   			$('.had-sign').hide();
							   			$('.buygoods').css('background','white');
							
							   		} else{
										$('.has-goods').hide();
							   		}
								});
						}
					});
			    });
		  }
	  });
}

$('.point2').click(function(){
	$('.point1 img').attr('src','img/dian1.gif');
	$('.point2 img').attr('src','img/dian2.gif');
	shop(62);
});

$('.point1').click(function(){
	$('.point1 img').attr('src','img/dian2.gif');
	$('.point2 img').attr('src','img/dian1.gif');
	shop(92);
});

$('.next').click(function(){
	if($('.point1 img').attr('src') == 'img/dian2.gif'){
		$('.point1 img').attr('src','img/dian1.gif');
		$('.point2 img').attr('src','img/dian2.gif');
		shop(62);
	}else{
		$('.point1 img').attr('src','img/dian2.gif');
		$('.point2 img').attr('src','img/dian1.gif');
		shop(92);
	}
	
});

$(function(){
	$('#table [lazyLoadSrc]').YdxLazyLoad();
	cartEvent();
});


//购物车交互操作
function cartEvent(){
  
  //点击全选
  $('.check-all').click(function(){
    //对于表单元素的属性，用prop()
    //console.log($(this).prop('checked'));
    var allVal = $(this).prop('checked');
    if(allVal){
      $('.check').prop('checked', allVal);
      //给选中的元素设置一个标识
      $('.check').attr('data-check', 'active');
    }else{
      $('.check').prop('checked', allVal);
      //删除标识
      $('.check').attr('data-check', '');
    };
    //求总价
    priceAll();
  });
  
  //点击单选
  $('.check').click(function(){
    if($(this).prop('checked')){
      //给选中的元素设置一个标识
      $(this).attr('data-check', 'active');
    }else{
      //删除标识
      $(this).attr('data-check', '');
    };
    //求总价
    priceAll();
  });
  
  //点击加
  $('.add').click(function(){
    //拿到元素中的number值进行++
    var nowNum = parseInt($(this).siblings('.goods-num').html());
    nowNum++;
    //设置数量上限
    nowNum = nowNum >= 10 ? 10 : nowNum;
    //设置
    $(this).siblings('.goods-num').html(nowNum);
    //求小计
    var unitPrice = parseInt($(this).parent().siblings('.goods-price').html());
    var subtotal = $(this).parent().siblings('.subtotal');
    subtotal.html(nowNum * unitPrice + '.00');
    //求总价
    priceAll();
  });
  
  //点击减
  $('.minus').click(function(){
    //拿到元素中的number值进行++
    var nowNum = parseInt($(this).siblings('.goods-num').html());
    nowNum--;
    //设置数量上限
    nowNum = nowNum <= 1 ? 1 : nowNum;
    //设置
    $(this).siblings('.goods-num').html(nowNum);
    //求小计
    var unitPrice = parseInt($(this).parent().siblings('.goods-price').html());
    var subtotal = $(this).parent().siblings('.subtotal');
    subtotal.html(nowNum * unitPrice + '.00');
    //求总价
    priceAll();
  });
  
  //点击删除
  $('.del-btn').click(function(){
    //删除接口  有number
    //一定是等到请求完成并且后台显示删除成功之后，才能把节点删除   
    var tr = $(this).parent().parent();
    tr.remove();
    //求总价
    priceAll();
    var patt1=new RegExp("^\\s+\\s$");
    if($('#table').children().length==0||patt1.test($('#table').children().html())){
    	str=`
    		<div class="had-sign shopcar" style="height: 217px;">
				您的购物车中没有商品，您可以：
				<p><a href="index.html">立即选购商品>></a>></p>
			</div>
    	`;
    		$('#buygoods').html(str);
    		$('#buygoods').css("background","url(img/shopcar.jpg) 200px 62px no-repeat");
    }
  });
};

//求总价的方法
function priceAll(){
  //判断所有单选有没有选中
  //拿到有属性data-check="active"的元素
  var priceSum = 0;
  $('[data-check="active"]').each(function(){
    priceSum += parseInt($(this).parent().siblings('.subtotal').html())
  });
  //给到总价元素
  $('.price-all').html('<span>折后商品金额总计：</span>¥' + priceSum + '.00');
};

