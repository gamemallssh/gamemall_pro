<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	function doGoPage(pageNo) {
		if($("#pageNo").val() > ${pageResult.totalPageCount}) {
			pageNo = ${pageResult.totalPageCount};
		}
		document.getElementById("pageNo").value = pageNo;
		document.forms[0].action = list_url;
		document.forms[0].submit();
	}
</script>
<br/>
<div align="center">
	<table>
		<tr>
			<td>
				总共有<s:property value="pageResult.totalCount" />条记录，
				当前第<s:property value="pageResult.pageNo"/>页 ，
				共<s:property value="pageResult.totalPageCount"/>页
			</td>
			<td>
				<s:if test="pageResult.pageNo>1">
					<a href="javascript:doGoPage(<s:property value='pageResult.pageNo-1' />)" >上一页</a>
				</s:if>
				<s:if test="pageResult.pageNo<pageResult.totalPageCount">
					<a href="javascript:doGoPage(<s:property value='pageResult.pageNo+1' />)" >下一页</a>
				</s:if>
			</td>
			<td>
				去到<input type="text" id="pageNo" name="pageNo" onkeypress="if(event.keyCode==13){doGoPage(this.value);}" min="0"
				size="2" max="" value="<s:property value='pageResult.pageNo' />"/>页
			</td>
		</tr>
	</table>
</div>