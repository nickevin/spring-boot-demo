package com.zen.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  @Autowired
  private MemberDAO memberDAO;

  public Member findByMobile(final String mobile) {
    return memberDAO.selectByMobile(mobile);
  }

  public Member findByEmail(final String mobile) {
    return memberDAO.selectByEmail(mobile);
  }

  public Page<Member> findAll(final Pageable pageable) {
    return memberDAO.findAll(pageable);
  }


}
