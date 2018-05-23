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
<link href="/lujinsuojizhang/css/jquery.bxslider.css" rel="stylesheet" type="text/css">
<link href="/lujinsuojizhang/css/font-awesome.css" rel="stylesheet" />
<link href="/lujinsuojizhang/css/index.css" rel="stylesheet" />

<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>催债记录</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 通话记录  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a><a class="btn btn-danger radius r" style="line-height:1.6em;margin-top:3px" href="javascript:removeIframe();" title="关闭" ><i class="Hui-iconfont">&#xe6a6;</i></a></nav>
<!-- <div class="page-container"> -->
	<div class="mt-20">
		<table  cellspacing="0" cellpadding="4" class="banking_processing_con">
			<tr>
				<td colspan="3" class="table_tdheight"><span>案件信息 </span>
				 </td>
			</tr>
			<tr>
				<td width="2"></td>
				<td align="center" valign="top">
					<table class="table table-border table-bordered table-bg table-hover table-sort">
						<tr>
							<td width="100">
							客户名称：<input type="text" value="${resultMap.deptCase.caseCustomer }" >
							</td>
							<td width="100">
							证件号码：<input type="text" value="${resultMap.deptCase.dcId }" >
							</td>
							<td width="100">
							联系电话：<input type="text" value="${resultMap.deptCase.customerContact }" >
							</td>
							<td width="100">
							联系地址：<input type="text" value="${resultMap.deptCase.customerLocation }" >
							</td>
							<!-- <td style="text-align:left">
							</td> -->
						</tr>
						<tr>
							<td width="100">
							贷款金额：<input type="text" value="${resultMap.deptCase.deptAmount }" >
							</td>
							<td width="100">
							贷款余额：<input type="text" value="${resultMap.deptCase.deptBalance }" >
							</td>
							<td width="100">
							结欠利息：<input type="text" value="${resultMap.deptCase.deptProfit }" >
							</td>
							<td width="100">
							贷款日期：<input type="text" value="${resultMap.deptCase.deptDate }" >
							</td>
							<!-- <td style="text-align:left">
							</td> -->
						</tr>
						<tr>
							<td width="100">
							机构名称：<input type="text" value="${resultMap.deptCase.caseOrg }" >
							</td>
							<td width="100">
							案件担保人：<input type="text" value="${resultMap.deptCase.caseWarrantor }" >
							</td>
							<td width="100">
							保证方式：<input type="text" value="${resultMap.deptCase.warrantorWay }" >
							</td>
							<td width="100">
							贷款用途：<input type="text" value="${resultMap.deptCase.deptFor }" >
							</td>
							<!-- <td style="text-align:left">
							</td> -->
						</tr>
						<tr>
							<td width="100">
							借据号：<input type="text" value="${resultMap.deptCase.loanNumber }" >
							</td>
							<td width="100">
							到期日期：<input type="text" value="${resultMap.deptCase.deptEndDate }" >
							</td>
							<td width="100">
							案件状态：<input type="text" value="${resultMap.deptCase.caseState }" >
							</td>
							<td width="100">
							导入时间：<input type="text" value="${resultMap.deptCase.createTime }" >
							</td>
							<!-- <td style="text-align:left">
							</td> -->
						</tr>
						
					</table>
				</td>
				<td width="2"></td>
			</tr>
			
			<tr>
				<td colspan="3" class="table_tdheight"><span>联系人信息</span> &nbsp;&nbsp;<a class="btn btn-primary radius">添加联系人 </a></span></td>
			</tr>
			<tr>
				<td width="2"></td>
				<td align="center" valign="top">
				<form name="contactForm" method="post">
					<table  border="0" class="table table-border table-bordered table-bg table-hover table-sort">
						<tr align="center">
							<th width="80">联系人名字</th>
							<th width="80">联系人身份证号</th>
							<th width="80">手机号码</th>
							<th width="80">户籍关系</th>
							<th width="80">户籍地址</th>
							<th width="80">其他关系</th>
							<th width="80">现居地址</th>
							<th width="80">备注信息</th>
							<th width="80">操作</th>
						</tr>
						<c:forEach items="${resultMap.contactList }" var="contact" varStatus="vs">
							<tr class="tr_addcolor">
								<td class="td_3 text-c"><font color="#A63E19">${contact.contactName }</font></td>
								<td class="td_3 text-c"><font color="#A63E19">${contact.contactDcid }</font></td>
								<td class="td_3 text-c"><font color="#A63E19">${contact.contactNumber }</font></td>
								<td class="td_3 text-c"><font color="#A63E19">${contact.householdShip }</font></td>
								<td class="td_3 text-c"><font color="#A63E19">${contact.householdLocation }</font></td>
								<td class="td_3 text-c"><font color="#A63E19">${contact.otherContactShip }</font></td>
								<td class="td_3 text-c"><font color="#A63E19">${contact.contactLocation }</font></td>
								<td class="td_3 text-c"><font color="#A63E19">${contact.contactRemark }</font></td>
								<td class="td_3 text-c"><font color="#A63E19">
									修改
								</font></td>
							</tr>
						</c:forEach>
					</table>
					</form>
				</td>
				<td width="2"></td>
			</tr>
			<!-- <tr height="15">
				<td colspan="3">&nbsp;</td>
			</tr> -->
			<tr height="15">
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td width="2"></td>
				<td align="center" valign="top">
				<div class="text-c">
					<form action="/casemgt/contactRecord/list_record.do" method="post" id="formD" name="dataListForm">
						<div><!--  class="formControls col-xs-8 col-sm-9" -->
							<span class="select-box inline">
								<select id="recordUser" name="recordUser" class="select" onchange="subForm()">
									<option value="1">13699562589</option>
									<option value="2">13177628766</option>
								</select>
							</span>
						
						<input value="搜记录" class="btn btn-success" type="submit" onclick="subForm()">
						<span><a href="javascript:;" onclick="" class="btn btn-primary radius">添加联系方式</a></span>
						<input type="text" value="${resultMap.contactRecordPo.caseContact }" name="caseContact" id="caseContact" placeholder=" 联系方式" style="width:150px" class="input-text">
						<span><a href="javascript:;" onclick="" class="btn btn-primary radius">添加联系记录</a></span>
						
						</div>
						<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
						<%-- 平台名称：<input type="text" value="${resultMap.contactRecordPo.epName }" name="epName" id="epName" placeholder=" 平台名称" style="width:150px" class="input-text">
						英文标志：<input type="text" value="${resultMap.contactRecordPo.epEngId }" name="epEngId" id="epEngId" placeholder=" 平台英文标志" style="width:150px" class="input-text">
						<span class="select-box inline">
							<select id="epFor" name="epFor" class="select" onchange="formSub()">
								<option value="">平台类型</option>
								<c:forEach items="${resultMap.pgServiceTypeEnums }" var="pgServiceTypeEnum" varStatus="vs1">
									<option value="${pgServiceTypeEnum.value }" <c:if test="${pgServiceTypeEnum.value == resultMap.contactRecordPo.epFor }"> selected</c:if>>${pgServiceTypeEnum.desc }</option>
								</c:forEach>
							</select>
						</span>
						<button type="button"class="btn btn-success" onclick="javascript:location.replace(location.href);" value="重置">重置</button>
						<a style="text-decoration:none" class="btn btn-success" onClick="deptcase_add('平台信息添加','/flowsys/record/deptcase_add_page.do')" href="javascript:;" title="添加"><i class="Hui-iconfont">&#xe600;</i> 添加</a>
						<input value="搜平台" class="btn btn-success" type="submit" onclick="formSub()"><!-- <i class="Hui-iconfont">&#xe665;</i> -->
						<span><a href="javascript:;" onclick="updateBalance()" class="btn btn-primary radius">刷新余额</a></span> --%>
						<input type="hidden" name="pageNoLong" value="${resultMap.pagination.pageNoLong }"> 
					</form>
				</div>
				</td>
			</tr>
			<tr height="15">
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3" class="table_tdheight"><span>催债记录 </span>
				 &nbsp;&nbsp;<a class="btn btn-primary radius">添加催债记录  </a></td>
			</tr>
			<!-- <tr height="15">
				<td colspan="3">&nbsp;</td>
			</tr> -->
			<tr>
				<td width="2"></td>
				<td align="center" valign="top">
					<table class="table table-border table-bordered table-bg table-hover table-sort" cellspacing="0" cellpadding="4"><!-- "banking_processing_con_tit" -->
						<thead>
							<tr class="text-c" style="line-height:15px">
								<!-- <th width="80">流量包Id</th> -->
								<th width="80" >联系方式</th>
								<th width="80">联系人</th>
								<th width="80">添加时间</th>
								<th width="80">操作</th>
								<th width="180">催债记录</th>
								<!-- <th width="80">更新时间</th>
								<th width="80">更新日志</th> -->
							</tr>
						</thead>
						<tbody>
							<tr class="text-c ">
								<td class="f-14">
									13699562589
								</td>
								<td class="f-14">
									xiao
								</td>
								<td class="f-14">
									123554552000
								</td>
								<td class="f-14 td-manage success"> 
									改号码&nbsp;&nbsp;	删除
								</td>
								<td class="f-14">
									沟通顺利，
								</td>
							</tr>
							<c:forEach items="${resultMap.pagination.records }" var="record" varStatus="vs">
								<tr class="text-c ">
									<td class="f-14">
										${record.caseContact }
									</td>
									<td class="f-14">
										${record.recordUserName }
									</td>
									<td class="f-14">
										${record.contactRecord }
									</td>
									<td class="f-14">
										${record.recordTime }
									</td>
									<td class="f-14 td-manage success"> 
										改号码&nbsp;&nbsp;	删除
									</td>
										<%--<a style="text-decoration:none" onClick="deptcase_del('/flowsys/record/deptcase_del.do','${record.id}','${record.epName }')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> 
										<a style="text-decoration:none" class="ml-5" onClick="deptcase_edit('平台信息编辑','/flowsys/record/deptcase_edit_page.do?epId=${record.id}','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <!-- <a style="text-decoration:none" class="ml-5" onClick="deptcase_del(this,'10001')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a> --></td> --%>
									<%-- <td><div class="f-12 c-999">
									<span data-toggle="popover"  data-placement="top" style="text-decoration: none;" title="${record.epIp }"><a title="${record.epIp }" href="${record.epIp }" target="_blank">${record.epPurchaseIp }</a></span>
									</div></td> --%>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</td>
				<td width="2"></td>
			</tr>
		</table>
		<%-- <mytag:Pagination pagination="${resultMap.pagination}" queryForm="dataListForm" divId="deptcaselistId" />  --%> 
	</div>
	<footer class="footer mt-20">
		<div class="container">
			<p><!-- 感谢jQuery、layer、laypage、Validform、UEditor、My97DatePicker、iconfont、Datatables、WebUploaded、icheck、highcharts、bootstrap-Switch<br> -->
				Copyright &copy;2017-2018科技有限公司 All Rights Reserved.<br>
				<!-- 本后台系统由<a href="http://www.h-ui.net/" target="_blank" title="H-ui前端框架">H-ui前端框架</a>提供前端技术支持 -->
				</p>
		</div>
	</footer>
<!-- </div> -->
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
 function subForm(){
	 //var caseContact = $('input[name=recordUser]').find("option:selected").text();
	 var caseContact = $('#recordUser').find("option:selected").text();
	 $('#caseContact').val(caseContact);
	$('form').submit();
}

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
</script> 
</body>
</html>