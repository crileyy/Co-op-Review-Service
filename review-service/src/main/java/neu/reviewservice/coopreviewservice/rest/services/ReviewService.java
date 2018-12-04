package neu.reviewservice.coopreviewservice.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import neu.reviewservice.coopreviewservice.models.Review;
import neu.reviewservice.coopreviewservice.repositories.CompanyLocationRepository;
import neu.reviewservice.coopreviewservice.repositories.CompanyRepository;
import neu.reviewservice.coopreviewservice.repositories.LocationRepository;
import neu.reviewservice.coopreviewservice.repositories.MajorRepository;
import neu.reviewservice.coopreviewservice.repositories.ReviewRepository;
import neu.reviewservice.coopreviewservice.repositories.UserRepository;

/**
 * The class handles business logic for the review APIs. It has methods for retrieving data from the
 * database and processing it to return new data to the APIs.
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

  /**
   * Retrieves all of the reviews for the company with the given name.
   *
   * @param name the name of the company
   * @return     a list of the reviews for that company
   */
  public List<Review> getReviewsForCompany(String name) {
    Integer companyId = this.companyRepository.findByName(name).getCompanyId();
    return this.reviewRepository.findByCompanyId(companyId);
  }

  /**
   * Retrieves all of the ratings for the company with the given name.
   *
   * @param name the name of the company
   * @return     a list of the ratings for the company
   */
  public List<Integer> getRatingsForCompany(String name) {
    Integer companyId = this.companyRepository.findByName(name).getCompanyId();
    return this.reviewRepository.findByCompanyId(companyId).stream().map(Review::getCompanyId).collect(Collectors.toList());
  }

  /**
   * Retrieves the average rating for the company with the given name.
   *
   * @param name the name of the company
   * @return     the average rating for the company
   */
  public Double getAvgRatingForCompany(String name) {
    Integer companyId = this.companyRepository.findByName(name).getCompanyId();
    List<Double> ratings = this.reviewRepository.findByCompanyId(companyId).stream().map(Review::getRating).collect(Collectors.toList());
    Optional<Double> sumRatings = ratings.stream().reduce(Double::sum);
    return sumRatings.map(sum -> sum / ratings.size()).orElse(-1.0);
  }
}
