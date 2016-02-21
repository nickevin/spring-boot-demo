package com.zen.user;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD) // 有序，XmlTransient 作用在字段
// @XmlAccessorType(XmlAccessType.PROPERTY) // 无序（若有序需与 propOrder 使用），XmlTransient 作用在 setter
// @XmlType(propOrder = {"userId", "username", "realName", "mobile", "email", "description"})
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private String userId;
  private String username = "";
  @XmlTransient
  private String password;
  private String realName = "";
  private String mobile = "";
  private String email = "";
  private String description = "";

}
