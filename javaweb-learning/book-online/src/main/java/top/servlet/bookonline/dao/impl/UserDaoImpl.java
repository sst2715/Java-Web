package top.servlet.bookonline.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.servlet.bookonline.dao.UserDao;
import top.servlet.bookonline.entity.User;
import top.servlet.bookonline.util.JdbcUtil;
import top.servlet.bookonline.util.Md5Util;

public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());

    public int insertUser(User user) {

        String sql = "INSERT INTO t_user(account,password,nickname,avatar) VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql, user.getAccount(), Md5Util.crypt(user.getPassword()), user.getNickname(), user.getAvatar());
    }
        public User findUser(User userDto){
            try {
                String sql = "SELECT * FROM t_user WHERE account = ? AND password = ?";

                return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>
                        (User.class),userDto.getAccount(),Md5Util.crypt(userDto.getPassword()))
            ;}catch(DataAccessException e){
                e.printStackTrace();
                return null;
        }
    }
}