package ma.m0hamedait.accountcqrses.query.repositories;

import ma.m0hamedait.accountcqrses.query.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
