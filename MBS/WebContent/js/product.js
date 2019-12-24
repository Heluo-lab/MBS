//拿传过来的goods_id
var goodsId = parseInt(getUrlVal('goods_id'));
var URL = 'http://www.wjian.top/shop/';
$(function(){
  $.get(URL + 'api_goods.php',{
    'goods_id' : goodsId
  }, function(re){
    var obj = JSON.parse(re);
    console.log(obj);
    if(obj.code != 0){
//    console.log(obj.message);
      return;
    };
    var str = `
      <p>${obj.data[0].goods_name}</p>
      <p>${obj.data[0].goods_desc}</p>
      <p>${obj.data[0].price}</p>
      <p>${obj.data[0].star_number}</p>
//    <p><span class="minus">-</span><span class="num">1</span><span class="add">+</span></p>
//    <a href="javascript:;" class="add-cart" data-goods-id="${obj.data[0].goods_id}">加入购物车</a>
    `;
//  $('.pro-r').html(str);
    //绑定加入购物车按钮事件
    addCart();
    
		$('.Shopping-zhong>h2').html(obj.data[0].goods_name);
		$('.jiage>b').html(parseInt(obj.data[0].price*0.7));
		$('.marketBox>del').html(obj.data[0].price);
	
    //加图片
    $('.zoomPad').append($('<img id="img-banner" src="'+obj.data[0].goods_thumb+'"/>'));	        
    $('.tu-big').append($('<img class="big-img" src="'+obj.data[0].goods_thumb+'"/>'))
    bigImg();
  })
});

//点击加入购物车
function addCart(){
  $('.addgouwu-btn').click(function(){
    //验证
//  var goodsId = $(this).attr('data-goods-id');    
    console.log(goodsId);
    if(localStorage.getItem('username') && localStorage.getItem('token')){
      //拿到goods_id  number  token
      var goodsNum = parseInt($('#product_num').html());
      var token = localStorage.getItem('token');
      //发起请求 
      console.log(goodsId, goodsNum, token);
      //真正后台数据更新了才能告诉用户加车成功
      alert('恭喜加车成功')
    }else{
      //用户没登录，跳登录 页面
      alert('未登录，请登录')
      console.log(goodsId)
      location.href = 'login.html?goods_id=' + goodsId;
    };
  });
};
//立刻购买
function toBuy(){
  $('#collect').click(function(){
    //验证
//  var goodsId = $(this).attr('data-goods-id');    
    if(localStorage.getItem('username') && localStorage.getItem('token')){
      //拿到goods_id  number  token
      var goodsNum = parseInt($('.num').html());
      var token = localStorage.getItem('token');
      //发起请求 
      console.log(goodsId, goodsNum, token);
      //真正后台数据更新了才能告诉用户加车成功
      alert('恭喜加车成功，点击跳转到购物车')
      console.log(goodsId)
      location.href = 'login.html?goods_id=' + goodsId;
    }else{
      //用户没登录，跳登录 页面
      alert('未登录，请登录')
      console.log(goodsId)
      location.href = 'login.html?goods_id=' + goodsId;
    };
  });
};

function bigImg(){
  //鼠标移入移出事件
  $('.zoomPad').hover(function(){
    $('.slide, .tu-big').show();
    $('.gouwu').hide();
  }, function(){
    $('.slide, .tu-big').hide();
     $('.gouwu').show();
  });
  
  //切换图片
  $('.tp-xiaomianb img').mouseenter(function(){
    //移入当前拿当前的src值
    var nowSrc = $(this).attr('src');
    //再设置另外小图和大图这个SRC值
    $('#img-banner, .big-img').attr('src', nowSrc);
  });
  
  $('.zoomPad').mousemove(function(event){
    var l = event.clientX - $('.zoomPad').offset().left - $('.slide').outerWidth() / 2;
    var t = event.clientY - $('.zoomPad').offset().top - $('.slide').outerHeight() / 2 + $(document).scrollTop();
    //验证范围
    if(l <= 0){l = 0};
    if(t <= 0){t = 0};
    var maxL = $('.zoomPad').width()-$('.slide').outerWidth();
    var maxT = $('.zoomPad').height()-$('.slide').outerHeight();
    if(l >= maxL){l = maxL};
    if(t >= maxT){t = maxT};
    //设置滑块
    $('.slide').css({left : l, top: t});
    //求比例
    var biliX = ($('.big-img').width() - $('.tu-big').width()) / ($('.zoomPad').width()-$('.slide').outerWidth());
    //设置大图移动
    $('.big-img').css({left : -l * biliX, top: -t * biliX});
  });
};

//获得地址栏参数值
function getUrlVal(property){//cat_id=77&name=xm
  var urlStr = window.location.search.substring(1);
  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
  var result = urlStr.match(re);
  if(result == null){return null};
  return result[2];
};
