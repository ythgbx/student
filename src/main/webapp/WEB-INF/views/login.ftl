<#include "common/_blank_layout.ftl">
<@layoutHead title="网站">
<meta charset="UTF-8">

<#--<link rel="stylesheet" href="/css/login.css">-->
<#--<script type="text/javascript" src="/js/jquery-3.1.1.min.js"></script>-->
<title>后台登陆</title>
</@layoutHead>

<@layoutBody>
<!-- 这是nested的内容-->
<div id="login_top">
    <div id="welcome">
        欢迎使用......管理系统
    </div>
    <div id="back">
        <a href="#">返回首页</a>&nbsp;&nbsp; | &nbsp;&nbsp;
        <a href="#">帮助</a>
    </div>
</div>
<div id="login_center">
    <div id="login_area">
        <div id="login_form">
            <form id="form_sub">
                <div id="login_tip">
                    用户登录&nbsp;&nbsp;UserLogin
                </div>
                <div><input type="text" class="username" name="userName"></div>
                <div><input type="password" class="pwd" name="password"></div>&nbsp;
                <div>
                    <input type="radio" name="role" value="1" > 辅导员&nbsp;&nbsp;
                    <input type="radio" name="role" value="2"> 班主任&nbsp;&nbsp;
                    <input type="radio" name="role" value="3" checked> 学生
                </div>
                <div id="btn_area">
                    <input type="button" name="submit" id="sub_btn" onclick="validate();" value="登&nbsp;&nbsp;录">&nbsp;&nbsp;
                    <input type="text"  id="input1" class="verify">
                    <input type="text" id="checkCode" class="code"> <a href="#" onclick="createCode()">看不清楚</a>
                    <button type="button" id="update" data-toggle="modal" data-target="#update">忘记密码</button>
                <#--<img src="/images/login/verify.png" alt="" width="80" height="40" id="checkCode"><a href="#" onclick="createCode()">看不清楚</a>-->
                </div>
            </form>
        </div>
    </div>
</div>

<!-- 模态框（Modal） 添加-->
<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="formAdd" enctype="multipart/form-data" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    <#--&times;-->
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        找回密码
                    </h4>
                </div>
                <div class="modal-body">

                    <label for="exampleInputEmail1">商品名称</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="name"
                           placeholder="请输入商品名称">

                    <label for="exampleInputEmail1">商品类型(1:积分 2:优惠卡)</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="typeId"
                           placeholder="请输入该商品类型">

                <#--<label for="exampleInputEmail1">商品标记(默认为0)</label>-->
                    <input type="hidden" class="form-control" id="exampleInputEmail1" name="flag" value="0"
                           placeholder="0">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button onclick="bus.updateCommodity(this)" id="add" type="button" class="btn btn-primary">提交
                    </button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<div id="login_bottom">
    版权所有
</div>
</@layoutBody>

<@layoutFooter>
<script type="text/javascript">
    var code ; //验证码
    function createCode(){
        code = "1111";
//        var codeLength = 4;//验证码为四位
        var checkCode = document.getElementById("checkCode");
//        checkCode.value = "";
//        var selectChar = new Array(1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','j','k','l','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');
//
//        for(var i=0;i<codeLength;i++) {
//            var charIndex = Math.floor(Math.random()*60);
//            code +=selectChar[charIndex];
//        }
//        if(code.length != codeLength){
//            createCode();
//        }
        checkCode.value = code;
    }


    function validate () {
        var inputCode = document.getElementById("input1").value.toUpperCase();
        var codeToUp=code.toUpperCase();
        if(inputCode.length <=0||inputCode.length >4) {
            alert("请输入4位验证码!");
            return false;
        }
        else if(inputCode != codeToUp ){
            alert("验证码输入错误,请从新输入!");
            createCode();
            return false;
        }
        else {
            var d = {};
            var t = $('#form_sub').serializeArray();
            $.each(t, function () {
                d[this.name] = this.value;
            });
            console.log(d);
            $.ajax({
                url: "/user/login",
                data: JSON.stringify(d),
                type: "POST",
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    if (data.result == "success") {
                        window.location.href = '/user/main';
                    }else if (data.result == "failure"){
                        alert(data.content);
                    }
                },
                error: function (data) {
                }
            });

        }

    }
    $(function () {
        createCode();
    })

</script>
</@layoutFooter>