<#include "../common/_easy.ftl">
<#include "../easy_js/poorbuild_js.ftl">
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
<div id="other">
    <div class="otherform">
        <table>
            <tr>
                <label>填表时间</label>
            </tr>
            <label>是否购买保险</label>
            <label>邮政编码</label>
            <label>经济来源</label>
            <label>家庭收入</label>
            <label>是否生源地贷款</label>
            <label>父亲工作单位</label>
            <label>父亲月收入</label>
            <label>母亲工作单位</label>
            <label>母亲月收入</label>
            <label>人口</label>
            <label>申请书</label>
            <label>特困证明</label>
            <label>父母下岗证明</label>
            <label>残疾证</label>
            <label>低保证</label>
        </table>
    </div>
</div>
<@js></@js>
<@poorbuildjs></@poorbuildjs>
</body>
</html>