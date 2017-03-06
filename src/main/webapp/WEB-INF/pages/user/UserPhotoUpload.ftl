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
<style type="text/css">
    body{
        background-color: #efeff4;
    }

    .preview{
        display: none;
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
    }

    .preview img{
        display: block;
        position: absolute;
        z-index: 2;
        top: 50%;
        left: 50%;
        max-width: 90%;
        -webkit-transform: translate3d(-50%,-50%,0);
        transform: translate3d(-50%,-50%,0);
    }

    .preview .delete{
        position: absolute;
        z-index: 2;
        width: 19px;
        height: 19px;
        bottom: 10px;
        right: 10px;
        font-size: 0;
        background: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACYAAAAmCAYAAACoPemuAAAAGXRFW…XUbDZTlyim6vR6vQk1+JbCBVjTXPISxVRVXrJcXKLw+gF7BIqryl7pzAAAAABJRU5ErkJggg==") no-repeat;
        background-size: 19px 19px;
    }
</style>
<script language="JavaScript">
    // codepen 没办法直接在 body 标签加属性，所以用这里用 js 给 body 添加 ontouchstart 属性来触发 :active
    document.body.setAttribute('ontouchstart', '');

    $(function () {
        // 允许上传的图片类型
        var allowTypes = ['image/jpg', 'image/jpeg', 'image/png', 'image/gif'];
        //10MB
        var maxSize = 10 * 1024 * 1024;
        // 图片最大宽度
        var maxWidth = 300;
        // 最大上传图片数量
        var maxCount = 6;
        var images = [];
        $('.js_file').on('change', function (event) {
            var files = event.target.files;

            // 如果没有选中文件，直接返回
            if (files.length === 0) {
                return;
            }

            for (var i = 0, len = files.length; i < len; i++) {
                var file = files[i];
                var reader = new FileReader();

                // 如果类型不在允许的类型范围内
                if (allowTypes.indexOf(file.type) === -1) {
                    $.weui.alert('该类型不允许上传');
                    continue;
                }

                if (file.size > maxSize) {
                    $.weui.alert('图片太大，不允许上传');
                    continue;
                }

                if ($('.weui_uploader_file').length >= maxCount) {
                    $.weui.alert('最多只能上传' + maxCount + '张图片');
                    return;
                }

                reader.onload = function (e) {
                    var img = new Image();
                    img.onload = function () {
                        // 不要超出最大宽度
                        var w = Math.min(maxWidth, img.width);
                        // 高度按比例计算
                        var h = img.height * (w / img.width);
                        var canvas = document.createElement('canvas');
                        var ctx = canvas.getContext('2d');
                        // 设置 canvas 的宽度和高度
                        canvas.width = w;
                        canvas.height = h;
                        ctx.drawImage(img, 0, 0, w, h);
                        var base64 = canvas.toDataURL('image/png');

                        // 插入到预览区
                        var $preview = $('<li class="weui_uploader_file weui_uploader_status" style="background-image:url(' + base64 + ')"><div class="weui_uploader_status_content">0%</div></li>');
                        $('.weui_uploader_files').append($preview);
                        var num = $('.weui_uploader_file').length;
                        $('.js_counter').text(num + '/' + maxCount);
                        images.push(base64);

                        // 然后假装在上传，可以post base64格式，也可以构造blob对象上传

                        var progress = 0;
                        function uploading() {
                            $preview.find('.weui_uploader_status_content').text(++progress + '%');
                            if (progress < 100) {
                                setTimeout(uploading, 30);
                            }
                            else {
                                // 如果是失败，塞一个失败图标
                                //$preview.find('.weui_uploader_status_content').html('<i class="weui_icon_warn"></i>');
                                $preview.removeClass('weui_uploader_status').find('.weui_uploader_status_content').remove();
                            }
                        }
                        setTimeout(uploading, 30);
                    };

                    img.src = e.target.result;
                };
                reader.readAsDataURL(file);
            }
        });
        $('.js_previews').on('click', '.weui_uploader_file', function(event){
            var index = $(this).index();
            var img = images[index];
            $('.preview').find('img').attr('src', img);
            $('.preview').show();
        });
    });
</script>
<body>
<div class="container">
    <div class="weui_cells_title">上传</div>
    <div class="weui_cells weui_cells_form">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <div class="weui_uploader">
                    <div class="weui_uploader_hd weui_cell">
                        <div class="weui_cell_bd weui_cell_primary">图片上传</div>
                        <#--<div class="weui_cell_ft js_counter">0/6</div>-->
                    </div>
                    <div class="weui_uploader_bd">
                        <ul class="weui_uploader_files js_previews">
                            <!-- 预览图插入到这 -->
                        </ul>
                        <div class="weui_uploader_input_wrp">
                            <input class="weui_uploader_input js_file" type="file" accept="image/jpg,image/jpeg,image/png,image/gif" multiple="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="weui_dialog_alert" style="display: none;">
    <div class="weui_mask"></div>
    <div class="weui_dialog">
        <div class="weui_dialog_hd"><strong class="weui_dialog_title">警告</strong></div>
        <div class="weui_dialog_bd">弹窗内容，告知当前页面信息等</div>
        <div class="weui_dialog_ft">
            <a href="javascript:;" class="weui_btn_dialog primary">确定</a>
        </div>
    </div>
</div>

<div class="preview">
    <div class="weui_mask"></div>
    <img src="" alt="" />
    <a href="javascript:;" class="delete" id="delete">delete</a>
</div>
</body>
</html>




