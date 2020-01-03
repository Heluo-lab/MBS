//只是首页用的JS， 其它页面不共用

//全局变量
var page = 1;
var scrollLock = false;

//请求广告位数据
// $(function(){
//   $.get(URL + 'api_ad.php', {'position_id':1}, function(result){
//     var obj = JSON.parse(result);
//     //验证
//     if(obj.code != 0){
//       console.log(obj.message);
//       return;
//     };
//     //OK的数据
//     var listArr = obj.data;
//     console.log(obj);
//     //让所图片缓存到本地   304 同名文件第二次请会先查看本地
//     for(var i = 0; i < listArr.length; i++){
//       var li = `
//         <li>
//           <a href="">
//             <img src="img/loading.gif" lazyLoadSrc="${listArr[i].url}" />
//           </a>
//         </li>
//       `;
//       $('.banner-list').append(li);
//     };
//     //统一选中调用预加载方法
//     $('[lazyLoadSrc]').YdxLazyLoad();
//   });
// });


//请求热门商品
//function hotGoods(){
//  $.get(URL + 'api_goods.php', {'page':page, 'pagesize':5}, function(result){
//    var obj = JSON.parse(result);
//    //验证
//    if(obj.code != 0){
////    console.log(obj.message);
//      return;
//    };
//    //OK的数据
////  console.log(obj);
//    var listArr = obj.data;
//    //数据渲染
//    for(var i = 0; i < listArr.length; i++){
//      var str = `
//		<li>
//			<a href="product.html?goods_id=${listArr[i].goods_id}" target="_blank">
//			<img src="img/loading.gif" lazyLoadSrc="${listArr[i].goods_thumb}" >
//			<p>${listArr[i].goods_name}</p>
//			<h3>￥${listArr[i].price}</h3>
//			<div class="goods-top">
//				<h2>${listArr[i].goods_desc}</h2>
//			</div>
//			</a>
//		</li>
//      `;
//      //console.log(str)
//      //内部组装一个添加一个
//      $('.goods').append(str);
//      //马上做图片预加载
//      $('.goods [lazyLoadSrc]').YdxLazyLoad();
//      //商品添加到页面去增加了高度之后才能放开锁
//      scrollLock = false;
//    };
//    
//  })
//};
//hotGoods();

//页面卷动到底部加载更多
//$(function(){
//  //监听页面卷动事件
//  $(window).scroll(function(){
//    //页面高度
//    var pageH = $(document).height();
//    var windowH = $(window).height();
//    var scrollTopH = $(document).scrollTop();
//    //验证
//    if((scrollTopH + windowH) / pageH < 0.94){
//      return;
//    };
//    //大于0.8 请求下一页数据
//    //节流
//    if(scrollLock){return};
//    scrollLock = true;//上锁
//    page++;
//    hotGoods();
//  });
//})

//页面加载完之后，立即将子级分类通过ajax后台生成
$(function(){
	var tyli = $(".nav-right .nav-right-li>a");
	tyli.each(function(){
			var mid=$(this).attr("id");
			var navli = $(this);
		$.ajax({
			type:"get",
			url:"http://127.0.0.1:8080/MBS/sontype",
			async:true,
			data:{id:mid},
			success:function(result){
				var arrayType =JSON.parse(result);
				$.each(arrayType,function(i,type){
						var str =`<li><a href="product_list?tyid=${type.id}">${type.typeName}</a></li>`;
						navli.siblings(".sublist").children("ul").append(str);
					});
			},
			error:function(){
				console.log("请求失败");
			}
		});
	})
});
