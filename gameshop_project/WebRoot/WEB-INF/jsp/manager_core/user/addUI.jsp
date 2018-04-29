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
    	var result = true;
    	// 账号唯一性校验
    	function doVerify() {
    		// 获取账号
    		var account = $("#account").val();
    		// 后台校验
    		if($.trim(account) != "") {
	    		$.ajax({
	    			url: "${basePath}nsfw/user_verifyAccount.action",
	    			data: {"user.account":account},
	    			type: "POST",
	    			success: function(msg){
	    				if("true" != msg) {
	    					alert("该账号已存在，请改用其他账号！");
	    					$("#account").val("");
	    					$("#account").focus();
	    					result = false;
	    				}else {
							result = true;
	    				}
	    			}
	    		});
    		}
    	}
    	// (表单提交)账号唯一性校验
    	$(function(){
    		$("form").submit( function() {
    			var name = $("#name");
	    		if($.trim(name.val()) == ""){
	    			alert("用户名不能为空！");
	    			name.focus();
	    			return false;
	    		}
	    		var account = $("#account");
	    		if($.trim(account.val()) == ""){
	    			alert("账号不能为空！");
	    			account.focus();
	    			return false;
	    		}
	    		var password = $("#password");
	    		if($.trim(password.val()) == ""){
	    			alert("密码不能为空！");
	    			password.focus();
	    			return false;
	    		}
		    	return result;
    	  	});
    	});
    </script>
	
  </head>
  
  <body>
   	<form action="" method="post" enctype="multipart/form-data">
	    <table id="baseInfo" width="100%" align="center" border="0" cellpadding="0" cellspacing="0"  >
	        <tr>
	            <td class="tdBg" width="200px">头像：</td>
	            <td>
	                <input type="file" name="icon"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="tdBg" width="200px">用户名：</td>
	            <td><s:textfield id="name" name="user.user_name"/> </td>
	        </tr>
	        <tr>
	            <td class="tdBg" width="200px">帐号：</td>
	            <td><s:textfield id="account" name="user.user_account" onchange="doVerify()"/></td>
	        </tr>
	        <tr>
	            <td class="tdBg" width="200px">密码：</td>
	            <td><s:textfield id="password" name="user.user_password"/></td>
	        </tr>
	        <tr>
	            <td class="tdBg" width="200px">性别：</td>
	            <td><s:radio list="#{'true':'男','false':'女'}" name="user.user_gender"/></td>
	        </tr>
	        <tr>
	            <td class="tdBg" width="200px">角色：</td>
	            <td><s:checkboxlist list="roleList" listKey="role_id" listValue="role_name" name="userRoleIds"/></td>
	        </tr>
	        <tr>
	            <td class="tdBg" width="200px">电子邮箱：</td>
	            <td><s:textfield id="email" name="user.user_email"/></td>
	        </tr>
	        <tr>
	            <td class="tdBg" width="200px">地址：</td>
	            <td><s:textfield name="user.user_address"/></td>
	        </tr>
	        <tr>
	            <td class="tdBg" width="200px">身份证号码：</td>
	            <td><s:textfield name="user.user_idcard"/></td>
	        </tr>
	        <tr>
	            <td class="tdBg" width="200px">手机号：</td>
	            <td><s:textfield name="user.user_phone"/></td>
	        </tr>
	    </table>
	    <div class="tc mt20">
	        <input type="submit" class="btnB2" value="保存" />
	        &nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="button" onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
	    </div>
   	</form>
  </body>
</html>
