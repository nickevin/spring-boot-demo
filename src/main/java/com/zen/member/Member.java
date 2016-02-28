package com.zen.member;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class description goes here.
 *
 * @author aopfilter@163.com
 * @since Jan 21, 2015 2:06:15 PM
 * @version 1.0
 * @see
 */
@Data
@Entity
@Table(name = "t_member")
@EqualsAndHashCode
@XmlRootElement(name = "Member")
@XmlAccessorType(XmlAccessType.FIELD)
public class Member implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String memberId;
  @NotNull
  private String memberName = "";
  @NotNull
  @XmlTransient
  private String password;
  @NotNull
  private String mobile = "";
  @NotNull
  private String email = "";
  private String address = "";
  private long score;

}
