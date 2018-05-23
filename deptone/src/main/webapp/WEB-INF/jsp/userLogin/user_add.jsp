<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/view/iconW.jpg" >
<link rel="Shortcut Icon" href="/view/iconW.jpg" />
<link href="/view/iconW.jpg" type="image/x-icon" rel="icon">
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
<!-- <link href="/view/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />  -->
<link href="/view/static/h-ui.admin/css/login.css" rel="stylesheet" type="text/css" />
<link href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />

<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<style type="text/css">
	 /* body{ text-align:center}  */
/* .sorry{ margin:0 auto; width:600px; height:300px; vertical-align: middle; border:1px solid #F00}  */

/* .sorry{
width:600px;
height:220px;
background:url(../images/bj_zhuce.jpg) no-repeat top center;
color:#fff;
font-size:40px;
font-family:"Comic Sans MS", cursive;
text-align:center;
line-height:220px;
} */
</style>
<title>用户添加-债务管理系统</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
	<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-loginUser-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required="required" value="" placeholder="" id="name" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">用户密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value=""  required="required"placeholder="" id="pass" name="pass">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">用户备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" required="required" placeholder="" id="userRemark" name="userRemark">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<button type="submit" class="btn btn-success radius" id="admin-role-save" name="admin-role-save"><i class="icon-ok"></i> 确定</button>
			</div>
		</div>
	</form>
</article>
<div class="footer">Copyright &copy;2017-2018 科技有限公司 All Rights Reserved.<br></div>

<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="/view/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#form-loginUser-add").validate({
			rules:{
				name:{
					required:true,
				},
				pass:{
					required:true,
				},
				userRemark:{
					required:true,
				}
			},
			submitHandler:function(form){
				$.ajax({
			        type:"post",
			        url:"/casemgt/userLogin/user_add.do",
			        data: $(form).serialize(),//表单数据
			        async : false,
			        success:function(d){
			         	if(d == "success"){
			         		var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	                        parent.layer.close(index);// 执行关闭 
			           } 
			         	if(d=="login-error"){
	                       layer.msg('保存异常!');
	                   }
	                   if(d=="error"){
	                       alert('保存异常,已经添加过该平台了!');
	                   }
			        }
			    });
			}
		});
	})
//
function ifIndex(){
	var $id = $('#id').val();
	//alert($id);
	if($id != ''){
		window.location.href='/home';
	}
}
</script>
</body>
</html>