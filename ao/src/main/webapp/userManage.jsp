<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户管理</title>
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

	<body fit="true">
		<div id="select" class="easyui-panel" title="查询" style="padding:10px;background:#fafafa;" closable:true, collapsible:true,minimizable:true,maximizable:true ">
			<form id="select">
				用户名：<input class="easyui-textbox " name="userName ">&nbsp;&nbsp;
				用户性别： <select id="cc " class="easyui-combobox " name="userSex " style="width:200px; ">
							<option>男</option>
							<option>女</option>
						</select>&nbsp;&nbsp;
				<a href="# " class="easyui-linkbutton " data-options="iconCls: 'icon-search' ">搜索</a>
				<br /><br />
				注册日期：<input id="dd " name="registerDate " type="text " class="easyui-datebox "></input>&nbsp;&nbsp;
				注册人：<input class="easyui-textbox name="registerName">&nbsp;&nbsp;
				<a id="btn " href="userManage.jsp" class="easyui-linkbutton " data-options="iconCls: 'icon-remove' " onclick="doReset()">清空</a>
			</form>
		</div>
		<div id="data" class="easyui-panel " title="用户信息列表 " style="padding:10px;background:#fafafa; " closable:true, collapsible:true,minimizable:true,maximizable:true ">
			<a id="btn " href="#" class="easyui-linkbutton " data-options="iconCls: 'icon-add'" onclick="btnClick()">新增</a>
			<table id="tt">
			</table>
		</div>
		<div id="win" class="easyui-window" title="新增用户信息" style="width:400px;height:500px;padding:20px">   
    		姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox " name="userName "><br/><br/>
    		账号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox " name="userNumber "><br/><br/>
    		密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox " name="userPassword"><br/><br/>
    		联系方式：<input class="easyui-textbox " name="userPhone "><br/><br/>
    		邮箱：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox " name="userEmail "><br/><br/>
    		<tr>
		        <td style="text-align:right;">性别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		        <td style="text-align:right">
		            <span class="radioSpan">
		                <input type="radio" name="adminFlag" value="0" >女</input>
		                <input type="radio" name="adminFlag" value="1" >男</input>
		            </span>
		        </td>
    		</tr><br/><br/>
    		部门：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select id="dept " class="easyui-combobox " name="userDept " style="width:100px; ">
					<option>研发部</option>
					<option>人事部</option>
					<option>保安部</option>
					<option>后勤部</option>
				</select>
			<hr/><br/><br />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="btnAdd " href="userManage.jsp" class="easyui-linkbutton " data-options="iconCls: 'icon-add'">新增</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="btnExit " href="userManage.jsp" class="easyui-linkbutton " data-options="iconCls: 'icon-cancel'">取消</a>
		</div> 
	<script>
		$(function(){
				$("#win").window("close");
		})
			
		function btnClick(){
			$("#win").window("open");
		}
		$(function(){
			$("#tt").datagrid({
				url:'data.json',
				method:'get', 
				fitColumns:true,
				singleSelect:true,
				columns:[[  
					{field:'id',title:'',width:'40px',align:'center'},    
					{field:'name',title:'姓名',width:'120px',align:'center'},
					{field:'userNumber',title:'账号',width:'120px',align:'center'},
					{field:'sex',title:'性别',width:'120px',align:'center'},
					{field:'phone',title:'联系方式',width:'120px',align:'center'},
					{field:'department',title:'部门',width:'120px',align:'center'},
					{field:'operate',title:'操作',align:'center',width:'310px',
						formatter:function(){
							return "<a href='#'>角色</a>&nbsp;&nbsp;&nbsp;&nbsp;" + 
								"<a href='#'>查看</a>&nbsp;&nbsp;&nbsp;&nbsp;" + 
								"<a href='#'>编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;" + 
								"<a href='#'>管理</a>";
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