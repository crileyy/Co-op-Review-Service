package neu.reviewservice.coopreviewservice.repositories;

import org.springframework.data.repository.CrudRepository;

import neu.reviewservice.coopreviewservice.models.Review;

/**
 * Created by criley on 12/2/18.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
