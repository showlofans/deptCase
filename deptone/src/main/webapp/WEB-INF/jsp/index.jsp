<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!-- <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0">  -->
<link rel="Bookmark" href="/view/iconW.jpg" >
<link rel="Shortcut Icon" href="/view/iconW.jpg" />
<link href="/view/iconW.jpg" type="image/x-icon" rel="icon">
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/view/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>催债系统</title>
<meta name="keywords" content="催债系统 ">
<meta name="description" content="催债系统">
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a title="系统最新更新时间：${applicationScope.startupTime }" class="logo navbar-logo f-l mr-10 hidden-xs" href="/home">债务系统Beta${portNum }</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="#">微族通道系统Beta</a> 
			<span class="logo navbar-slogan f-l mr-10 hidden-xs">
			</span> 
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
			<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
				<ul class="cl">
					<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
							<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
							<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
							<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
							<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
							<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
							
					</ul>
				</li>
			</ul>
		</nav>
	</div>
</div>

</header>
<aside class="Hui-aside">
	<div>
	<dl id="menu-member">
		<!-- <dt><i class="Hui-iconfont" style="font-size:20px;">&#xe633;</i> 案件管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt> -->
		<dd style="padding-left:15px;">
			<ul>
				<!-- <li><a data-href="http://htmlify.wps.cn/doc/index.html?ksyun=hPT1Afio/word.html&theme=clear" data-title="平台操作指南" href="javascript:void(0)">平台操作指南</a></li> -->
				<li ><a  data-title="案件管理" data-href="/casemgt/deptCase/list_case.do" onclick="Hui_admin_tab(this)" title="案件管理"">案件管理</a></li>
				<li ><a  data-title="联系人管理" data-href="/casemgt/deptCase/list_case.do" onclick="Hui_admin_tab(this)" title="联系人管理"">联系人管理</a></li>
				<li ><a  data-title="用户管理" data-href="/casemgt/userLogin/list_user.do" onclick="Hui_admin_tab(this)" title="用户管理"">用户管理</a></li>
				<li ><a  data-title="退出登录" data-href="/casemgt/userLogin/user_logout.do" onclick="Hui_admin_tab(this)" title="退出登录"">退出登录</a></li>
			</ul>
		</dd>
	</dl>
</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
					<span title="我的桌面" data-href="/casemgt/deptCase/list_case.do">案件管理</span>
					<em></em></li>
		</ul>
	</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="/casemgt/deptCase/list_case.do"></iframe>
	</div>
</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
		<li id="closeother">关闭其他 </li>
</ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/view/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
//收藏本站 www.jb51.net
function AddFavorite(title, url) {
 try {
   window.external.addFavorite(url, title);
 }
catch (e) {
   try {
    window.sidebar.addPanel(title, url, "");
  }
   catch (e) {
     alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请进入新网站后使用Ctrl+D进行添加");
   }
 }
}

$(function(){
	$("#min_title_list li").contextMenu('Huiadminmenu', {
		bindings: {
			'closethis': function(t) {
				console.log(t);
				if(t.find("i")){
					t.find("i").trigger("click");
				}		
			},
			'closeall': function(t) {
				alert('Trigger was '+t.id+'\nAction was Email');
			},
		}
	});
});
</script> 
</body>
</html>