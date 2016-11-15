<#include "common/_layout.ftl">
<@layoutHead title="网站">
<style type="text/css">
    body {
        padding: 0 auto;
        margin: 0 auto;

    }

    #content {
        margin: 0 auto;
        width: 100%;
        height: auto;
        text-align: center;
        vertical-align: text-bottom;

    }

    .form {
        width: 100%;
        height: auto;
        text-align: center;
        background-color: #a4061f;
        margin: 0 auto;

    }

    .footer {
        width: 100%;
        height: 0.2rem;
        text-align: center;
        background-color: #a4061f;
        margin: 0 auto;
    }

    .input {
        background: #fff;
        padding-left: 0.4rem;
        border-radius: 10px;
        -webkit-border-radius: 50px;
        -moz-border-radius: 5px;
        width: 80%;
        height: 0.56rem;
        font-size: 0.2rem;
        border: 1px solid;
        outline: medium;
    }

    　img {
        max-width: 100%;
        height: auto;
        width: 100%
    }

    .top {
        width: 86%;
        height: 0.15rem;
        background-color: #fcdb74;
        margin: 0 auto;

    }

    .middle {
        width: 86%;
        height: 9rem;
        background-color: #fff6d7;
        margin: 0 auto;

    }

    #input1 {
        background: #fff;
        padding-left: 0.2rem;
        border-radius: 10px;
        -webkit-border-radius: 50px;
        -moz-border-radius: 5px;
        width: 45%;
        height: 0.56rem;
        font-size: 0.2rem;
        border: 1px solid;
        outline: medium;
        margin-right: 0;
    }

    #checkcode {
        background: #fec536;
        border-radius: 10px;
        -webkit-border-radius: 50px;
        -moz-border-radius: 5px;
        width: 30%;
        height: 0.6rem;
        font-size: 0.2rem;
        color: #fff;
        border: 1px;
        outline: medium;
        margin-left: 0;
        box-shadow: -2px 0 2px #666666 /*左边阴影*/
    }

</style>

</@layoutHead>

<@layoutBody>
<!-- 这是nested的内容-->
<div>
    <div id="content">
        <img src="6.png" style="width: 100% " align="absmiddle">
        <div class="form">
            <div class="top">
            </div>
            <div class="middle">
                <img src="10.png" style="width:65% ;margin-top:0.5rem " align="absmiddle">
                <form role="form" id="form1">
                    <input type="text" name="school" placeholder="所在学校" style="margin-top: 1rem" class="input"><br/>
                    <input type="text" name="institute" placeholder="所在院系" class="input"><br/>
                    <input type="text" name="name" placeholder="姓名" class="input"><br/>
                    <input type="text" name="phone" placeholder="手机号码" id="input1">
                    <button id="checkcode">获取验证码</button>
                    <input type="text" name="code" placeholder="验证码" class="input">
                </form>
                <a onclick="submit()"><button type="button">报名活动</button></a>
            </div>


        </div>
        <div class="footer">

        </div>
    </div>
</div>


</@layoutBody>

<@layoutFooter>
<script>!function (e) {
    function t(a) {
        if (i[a])return i[a].exports;
        var n = i[a] = {exports: {}, id: a, loaded: !1};
        return e[a].call(n.exports, n, n.exports, t), n.loaded = !0, n.exports
    }

    var i = {};
    return t.m = e, t.c = i, t.p = "", t(0)
}([function (e, t) {
    "use strict";
    Object.defineProperty(t, "__esModule", {value: !0});
    var i = window;
    t["default"] = i.flex = function (e, t) {
        var a = e || 100, n = t || 1, r = i.document, o = navigator.userAgent, d = o.match(/Android[\S\s]+AppleWebkit\/(\d{3})/i), l = o.match(/U3\/((\d+|\.){5,})/i), c = l && parseInt(l[1].split(".").join(""), 10) >= 80, p = navigator.appVersion.match(/(iphone|ipad|ipod)/gi), s = i.devicePixelRatio || 1;
        p || d && d[1] > 534 || c || (s = 1);
        var u = 1 / s, m = r.querySelector('meta[name="viewport"]');
        m || (m = r.createElement("meta"), m.setAttribute("name", "viewport"), r.head.appendChild(m)), m.setAttribute("content", "width=device-width,user-scalable=no,initial-scale=" + u + ",maximum-scale=" + u + ",minimum-scale=" + u), r.documentElement.style.fontSize = a / 2 * s * n + "px"
    }, e.exports = t["default"]
}]);
flex(100, 1);</script>

<script type="text/javascript">
    function submit() {
        console.log("aaaaass")
        var d = {};
        var t = $('#form1').serializeArray();
        $.each(t, function () {
            d[this.name] = this.value;
        })
        console.log(d)
        $.ajax({
            url: "/user/sign",
            data: JSON.stringify(d),
            type: "POST",
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                alert(data.content);
            },
            failure: function (data) {
                alert(data.content)
            }
        });
        window.location.reload();
    }
</script>
<script type="text/javascript">
    $("#checkcode").click(function(e){


        e.preventDefault()
        var phone=$("#input1").val();
        console.log(JSON.stringify({"phone":phone}))
        if(phone==""){
            alert("请输入手机号！")
        }else{
            $.ajax({
                url: "/user/sms",
                data: JSON.stringify({"phone":phone}),
                type: "POST",
                contentType:"application/json",
                success: function (data) {
                    alert("发送成功！");
                },
                failure:function () {
                    alert("发送失败！")
                }
            });
        }
    })

</script>
</@layoutFooter>