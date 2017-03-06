<#import "spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>WeUI</title>
    <!-- 引入 WeUI -->
    <link href="<@spring.url'/resource/css/weui.css'/>" rel="stylesheet" type="text/css" />
</head>
<#--<style type="text/css">-->
    <#--body{-->
        <#--background-color: #efeff4;-->
    <#--}-->
    <#--.weui_label{-->
        <#--width: 5em;-->
    <#--}-->
    <#--.weui_select{-->
        <#--padding-left: 0;-->
    <#--}-->
<#--</style>-->
<script language="JavaScript">
    // :active
    document.body.setAttribute('ontouchstart', '');
</script>
<body>
<div class="weui_cells_title">常用工具</div>
<div class="weui_grids">
    <a href="javascript:;" class="weui_grid">
        <div class="weui_grid_icon">
            <img src="http://weui.github.io/weui/images/icon_nav_button.png" alt="">
        </div>
        <p class="weui_grid_label">
            高德地图
        </p>
    </a>
    <a href="javascript:;" class="weui_grid">
        <div class="weui_grid_icon">
            <img src="http://weui.github.io/weui/images/icon_nav_cell.png" alt="">
        </div>
        <p class="weui_grid_label">
            指南针
        </p>
    </a>
    <a href="javascript:;" class="weui_grid">
        <div class="weui_grid_icon">
            <img src="http://weui.github.io/weui/images/icon_nav_toast.png" alt="">
        </div>
        <p class="weui_grid_label">
            生活服务
        </p>
    </a>
    <a href="javascript:;" class="weui_grid">
        <div class="weui_grid_icon">
            <img src="http://weui.github.io/weui/images/icon_nav_dialog.png" alt="">
        </div>
        <p class="weui_grid_label">
            ofo单车
        </p>
    </a>
    <a href="javascript:;" class="weui_grid">
        <div class="weui_grid_icon">
            <img src="http://weui.github.io/weui/images/icon_nav_progress.png" alt="">
        </div>
        <p class="weui_grid_label">
            Progress
        </p>
    </a>
    <a href="javascript:;" class="weui_grid">
        <div class="weui_grid_icon">
            <img src="http://weui.github.io/weui/images/icon_nav_msg.png" alt="">
        </div>
        <p class="weui_grid_label">
            Msg
        </p>
    </a>

</div>
</body>
</html>




