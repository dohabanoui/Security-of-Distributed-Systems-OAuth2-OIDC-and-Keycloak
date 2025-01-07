package ma.sdia.inventoryservice.repository;

import ma.sdia.inventoryservice.entities.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChequeRepository extends JpaRepository<Cheque, String> {
}
