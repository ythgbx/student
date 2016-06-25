<#macro layoutHead title >
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${title!""} - 追风巴士</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap core CSS -->
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="/css/font-awesome.min.css" rel="stylesheet">
<!-- ionicons -->
<link href="/css/ionicons.min.css" rel="stylesheet">
<!-- Simplify -->
<link href="/css/simplify.min.css" rel="stylesheet">

<#nested>

</head>
</#macro>

<#macro layoutBody>
<body>

<div class="wrapper preload">
    <#include "_sidebar.ftl" >
    <@sidebar></@sidebar>
    <#include "_nav.ftl" >
    <@nav></@nav>
    <#include "_menu.ftl" >
    <@menu></@menu>
    <div class="main-container">
        <div class="padding-md">

            <!--main start-->
            <#nested>
            <!--main end-->

        </div><!-- ./padding-md -->
    </div><!-- /main-container -->

    <footer class="footer">
				<span class="footer-brand">
					<strong class="text-danger">追风</strong> 巴士
				</span>
        <p class="no-margin">
            &copy; 2016 <strong> 亚投 新能 </strong>. ALL Rights Reserved.
        </p>
    </footer>
</div><!-- /wrapper -->

</#macro>


<#macro layoutFooter>
<a href="#" class="scroll-to-top hidden-print"><i class="fa fa-chevron-up fa-lg"></i></a>

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- Jquery -->
<script src="/js/jquery-1.11.1.min.js"></script>
<!-- Bootstrap -->
<script src="/bootstrap/js/bootstrap.min.js"></script>
<!-- Slimscroll -->
<script src='/js/jquery.slimscroll.min.js'></script>
<!-- Popup Overlay -->
<script src='/js/jquery.popupoverlay.min.js'></script>
<!-- Modernizr -->
<script src='/js/modernizr.min.js'></script>
<!-- Simplify -->
<script src="/js/simplify/simplify.js"></script>

<#nested>

</body>
</html>
</#macro>
