package lk.abc.spring.repo;

import lk.abc.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/20/21
 */

public interface CustomerRepo extends JpaRepository<Customer, String> {
    Optional<Customer> findCustomerByNameAndPassword(String name, String password);
}
