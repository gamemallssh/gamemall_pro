<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>信息发布管理</title>
	<link href="${basePath }css/module/right.css" type="text/css" rel="stylesheet">
	<link href="${basePath }css/module/css.css" type="text/css" rel="stylesheet">

	<%-- <script type="text/javascript" charset="utf-8" src="${basePath }js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${basePath }js/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${basePath }js/ueditor/lang/zh-cn/zh-cn.js"></script>
    
    <script type="text/javascript">
    	window.UEDITOR_HOME_URL = "${basePath }js/ueditor/";
		var ue = UE.getEditor('editor');
	</script> --%>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath}manager_core/info_edit.action" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>信息发布管理</strong>&nbsp;-&nbsp;修改信息</div></div>
    <div class="tableH2">修改信息</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">信息分类：</td>
            <td><s:select name="info.info_type" list="#infoTypeMap"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">信息标题：</td>
            <td colspan="3"><s:textfield name="info.info_title" cssStyle="width:90%"/></td>
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
            	<s:property value="info.info_creator" />
            	<s:hidden name="info.info_creator" />
            </td>
            <td class="tdBg" width="200px">创建时间：</td>
            <td>
            	<s:date name="info.info_create_time" format="yyyy-MM-dd HH:mm" />
            	<s:hidden name="info.info_create_time" />
            </td>
        </tr>
    </table>
    <!-- 保存特殊数据 -->
    <s:hidden name="info.info_id"/>
    <s:hidden name="info.info_state"/>
    <!-- 暂存查询条件值 -->
    <s:hidden name="strTitle"/>
    <s:hidden name="pageNo"/>
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>