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
                    <input name="confirmpassword" type="password" class="form-control" data-parsley-required="true" placeholder="确认密码">
                </div>


                <div class="m-top-md p-top-sm">
                    <a id="submit"  class="btn btn-success block">注册</a>
                </div>

               <div class="m-top-md p-top-sm">
                   <a href="/user/login" class="btn btn-default block">登录</a>

               </div>
            </form>
        </div><!-- ./sign-in-inner -->
    </div><!-- ./sign-in-wrapper -->

</@layoutBody>

<@layoutFooter>


</@layoutFooter>