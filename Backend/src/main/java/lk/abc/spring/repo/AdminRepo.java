package lk.abc.spring.repo;

import lk.abc.spring.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/20/21
 */

public interface AdminRepo extends JpaRepository<Admin, String> {
    Optional<Admin> findAdminByNameAndPassword(String name,String password);
}
