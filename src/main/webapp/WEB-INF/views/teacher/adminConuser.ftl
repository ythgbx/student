<#include "../common/_easy.ftl">
<#include "../easy_js/adminConuser_js.ftl">
<@css></@css>
<body>
<div style="margin-bottom: 5px; margin-right: 0px;" id="tools">
    <button href="#" class="easyui-linkbutton" iconCls="icon-add"
       plain="true" id="reset" onclick="obj.resetnew();">添加辅导员</button>
</div>
<div id="new_table"></div>
<@js></@js>
<@adminconjs></@adminconjs>
</body>
</html>