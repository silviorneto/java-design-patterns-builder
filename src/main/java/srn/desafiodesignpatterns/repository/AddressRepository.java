package srn.desafiodesignpatterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import srn.desafiodesignpatterns.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
}
