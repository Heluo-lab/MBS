//做公共页面的数据!!!
//公共的前缀
var URL = 'http://www.wjian.top/shop/';



//判断用户登录状态方法
$(function checkLogin(){
	if(localStorage.getItem('username') && localStorage.getItem('token')){
   	 //用户登录了
    	$('.message-no').css('display','none');
    	$('.message-yes .userid').show().html('你好' + localStorage.getItem('username') + '<span>　|</span>');
   		$('.message-yes').show();
		$('.has-goods').hide();
   		$('.no-sign').hide();
   		$('.had-sign').show();
   		$('.shopcar').css('height','261px')
   }else{
   		//用户没登录了
   		$('.has-goods').hide();
   		$('.no-sign').show();
   		$('.had-sign').hide();
		$('.shopcar').css('height','261px')
   	}
});
$('.exit-btn').click(function(){
	localStorage.removeItem('username');
localStorage.removeItem('t	oken');
	$('.message-yes').hide();
  	$('.message-no').show();
    $('.no-sign').show();
   	$('.had-sign').hide();
});

//添加购物车
$(function(){
  $.get(URL + 'api_goods.php',{'page':1, 'pagesize':0}, function(re){
    var obj = JSON.parse(re);
    console.log(obj);
    //验证
    if(obj.code != 0){
      console.log(obj.message);
      return;
    };
    var listArr = obj.data;
    //遍历数组数据
    for(var i = 0; i < listArr.length; i++){
      var str = `
      	<tr>
			<td><input type="checkbox" class="check" /></td>
			<td class="goods-img"><img lazyLoadSrc="${listArr[i].goods_thumb}" src="img/loading.gif" /></td>
			<td class="goods-content"><a href="javascript:;">${listArr[i].goods_name}</a></td>
			<td class="goods-price">${listArr[i].price}</td>
			<td class="goods-nub">
				<a href="javascript:;" class="minus">-</a><button class="goods-num">1</button><a href="javascript:;" class="add">+</a>
			</td>
			<td class="subtotal">${listArr[i].price}</td>
			<td><a href="javascript:;" class="del-btn">删除</a></td>
		</tr>
      `;
      //循环内,组装好一个添加一个 
      $('#table').append(str);
    };
    //循环体外图片预加载
    $('#table [lazyLoadSrc]').YdxLazyLoad();
    //数据结构渲染到页面这后才能交互操作
    cartEvent();
    //判断有无商品
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
	
	
	
  });
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



//打开页面请求分类商品
$(function(){
  //请求当前分类 下的商品
  $.get(URL + 'api_goods.php', {'cat_id':45, 'page':1, 'pagesize':5}, function(re){
    var obj = JSON.parse(re);
    console.log(obj);
    //验证数据
    if(obj.code == 1){
      console.log(obj.message);
      //当前分类下面没有商品
      return;
    };
    if(obj.code != 0){
      console.log(obj.message);
      return;
    };
    //有商品，渲染到页面
    var listArr = obj.data;
    
    //数据渲染
    for(var i = 0; i < listArr.length; i++){
      var str = `
      	<ul>
			<li><a href="product.html?goods_id=${listArr[i].goods_id}" target="_blank">
				<img src="img/loading.gif" lazyLoadSrc="${listArr[i].goods_thumb}" />
				</a>
			</li>
			<li>${listArr[i].goods_name}</li>
			<li>${listArr[i].price}</li>
			<a href="javascript:;" class="join">加入购物车</a>
		</ul>
      `;
      //内部组装一个添加一个
      $('.hot').append(str);         
    };
    //马上做图片预加载
    $('.hot [lazyLoadSrc]').YdxLazyLoad(); 
    
    
    
    //热门商品添加购物车
    $(".join").click(function(){
		$.get(URL + 'api_goods.php', {'goods_id':listArr[$('.hot .join').index(this)].goods_id, 'page':1, 'pagesize':1}, function(re){
	    var obj = JSON.parse(re);
	    console.log(obj);
	    //验证数据
	    if(obj.code == 1){
	      console.log(obj.message);
	      //当前分类下面没有商品
	      return;
	    };
	    if(obj.code != 0){
	      console.log(obj.message);
	      return;
	    };
	    //有商品，渲染到页面
	    var listArr = obj.data;
	    
	    //数据渲染
	    for(var i = 0; i < listArr.length; i++){
	      var str = `
	      	<tr>
				<td><input type="checkbox" class="check" /></td>
				<td class="goods-img"><img lazyLoadSrc="${listArr[i].goods_thumb}" src="img/loading.gif" /></td>
				<td class="goods-content"><a href="product.html?goods_id=${listArr[i].goods_id}">${listArr[i].goods_name}</a></td>
				<td class="goods-price">${listArr[i].price}</td>
				<td class="goods-nub">
					<a href="javascript:;" class="minus">-</a><button class="goods-num">1</button><a href="javascript:;" class="add">+</a>
				</td>
				<td class="subtotal">${listArr[i].price}</td>
				<td><a href="javascript:;" class="del-btn">删除</a></td>
			</tr>
	      `;
	      //内部组装一个添加一个
	      $('#table').append(str);         
	    };
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
	  });
    });
    
  });
});

var id = 69;
function shop(id){
  //请求当前分类 下的商品
  $.get(URL + 'api_goods.php', {'cat_id':id, 'page':1, 'pagesize':5}, function(re){
    var obj = JSON.parse(re);
    console.log(obj);
    //验证数据
    if(obj.code == 1){
      console.log(obj.message);
      //当前分类下面没有商品
      return;
    };
    if(obj.code != 0){
      console.log(obj.message);
      return;
    };
    //有商品，渲染到页面
    var listArr = obj.data;
    
    //清空.hot
    $('.hot').empty('ul');
    //数据渲染
    for(var i = 0; i < listArr.length; i++){
      var str = `
      	<ul>
			<li><a href="product.html?goods_id=${listArr[i].goods_id}" target="_blank">
				<img src="img/loading.gif" lazyLoadSrc="${listArr[i].goods_thumb}" />
				</a>
			</li>
			<li>${listArr[i].goods_name}</li>
			<li>${listArr[i].price}</li>
			<a href="javascript:;" class="join">加入购物车</a>
		</ul>
      `;
      
      //内部组装一个添加一个
      $('.hot').append(str);         
    };
    
    //马上做图片预加载
    $('.hot [lazyLoadSrc]').YdxLazyLoad(); 
    
    //热门商品添加购物车
    $(".join").click(function(){
		$.get(URL + 'api_goods.php', {'goods_id':listArr[$('.hot .join').index(this)].goods_id, 'page':1, 'pagesize':1}, function(re){
	    var obj = JSON.parse(re);
	    console.log(obj);
	    //验证数据
	    if(obj.code == 1){
	      console.log(obj.message);
	      //当前分类下面没有商品
	      return;
	    };
	    if(obj.code != 0){
	      console.log(obj.message);
	      return;
	    };
	    //有商品，渲染到页面
	    var listArr = obj.data;
	    
	    //数据渲染
	    for(var i = 0; i < listArr.length; i++){
	      var str = `
	      	<tr>
				<td><input type="checkbox" class="check" /></td>
				<td class="goods-img"><img lazyLoadSrc="${listArr[i].goods_thumb}" src="img/loading.gif" /></td>
				<td class="goods-content"><a href="javascript:;">${listArr[i].goods_name}</a></td>
				<td class="goods-price">${listArr[i].price}</td>
				<td class="goods-nub">
					<a href="javascript:;" class="minus">-</a><button class="goods-num">1</button><a href="javascript:;" class="add">+</a>
				</td>
				<td class="subtotal">${listArr[i].price}</td>
				<td><a href="javascript:;" class="del-btn">删除</a></td>
			</tr>
	      `;
	      //内部组装一个添加一个
	      $('#table').append(str);         
	    };
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
	  });
    });
    
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
  });
  //大功告成
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

