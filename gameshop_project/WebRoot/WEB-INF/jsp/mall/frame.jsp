<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>信息管理</title>
	</head>
	
<frameset cols="*,1230,*" class="bj" frameborder="no" border="0" framespacing="0">
    <frame src="${basePath}common/bg.jsp" scrolling="No" noresize="noresize"/>
    <!-- 框架区 -->
	<frameset rows="152,*" cols="*" frameborder="no" border="0">
		<!-- 导航区 -->
		<frame src="${basePath }mall/home_top.action" name="topFrame" scrolling="No" noresize="noresize" id="topFrame"/>
		<!-- 主区 -->
		<frameset rows="*" cols="*" frameborder="no" border="0" framespacing="0">
			<!-- 左部 -->
			<%-- <frame src="${basePath }mall/home_left.action" scrolling="no" noresize="noresize" id="leftFrame" /> --%>
			<!-- 右部 -->
	        <%-- <frame src="${basePath }common/welcome.jsp" name="mainFrame" id="mainFrame" /> --%>
		</frameset>
	</frameset>
    <frame src="${basePath}common/bg.jsp" scrolling="No" noresize="noresize"/>
</frameset>
	
	<body></body>
</html>
