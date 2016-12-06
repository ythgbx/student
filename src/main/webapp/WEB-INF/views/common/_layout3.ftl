<#macro HEAD title>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/table.css">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/colResizable-1.3.min.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.SuperSlide.js"></script>
    <script type="text/javascript" src="/js/top.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <#nested>
    <title>${title!""} - 资助管理系统</title>
</head>
</#macro>
<#macro TOP>
<body>
<div class="top">
    <div id="top_t">
        <div id="logo" class="fl"></div>
        <div id="photo_info" class="fr">
            <div id="photo" class="fl">
                <a href="#"><img src="/images/a.png" alt="" width="60" height="60"></a>
            </div>
            <div id="base_info" class="fr">
                <div class="help_info">
                    <a href="1" id="hp">&nbsp;</a>
                    <a href="2" id="gy">&nbsp;</a>
                    <a href="/user/logout" id="out">&nbsp;</a>
                </div>
                <div class="info_center">
                ${Session.CURRENT_USER.name}
                    <span id="nt">通知</span><span><a href="#" id="notice">3</a></span>
                </div>
            </div>
        </div>
    </div>
    <div id="side_here">
        <div id="side_here_l" class="fl"></div>
        <div id="here_area" class="fl">当前时间:</div>
    </div>
</div>
</#macro>
<#macro SIDE>
<div class="side">
    <div class="sideMenu" style="margin:0 auto" id="nav">
        <h3> 贫困建档</h3>
        <ul>
            <a href="/poorBuild/page"><li>在线申请</li></a>
        </ul>
        <h3> 国家奖学金</h3>
        <ul>
            <a href="#"><li>在线申请</li></a>
        </ul>
        <h3> 国家励志奖学金</h3>
        <ul>
            <a href="#"><li>在线申请</li></a>
        </ul>
        <h3> 国家助学金</h3>
        <ul>
            <a href="#"><li>在线申请</li></a>
        </ul>
        <h3> 信息维护</h3>
        <ul>
            <a href="/user/information"><li>修改个人信息</li></a>
            <a href="#" data-toggle="modal" data-target="#myModal"><li>修改密码</li></a>
        </ul>

    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:300px">
        <div class="modal-content">
            <form id="retrievePassword">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title">修改密码</h4>
                </div>
                <div class="modal-body">
                    请输入新密码<input type="password" class="form-control" name="new_password" id="pwd1">
                </div>
                <div class="modal-body">
                    请确认新密码<input type="password" class="form-control" name="newPassword1" id="pwd2">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <input onclick="modifyPassword()" type="button" class="btn btn-primary"
                           value="提交"/>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</#macro>
<#macro BODY>
<div class="main" style="overflow: auto">
    <#nested />
</div>
</#macro>
<#macro FOOT>
<div class="bottom">
    <div id="bottom_bg">版权</div>
</div>
<div class="scroll">
    <a href="javascript:;" class="per" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(1);"></a>
    <a href="javascript:;" class="next" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(2);"></a>
</div>
<#nested />
</body>

</html>
</#macro>
