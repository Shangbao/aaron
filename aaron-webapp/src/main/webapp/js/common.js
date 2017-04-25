var basePath = (function() {
    var url = window.location + "";
    var h = url.split("//");
    var x = h[1].split("/");
    return h[0] + "//" + window.location.host + "/" + x[1] ;
})();

//  页面重定向
function redirect(url) {
    window.location.href = basePath + '/Admin' + url;
}

function doError(data){
    if(data.status==404){
        toast.error("未找到请求地址");
        return
    }
    if(data.statusText.indexOf("Failure")!=-1){
        toast.error("操作超时，请检查网络连接");
        return
    }
    if(data.statusText=="timeout"){
        toast.error("操作超时，请检查网络连接");
    }else{
        toast.error(data.responseText);
    }
}

function format(date, fmt) {
    var o = {
        "M+": date.getMonth() + 1,                 //月份
        "d+": date.getDate(),                    //日
        "h+": date.getHours(),                   //小时
        "m+": date.getMinutes(),                 //分
        "s+": date.getSeconds()                 //秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function initMenuTree(){
    $(".child_menu li").remove("current-page");
    var url = window.location.search;
    var menuId = url.substring(url.lastIndexOf('=')+1, url.length);
    $("#"+menuId).addClass("current-page");
    var father=$("#"+menuId).parent("ul");
    father.css('display','block');
    var grandFather=$("#"+menuId).parent("ul").parent("li");
    grandFather.addClass("active");
}

function initMenuStatus(){
    $(".child_menu li").remove("current-page");
}
