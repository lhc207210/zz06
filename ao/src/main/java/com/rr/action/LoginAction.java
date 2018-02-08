package com.rr.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.rr.anno.User;
import com.rr.service.IUserService;
import com.rr.vo.JsonBean;
import com.rr.vo.TreeNode;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven<User>{

	@Resource(name="userService")
	private IUserService userService;
	private User user;
	
	@Override
	public User getModel() {
		if(user == null){
			user = new User();
		}
		return user;
	}

	//显示操作资源
	public void showResource() throws IOException{
		
		HttpServletResponse response = ServletActionContext.getResponse();
		String unumber = user.getUnumber();
		
		User userInfo = userService.findUserByNumber(unumber);
		response.setCharacterEncoding("utf-8");
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		
		//用数组的方式写出要过滤的东西
		//可能有问题
		config.setExcludes(new String[]{"userroles","role","user","resourceroles","resource"});
																	
		TreeNode node = userService.findResourceByName(userInfo.getUname());
		
		JSONObject jsonObj = JSONObject.fromObject(node, config);
	
		System.out.println(jsonObj.toString());
		response.getWriter().write(jsonObj.toString());
		
	}
	
	//登录
	public void loginAction() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		
		String unumber = user.getUnumber();
		String password = user.getPassword();
		
		JsonBean bean = new JsonBean();
		
		userService.login(unumber, password);
		
		try {
			//将用户登录信息发放入session
			HttpSession session = request.getSession(false);
			if(session == null){
				session = request.getSession();
			}
			session.setAttribute("unumber", unumber);
			bean.setCode(1);
		} catch (Exception e) {
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		response.getWriter().write(JSONObject.fromObject(bean).toString());
	}
		
		//注册
		public void registerAction() throws IOException {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");

			JsonBean bean = new JsonBean();
			try {
				userService.RegisterUser(user);
				
				//将用户登录信息发放入session
				HttpSession session = request.getSession(false);
				if(session == null){
					session = request.getSession();
				}
				session.setAttribute("user", user);
				
				bean.setCode(1);
			} catch (Exception e) {
				// TODO: handle exception
				bean.setCode(0);
				bean.setMsg(e.getMessage());
			}
			
			response.getWriter().write(JSONObject.fromObject(bean).toString());
			
		}

}