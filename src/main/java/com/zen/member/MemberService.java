package com.zen.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  @Autowired
  private MemberDAO memberDAO;

  @Cacheable(value = "memberCache")
  public Member findByMobile(String mobile) {
    return memberDAO.selectByMobile(mobile);
  }

  @Cacheable(value = "memberCache2")
  public Member findByEmail(String mobile) {
    return memberDAO.selectByEmail(mobile);
  }

  @Cacheable(value = "memberCache3")
  public Page<Member> findAll(Pageable pageable) {
    return memberDAO.findAll(pageable);
  }


}
