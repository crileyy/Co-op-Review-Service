package neu.reviewservice.coopreviewservice.repositories;

import org.springframework.data.repository.CrudRepository;

import neu.reviewservice.coopreviewservice.models.User;

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository. In Spring, an
 * interface that extends a CrudRepository has access to a specific table in the MySQL database.
 * This interface has access to the user table.
 * CRUD refers Create, Read, Update, Delete.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

  User findByUsername(String username);
}
