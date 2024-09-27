package top.servlet.bookonline.dao;

import org.junit.jupiter.api.Test;
import top.servlet.bookonline.dao.impl.UserDaoImpl;
import top.servlet.bookonline.entity.Book;
import top.servlet.bookonline.entity.User;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    @Test
    void insertUser() {
        UserDao userDao = new UserDaoImpl();
        User user = User.builder().nickname("sys").password("123456").address("江苏南京")
                .avatar("https://www.forestpolice.net/2024/0924/c1697a97577/page.htm").account("sys").build();
        userDao.insertUser(user);
    }}


//    void insertBook() {
//        UserDao userDao = new UserDaoImpl();
//        Book book = Book.builder().id("sys").password("123456").address("江苏南京")
//                .avatar("https://www.forestpolice.net/2024/0924/c1697a97577/page.htm").account("sys").build();
//
//
//