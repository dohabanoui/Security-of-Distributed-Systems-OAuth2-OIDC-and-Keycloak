package ma.banouidoha.orderservice.web;

import ma.banouidoha.orderservice.entities.Order;
import ma.banouidoha.orderservice.repositories.OrderRepository;
import ma.banouidoha.orderservice.restclients.InventoryRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrdersRestControllers {
    private OrderRepository orderRepository;
    private InventoryRestClient inventoryRestClient;

    public OrdersRestControllers(OrderRepository orderRepository, InventoryRestClient inventoryRestClient) {
        this.orderRepository = orderRepository;
        this.inventoryRestClient = inventoryRestClient;
    }

    /*
    @GetMapping("/orders")
    public List<Order> findAllOrders() {
        List<Order> allOrders = orderRepository.findAll();
        return allOrders;
    }*/

    @GetMapping("/orders")
    public List<Order> findAllOrders() {
        List<Order> allOrders = orderRepository.findAll();
        allOrders.forEach(order -> {
            order.getProductItems().forEach(productItem -> {
                productItem.setProduct(inventoryRestClient.findProductById(productItem.getProductId()));
            });
        });
        return allOrders;
    }

    @GetMapping("/orders/{id}")
    public Order findOrderById(@PathVariable String id) {
        Order order = orderRepository.findById(id).get();
        order.getProductItems().forEach(productItem -> {
            productItem.setProduct(inventoryRestClient.findProductById(productItem.getProductId()));
        });
        return order;
    }
}

