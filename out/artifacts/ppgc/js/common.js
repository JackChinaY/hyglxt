/**
 * 公共变量和函数
 */
// 获取主机地址之后的目录，如： /Demo2/login.html
var pathName = window.document.location.pathname;
//获取带"/"的项目名，如：/Demo2
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
$(function () {
    //过滤所有的ajax响应体，如果为-1表示用户登录超时或者无权限再继续访问，需要及时退出
    $(document).ajaxSuccess(function (event, xhr, settings, data) {
        if (data.code == '-1') {
            $.cookie("username", null, {expires: -1});//删除cookie信息
            top.location.href = projectName + '/login';
        }
    });
});