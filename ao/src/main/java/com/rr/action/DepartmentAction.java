package com.rr.action;

import java.util.List;
import javax.annotation.Resource;

import com.rr.anno.Department;
import com.rr.service.IDepartmentService;

@Controller
@Scope("prototype")//针对Action的对象，设置为非单例的
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	@Resource(name="departmentService")
	private IDepartmentService departService;
	private Department depart;
	
	@Override
	public Department getModel() {
		if(depart == null){
			depart = new Department();
		}
		return depart;
	}
	

	//展示所有部门
	public void showAllDepartment(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		List<Department> list = departService.showAllDept();
		JSONObject json = JSONObject.fromObject(list);
		
		response.getWriter().write(json.toString());
	}
	
	//添加部门
		public String addDept(){
			HttpServletRequest request = ServletActionContext.getRequest();
			
			deptService.addDept(dept);
			
			return SUCCESS;
		}
		
		//删除部门
		public String deleteDepartment(){
			HttpServletRequest request = ServletActionContext.getRequest();
			
			departService.deleteDepartment(depart);
			
			return SUCCESS;
		}
		
		//更新部门
		public String updateDepartment(){
			HttpServletRequest request = ServletActionContext.getRequest();
			
			departService.updateDepartment(depart);
			
			return SUCCESS;
		}
		
		//根据ID查找部门
		public String findDepartmentById(){
			HttpServletRequest request = ServletActionContext.getRequest();
			
			departService.findDepartmentById(depart.getDId());
			
			return SUCCESS;
		}
		
		//根据名字查找部门
		public String findDepartByName(){
			HttpServletRequest request = ServletActionContext.getRequest();
			
			departService.findDepartment
			
			ByName(depart.getDName());
			
			return SUCCESS;
		}
}
