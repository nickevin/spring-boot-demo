package com.zen.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserDAO userDAO;

  public User findByUsername(final String username) {
    return userDAO.selectByUsername(username);
  }

}
