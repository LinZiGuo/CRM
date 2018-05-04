<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编辑客户</title>
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
				<s:form action="editCustomer" namespace="/customer">
				<s:hidden name="custId" value="%{custId}"></s:hidden>
				<table cellpadding="0" cellspacing="0">
					<tr>
						<th width="100">客户名称 <span class="f_cB">*</span></th>
							<td>
								<div class="txtbox floatL" style="width: 100px;">
									<s:textfield name="custName" type="text" size="20" />
								</div>
							</td>
					</tr>
					<tr>
						<th>所属行业 <span class="f_cB">*</span></th>
						<td><div class="txtbox floatL" style="width: 100px;">
								<s:textfield name="custIndustry" type="text" size="20" />
							</div></td>
					</tr>
					<tr>
						<th>信息来源 <span class="f_cB">*</span></th>
						<td>
							<s:select name="custSource.dictId" list="custSources" listKey="dictId" listValue="dictItemName" headerKey="" headerValue="---请选择---" class="selectbox" style="width:230px;" />
						</td>
					</tr>
					<tr>
						<th>客户级别 <span class="f_cB">*</span></th>
						<td>
							<s:select name="custLevel.dictId" list="custLevels" listKey="dictId" listValue="dictItemName" headerKey="" headerValue="---请选择---" class="selectbox" style="width:230px;" />
						</td>
					</tr>
					<tr>
						<th>联系地址 <span class="f_cB">*</span></th>
						<td>
							<div class="txtbox floatL" style="width: 100px;">
								<s:textfield name="custAddress" type="text" size="100" />
							</div>
						</td>
					</tr>
					<tr>
						<th>联系电话 <span class="f_cB">*</span></th>
						<td><div class="txtbox floatL">
								<s:textfield name="custPhone" type="text" />
							</div></td>
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