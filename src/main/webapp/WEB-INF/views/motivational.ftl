<#include "common/_layout3.ftl">

<@HEAD title="主页"/>
<@TOP />
<@SIDE />
<@BODY>
<body>
<div class="container clearfix">
    <div class="table_main clearfix">
        <br><h1 align="center">湖北省(2015-2016)国家励志奖学金申请审批表表</h1><br>
        <form id="poor">
            学校:<input type="text" name="school" width="20">&nbsp;&nbsp;院系:<input type="text" name="department" width="20">&nbsp;&nbsp;班级:<input type="text" name="classes" width="100">
            学号:<input type="text" name="id" width="20">
            <table border="1px solid"  rules="all">
                <tbody>
                <tr>
                    <td width="87" rowspan="5" style="width:89px;">
                        <strong>基本情况</strong></td>
                    <td >
                        姓 名</td>
                    <td colspan="2">
                        <input type="text" name="name" class="message" style="width:150px;"/>
                    </td>
                    <td colspan="3"  >
                        性 别</td>
                    <td colspan="2">
                        <select name="sex" class="message" style="width:50px; text-align:center">
                            <option value="男" selected="selected">男</option>
                            <option value="女" >女</option>
                        </select>
                    </td>

                    <td rowspan="4" style="width:115px; height:130px;">
                        <img  src="/images/tx.png" alt="" width="130" height="170" id="Img1"><br>
                        <input name="img" type="hidden" value="">
                        <button onclick="updateImg()" type="button">点击更换头像</button>
                    </td>
                </tr>
                <tr>
                    <td >
                        出生年月</td>
                    <td colspan="2" >
                        <input type="text" name="birthDate" class="message" style="width:150px;" />
                    </td>
                    <td colspan="3"  >
                        入学时间</td>
                    <td colspan="2" >
                        <input type="text" name="admissionDate" class="message" />
                    </td>
                </tr>

                <tr>
                    <td >
                        政治面貌</td>
                    <td colspan="2">
                        <select name="politicalstatus" class="message" style="width:110px; text-align:center">
                            <option value="群众" >群众</option>
                            <option value="共青团员">共青团员</option>
                            <option value="中共预备党员" >中共预备党员</option>
                            <option value="中共党员" selected="selected" >中共党员</option>
                        </select>
                    </td>
                    <td colspan="3" >
                        民 族</td>
                    <td colspan="2" >
                        <input type="text" class="message" name="nation"   />
                    </td>
                </tr>
                <tr>
                    <td height="38"  >
                        专 业</td>
                    <td colspan="2" >
                        <select name="specialty" class="message" style="font-size:14px; width:200px" >
                            <option value="计算机科学与技术" selected="selected">计算机科学与技术</option>
                            <option value="计算机科学与技术(专升本)" >计算机科学与技术(专升本)</option>
                            <option value="软件工程">软件工程</option>
                            <option value="物联网工程">物联网工程</option>
                            <option value="网络工程">网络工程</option>
                            <option value="计算机应用技术">计算机应用技术</option>
                            <option value="计算机网络技术">计算机网络技术</option>
                        </select>
                    </td>
                    <td colspan="3" >
                        学 制</td>
                    <td colspan="2" >

                        <select name="studyLength" style="width:50px">
                            <option value="2" >2年</option>
                            <option value="3">3年</option>
                            <option value="4" selected="selected">4年</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td  >
                        身份证号</td>
                    <td colspan="2" >
                        <input class="message" type="text" name="idCard" style="width:150px" />
                    </td>
                    <td colspan="3" >
                        联系电话<br />
                        及ＱＱ号</td>
                    <td  colspan="3" style="text-align:right" />
                    电话<input type="tel" name="tel" class="message" style=" width:120px" />
                    &nbsp;QQ：<input type="text" name="qq" class="message" style=" width:120px" /> <!--没有该字段-->
                    </td>
                </tr>


                <tr>
                    <td rowspan="2">
                        <strong>学习成绩或综合考评</strong></td>
                    <td height="37" colspan="6" >
                        班级（年级或专业）同学中排名</td>
                    <td colspan="3" >
                        家庭经济困难认定等级</td>
                </tr>



                <tr>
                    <td colspan="6">
                        <input type="text" name="ranking" class="message" style="width:30px; border-bottom:#000 1px solid;" />/<input type="text" name="tnumber" class="message" style="width:30px;border-bottom:#000 1px solid;" /> &nbsp;&nbsp;&nbsp;（名次/总人数）</td>
                    <td colspan="3" >
                        <input type="radio" name="level" value="困难" />困难 &nbsp;<!--没有该字段-->
                        <input type="radio" name="level" value="一般困难" />一般困难&nbsp;
                        <input type="radio" name="level" value="特别困难" />特别困难&nbsp;
                    </td>
                </tr>



                <tr>
                    <td style="width:89px;">
                        <strong>受助</strong><br />
                        <strong>情况</strong></td>
                    <td >
                        上学年受助金额（元）</td>
                    <td colspan="3" style="width:120px;">
                        <input type="text" name="lastyearMoney" class="message" style="width:160px;" /> <!--没有该字段-->
                    </td>
                    <td colspan="2" >
                        上学年资助<br />
                        主要用途
                    </td>
                    <td width="375" >
                        <input type="text" name="useofFunds" class="message" style="width:70px;" /> <!--没有该字段-->
                    </td>
                    <td width="91" >
                        本学年申请主要用途</td>
                    <td >
                        <input type="text" name="thisUse" class="message" style="width:110px;" /> <!--没有该字段-->
                    </td>
                </tr>





                <tr>
                    <td style="width:89px;">
                        <strong>指定发放</strong><br />
                        <strong>银行卡信息</strong></td>
                    <td style="width:72px;">
                        开户银行</td>
                    <td colspan="3" >
                        <select name="bankAccount" class="message" style="width:150px;"><!--没有该字段-->
                            <option value="中国交通银行" selected="selected">中国交通银行</option>
                            <option value="中国建设银行">中国建设银行</option>
                            <option value="中国工商银行">中国工商银行</option>
                            <option value="中国农业银行">中国农业银行</option>
                            <option value="中国邮政储蓄银行">中国邮政储蓄银行</option>
                            <option value="湖北银行">湖北银行</option>
                        </select>
                    </td>
                    <td colspan="2">
                        银行<br />
                        卡号</td>
                    <td colspan="3" style="width:211px;">
                        <input type="text" name="bandCard" class="message" style="width:200px; height:30px;" />
                    </td>
                </tr>





                <tr>
                    <td rowspan="3" style="width:89px;">
                        <strong>家庭经济</strong><br />
                        <strong>情 &nbsp;况</strong></td>
                    <td style="width:72px;">
                        家庭户口</td>
                    <td colspan="6" style="width:284px;"><!--没有该字段-->
                        <input  type="radio" name="familybook" value="城镇"  />A、城镇 &nbsp;&nbsp;&nbsp;&nbsp;
                        <input  type="radio" name="familybook" value="农村" checked="checked"  />B、农村
                    </td>
                    <td style="width:76px;">
                        家庭人口<br />
                        总数</td>
                    <td style="width:135px;">
                        <input type="text" name="totalNum" class="message" style="width:110px;" />  <!--没有该字段-->
                    </td>
                </tr>





                <tr>
                    <td height="44" style="width:72px;">
                        家庭月总收入</td>
                    <td colspan="2" style="width:106px;">
                        <input type="text" name="totalMoney" class="message" style="width:210px;" />   <!--没有该字段-->
                    </td>
                    <td colspan="3" style="width:103px;">
                        人均月收入</td>
                    <td style="width:75px;">
                        <input type="text" name="aveMoney" class="message" style="width:70px;" />     <!--没有该字段-->
                    </td>
                    <td style="width:76px;">
                        收入来源</td>
                    <td style="width:135px;">
                        <input type="text" name="Esources" class="message" style="width:110px;"  />	<!--没有该字段-->
                    </td>
                </tr>



                <tr>
                    <td align="center" valign="middle" style="width:72px;">
                        家庭<br />
                        住址<br />
                    </td>
                    <td colspan="5" style="width:284px;">
                        <input type="text" name="address" class="message" style="width:365px;" />
                    </td>
                    <td style="width:76px;">
                        家长联系<br />
                        电话</td>
                    <td style="width:135px;" colspan="2" >
                        <input type="text" name="ftel" class="message" style="width:180px;" />
                    </td>
                </tr>


                <tr>
                    <td style="width:89px;">
                        <strong>申请理由（主要包括成绩情况及家庭情况）</strong></td>
                    <td colspan="9" style="width:567px; text-align:justify;">
                        <input type="text" class="messageone" name="application" style="width:800px; height:150px; " />  <!--没有该字段-->
                        <pre style="font-size:14px">                                                          申请人签名（手签）：       <input type="date" name="datetime" class="message" /><br /> </pre>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（郑重承诺：本人保证所填信息真实、可靠，如发现有弄虚作假，愿承担相应责任。）<br /><br />
                    </td>
                </tr>


                <tr>
                    <td style="width:89px;">
                        <strong>院系推荐<br />意见</strong>
                    </td>


                    <td colspan="5" valign="middle" style="width:150px; text-align:justify;">
                        院系审核意见：<br />
                        <input type="text" name="dsuggest" class="message" style="width:400px; height:80px; font-size:20px;" />
                        <br />
                        <pre style="font-size:14px;">                                            （ 公章）</pre><br />

                        <pre style="font-size:14px;">                       	                   <input type="date" name="ddatetime" class="message"   /></pre>

                    </td>



                    <td colspan="4" style="width:327px; text-align:justify;">
                        学校审核意见：<br /><br />
                        &nbsp;&nbsp;&nbsp;&nbsp经评审、公示，无异议，现推荐该同学获得国家励志奖学金。<br />
                        &nbsp;<br />
                        &nbsp;<br />
                        <pre style="font-size:14px;">                                （ 公章）</pre><br />

                        <pre style="font-size:14px;">                              <input type="date" name="ddatetime" class="message"   /></pre>
                        &nbsp;</td>
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
        $.ajax({
            url: "/user/getInfo",
            type: "GET",
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                console.log(data);
                if(data!=null||data!=""){
                    var img = document.getElementById("Img1");
                    img.src = "/upload/"+data.img;
                    $("[name=img]").val(data.img);
                    $("[name=school]").val(data.school);
                    $("[name=department]").val(data.department);
                    $("[name=classes]").val(data.classes);
                    $("[name=id]").val(data.id);
                    $("[name=name]").val(data.name);
                    $("[name=sex]").val([data.sex]);
                    $("[name=birthDate]").val(data.birthDate);
                    $("[name=nation]").val(data.nation);
                    $("[name=politicalStatus]").val(data.politicalStatus);
                    $("[name=admissionDate]").val(data.admissionDate);
                    $("[name=studyLength]").val(data.studyLength);
                    $("[name=idCard]").val(data.idCard);
                    $("[name=tel]").val(data.tel);
                    $("[name=qq]").val(data.qq);
                    $("[name=residence]").val([data.residence]);
                    $("[name=address]").val(data.address);
                    $("[name=bandCard]").val(data.bandCard);
                    if(data.ftel!=""){
                        $("[name=ftel]").val(data.ftel);
                    }else {
                        $("[name=ftel]").val(data.mtel);
                    }
                    $("[name=m1name]")




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
            url: "/grant/application",
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