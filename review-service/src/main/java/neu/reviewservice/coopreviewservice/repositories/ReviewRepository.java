package neu.reviewservice.coopreviewservice.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import neu.reviewservice.coopreviewservice.models.Review;

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called reviewRepository. In Spring, an
 * interface that extends a CrudRepository has access to a specific table in the MySQL database.
 * This interface has access to the review table.
 * CRUD refers Create, Read, Update, Delete.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {

  List<Review> findByCompanyId(Integer companyId);
}
