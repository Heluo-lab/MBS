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


$(function(){
  $.get(URL + 'api_goods.php',{'page':1, 'pagesize':3}, function(re){
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
			<td><input type="checkbox" class="check" data-check="active" /></td>
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
    console.log($('#table').children().length);
	$(function(){
	if ($('#table').children().length != 0) {
   			$('.has-goods').show();
   			$('.no-sign').hide();
   			$('.had-sign').hide();
   		} else{
			$('.has-goods').hide();
   		}
	});
  });
});

//求总价的方法
$(function priceAll(){
  //判断所有单选有没有选中
  //拿到有属性data-check="active"的元素
  var priceSum = 0;
  $('[data-check="active"]').each(function(){
    priceSum += parseInt($(this).parent().siblings('.subtotal').html())
    console.log(priceSum);
  });
  //给到总价元素
  $('.price-all').html('<span>折后商品金额总计：</span>¥' + priceSum + '.00');
});