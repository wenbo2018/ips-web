
    function page() {
        /* 先销毁pagination容器 */
        $("#page").html("");
        /* 重新生成容器 */
        $("#page").html("<div class='m-pagination'></div>");
        $(".m-pagination").eq(0).page({
            firstBtnText : '首页',
            lastBtnText : '尾页',
            prevBtnText : '上一页',
            nextBtnText : '下一页',
            showInfo : true,
            showJump : true,
            jumpBtnText : '跳转',
            showPageSizes : true,
            infoFormat : '{start} ~ {end}条，共{total}条',
            remote : {
                url : '/admins/users/userPagses', // 请求地址
                params : {
                    // 'param' : param
                    // 自定义请求参数
                },
                beforeSend : function(XMLHttpRequest) {
                    $("#content").html("");
                },
                success : function(data, pageIndex) {
                    //data为响应返回的json数据
                    //...do somethings
                    var c="";
                    for (var i = 0; i < data.list.length; i++) {
                        c+="<tr><td>"+data.list[i].id+"</td><td>"+data.list[i].username+"</td><td>***</td><td>"+data.list[i].email+"</td>";

                        if(data.list[i].au==0) {
                            c+="<td>普通用户</td>";
                        }else {
                            c+="<td>管理员</td>";
                        }
                        if (data.list[i].status==0) {
                            c+="<td>停用</td>";
                        } else {
                            c+="<td>使用中</td>";
                        }

                        c+="<td ><a  id='users-delete-user'  name='"+data.list[i].id+"'  data-toggle='modal' class='btn btn-danger'>删除</a></td></tr>";
                    }
                    $("#content").html(c);
                },
                complete : function(XMLHttpRequest, textStatu) {
                    //...
                },
                pageIndexName : 'pageIndex', //请求参数，当前页数，索引从0开始
                pageSizeName : 'pageSize', //请求参数，每页数量
                totalName : 'total' //指定返回数据的总数据量的字段名
            }
        });
    }







    function imuPage() {
        /* 先销毁pagination容器 */
        $("#pagei").html("");
        /* 重新生成容器 */
        $("#pagei").html("<div class='i-pagination'></div>");
        $(".i-pagination").eq(0).page({
            firstBtnText : '首页',
            lastBtnText : '尾页',
            prevBtnText : '上一页',
            nextBtnText : '下一页',
            showInfo : true,
            showJump : true,
            jumpBtnText : '跳转',
            showPageSizes : true,
            infoFormat : '{start} ~ {end}条，共{total}条',
            remote : {
                url : '/admins/datas/imuPagses', // 请求地址
                params : {
                    // 'param' : param
                    // 自定义请求参数
                },
                beforeSend : function(XMLHttpRequest) {
                    $("#contenti").html("");
                },
                success : function(data, pageIndex) {
                    //data为响应返回的json数据
                    //...do somethings
                    var c="";
                    for (var i = 0; i < data.list.length; i++) {
                        c+="<tr><td>"+data.list[i].id+"</td>";
                        c+="<td>"+data.list[i].position+"</td><td>"+data.list[i].indexId+"</td>";
                        c+="<td>"+data.list[i].magneticX.toFixed(3)+"</td>"
                        c+="<td>"+data.list[i].magneticY.toFixed(3)+"</td>"
                        c+="<td>"+data.list[i].magneticZ.toFixed(3)+"</td>"
                        c+="<td>"+data.list[i].accelerationX.toFixed(3)+"</td>"
                        c+="<td>"+data.list[i].accelerationY.toFixed(3)+"</td>"
                        c+="<td>"+data.list[i].accelerationZ.toFixed(3)+"</td>"
                        c+="<td>"+data.list[i].gyroscopeX.toFixed(3)+"</td>"
                        c+="<td>"+data.list[i].gyroscopeY.toFixed(3)+"</td>"
                        c+="<td>"+data.list[i].gyroscopeZ.toFixed(3)+"</td>"
                        c+="<td ><a id='datas-delete-imu'  name='"+data.list[i].id+"'   data-toggle='modal' class='btn btn-danger'>删除</a></td></tr>";
                    }
                    $("#contenti").html(c);
                },
                complete : function(XMLHttpRequest, textStatu) {
                    //...
                },
                pageIndexName : 'pageIndex', //请求参数，当前页数，索引从0开始
                pageSizeName : 'pageSize', //请求参数，每页数量
                totalName : 'total' //指定返回数据的总数据量的字段名
            }
        });
    }



    function wifiPage() {
        /* 先销毁pagination容器 */
        $("#pagew").html("");
        /* 重新生成容器 */
        $("#pagew").html("<div class='w-pagination'></div>");
        $(".w-pagination").eq(0).page({
            firstBtnText : '首页',
            lastBtnText : '尾页',
            prevBtnText : '上一页',
            nextBtnText : '下一页',
            showInfo : true,
            showJump : true,
            jumpBtnText : '跳转',
            showPageSizes : true,
            infoFormat : '{start} ~ {end}条，共{total}条',
            remote : {
                url : '/admins/datas/wifiPagses', // 请求地址
                params : {
                    // 'param' : param
                    // 自定义请求参数
                },
                beforeSend : function(XMLHttpRequest) {
                    $("#contentw").html("");
                },
                success : function(data, pageIndex) {
                    //data为响应返回的json数据
                    //...do somethings
                    var c="";
                    for (var i = 0; i < data.list.length; i++) {

                        c+="<tr><td>"+data.list[i].id+"</td>";
                        c+="<td>"+data.list[i].ap1+"</td>";
                        c+="<td>"+data.list[i].ap2+"</td>";
                        c+="<td>"+data.list[i].ap3+"</td>";
                        c+="<td>"+data.list[i].ap4+"</td>";
                        c+="<td>"+data.list[i].ap5+"</td>";
                        c+="<td>"+data.list[i].ap6+"</td>";
                        c+="<td>"+data.list[i].ap7+"</td>";
                        c+="<td>"+data.list[i].ap8+"</td>";
                        c+="<td>"+data.list[i].ap9+"</td>";
                        c+="<td>"+data.list[i].ap10+"</td>";
                        c+="<td>"+data.list[i].cin+"</td>";
                        c+="<td ><a id='datas-delete-wifi'  name='"+data.list[i].id+"'   data-toggle='modal' class='btn btn-danger'>删除</a></td></tr>";
                    }
                    $("#contentw").html(c);
                },
                complete : function(XMLHttpRequest, textStatu) {
                    //...
                },
                pageIndexName : 'pageIndex', //请求参数，当前页数，索引从0开始
                pageSizeName : 'pageSize', //请求参数，每页数量
                totalName : 'total' //指定返回数据的总数据量的字段名
            }
        });
    }




    function apPage() {
        /* 先销毁pagination容器 */
        $("#pagea").html("");
        /* 重新生成容器 */
        $("#pagea").html("<div class='a-pagination'></div>");
        $(".a-pagination").eq(0).page({
            firstBtnText : '首页',
            lastBtnText : '尾页',
            prevBtnText : '上一页',
            nextBtnText : '下一页',
            showInfo : true,
            showJump : true,
            jumpBtnText : '跳转',
            showPageSizes : true,
            infoFormat : '{start} ~ {end}条，共{total}条',
            remote : {
                url : '/admins/datas/apPagses', // 请求地址
                params : {
                    // 'param' : param
                    // 自定义请求参数
                },
                beforeSend : function(XMLHttpRequest) {
                    $("#contenta").html("");
                },
                success : function(data, pageIndex) {
                    //data为响应返回的json数据
                    //...do somethings
                    var c="";
                    for (var i = 0; i < data.list.length; i++) {

                        c+="<tr><td>"+data.list[i].id+"</td>";
                        c+="<td>"+data.list[i].macName+"</td>";
                        c+="<td ><a id='datas-delete-ap'  name='"+data.list[i].id+"'   data-toggle='modal' class='btn btn-danger'>删除</a></td></tr>";
                    }
                    $("#contenta").html(c);
                },
                complete : function(XMLHttpRequest, textStatu) {
                    //...
                },
                pageIndexName : 'pageIndex', //请求参数，当前页数，索引从0开始
                pageSizeName : 'pageSize', //请求参数，每页数量
                totalName : 'total' //指定返回数据的总数据量的字段名
            }
        });
    }


    function dataRPage() {
        /* 先销毁pagination容器 */
        $("#pager").html("");
        /* 重新生成容器 */
        $("#pager").html("<div class='r-pagination'></div>");
        $(".r-pagination").eq(0).page({
            firstBtnText : '首页',
            lastBtnText : '尾页',
            prevBtnText : '上一页',
            nextBtnText : '下一页',
            showInfo : true,
            showJump : true,
            jumpBtnText : '跳转',
            showPageSizes : true,
            infoFormat : '{start} ~ {end}条，共{total}条',
            remote : {
                url : '/admins/datas/dataRecoderPagses', // 请求地址
                params : {
                    // 'param' : param
                    // 自定义请求参数
                },
                beforeSend : function(XMLHttpRequest) {
                    $("#contentr").html("");
                },
                success : function(data, pageIndex) {
                    //data为响应返回的json数据
                    //...do somethings
                    var c="";
                    for (var i = 0; i < data.list.length; i++) {

                        c+="<tr><td>"+data.list[i].id+"</td>";
                        c+="<td>"+data.list[i].position+"</td>";
                        c+="<td>"+data.list[i].mobilePhone+"</td>";
                        c+="<td>"+data.list[i].dataSizes+"</td>";
                        c+="<td>"+data.list[i].datetime+"</td>";
                        c+="<td ><a id='datas-delete-recoder'  name='"+data.list[i].id+"'   data-toggle='modal' class='btn btn-danger'>删除</a></td></tr>";
                    }
                    $("#contentr").html(c);
                },
                complete : function(XMLHttpRequest, textStatu) {
                    //...
                },
                pageIndexName : 'pageIndex', //请求参数，当前页数，索引从0开始
                pageSizeName : 'pageSize', //请求参数，每页数量
                totalName : 'total' //指定返回数据的总数据量的字段名
            }
        });
    }


    function mapPage() {
        /* 先销毁pagination容器 */
        $("#pagermap").html("");
        /* 重新生成容器 */
        $("#pagermap").html("<div class='map-pagination'></div>");
        $(".map-pagination").eq(0).page({
            firstBtnText : '首页',
            lastBtnText : '尾页',
            prevBtnText : '上一页',
            nextBtnText : '下一页',
            showInfo : true,
            showJump : true,
            jumpBtnText : '跳转',
            showPageSizes : true,
            infoFormat : '{start} ~ {end}条，共{total}条',
            remote : {
                url : '/admins/datas/mapPagses', // 请求地址
                params : {
                    // 'param' : param
                    // 自定义请求参数
                },
                beforeSend : function(XMLHttpRequest) {
                    $("#contentmap").html("");
                },
                success : function(data, pageIndex) {
                    //data为响应返回的json数据
                    //...do somethings
                    var c="";
                    for (var i = 0; i < data.list.length; i++) {
                        c+="<tr><td>"+data.list[i].id+"</td>";
                        c+="<td>"+data.list[i].mapName+"</td>";
                        c+="<td><ul id="+data.list[i].id+"><li><img id='imges'  name="+data.list[i].id+" data-original='"+"../../resource/images"+data.list[i].mapUrl+"'   style='height: 40px;width: 40px' src='"+"../../resource/images"+data.list[i].mapUrl+"' class='img-polaroid'></li></ul></td>";
                        c+="<td>"+data.list[i].mapDesc+"</td>";
                        c+="<td>"+data.list[i].datetime+"</td>";
                        c+="<td ><a id='maps-delete-map'  name='"+data.list[i].id+"'   data-toggle='modal' class='btn btn-danger'>删除</a></td></tr>";
                    }
                    $("#contentmap").html(c);
                },
                complete : function(XMLHttpRequest, textStatu) {
                    //...
                },
                pageIndexName : 'pageIndex', //请求参数，当前页数，索引从0开始
                pageSizeName : 'pageSize', //请求参数，每页数量
                totalName : 'total' //指定返回数据的总数据量的字段名
            }
        });
    }


    function apiPage() {
        /* 先销毁pagination容器 */
        $("#pageapi").html("");
        /* 重新生成容器 */
        $("#pageapi").html("<div class='api-pagination'></div>");
        $(".api-pagination").eq(0).page({
            firstBtnText : '首页',
            lastBtnText : '尾页',
            prevBtnText : '上一页',
            nextBtnText : '下一页',
            showInfo : true,
            showJump : true,
            jumpBtnText : '跳转',
            showPageSizes : true,
            infoFormat : '{start} ~ {end}条，共{total}条',
            remote : {
                url : '/admins/apis/apiRequestPagses', // 请求地址
                params : {
                    // 'param' : param
                    // 自定义请求参数
                },
                beforeSend : function(XMLHttpRequest) {
                    $("#contentapi").html("");
                },
                success : function(data, pageIndex) {
                    //data为响应返回的json数据
                    //...do somethings
                    var c="";
                    for (var i = 0; i < data.list.length; i++) {

                        c+="<tr><td>"+data.list[i].id+"</td>";
                        c+="<td>"+data.list[i].apiUrl+"</td>";
                        c+="<td>"+data.list[i].clientIp+"</td>";
                        c+="<td>"+data.list[i].requestTime+"</td>";
                        if (data.list[i].status==1) {
                            c+="<td>请求成功</td>";
                        }else {
                            c+="<td>请求失败</td>";
                        }
                        c+="<td ><a id='apiss-delete-apidata'  name='"+data.list[i].id+"'   data-toggle='modal' class='btn btn-danger'>删除</a></td></tr>";
                    }
                    $("#contentapi").html(c);
                },
                complete : function(XMLHttpRequest, textStatu) {
                    //...
                },
                pageIndexName : 'pageIndex', //请求参数，当前页数，索引从0开始
                pageSizeName : 'pageSize', //请求参数，每页数量
                totalName : 'total' //指定返回数据的总数据量的字段名
            }
        });
    }





