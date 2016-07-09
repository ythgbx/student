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
                    <input name="phone" type="text" class="form-control" data-parsley-required="true" placeholder="Phone Number">
                </div>
                <div class="form-group">
                    <input name="password" type="password" class="form-control" data-parsley-required="true" placeholder="Password">
                </div>

                <div class="form-group">
                    <div class="custom-checkbox">
                        <input type="checkbox" id="chkRemember">
                        <label for="chkRemember"></label>
                    </div>
                    Remember me
                </div>

                <div class="m-top-md p-top-sm">
                    <a id="submit"  class="btn btn-success block">Sign in</a>
                </div>

                <div class="m-top-md p-top-sm">
                    <div class="font-12 text-center m-bottom-xs">
                        <a href="#" class="font-12">Forgot password ?</a>
                    </div>
                    <div class="font-12 text-center m-bottom-xs">Do not have an account?</div>
                    <a href="signup.html" class="btn btn-default block">Create an accounts</a>
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
                dataType:"json",
                data: {
                    phone:$("input[name=phone]").val(),
                    password:$("input[name=password]").val()
                },
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