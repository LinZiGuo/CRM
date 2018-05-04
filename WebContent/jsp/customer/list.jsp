<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户列表</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="generator" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
<link href="${pageContext.request.contextPath }/css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="${pageContext.request.contextPath }/css/print.css" rel="stylesheet" type="text/css" media="print" />
<script src="${pageContext.request.contextPath }/js/jquery-1.10.1.min.js"></script>
<script src="${pageContext.request.contextPath }/js/side.js" type="text/javascript"></script>
<script language="javascript">
	function delOne(custId){
		var sure = window.confirm("确定删除吗？");
		if(sure){
			window.location.href="${pageContext.request.contextPath }/customer/removeCustomer.action?custId="+custId;
		}
	}
</script>

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body>
<s:form action="findAllCustomer" namespace="/custom">
	<s:hidden name="num" value="" id="pagenum"></s:hidden>
	<div id="Search">
		<div class="form_boxA">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td width="100">客户名称 </td>
					<td>
						<s:textfield name="custName" type="text" size="20" />
					</td>
					<td width="60">所属行业 </td>
					<td>
						<s:textfield name="custIndustry" type="text" size="20" />
					</td>
					<td width="60">信息来源 </td>
					<td>
						<s:select name="custSource.dictId" list="custSources" listKey="dictId" listValue="dictItemName" headerKey="" headerValue="请选择" class="selectbox" style="width:80px;" />
					</td>
					<td width="60">客户级别 </td>
					<td>
						<s:select name="custLevel.dictId" list="custLevels" listKey="dictId" listValue="dictItemName" headerKey="" headerValue="请选择" class="selectbox" style="width:80px;" />
					</td>
					<td>
						<div class="btn_box floatR">
							<s:submit value="查询" />
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- MainForm -->
	<div id="MainForm">
		<div class="form_boxA">
			<h2>客户列表</h2>
			<table cellpadding="0" cellspacing="0">
				<tr>
					<th>客户名称</th>
					<th>客户级别</th>
					<th>客户来源</th>
					<th>所属行业</th>
					<th>联系地址</th>
					<th>联系电话</th>
					<th>操作</th>
				</tr>
				<s:iterator value="page.records">
				<tr>
					<td>${custName }</td>
					<td>${custLevel.dictItemName }</td>
					<td>${custSource.dictItemName }</td>
					<td>${custIndustry }</td>
					<td>${custAddress }</td>
					<td>${custPhone }</td>
					<td>
						<s:a action="editUICustomer" namespace="/customer">
							<s:param name="custId" value="%{custId}"></s:param>
							修改</s:a> | 
						<s:a href="javascript:delOne('%{custId}')">删除</s:a>
						</td>
				</tr>
				</s:iterator>
			</table>
			<p class="msg">共找到${page.totalRecords }条记录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;第${page.currentPageNum }页 | 共${page.totalPageNum }页</p>
		</div>
	</div>
	<!-- /MainForm -->
<!-- PageNum -->
<%@ include file="/jsp/commons/page.jsp" %>
<!-- /PageNum -->
</s:form>
</body>
</html>