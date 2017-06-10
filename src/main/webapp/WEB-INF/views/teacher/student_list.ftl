<#include "../common/_easy.ftl">
<#include "../easy_js/student_js.ftl">
<html lang="en">
<@css></@css>
<body>
<table></table>
<div style="margin-bottom: 5px; margin-right: 0px;" id="tools">
    <label> <label>教学院:</label>
        <input name="college">
        <label>专业:</label>
        <input name="profession">
        <label>班级:</label>
        <input name="classname">
        <a href="#" type="query" onclick="obj.query();">查询</a>
    </label> <label style="padding-left: 100px;">
    <label>查询:</label>
    <input name="searchterm">
</label>

    <a href="#" class="easyui-linkbutton" iconCls="icon-log"
       plain="true" id="reset" onclick="obj.resetnew();">重置</a>


</div>
<div id="term">
    <div name="title">标题</div>
    <div name="name">作者</div>
</div>
<div id="new_table"></div>
<@js></@js>
<@stujs></@stujs>
</body>
</html>