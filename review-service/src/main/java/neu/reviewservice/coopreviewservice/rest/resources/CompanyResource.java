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

import neu.reviewservice.coopreviewservice.models.Company;
import neu.reviewservice.coopreviewservice.models.CompanyLocation;
import neu.reviewservice.coopreviewservice.models.User;
import neu.reviewservice.coopreviewservice.repositories.CompanyLocationRepository;
import neu.reviewservice.coopreviewservice.repositories.CompanyRepository;
import neu.reviewservice.coopreviewservice.repositories.LocationRepository;
import neu.reviewservice.coopreviewservice.repositories.MajorRepository;
import neu.reviewservice.coopreviewservice.repositories.ReviewRepository;
import neu.reviewservice.coopreviewservice.repositories.UserRepository;
import neu.reviewservice.coopreviewservice.rest.services.ReviewService;

/**
 * REST APIs for companies.
 */
@RestController
@RequestMapping("/company")
public class CompanyResource {
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

  // POST

  /**
   * Add a company to the database.
   *
   * @param company the company to add
   * @return        the company that was added
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Company> addCompany(@RequestBody @Valid Company company) {
    Company response = this.companyRepository.save(company);
    return new ResponseEntity<>(response,
            response != null ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
  }

  // GET

  /**
   * Get all companies in the database.
   *
   * @return an iterable of all companies
   */
  @RequestMapping(path = "allCompanies", method = RequestMethod.GET)
  public ResponseEntity<Iterable<Company>> allCompanies() {
    return new ResponseEntity<>(this.companyRepository.findAll(), HttpStatus.OK);
  }

  /**
   * Get all company locations in the database.
   *
   * @return an iterable of all company locations
   */
  @RequestMapping(path = "allCompanyLocations", method = RequestMethod.GET)
  public ResponseEntity<Iterable<CompanyLocation>> allCompanyLocations() {
    return new ResponseEntity<>(this.companyLocationRepository.findAll(), HttpStatus.OK);
  }

}
