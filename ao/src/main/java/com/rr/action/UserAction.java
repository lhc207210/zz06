package com.rr.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.rr.anno.User;
import com.rr.service.IUserService;
import com.rr.util.ResponseInfo;
import com.rr.vo.JsonBean;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")//针对Action的对象，设置为非单例的
public class UserAction extends ActionSupport implements ModelDriven<User>{

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

	/*
	public void listUser(){
			
		JsonBean bean = new JsonBean();
		HttpServletRequest reqeust= ServletActionContext.getRequest();
			
		//得到页面
		String page = reqeust.getParameter("page");
					
		//得到每页显示多少条记录
		String pageSize = reqeust.getParameter("rows");
					
		//查询总行数
		try {
			long count = userService.count();
			int index = (Integer.parseInt(page) - 1) * Integer.parseInt(pageSize);
									
			//分页查询
			List<User> list = userService.findByPage(index, Integer.parseInt(pageSize));
			Map<String, Object> map = new HashMap<>();
			map.put("total", count);
			map.put("rows", list);//每页的数据
							
			bean.setCode(1);
			bean.setMsg(map);
		} catch (Exception e) {
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
	
		String string = JSONObject.fromObject(bean).toString();
		ResponseInfo.writeInfo(string);
	}
	*/
	
	//更新
	public void updateUser(){
		
		userService.updateUser(user);
		
		JsonBean bean = new JsonBean();
		bean.setCode(1);
		
		String string = JSONObject.fromObject(bean).toString();
		ResponseInfo.writeInfo(string);
	}
	
	//删除
	public void deleteuser(){
		userService.deleteUser(user);
		JsonBean bean = new JsonBean();
		bean.setCode(1);
		
		String string = JSONObject.fromObject(bean).toString();
		ResponseInfo.writeInfo(string);
	}
	
	//模糊查询，展示结果
	public void findByCondition(String keyword){
		userService.searchByCondition(keyword);
		JsonBean bean = new JsonBean();
		bean.setCode(1);
		
		String string = JSONObject.fromObject(bean).toString();
		ResponseInfo.writeInfo(string);
	}
}
