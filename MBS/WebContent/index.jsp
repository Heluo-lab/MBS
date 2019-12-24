<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
<script type="text/javascript">

	function User(username, userpassword,age,score) {
		this.username=username;
		this.userpassword=userpassword;
		this.age=age;
		this.score=score;
	}

	function register() {
		var sname = document.getElementById("username").value;
		//验证用户名是否为6-20位
		var regname = /^\w{6,20}$/gi;
		if (!regname.test(sname)) {
			document.getElementById("usernamediv").innerHTML = "<font color='red'>用户名要在6-20位之间且只能是数字与字母组合</font>";
			return;
		} else {
			document.getElementById("usernamediv").innerHTML = "<font color='green'>用户名合法</font>";
		}
		var score = document.getElementById("score").value;
		var regscore = /^\d+$/gi;
		if (!regscore.test(score)) {
			return;
		}
		//表示填写的格式合法
		//var form = document.getElementById("myform");
		//form.method = "get";
		//form.action = "registerAction.jsp";
		//form.submit();
		var user = new User(encodeURL($("#username").val()),encodeURL($("#userpassword").val()),encodeURL($('input[name="sex"]:checked').val()),encodeURL($("#score").val()));
		$.ajax({
			type:"post",
			url:"checkJson.jsp",
			data:"data="+JSON.stringify(user),
			success:function(result){
				if(result.msg=="ok"){
					$.ajax({
						type:"post",
						url:"select.jsp",
						data:"data="+JSON.stringify(stu),
						success:
					});
				}
			}
		});
	}
</script>
</head>
<body>
	<form id="myform">
		用户名：<input type="text" name="username" id="username" />
		<div id="usernamediv" style="display: inline"></div>
		<br /> 密 码 ：<input type="password" name="userpassword"
			id="userpassword">
		<div id="usernamediv" style="display: inline"></div>
		<br /> 性 别：男：<input type="radio" name="sex" value="男"
			checked="checked" />女：<input type="radio" name="sex" value="女" /><br />
		成 绩：<input type="text" name="score" id="score" /><br /> <input
			type="button" value="注册" onclick="register()" />
	</form>
</body>
</
</html>