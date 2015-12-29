package com.zen.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserDAO userDAO;

  @Cacheable(value = "userCache")
  public User findByUsername(String username) {
    return userDAO.selectByUsername(username);
  }

}
