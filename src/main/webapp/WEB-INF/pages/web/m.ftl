<#import "spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="http://7xkdgb.com2.z0.glb.qiniucdn.com/img/faceu_new.ico">
    <title>Faceu</title>
    <script type="text/javascript" src="http://dn-faceu.qbox.me/jquery.min.js"></script>
    <style>
        html {
            width: 100%;
            font-family: '微软雅黑', 'Helvetica';
            font-size: 15px;
            color: rgba(255, 255, 255, 0.8);
            background-color: #16cfa2;
        }
    </style>

    <#--<script type="text/javascript">-->
        <#--var download_url = "http://a.app.qq.com/o/simple.jsp?pkgname=com.lemon.faceu";-->
        <#--$(document).ready(function () {-->
            <#--$("#img_iphone").click(function () {-->
                <#--window.location.href = download_url;-->
            <#--});-->
            <#--$("#img_android").click(function () {-->
                <#--window.location.href = download_url;-->
            <#--});-->
        <#--});-->
    <#--</script>-->
</head>

<body>
<div>
    <div style="width:100%;height:30px;"></div>
    <div style="width:100%;text-align:center;">
        <img src="<@spring.url'/resource/images/main_icon.png'/>" style="width:320px;height:320px;"/>
    </div>
    <div style="width:100%;height:24px;"></div>
    <div style="width:100%;height:100px;">
    <div style="width: 50%;float:left;text-align: right;">
    <img src="http://7xkdgb.com2.z0.glb.qiniucdn.com/img/ic-2.png" style="width:340px;height:100px;margin-right:27px;" id="img_iphone"/>
    </div>
    <div style="width: 50%;float:right;text-align: left;">
    <img src="http://7xkdgb.com2.z0.glb.qiniucdn.com/img/ic-3.png" style="width:340px;height:100px;margin-left:27px;" id="img_android"/>
    </div>
        <div style="width: 100%;float:right;text-align: center;">
            <img src="<@spring.url'/resource/images/app.png'/>" style="width:200px;height:200px;margin-left:27px;margin-top:27px;" id="img_android"/>
        </div>

    </div>
    <div style="width:100%;height:68px;"></div>
    <div style="width:100%;text-align:center;">
        Email:wenboing.shen@gmail.com
    </div>
    <div style="width:100%;height:30px;"></div>
    <div style="width:100%;text-align:center;">
        © 2017 华南理工大学自动化科学与工程学院 粤ICP备13065114号</a>
    </div>
</div>
</body>

</html>
