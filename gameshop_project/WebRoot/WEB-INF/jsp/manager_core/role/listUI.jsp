<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>LIST</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
		//全选、全反选
		function doSelectAll(){
			$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
		}
		
		function doAdd() {
			location.href = "${basePath}manager_core/role_addUI.action";
		}
		
		function doEdit(id) {
			document.forms[0].action = "${basePath}manager_core/role_editUI.action?role.role_id="+id;
			document.forms[0].submit();
		}
		
		function doDelete(id) {
			// 重置页号
			$("#pageNo").val(1);
			document.forms[0].action = "${basePath}manager_core/role_delete.action?role.role_id="+id;
			document.forms[0].submit();
		}
		
		function doDeleteAll() {
			// 重置页号
			$("#pageNo").val(1);
			document.forms[0].action = "${basePath}manager_core/role_deleteSelected.action";
			document.forms[0].submit();
		}
		
		var list_url = "${basePath}manager_core/role_listUI.action"
		function doSearch() {
			// 重置页号
			$("#pageNo").val(1);
			document.forms[0].action = list_url;
			document.forms[0].submit();
		}
	</script>
  </head>
  
  <body>
   	<form action="" method="post">
		<div class="content_info">
             <div class="c_crumbs"><div><b></b><strong>角色管理 </strong></div> </div>
             <div class="search_art">
             	<li>
              		 角色名称：<s:textfield name="role.role_name" cssClass="s_text" id="roleName"  cssStyle="width:160px;"/>
                </li>
                <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                 <li>
                     <input type="button" value="新增" class="s_button" onclick="doAdd()"/>&nbsp;
                     <input type="button" value="删除" class="s_button" onclick="doDeleteAll()"/>&nbsp;
                 </li>
             </div>

             <div class="t_list" style="margin:0px; border:0px none;">
                 <table width="100%" border="0">
                     <tr class="t_tit">
                         <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()" /></td>
                         <td width="120" align="center">角色名称</td>
                         <td width="100" align="center">权限</td>
                         <td width="120" align="center">操作</td>
                     </tr>
                    	<s:iterator value="pageResult.items" status="st">
                         <tr>
                             <td align="center"><input type="checkbox" name="selectedRow" value='<s:property value="role_id"/>'/></td>
                             <td align="center"><s:property value="role_name"/></td>
                             <td align="center">
                             	<s:iterator value="role_privilege">
                             		<s:property value="#privilegeMap[roleprivilege_id.privilege_code]"/>
                             	</s:iterator>
                             </td>
                             <td align="center">
                                 <a href="javascript:doEdit('<s:property value="role_id"/>')">编辑</a>
                                 <a href="javascript:doDelete('<s:property value="role_id"/>')">删除</a>
                             </td>
                         </tr>
                     </s:iterator>
                 </table>
             </div>
        </div>
        <jsp:include page="/common/pageNavigator.jsp" />
   	</form>
  </body>
</html>
