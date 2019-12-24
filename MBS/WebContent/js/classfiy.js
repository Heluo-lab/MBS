// //只是首页用的JS， 其它页面不共用

// //全局变量
// var page = 1;
// var scrollLock = false;


// //请求热门商品
// function hotGoods(){
//   $.get(URL + 'api_goods.php', {'page':page, 'pagesize':5}, function(result){
//     var obj = JSON.parse(result);
//     //验证
//     if(obj.code != 0){
//       console.log(obj.message);
//       return;
//     };
//     //OK的数据
//     console.log(obj);
//     var listArr = obj.data;
//     //数据渲染
//     for(var i = 0; i < listArr.length; i++){
//       var str = `
// 		<li>
// 			<a href="product.html?goods_id=${listArr[i].goods_id}" target="_blank">
// 			<img src="img/loading.gif" lazyLoadSrc="${listArr[i].goods_thumb}" >
// 			<p>${listArr[i].goods_name}</p>
// 			<h3>￥${listArr[i].price}</h3>
// 			<div class="goods-top">
// 				<h2>${listArr[i].goods_desc}</h2>
// 			</div>
// 			</a>
// 		</li>
//       `;
//       //console.log(str)
//       //内部组装一个添加一个
//       $('.goods').append(str);
//       //马上做图片预加载
//       $('.goods [lazyLoadSrc]').YdxLazyLoad();
//       //商品添加到页面去增加了高度之后才能放开锁
//       scrollLock = false;
//     };
    
//   })
// };
// hotGoods();

// //页面卷动到底部加载更多
// $(function(){
//   //监听页面卷动事件
//   $(window).scroll(function(){
//     //页面高度
//     var pageH = $(document).height();
//     var windowH = $(window).height();
//     var scrollTopH = $(document).scrollTop();
//     //验证
//     if((scrollTopH + windowH) / pageH < 0.90){
//       return;
//     };
//     //大于0.8 请求下一页数据
//     //节流
//     if(scrollLock){return};
//     scrollLock = true;//上锁
//     page++;
//     hotGoods();
//   });
// })
//console.log();
//document.title.innerHTML = location.search;
////?cat_id=77  goods_id=1007
//console.log(typeof getUrlVal('cat_id'))

//全局变量 每个分类下的页数，size固定为3
var page = 0;

//拿传过来的cat_id
var catId = parseInt(getUrlVal('cat_id'));

//模拟页数
$.ajax({
  url :URL + 'api_goods.php', 
  data : {
    'cat_id':catId, 
    'page':1, 
    'pagesize':100000
  },
  async : false,
  dataType : 'json',
  success : function(re){
    console.log(re);
    if(re.code == 0){
      page = Math.ceil(re.data.length /15);
      console.log(page);
    };
  },
});


//打开页面请求分类商品
$(function(){
  //请求当前分类 下的商品
  $.get(URL + 'api_goods.php', {'cat_id':catId, 'page':1, 'pagesize':15}, function(re){
    var obj = JSON.parse(re);
//  console.log(obj);
    //验证数据
    if(obj.code == 1){
//    console.log(obj.message);
      //当前分类下面没有商品
      $('.goods').html('新品正在上架');
      $('.pagination').hide();
      return;
    };
    if(obj.code != 0){
//    console.log(obj.message);
      return;
    };
    //有商品，渲染到页面
    var listArr = obj.data;
    
    //数据渲染
    for(var i = 0; i < listArr.length; i++){
      var str = `
        <li>
        	<a href="product.html?goods_id=${listArr[i].goods_id}" target="_blank">
        	<img src="img/loading.gif" lazyLoadSrc="${listArr[i].goods_thumb}" >
        	<p>${listArr[i].goods_name}</p>
        	<h3>￥${listArr[i].price}</h3>
        	<div class="goods-top">
        		<h2>${listArr[i].goods_desc}</h2>
        	</div>
        	</a>
        </li>
      `;
      //内部组装一个添加一个
      $('.goods').append(str);         
    };
    //马上做图片预加载
    $('.goods [lazyLoadSrc]').YdxLazyLoad(); 
    //调用分页方法
    $('.pagination').pagination({
      //这个页数后台要有
      pageCount : page,
      prevCls : 'previous',
      nextCls : 'next',
      prevContent : '上一页',
      nextContent : '下一页',
      mode : 'fixed',
      count : 4,
      coping : true,
      homePage : '首页',
      endPage : '尾页',
      jump : true,
      //回调用来拿当前页码！
      callback : function(event){
        var pageCurrent = event.getCurrent();
        //做请求数据了吧
        $.get(URL+'api_goods.php',{
          cat_id : catId,
          page : pageCurrent,
          pagesize : 15,           
        }, function(re){
          var obj = JSON.parse(re);
          var listArr = obj.data;
          //数据渲染
          var str = ``;
          for(var i = 0; i < listArr.length; i++){
            str += `
              <li>
              	<a href="product.html?goods_id=${listArr[i].goods_id}" target="_blank">
              	<img src="img/loading.gif" lazyLoadSrc="${listArr[i].goods_thumb}" >
              	<p>${listArr[i].goods_name}</p>
              	<h3>￥${listArr[i].price}</h3>
              	<div class="goods-top">
              		<h2>${listArr[i].goods_desc}</h2>
              	</div>
              	</a>
              </li>
            `;         
          };
          $('.goods').html(str);
          //马上做图片预加载
          $('.goods [lazyLoadSrc]').YdxLazyLoad();
        });
      },
    });
    
    
  });
});
