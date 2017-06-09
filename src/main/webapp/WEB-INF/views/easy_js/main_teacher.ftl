<#macro main_techer>
    <script>
        $(function() {
            $('#nav').tree({
                data : [
                    {
                        "id" : 1,
                        "text" : "系统管理",
                        "iconCls" : "icon-save",
                        "children" : [
                            {
                                "text" : "更新信息",
                                "url" : "/page/stulist"
                            },
                            {
                                "text" : "程序信息"
                            }
                        ]
                    },
                    {
                        "id" : 2,
                        "text" : "会员管理",
                        "children" : [
                            {
                                "id" : 7,
                                "text" : "新增会员",
                                "checked" : true
                            },
                            {
                                "text" : "审核会员"
                            }
                        ]
                    }
                ],
                lines : false,
                onLoadSuccess : function(node, data) {
                    if (data) {
                        $(data).each(function(index, value) {
                            if (this.state == 'closed') {
                                //同时展开所有
                                $('#nav').tree('expandAll');
                            }
                        });
                    }
                },
                onClick : function(node) {
                    if (node.url) {
                        if ($('#tabs').tabs('exists', node.text)) {
                            $('#tabs').tabs('select', node.text);
                        } else {
                            $('#tabs').tabs('add', {
                                title : node.text,
                                iconCls : node.iconCls,
                                closable : true,
//						href : node.url + '.html',
                                content : '<iframe scrolling="auto" frameborder="0" src="'+ node.url+'" style="width:100%;height:99%;"></iframe>',
                            });
                        }
                    }
                },
            });
            $('#tabs').tabs({
                fit : true,
                border : false,
            });

        });
    </script>

</#macro>