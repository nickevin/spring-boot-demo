package com.zen.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class MemberController {

  private static final String template = "Mobile: %s!";

  @Autowired
  private MemberService memberService;

  @RequestMapping("/member")
  public Member member(@RequestParam(value = "mobile", defaultValue = "13818112388") String mobile) {
    log.info(String.format(template, mobile));

    return memberService.findByEmail(mobile);
  }

  @RequestMapping("/email")
  public Member email(@RequestParam(value = "email", defaultValue = "aopfilter@163.com") String email) {
    log.info(String.format(template, email));

    return memberService.findByEmail(email);
  }

  @RequestMapping("/members")
  public Page<Member> members() {
    // 一页两条纪录，显示第1页（以0起始）
    return memberService.findAll(new PageRequest(0, 2, Sort.Direction.DESC, "memberName"));
  }

}
