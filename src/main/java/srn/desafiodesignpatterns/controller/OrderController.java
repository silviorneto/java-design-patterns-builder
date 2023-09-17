package srn.desafiodesignpatterns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import srn.desafiodesignpatterns.dto.CreateComboPayload;
import srn.desafiodesignpatterns.model.Combo;
import srn.desafiodesignpatterns.model.Order;
import srn.desafiodesignpatterns.service.OrderService;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @GetMapping
    public ResponseEntity<Iterable<Order>> getAll() {
        Iterable<Order> orders = orderService.getAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PostMapping("/combo")
    public ResponseEntity<Order> saveCombo(@RequestBody CreateComboPayload payload) {
        Long clientId = Long.valueOf(payload.getClient_id().toString());
        Integer comboNumber = Integer.valueOf(payload.getCombo_number().toString());
        Order order = orderService.saveCombo(comboNumber, clientId);
        return ResponseEntity.ok(order);
    }


    @PutMapping("{id}")
    public ResponseEntity<Order> update(@PathVariable("id") Long id, @RequestBody Order order) {
        orderService.update(id, order);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }

}
