package pontta.teste.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pontta.teste.crud.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
