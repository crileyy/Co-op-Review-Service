package neu.reviewservice.coopreviewservice.models;

import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * ORM model. Class represents the review table and its fields represent the table's columns.
 *
 * CREATE TABLE IF NOT EXISTS `review` (
 `review_id` INT PRIMARY KEY AUTO_INCREMENT,
 `review_text` VARCHAR(2000) NULL,
 `rating` INT NOT NULL,
 `return_offer` BOOLEAN NULL,
 `would_work_again` BOOLEAN NULL,
 `user_id` INT,
 `company_id` INT NOT NULL,
 `location_id` INT NOT NULL,
 `num_interviews` INT,
 `position` varchar(50) NOT NULL,

 CONSTRAINT `r_user_id` FOREIGN KEY (user_id) REFERENCES user (user_id),
 CONSTRAINT `r_company_id` FOREIGN KEY (company_id) REFERENCES company (company_id),
 CONSTRAINT `r_location_id` FOREIGN KEY (location_id) REFERENCES location (location_id));
 */
@Entity
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Nullable
  private Integer reviewId;
  private String reviewText;
  private Double rating;
  private Boolean returnOffer;
  private Boolean wouldWorkAgain;
  private Integer userId;
  private Integer companyId;
  private Integer locationId;
  private Integer numInterviews;
  private String position;

  public Integer getReviewId() {
    return reviewId;
  }

  public void setReviewId(Integer reviewId) {
    this.reviewId = reviewId;
  }

  public String getReviewText() {
    return reviewText;
  }

  public void setReviewText(String reviewText) {
    this.reviewText = reviewText;
  }

  public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }

  public Boolean getReturnOffer() {
    return returnOffer;
  }

  public void setReturnOffer(Boolean returnOffer) {
    this.returnOffer = returnOffer;
  }

  public Boolean getWouldWorkAgain() {
    return wouldWorkAgain;
  }

  public void setWouldWorkAgain(Boolean wouldWorkAgain) {
    this.wouldWorkAgain = wouldWorkAgain;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

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

  public Integer getNumInterviews() {
    return numInterviews;
  }

  public void setNumInterviews(Integer numInterviews) {
    this.numInterviews = numInterviews;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }
}
