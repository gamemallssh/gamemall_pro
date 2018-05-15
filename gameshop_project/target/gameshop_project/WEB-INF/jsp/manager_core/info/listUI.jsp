<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>信息发布管理</title>
	<link href="${basePath }css/module/right.css" type="text/css" rel="stylesheet">
    <script type="text/javascript">
	  	//全选、全反选
		function doSelectAll(){
			// jquery 1.6 前
			//$("input[name=selectedRow]").attr("checked", $("#selAll").is(":checked"));
			//prop jquery 1.6+建议使用
			$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
		}
		
		function doAdd() {
			location.href = "${basePath}manager_core/info_addUI.action";
		}
		
		function doEdit(id) {
			document.forms[0].action = "${basePath}manager_core/info_editUI.action?info.info_id="+id;
			document.forms[0].submit();
		}
		
		function doDelete(id) {
			// 重置页号
			$("#pageNo").val(1);
			document.forms[0].action = "${basePath}manager_core/info_delete.action?info.info_id="+id;
			document.forms[0].submit();
		}
		
		function doDeleteAll() {
			// 重置页号
			$("#pageNo").val(1);
			document.forms[0].action = "${basePath}manager_core/info_deleteSelected.action";
			document.forms[0].submit();
		}
		
		function doPublic(info_id, state) {
			$.ajax({
				url:"${basePath}manager_core/info_publicInfo.action",
				data:{"info.info_id":info_id, "info.info_state":state},
				type:"POST",
				success: function(msg) {
					// 更新状态栏，更新显示值
					if("更新状态成功" == msg) {
						if(state == 1) {
							$("#show_"+info_id).html("发布");
							$("#oper_"+info_id).html('<a href="javascript:doPublic(\''+ info_id +'\', 0)">停用</a>');
						}else {
							$("#show_"+info_id).html("停用");
							$("#oper_"+info_id).html('<a href="javascript:doPublic(\''+ info_id +'\', 1)">发布</a>');
						}
					}else {
						alert("更新信息状态失败！");
					}
				},
				error: function() {
					alert("更新信息状态失败！");
				}
			});
		}
		
		var list_url = "${basePath}manager_core/info_listUI.action"
		function doSearch() {
			// 重置页号
			$("#pageNo").val(1);
			document.forms[0].action = list_url;
			document.forms[0].submit();
		}
		
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post">
<div class="p_d_1">
<div class="p_d_1_1">
  <div class="content_info">
     <div class="c_crumbs"><div><b></b><strong>信息发布管理</strong></div></div>
  	 <div class="search_art">
    	<li>
			信息标题：<s:textfield name="info.info_title" cssClass="s_text" id="infoTitle"  cssStyle="width:160px;"/>
        </li>
        <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
         <li style="float:right;">
             <input type="button" value="新增" class="s_button" onclick="doAdd()"/>&nbsp;
             <input type="button" value="删除" class="s_button" onclick="doDeleteAll()"/>&nbsp;
         </li>
     </div>

     <div class="t_list" style="margin:0px; border:0px none;">
         <table width="100%" border="0">
             <tr class="t_tit">
                 <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()" /></td>
                 <td align="center">信息标题</td>
                 <td width="120" align="center">信息分类</td>
                 <td width="120" align="center">创建人</td>
                 <td width="140" align="center">创建时间</td>
                 <td width="80" align="center">状态</td>
                 <td width="120" align="center">操作</td>
             </tr>
             <s:iterator value="pageResult.items" status="st">
                 <tr <s:if test="#st.odd"> bgcolor="f8f8f8" </s:if> >
                     <td align="center"><input type="checkbox" name="selectedRow" value="<s:property value='info_id'/>"/></td>
                     <td align="center"><s:property value="info_title"/></td>
                     <td align="center">
                     	<s:property value="#infoTypeMap[info_type]"/>	
                     </td>
                     <td align="center"><s:property value="info_creator"/></td>
                     <td align="center"><s:date name="info_create_time" format="yyyy-MM-dd HH:mm"/></td>
                     <td align="center" id="show_<s:property value='info_id' />"><s:property value="info_state==1?'发布':'停用'"/></td>
                     <td align="center">
                     	<span id="oper_<s:property value='info_id' />">
                     		<s:if test="info_state == 1">
                     			<a href="javascript:doPublic('<s:property value="info_id" />', 0)">停用</a>
                     		</s:if><s:else>
                     			<a href="javascript:doPublic('<s:property value="info_id" />', 1)">发布</a>
                     		</s:else>
                     	</span>
                         <a href="javascript:doEdit('<s:property value='info_id'/>')">编辑</a>
                         <a href="javascript:doDelete('<s:property value='info_id'/>')">删除</a>
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