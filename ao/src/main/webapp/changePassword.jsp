<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>修改密码</title>
        <!--
        	导入easyUI的样式文件
        -->
		<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="themes/icon.css">

		<!--
        	导入easyUI的js库
        	easyUI 依赖与jQuery，所以必须先导入jQuery的库
        -->
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
    </head>
    <body>
    	<div id="d1" style="height: 300px; border:1px solid #C7DAF2;">
    		<div id="d2" style="width: 300px; height: 300px;text-align:center;margin:0 auto;padding-top: 20px;">    
    			旧密码：&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox " name="userName "><br><br>
    			新密码：&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox " name="userName "><br><br>
    			确认密码：<input class="easyui-textbox " name="userName "><br><br>
    			<a id="btn " href="#" class="easyui-linkbutton " data-options="iconCls: 'icon-add'">修改</a>
    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<a id="btn " href="#" class="easyui-linkbutton " data-options="iconCls: 'icon-cancel'">取消</a>
    		</div>
    	</div>
 	</body>
</html>