$(function(){
	var tyid = $("#tyid").val();
	var tyli = $(".list_left .left .list_l_c .list_l_dt dl dt>a");
	tyli.each(function(){
			var mid=$(this).attr("id");
			//alert(mid);
			var navli = $(this);
			var l=navli.parent("dt").siblings("dd")[0];
			//alert(l);
		$.ajax({
			type:"get",
			url:"http://127.0.0.1:8080/MBS/sontype",
			async:true,
			data:{id:mid},
			success:function(result){
				var arrayType =JSON.parse(result);
				$.each(arrayType,function(i,type){	
					if(type.id==tyid){
						var str =`<a rel="nofollow" class="" style="color:#e50056;" href="product_list?tyid=${type.id}">${type.parentName}--${type.typeName}</a>`;
					}else{
						var str =`<a rel="nofollow" class="" href="product_list?tyid=${type.id}">${type.parentName}--${type.typeName}</a>`;
					}
						navli.parent("dt").siblings("dd").append(str);
					});
			},
			error:function(){
				console.log("请求失败");
			}
		});
	 })
});