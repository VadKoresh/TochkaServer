package main.repository;

import main.entity.UserTochkiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTochkiRepository extends CrudRepository<UserTochkiEntity, Long> {
    UserTochkiEntity findByNumberPhone(String numberPhone);
    List<UserTochkiEntity> findAllByNumberPhoneIsNotNull();
}
