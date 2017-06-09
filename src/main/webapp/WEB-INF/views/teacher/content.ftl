<#include "../common/_layout3.ftl">
<@HEAD title=""></@HEAD>




<body>
<div class="container">
    <span>学院</span>
    <select name="college">
        <option value="计算机学院" selected="selected">计算机学院</option>
        <option value="化学与化工学院">化学与化工学院</option>
        <option value="机电工程学院">机电工程学院</option>
        <option value="材料与冶金学院">材料与冶金学院</option>
        <option value="电子信息工程学院" >电子信息工程学院</option>
        <option value="土木建筑工程学院">土木建筑工程学院</option>
        <option value="数理学院">数理学院</option>
        <option value="材料与冶金学院">材料与冶金学院</option>
        <option value="环境工程学院">环境工程学院</option>
        <option value="医学院">医学院</option>
        <option value="经济与管理学院">经济与管理学院</option>
        <option value="师范学院">师范学院</option>
        <option value="外国语学院">外国语学院</option>
        <option value="国际学院">国际学院</option>
        <option value="艺术学院">艺术学院</option>
        <option value="光谷国际北斗学院">光谷国际北斗学院</option>
        <option value="高职学院">高职学院</option>
    </select>
    <span>专业</span>
    <select name="pre">
        <option>计算机科学与技术</option>
    </select>
    <span>班级</span>
    <select name="pre">
        <option>一班</option>
    </select>
    <span>姓名</span>
    <input type="text" name="name" class="input-text lh25" size="10">
    <input type="button" name="button" class="ext_btn ext_btn_submit" value="查询"></div>

<div id="table" class="mt10">
    <div class="box span10 oh">
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
            <tr>
                <th width="30"><input type="checkbox"></th>
                <th width="100">学号</th>
                <th width="100">姓名</th>
                <th>性别</th>
                <th>学院</th>
                <th>身份证号</th>
                <th>专业名称</th>
                <th>行政班</th>
                <th>年级</th>
                <th>层次</th>
                <th>学制</th>
            </tr>
            </tr>
            <#list list as stu>
            <tr class="tr">
                <td class="td_center">
                    <input type="checkbox"></td>
                <td>${stu.sno}</td>
                <td>${stu.sname}</td>
                <td>${stu.sex}</td>
                <td>${stu.college}</td>
                <td>${stu.idcard}</td>
                <td>${stu.profession}</td>
                <td>${stu.classname}</td>
                <td>${stu.grade}</td>
                <td>${stu.level}</td>
                <td>${stu.studylength}</td>
            </tr>
            </#list>
        </table>
        <div class="page mt10" style="float: right;">
            <div class="pagination">
                <ul>
                    <li class="first-child">
                        <a href="#">首页</a>
                    </li>
                    <li class="disabled">
                        <span>上一页</span>
                    </li>
                    <li class="active">
                        <span>1</span>
                    </li>
                    <li>
                        <a href="#">2</a>
                    </li>
                    <li>
                        <a href="#">下一页</a>
                    </li>
                    <li class="last-child">
                        <a href="#">末页</a>
                    </li>
                </ul>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $(".list_table").colResizable({
            liveDrag:true,
            gripInnerHtml:"<div class='grip'></div>",
            draggingClass:"dragging",
            minWidth:30
        });
    });

</script>
</body>
