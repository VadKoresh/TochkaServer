package main.repository;

import main.entity.AdministratorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends CrudRepository<AdministratorEntity, Long> {
    AdministratorEntity findByLogin(String login);
}
