<#include "common/_layout3.ftl">

<@HEAD title="主页"/>
<@TOP />
<@SIDE />
<@BODY>
<body>
<div class="container clearfix">
    <div class="table_main clearfix">
        <br><h1 align="center">湖北省(2016-2017)国家助学金申请表</h1><br>
        <form id="poor">
            学校:<input type="text" name="school" width="20">&nbsp;&nbsp;院系:<input type="text" name="department" width="20">&nbsp;&nbsp;班级:<input type="text" name="classes" width="20">
            学号:<input type="text" name="id" width="20">
            <table align="center" border="1px solid" rules="all">
                <tbody>
                <tr>
                    <td rowspan="3" style="width:77px;">
                        本人<br />
                        情况</td>
                    <td style="width:53px;">
                        姓名</td>
                    <td colspan="2" style="width:122px;">
                        <input type="text" name="name" class="message" style="width:120px;"/>
                    </td>
                    <td style="width:45px;">
                        性别</td>

                    <td colspan="2" style="width:46px;">
                        <select name="sex" class="message" style="width:50px; text-align:center">
                            <option value="男" selected="selected">男</option>
                            <option value="女" >女</option>
                        </select>
                    </td>
                    <td style="width:73px;">
                        出生年月</td>
                    <td style="width:60px;">
                        <input type="text" name="birthdate" class="message" />
                    </td>
                    <td rowspan="3" style="width:115px; height:130px;">
                        照片</td>
                </tr>
                <tr>
                    <td style="width:53px;">
                        民族</td>
                    <td colspan="2" style="width:122px;">
                        <input type="text" class="message" name="nation"   />
                    </td>
                    <td style="width:45px;">
                        政治面貌</td>
                    <td colspan="2" style="width:46px;">
                        <select name="politicalstatus" class="message" style="width:110px; text-align:center">
                            <option value="群众" >群众</option>
                            <option value="共青团员">共青团员</option>
                            <option value="中共预备党员" >中共预备党员</option>
                            <option value="中共党员" selected="selected" >中共党员</option>
                        </select>
                    </td>
                    <td style="width:73px;">
                        入学时间</td>
                    <td style="width:60px;">
                        <input type="text" name="admissiondate" class="message" />
                    </td>
                </tr>
                <tr>
                    <td style="width:53px;">
                        身份<br />证号</td>
                    <td colspan="5" style="width:213px;">
                        <input type="text" name="idcard" class="message" style="width:290px" />
                    </td>
                    <td style="width:73px;">
                        联系电话及ＱＱ号</td>
                    <td style="width:60px; text-align:justify">
                        <input type="tel" name="tel" class="message" style="height:15px" /><br />
                        &nbsp;QQ：<input type="text" name="QQ" class="message" style="height:15px; width:80px" /> <!--没有该字段-->
                    </td>
                </tr>
                <tr>
                    <td rowspan="4" style="width:77px;">
                        &nbsp;<br />
                        家庭<br />
                        经济<br />
                        情况</td>
                    <td style="width:53px;">
                        家庭<br />户口</td>
                    <td colspan="6" style="width:286px;">
                        <input type="radio" name="familybook" value="城镇"   />城镇 &nbsp;&nbsp;&nbsp;   <!--没有该字段-->
                        <input type="radio" name="familybook" value="农村" checked="checked" />农村
                    </td>
                    <td style="width:109px;">
                        家庭人口总数</td>
                    <td style="width:101px;">
                        <input type="text" name="totalNum" class="message" style="width:110px;" />  <!--没有该字段-->
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="width:109px;">
                        家庭月总收入</td>
                    <td style="width:67px;">
                        <input type="text" name="totalMoney" class="message" style="width:80px;" />   <!--没有该字段-->
                    </td>
                    <td colspan="3" style="width:91px;">
                        人均月收入</td>
                    <td style="width:73px;">
                        <input type="text" name="aveMoney" class="message" style="width:70px;" />     <!--没有该字段-->
                    </td>
                    <td style="width:109px;">
                        收入来源</td>
                    <td style="width:101px;">
                        <input type="text" name="Esources" class="message" style="width:110px;"  />	<!--没有该字段-->
                    </td>
                </tr>
                <tr>
                    <td colspan="3" style="width:175px;">
                        家庭经济困难认定等级</td>
                    <td colspan="6" style="width:374px;">
                        <input type="radio" name="level" value="困难" />困难 &nbsp;&nbsp;&nbsp;	<!--没有该字段-->
                        <input type="radio" name="level" value="一般困难" />一般困难&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="level" value="特别困难" />特别困难&nbsp;&nbsp;&nbsp;
                    </td>

                </tr>
                <tr>
                    <td colspan="2" style="width:109px;">
                        家庭住址</td>
                    <td colspan="5" style="width:231px;">
                        <input type="text" name="address" class="message" style="width:365px;" />
                    </td>
                    <td style="width:109px;">
                        家长联系电话</td>
                    <td style="width:101px;">
                        <input type="text" name="ftel" class="message" style="width:110px;" />
                    </td>
                </tr>
                <tr>
                    <td style="width:77px;">
                        受助<br />
                        情况</td>
                    <td colspan="2" style="width:109px;">
                        上学年<br />
                        受助金额(元)</td>
                    <td style="width:67px;">
                        <input type="text" name="lastyearMoney" class="message" style="width:80px;" /> <!--没有该字段-->
                    </td>
                    <td colspan="3" style="width:91px;">
                        上学年资助<br />
                        主要用途</td>
                    <td style="width:73px;">
                        <input type="text" name="useofFunds" class="message" style="width:70px;" /> <!--没有该字段-->
                    </td>
                    <td style="width:109px;">
                        本学年申请主要用途</td>
                    <td style="width:101px;">
                        <input type="text" name="thisUse" class="message" style="width:110px;" /> <!--没有该字段-->
                    </td>
                </tr>
                <tr>
                    <td style="width:77px;">
                        指定发放<br />
                        银行卡信息</td>
                    <td colspan="2" style="width:109px;">
                        开户银行</td>
                    <td colspan="4" style="width:158px;">
                        <select name="bankAccount" class="message" style="width:150px;"><!--没有该字段-->
                            <option value="中国交通银行" selected="selected">中国交通银行</option>
                            <option value="中国建设银行">中国建设银行</option>
                            <option value="中国工商银行">中国工商银行</option>
                            <option value="中国农业银行">中国农业银行</option>
                            <option value="中国邮政储蓄银行">中国邮政储蓄银行</option>
                            <option value="湖北银行">湖北银行</option>
                        </select>
                    </td>
                    <td style="width:73px;">
                        银行<br />
                        卡号</td>
                    <td colspan="2" style="width:210px;"><!--没有该字段-->
                        <input type="text" name="bankNo" class="message" style="width:250px; height:50px;" />
                    </td>
                </tr>
                <tr>
                    <td rowspan="4" style="width:77px;">
                        家庭<br />
                        主要<br />
                        成员<br />
                        情况</td>
                    <td colspan="2" style="width:109px;">
                        姓名</td>
                    <td style="width:67px;">
                        年龄</td>
                    <td colspan="3" style="width:91px;">
                        与本人关系</td>
                    <td colspan="3" style="width:283px;">
                        工作单位或职业</td>
                </tr>
                <tr>
                    <td colspan="2" style="width:109px;">
                        <input type="text" class="message" name="fname" style="width:110px" />
                    </td>
                    <td style="width:67px;">
                        <input type="text" class="message" name="fage" style="width:80px" /><!--没有该字段-->
                    </td>
                    <td colspan="3" style="width:91px;">
                        <input type="text" class="message" name="frel" style="width:150px;" />
                    </td>
                    <td colspan="3" style="width:283px;">
                        <input type="text" class="message" name="fworkadd" style="width:320px;" /><!--没有该字段-->
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="width:109px;">
                        <input type="text" class="message" name="mname" style="width:110px;" />
                    </td>
                    <td style="width:67px;">
                        <input type="text" class="message" name="mage" style="width:80px;" /><!--没有该字段-->
                    </td>
                    <td colspan="3" style="width:91px;">
                        <input type="text" class="message" name="mrel" style="width:150px;" />
                    </td>
                    <td colspan="3" style="width:283px;">
                        <input type="text" class="message" name="mworkadd" style="width:320px;" /><!--没有该字段-->
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="width:109px;">
                        <input type="text" class="message" name="oname" style="width:110px;" /><!--没有该字段-->
                    </td>
                    <td style="width:67px;">
                        <input type="text" class="message" name="oage" style="width:80px;" /><!--没有该字段-->
                    </td>
                    <td colspan="3" style="width:91px;">
                        <input type="text" class="message" name="orel" style="width:150px;" /><!--没有该字段-->
                    </td>
                    <td colspan="3" style="width:283px;">
                        <input type="text" class="message" name="oworkadd" style="width:320px;" /><!--没有该字段-->
                    </td>
                </tr>
                <tr>
                    <td colspan="10" style="width:627px; text-align:justify;" >
                        申请理由:<br />
                        <input type="text" class="messageone" name="application" style="width:810px; height:150px; " />

                        <pre style="font-size:14px">                                                                      申请人签名（手签）：   <input type="date" name="datetime" class="message" /><br /> </pre>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（郑重承诺：本人保证所填信息真实、可靠，如发现有弄虚作假，愿承担相应责任。）
                    </td>
                </tr>


                <tr>
                    <td colspan="6"  style="width:319px; text-align:justify;">
                        院系审核意见：<br />
                        <input type="text" name="dsuggest" class="message" style="width:400px; height:80px; font-size:20px;" />
                        <br />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（ 公章）<br />
                        <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="date" name="ddatetime" class="message"   />

                        &nbsp;&nbsp;&nbsp;</td>


                    <td colspan="6"  style="width:319px; text-align:justify;">
                        学 校 审 核 意 见：<br /><br />
                <pre style="font-size:20px;">   经 评 审，批 准 该 生 获 得<input type="text" name="" class="messageone" style="width:30px; height:30px; text-align:center; font-size:18px;" />等 国 家
助 学 金。</pre>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（ 公章）<br />
                        <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="date" name="ddatetime" class="message"   />

                        &nbsp;&nbsp;&nbsp;</td>
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
                    $("[name=birthDate]").val(data.birthDate);
                    $("[name=nation]").val(data.nation);
                    $("[name=studyLength]").val(data.studyLength);
                    $("[name=depth]").val(data.depth);
                    $("[name=grade]").val(data.grade);
                    $("[name=classes]").val(data.classes);
                    $("[name=bandCard]").val(data.bandCard);
                    $("[name=politicalStatus]").val(data.politicalStatus);
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
        $.ajax({
            url: "/poorBuild/application",
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