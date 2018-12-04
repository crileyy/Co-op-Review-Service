package neu.reviewservice.coopreviewservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * ORM model. Class represents the company_location table and its fields represent the table's columns.
 *
 * CREATE TABLE IF NOT EXISTS `company_location` (
 `company_id` INT NOT NULL,
 `location_id` INT NOT NULL,

 CONSTRAINT `cl_company_id` FOREIGN KEY (company_id) REFERENCES company (company_id),
 CONSTRAINT `cl_location_id` FOREIGN KEY (location_id) REFERENCES location (location_id)
 );
 */
@Entity
public class CompanyLocation {

  @Id
  private Integer companyId;
  private Integer locationId;

  public Integer getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Integer companyId) {
    this.companyId = companyId;
  }

  public Integer getLocationId() {
    return locationId;
  }

  public void setLocationId(Integer locationId) {
    this.locationId = locationId;
  }
}
