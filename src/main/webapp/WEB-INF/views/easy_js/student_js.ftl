<#macro stujs>
<script>
    $(function() {


        //格式化查询按钮
        $('a[type="query"]').linkbutton({
            plain : true,
        });
        $('input[name="profession"]').combobox({

        });
        $('input[name="classname"]').combobox({

        });

        $('input[name="college"]').combobox({
            textField : 'collegetxt',
            valueField : 'collegetxt',
//            width : 80,
            editable : false,
            data : [{
                collegetxt : '计算机学院',

            },{
                collegetxt : '化学与化工学院',
            },{
                collegetxt : '机电工程学院',
            },{
                collegetxt : '材料与冶金学院',
            },{
                collegetxt : '电子信息工程学院',
            },{
                collegetxt : '土木建筑工程学院',
            },{
                collegetxt : '数理学院',
            },{
                collegetxt : '材料与冶金学院',
            },{
                collegetxt : '环境工程学院',
            },{
                collegetxt : '数理学院',
            },{
                collegetxt :  '医学院',
            },{
                collegetxt :  '经济与管理学院',
            },{
                collegetxt :  '师范学院',
            },{
                collegetxt :  '外国语学院',
            },{
                collegetxt :  '国际学院',
            },{
                collegetxt :  '艺术学院',
            },{
                collegetxt :  '光谷国际北斗学院',
            },{
                collegetxt :  '高职学院',
            }]
        });

        //格式化日期搜索框
        $('input[type="date"]').datetimebox({

        });

        //格式化其它下拉框
        $('input[name="search"]').combobox({
            textField : 'othertxt',
            valueField : 'otherval',
            width : 80,
            editable : false,
            data : [{
                othertxt : '标题',
                otherval : 'title',
            },{
                othertxt : '作者',
                otherval : 'name',
            }]
        });


//	渲染table
        $("#new_table").datagrid({

            url : '/tea/query',
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
            },{
                field : 'sname',
                title : '姓名',
                sortable : true,
                width : 100,
            },{
                field : 'sex',
                title : '性别',
                width : 100,
            },{
                field : 'college',
                title : '学院',
                sortable : true,
                width : 100,
            },{
                field : 'idcard',
                title : '身份证号',
                sortable : true,
                width : 100,

            },{
                field : 'profession',
                title : '专业名称',
                width : 100,
            },{
                field : 'classname',
                title : '行政班',
                width : 100,
            },{
                field : 'grade',
                title : '年级',
                width : 100,
            },{
                field : 'level',
                title : '层次',
                width : 100,
            },{
                field : 'studylength',
                title : '学制',
                width : 100,
            }
            ] ],
        });
        obj={
            query : function () {
                var datetype = $('input[name="dateselect"]').val();
                var starttime = $('input[name="datestart"]').val();
                var endtime = $('input[name="dateend"]').val();
                $('#new_table').datagrid({
                    url : 'new/getBydate.do',
                    //提交额外的参数
                    queryParams:{
                        datetype : datetype,
                        starttime : starttime,
                        endtime : endtime
                    }
                });
                //使用ajax
//			$.post('test',
//					{datetype : datetype,
//					start : start,
//					end : end},
//					function(data, textStatus, xhr) {
//					/*optional stuff to do after success */
//				});
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
            remove : function(){
                var id = $("#new_table").datagrid('getSelected').newid;
                $.ajax({
                    url: 'new/delnew.do',
                    type: 'post',
                    data: {"newid":id},
                    success : function(data) {
                        $.messager.show({
                            title : '消息',
                            msg : '删除'+data+'条数据成功！'
                        });
                        $("#new_table").datagrid("reload");
                    },
                    error : function(){
                        $.messager.show({
                            title : '消息',
                            msg : '删除失败！'
                        });

                    }
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