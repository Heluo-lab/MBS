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
		left:((document.documentElement.clientWidth-$(this).offset().left)),
		width:'30px',
		height:'30px',
		opacity:'0.7'
	},1200,function(){
		jQuery(".gwc").animate({"width":"66px","height":"66px","top":"23%"},"fast");
		jQuery(".gwc").animate({"width":"60px","height":"60px","top":"24%"},"fast");
		lock = false;
		$(this).remove();
		jsq=jsq+1;
		jQuery(".count").html(jsq);
		
	})
})
