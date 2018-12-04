package neu.reviewservice.coopreviewservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ORM model. Class represents the location table and its fields represent the table's columns.
 *
 * CREATE TABLE IF NOT EXISTS `location` (
 `location_id` INT NOT NULL,
 `city` VARCHAR(50) NOT NULL,
 `state` VARCHAR(50) NULL,
 `country` VARCHAR(50) NOT NULL,
 PRIMARY KEY (`location_id`));
 */
@Entity
public class Location {

  @Id
  private Integer locationId;
  private String city;
  private String state;
  private String country;

  public Integer getLocationId() {
    return locationId;
  }

  public void setLocationId(Integer locationId) {
    this.locationId = locationId;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
