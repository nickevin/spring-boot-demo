package com.zen.user;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDAO {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public User selectByUsername(String username) {
    String sql = "SELECT * FROM t_user tb WHERE tb.username = ?  ";

    Object[] params = new Object[] {username};
    int[] types = new int[] {Types.VARCHAR};

    log.info("no caching");

    return jdbcTemplate.queryForObject(sql, params, types, new BeanPropertyRowMapper<User>(User.class));
  }


}

