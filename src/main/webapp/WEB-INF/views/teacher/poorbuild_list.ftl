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
    <div class="container clearfix">
        <div class="table_main clearfix">
            <br><h1 align="center">湖北理工学院家庭经济困难学生申请认定(档案)表</h1><br>
            <form id="grant">
                <input type="hidden" name="id" value="">
                <table border="1" cellspacing="0" cellpadding="0" align="left" border-collapse="collapse">
                    <tbody><tr>
                        <td width="69" class="toptitle">
                            姓名
                        </td>
                        <td colspan="2">
                            <input type="text" name="sname" style="width:130px;">
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
                            <input type="text" name="birthDate" style="width:100px;">
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
                            <input type="hidden" name="studyLength">
                            <input type="text" name="depth" style="width:50px;">
                        </td>
                        <td colspan="2" rowspan="2">
                            年级<br>
                            班级
                        </td>
                        <td colspan="5" style="text-align: center">
                            <input type="text" name="grade" style="width:60px;">级
                        </td>
                        <td width="88" rowspan="2">
                            政治<br>
                            面貌
                        </td>
                        <td colspan="2" rowspan="2">
                            <input type="text" name="politicalStatus" style="width:100px;">
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
                            <input type="text" name="isLoan" width="10">
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



                    </tbody>
                </table>
            </form>
        </div>
        <!--  <div align="center">
              <input type="button" class="btn btn82 btn_save2" onclick="sub()" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="button" class="btn btn82 btn_res" value="重置">
          </div>-->
    </div>

</div>
<@js></@js>
<@poorbuildjs></@poorbuildjs>
</body>
</html>