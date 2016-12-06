<#include "common/_layout3.ftl">

<@HEAD title="主页"/>
<@TOP />
<@SIDE />
<@BODY>
<body>
<div class="container clearfix">
    <div class="table_main clearfix">
        <br><h1 align="center">湖北理工学院家庭经济困难学生申请认定(档案)表</h1><br>
        <form id="poor">
            <input type="hidden" name="id" value="">
        <table border="1" cellspacing="0" cellpadding="0" align="left" border-collapse="collapse">
            <tbody><tr>
                <td width="69" class="toptitle">
                    姓名
                </td>
                <td colspan="2">
                    <input type="text" name="name" style="width:130px;">
                </td>
                <td colspan="2">
                    性别
                </td>
                <td colspan="2" width="50">
                    <input type="text" name="sex" style="width:50px;">
                </td>
                <td colspan="3">
                    出生年月
                </td>
                <td width="88">
                    <input type="text" name="birthdate" style="width:100px;">
                </td>
                <td width="50">
                    民族
                </td>
                <td width="58">
                    <input type="text" name="nation" style="width:50px;">
                </td>
                <td width="122" rowspan="5">
                    <img  src="/images/tx.png" alt="" width="130" height="170" id="Img1"><br>
                    <input name="img" type="hidden" value="">
                    <button onclick="updateImg()" type="button">点击更换头像</button>
                </td>
            </tr>
            <tr>
                <td width="69" rowspan="2" class="toptitle">
                    学制
                </td>
                <td colspan="2" rowspan="2">
                    <input type="hidden" name="studylength">
                    <input type="text" name="studylength1" style="width:50px;">
                </td>
                <td colspan="2" rowspan="2">
                    年级<br>
                    班级
                </td>
                <td colspan="5">
                    <input type="text" name="grade" style="width:60px;">
                </td>
                <td width="88" rowspan="2">
                    政治<br>
                    面貌
                </td>
                <td colspan="2" rowspan="2">
                    <input type="text" name="politicalstatus" style="width:100px;">
                </td>
            </tr>
            <tr>
                <td height="56" colspan="5">
                    <input type="text" name="classes" style="width:180px;">
                </td>
            </tr>
            <tr>
                <td width="69" class="toptitle">
                    寝室
                </td>
                <td colspan="2">
                    <input type="text" name="sroom" style="width:100px;">
                </td>
                <td colspan="2">
                    联系<br>
                    电话
                </td>
                <td colspan="5">
                    <input type="text" name="tel" style="width:120px;">
                </td>
                <td width="88">
                    是否购<br>
                    买保险
                </td>
                <td colspan="2">
                    <input type="text" name="insurance" style="width:120px;">
                </td>
            </tr>
            <tr>
                <td width="69" class="toptitle">
                    身份<br>
                    证号
                </td>
                <td colspan="7">
                    <input type="text" name="idCard" style="width: 200px;">
                </td>
                <td colspan="2">
                    校园<br>
                    卡号
                </td>
                <td colspan="3">
                    <input class="message" type="text" name="bandCard" style="width:320px;"/>
                </td>
            </tr>
            <tr>
                <td width="69" rowspan="8" class="toptitle">
                    家<br><br>
                    庭<br> <br>
                    情<br> <br>
                    况
                </td>
                <td colspan="2">
                    家庭住址
                </td>
                <td colspan="8">
                    <input type="text" name="address" style="width: 350px">
                </td>
                <td colspan="2">
                    家庭邮政编码
                </td>
                <td width="122">
                    <input type="text" name="code" style="width: 130px">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    经济来源
                </td>
                <td colspan="3">
                    <input type="text" name="economicsources" style="width: 100px">
                </td>
                <td colspan="3">
                    家庭<br>
                    月收入
                </td>
                <td colspan="2" style="text-align:right">
                    <input type="text" name="familyincome" width="20">元
                </td>
                <td colspan="2">
                    是否获得<br>
                    生源地贷款
                </td>
                <td width="122">
                    <input type="text" name="isloan" width="10">
                </td>
            </tr>
            <tr>
                <td width="36" rowspan="6">
                    家庭主要成员
                </td>
                <td width="80" rowspan="3" style="text-align:center">
                    家<br>庭<br>人<br>口<br>数
                </td>
                <td colspan="3">
                    家庭
                    关系
                </td>
                <td colspan="3">
                    姓名
                </td>
                <td colspan="4">
                    工作单位或所在地
                </td>
                <td width="122">
                    月收入
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    父亲
                </td>
                <td colspan="3" valign="top">
                    <input type="text" name="fname" style="width:130px;">
                </td>
                <td colspan="4">
                    <input type="text" name="fworkplace" style="width: 350px">
                </td>
                <td width="122">
                    <input type="text" name="fearning" style="width: 50px">
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    母亲
                </td>
                <td colspan="3" valign="top">
                    <input type="text" name="mname" style="width:130px;">
                </td>
                <td colspan="4">
                    <input type="text" name="mworkplace" style="width: 350px">
                </td>
                <td width="122">
                    <input type="text" name="mearning" style="width: 50px">
                </td>
            </tr>
            <tr>
                <td width="80" rowspan="3">
                    <input type="text" name="population" style="width: 50px">
                    <br> <br>
                    人
                </td>
                <td colspan="3">
                    <input type="text" name="m1" style="width: 60px">
                </td>
                <td colspan="3" valign="top">
                    <input type="text" name="m1name" style="width: 80px">
                </td>
                <td colspan="4">
                    <input type="text" name="m1workplace" style="width: 350px">
                </td>
                <td width="122">
                    <input type="text" name="m1earning" style="width: 50px">
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="text" name="m2" style="width: 60px">
                </td>
                <td colspan="3" valign="top">
                    <input type="text" name="m2name" style="width: 80px">
                </td>
                <td colspan="4">
                    <input type="text" name="m2workplace" style="width: 350px">
                </td>
                <td width="122">
                    <input type="text" name="m2earning" style="width: 50px">
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="text" name="m3" style="width: 60px">
                </td>
                <td colspan="3" valign="top">
                    <input type="text" name="m3name" style="width: 80px">
                </td>
                <td colspan="4">
                    <input type="text" name="m3workplace" style="width: 350px">
                </td>
                <td width="122">
                    <input type="text" name="m3earning" style="width: 50px">
                </td>
            </tr>
            <tr>
                <td width="69" class="toptitle">
                    申校<br>
                    材料
                </td>
                <td colspan="13" style="text-align:left">

                <pre>     个人申请 <input type="checkbox" name="check" >     特困证明 <input type="checkbox" name="check" >     父母下岗证 <input type="checkbox" name="check" >    残疾证 <input type="checkbox" name="check" >     低保证 <input type="checkbox" name="check" >

     病情证明 <input type="checkbox" name="check" >     获奖证明 <input type="checkbox" name="check" >（以上证明材料提供复印件附在后页）<pre>                </pre></pre></td>
            </tr>
            <tr>
                <td width="69" class="toptitle">

                    班<br><br>主<br><br>任<br><br>鉴<br><br>定
                </td>
                <td colspan="13" style="text-align:justify">
                    <textarea name="tappraisal" style="width: 950px;height: 120px font-size:18px;
    border:none"></textarea>
			  <pre>

                                                    班主任签字：

                                                                   <input type="date" name="tsigndate"></pre>
                </td>
            </tr>
            <tr>
                <td width="69" class="toptitle">
                    学<br><br>院<br><br>意<br><br>见
                </td>
                <td colspan="13">
            <pre>    经核实，该生评定为：1、贫困学生 <input type="radio" name="dgrades" value="贫困学生"> 2、特困学生 <input type="radio" name="dgrades" value="特困学生">




                                    （公章）         学院领导签字：

                                                                   <input type="date" name="dsigndate"></pre>


                </td>
            </tr>
            <tr>
                <td width="69" class="toptitle">
                    学<br><br>校<br><br>意<br><br>见
                </td>
                <td colspan="13">
              <pre>    经审核，同意该生评定为：1、贫困学生 <input type="radio" name="sgrades" value="贫困学生"> 2、特困学生 <input type="radio" name="sgrades" value="贫困学生">




                                    （公章）         学校领导签章：

                                                                   <input type="date" name="ssigndate"></pre>
                </td>
            </tr>
            </tbody>
        </table>
        </form>
    </div>
    <div align="center">
        <input type="button" class="btn btn82 btn_save2" onclick="sub()" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" class="btn btn82 btn_res" value="重置">
    </div>
</div>
</@BODY>
<@FOOT>
<script type="text/javascript">
    $(function () {
        console.log("aaa");
        $.ajax({
            url: "/user/getInfo",
            type: "GET",
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                console.log(data);
                if(data!=null||data!=""){
                    var img = document.getElementById("Img1");
                    $("[name=id]").val(data.id);
                    $("[name=name]").val(data.name);
                    $("[name=img]").val(data.img);
                    img.src="/upload/"+data.img;
                    $("[name=sex]").val(data.sex);
                    $("[name=birthdate]").val(data.birthDate);
                    $("[name=nation]").val(data.nation);
                    $("[name=studylength]").val(data.studyLength);
                    $("[name=studylength1]").val(data.depth);
                    $("[name=grade]").val(data.grade+"级");
                    $("[name=classes]").val(data.classes);
                    $("[name=bandCard]").val(data.bandCard);
                    $("[name=politicalstatus]").val(data.politicalStatus);
                    $("[name=sroom]").val(data.sroom);
                    $("[name=tel]").val(data.tel);
                    $("[name=idCard]").val(data.idCard);
                    $("[name=address]").val(data.address);
                    $("[name=fname]").val(data.fname);
                    $("[name=mname]").val(data.mname);

                }
            },
            error: function (data) {
            }
        });
    })

    function sub() {
        var d = {};
        var t = $('#poor').serializeArray();
        $.each(t, function () {
            d[this.name] = this.value;
        });
        console.log(d);

    }
</script>

</@FOOT>