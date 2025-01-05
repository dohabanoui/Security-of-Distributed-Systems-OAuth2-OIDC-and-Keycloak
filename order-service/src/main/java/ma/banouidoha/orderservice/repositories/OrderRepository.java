package ma.banouidoha.orderservice.repositories;
import ma.banouidoha.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
