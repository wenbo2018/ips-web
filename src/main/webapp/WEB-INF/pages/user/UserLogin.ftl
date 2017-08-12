<#import "spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>WeUI</title>
    <!-- 引入 WeUI -->
    <link href="<@spring.url'/resource/css/weui.css'/>" rel="stylesheet" type="text/css" />
    <script src="<@spring.url'/resource/theme/jquery-2.1.4.min.js'/>" type="text/javascript"></script>
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
    var clock = '';
    var nums = 60;
    var flg=true;
    // :active
    $(function(){
        $('#btn').on('click', function(){
            var phone=$("#phone").val();
            var code=$("#code").val();
            nativeMethod.toActivity(phone,code);
        });

        $('#dialog').on('click', '.weui_btn_dialog', function(){
            $('#dialog').hide();
        });
    });

    function js_method(){
        $.ajax({
            url: "/User/getCheckCode",
            type: "POST",
            dataType: "text",
            data: {"phone": $("#phone").val()},
            success: function (data) {
                var obj = jQuery.parseJSON(data);
                if (obj.code == 200) {
                    if (flg) {
                        flg=false;
                        $("#check").attr("disabled", true);
                        $("#check").text("重新发送("+nums+"s)");
                        clock = setInterval(doLoop, 1000); //一秒执行一次
                    }
                } else {

                }
            },
            error: function (data) {
                alert("系统错误");
            }
        });
    }
    function doLoop()
    {
        nums--;
        console.log(nums);
        if(nums > 0){
            $("#check").text("重新发送("+nums+"s)");
        }else{
            clearInterval(clock); //清除js定时器
            $("#check").attr("disabled", false);
            $("#check").text("获取验证码");
            flg=true;
            nums =60; //重置时间
        }
    }
</script>
<body>

<div class="weui_msg">
    <div class="weui_cell_hd">
        <img src="<@spring.url'/resource/images/main_icon.png'/>" alt="" style="width:180px;height:180px;" class="cover">
    </div>
    <div class="weui_text_area">
        <h2 class="weui_msg_title" style="font-family : 微软雅黑,宋体;
font-size : 1.5em;">用户登录</h2>
    </div>
</div>

<div class="weui_cells weui_cells_form">
    <div class="weui_cell">
        <div class="weui_cell_hd">
            <label class="weui_label" style="font-family : 微软雅黑,宋体;
font-size : 1em;">手机号码</label>
        </div>
        <div class="weui_cell_bd weui_cell_primary">
            <input class="weui_input" type="number" id="phone" pattern="[0-9]*" style="font-family : 微软雅黑,宋体;
font-size : 1em;" placeholder="请输入手机号码">
        </div>
        <a id="check" onclick="js_method()" class="weui_btn weui_btn_warn" style="font-family : 微软雅黑,宋体;
font-size : 1em;width:6.5em;padding: 0em;" >获取验证码</a>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_hd">
            <label class="weui_label" style="font-family : 微软雅黑,宋体;
font-size : 1em;">短信验证码</label>
        </div>
        <div class="weui_cell_bd weui_cell_primary">
            <input class="weui_input" type="number" id="code" pattern="[0-9]*" style="font-family : 微软雅黑,宋体;
font-size : 1em;" placeholder="请输入短信验证码">
        </div>

    </div>
</div>
<div class="weui_cells_tips">

</div>

<div class="weui_btn_area">
    <a class="weui_btn weui_btn_primary" id="btn"  href="javascript:" style="font-family : 微软雅黑,宋体;
font-size : 1em;">登录</a>
</div>
</div>
</body>
</html>




