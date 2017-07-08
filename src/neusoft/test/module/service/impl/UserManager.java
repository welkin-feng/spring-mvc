package neusoft.test.module.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import neusoft.test.module.domain.User;
import neusoft.test.module.mapper.IUserMapper;
import neusoft.test.module.service.IUserManager;

@Service("userManager")
@Transactional
public class UserManager implements IUserManager {
	@Autowired
	private IUserMapper userMapper;

	@Override
	public String userLogin(String userName, String userPwd) {
		User user = userMapper.getUserByName(userName);

		System.out.println(user.getId() + ":" + user.getUserName() + ":" + user.getUserPwd());
		if (user.getUserPwd().equalsIgnoreCase(userPwd)) {
			if (userName.equals("admin")) {
				// 跳转到商品管理页（goodsmanager.html）
				return "goodsmanager";
			} else {
				// 跳转到分类查询页（selectbyclass.html）
				return "classification";
			}
		}
		return null;
	}

	public User getUserById(String userId) {
		System.out.println("search" + userId);
		User user = userMapper.getUser(userId);
		return user;
	}

	@Override
	public void addUser(String id, String userName, String userPwd) {
		userMapper.add(id, userName, userPwd);
	}

	@Override
	public void updateUser(String id, String userName, String userPwd) {
		System.out.println("update" + id);
		userMapper.updateUser(id, userName, userPwd);

	}

	@Override
	public void delUserById(String userId) {
		System.out.println("update" + userId);
		userMapper.delUserById(userId);
	}

	@Override
	public List<User> getAll() {
		List<User> userList = userMapper.getAll();
		return userList;
	}

	@Override
	public User getUserByName(String userName) {
		User user = userMapper.getUserByName(userName);
		return user;
	}
}
