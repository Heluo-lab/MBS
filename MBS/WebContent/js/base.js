//做公共页面的数据!!!
//公共的前缀
var URL = 'http://www.wjian.top/shop/';

//获得地址栏参数值
function getUrlVal(property){//cat_id=77&name=xm
  var urlStr = window.location.search.substring(1);
  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
  var result = urlStr.match(re);
  if(result == null){return null};
  return result[2];
};

//请求商品分类
$(function(){
  //刷新就开始请求
  $.get('http://www.wjian.top/shop/api_cat.php', function(result){
    var obj = JSON.parse(result)
//  console.log(obj);
    //验证
    if(obj.code != 0){
//    console.log(obj.message);
      return;
    };
    //OK的分类
    var listArr = obj.data;
    var str = '';
	var cat_id = getUrlVal('cat_id');
    for(var i = 0; i < listArr.length; i++){
		if(cat_id==listArr[i].cat_id){
			str += '<li class="active-li"><a class="active-a" target="_blank" href="classfiy.html?cat_id=' +listArr[i].cat_id+ '">' + listArr[i].cat_name + '</a></li>';
		}else{
			str += '<li><a href="classfiy.html?cat_id=' +listArr[i].cat_id+ '">' + listArr[i].cat_name + '</a></li>';
		}
		
    };
    //添加到页面
    // $('.goods-list').append(str);
	$('.goods-list').html(str);
  });
});






