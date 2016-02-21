package com.zen.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 * Class description goes here.
 *
 * @author aopfilter@163.com
 * @since 2014-09-20
 * @version 1.0
 * @see
 */
@Slf4j
@Api(tags = "member", description = "会员 API")
@RestController
@RequestMapping("/member")
public class MemberController {

  private static final String template = "Mobile: %s!";

  @Autowired
  private MemberService memberService;

  @ApiOperation(value = "查询手机号码")
  @RequestMapping(value = "/mobile", method = RequestMethod.GET)
  public Member mobile(@RequestParam(value = "mobile", defaultValue = "13818112388") String mobile) {
    log.info(String.format(template, mobile));

    return memberService.findByMobile(mobile);
  }

  @ApiOperation(value = "查询电子邮箱")
  @RequestMapping(value = "/email", method = RequestMethod.GET)
  public Member email(@ApiParam(value = "电子邮箱", required = true,
      example = "mike@gmail.com") @RequestParam(value = "email", defaultValue = "aopfilter@163.com") String email) {
    log.info(String.format(template, email));

    return memberService.findByEmail(email);
  }

  @ApiOperation(value = "查询所有会员")
  @RequestMapping(value = "/members", method = RequestMethod.GET)
  public Page<Member> members() {
    // 一页两条纪录，显示第1页（以0起始）
    return memberService.findAll(new PageRequest(0, 2, Sort.Direction.DESC, "memberName"));
  }

}
