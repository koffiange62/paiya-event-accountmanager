package events.paiya.accountmanager.repositories;

import events.paiya.accountmanager.domains.User;
import org.mapstruct.control.MappingControl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByActiveIsTrue();
    Page<User> findAllByActiveIsTrue(Pageable pageable);
    Optional<User> findUserByIdAndActiveIsTrue(String id);
    boolean existsByEmailAndActiveIsTrue(String email);
}
