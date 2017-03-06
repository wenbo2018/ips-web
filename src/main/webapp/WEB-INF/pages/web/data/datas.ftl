<#import "spring.ftl" as spring/>
<!doctype html>
<html lang="en">
<head>
    <link rel="shortcut icon" type="image/x-icon" href="<@spring.url'/resource/images/favicon.ico'/>" media="screen" />
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible'>
    <link rel="stylesheet" type="text/css" href="<@spring.url'/resource/theme/lib/bootstrap/css/bootstrap.css'/>">
    <link rel="stylesheet" href="<@spring.url'/resource/theme/lib/font-awesome/css/font-awesome.css'/>">

    <script src="<@spring.url'/resource/theme/lib/jquery-1.11.1.min.js'/>" type="text/javascript"></script>

    <link rel="stylesheet" type="text/css" href="<@spring.url'/resource/theme/stylesheets/theme.css'/>">
    <link rel="stylesheet" type="text/css" href="<@spring.url'/resource/theme/stylesheets/premium.css'/>">

    <link rel="stylesheet" type="text/css" href="<@spring.url'/resource/theme/jquery.pagination.css'/>">
    <script src="<@spring.url'/resource/theme/jquery-2.1.4.min.js'/>"></script>
    <script src="<@spring.url'/resource/theme/jquery.pagination-1.2.7.min.js'/>"></script>
    <script src="<@spring.url'/resource/theme/pages.js'/>"></script>
    <script src="<@spring.url'/resource/theme/admins.js'/>"></script>
</head>
<body class=" theme-blue">

<!-- Demo page code -->
<script type="text/javascript">
    $(window).load(function(){
        imuPage();
        wifiPage();
        dataRPage();
        apPage();
    });

</script>
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


        <div class="row" >
            <select style="width: 200px;height: 34px;margin-left: 13px;" class="selectpicker">
                <option value="-12.0">(GMT -12:00) </option>
                <option value="-11.0">(GMT -11:00) </option>
                <option value="-10.0">(GMT -10:00) Hawaii</option>
                <option value="-9.0">(GMT -9:00) Alaska</option>
                <option selected="selected" value="-8.0">(GMT -8:00) Pac</option>
            </select>
            <div class="btn-group">
            <button class="btn btn-primary"><i class="fa fa-plus"></i>导出Excel数据</button>&nbsp;
            </div>
        </div>
        <br>

        <ul class="nav nav-tabs">
            <li class="active"><a href="#home" data-toggle="tab">IMU数据</a></li>
            <li><a href="#profile"   data-toggle="tab">WIFI数据</a></li>
            <li><a href="#recoder"   data-toggle="tab">数据采集记录</a></li>
            <li><a href="#ap"   data-toggle="tab">AP数据</a></li>
        </ul>

        <div class="row">
            <div class="col-md-12">
                <br>
                <div id="myTabContent" class="tab-content">
                    <#--第一版-->
                    <div class="tab-pane active in" id="home">
                        <div class="panel panel-default">
                            <div class="panel-heading no-collapse">IMU数据<span class="label label-warning">+10</span></div>
                            <table class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th class="center">Id</th>
                                    <th class="center">Position</th>
                                    <th class="center">IndexId</th>
                                    <th class="center">MagneticX</th>
                                    <th class="center">MagneticY</th>
                                    <th class="center">MagneticZ</th>
                                    <th class="center">AccelerationX</th>
                                    <th class="center">AccelerationY</th>
                                    <th class="center">AccelerationZ</th>
                                    <th class="center">GyroscopeX</th>
                                    <th class="center">GyroscopeY</th>
                                    <th class="center">GyroscopeZ</th>
                                    <th class="center">操作</th>
                                </tr>
                                </thead>
                                <tbody id="contenti">

                                </tbody>
                            </table>
                        </div>
                        <div id="pagei">
                            <!-- pagination所需容器 -->
                            <div class="i-pagination"></div>
                        </div>
                    </div>

                     <#--第二版-->
                    <div class="tab-pane fade" id="profile">
                        <div class="panel panel-default">
                            <div class="panel-heading no-collapse">WIFI数据<span class="label label-warning">+10</span></div>
                            <table class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th class="center">Id</th>
                                    <th class="center">AP1</th>
                                    <th class="center">AP2</th>
                                    <th class="center">AP3</th>
                                    <th class="center">AP4</th>
                                    <th class="center">AP5</th>
                                    <th class="center">AP6</th>
                                    <th class="center">AP7</th>
                                    <th class="center">AP8</th>
                                    <th class="center">AP9</th>
                                    <th class="center">AP10</th>
                                    <th class="center">Position</th>
                                    <th class="center">操作</th>
                                </tr>
                                </thead>
                                <tbody id="contentw">

                                </tbody>
                            </table>
                        </div>
                        <div id="pagew">
                            <!-- pagination所需容器 -->
                            <div class="w-pagination"></div>
                        </div>
                    </div>

                    <#--第三版-->
                        <div class="tab-pane fade" id="recoder">
                            <div class="panel panel-default">
                                <div class="panel-heading no-collapse">数据采集记录<span class="label label-warning">+10</span></div>
                                <table class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th class="center">Id</th>
                                        <th class="center">Position</th>
                                        <th class="center">手机型号</th>
                                        <th class="center">数据量</th>
                                        <th class="center">采集时间</th>
                                        <th class="center">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="contentr">

                                    </tbody>
                                </table>
                            </div>
                            <div id="pager">
                                <!-- pagination所需容器 -->
                                <div class="r-pagination"></div>
                            </div>
                        </div>

                    <#--第四版-->
                        <div class="tab-pane fade" id="ap">
                            <div class="panel panel-default">
                                <div class="panel-heading no-collapse">AP数据<span class="label label-warning">+10</span></div>
                                <table class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th class="center">Id</th>
                                        <th class="center">MAC地址</th>
                                        <th class="center">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="contenta">

                                    </tbody>
                                </table>
                            </div>
                            <div id="pagea">
                                <!-- pagination所需容器 -->
                                <div class="a-pagination"></div>
                            </div>
                        </div>

                </div>
            </div>
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
