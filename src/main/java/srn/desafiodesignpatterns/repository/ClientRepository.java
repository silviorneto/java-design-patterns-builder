package srn.desafiodesignpatterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import srn.desafiodesignpatterns.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
