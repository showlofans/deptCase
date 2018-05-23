<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/MyTaglib.tld" prefix="mytag"%>
<!DOCTYPE >
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/view/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/H-ui.admin.css" />
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="/view/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/view/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="/view/mine/paging.css" />

<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>用户列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户管理 <span class="c-gray en">&gt;</span> 批量分配案件  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray"> <span class="l"> <a class="btn btn-primary radius" href="javascript:;" onclick="loginUser_add('添加用户','/casemgt/userLogin/user_add_page.do','800')"><i class="Hui-iconfont">&#xe600;</i> 批量分配</a> </span> <span class="r">共有数据：<strong>${resultMap.pagination.totalRecord }</strong> 条</span> </div>
	<table class="table table-border table-bordered table-hover table-bg">
		<thead>
			<tr >
				<th scope="col" colspan="9">未分配的案件列表<span class="r">用户：${resultMap.userPo.name }-${resultMap.userPo.userRemark }</span></th>
			</tr>
			<tr class="text-c">
				<!-- <th width="80">流量包Id</th> -->
				<th width="25"><input type="checkbox" value="" name=""></th>
				<th width="80">客户名称</th>
				<th width="80">贷款日期</th>
				<th width="80">到期日期</th>
				<th width="80">贷款金额</th>
				<!-- <th width="75">贷款余额</th>
				<th width="60">结欠利息</th> -->
				<th width="100">机构名称</th>
				<!-- <th width="80">联系电话</th>
				<th width="120">证件号码</th>
				<th width="100">地址</th> -->
				<th width="80">保证人名称</th>
				<th width="80">导入时间</th>
				<th width="80">操作</th>
				<!-- <th width="80">更新时间</th>
				<th width="80">更新日志</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${resultMap.pagination.records }" var="deptcase" varStatus="vs">
				<tr class="text-c ">
					<td width="25"><input type="checkbox" value="" name=""></td>
					<td class="f-14 td-manage">
						<span data-toggle="tooltip" data-placement="top" style="text-decoration: none;" title="${deptcase.caseCustomer }">${deptcase.caseCustomer }
						</span>
					</td>
					<td class="f-14">
						${deptcase.deptDate }
					</td>
					<td class="f-14">
						${deptcase.deptEndDate }
					</td>
					<td class="f-14">
						${deptcase.deptAmount }
					</td>
					<%-- <td class="f-14">
						${deptcase.deptBalance }
					</td>
					<td class="f-14">
						${deptcase.deptProfit }
					</td> --%>
					<td class="f-14">
						${deptcase.caseOrg }
					</td>
					<%-- <td class="f-14">
						${deptcase.dcId }
					</td>
					<td class="f-14">
						${deptcase.customerContact }
					</td>
					<td class="f-14">
						${deptcase.customerLocation }
					</td> --%>
					<td class="f-14">
						${deptcase.caseWarrantor }
					</td>
					<td class="f-14">
						${deptcase.createTime }
					</td>
					<td class="f-14 td-manage success"> 
						分配&nbsp;&nbsp;	删除&nbsp;&nbsp;	
						<a data-title="联系记录" data-href="/casemgt/contactRecord/list_record.do?caseId=${deptcase.id }" onclick="Hui_admin_tab(this)" title="联系记录"">记录</a>
					</td>
						<%--<a style="text-decoration:none" onClick="deptcase_del('/flowsys/deptcase/deptcase_del.do','${deptcase.id}','${deptcase.epName }')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> 
						<a style="text-decoration:none" class="ml-5" onClick="deptcase_edit('平台信息编辑','/flowsys/deptcase/deptcase_edit_page.do?epId=${deptcase.id}','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <!-- <a style="text-decoration:none" class="ml-5" onClick="deptcase_del(this,'10001')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a> --></td> --%>
					<%-- <td><div class="f-12 c-999">
					<span data-toggle="popover"  data-placement="top" style="text-decoration: none;" title="${deptcase.epIp }"><a title="${deptcase.epIp }" href="${deptcase.epIp }" target="_blank">${deptcase.epPurchaseIp }</a></span>
					</div></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="deptcaselistId" />
	<div class="cl pd-5 bg-1 bk-gray"> <span class="l"> <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量收回</a> </span> <span class="r">共有数据：<strong>${fn:length(resultMap.contactCaseList)}</strong> 条</span> </div>
	<table class="table table-border table-bordered table-hover table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">案件列表<span class="r">用户：${resultMap.userPo.name }-${resultMap.userPo.userRemark }</span></th>
			</tr>
			<tr class="text-c">
				<!-- <th width="80">流量包Id</th> -->
				<th width="25"><input type="checkbox" value="" name=""></th>
				<th width="80">客户名称</th>
				<th width="80">贷款日期</th>
				<th width="80">到期日期</th>
				<th width="80">贷款金额</th>
				<!-- <th width="75">贷款余额</th>
				<th width="60">结欠利息</th> -->
				<th width="100">机构名称</th>
				<!-- <th width="80">联系电话</th>
				<th width="120">证件号码</th>
				<th width="100">地址</th> -->
				<th width="80">保证人名称</th>
				<th width="80">导入时间</th>
				<th width="80">操作</th>
				<!-- <th width="80">更新时间</th>
				<th width="80">更新日志</th> -->
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty resultMap.contactCaseList }">
					<tr class="text-c ">
						<th scope="col" colspan="8">没有分配案件!!</th>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${resultMap.contactCaseList }" var="deptcase" varStatus="vs">
						<tr class="text-c ">
							<td width="25"><input type="checkbox" value="" name=""></td>
							<td class="f-14 td-manage">
								<span data-toggle="tooltip" data-placement="top" style="text-decoration: none;" title="${deptcase.caseCustomer }">${deptcase.caseCustomer }
								</span>
							</td>
							<td class="f-14">
								${deptcase.deptDate }
							</td>
							<td class="f-14">
								${deptcase.deptEndDate }
							</td>
							<td class="f-14">
								${deptcase.deptAmount }
							</td>
							<%-- <td class="f-14">
								${deptcase.deptBalance }
							</td>
							<td class="f-14">
								${deptcase.deptProfit }
							</td> --%>
							<td class="f-14">
								${deptcase.caseOrg }
							</td>
							<%-- <td class="f-14">
								${deptcase.dcId }
							</td>
							<td class="f-14">
								${deptcase.customerContact }
							</td>
							<td class="f-14">
								${deptcase.customerLocation }
							</td> --%>
							<td class="f-14">
								${deptcase.caseWarrantor }
							</td>
							<td class="f-14">
								${deptcase.createTime }
							</td>
							<td class="f-14 td-manage success"> 
								分配&nbsp;&nbsp;	删除&nbsp;&nbsp;	
								<a data-title="联系记录" data-href="/casemgt/contactRecord/list_record.do?caseId=${deptcase.id }" onclick="Hui_admin_tab(this)" title="联系记录"">记录</a>
							</td>
								<%--<a style="text-decoration:none" onClick="deptcase_del('/flowsys/deptcase/deptcase_del.do','${deptcase.id}','${deptcase.epName }')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> 
								<a style="text-decoration:none" class="ml-5" onClick="deptcase_edit('平台信息编辑','/flowsys/deptcase/deptcase_edit_page.do?epId=${deptcase.id}','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <!-- <a style="text-decoration:none" class="ml-5" onClick="deptcase_del(this,'10001')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a> --></td> --%>
							<%-- <td><div class="f-12 c-999">
							<span data-toggle="popover"  data-placement="top" style="text-decoration: none;" title="${deptcase.epIp }"><a title="${deptcase.epIp }" href="${deptcase.epIp }" target="_blank">${deptcase.epPurchaseIp }</a></span>
							</div></td> --%>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<footer class="footer mt-20">
		<div class="container">
			<p><!-- 感谢jQuery、layer、laypage、Validform、UEditor、My97DatePicker、iconfont、Datatables、WebUploaded、icheck、highcharts、bootstrap-Switch<br> -->
				Copyright &copy;2017-2018科技有限公司 All Rights Reserved.<br>
				<!-- 本后台系统由<a href="http://www.h-ui.net/" target="_blank" title="H-ui前端框架">H-ui前端框架</a>提供前端技术支持 -->
				</p>
		</div>
	</footer>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<!-- jQuery -->
<script type="text/javascript" src="/view/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
/*管理员-角色-添加*/
function loginUser_add(title,url,w,h){
	var index = layer.open({
        type: 2,
        title: title,
        area: [w, '560px'],
        //closeBtn: 1,
        content: url,
         end: function () {
            location.reload();
        }
    });
	//layer_show(title,url,w,h);
}
/*管理员-角色-编辑*/
function loginUser_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
</script> 
</body>
</html>