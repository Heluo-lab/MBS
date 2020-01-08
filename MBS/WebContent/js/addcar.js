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
		top:((document.documentElement.clientHeight/2-$(this).offset().top+$(document).scrollTop())),
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
	})
})
var color = null;
var colorCode = null;
jQuery(".colorbtn").click(function(){
//	商品自增ID
	var goodsid = $(".goodsid-yyy").html();
	if(lock == true){
		return;
	}
	lock = true;
//	颜色
	color = $(this).children("span").html();
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
			var size = result.split(",");
			for (var i = 0; i < size.length; i++) {
				var size1 = size[i]
				str=`<a class="sizetp" href="javascript:;">${size1}</a>`;
				$(".size-yyy").append(str);
			}
			$(".dq").removeClass();
			obj.addClass("dq");
			lock = false;
		}
	});
})
var size =null;
jQuery(".sizetp").click(function(){
	lock = true;
	size = $(this).html();
	console.log(size);
})