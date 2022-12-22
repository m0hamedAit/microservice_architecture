package ma.m0hamedait.accountcqrses.query.repositories;

import ma.m0hamedait.accountcqrses.query.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
