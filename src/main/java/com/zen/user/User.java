package com.zen.user;

import java.io.Serializable;

import lombok.Data;

/**
 * Class description goes here.
 * 
 * @author aopfilter@163.com
 * @since Jan 21, 2015 2:06:15 PM
 * @version 1.0
 * 
 */
@Data
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private String userId;
  private String username = "";
  private String password;
  private String realName = "";
  private String mobile = "";
  private String email = "";
  private String description = "";

}
