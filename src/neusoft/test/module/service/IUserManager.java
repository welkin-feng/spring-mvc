package neusoft.test.module.service;

import java.util.List;

import neusoft.test.module.domain.User;

public interface IUserManager {

	public String userLogin(String userName, String userPwd);
	public User getUserById(String userId);
	public void addUser(String id, String userName, String userPwd);
	public void updateUser(String id, String userName, String userPwd);
	public void delUserById(String userId);
	public List<User> getAll();
	public User getUserByName(String userName);
	
}
