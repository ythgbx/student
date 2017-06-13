<#macro layoutHead title >
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${title!""} - 资助管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
    <link rel="stylesheet" href="/css/login.css" >
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
<#nested>

</head>
</#macro>

<#macro layoutBody>
<body>

<div class="overflow-hidden light-background">
            <!--main start-->
            <#nested>
            <!--main end-->
</div><!-- /wrapper -->
</#macro>

<#macro layoutFooter>
<!-- Jquery -->
<script type="text/javascript" src="/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/colResizable-1.3.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<#nested>

</body>
</html>
</#macro>

<#macro jquery>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
</#macro>
<#macro table>
<link rel="stylesheet" href="/css/common.css">
<#--<link rel="stylesheet" href="/css/style.css">-->
<link rel="stylesheet" href="/css/table.css">
<#--<link rel="stylesheet" href="/css/login.css">-->
</#macro>
