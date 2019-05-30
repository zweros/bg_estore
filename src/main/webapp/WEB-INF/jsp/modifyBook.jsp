<%--
  Created by IntelliJ IDEA.
  User: wzer
  Date: 2019/5/29
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<span style="font-size:30px;font-weight: 300;color:red">${flag}</span>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>更新图书信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="book/updateBook" enctype="multipart/form-data">
            <div class="form-group">
                <div class="label">
                    <label>图书ID：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${book.bookId}" name="bookId" readonly/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>图书标题：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${book.name}" name="name" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>图书价格：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${book.price}" name="price" data-validate="required:请输入价格"/>
                    <div class="tips"></div>
                </div>
            </div>
            <%--
            <div class="form-group">
                <div class="label">
                    <label>图片：</label>
                </div>
                <div class="field">
                    <input type="file" id="url1" name="img" class="input tips" style="width:25%; float:left;" value=""
                           data-toggle="hover" data-place="right" data-image=""/>
                    &lt;%&ndash;
                    <input type="button" class="button bg-blue margin-left" id="image1" value="+ 浏览上传"
                           style="float:left;">
                    <div class="tipss">图片尺寸：500*500</div>
                    &ndash;%&gt;
                </div>
            </div>
            --%>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
