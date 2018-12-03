package neu.reviewservice.coopreviewservice.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import neu.reviewservice.coopreviewservice.models.Company;
import neu.reviewservice.coopreviewservice.models.CompanyLocation;
import neu.reviewservice.coopreviewservice.models.Location;
import neu.reviewservice.coopreviewservice.models.Major;
import neu.reviewservice.coopreviewservice.models.Review;
import neu.reviewservice.coopreviewservice.models.User;
import neu.reviewservice.coopreviewservice.repositories.CompanyLocationRepository;
import neu.reviewservice.coopreviewservice.repositories.CompanyRepository;
import neu.reviewservice.coopreviewservice.repositories.LocationRepository;
import neu.reviewservice.coopreviewservice.repositories.MajorRepository;
import neu.reviewservice.coopreviewservice.repositories.ReviewRepository;
import neu.reviewservice.coopreviewservice.repositories.UserRepository;
import neu.reviewservice.coopreviewservice.rest.services.ReviewService;

/**
 * REST APIs for the reviews.
 */
@RestController
@RequestMapping("/review")
public class ReviewResource {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ReviewRepository reviewRepository;

  @Autowired
  private MajorRepository majorRepository;

  @Autowired
  private LocationRepository locationRepository;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private CompanyLocationRepository companyLocationRepository;

  @Autowired
  private ReviewService reviewService;

  /*
  TODO APIs to make
  Get:
    Get all reviews for a company (can add parameters to get reviews for a specified company)
    Get all ratings for a company
    Get average rating for a company
    Get location information for co-op position
    Get user information
    Get accepted rate
    Get offer rate
  Put:
    Update user
    Update review
    Update company
  Post:
    Add review
    Add user
    Add company
    Add major
  Delete:
    Delete user
    Delete review
   */
  @RequestMapping(path = "reviewsForCompany/{name}", method = RequestMethod.GET)
  public ResponseEntity<List<Review>> reviewsForCompany(@PathVariable String name) {
    return new ResponseEntity<>(this.reviewService.getReviewsForCompany(name), HttpStatus.OK);
  }

  @RequestMapping(path = "allCompanies", method = RequestMethod.GET)
  public ResponseEntity<Iterable<Company>> allCompanies() {
    return new ResponseEntity<>(this.companyRepository.findAll(), HttpStatus.OK);
  }

  @RequestMapping(path = "allCompanyLocations", method = RequestMethod.GET)
  public ResponseEntity<Iterable<CompanyLocation>> allCompanyLocations() {
    return new ResponseEntity<>(this.companyLocationRepository.findAll(), HttpStatus.OK);
  }

  @RequestMapping(path = "allLocations", method = RequestMethod.GET)
  public ResponseEntity<Iterable<Location>> allLocations() {
    return new ResponseEntity<>(this.locationRepository.findAll(), HttpStatus.OK);
  }

  @RequestMapping(path = "allMajors", method = RequestMethod.GET)
  public ResponseEntity<Iterable<Major>> allMajors() {
    return new ResponseEntity<>(this.majorRepository.findAll(), HttpStatus.OK);
  }

  @RequestMapping(path = "allReviews", method = RequestMethod.GET)
  public ResponseEntity<Iterable<Review>> allReviews() {
    return new ResponseEntity<>(this.reviewRepository.findAll(), HttpStatus.OK);
  }

  @RequestMapping(path = "allUsers", method = RequestMethod.GET)
  public ResponseEntity<Iterable<User>> allUsers() {
    return new ResponseEntity<>(this.userRepository.findAll(), HttpStatus.OK);
  }

  @RequestMapping(path = "ping", method = RequestMethod.GET)
  public ResponseEntity<String> findAllSongs() {
    return new ResponseEntity<>("pong", HttpStatus.OK);
  }
}
