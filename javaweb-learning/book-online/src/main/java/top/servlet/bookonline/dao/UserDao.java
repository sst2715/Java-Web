package top.servlet.bookonline.dao;

import top.servlet.bookonline.entity.User;

public interface UserDao {

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据条件查找用户
     *
     * @param userDto
     * @return
     */
    User findUser(User userDto);
}
