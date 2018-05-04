<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>联系人列表</title>
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
	function delOne(lkmId){
		var sure = window.confirm("确定删除吗？");
		if(sure){
			window.location.href="${pageContext.request.contextPath }/linkman/removeLinkman.action?lkmId="+lkmId;
		}
	}
</script>

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body>
<s:form action="findAllLinkman" namespace="/linkman">
	<div id="Search">
		<div class="form_boxA">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td width="100">所属公司 </td>
					<td>
						<s:select name="customer.custId" list="customers" listKey="custId" listValue="custName" headerKey="" headerValue="请选择" class="selectbox" style="width:80px;" />
					</td>
					<td width="100">姓名 </td>
					<td>
						<s:textfield name="lkmName" type="text" size="20" />
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
					<th>所属公司</th>
					<th>姓名</th>
					<th>性别</th>
					<th>办公电话</th>
					<th>手机</th>
					<th>邮箱</th>
					<th>职位</th>
					<th>操作</th>
				</tr>
				<s:iterator value="linkMans">
				<tr>
					<td>${customer.custName }</td>
					<td>${lkmName }</td>
					<td>${lkmGender }</td>
					<td>${lkmPhone }</td>
					<td>${lkmMobile }</td>
					<td>${lkmEmail }</td>
					<td>${lkmPosition }</td>
					<td>${lkmMemo }</td>
					<td>
						<s:a action="editUILinkman" namespace="/linkman">
							<s:param name="lkmId" value="%{lkmId}"></s:param>
							修改</s:a> | 
						<s:a href="javascript:delOne('%{lkmId}')">删除</s:a>
						</td>
				</tr>
				</s:iterator>
			</table>
			<p class="msg">共找到47条年度预算记录，当前显示从第1条至第10条</p>
		</div>
	</div>
	<!-- /MainForm -->
</s:form>

</body>
</html>