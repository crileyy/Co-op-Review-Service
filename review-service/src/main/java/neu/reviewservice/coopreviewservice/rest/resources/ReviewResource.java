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

import javax.validation.Valid;

import neu.reviewservice.coopreviewservice.models.Location;
import neu.reviewservice.coopreviewservice.models.Major;
import neu.reviewservice.coopreviewservice.models.Review;
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
    Get return offer rate
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

  // DELETE
  @RequestMapping(method = RequestMethod.DELETE)
  public ResponseEntity<String> deleteReview(@RequestBody @Valid Review review) {
    this.reviewRepository.delete(review);
    return new ResponseEntity<>("Review deleted", HttpStatus.OK);
  }

  // POST
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Review> addReview(@RequestBody @Valid Review review) {
    Review response = this.reviewRepository.save(review);
    return new ResponseEntity<>(response,
            response != null ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
  }

  // GET
  @RequestMapping(path = "avgRatingForCompany/{name}", method = RequestMethod.GET)
  public ResponseEntity<Double> avgRatingForCompany(@PathVariable String name) {
    return new ResponseEntity<>(this.reviewService.getAvgRatingForCompany(name), HttpStatus.OK);
  }

  @RequestMapping(path = "ratingsForCompany/{name}", method = RequestMethod.GET)
  public ResponseEntity<List<Integer>> ratingsForCompany(@PathVariable String name) {
    return new ResponseEntity<>(this.reviewService.getRatingsForCompany(name), HttpStatus.OK);
  }

  @RequestMapping(path = "reviewsForCompany/{name}", method = RequestMethod.GET)
  public ResponseEntity<List<Review>> reviewsForCompany(@PathVariable String name) {
    return new ResponseEntity<>(this.reviewService.getReviewsForCompany(name), HttpStatus.OK);
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

  @RequestMapping(path = "ping", method = RequestMethod.GET)
  public ResponseEntity<String> findAllSongs() {
    return new ResponseEntity<>("pong", HttpStatus.OK);
  }
}
