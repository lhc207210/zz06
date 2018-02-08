package com.rr.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.rr.anno.User;
import com.rr.dao.IUserDao;
import com.rr.service.IUserService;
import com.rr.util.StringUtil;
import com.rr.vo.TreeNode;


@Service
public class UserService implements IUserService{

	@Resource(name="userDao")
	private IUserDao userDao;

	/*
	@Override
	public List<User> findByPage(int index, int pageSize) {
		List<User> list = null;
		try{
			list = userDao.findByPage(index, pageSize);		
			
			return list;
		}catch(Exception e){
			throw new RuntimeException("查询餐桌数据异常");
		}		
	}

	@Override
	public long count() {
		Long count = null;
		
		try {
			count = userDao.count();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	*/

	@Override
	public void RegisterUser(User user) {
		//通过账号获取用户信息
		User userInfo = userDao.findByNumber(user.getUnumber());
		if(userInfo == null){
		try {
			userDao.Register(user);
		} catch (SQLException e) {
			throw new RuntimeException("用户注册异常");
		}
		} else {
			throw new RuntimeException("用户已经存在，不能注册");
		}
	}

	@Override
	public void updateUser(User user) {
		try {
			userDao.update(user);
		} catch (Exception e) {
			throw new RuntimeException("更新用户异常");
		}
		
	}

	@Override
	public List<User> searchByCondition(String keyword) {
		List<User> list = null;
		
		try {
			list = userDao.search(keyword);
		} catch (Exception e) {
			throw new RuntimeException("查询用户信息异常");
		}	
		return list;
	}


	@Override
	public List<User> showAllUser() {
		
		List<User> list = userDao.showAllUser();
		return list;
	}

	@Override
	public void login(String unumber, String password) {
		
		boolean ret = StringUtil.strIsEmpty(unumber);
		if(ret == true){
			throw new RuntimeException("账号不能为空");
		}
		ret = StringUtil.strIsEmpty(password);
		
		if(ret == true){
			throw new RuntimeException("密码不能为空");
		}
		
		User user = userDao.findByNumber(unumber);
		
		if(user == null){
			throw new RuntimeException("用户不存在");
		}else{
			if(!password.equals(user.getPassword())){
				throw new RuntimeException("密码不正确");
			}
		}
	}

	@Override
	public void deleteUser(User user) {
		
		try {		
			if(user != null){
				userDao.deleteUser(user);
			}else{
				throw new RuntimeException("用户不存在，不能删除");
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
			throw new RuntimeException("删除用户数据异常");
		}	
	}

	//根据账号查找用户
	@Override
	public User findUserByNumber(String unumber) {
		User user = null;
		
		try {
			if(user != null ){
				user = userDao.findByNumber(unumber);
			}else {
				throw new RuntimeException("用户不存在，不能删除");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	//根据id查找用户
	@Override
	public User findUserById(int id) {
		
		User user = null;	
		try {
			user = userDao.findById(id);
			if(user == null){
				throw new RuntimeException("用户不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	//根据名字查找用户
	@Override
	public User findUserByName(String uname) {
		User user = null;	
		try {
			user = userDao.findUserByName(uname);
			if(user == null){
				throw new RuntimeException("用户不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	//根据名字查找用户资源
	@Override
	public TreeNode findResourceByName(String uname) {
		
		TreeNode tree = userDao.findResourceByName(uname);
		return tree;
	}
}
