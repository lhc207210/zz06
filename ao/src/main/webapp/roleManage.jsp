<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>角色管理</title>
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
    	<div id="select" class="easyui-panel" title="查询" style="padding:10px;background:#fafafa;" closable:true, collapsible:true,minimizable:true,maximizable:true ">
			<form id="select">
				角色名称：<input class="easyui-textbox " name="userName ">&nbsp;&nbsp;
				<a href="# " class="easyui-linkbutton " data-options="iconCls: 'icon-search' ">查询</a>
			</form>
		</div>
		<div id="data" class="easyui-panel " title="用户信息列表 " style="padding:10px;background:#fafafa; " closable:true, collapsible:true,minimizable:true,maximizable:true ">
			<a id="btn " href="#" class="easyui-linkbutton " data-options="iconCls: 'icon-add'" onclick="btnClick()">新增</a>
			<table id="tt">
			</table>
		</div>
		<div id="win" class="easyui-window" title="新增角色信息" style="width:400px;height:500px;padding:20px">   
    		角色名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox " name="userName "><br/><br/>
			<hr/><br/><br />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="btnAdd " href="roleManage.jsp" class="easyui-linkbutton " data-options="iconCls: 'icon-add'">新增</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="btnExit " href="roleManage.jsp" class="easyui-linkbutton " data-options="iconCls: 'icon-cancel'">取消</a>
		</div> 
	<script>
		$(function(){
				$("#win").window("close");
		})
			
		function btnClick(){
			$("#win").window("open");
		}
		function doReset(){
			$('#select').form('reset');                         
			$('input[name=userName]').val("");                 
			$('input[name=userSex]').val("");
			$('input[name=registerDate]').val("");
			$('input[name=registerName]').val("");
		}
		$(function(){
			$("#tt").datagrid({
				url:'role.json',
				method:'get', 
				fitColumns:true,
				singleSelect:true,
				columns:[[  
					{field:'code',title:'',width:'50px',align:'center'},    
					{field:'name',title:'角色名称',width:'500px',align:'center'},
					{field:'operate',title:'操作',align:'center',width:'440px',
						formatter:function(){
							return "<a href='#'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;" + 
								"<a href='#'>删除</a>";
						}
					}
				]], 
						
				//显示分页组件，不能设置total
				pagination:true,
				pageSize:5,
				pageList:[5,10,15]
						
			});
					
			//返回datagrid的分页对象
			var $page = $("#tt ").datagrid("getPager ");
						
			$page.pagination({
				showPageList:true
			});
		})
	</script>
    	
 	</body>
</html>