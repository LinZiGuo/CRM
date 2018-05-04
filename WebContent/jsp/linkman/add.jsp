<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加联系人</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="generator" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link href="${pageContext.request.contextPath }/css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="${pageContext.request.contextPath }/css/print.css" rel="stylesheet" type="text/css" media="print" />
<script src="${pageContext.request.contextPath }/js/jquery-1.10.1.min.js"></script>
<script src="${pageContext.request.contextPath }/js/side.js" type="text/javascript"></script>

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>
<body>
			<div class="form_boxC">
				<p>
					"<span class="f_cB">*</span>"号为必填项目
				</p>
				<s:form action="addLinkman.action" namespace="/linkman">
				<table cellpadding="0" cellspacing="0">
					<tr>
						<th width="100">所属客户 <span class="f_cB">*</span></th>
							<td>
								<div class="txtbox floatL" style="width: 100px;">
									<s:select name="customer.custId" list="customers" listKey="custId" listValue="custName" headerKey="" headerValue="---请选择---" class="selectbox" style="width:230px;" />
								</div>
							</td>
					</tr>
					<tr>
						<th width="100">姓名 <span class="f_cB">*</span></th>
							<td>
								<div class="txtbox floatL" style="width: 100px;">
									<s:textfield name="lkmName" type="text" size="20" />
								</div>
							</td>
					</tr>
					<tr>
						<th width="100">性别 </th>
							<td>
								<div class="" style="width: 100px;">
									<s:radio name="lkmGender" list="{'男','女'}" value="男" />
								</div>
							</td>
					</tr>
					<tr>
						<th width="100">办公电话 </th>
							<td>
								<div class="txtbox floatL" style="width: 100px;">
									<s:textfield name="lkmPhone" type="text" size="20" />
								</div>
							</td>
					</tr>
					<tr>
						<th width="100">手机 </th>
							<td>
								<div class="txtbox floatL" style="width: 100px;">
									<s:textfield name="lkmMobile" type="text" size="20" />
								</div>
							</td>
					</tr>
					<tr>
						<th width="100">邮箱 </th>
							<td>
								<div class="txtbox floatL" style="width: 100px;">
									<s:textfield name="lkmEmail" type="text" size="20" />
								</div>
							</td>
					</tr>
					<tr>
						<th width="100">职位 </th>
							<td>
								<div class="txtbox floatL" style="width: 100px;">
									<s:textfield name="lkmPosition" type="text" size="20" />
								</div>
							</td>
					</tr>
					<tr>
						<th width="100">简介 </th>
							<td>
								<div class="txtbox floatL" style="width: 120px;">
									<s:textarea name="lkmMemo" type="text" />
								</div>
							</td>
					</tr>
				</table>
			</div>
		</div>
		<!-- SubPopup -->

		<div id="BtmBtn">
			<div class="btn_boxB floatR mag_l20">
				<input type="reset" value="取消">
			</div>
			<div class="btn_box floatR">
				<input type="submit" value="提交">
			</div>
		</div>
	</div>
	</s:form>
	<!-- /Popup -->
</body>
</html>