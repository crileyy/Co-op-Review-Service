package neu.reviewservice.coopreviewservice.repositories;

import org.springframework.data.repository.CrudRepository;

import neu.reviewservice.coopreviewservice.models.Major;

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called majorRepository. In Spring, an
 * interface that extends a CrudRepository has access to a specific table in the MySQL database.
 * This interface has access to the major table.
 * CRUD refers Create, Read, Update, Delete.
 */
public interface MajorRepository extends CrudRepository<Major, Integer> {
}
