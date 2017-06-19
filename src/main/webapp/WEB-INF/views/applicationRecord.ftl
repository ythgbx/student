<#include "common/_blank_layout.ftl">
<body>
<@jquery></@jquery>
<@table></@table>
<div class="container clearfix">
    <div id="table" class="mt10">
        <div class="box span10 oh">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                    <th width="30">#</th>
                    <th width="100">标题</th>
                    <th width="100">标题</th>
                    <th>标题</th>
                </tr>
                <tr class="tr">
                    <td class="td_center"><input type="checkbox"></td>
                    <td>aad</td>
                    <td>aad</td>
                    <td>aad</td>

                </tr>

                <tr class="tr">
                    <td class="td_center"><input type="checkbox"></td>
                    <td>aad</td>
                    <td>aad</td>
                    <td>aad</td>
                    <c:out value="${status.index+1}"> </c:out>

                </tr>

            </table>
</div>



<script type="text/javascript">
    $(function () {
        $.ajax({
            url: "/student/getInfo",
            type: "GET",
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                console.log(data);
                var img = document.getElementById("Img1");
                if(data!=null||data!=""){
                    $("#img1").src = "/upload/"+data.img;
                    img.src = "/upload/"+data.img;
                    $("[name=idcard]").val(data.idcard);
                    $("[name=sno]").val(data.sno);
                    $("[name=sname]").val(data.sname);
                    $("[name=usedname]").val(data.usedname);
                    $("[name=sex]").val([data.sex]);
                    $("[name=college]").val(data.college);
                    $("[name=birthday]").val(data.birthday);
                    $("[name=profession]").val(data.profession);
                    $("[name=classname]").val(data.classname);
                    $("[name=grade]").val(data.grade);
                    $("[name=level]").val(data.level);
                    $("[name=admissiontime]").val(data.admissiontime);
                    $("[name=studylength]").val(data.studylength);
                    $("[name=nationality]").val(data.nationality);
                    $("[name=political]").val(data.political);
                    $("[name=sroom]").val(data.sroom);
                    $("[name=address]").val(data.address);
                    $("[name=stel]").val(data.stel);
                    $("[name=schoolcard]").val(data.schoolcard);
                    $("[name=fname]").val(data.fname);
                    $("[name=ftel]").val(data.ftel);
                    $("[name=mname]").val(data.mname);
                    $("[name=mtel]").val(data.mtel);
                    $("[name=nativeplace]").val(data.nativeplace);
                    $("[name=qq]").val(data.qq);
                    $("[name=familyaccount]").val([data.familyaccount]);
                }
            },
            error: function (data) {
            }
        });
    })

    function updateInfo() {
        var d = {};
        var t = $('#info').serializeArray();
        $.each(t, function () {
            d[this.name] = this.value;
        });
        console.log(d);
        $.ajax({
            url: "/student/updateInfo",
            data: JSON.stringify(d),
            type: "POST",
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                alert(data.content);
            },
            error: function (data) {
                alert("请求失败！")
            }
        });
    }
</script>

</body>
