package com.rr.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import com.rr.anno.Department;
import com.rr.dao.IDepartmentDao;

@Repository
public class DepartmentDao implements IDepartmentDao{

	@Resource
	private SessionFactory sessionFactory;
	
	//展示所有部门
	@Override
	public List<Department> showAllDepartment() {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Department");
		List<Department> list = null;
		try {
			list = query.list();		
		} catch (Exception e) {
			throw new RuntimeException("查询所有部门信息失败");
		}
				
		return list;
	}

	//添加部门
	@Override
	public void addDepartment(Department depart) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(depart);
		
	}

	//更新部门
	@Override
	public void updateDepartment(Department depart) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(depart);
		
	}

	//删除部门
	@Override
	public void deleteDepartment(Department depart) {
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(depart);
		
	}

	//根据id查找部门
	@Override
	public Department findDepartmentById(int did) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Department where did=:id");
		query.setParameter("id", did);
		Department depart = (Department)query.uniqueResult();
		
		return depart;
	}

	//根据名字查找部门
	@Override
	public Department findDepartmentByName(String dname) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Department where dname=:name");
		query.setParameter("name", dname);
		Department depart = (Department)query.uniqueResult();
		
		return depart;
	}

	

}
