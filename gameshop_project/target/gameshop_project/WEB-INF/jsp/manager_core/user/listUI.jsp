<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>LIST</title>
	<link href="${basePath }css/module/right.css" type="text/css" rel="stylesheet">
	
	<script type="text/javascript">
		//全选、全反选
		function doSelectAll(){
			$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
		}
		
		function doAdd() {
			location.href = "${basePath}manager_core/user_addUI.action";
		}
		
		function doEdit(id) {
			document.forms[0].action = "${basePath}manager_core/user_editUI.action?user.user_id="+id;
			document.forms[0].submit();
		}
		
		function doDelete(id) {
			// 重置页号
			$("#pageNo").val(1);
			document.forms[0].action = "${basePath}manager_core/user_delete.action?user.user_id="+id;
			document.forms[0].submit();
		}
		
		function doDeleteAll() {
			// 重置页号
			$("#pageNo").val(1);
			document.forms[0].action = "${basePath}manager_core/user_deleteSelected.action";
			document.forms[0].submit();
		}
		
		var list_url = "${basePath}manager_core/user_listUI.action"
		function doSearch() {
			// 重置页号
			$("#pageNo").val(1);
			document.forms[0].action = list_url;
			document.forms[0].submit();
		}
	</script>
  </head>
  
  <body class="rightBody">
   	<form action="" method="post">
    <div class="p_d_1">
    <div class="p_d_1_1">
      <div class="content_info">
        <div class="c_crumbs"><div><b></b><strong>用户管理</strong></div></div>
		<div class="search_art">
			<li>
              	用户名：<s:textfield name="user.user_name" cssClass="s_text" id="userName"  cssStyle="width:160px;"/>
            </li>
            <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
	        <li>
	            <input type="button" value="新增" class="s_button" onclick="doAdd()"/>&nbsp;
	            <input type="button" value="删除" class="s_button" onclick="doDeleteAll()"/>&nbsp;
	        </li>
	    </div>
        
        <div class="t_list" style="margin:0px; border:0px none;">
   		<table width="80%" border="0">
   			<tr class="t_tit">
   				<td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()"></td>
                <td width="140" align="center">用户名</td>
                <td width="140" align="center">帐号</td>
                <td width="160" align="center">电话</td>
                <td width="80" align="center">性别</td>
                <td width="160" align="center">地址</td>
                <td width="160" align="center">身份证</td>
                <td width="160" align="center">电子邮箱</td>
                <td width="100" align="center">操作</td>
            </tr>
            
            <s:iterator value="pageResult.items" status="st">
            	<tr <s:if test="#st.odd">bgcolor="f8f8f8"</s:if>>
            		<td align="center"><input type="checkbox" name="selectedRow" value="<s:property value="user_id"/>"/></td>
                    <td align="center"><s:property value="user_name" /></td>
                    <td align="center"><s:property value="user_account"/></td>
                    <td align="center"><s:property value="user_phone"/></td>
                    <td align="center"><s:property value="user_gender?'男':'女'"/></td>
                    <td align="center"><s:property value="user_address"/></td>
                    <td align="center"><s:property value="user_idcard"/></td>
                    <td align="center"><s:property value="user_email"/></td>
                    <td align="center">
                        <a href="javascript:doEdit('<s:property value="user_id"/>')">编辑</a>
                        <a href="javascript:doDelete('<s:property value="user_id"/>')">删除</a>
                    </td>
            	</tr>
            </s:iterator>
   		</table>
   		</div>
   		</div>
        <jsp:include page="/common/pageNavigator.jsp" />
        </div>
        </div>
   	</form>
  </body>
</html>
