package com.zen.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Class description goes here.
 *
 * @author zhen.ni@ebaotech.com
 * @since 2013-10-18
 * @version 1.0
 * @see
 */
@Slf4j
@RestController
public class UserController {

  private static final String template = "Hello, %s!";

  @Autowired
  private UserService userService;

  @RequestMapping("/greeting")
  public User greeting(@RequestParam(value = "name", defaultValue = "World") String username) {
    log.info(String.format(template, username));

    return userService.findByUsername(username);
  }
}
