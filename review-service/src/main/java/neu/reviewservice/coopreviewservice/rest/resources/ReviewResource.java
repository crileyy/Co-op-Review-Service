package neu.reviewservice.coopreviewservice.rest.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST APIs for the reviews.
 */
@RestController
@RequestMapping("/review")
public class ReviewResource {

  @RequestMapping(path = "ping", method = RequestMethod.GET)
  public ResponseEntity<String> findAllSongs() {
    return new ResponseEntity<>("pong", HttpStatus.OK);
  }
}
