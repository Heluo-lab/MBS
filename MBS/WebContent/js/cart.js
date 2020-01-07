//做公共页面的数据!!!
//公共的前缀
var URL = 'http://www.wjian.top/shop/';
var count = 1;
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
			  console.log("hot");
			  var re = JSON.parse(result);
			  $('.hot').empty('ul');
			  $.each(re,function(i,obj){
				  //清空.hot
				  //数据渲染
				  var str = `
					  <ul>
					  <li><a href="product.html?goods_id=${obj.goodsId}" id="${obj.goodsId}" target="_blank">
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
			  });
				  
				  //马上做图片预加载
				  $('.hot [lazyLoadSrc]').YdxLazyLoad();
				  $(".join").click(function(){
					  var goods = $(this).siblings(":first").children("a").attr("id");
					  $.get({
						  type:"post",
						  url:"addcart",
						  data:"id="+goods,
						  success:function(result){
							  var obj = JSON.parse(result);
							  var str1 = `
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
								  <a href="order"><button class="buy">去结算</button></a>
								  </div>
								  </div>
								  </div>
								  `;
							  var str = `
								  <tr>
									  <input type="hidden" class="cartgoodsid" value="${goods}" />
									  <td><input type="checkbox" class="check"checked data-check="active"/></td>
									  <td class="goods-img"><img lazyLoadSrc="${obj.showImage}" src="img/loading.gif" /></td>
									  <td class="goods-content"><a href="javascript:;" style="text-decoration:none;">${obj.goodsName}<p>尺寸：<span class="size">${obj.sizes}</span> 颜色：<span class="color">${obj.colour }</span></p></a></td>
									  <td class="goods-price">${obj.price}</td>
									  <td class="goods-nub">
									  <a href="javascript:;" class="minus" style="text-decoration:none;" onclick="">-</a><button class="goods-num">1</button><a href="javascript:;" class="add" style="text-decoration:none;">+</a>
									  </td>
									  <td class="subtotal">${obj.price}</td>
									  <td><a href="javascript:;" class="del-btn" style="text-decoration:none;">删除</a></td>
								  </tr>
								  `;
							  if($('.goods-priceAll-right').html()==null){
								  $('#buygoods').append(str1);
							  }
							  //判断有无商品有则获得fff为true并且拿到它
							  var fff = false;
							  var g;
							  for (var i = 0; i < $("#table").children().children().length; i++) {
								  if ( $('.cartgoodsid').eq(i).val()==goods) {
									  fff = true;
									  g = $('.cartgoodsid').eq(i);
								  }
							  }
							  //存在则num++否则添加新的
							  var num;
							  if (fff) {
								  num = g.siblings(".goods-nub").children('.goods-num').html();
								  num++;
								  g.siblings(".goods-nub").children('.goods-num').html(num);
								  var unitPrice = parseInt(g.siblings('.goods-price').html());
								  var subtotal = g.siblings('.subtotal');
								  subtotal.html(num * unitPrice + '.00');
							  }else{
								  num=1;
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
							  $.ajax({
								  type:"post",
								  url:"addcartdata",
								  data:"goodsid="+goods+"&goodsnum="+num+"&size="+obj.size+"&color="+obj.color,
								  success:function(result){
									  console.log("success");
								  }
							  });
							  $(priceAll());
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
			  var re = JSON.parse(result);
			  $('.hot').empty('ul');
			  $.each(re,function(i,obj){
				  //清空.hot
				  //数据渲染
				  console.log(obj.goodsId);
				  var str = `
					  <ul>
					  <li><a href="product.html?goods_id=${obj.goodsId}" id="${obj.goodsId}" target="_blank">
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
			  });
				  
				  //马上做图片预加载
				  $('.hot [lazyLoadSrc]').YdxLazyLoad();
				  $(".join").click(function(){
					  var goods = $(this).siblings(":first").children("a").attr("id");
					  $.get({
						  type:"post",
						  url:"addcart",
						  data:"id="+goods,
						  success:function(result){
							  var obj = JSON.parse(result);
							  var str1 = `
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
								  <a href="order"><button class="buy">去结算</button></a>
								  </div>
								  </div>
								  </div>
								  `;
							  var str = `
								  <tr>
									  <input type="hidden" class="cartgoodsid" value="${goods}" />
									  <td><input type="checkbox" class="check" checked data-check="active"/></td>
									  <td class="goods-img"><img lazyLoadSrc="${obj.showImage}" src="img/loading.gif" /></td>
									  <td class="goods-content"><a href="javascript:;" style="text-decoration:none;">${obj.goodsName}</a><p>尺寸：<span class="size">${obj.sizes}</span> 颜色：<span class="color">${obj.colour }</span></p></td>
									  <td class="goods-price">${obj.price}</td>
									  <td class="goods-nub">
									  <a href="javascript:;" class="minus" style="text-decoration:none;" onclick="">-</a><button class="goods-num">1</button><a href="javascript:;" class="add" style="text-decoration:none;">+</a>
									  </td>
									  <td class="subtotal">${obj.price}</td>
									  <td><a href="javascript:;" class="del-btn" style="text-decoration:none;">删除</a></td>
								  </tr>
								  `;
							  if($('.goods-priceAll-right').html()==null){
								  $('#buygoods').append(str1);
							  }
							  //判断有无商品有则获得fff为true并且拿到它
							  var fff = false;
							  var g;
							  for (var i = 0; i < $("#table").children().length; i++) {
								  if ( $('.cartgoodsid').eq(i).val()==goods) {
									  fff = true;
									  g = $('.cartgoodsid').eq(i);
								  }
							  }
							  //存在则num++否则添加新的
							  var num;
							  if (fff) {
								  num = g.siblings(".goods-nub").children('.goods-num').html();
								  num++;
								  g.siblings(".goods-nub").children('.goods-num').html(num);
								  var unitPrice = parseInt(g.siblings('.goods-price').html());
								  var subtotal = g.siblings('.subtotal');
								  subtotal.html(num * unitPrice + '.00');
							  }else{
								  num=1;
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
							  $.ajax({
								  type:"post",
								  url:"addcartdata",
								  data:"goodsid="+goods+"&goodsnum="+num+"&size="+obj.size+"&color="+obj.color,
								  success:function(result){
									  console.log("success");
								  }
							  });
							  $(priceAll());
						  }
					  });
					  $(priceAll());
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

var lock = false;
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
      var nowNum = parseInt($(this).parent().siblings('.goods-nub').children(".goods-num").html());
      var goods = $(this).parent().siblings('.cartgoodsid').val();
      var size = $(this).parent().siblings('.goods-content').children("p").children(".size").html();
      var color = $(this).parent().siblings('.goods-content').children("p").children(".color").html();
      $.ajax({
  		  type:"post",
  		  url:"addcartdata",
  		  data:"goodsid="+goods+"&goodsnum="+nowNum+"&size="+size+"&color="+color,
  		  success:function(result){
  			  console.log("success");
  		  }
  	  });
    }else{
      //删除标识
      $(this).attr('data-check', '');
      var goods = $(this).parent().siblings('.cartgoodsid').val();
      var size = $(this).parent().siblings('.goods-content').children("p").children(".size").html();
      var color = $(this).parent().siblings('.goods-content').children("p").children(".color").html();
      $.ajax({
  		  type:"post",
  		  url:"deletecart",
  		  data:"goodsid="+goods+"&size="+size+"&color="+color,
  		  success:function(result){
  			  console.log("success");
  		  }
  	  });
    };
    //求总价
    priceAll();
  });
  
  //点击加
  $('.add').click(function add(){
	//先判断锁状态
	  if(lock){
		  return;
	  };
	  //上锁
	  lock = true;
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
    var goods = $(this).parent().siblings('.cartgoodsid').val();
    var size = $(this).parent().siblings('.goods-content').children("p").children(".size").html();
    var color = $(this).parent().siblings('.goods-content').children("p").children(".color").html();
    $.ajax({
		  type:"post",
		  url:"addcartdata",
		  data:"goodsid="+goods+"&goodsnum="+nowNum+"&size="+size+"&color="+color,
		  success:function(result){
			  console.log("success");
		  }
	  });
    setTimeout(function(){
        //oBtn.disabled = false;
        //开锁
        lock = false;
      },500)
  });
  
  //点击减
  $('.minus').click(function minus(){
	//先判断锁状态
	  if(lock){
		  return;
	  };
	  //上锁
	  lock = true;
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
    var goods = $(this).parent().siblings('.cartgoodsid').val();
    var size = $(this).parent().siblings('.goods-content').children("p").children(".size").html();
    var color = $(this).parent().siblings('.goods-content').children("p").children(".color").html();
    $.ajax({
		  type:"post",
		  url:"addcartdata",
		  data:"goodsid="+goods+"&goodsnum="+nowNum+"&size="+size+"&color="+color,
		  success:function(result){
			  console.log("success");
		  }
	  });
    setTimeout(function(){
        //oBtn.disabled = false;
        //开锁
        lock = false;
      },500)
  });
  
  //点击删除
  $('.del-btn').click(function deleteCart(){
	//先判断锁状态
	  if(lock){
		  return;
	  };
	  //上锁
	  lock = true;
    //删除接口  有number
    //一定是等到请求完成并且后台显示删除成功之后，才能把节点删除   
	if(confirm("你确定提交吗？")){
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
		var goods = $(this).parent().siblings('.cartgoodsid').val();
		var size = $(this).parent().siblings('.goods-content').children("p").children(".size").html();
		var color = $(this).parent().siblings('.goods-content').children("p").children(".color").html();
		$.ajax({
			type:"post",
			url:"deletecart",
			data:"goodsid="+goods+"&size="+size+"&color="+color,
			success:function(result){
				console.log("success");
			}
		});
	}
    setTimeout(function(){
        //oBtn.disabled = false;
        //开锁
        lock = false;
      },500)
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
$(priceAll());