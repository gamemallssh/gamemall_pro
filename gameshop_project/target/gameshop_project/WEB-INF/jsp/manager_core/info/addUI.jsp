<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>信息发布管理</title>
	<link href="${basePath }css/module/right.css" type="text/css" rel="stylesheet">
	<link href="${basePath }css/module/css.css" type="text/css" rel="stylesheet">

<%-- 	<script type="text/javascript" charset="utf-8" src="${basePath }js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${basePath }js/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${basePath }js/ueditor/lang/zh-cn/zh-cn.js"></script>
    
    <script type="text/javascript">
    	window.UEDITOR_HOME_URL = "${basePath }js/ueditor/";
		var ue = UE.getEditor('editor');
	</script> --%>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath }manager_core/info_add.action" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>信息发布管理</strong>&nbsp;-&nbsp;新增信息</div></div>
    <div class="tableH2">新增信息</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">信息分类：</td>
            <td><s:select name="info.info_type" list="#infoTypeMap" cssStyle="width:90px;"/></td>
            <td class="tdBg" width="200px"></td>
            <td></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">信息标题：</td>
            <td colspan="3"><s:textfield name="info.info_title" cssStyle="width:90%;height:30px;"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">信息内容：</td>
            <td colspan="3"><s:textarea id="editor" name="info.info_content" cssStyle="width:90%;height:160px;" /></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">备注：</td>
            <td colspan="3"><s:textarea name="info.info_memo" cols="90" rows="3"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">创建人：</td>
            <td>
            	<s:property value="#session.SYS_USER.user_name" />
            	<s:hidden name="info.info_creator" value="%{#session.SYS_USER.user_name}"></s:hidden>
            </td>
            <td class="tdBg" width="200px">创建时间：</td>
            <td>
            	<s:date name="info.info_create_time" format="yyyy-MM-dd HH:mm" />
            </td>
        </tr>
    </table>
    <s:hidden name="info.info_create_time"/>
    <!-- 默认信息为发布 -->
    <s:hidden name="info.info_state" value="1"/>
    <!-- 暂存查询条件值 -->
    <s:hidden name="strTitle"/>
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>