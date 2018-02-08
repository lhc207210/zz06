<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企业OA</title>
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
		<div id="cc" class="easyui-layout" style="width:600px;height:400px;" fit="true">
			<div data-options="region:'north',split:true" style="height:70px;background-color: greenyellow;">
				<table>
					<tr>
						<td width="1200px"><font size="6px">企业OA系统管理1.0</font></td>
						<td>
							欢迎&nbsp;&nbsp;&nbsp;&nbsp;
							<div id="uname">
								刘备
							</div>	
							登录
						</td>
					</tr>
				</table>
			</div>

			<div data-options="region:'east',iconCls:'icon-reload',title:'资源管理',split:true" style="width:100px;background-color: greenyellow;">

			</div>

			<div data-options="region:'west',title:'导航菜单',split:true" style="width:150px;background-color: greenyellow;">
				<ul id="tt1"></ul>
			</div>

			<div id="tt" data-options="region:'center'" class="easyui-tabs" style="background:#eee;" fit="true">
				<div title="首页" style="text-align: center;background-color: #7DF3FE;">
					<h1>welcome</h1>
				</div>
			</div>

			<div data-options="region:'south',split:true" style="height:60px;text-align: center;background-color: green;">
				@snowwolf 版权所有
			</div>
		</div>
	</body>

	<script>
		$('#tt1').tree({
			url: 'test?UNumber=${param.UNumber}',
			method: "get",
			loadFilter: function(data){    
		        if (data.d){    
		            return [data.d];    
		        } else {    
		            return [data];    
		        }    
		    }
		});
		$('#tt1').tree({
			onClick: function(node){
				//alert(node.text);  // 在用户点击的时候提示
				uri =node.attributes.url;
				title = node.text;
				//alert(title);
				$(function () {
					//alert(uri);
					var tt = $('#tt');
					if (tt.tabs('exists', title)) {
						tt.tabs('select', title);
					} else {
						var content = '<iframe scrolling="auto" frameborder="0"  src="'+ uri +'" fit="true" style="width:100%;height:100%;"></iframe>';
						tt.tabs('add', {
							title : title,
							content : content,
							closable : true
						});
					}

					}
				);
			}
		});
	</script>

</html>