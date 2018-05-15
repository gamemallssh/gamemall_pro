<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/common/header.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>游戏商城与资讯平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${basePath}css/home.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		body{
			width:100%;
			background:#3C3C3C no-repeat 0px 0px;
		    background-size:100% auto;
		    filter : progid:DXImageTransform.Microsoft.AlphaImageLoader ( sizingMethod='scale' , src='../images/home/home_bg.png') ;
		    margin:0;
		    padding:0;
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
	<!-- }头部 -->
<!-- 导航{ -->
<div class="menu">
    <ul class="clearfix">
        <li class="hover"><a href="javascript:void(0);">欢迎</a></li>
		<li><a href="${basePath }mall/home_frame.action">商城</a></li>
        <li><a href="javascript:void(0);">体验区</a></li>
        <li><a href="javascript:void(0);">我的空间</a></li>
        <li><a href="javascript:void(0);">新闻</a></li>
        <li><a href="${basePath }manager_core/home_frame.action">信息管理</a></li>
        <li><a href="javascript:void(0);">商城管理</a></li>
    </ul>
</div>
<!-- }导航 -->
</body>
</html>
