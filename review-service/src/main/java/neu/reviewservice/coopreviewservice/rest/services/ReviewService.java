package neu.reviewservice.coopreviewservice.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import neu.reviewservice.coopreviewservice.models.Review;
import neu.reviewservice.coopreviewservice.repositories.CompanyLocationRepository;
import neu.reviewservice.coopreviewservice.repositories.CompanyRepository;
import neu.reviewservice.coopreviewservice.repositories.LocationRepository;
import neu.reviewservice.coopreviewservice.repositories.MajorRepository;
import neu.reviewservice.coopreviewservice.repositories.ReviewRepository;
import neu.reviewservice.coopreviewservice.repositories.UserRepository;

/**
 * Created by criley on 12/3/18.
 */
@Service
public class ReviewService {

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

  public List<Review> getReviewsForCompany(String name) {
    Integer companyId = this.companyRepository.findByName(name).getCompanyId();
    return this.reviewRepository.findByCompanyId(companyId);
  }

  public List<Integer> getRatingsForCompany(String name) {
    Integer companyId = this.companyRepository.findByName(name).getCompanyId();
    return this.reviewRepository.findByCompanyId(companyId).stream().map(Review::getCompanyId).collect(Collectors.toList());
  }
}
