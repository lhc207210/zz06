package com.rr.service;

import java.util.List;

import com.rr.anno.Department;

public interface IDepartmentService {

	//展示所有部门
	public List<Department> showAllDepartment();
	
	//添加部门
	public void addDepartment(Department depart);
	
	//更新部门
	public void updateDepartment(Department depart);
	
	//删除部门
	public void deleteDepartment(Department depart);
	
	//根据id查询部门
	public Department findDepartmentById(int id);
	
	//根据名字查找部门
	public Department findDepartmentByName(String dname);
}
