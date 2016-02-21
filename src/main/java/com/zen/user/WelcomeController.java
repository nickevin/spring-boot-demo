package com.zen.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * Class description goes here.
 *
 * @see http://www.oresteluci.com/java-rest-xml-json-response/
 */
@Slf4j
@Api(tags = "test", description = "测试")
@Controller
public class WelcomeController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/welcome", method = RequestMethod.GET)
  public @ResponseBody User welcome() {
    return userService.findByUsername("admin");
  }

  @RequestMapping(value = "/hi", method = RequestMethod.GET)
  public String hi(ModelMap model) {
    model.addAttribute("result", true);

    return "user";
  }

}
