<#include "common/_blank_layout.ftl">
<@layoutHead title="网站"></@layoutHead>

<@layoutBody>
<!-- 这是nested的内容-->

<div class="wrapper no-navigation preload">
    <div class="sign-in-wrapper">
        <div class="sign-in-inner">
            <div class="login-brand text-center">
                <i class="fa fa-database m-right-xs"></i> 追风 <strong class="text-skin">巴士</strong>
            </div>

            <form id="form" data-validate="parsley" novalidate>
                <div class="form-group m-bottom-md">
                    <input name="phone" type="text" class="form-control" data-parsley-required="true" placeholder="手机号">
                </div>
                <div class="form-group">
                    <input name="password" type="password" class="form-control" data-parsley-required="true" placeholder="密码">
                </div>

                <div class="form-group">
                    <div class="custom-checkbox">
                        <input type="checkbox" id="chkRemember">
                        <label for="chkRemember"></label>
                    </div>
                    记住密码
                </div>

                <div class="m-top-md p-top-sm">
                    <a id="submit"  class="btn btn-success block">登录</a>
                </div>

                <div class="m-top-md p-top-sm">
                    <div class="font-12 text-center m-bottom-xs">
                        <a href="#" class="font-12">忘记密码?</a>
                    </div>
                    <div class="font-12 text-center m-bottom-xs">没有账号?</div>
                    <a href="/user/registerPage" class="btn btn-default block">注册</a>
                </div>
            </form>
        </div><!-- ./sign-in-inner -->
    </div><!-- ./sign-in-wrapper -->

</@layoutBody>

<@layoutFooter>

    <!-- Parsley -->
    <script src="/js/parsley.min.js"></script>

    <script>

        //Form Validation
        $('#form').parsley( { listeners: {
            onFormSubmit: function ( isFormValid, event ) {
                if(isFormValid)	{
                    return false;
                }
            }
        }});
        $("#submit").click(function(){
            $.ajax({
                url:"/user/login",
                type:"POST",
                contentType: "application/json",
                dataType:"json",
                data:  JSON.stringify(
                        {
                            "phone": $("input[name=phone]").val(),
                            "password": $("input[name=password]").val()
                        }
                ),
                success:function(data){
                    if(data.result=="success")
                    {
                        window.location.href = '/user/list';
                    }
                    else
                    {
                        alert(data.result);
                    }
                },
                error:function(err){
                    alert("登录失败");
                }

            })
        })
    </script>

</@layoutFooter>