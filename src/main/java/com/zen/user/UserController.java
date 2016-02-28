package com.zen.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;

@Api(tags = "user", description = "用户 API")
@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/hi", method = RequestMethod.GET)
  public @ResponseBody User welcome() {
    return userService.findByUsername("admin");
  }

  @RequestMapping(method = RequestMethod.GET)
  public String user(final ModelMap model) {
    model.addAttribute("role", "user");

    return "user";
  }

  @RequestMapping(value = "/admin", method = RequestMethod.GET)
  public String admin(final ModelMap model) {
    model.addAttribute("role", "admin");

    return "user";
  }

}
