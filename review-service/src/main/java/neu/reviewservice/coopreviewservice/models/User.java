package neu.reviewservice.coopreviewservice.models;

/**
 * Created by criley on 12/2/18.
 *
 * CREATE TABLE IF NOT EXISTS `user` (
 `user_id` INT NOT NULL,
 `username` VARCHAR(50) NOT NULL UNIQUE,
 `firstname` VARCHAR(50),
 `lastname` VARCHAR(50),
 `year` INT,
 `email` VARCHAR(50),
 `num_coops` INT NOT NULL,
 `major_id` INT NOT NULL,
 PRIMARY KEY (`user_id`),

 CONSTRAINT `u_major_id` FOREIGN KEY (major_id) REFERENCES major (major_id));
 */

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

  @Id
  private Integer userId;
  private String username;
  private String firstname;
  private String lastname;
  private Integer year;
  private String email;
  private Integer numCoops;
  private Integer majorId;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getNumCoops() {
    return numCoops;
  }

  public void setNumCoops(Integer numCoops) {
    this.numCoops = numCoops;
  }

  public Integer getMajorId() {
    return majorId;
  }

  public void setMajorId(Integer majorId) {
    this.majorId = majorId;
  }
}
