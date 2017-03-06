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

    .cover{
        display: block;
        width: 120px;
        height: 80px;
        margin-right: 15px;
    }
    .title{
        font-weight: 400;
        margin-right: 15px;
        font-size: 16px;
    }
    .summary{
        font-size: 14px;
        margin-right: 15px;
        color: #888888;
        display: -webkit-box;
        max-width: 100%;
        -webkit-line-clamp: 1;
        -webkit-box-orient: vertical;
        overflow: hidden;
        text-overflow: ellipsis;
    }
</style>
<script language="JavaScript">

</script>
<body>
<div class="container">
    <div class="weui_cells_title">地图列表</div>
    <div class="weui_cells weui_cells_access">
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <img src="<@spring.url'/resource/images/map/m1.jpg'/>" alt="" class="cover">
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <h3 class="title">XX科研大楼室内地图</h3>
                <p class="summary">华南理工大学3号楼</p>
            </div>
            <div class="weui_cell_ft">
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <img src="<@spring.url'/resource/images/map/m2.jpg'/>" alt="" class="cover">
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <h3 class="title">学生宿舍室内地图</h3>
                <p class="summary">西六学生宿舍</p>
            </div>
            <div class="weui_cell_ft">
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <img src="<@spring.url'/resource/images/map/m3.jpg'/>" alt="" class="cover">
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <h3 class="title">测试地图</h3>
                <p class="summary">测试地图</p>
            </div>
            <div class="weui_cell_ft">
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <img src="<@spring.url'/resource/images/map/m4.jpg'/>" alt="" class="cover">
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <h3 class="title">测试地图</h3>
                <p class="summary">测试地图</p>
            </div>
            <div class="weui_cell_ft">
            </div>
        </div>
    </div>
</div>

</body>
</html>




