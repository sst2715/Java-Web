package top.servlet.bookonline.service.impl;

import top.servlet.bookonline.dao.UserDao;
import top.servlet.bookonline.dao.impl.UserDaoImpl;
import top.servlet.bookonline.entity.User;
import top.servlet.bookonline.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    public User signIn(String account, String password) {
        User user = User.builder().account(account).password(password).build();
        return userDao.findUser(user);
    }}
