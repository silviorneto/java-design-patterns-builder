package srn.desafiodesignpatterns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import srn.desafiodesignpatterns.exceptions.ClientNotFoundException;
import srn.desafiodesignpatterns.model.Client;
import srn.desafiodesignpatterns.model.Combo;
import srn.desafiodesignpatterns.model.Order;
import srn.desafiodesignpatterns.model.builder.OrderBuilder;
import srn.desafiodesignpatterns.repository.ClientRepository;
import srn.desafiodesignpatterns.repository.OrderRepository;
import srn.desafiodesignpatterns.service.OrderService;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Iterable<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void update(Long id, Order order) {
        Optional<Order> orderFounded = orderRepository.findById(id);
        if (orderFounded.isPresent()) {
            orderRepository.save(order);
        }
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order saveCombo(Integer comboNumber, Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);

        if (client.isEmpty()) {
            throw new ClientNotFoundException("Cliente não encontrado");
        }

        Combo combo = Combo.fromNumber(comboNumber);
        OrderBuilder orderBuilder = new OrderBuilder();
        Order order;

        if (combo == Combo.FAMILIA) {
            order = orderBuilder
                    .addMain("PizzaFamília")
                    .forDrink("Refrigerante 2L")
                    .addDessert("Pizza Chocolate M")
                    .addGift("Brinquedo")
                    .toClient(client.get())
                    .thatsAll();

        } else if (combo == Combo.VEGETARIANO) {
            order = orderBuilder
                    .addMain("Pizza Veggie")
                    .forDrink("Suco 1L")
                    .toClient(client.get())
                    .thatsAll();

        } else {
            order = orderBuilder
                    .addMain("Pizza Grande")
                    .forDrink("Refrigerante 1.5L")
                    .addDessert("Pizza Chocolate Brotinho")
                    .toClient(client.get())
                    .thatsAll();
        }

        orderRepository.save(order);
        return order;
    }


}
