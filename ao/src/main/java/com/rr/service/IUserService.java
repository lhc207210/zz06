package com.rr.service;

import java.util.List;

import com.rr.anno.User;
import com.rr.vo.TreeNode;


public interface IUserService {

	//public List<User> findByPage(int index, int pageSize);
	
	//public long count();
	
	//展示所有用户
	public List<User> showAllUser();			
	
	//用户登录
	public void login(String unumber, String password);
	
	//注册用户
	public void RegisterUser(User user);
	
	//删除用户
	public void deleteUser(User user);		
	
	//修改用户
	public void updateUser(User user);
	
	//根据账号查找
	public User findUserByNumber(String unumber);
	
	//根据ID查找用户
	public User findUserById(int id);
	
	//根据名字查找用户
	public User findUserByName(String uname);
	
	//根据用户名字查找资源
	public TreeNode findResourceByName(String uname);
	
	//模糊查询
	public List<User> searchByCondition(String keyword);
	
	//添加用户
	//public void addUser(User user);
	
}
