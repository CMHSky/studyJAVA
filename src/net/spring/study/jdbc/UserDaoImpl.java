package net.spring.study.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

//    @Resource
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int addUer(User user) {
        String sql = "INSERT into `user` (`user`.user_name,`user`.`status`) VALUES(?,?);";
        int update = jdbcTemplate.update(sql, user.getUserName(), user.getStatus());
        return update;
    }

    @Override
    public int update(User user) {
        String sql = "UPDATE `user` SET status=? WHERE user_name=?;";
        return jdbcTemplate.update(sql, user.getStatus(), user.getUserName());
    }

    @Override
    public int delete(User user) {
        String sql = "DELETE FROM `user` where user_name=?;";
        return jdbcTemplate.update(sql, user.getUserName());
    }

    @Override
    public int count(User user) {
        String sql = "SELECT COUNT(*) FROM `user` where `status`=?;";
        return jdbcTemplate.queryForObject(sql, Integer.class, user.getStatus());
    }

    @Override
    public List<User> getList(User user) {
        String sql = "SELECT * FROM `user` where `status`=?;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), user.getStatus());
    }

    @Override
    public User getUser(User user) {
        String sql = "SELECT * FROM `user` where `user_id`=?;";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUserId());
    }

    @Override
    public void batchAddUser(List<Object[]> batchArgs) {
        String sql = "INSERT into `user` (`user`.user_name,`user`.`status`) VALUES(?,?);";
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }
}
