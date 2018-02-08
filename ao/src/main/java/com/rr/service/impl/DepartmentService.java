package com.rr.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rr.anno.Department;
import com.rr.dao.IDepartmentDao;
import com.rr.service.IDepartmentService;

@Service
public class DepartmentService implements IDepartmentService{

	@Resource(name="departmentDao")
	private IDepartmentDao departDao;
	
	//展示所有用户
	@Override
	public List<Department> showAllDepartment() {
		
		List<Department> list = null;
		
		list = departDao.showAllDepartment();
		return list;
	}

	//添加用户
	@Override
	public void addDepartment(Department depart) {
		//通过名字获取部门
		Department department = departDao.findDepartmentByName(depart.getDname())
		
		if(department == null){
			try {
				
				departDao.addDepartment(depart);
				
			} catch (SQLException e) {
				
				throw new RuntimeException("添加部门异常");
				
			}
			
		} else {
			
			throw new RuntimeException("部门已经存在，不能添加");
		}	
	}

	//更新部门
	@Override
	public void updateDepartment(Department depart) {
		
		try {
			departDao.updateDepartment(depart);;
		} catch (Exception e) {
			throw new RuntimeException("更新部门异常");
		}
		
	}

	//删除部门
	@Override
	public void deleteDepartment(Department depart) {
		
		try {		
			if(depart != null){
				departDao.deleteDepartment(depart);
			}else{
				throw new RuntimeException("部门不存在，不能删除");
			}
		} catch (Exception e) {
				
			throw new RuntimeException("删除部门数据异常");
		}	
	}

	//通过id查找部门
	@Override
	public Department findDepartmentById(int id) {
		
		Department depart = null;	
		try {
			depart = departDao.findDepartmentById(id);
			
			if(depart == null){
				throw new RuntimeException("部门不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return depart;
	}

	@Override
	public Department findDepartmentByName(String dname) {
		
		Department depart = null;	
		try {
			depart = departDao.findDepartmentByName(dname);
			
			if(depart == null){
				throw new RuntimeException("部门不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return depart;
	}

}
