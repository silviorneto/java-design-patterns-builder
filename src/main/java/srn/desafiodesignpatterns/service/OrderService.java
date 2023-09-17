package srn.desafiodesignpatterns.service;

import srn.desafiodesignpatterns.model.Combo;
import srn.desafiodesignpatterns.model.Order;

import java.util.Optional;

public interface OrderService {
    Iterable<Order> getAll();
    Optional<Order> findById(Long id);
    void save(Order order);
    void update(Long id, Order order);
    void delete(Long id);

    Order saveCombo(Integer comboNumber, Long clientId);

}
