package neu.reviewservice.coopreviewservice.repositories;

import org.springframework.data.repository.CrudRepository;

import neu.reviewservice.coopreviewservice.models.Company;

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called companyRepository. In Spring, an
 * interface that extends a CrudRepository has access to a specific table in the MySQL database.
 * This interface has access to the company table.
 * CRUD refers Create, Read, Update, Delete.
 */
public interface CompanyRepository extends CrudRepository<Company, Integer> {

  Company findByName(String name);
}
