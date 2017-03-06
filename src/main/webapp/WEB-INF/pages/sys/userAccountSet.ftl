<#import "spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>WeUI</title>
    <!-- 引入 WeUI -->
    <script src="<@spring.url'/resource/theme/jquery-2.1.1.min.js'/>" type="text/javascript"></script>
    <link href="<@spring.url'/resource/css/weui.css'/>" rel="stylesheet" type="text/css" />
</head>
<style type="text/css">
    body{
        background-color: #efeff4;
    }
    .weui_label{
        width: 5em;
    }

    .container{
        padding: 15px;
    }

</style>
<script language="JavaScript">
    // :active
    $(function(){
        $('#btn').on('click', function(){
            $('#dialog').show();
        });

        $('#dialog').on('click', '.weui_btn_dialog', function(){
            $('#dialog').hide();
        });
    });
</script>
<body>

<div class="weui_cells_title">请妥善记住你的用户密码</div>
<div class="weui_cells weui_cells_form">
    <div class="weui_cell">
        <div class="weui_cell_hd">
            <div class="weui_label">账号</div>
        </div>
        <div class="weui_cell_hd">
            <div class="weui_label">wenbo2018</div>
        </div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_hd">
            <div class="weui_label">初始密码</div>
        </div>
        <div class="weui_cell_bd weui_cell_primary">
            <input type="password" class="weui_input" />
        </div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_hd">
            <div class="weui_label">确认密码</div>
        </div>
        <div class="weui_cell_bd weui_cell_primary">
            <input type="password" class="weui_input" />
        </div>
    </div>
</div>

<div class="container">
    <a href="javascript:;" id="btn" class="weui_btn weui_btn_primary">确定</a>
</div>

<#--修改成功弹框-->
<#--<div class="container">-->
    <#--<a href="javascript:;" id="btn" class="weui_btn weui_btn_primary">显示弹框</a>-->
<#--</div>-->
<div class="weui_dialog_alert" id="dialog" style="display: none;">
    <div class="weui_mask"></div>
    <div class="weui_dialog">
        <div class="weui_dialog_hd"><strong class="weui_dialog_title">提示</strong></div>
        <div class="weui_dialog_bd">密码修改成功</div>
        <div class="weui_dialog_ft">
            <a href="javascript:;" class="weui_btn_dialog primary">确定</a>
        </div>
    </div>
</div>
</body>
</html>




