<#macro poorbuildjs>
<script>
    $(function() {
        var other = $('input[name="search"]').val();

        //格式化查询按钮
        $('a[type="query"]').linkbutton({
            plain : false,
        });
        $('input[name="profession"]').combobox({
            textField : 'pname',
            valueField : 'pcode',
            editable : false,
            onSelect : function (record) {
                var re = record;
                var url = '/menu/getClassName?pcode='+$(this).combobox('getValue');
                $('input[comboname="classname"]').combobox('clear');
                $('input[comboname="classname"]').combobox('reload',url);
                $('#new_table').datagrid('load',{
                    profession : re.pname
                })
            }

        });
        $('input[name="classname"]').combobox({
            textField : 'cname',
            valueField : 'cname',
            editable : false,
            onSelect : function(record){
                var re = record;
                $('#new_table').datagrid('load',{
                    profession : re.cname
                })
            }

        });

        $('input[name="college"]').combobox({
            textField : 'cname',
            valueField : 'code',
            editable : false,
            url : '/menu/getAllCollege',
            //
            onSelect : function (record) {
                var re = record;
                var url = '/menu/getProfessional?code='+$(this).combobox('getValue');
                $('input[comboname="profession"]').combobox('clear');
                $('input[comboname="classname"]').combobox('clear');
                $('input[comboname="profession"]').combobox('reload',url);
                $('#new_table').datagrid('load',{
                    college : re.cname
                })
            }
        });




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
            },{
                field : 'admin',
                title : '状态',
                width : 100,
                formatter : function (value,row,index) {
                    if(value==0){
                        return '未审核';
                    }
                    if (value==1){
                        return '未通过';
                    }
                    if(value==2){
                        return '通过';
                    }
                }
            }
            ] ],
            onDblClickRow: function (rowIndex,rowData) {
//                $('#other').dialog('open',true);
                //详细信息的对话框
                $('#other').dialog({
                    title : '详细信息',
                    fit : true,
                    buttons : [
                        {
                            text : '通过',
                            handler : function(){
                                //通过ajax
                            }
                        },{
                            text : '不通过',
                            handler : function () {
                                $.messager.prompt('提示信息','请填写备注信息',function (flag) {
                                    if (flag){
                                        //不同的备注信息，update ,ajax
                                        alert(flag);
                                    }
                                });
                            }
                        }
                    ]
                });
                //清除表单数据
                $('#grant').form('clear');
                //加载信息
                $('#grant').form('load',
                    rowData
                );
                //加载学生基本信息
                $('#grant').form('load',
                        rowData.student
                );

                console.log(rowData);
            },

        });




        obj={
            getOther : function (row) {

//                alert('');
            },
            query : function () {
                console.log('query');
            },
            resetnew : function(){;
                $('#new_table').datagrid('load'
                );
            },
        }

        //格式化搜索框
        $('input[name="searchterm"]').searchbox({
            width : 230,
            prompt : '输入查询条件',
            menu : '#term',
            searcher : function(value, name) {
                var parm = {};
                parm[name] = value;
                if (value) {
                    $('#new_table').datagrid('load', parm);
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