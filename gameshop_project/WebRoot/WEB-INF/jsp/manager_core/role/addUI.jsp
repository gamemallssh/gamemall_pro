<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>ADD</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">

    </script>
	
  </head>
  
  <body>
   	<form action="${basePath}manager_core/role_add.action" method="post">
	    <div class="p_d_1">
	        <div class="p_d_1_1">
	            <div class="content_info">
	    <table width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
	        <tr>
	            <td class="tdBg" width="200px">角色名称：</td>
	            <td><s:textfield name="role.role_name" /></td>
	        </tr>
	        <tr>
	            <td class="tdBg" width="200px">角色权限：</td>
	            <td>
	            	<s:checkboxlist list="#privilegeMap" name="privilegeIds"/>
	            </td>
	        </tr>
	    </table>
    
	    <div class="tc mt20">
	        <input type="submit" class="btnB2" value="保存" />
	        &nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
	    </div>
   	</form>
  </body>
</html>
