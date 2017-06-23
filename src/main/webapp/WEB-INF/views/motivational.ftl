<#include "common/_blank_layout.ftl">
<body>
<@jquery></@jquery>
<@table></@table>
<body>
<div class="container clearfix">
    <div class="table_main clearfix">
    <#--<div class="tablebox">-->
        <br>
        <h2 align="center">湖北省(2017-2018)国家励志奖学金申请审批表表</h2><br>
        <form id="poor">
            学校:<input class="title" type="text" name="school" width="45px">&nbsp;
            院系:<input class="title" type="text" name="college" style="width:150px">
            班级:<input class="title" type="text" name="classname" width="100">&nbsp;
            学号:<input class="title" type="text" name="sno" width="20">


            <table border="1" rules="all">
                <tr>
                    <td rowspan="5">基本情况</td>
                    <td>姓名</td>
                    <td colspan="2"><input type="text" name="sname" class="message"/></td>
                    <!--td>&nbsp;</td-->
                    <td>性别</td>
                    <td><select name="sex" class="message" style="width:50px; text-align:center">
                        <option value="男" selected="selected">男</option>
                        <option value="女">女</option>
                    </select></td>
                    <td rowspan="4">
                        <img src="/images/tx.png" alt="" width="90" height="125" id="Img1"><br>
                        <input name="img" type="hidden" value="">
                        <button onclick="updateImg()" type="button">点击更换头像</button>
                    </td>
                </tr>


                <tr>
                    <!--td>&nbsp;</td-->
                    <td>出生年月</td>
                    <td colspan="2"><input type="text" name="birthday" class="message"/></td>
                    <!--td>&nbsp;</td-->
                    <td>入学时间</td>
                    <td><input type="text" name="admissiontime" class="message1"/></td>
                    <!--td>&nbsp;</td-->
                </tr>


                <tr>
                    <!--td>&nbsp;</td-->
                    <td>政治面貌</td>
                    <td colspan="2"><select name="political" class="message" text-align:"center">
                        <option value="群众">群众</option>
                        <option value="共青团员">共青团员</option>
                        <option value="中共预备党员">中共预备党员</option>
                        <option value="中共党员" selected="selected">中共党员</option>
                        </select></td>
                    <!--td>&nbsp;</td-->
                    <td>民族</td>
                    <td><input type="text" class="message1" name="nationality"/></td>
                    <!--td>&nbsp;</td-->
                </tr>


                <tr>
                    <!--td>&nbsp;</td-->
                    <td>专业</td>
                    <td colspan="2">
                        <select name="profession" class="message" style="font-size:14px;">
                            <option value="计算机科学与技术" selected="selected">计算机科学与技术</option>
                            <option value="计算机科学与技术(专升本)">计算机科学与技术(专升本)</option>
                            <option value="软件工程">软件工程</option>
                            <option value="物联网工程">物联网工程</option>
                            <option value="网络工程">网络工程</option>
                            <option value="计算机应用技术">计算机应用技术</option>
                            <option value="计算机网络技术">计算机网络技术</option>
                        </select></td>
                    <!--td>&nbsp;</td-->
                    <td>学制</td>
                    <td>
                        <select name="studylength" style="width:50px">
                            <option value="2">2年</option>
                            <option value="3">3年</option>
                            <option value="4" selected="selected">4年</option>
                        </select></td>
                    <!--td>&nbsp;</td-->
                </tr>


                <tr>
                    <!--td>&nbsp;</td-->
                    <td>身份证号</td>
                    <td colspan="2">
                        <input class="message" type="text" name="idcard"/></td>
                    <!--td>&nbsp;</td-->
                    <td>联系电话<br/>及QQ</td>
                    <td colspan="2">
                        电话：<input type="text" name="stel" class="message" style="height:15px; width:130px"/><br/>
                        &nbsp;QQ：<input type="text" name="qq" class="message" style="height:15px; width:130px"/>
                        <!--没有该字段--></td>
                    <!--td>&nbsp;</td-->
                </tr>


                <tr>
                    <td rowspan="2"><p>学习成绩或</p>
                        <p>综合考评</p></td>
                    <td colspan="3">班级（年级或专业）同学中排名</td>
                    </td>
                    <!--td>&nbsp;</td-->
                    <!--td>&nbsp;</td-->
                    <td colspan="3">家庭经济困难认定等级</td>
                    <!--td>&nbsp;</td-->
                    <!--td>&nbsp;</td-->
                </tr>


                <tr>
                    <!--td>&nbsp;</td-->
                    <td colspan="3">
                        <input type="text" name="ranking" class="message"
                               style="width:30px; border-bottom:#000 1px solid;"/>/<input type="text" name="tnumber"
                                                                                          class="message"
                                                                                          style="width:30px;border-bottom:#000 1px solid;"/>
                        &nbsp;&nbsp;（名次/总人数）
                    </td>
                    <!--td>&nbsp;</td-->
                    <!--td>&nbsp;</td-->
                    <td colspan="3">
                        <input type="radio" name="poorgrades" value="困难"/>困难 &nbsp;<!--没有该字段-->
                        <input type="radio" name="poorgrades" value="一般困难"/>一般困难&nbsp;
                        <input type="radio" name="poorgrades" value="特别困难"/>特别困难&nbsp;</td>
                    <!--td>&nbsp;</td-->
                    <!--td>&nbsp;</td-->
                </tr>


                <tr>
                    <td height="29">受助情况</td>
                    <td><p>上学期受助</p>
                        <p>金额（元）</p></td>
                    <td><input type="text" name="amounted" class="message" style="width:90px;"/> <!--没有该字段--></td>
                    <td><p>上学期资助</p>
                        <p>主要用途</p></td>
                    <td><input type="text" name="fundedpurpose" class="message" style="width:90px;"/> <!--没有该字段--></td>
                    <td><p>本学期申请</p>
                        <p>主要用途</p></td>
                    <td><input type="text" name="fundpurpose" class="message" style="width:90px;"/> <!--没有该字段--></td>
                </tr>


                <tr>
                    <td>指定发放银行卡信息</td>
                    <td>开户银行</td>
                    <td colspan="2">
                        <select name="bankaccount" class="message" style="width:150px;"><!--没有该字段-->
                            <option value="中国交通银行" selected="selected">中国交通银行</option>
                            <option value="中国建设银行">中国建设银行</option>
                            <option value="中国工商银行">中国工商银行</option>
                            <option value="中国农业银行">中国农业银行</option>
                            <option value="中国邮政储蓄银行">中国邮政储蓄银行</option>
                            <option value="湖北银行">湖北银行</option>
                        </select></td>
                    <!--td>&nbsp;</td-->
                    <td>银行卡号</td>
                    <td colspan="2"><input type="text" name="schoolcard" class="message"/></td>
                    <!--td>&nbsp;</td-->
                </tr>


                <tr>
                    <td rowspan="3">经济情况</td>
                    <td>家庭户口</td>
                    <td colspan="2">
                        <input type="radio" name="familyaccount" value="城镇"/>A、城镇 &nbsp;&nbsp;
                        <input type="radio" name="familyaccount" value="农村" checked="checked"/>B、农村
                    </td>
                    <!--td>&nbsp;</td-->
                    <td>家庭人口总数</td>
                    <td colspan="2"><input type="text" name="populationcount" class="message"/>  <!--没有该字段--></td>
                    <!--td>&nbsp;</td-->
                </tr>


                <tr>
                    <!--td>&nbsp;</td-->
                    <td>家庭月总收入</td>
                    <td><input type="text" name="familyincome" class="message" style="width:95px;"/> <!--没有该字段--></td>
                    <td>人均收入</td>
                    <td><input type="text" name="monthlyincome" class="message" style="width:95px;"/>     <!--没有该字段-->
                    </td>
                    <td>收入来源</td>
                    <td><input type="text" name="revenuesource" class="message" style="width:95px;"/>    <!--没有该字段-->
                    </td>
                </tr>


                <tr>
                    <!--td>&nbsp;</td-->
                    <td>家庭住址</td>
                    <td colspan="3"><input type="text" name="address" class="message" style="width:290px;"/></td>
                    <!--td>&nbsp;</td-->
                    <!--td>&nbsp;</td-->
                    <td>家长联系电话</td>
                    <td><input type="text" name="ftel" class="message" style="width:95px;"/></td>
                </tr>


                <tr>
                    <td class="jiacu"><p>申请理由</p>
                        <p>（主要包括</p>
                        <p>成绩情况及家庭情况）</p></td>
                    <td colspan="6"><input type="text" class="messageone" name="applicationreasons" style="width:600px; height:150px; " />  <!--没有该字段&ndash;&gt;-->


                        <pre style="font-size:14px">                                                          <br /> </pre>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（郑重承诺：本人保证所填信息真实、可靠，如发现有弄虚作假，愿承担相应责任。）<br /><br /></td>
                    <!--td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td-->
                </tr>





            <#--<tr>-->
            <#--<td  >&nbsp;</td>-->
            <#--<td colspan="3"  style="text-align:justify; line-height:32px;">&nbsp;&nbsp 院校审核意见：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-->
            <#--<input type="text" name="dsuggest" class="message" style="width:300px; height:100px; font-size:20px;" />-->
            <#--<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（ 公章）<br />-->

            <#--&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <input type="date" name="ddatetime" class="message"   />-->
            <#--</td>-->




            <#--<!--td>&nbsp;</td>-->
            <#--<td>&nbsp;</td&ndash;&gt;-->
            <#--<td colspan="3" style="text-align:justify; line-height:32px;">-->
            <#--&nbsp;&nbsp;学校审核意见：<br />-->
            <#--&nbsp;&nbsp;&nbsp;&nbsp;经评审、公示，无异议，现推荐该同学获得国家励志奖学金。<br />  <br />-->
            <#--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （ 公章）<br />-->

            <#--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;-->
            <#--<input type="date" name="ddatetime" class="message"   />-->
            <#--&nbsp;</td>-->
            <#--<!--td>&nbsp;</td>-->
            <#--<td>&nbsp;</td&ndash;&gt;-->
            <#--</tr>-->


            </table>
            <input type="button" class="btn btn82 btn_save2" onclick="sub()" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btn btn82 btn_res" value="重置">
    </div>
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
                if (data != null || data != "") {
                    var img = document.getElementById("Img1");
                    img.src = "/upload/" + data.img;
                    $("[name=college]").val(data.college);
                    $("[name=classname]").val(data.classname);
                    $("[name=sno]").val(data.sno);
                    $("[name=sname]").val(data.sname);
                    $("[name=sex]").val([data.sex]);
                    $("[name=birthday]").val(data.birthday);
                    $("[name=admissiontime]").val(data.admissiontime);
                    $("[name=studylength]").val(data.studylength);
                    $("[name=nationality]").val(data.nationality);
                    $("[name=political]").val(data.political);
                    $("[name=profession]").val(data.profession);
                    $("[name=idcard]").val(data.idcard);
                    $("[name=stel]").val(data.stel);
                    $("[name=qq]").val(data.qq);
                    $("[name=schoolcard]").val(data.schoolcard);
                    $("[name=familyaccount]").val([data.familyaccount]);
                    $("[name=address]").val(data.address);
                    if (data.ftel != "") {
                        $("[name=ftel]").val(data.ftel);
                    } else {
                        $("[name=ftel]").val(data.mtel);
                    }

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
        $.ajax({
            url: "/motivational/application",
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

</body>
