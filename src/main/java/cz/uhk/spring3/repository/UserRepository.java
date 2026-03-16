package cz.uhk.spring3.repository;

import cz.uhk.spring3.model.User;
import cz.uhk.spring3.model.dto.UserBasicsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserBasicsDTO findByEmail(String email);
}
