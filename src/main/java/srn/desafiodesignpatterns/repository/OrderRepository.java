package srn.desafiodesignpatterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import srn.desafiodesignpatterns.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
