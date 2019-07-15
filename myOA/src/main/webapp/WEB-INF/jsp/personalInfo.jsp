<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/13
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("base", request.getContextPath());


%>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>头像处理</title>
<%--前端简单图像处理--%>
<link href="${base}/static/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${base}/static/bootstrap/bootstrap-datetimepicker.min.css" rel="stylesheet">
<link href="${base}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${base}/static/font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="${base}/static/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="${base}/static/css/plugins/select2/select2.min.css" rel="stylesheet">
<link href="${base}/static/css/plugins/cropper/cropper.min.css" rel="stylesheet">
<link href="${base}/static/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
<link href="${base}/static/css/animate.css" rel="stylesheet">
<link href="${base}/static/css/style.css" rel="stylesheet">

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                个人头像设置
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-8 column">
            <form id="form" class="form-horizontal" enctype="multipart/form-data">
                <div class="form-group"><label class="col-sm-2 control-label">设备图片</label>
                    <div class="col-sm-10">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="image-crop">
                                    <img id="image" src="">
                                </div>
                                <h4>图片预览</h4>
                                <div class="img-preview img-preview-sm" style="width:130px;"></div>
                                <div class="btn-group" style="margin-top: 20px;">
                                    <label title="Upload image file" for="inputImage" class="btn btn-primary">
                                        <input type="file" accept="image/*" id="inputImage" class="hide">
                                        上传图片
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="hr-line-dashed"></div>
                <div class="form-group">
                    <div class="col-sm-4 col-sm-offset-2">
                        <button class="btn btn-primary" type="submit">新增</button>
                        <button class="btn btn-white" type="button" onclick="history.back();">返回</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
        </div>
    </div>
</div>
<script src="${base}/static/jquery/jquery.min.js"></script>
<script src="${base}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${base}/static/bootstrap/moment-with-locales.js"></script>
<script src="${base}/static/bootstrap/bootstrap-datetimepicker.min.js"></script>


<script src="${base}/static/js/jquery-2.1.1.js"></script>
<script src="${base}/static/js/bootstrap.min.js"></script>
<script src="${base}/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${base}/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${base}/static/js/inspinia.js"></script>
<script src="${base}/static/js/plugins/pace/pace.min.js"></script>
<script src="${base}/static/js/plugins/select2/select2.full.min.js"></script>
<script src="${base}/static/js/plugins/cropper/cropper.min.js"></script>
<%--这里使用的版本和宋老师不一样--%>
<script src="${base}/static/js/plugins/cropper/canvas-toBlob.js" type="text/javascript"></script>
<script src="${base}/static/js/plugins/iCheck/icheck.min.js"></script>


<script>
    function convertBase64UrlToBlob(urlData) {
        /**
         * 去掉url的头，转换为byte
         * @type {string}
         */
        bytes = window.atob(urlData.split(",")[1]);

        /**
         * 处理异常，将ascii码小于0的转换为大于0
         * @type {ArrayBuffer}
         */
        var ab = new ArrayBuffer(bytes.length);
        var ia = new Uint8Array(ab);
        for (var i = 0; i < bytes.length; i++) {
            ia[i] = bytes.charCodeAt(i);
        }
        return new Blob([ab], {type: 'image/png'});
    }

    $(document).ready(function () {
        /**
         * 提交绑定事件
         */
        $('form').submit(function () {
            if (!$image.cropper("getDataURL")) {
                alert("请上传图片！");
                return false;
            }
            var blob = convertBase64UrlToBlob($image.cropper("getDataURL"));
            var formData = new FormData($('#form').get(0));
            formData.append("file", blob, fileName);

            $.ajax({
                type: "POST",
                url: '${base}/addDevice',
                data: formData,
                contentType: false,//necessary
                processData: false,//necessary
                dataType: "text",
                success: function (retJson) {
                    if (retJson == '文件上传成功') {
                        /**
                         * 上传成功
                         */
                        alert("文件上传成功");
                    } else {
                        alert(retJson.data);
                    }
                },
                error: function () {
                    alert("文件上传失败")
                }
            });
            return false;
        });

        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green'
        });

        $('.select2_demo_3').select2({
            placeholder: "Select a device type",
            allowClear: true
        });

        var $image = $(".image-crop > img");
        $($image).cropper({
            aspectRatio: 1,
            preview: ".img-preview",
            done: function (data) {
            }
        });

        var $inputImage = $("#inputImage");
        if (window.FileReader) {
            $inputImage.change(function () {
                var fileReader = new FileReader(),
                    files = this.files,
                    file;

                if (!files.length) {
                    return;
                }

                file = files[0];
                fileName = file.name;
                if (/^image\/\w+$/.test(file.type)) {
                    fileReader.readAsDataURL(file);
                    fileReader.onload = function () {
                        $inputImage.val("");
                        $image.cropper("reset", true).cropper("replace", this.result);
                    };
                } else {
                    showMessage("Please choose an image file.");
                }
            });
        } else {
            $inputImage.addClass("hide");
        }
    });
</script>

</body>
</html>
