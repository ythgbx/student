<#macro main_techer>
<script>
    $(function () {
        $('#nav').tree({
            data: [
                {
                    "id": 1,
                    "text": "信息管理",
                    "iconCls": "icon-save",
                    "children": [
                        {
                            "text": "学生信息",
                            "url": "/page/stulist"
                        },

                    ]
                },
                {
                    "id": 2,
                    "text": "资助管理",
                    "children": [
                        {
                            "id": 7,
                            "text": "在线审核",
                            "children": [
                                {
                                    "text": "建档管理",
                                    "url": "/page/poorlist"
                                }, {
                                    "text": "助学金管理",
                                    "url": "/page/gran"
                                }, {
                                    "text": "励志奖学金",
                                    "url": "/page/motivation",
                                }
                            ],
                        },
                        {
                            "text": "数据统计",
                            "url" : "/poorBuild/data",
                        }
                    ]
                }, {
                    "id": 3,
                    "text": "用户管理",
                    "iconCls" : "icon-add",
                    "url" : "/page/adminConuser",
                }
            ],
            lines: false,
            onLoadSuccess: function (node, data) {
                if (data) {
                    $(data).each(function (index, value) {
                        if (this.state == 'closed') {
                            //同时展开所有
                            $('#nav').tree('expandAll');
                        }
                    });
                }
            },
            onClick: function (node) {
                if (node.url) {
                    if ($('#tabs').tabs('exists', node.text)) {
                        $('#tabs').tabs('select', node.text);
                    } else {
                        $('#tabs').tabs('add', {
                            title: node.text,
                            iconCls: node.iconCls,
                            closable: true,
//						href : node.url + '.html',
                            content: '<iframe scrolling="auto" frameborder="0" src="' + node.url + '" style="width:100%;height:99%;"></iframe>',
                        });
                    }
                }
            },
        });
        $('#tabs').tabs({
            fit: true,
            border: false,
        });

    });
</script>

</#macro>