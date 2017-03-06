<#import "spring.ftl" as spring/>
<!doctype html>
<html lang="en">
<head>
    <link rel="shortcut icon" type="image/x-icon" href="<@spring.url'/resource/images/favicon.ico'/>" media="screen" />
    <meta charset="utf-8">
    <title>Bootstrap Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="<@spring.url'/resource/theme/lib/bootstrap/css/bootstrap.css'/>">
    <link rel="stylesheet" href="<@spring.url'/resource/theme/lib/font-awesome/css/font-awesome.css'/>">
    <script src="<@spring.url'/resource/theme/jquery-2.1.4.min.js'/>"></script>

    <link rel="stylesheet" type="text/css" href="<@spring.url'/resource/theme/stylesheets/theme.css'/>">
    <link rel="stylesheet" type="text/css" href="<@spring.url'/resource/theme/stylesheets/premium.css'/>">
    <script type="text/javascript">
        $(document).ready(function () {
            var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
            $("#signup").click(function () {
                if ($("#username").val() == "" || $("#password").val() == "" ||$("#password2").val() =="") {
                alert("用户名或密码不能为空");
            } else  if($("#password").val()!=$("#password2").val()) {
                alert("两次输入密码不一致");
            } else if(!reg.test($("#email").val())) {
                alert("邮箱地址不正确");
            } else {
                $.ajax({
                    url: "signUpAdd",
                    type: "POST",
                    dataType: "text",
                    data: {"username": $("#username").val(), "password": $("#password").val(),"email": $("#email").val()},
                    success: function (data) {
                        var obj = jQuery.parseJSON(data);
                        if (obj.code == 200) {
                            alert("注册成功");
                            location.href = "admins/index";
                        } else {
                            $("#error").text("用户名已被占用");
                        }
                    },
                    error: function (data) {

                    }
                });
            }
        });

        })
        ;
    </script>
</head>
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


<div class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <a class="" href="index.html"><span class="navbar-brand"><span class="fa fa-paper-plane"></span> MIPS后台管理系统</span></a>
    </div>

    <div class="navbar-collapse collapse" style="height: 1px;">

    </div>
</div>
</div>


<div class="dialog">
    <div class="panel panel-default">
        <p class="panel-heading no-collapse" style="text-align: center">用户注册</p>
        <div class="panel-body">
            <form>

                <div class="form-group">
                    <label>用户名</label>
                    <input type="text" class="form-control span12" id="username">
                </div>
                <div class="form-group">
                    <label>密码</label>
                    <input type="password" class="form-control span12" id="password">
                </div>
                <div class="form-group">
                    <label>重复密码</label>
                    <input type="password" class="form-control span12" id="password2">
                </div>
                <div class="form-group">
                    <label>邮箱</label>
                    <input type="text" class="form-control span12" id="email">
                </div>
                <div class="form-group">
                    <a id="signup" class="btn btn-primary pull-right">注册</a>
                    <label class="remember-me"><input type="checkbox"> I agree with the
                        <a href="terms-and-conditions.html">MIPS协议</a></label>
                </div>
                <div class="clearfix"></div>
            </form>
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
