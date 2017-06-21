<#include "common/_blank_layout.ftl">
<body>
<@jquery></@jquery>
<@table></@table>
<div class="container clearfix">
    <#--<div class="table_main clearfix">-->
        <#--<br><h2 align="center">湖北理工学院学生个人基本信息表</h2><br>-->
        <div id="table" class="mt10">
            <div class="box span10 oh">
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                    <tr>
                        <th width="30">#</th>
                        <th width="80">申请类型</th>
                        <th width="100">申请时间</th>
                        <th width="100">学院审核结果</th>
                        <th width="100">学校审核结果</th>
                        <th width="100">备注</th>
                    </tr>
                    <#list recordDtos as record>
                        <tr class="tr">
                            <td class="td_center"><input type="checkbox"></td>
                            <td>${record.type!""}</td>
                            <td>${record.date!""}</td>
                            <td>${record.counselor!""}</td>
                            <td>${record.admin!""}</td>
                            <td>${record.remark!""}</td>
                        </tr>
                    </#list>

                </table>

            </div>
        <#--</div>-->

    <#--</div>-->
</div>



<#--<script type="text/javascript">-->
    <#--$(function () {-->
        <#--$.ajax({-->
            <#--url: "/student/getInfo",-->
            <#--type: "GET",-->
            <#--dataType: "json",-->
            <#--contentType: "application/json;charset=UTF-8",-->
            <#--success: function (data) {-->
                <#--console.log(data);-->
                <#--var img = document.getElementById("Img1");-->
                <#--if(data!=null||data!=""){-->
                    <#--$("#img1").src = "/upload/"+data.img;-->
                    <#--img.src = "/upload/"+data.img;-->
                    <#--$("[name=idcard]").val(data.idcard);-->
                    <#--$("[name=sno]").val(data.sno);-->
                    <#--$("[name=sname]").val(data.sname);-->
                    <#--$("[name=usedname]").val(data.usedname);-->
                    <#--$("[name=sex]").val([data.sex]);-->
                    <#--$("[name=college]").val(data.college);-->
                    <#--$("[name=birthday]").val(data.birthday);-->
                    <#--$("[name=profession]").val(data.profession);-->
                    <#--$("[name=classname]").val(data.classname);-->
                    <#--$("[name=grade]").val(data.grade);-->
                    <#--$("[name=level]").val(data.level);-->
                    <#--$("[name=admissiontime]").val(data.admissiontime);-->
                    <#--$("[name=studylength]").val(data.studylength);-->
                    <#--$("[name=nationality]").val(data.nationality);-->
                    <#--$("[name=political]").val(data.political);-->
                    <#--$("[name=sroom]").val(data.sroom);-->
                    <#--$("[name=address]").val(data.address);-->
                    <#--$("[name=stel]").val(data.stel);-->
                    <#--$("[name=schoolcard]").val(data.schoolcard);-->
                    <#--$("[name=fname]").val(data.fname);-->
                    <#--$("[name=ftel]").val(data.ftel);-->
                    <#--$("[name=mname]").val(data.mname);-->
                    <#--$("[name=mtel]").val(data.mtel);-->
                    <#--$("[name=nativeplace]").val(data.nativeplace);-->
                    <#--$("[name=qq]").val(data.qq);-->
                    <#--$("[name=familyaccount]").val([data.familyaccount]);-->
                <#--}-->
            <#--},-->
            <#--error: function (data) {-->
            <#--}-->
        <#--});-->
    <#--})-->

    <#--function updateInfo() {-->
        <#--var d = {};-->
        <#--var t = $('#info').serializeArray();-->
        <#--$.each(t, function () {-->
            <#--d[this.name] = this.value;-->
        <#--});-->
        <#--console.log(d);-->
        <#--$.ajax({-->
            <#--url: "/student/updateInfo",-->
            <#--data: JSON.stringify(d),-->
            <#--type: "POST",-->
            <#--dataType: "json",-->
            <#--contentType: "application/json;charset=UTF-8",-->
            <#--success: function (data) {-->
                <#--alert(data.content);-->
            <#--},-->
            <#--error: function (data) {-->
                <#--alert("请求失败！")-->
            <#--}-->
        <#--});-->
    <#--}-->
<#--</script>-->

</body>
