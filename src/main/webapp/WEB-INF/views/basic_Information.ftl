<#include "common/_layout3.ftl">

<@HEAD title="主页"/>
<@TOP />
<@SIDE />
<@BODY>
<body>
<div class="container clearfix">
    <div class="table_main clearfix">
        <br><h1 align="center">计算机学院学生个人基本信息表</h1><br>
        <form id="info">
            <input type="hidden" name="id"/>
        <table border="1px" cellspacing="0px" cellpadding="0px"  border-collapse="collapse" rules="all">
            <tbody>
            <tr>
                <td rowspan="7" style="width:33px;">
                    <br>
                    学<br><br>生<br><br>基<br><br>本<br><br>信<br><br>息</td>
                <td height="36" style="width:84px;">
                    学校</td>
                <td style="width:106px;">
                    <input class="message" type="text" name="school"   />
                </td>
                <td style="width:48px;">
                    学院</td>
                <td style="width:113px;">
                    <select name="department">
                        <option value="计算机学院" selected="selected">计算机学院</option>
                        <#--<option value="化学与化工学院">化学与化工学院</option>-->
                        <#--<option value="机电工程学院">机电工程学院</option>-->
                        <#--<option value="材料与冶金学院">材料与冶金学院</option>-->
                        <#--<option value="电子信息工程学院" >电子信息工程学院</option>-->
                        <#--<option value="土木建筑工程学院">土木建筑工程学院</option>-->
                        <#--<option value="数理学院">数理学院</option>-->
                        <#--<option value="材料与冶金学院">材料与冶金学院</option>-->
                        <#--<option value="环境工程学院">环境工程学院</option>-->
                        <#--<option value="医学院">医学院</option>-->
                        <#--<option value="经济与管理学院">经济与管理学院</option>-->
                        <#--<option value="师范学院">师范学院</option>-->
                        <#--<option value="外国语学院">外国语学院</option>-->
                        <#--<option value="国际学院">国际学院</option>-->
                        <#--<option value="艺术学院">艺术学院</option>-->
                        <#--<option value="光谷国际北斗学院">光谷国际北斗学院</option>-->
                        <#--<option value="高职学院">高职学院</option>-->
                    </select>
                </td>
                <td style="width:83px;">
                    年级</td>
                <td style="width:110px;">


                    <select name="grade" class="message" style="width:80px;">
                        <option value="2014" selected="selected">2014级</option>
                        <option value="2015">2015级</option>
                        <option value="2016">2016级</option>
                        <option value="2017">2017级</option>
                    </select>
                </td>
                <td rowspan="4" style="width:130px;" id="updateImg">
                    <img  src="/images/tx.png" alt="" width="130" height="150" id="Img1"><br>
                    <input name="img" type="hidden" value="">
                    <button onclick="updateImg()" type="button">点击更换头像</button>
                </td>
            </tr>
            <tr>
                <td height="37" style="width:84px;">
                    专业</td>
                <td style="width:106px;">

                    <select name="specialty" class="message" style="font-size:14px; text-align: center " >
                        <option value="计算机科学与技术" selected="selected">计算机科学与技术</option>
                        <option value="计算机科学与技术(专升本)" >计算机科学与技术(专升本)</option>
                        <option value="软件工程">软件工程</option>
                        <option value="物联网工程">物联网工程</option>
                        <option value="网络工程"  style=" text-align: center ">网络工程</option>
                        <option value="计算机应用技术">计算机应用技术</option>
                        <option value="计算机网络技术">计算机网络技术</option>
                    </select>
                </td>


                <td style="width:48px;">
                    姓名</td>
                <td style="width:113px;">
                    <input class="message" type="text" name="name" />
                </td>
                <td style="width:83px;">
                    性别</td>
                <td style="width:110px;">
                    <input  type="radio" name="sex" value="男"  checked/>&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;
                    <input  type="radio" name="sex" value="女"   />&nbsp;女
                </td>
            </tr>


            <tr>
                <td style="width:84px;">
                    民族</td>
                <td style="width:106px;">
                    <input class="message" type="text" name="nation" />
                </td>
                <td style="width:48px;">
                    出生<br />
                    日期</td>
                <td style="width:113px;">
                    <input class="message" type="text" name="birthDate" />
                </td>
                <td style="width:83px;">
                    入学时间</td>
                <td style="width:110px;">
                    <input class="message" type="text" name="admissionDate" />
                </td>
            </tr>


            <tr>
                <td height="40" style="width:84px;">
                    政治面貌
                </td>
                <td style="width:106px;">
                    <select name="politicalStatus" style="width:110px">
                        <option value="共青团员" >共青团员</option>
                        <option value="中共预备党员">中共预备党员</option>
                        <option value="中共党员" selected="中共党员">中共党员</option>
                    </select>
                </td>

                <td style="width:106px;">
                    学制
                </td>

                <td style="width:48px;">

                    <select name="studyLength" style="width:50px">
                        <option value="2" >2年</option>
                        <option value="3">3年</option>
                        <option value="4" selected="selected">4年</option>
                    </select>
                </td>

                <td>
                    生源地
                </td>
                <td style="width:113px;">
                    <input class="message" type="text" name="nativePlace" />


                </td>

            </tr>


            <tr>
                <td height="39" style="width:84px;">
                    班级</td>
                <td colspan="2" >
                    <input class="message" type="text" name="classes" style="width:240px;"/>

                </td>


                <td>
                    银行卡号
                </td>
                <td colspan="3" style="width:219px;">
                    <input class="message" type="text" name="bandCard" style="width:320px;"/>  <!--没有该字段-->
                </td>
            </tr>





            <tr>
                <td height="39" style="width:84px;">
                    身份证号</td>
                <td colspan="3" style="width:267px;">
                    <input class="message" type="text" name="idCard" style="width:315px" />
                </td>
                <td style="width:83px;">
                    家庭户口</td>
                <td colspan="2" style="width:219px;">
                    <!--没有该字段-->
                    <input  type="radio" name="residence" value="城镇"  />&nbsp;&nbsp;A、城镇 &nbsp;&nbsp;&nbsp;&nbsp;
                    <input  type="radio" name="residence" value="农村" checked="checked"  />&nbsp;&nbsp;B、农村
                </td>
            </tr>



            <tr>
                <td style="width:84px;">
                    电话号码</td>
                <td style="width:106px;">
                    <input class="message" type="text" name="tel"  />
                </td>
                <td style="width:48px;">
                    QQ</td>
                <td style="width:113px;">
                    <input class="message" type="text" name="qq"  />
                </td>
                <td style="width:83px;">
                    寝室号</td>
                <td colspan="2" style="width:219px;">
                    <input class="message" type="text" name="sroom"  style="width:240px;" />
                </td>
            </tr>
            <tr>
                <td rowspan="3" style="width:33px;">
                    家<br><br>庭<br><br>信<br><br>息</td>
                <td height="39" style="width:84px;">
                    父亲姓名</td>
                <td colspan="2" style="width:154px;">
                    <input class="message" type="text" name="fname"  style="width:180px;" />
                </td>
                <td colspan="2" style="width:196px;">
                    父亲联系电话</td>
                <td colspan="2" style="width:219px;">
                    <input class="message" type="text" name="ftel"  style="width:240px;" />
                </td>
            </tr>
            <tr>
                <td height="40" style="width:84px;">
                    母亲姓名</td>
                <td colspan="2" style="width:154px;">
                    <input class="message" type="text" name="mname"  style="width:180px;" />
                </td>
                <td colspan="2" style="width:196px;">
                    母亲联系电话</td>
                <td colspan="2" style="width:219px;">
                    <input class="message" type="text" name="mtel"  style="width:240px;" />
                </td>
            </tr>
            <tr>
                <td style="width:84px;">
                    家庭详<br />细地址</td>
                <td colspan="6" style="width:569px;">
                    <input class="message" type="text" name="address"  style="width:650px;" />
                </td>
            </tr>
            <tr>
                <td colspan="2" height="165" style="width:33px;">
                    备注信息</td>
                <td colspan="6" style="width:653px;">		<!--没有该字段-->
                    <input class="message" type="text" name="remarks"  style="width:740px; text-align:start; padding-left:15px;" />
                </td>
            </tr>
            </tbody>
        </table>
        </form>
    </div>
    <div align="center">
        <input type="button" name="button" class="btn btn82 btn_save2" value="保存" onclick="updateInfo()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" name="button" class="btn btn82 btn_res" value="重置">
    </div>
</div>
</@BODY>
<@FOOT>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url: "/user/getInfo",
            type: "GET",
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                console.log(data);
                var img = document.getElementById("Img1");
                if(data!=null||data!=""){
                    $("#img1").src = "/upload/"+data.img;
                    img.src = "/upload/"+data.img;
                    $("[name=id]").val(data.id);
                    $("[name=school]").val(data.school);
                    $("[name=department]").val(data.department);
                    $("[name=name]").val(data.name);
                    $("[name=img]").val(data.img);
                    $("[name=sex]").val([data.sex]);
                    $("[name=birthDate]").val(data.birthDate);
                    $("[name=admissionDate]").val(data.admissionDate);
                    $("[name=nation]").val(data.nation);
                    $("[name=studyLength]").val(data.depth);
                    $("[name=nativePlace]").val(data.nativePlace);
                    $("[name=grade]").val(data.grade);
                    $("[name=classes]").val(data.classes);
                    $("[name=bandCard]").val(data.bandCard);
                    $("[name=politicalStatus]").val(data.politicalStatus);
                    $("[name=sroom]").val(data.sroom);
                    $("[name=tel]").val(data.tel);
                    $("[name=idCard]").val(data.idCard);
                    $("[name=residence]").val([data.residence]);
                    $("[name=address]").val(data.address);
                    $("[name=fname]").val(data.fname);
                    $("[name=ftel]").val(data.ftel);
                    $("[name=mname]").val(data.mname);
                    $("[name=mtel]").val(data.mtel);
                    $("[name=qq]").val(data.qq);
                    $("[name=remarks]").val(data.remarks);
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
            url: "/user/updateInfo",
            data: JSON.stringify(d),
            type: "POST",
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                alert(data.content);
            },
            error: function (data) {
            }
        });


    }
</script>

</@FOOT>