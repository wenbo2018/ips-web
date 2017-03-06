<#import "spring.ftl" as spring/>
<!doctype html>
<html lang="en">
<head>
    <link rel="shortcut icon" type="image/x-icon" href="<@spring.url'/resource/images/favicon.ico'/>" media="screen" />
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible'>
    <link rel="stylesheet" type="text/css" href="<@spring.url'/resource/theme/lib/bootstrap/css/bootstrap.css'/>">
    <link rel="stylesheet" href="<@spring.url'/resource/theme/lib/font-awesome/css/font-awesome.css'/>">
    <script src="<@spring.url'/resource/theme/bootstrap-3.3.5.min.js'/>" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="<@spring.url'/resource/theme/stylesheets/theme.css'/>">
    <link rel="stylesheet" type="text/css" href="<@spring.url'/resource/theme/stylesheets/premium.css'/>">
    <link rel="stylesheet" type="text/css" href="<@spring.url'/resource/theme/jquery.pagination.css'/>">
    <script src="<@spring.url'/resource/theme/jquery-2.1.4.min.js'/>"></script>
    <script src="<@spring.url'/resource/theme/jquery.pagination-1.2.7.min.js'/>"></script>
    <script src="<@spring.url'/resource/theme/pages.js'/>"></script>
    <script src="<@spring.url'/resource/theme/admins.js'/>"></script>
</head>

<script type="text/javascript">
    $(window).load(function(){
        apiPage();
    });
</script>
<body class=" theme-blue">

<!-- Demo page code -->

<script type="text/javascript">
    $(function () {
        var match = document.cookie.match(new RegExp('color=([^;]+)'));
        if (match) var color = match[1];
        if (color) {
            $('body').removeClass(function (index, css) {
                return (css.match(/\btheme-\S+/g) || []).join(' ')
            })
            $('body').addClass('theme-' + color);
        }

        $('[data-popover="true"]').popover({html: true});

    });
</script>
<style type="text/css">
    #line-chart {
        height: 300px;
        width: 800px;
        margin: 0px auto;
        margin-top: 1em;
    }

    .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover {
        color: #fff;
    }
</style>

<script type="text/javascript">
    $(function () {
        var uls = $('.sidebar-nav > ul > *').clone();
        uls.addClass('visible-xs');
        $('#main-menu').append(uls.clone());
    });



</script>

<#include "web/menu.ftl"/>

<div class="content">

    <div class="main-content">

        <div class="btn-toolbar list-toolbar">
            <button class="btn btn-primary"><i class="fa fa-plus"></i> New User</button>
            <button class="btn btn-default">Import</button>
            <button class="btn btn-default">Export</button>
            <div class="btn-group">
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading no-collapse">API请求列表<span class="label label-warning">+10</span></div>
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th class="center">Id</th>
                    <th class="center">API URL</th>
                    <th class="center">请求IP</th>
                    <th class="center">请求时间</th>
                    <th class="center">请求状态</th>
                    <th class="center">操作</th>
                </tr>
                </thead>
                <tbody id="contentapi">

                </tbody>
            </table>

        </div>
        <div id="pageapi">
            <!-- pagination所需容器 -->
            <div class="api-pagination"></div>
        </div>
    </div>
</div>


<script src="<@spring.url'/resource/theme/lib/bootstrap/js/bootstrap.js'/>"></script>
<script type="text/javascript">
    $("[rel=tooltip]").tooltip();
    $(function () {
        $('.demo-cancel-click').click(function () {
            return false;
        });
    });
</script>


</body>
</html>
