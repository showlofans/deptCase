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
<title>平台列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 案件管理  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<div class="page-container">
	<c:if test="${loginContext.userLimit == 0 }">
	<div class="text-c">
		<form class="form form-horizontal" name="form-import" action="?"  id="form-import" enctype="multipart/form-data">
		<div class="formControls col-xs-8 col-sm-9">
			<span class="btn-upload">
			  <a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 选择文件</a>
			  <input value="" class="input-text upload-url" style="width:300px" type="text" readonly >
			  <input type="file" multiple name="uploadFile" class="input-file">
			</span>
			<button type="button" id="saveButton" class="btn btn-primary radius" onclick="importCase()"> 导入案件</button>
		</div>
		</form>
		<form class="form form-horizontal" name="form-import-contact" action="?"  id="form-import-contact" enctype="multipart/form-data">
		<div class="formControls col-xs-8 col-sm-9">
			<span class="btn-upload">
			  <a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 选择文件</a>
			  <input value="" class="input-text upload-url" style="width:300px" type="text" readonly >
			  <input type="file" multiple name="contactFile" class="input-file">
			</span>
			<button type="button" id="saveButton" class="btn btn-primary radius" onclick="importContact()"> 导入联系人</button>
		</div>
		</form>
	<form action="/flowsys/deptCase/list_deptcase.do" method="post" id="formD" name="dataListForm">
		<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
		<%-- 平台名称：<input type="text" value="${resultMap.searchParam.epName }" name="epName" id="epName" placeholder=" 平台名称" style="width:150px" class="input-text">
		英文标志：<input type="text" value="${resultMap.searchParam.epEngId }" name="epEngId" id="epEngId" placeholder=" 平台英文标志" style="width:150px" class="input-text">
		<span class="select-box inline">
			<select id="epFor" name="epFor" class="select" onchange="formSub()">
				<option value="">平台类型</option>
				<c:forEach items="${resultMap.pgServiceTypeEnums }" var="pgServiceTypeEnum" varStatus="vs1">
					<option value="${pgServiceTypeEnum.value }" <c:if test="${pgServiceTypeEnum.value == resultMap.searchParam.epFor }"> selected</c:if>>${pgServiceTypeEnum.desc }</option>
				</c:forEach>
			</select>
		</span>
		<button type="button"class="btn btn-success" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
		<a style="text-decoration:none" class="btn btn-success" onClick="deptcase_add('平台信息添加','/flowsys/deptcase/deptcase_add_page.do')" href="javascript:;" title="添加"><i class="Hui-iconfont">&#xe600;</i> 添加</a>
		<input value="搜平台" class="btn btn-success" type="submit" onclick="formSub()"><!-- <i class="Hui-iconfont">&#xe665;</i> -->
		<span><a href="javascript:;" onclick="updateBalance()" class="btn btn-primary radius">刷新余额</a></span> --%>
		<input type="hidden" name="pageNo" value="${resultMap.pagination.pageNo }"> 
		</form>
	</div>
	</c:if>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<!-- <th width="80">流量包Id</th> -->
					<th width="80">客户名称</th>
					<th width="80">贷款日期</th>
					<th width="80">到期日期</th>
					<th width="80">贷款金额</th>
					<th width="75">贷款余额</th>
					<th width="60">结欠利息</th>
					<th width="120">证件号码</th>
					<th width="100">机构名称</th>
					<th width="80">联系电话</th>
					<th width="100">地址</th>
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
						<td class="f-14">
							${deptcase.deptBalance }
						</td>
						<td class="f-14">
							${deptcase.deptProfit }
						</td>
						<td class="f-14">
							${deptcase.dcId }
						</td>
						<td class="f-14">
							${deptcase.caseOrg }
						</td>
						<td class="f-14">
							${deptcase.customerContact }
						</td>
						<td class="f-14">
							${deptcase.customerLocation }
						</td>
						<td class="f-14">
							${deptcase.caseWarrantor }
						</td>
						<td class="f-14">
							${deptcase.createTime }
						</td>
						<td class="f-14 td-manage success"> 
							分配&nbsp;&nbsp;	删除&nbsp;&nbsp;	
							<a data-title="联系记录" data-href="/casemgt/contactRecord/list_record.do" onclick="Hui_admin_tab(this)" title="联系记录"">记录</a>
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
	</div>
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
/*平台-添加*/
function deptcase_add(title,url){
	//alert("sd");
	var index = layer.open({
        type: 2,
        title: title,
        //area: ['650px', '560px'],
        //closeBtn: 1,
        content: url+'?pageTitle=' + title,
         end: function () {
            location.reload();
        }
    });
	layer.full(index);
}
/* function formSub(){
	$('form').submit();
}
 */
/*平台-编辑*/
function deptcase_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url,
		//area: ['650px', '560px'],
		end: function () {
            location.reload();
		}
	});
	layer.full(index);
}
/*平台-下架*/
function deptcase_del(url,epId,epName){
	layer.confirm('确认要清除'+epName+'平台吗？',function(index){
		$.ajax({
			type: 'POST',
			url: url,
			data: {epId:epId},
			success: function(data){
				if(data=="success")
				{
					layer.msg('下架平台成功!',{icon:1,time:1000});
					location.reload();
				}else{
					layer.msg('下架平台失败!',{icon:1,time:1000});
				}
			},
			error:function(data) {
				console.log(data.msg);
			}
		});		
	});
}
/**导入案件*/
function importCase(){
	//alert($('#telList').val());
	 //$('#telList').val('100');
	// $('#saveButton').set('disabled', 'false');
	 //alert("1");
	$.ajax({
         url : "/casemgt/deptCase/import_case.do",
         type : "POST",
         cache: true, 
         data : new FormData($('#form-import')[0]),
         processData: false,
         contentType : false,
         success : function(data) {
        	 //alert(data);
        	//$('#telList').val(data);
        	if("success" == data){
            //alert(data);  
        		location.reload();
           	}else{
           		alert(data);
           	}
         },

         error : function(data) {
             alert("出错：" + data.code);
         } 
     });
	// $('#form-import').submit();
 }
 /**导入联系人*/
 function importContact(){
	 $.ajax({
         url : "/casemgt/caseContact/import_case_contact.do",
         type : "POST",
         cache: true, 
         data : new FormData($('#form-import-contact')[0]),
         processData: false,
         contentType : false,
         success : function(data) {
        	 //alert(data);
        	//$('#telList').val(data);
        	if("success" == data){
            //alert(data);  
        		location.reload();
           	}else{
           		alert(data);
           	}
         },

         error : function(data) {
             alert("出错：" + data.code);
         } 
     });
 }
</script> 
</body>
</html>