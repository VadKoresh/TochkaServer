package main.repository;

import main.entity.IntentVisitEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntentVisitRepository extends CrudRepository<IntentVisitEntity, Integer> {
    List<IntentVisitEntity> findAll();
}
