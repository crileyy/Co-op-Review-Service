package neu.reviewservice.coopreviewservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ORM model. Class represents the major table and its fields represent the table's columns.
 *
 * CREATE TABLE IF NOT EXISTS `major` (
 `major_id` INT NOT NULL,
 `name` VARCHAR(50) NOT NULL,
 PRIMARY KEY (`major_id`));
 */
@Entity
public class Major {

  @Id
  private Integer majorId;
  private String name;

  public Integer getMajorId() {
    return majorId;
  }

  public void setMajorId(Integer majorId) {
    this.majorId = majorId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
