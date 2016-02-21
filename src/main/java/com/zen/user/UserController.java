package com.zen.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
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
@Api(tags = "user", description = "用户 API")
@RestController
@RequestMapping("/admin")
public class UserController {

  private static final String template = "Hello, %s!";

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/hi", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public User greeting(@RequestParam(value = "name", defaultValue = "root2") String username) {
    log.info(String.format(template, username));

    return userService.findByUsername(username);
  }
}
