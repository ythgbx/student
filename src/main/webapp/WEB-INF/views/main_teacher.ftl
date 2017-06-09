<#include "common/_easy.ftl">
<#include "common/_layout1.ftl">
<#include "easy_js/main_teacher.ftl">
<@HEAD title="主页"></@HEAD>
<@css></@css>
<body class="easyui-layout">

<div data-options="region:'north'" style="height: 78px;">
<@TOP></@TOP>
</div>

<div data-options="region:'south',title:'footer',noheader:true" style="height:35px;line-height:30px;text-align:center;">

</div>
<div data-options="region:'west',title:'导航信息',split:true,iconCls:'icon-help'" style="width:180px;padding:10px;">
    <ul id="nav">

    </ul>

</div>
<div data-options="region:'center'" style="overflow:hidden;">
    <div id="tabs">
        <div title="起始页" iconCls="icon-home" style="padding:0 10px;display:block;">
            欢迎来到后台管理系统！
        </div>
    </div>
</div>
<script type="text/javascript">
    function tabsClose() {
        var tab = $('#tabs').tabs('getSelected');//获取当前选中tabs
        var index = $('#tabs').tabs('getTabIndex', tab);//获取当前选中tabs的index
        $('#tabs').tabs('close', index);//关闭对应index的tabs
    }
    $(function () {
        dsad
    });
</script>
<@js></@js>
<@main_techer></@main_techer>
</body>
</html>