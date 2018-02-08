<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录</title>
		<!--
        	导入easyUI的样式文件
        -->
		<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="themes/icon.css">
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<!--
        	导入easyUI的js库
        	easyUI 依赖与jQuery，所以必须先导入jQuery的库
        -->
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	</head>

	<body bgcolor="#6DC0E4" style="margin: auto;">
		<div class="div1" style="width: 300px;height: 200px;background-color: aquamarine;padding: 20px;" >
			<h2 align="center">欢迎登录</h2>
			<form id="loginForm" action="" method="post" onsubmit="return false">
				<table align="center">
					<tr>
						<td>账号：</td>
						<td><input id="number" type="text" name="UNumber" /></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="UPassword" /></td>
						<tr/>
						<tr align="center">
							<td colspan="2" align="center">
								<input type="submit" value="登录" onclick="login()"/>&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="重置" />
							</td>
						</tr>
				</table>
			</form>
			<div class="register" style="text-align:right;">
				<a href="#" onclick="btnClick()">注册账号</a>
			</div>
		</div>
		<div id="win" class="easyui-window" title="用户注册信息" style="width:400px;height:500px;padding:20px">   
    		<form id="registerFrom" action="" method="get" onsubmit="return false" >
	    		姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox " name="UName "><br/><br/>
	    		账号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox " name="UNumber"><br/><br/>
	    		密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox " name="UPassword"><br/><br/>
	    		联系方式：<input class="easyui-textbox " name="UPhone "><br/><br/>
	    		邮箱：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox " name="UEmail "><br/><br/>
	    		<tr>
			        <td style="text-align:right;">性别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			        <td style="text-align:right">
			            <span class="radioSpan">
			                <input type="radio" name="USex" value="0" >女</input>
			                <input type="radio" name="USex" value="1" >男</input>
			            </span>
			        </td>
	    		</tr><br/><br/>
	    		部门：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="cc" name="dept" value="dept.getDName()">  
	    		
	    		
	    		 <!-- <select id="dept " class="easyui-combobox " name="UDept " style="width:100px; ">
						<option>研发部</option>
						<option>人事部</option>
						<option>保安部</option>
						<option>后勤部</option>
					</select> -->
				<hr/><br/><br />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" value="注册" onclick="login1()"/>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="重置" />
    		</form>
		</div> 
	</body>

	<script type="text/javascript">
		$(function(){
			$("#win").window("close");
		})
		
		function btnClick(){
			$("#win").window("open");
		}
	
		function login(){
			//异步提交
			$.ajax({
				type:"post",
				url:"loginAction",
				data:$("#loginForm").serialize(),
				dataType:"json",
				success:function(data){
					if(data.code == 0){
						alert(data.msg);
					}else{
						window.location.href = "show.jsp?UNumber=" + $('#number').val();
					}
				}
						
			});
		}
		
		$('#registerFrom').form({    
		    url:"registerAction",    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit;    
		    },    
		    success:function(data){    
		    	window.location.href="login.jsp";    
		    }    
		}); 
		
		$('#cc').combobox({    
		    url:'showAllDept',    
		    valueField:'DId',    
		    textField:'DName'   
		});
		
		/* function login1(){
			//异步提交
			$.ajax({
				type:"get",
				url:"register",
				data:$("#registerFrom").serialize(),
				dataType:"json",
				success:function(data){
					if(data.code == 0){
						alert(data.msg);
					}else{
						window.location.href="login.jsp";
					}
				}
			});
		} */
	</script>
</html>