var color = $(".dq").children("span").html();
var colorCode = null;
var size =$(".size-yyy").children(":first").html();
var goodsid = $(".goodsid-yyy").html();
var colorimg = null;
console.log(size);
jQuery(".colorbtn").click(function(){
//	商品自增ID
	
	if(lock == true){
		return;
	}
	lock = true;
//	颜色
	color = $(this).children().children("span").html();
	console.log(color);
	var obj = $(this).children("p");
//	colorCode
	colorCode = $(this).children().children("#colorcode-yyy").val();
	console.log(colorCode);
	
	$.ajax({
		type:"post",
		url:"getsize",
		data:"goodsid="+goodsid+"&colorcode="+colorCode,
		success:function(result){
			console.log(result);
			str=` `;
			$(".size-yyy").html(str);
			var sizes = result.split(",");
			for (var i = 0; i < sizes.length; i++) {
				var size1 = sizes[i]
				str=`<a class="sizetp" href="javascript:; ">${size1}</a>`;
				$(".size-yyy").append(str);
			}
			$(".size-yyy").children(":first").addClass("bxz");
			$(".dq").removeClass();
			obj.addClass("dq");
			jQuery(".sizetp").click(function(){
				$(".bxz").removeClass("bxz");
				$(this).addClass("bxz")
				size = $(this).html();
			})
			lock = false;
		}
	});
})
jQuery(".sizetp").click(function(){
				$(".bxz").removeClass("bxz");
				$(this).addClass("bxz")
				size = $(this).html();
			})
			
var lock = false;
var jsq = 0;
jQuery("#addshoppingcart").click(function(){
	if(lock == true){
		return;
	}
	lock = true;
	var fly = $(".xyd").clone().css("display","block");
	fly.appendTo(".gouwu");
	fly.animate({
		top:((document.documentElement.clientHeight/2-20-$(this).offset().top+$(document).scrollTop())),
		left:((document.documentElement.clientWidth+180-$(this).offset().left)),
		width:'30px',
		height:'30px',
		opacity:'0.7'
	},1000,function(){
		jQuery(".menu-car").animate({"width":"38px","height":"137px","top":"30%"},"fast");
		jQuery(".menu-car").animate({"width":"36px","height":"127px","top":"24%"},"fast");
		lock = false;
		$(this).remove();
		jsq=jsq+1;
		jQuery(".count").html(jsq);
	});	
	console.log(size);
		$.ajax({
		type:"post",
		url:"addcartdata",
		data:"goodsid="+goodsid+"&color="+color+"&size="+size+"&goodsnum=1",
		success:function(result){}});
})
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
    var biliY = ($('.big-img').height() - $('.tu-big').height()) / ($('.zoomPad').height()-$('.slide').outerHeight())
    //设置大图移动
    $('.big-img').css({left : -l * biliX, top: -t * biliY});
  });