package neu.reviewservice.coopreviewservice.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import neu.reviewservice.coopreviewservice.models.User;
import neu.reviewservice.coopreviewservice.repositories.CompanyLocationRepository;
import neu.reviewservice.coopreviewservice.repositories.CompanyRepository;
import neu.reviewservice.coopreviewservice.repositories.LocationRepository;
import neu.reviewservice.coopreviewservice.repositories.MajorRepository;
import neu.reviewservice.coopreviewservice.repositories.ReviewRepository;
import neu.reviewservice.coopreviewservice.repositories.UserRepository;
import neu.reviewservice.coopreviewservice.rest.services.ReviewService;

/**
 * REST APIs for users.
 */
@RestController
@RequestMapping("/user")
public class UserResource {
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

  // DELETE

  /**
   * Delete a user.
   *
   * @param user the user to delete
   * @return     a string if the deletion is successful
   */
  @RequestMapping(method = RequestMethod.DELETE)
  public ResponseEntity<String> deleteUser(@RequestBody @Valid User user) {
    this.userRepository.delete(user);
    return new ResponseEntity<>("User deleted", HttpStatus.OK);
  }

  /**
   * Delete a user with the given username.
   *
   * @param username the username of the user to delete
   * @return     a string if the deletion is successful
   */
  @RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
  public ResponseEntity<String> deleteUserByUsername(@PathVariable String username) {
    this.userRepository.deleteUserByUsername(username);
    return new ResponseEntity<>("User deleted", HttpStatus.OK);
  }

  // POST

  /**
   * Add a user
   *
   * @param user the new user to add to the database
   * @return     the user that was added to the database
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<User> addUser(@RequestBody @Valid User user) {
    User response = this.userRepository.save(user);
    return new ResponseEntity<>(response,
            response != null ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
  }

  // GET

  /**
   * Get a user from their username
   *
   * @param username the username
   * @return         the user with the given username
   */
  @RequestMapping(path = "/{username}", method = RequestMethod.GET)
  public ResponseEntity<User> userByUsername(@PathVariable String username) {
    User user = this.userRepository.findByUsername(username);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  /**
   * Get all users.
   *
   * @return an iterable of all the users in the database
   */
  @RequestMapping(path = "allUsers", method = RequestMethod.GET)
  public ResponseEntity<Iterable<User>> allUsers() {
    return new ResponseEntity<>(this.userRepository.findAll(), HttpStatus.OK);
  }

}
