package neu.reviewservice.coopreviewservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * CREATE TABLE IF NOT EXISTS `company` (
 `company_id` INT NOT NULL,
 `name` VARCHAR(50) NOT NULL,
 PRIMARY KEY (`company_id`))
 */
@Entity
public class Company {

  @Id
  private Integer companyId;
  private String name;

  public Integer getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Integer companyId) {
    this.companyId = companyId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
