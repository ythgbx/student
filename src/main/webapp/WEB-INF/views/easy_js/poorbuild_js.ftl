<#macro poorbuildjs>
<script>
    $(function() {
        var other = $('input[name="search"]').val();

        //格式化查询按钮
        $('a[type="query"]').linkbutton({
            plain : true,
        });
        $('input[name="profession"]').combobox({
            textField : 'pname',
            valueField : 'pcode',
            editable : false,
            onSelect : function (record) {
                var re = record;
                var url = '/menu/getClassName?pcode='+$(this).combobox('getValue');
                $('input[comboname="classname"]').combobox('reload',url);
            }

        });
        $('input[name="classname"]').combobox({
            textField : 'cname',
            valueField : 'cname',
            editable : false,

        });

        $('input[name="college"]').combobox({
            textField : 'cname',
            valueField : 'code',
            editable : false,
            url : '/menu/getAllCollege',
            onSelect : function (record) {
                var re = record;
                var url = '/menu/getProfessional?code='+$(this).combobox('getValue');
                $('input[comboname="profession"]').combobox('reload',url);
                $('#new_table').datagrid('load',{
                    college : re.cname
                })
            }
        });

//        //格式化日期搜索框
//        $('input[type="date"]').datetimebox({
//
//        });
//
//        //格式化其它下拉框
//        $('input[name="search"]').combobox({
//            textField : 'othertxt',
//            valueField : 'otherval',
//            width : 80,
//            editable : false,
//            data : [{
//                othertxt : '标题',
//                otherval : 'title',
//            },{
//                othertxt : '作者',
//                otherval : 'name',
//            }]
//        });


//	渲染table
        $("#new_table").datagrid({
            url : '/puton/getinfo',
            pagination : true,
            pagePosition : 'bottom',
            singleSelect : true,
            border : false,
            fitColumns : true,
            rownumbers : true,
            // 面板大小自适应容器
            fit : true,
            toolbar : '#tools',
            columns : [ [{
                field : '',
                hidden : true,
            },{
                field : 'sno',
                title : '学号',
                sortable : true,
                width : 100,
                formatter : function (value,row,index) {
                    return row.student.sno;
                }
            },{
                field : 'sname',
                title : '姓名',
                sortable : true,
                width : 100,
                formatter : function (value,row,index) {
                    return row.student.sname;
                }
            },{
                field : 'sex',
                title : '性别',
                width : 100,
                formatter : function (value,row,index) {
                    return row.student.sex;
                }
            },{
                field : 'college',
                title : '学院',
                sortable : true,
                width : 100,
                formatter : function (value,row,index) {
                    return row.student.college;
                }
            },{
                field : 'idcard',
                title : '身份证号',
                sortable : true,
                width : 100,

            },{
                field : 'profession',
                title : '专业名称',
                width : 100,
                formatter : function (value,row,index) {
                    return row.student.profession;
                }
            },{
                field : 'classname',
                title : '行政班',
                width : 100,
                formatter : function (value,row,index) {
                    return row.student.classname;
                }
            },{
                field : 'grade',
                title : '年级',
                width : 100,
                formatter : function (value,row,index) {
                    return row.student.grade;
                }
            },{
                field : 'level',
                title : '层次',
                width : 100,
                formatter : function (value,row,index) {
                    return row.student.level;
                }
            },{
                field : 'studylength',
                title : '学制',
                width : 100,
                formatter : function (value,row,index) {
                    return row.student.studylength;
                }
            }
            ] ],
            onDblClickRow: function (rowIndex,rowData) {
//                $('#other').dialog('open',true);
                //详细信息的对话框
                $('#other').dialog({
                    title : '详细信息',
                    fit : true,
                });
                $('#grant').form('load',
                    rowData
                );
                $('#grant').form('load',
                        rowData.student
                );

                console.log(rowData);
            },
            onLoadSuccess : function(data){
                $("a[name='opera']").linkbutton({
                    text:'详细信息',
                    plain:true,
                    iconCls:'icon-man'
                });
            },
        });




        obj={
            getOther : function (row) {

//                alert('');
            },
            query : function () {
                console.log('query');
            },
            resetnew : function(){
                //重置搜索
                //清空查询文本框
                $('input[type="date"]').val("");
                $('input[name="searchterm"]').text("");
                $('#new_table').datagrid({
                    url : '/tea/query',
                });
            },
        }

        //格式化搜索框
        $('input[name="searchterm"]').searchbox({
            width : 230,
            prompt : '输入查询条件',
            menu : '#term',
            searcher : function(value, name) {
                if (value) {
                    $('#new_table').datagrid('load', {
                        term : name,
                        termval : value,
                    });
                }else{
                    $.messager.alert('警告','请输入查询条件','warning');
                }
            },
        });
    });
</script>

</#macro>

<#macro tablecss>
<link type="text/css" rel="stylesheet" href="/css/poortable.css" />
</#macro>