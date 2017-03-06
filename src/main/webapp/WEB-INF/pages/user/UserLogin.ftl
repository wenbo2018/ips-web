<#import "spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>WeUI</title>
    <!-- 引入 WeUI -->
    <link href="<@spring.url'/resource/css/weui.css'/>" rel="stylesheet" type="text/css" />
    <script src="<@spring.url'/resource/js/jquery.min.js'/>" type="text/javascript"></script>
</head>
<style type="text/css">
    body{
        background-color: #efeff4;
    }
    .weui_label{
        width: 5em;
    }
</style>
<script language="JavaScript">
    // :active
    $(function(){
        $('#btn').on('click', function(){
            nativeMethod.toActivity();
        });

        $('#dialog').on('click', '.weui_btn_dialog', function(){
            $('#dialog').hide();
        });
    });
</script>
<body>

<div class="weui_msg">
    <div class="weui_cell_hd">
        <img src="<@spring.url'/resource/images/main.png'/>" alt="" class="cover">
    </div>
    <div class="weui_text_area">
        <h2 class="weui_msg_title">用户登录</h2>
    </div>
</div>

<div class="weui_cells weui_cells_form">
    <div class="weui_cell">
        <div class="weui_cell_hd">
            <label class="weui_label">手机号码</label>
        </div>
        <div class="weui_cell_bd weui_cell_primary">
            <input class="weui_input" type="number" pattern="[0-9]*" placeholder="请输入手机号码">
        </div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_hd">
            <label class="weui_label">短信验证码</label>
        </div>
        <div class="weui_cell_bd weui_cell_primary">
            <input class="weui_input" type="number" pattern="[0-9]*" placeholder="请输入短信验证码">
        </div>
        <a href="javascript:;" class="weui_btn weui_btn_default">获取验证码</a>
    </div>
</div>
<div class="weui_cells_tips">

</div>

<div class="weui_btn_area">
    <a class="weui_btn weui_btn_primary" id="btn"  href="javascript:">登录</a>
</div>
</div>
</body>
</html>




