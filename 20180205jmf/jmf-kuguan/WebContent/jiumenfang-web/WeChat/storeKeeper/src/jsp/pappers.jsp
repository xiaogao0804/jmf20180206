<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="<%=path %>/jiumenfang-web/publicJs/flexible.js"></script>
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/reset.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/css/salesReturn.css">
    <meta http-equiv="refresh" content="600">
    <title>单证</title>
</head>
<body>
    <div class="pappers-contain">
        <div class="receiving-header">
            <i class="fa fa-angle-left fa-3x"></i>
            <span>单证</span>
        </div>
         <form action="fileUpload.do" method="post" enctype="multipart/form-data">
        <div class="pappers-info">
                <span class="s-name">标题</span>
                <input type="text" id="s" name="title">
        </div>
        <div class="pappers-txt" style="width: 90%; margin:0.5rem auto;">
                <p style="margin-bottom: 0.1rem">
                    <span style="font-size:0.53rem;color:#495165;" >概况描述</span>
                </p>
                <p	style="width:100%">
                    <textarea name="area"  rows="8" style="border:1px	solid #95989a;border-radius:10px;width:100%;" id="d"></textarea>
                </p>
        </div>
        <div class="pappers-camera">
            <div class="pappers-photograph">
                <img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/image/xiangji.png" alt="">
            </div>
            <ul class="pappers-picture">
         
                <li>
                    <input id="fileBtn" type="file" name="file" onchange="upload('#fileBtn', '#img');"/>
                    <img src="" id="img" style="width:100%;height:100%;"/>
                    <span>+</span>
                </li>
                <li>
                    <input id="fileBtn2" type="file" name="file1" onchange="upload('#fileBtn2', '#img2');"/>
                    <img src="" id="img2" style="width:100%;height:100%;"/>
                    <span>+</span>
                </li>
                <li>
                    <input id="fileBtn3" type="file" name="file2" onchange="upload('#fileBtn3', '#img3');"/>
                    <img src="" id="img3" style="width:100%;height:100%;"/>
                    <span>+</span>
                </li>
                <li>
                    <input id="fileBtn4" type="file" name="file3" onchange="upload('#fileBtn4', '#img4');"/>
                    <img src="" id="img4" style="width:100%;height:100%;"/>
                    <span>+</span>
                </li>
                <li>
                    <input id="fileBtn5" type="file" name="file4" onchange="upload('#fileBtn5', '#img5');"/>
                    <img src="" id="img5" style="width:100%;height:100%;"/>
                    <span>+</span>
                </li>
                <li>
                    <input id="fileBtn6" type="file" name="file5" onchange="upload('#fileBtn6', '#img6');"/>
                    <img src="" id="img6" style="width:100%;height:100%;"/>
                    <span>+</span>
                </li>
            </ul>
            <div class="clear"></div>
            
        </div>
            <div  class="pappers-btn">
                <input type="submit" value="提交">
            </div>
            </form>
    </div>
</body>
<script src="<%=path %>/jiumenfang-web/publicJs/jquery-3.2.1.min.js"></script>
<script src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/js/salesReturn.js"></script>
</html>