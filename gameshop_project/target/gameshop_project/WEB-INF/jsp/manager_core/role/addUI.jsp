<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>角色管理</title>
	<link href="${basePath }css/module/right.css" type="text/css" rel="stylesheet">
	<link href="${basePath }css/module/css.css" type="text/css" rel="stylesheet">
	
  </head>
  
  <body class="rightBody">
   	<form id="form" name="form" action="${basePath}manager_core/role_add.action" method="post">
	    <div class="p_d_1">
	    <div class="p_d_1_1">
	    <div class="content_info">
			<div class="c_crumbs"><div><b></b><strong>角色管理</strong>&nbsp;-&nbsp;新增角色</div></div>
			<div class="tableH2">新增角色</div>
	    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
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
   		</div></div></div>
   	</form>
  </body>
</html>
