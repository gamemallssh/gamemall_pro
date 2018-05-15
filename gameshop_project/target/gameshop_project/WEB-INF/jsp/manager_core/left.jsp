<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <link href="${basePath }css/module/css.css" rel="stylesheet" type="text/css"/>
    <link href="${basePath }css/module/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        //隐藏菜单
        $(document).ready(function () {
            $("dt a").click(function () {
                var cur = $(this);
                cur.parent().next().toggle(700);
                var cur_dl = cur.parent().parent();
                doRemoveCurClass();
                $(cur_dl).addClass("curr");
            });

            $("dd a").each(function () {
                $(this).bind("click", function () {
                    doRemoveCurClass();
                    $(this).addClass("cur");
                });
            });

        });

        function doRemoveCurClass() {
            $("dl").each(function () {
                $(this).removeClass("curr");
                $("dd a").each(function () {
                    $(this).removeClass("cur");
                });
            });
        }

        function closeOtherDD(id) {
            $("dd").each(function () {
                if ($(this).attr("id") != id + "dd") {
                    $(this).hide(700);
                }
            });
        }
    </script>
    <style>
        * {
        }
    </style>
</head>
<body>
<div class="xzfw" style="width: 210px;">
    <div class="xzfw_nav" style="width:214px;min-height:500px;">
        <div class="nBox" style="width:214px;">
            <div class="x_top" style="width:214px;"></div>
            <div class="sm">
				<dl class="">
                    <dt><a class="yh" href="${basePath }manager_core/role_listUI.action" target="mainFrame"><b></b>角色管理<s class="down"></s>
                    </a></dt>
                </dl>
                <dl class="">
                    <dt><a class="yh" href="${basePath }manager_core/user_listUI.action" target="mainFrame"><b></b>用户管理<s class="down"></s>
                    </a></dt>
                </dl>
                <dl>
                    <dt><a class="xxfb" href="${basePath }manager_core/info_listUI.action" target="mainFrame"><b></b>信息发布管理<s class="down"></s>
					</a></dt>
                </dl>
            </div>
        </div>
    </div>
</div>
</body>
</html>