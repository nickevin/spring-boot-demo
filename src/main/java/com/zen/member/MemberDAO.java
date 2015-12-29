package com.zen.member;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO extends PagingAndSortingRepository<Member, String> {

  @Query("select u from Member u where u.mobile = ?1")
  public Member selectByMobile(String mobile);

  @Query(value = "SELECT * FROM t_member WHERE email = ?1", nativeQuery = true)
  public Member selectByEmail(String email);

}
