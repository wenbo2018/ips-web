<#import "spring.ftl" as spring/>
<!doctype html>
<html lang="en">
<head>
    <link rel="shortcut icon" type="image/x-icon" href="<@spring.url'/resource/images/favicon.ico'/>" media="screen" />
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible'>
    <link rel="stylesheet" type="text/css" href="<@spring.url'/resource/theme/lib/bootstrap/css/bootstrap.css'/>">
    <link rel="stylesheet" href="<@spring.url'/resource/theme/lib/font-awesome/css/font-awesome.css'/>">
    <script src="<@spring.url'/resource/theme/lib/jquery-1.11.1.min.js" type="text/javascript'/>"></script>
    <script src="<@spring.url'/resource/theme/lib/jQuery-Knob/js/jquery.knob.js" type="text/javascript'/>"></script>
    <script src="<@spring.url'/resource/js/ichart.1.2.min.js" type="text/javascript'/>"></script>

    <script type="text/javascript">
        $(function () {
            $(".knob").knob();
        });

        $(function(){
            var labels=[];
            var flow=[];
            $.ajax({
                url: "/admins/apis/apICountData",
                type: "GET",
                dataType: "json",
                success: function (data) {
                    for(var i=0;i<data.length;i++) {
                        labels.push(data[i].date.substr(0,10));
                        flow.push(data[i].count/100);
                    }
                    var data = [
                        {
                            name : 'PV',
                            value:flow,
                            color:'#0d8ecf',
                            line_width:2
                        }
                    ];

//            var labels = ["2012-12-01","2012-12-02","2012-12-03","2012-12-04","2012-12-05","2012-12-06"];

                    var line = new iChart.LineBasic2D({
                        render : 'canvasDiv',
                        data: data,
                        align:'center',
                        title : 'MIPS系统最近7天流量趋势',
                        subtitle : '平均18:00-22:00访问量达到最大值(单位：100次)',
                        width : 764,
                        height : 500,
                        sub_option:{
                            smooth : true,//平滑曲线
                            point_size:10
                        },
                        tip:{
                            enable:true,
                            shadow:true
                        },
                        legend : {
                            enable : false
                        },
                        crosshair:{
                            enable:true,
                            line_color:'#62bce9'
                        },
                        coordinate:{
                            width:600,
                            valid_width:500,
                            height:360,
                            axis:{
                                color:'#9f9f9f',
                                width:[0,0,2,2]
                            },
                            grids:{
                                vertical:{
                                    way:'share_alike',
                                    value:12
                                }
                            },
                            scale:[{
                                position:'left',
                                start_scale:0,
                                end_scale:100,
                                scale_space:20,
                                scale_size:2,
                                scale_color:'#9f9f9f'
                            },{
                                position:'bottom',
                                labels:labels
                            }]
                        }
                    });
                    //开始画图
                    line.draw();
                },
                error: function (data) {
                    alert("系统错误,请稍后再试");
                }
            });
        });


        $(function(){
            var api = [];
            var apiRatio=[];
            $.ajax({
                url: "/admins/apis/apITop",
                type: "GET",
                dataType: "json",
                success: function (data) {
                    for(var i=0;i<data.length;i++) {
                        api.push("~"+data[i].apiUrl.substr(data[i].apiUrl.length-20));
                        apiRatio.push(data[i].apiCount*100);
                    }
                    var datas = [
                        {name : api[0] ,value: apiRatio[0],color:'#a5c2d5'},
                        {name : api[1] ,value: apiRatio[1],color:'#a5c2d5'},
                        {name : api[2],value : apiRatio[2],color:'#76a871'},
                        {name : api[3] ,value: apiRatio[3],color:'#9f7961'},
                        {name : api[4],value : apiRatio[4],color:'#a56f8f'},
                        {name : api[5] ,value: apiRatio[5],color:'#6f83a5'},
                        {name : api[6] ,value: apiRatio[6],color:'#a5c2d5'},
                        {name : api[7] ,value: apiRatio[7],color:'#a5c2d5'},
                        {name : api[8],value : apiRatio[8],color:'#76a871'},
                        {name : api[9] ,value: apiRatio[9],color:'#9f7961'},
                    ];
                    new iChart.Bar2D({
                        render : 'canvasDivAPI',
                        data: datas,
                        title : '请求次数前10位API',
                        showpercent:true,
                        align:'right',
                        decimalsnum:2,
                        width : 764,
                        height : 500,
                        coordinate:{
                            width:600,
                            valid_width:500,
                            height:360,
                            scale:[{
                                position:'bottom',
                                start_scale:0,
                                end_scale:40,
                                scale_space:8,
                                listeners:{
                                    parseText:function(t,x,y){
                                        return {text:t+"%"}
                                    }
                                }
                            }]
                        }
                    }).draw();
                },
                error: function (data) {
                    alert("系统错误,请稍后再试");
                }
            });
        });

    </script>


    <link rel="stylesheet" type="text/css" href="<@spring.url'/resource/theme/stylesheets/theme.css'/>">
    <link rel="stylesheet" type="text/css" href="<@spring.url'/resource/theme/stylesheets/premium.css'/>">

</head>
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
<body class=" theme-blue">

<!-- Demo page code -->



<#include "web/menu.ftl"/>

<div class="content">
    <div class="main-content">
        <div class="col-sm-6 col-md-6">
            <div class="panel panel-default">
                <a href="#page-stats" style="text-align: center" class="panel-heading" data-toggle="collapse">系统流量统计</a>
                <div id="page-stats" class="panel-collapse panel-body collapse in">
                    <div id='canvasDiv' style="align-content: center"></div>
                </div>
            </div>
        </div>
        <div class="col-sm-6 col-md-6">
            <div class="panel panel-default">
                <a href="#page-stats" style="text-align: center" class="panel-heading" data-toggle="collapse">系统流量统计</a>
                <div id="page-stats" class="panel-collapse panel-body collapse in">
                    <div id='canvasDivAPI' style="align-content: center"></div>
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