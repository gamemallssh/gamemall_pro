<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <link href="${basePath }css/home.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
    	body{
    		margin:0px;
    		padding:0px;
    	}
    </style>
</head>

<body>
	<!-- 头部{ -->
	<table width="1230" border="0" align="center" cellpadding="0" 
	cellspacing="0" background="${basePath}images/home/logo.png" class="top">
		<tr>
			<td width="416" height="100" align="left" valign="middle"></td>
			<td width="300" align="right" valign="top">
				<table width="350" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="17" height="9"></td>
                        <td width="66" height="9"></td>
                        <td width="120" height="5"></td>
                        <td width="17" height="9"></td>
						<td width="36" height="9"></td>
						<td width="17"></td>
						<td width="46"></td>
					</tr>
					<tr>
						<td align="center"/>
                        <td align="left"/>
                        <s:if test="#session.SYS_USER.name != null">
                        	<td align="left"><font color="white">欢迎您，${sessionScope.SYS_USER.name }</font></td>
							<td width="17" align="center"><img src="${basePath}images/home/exit.png"width="14" height="14"/></td>
							<td align="left" valign="middle"><a href="${basePath}sys/login_logout.action" target="_top">退出</a></td>
						</s:if><s:else>
                        	<td align="left">
                        		<font color="white">未登录，请
                        		<a href="#" style="text-decoration:none; color:white; font-size:15px;">登陆</a>
                        		</font>
                        	</td>
							
						</s:else>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<!-- 导航{ -->
	<div class="menu">
		<ul class="clearfix">
        	<li><a href="${basePath }sys/home.action" target="_top">欢迎</a></li>
			<li><a href="${basePath }mall/home_frame.action" target="_top">商城</a></li>
	        <li><a href="javascript:void(0);">体验区</a></li>
	        <li><a href="javascript:void(0);">我的空间</a></li>
	        <li><a href="javascript:void(0);">新闻</a></li>
	        <li class="hover"><a href="javascript:void(0);">信息管理</a></li>
	     	<li><a href="javascript:void(0);">商城管理</a></li>
		</ul>
	</div>
	<!-- }导航 -->
</body>
</html>