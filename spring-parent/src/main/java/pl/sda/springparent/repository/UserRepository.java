package pl.sda.springparent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.springparent.dao.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
