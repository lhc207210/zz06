package com.rr.dao;

import java.sql.SQLException;
import java.util.List;

import com.rr.anno.User;
import com.rr.vo.TreeNode;

public interface IUserDao {


	
	//展示所有用户
	public List<User> showAllUser(); 
	
	
	//展示用户信息
	//public List<User> findByPage(int index, int pageSize) throws SQLException;
	//public long count() throws SQLException;
	
	//根据账户查找用户
	public User findByNumber(String unumber);
	
	//注册用户(添加用户)
	public void Register(User user) throws SQLException;
	
	//模糊查找
	public List<User> search(String keyword);
	
	//根据Id查找用户
	public User findById(int id);
	
	//更新用户
	public void update(User user);

	//删除用户
	public void deleteUser(User user);
	
	//根据名字查找用户
	public User findUserByName(String uname);
		
	//根据名字查找资源
	public TreeNode findResourceByName(String uname);
}
