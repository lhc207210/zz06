package com.rr.dao;

import java.util.List;

import com.rr.anno.Department;

public interface IDepartmentDao {

	//展示所有部门
	public List<Department> showAllDepartment();
	
	//增加部门
	public void addDepartment(Department depart);
	
	//更新部门
	public void updateDepartment(Department depart);
	
	//删除部门
	public void deleteDepartment(Department depart);
	
	//根据Id查询部门
	public Department findDepartmentById(int did);
	
	//根据名字查找部门
	public Department findDepartmentByName(String dname);
}
