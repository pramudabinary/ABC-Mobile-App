package lk.abc.spring.repo;

import lk.abc.spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/24/21
 */


public interface ProductRepo extends JpaRepository<Product,String> {
}
