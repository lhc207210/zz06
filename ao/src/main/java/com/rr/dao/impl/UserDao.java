package com.rr.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.rr.anno.User;
import com.rr.dao.IUserDao;
import com.rr.vo.ResourseBean;
import com.rr.vo.TreeNode;

@Repository
public class UserDao implements IUserDao{

	@Resource
	private SessionFactory sessionFactory;
	
	//展示所用用户
	@Override
	public List<User> showAllUser() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		
		return list;
	}

	/*
	@Override
	public List<User> findByPage(int index, int pageSize) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select d,u from User u,Department d where d.did=u.departmen.did");
		
		//从那个索引处记录开始查
		query.setFirstResult(index);		
		//最多查询多少条数据
		query.setMaxResults(pageSize);
		
		//返回查询的数据的集合
		List<User> list = null;		
		try {
			list = query.list();		
		} catch (Exception e) {
			throw new RuntimeException("查询所有用户信息失败");
		}
				
		return list;
	}

	@Override
	public long count() throws SQLException {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select count(*) from User");		
		Long count = (long)query.uniqueResult();
		return count;
	}
	*/


	//注册用户(添加用户)
	@Override
	public void Register(User user) throws SQLException {
	
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	
	}

	//通过名字进行模糊查找
	@Override
	public List<User> search(String keyword) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where uname like :name");
		query.setParameter("name", "%" + keyword + "%");
		//返回查询的数据的集合
		List<User> list = null;
				
		try {
			list = query.list();		
		} catch (Exception e) {
			throw new RuntimeException("查询用户信息失败");
		}			
		return list;	
	}

	@Override
	public User findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where uid=:uid");
		query.setParameter("uid", id);
		
		User user = (User)query.uniqueResult();
		return user;
	}

	@Override
	public void update(User user) {

		Session session = sessionFactory.getCurrentSession();		
		session.saveOrUpdate(user);
		
	}


	// 根据名字查找资源
	@Override
	public TreeNode findResourceByName(String uname) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select new com.rr.vo.ResourseBean(re.resid,re.resname,re.url) from Employee emp, Roleemployee rmp,Role r,Roleresources rrs,Resources re,RoleresourcesId rei "
				+ "where emp.eid=remp.employee.eid and r.rid=rmp.role.rid and r.rid=rrs.role.rid and emp.username=:ename");
		query.setParameter("uname", uname);
		List<ResourseBean> list = query.list();
		TreeNode treeNode1 = new TreeNode();
		List<TreeNode> children = new ArrayList<>();
		for (ResourseBean rb : list) {
			Map<String, Object> map = new HashMap<>();
			if (rb == list.get(0)) {
				treeNode1.setId(String.valueOf(rb.getResid()));
				treeNode1.setText(rb.getResname());
				map.put("url", rb.getUrl());
				treeNode1.setAttributes(map);
			} else {
				TreeNode treeNode = new TreeNode();
				treeNode.setId(String.valueOf(rb.getResid()));
				treeNode.setText(rb.getResname());
				map.put("url", rb.getUrl());
				treeNode.setAttributes(map);
				children.add(treeNode);
			}

		}	
		treeNode1.setChildren(children);

		return treeNode1;
	}

	//通过账号查找
	@Override
	public User findByNumber(String unumber) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where unumber=:unumber");
		
		query.setParameter("unumber", unumber);
		User user = (User)query.uniqueResult();
		
		return user;
	}

	//删除用户
	@Override
	public void deleteUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
		
	}

	@Override
	public User findUserByName(String uname) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where uname=:uname");
		
		query.setParameter("uname", uname);
		User user = (User)query.uniqueResult();
		
		return user;
	}

}
