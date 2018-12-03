package neu.reviewservice.coopreviewservice.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neu.reviewservice.coopreviewservice.models.User;
import neu.reviewservice.coopreviewservice.repositories.UserRepository;

/**
 * REST APIs for the reviews.
 */
@RestController
@RequestMapping("/review")
public class ReviewResource {

  @Autowired
  private UserRepository userRepository;

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

  @RequestMapping(path = "allUsers", method = RequestMethod.GET)
  public ResponseEntity<Iterable<User>> allUsers() {
    return new ResponseEntity<>(this.userRepository.findAll(), HttpStatus.OK);
  }

  @RequestMapping(path = "ping", method = RequestMethod.GET)
  public ResponseEntity<String> findAllSongs() {
    return new ResponseEntity<>("pong", HttpStatus.OK);
  }
}
