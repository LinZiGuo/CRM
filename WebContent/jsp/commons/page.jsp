<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<script type="text/javascript">
function topage(num){
	//1.给表单中提供的一个隐藏域赋值，用于提供当前页
	document.getElementById("pagenum").value = num;
	//2.提交表单
	document.forms[0].submit();
}
</script>
<ul id="PageNum">
	<li><a href="javascript:topage(1)">首页</a></li>
	<li><a href="javascript:topage('${page.prePageNum }')"">上一页</a></li>
	<!-- 遍历显示页号 -->
	<s:iterator begin="%{page.beginPageNum}" end="%{page.endPageNum}" var="snum">
		<li><a href="javascript:topage('${snum }')">${snum }</a></li>
	</s:iterator>
	<li><a href="javascript:topage('${page.nextPageNum }')">下一页</a></li>
	<li><a href="javascript:topage('${page.totalPageNum }')">尾页</a></li>
</ul>