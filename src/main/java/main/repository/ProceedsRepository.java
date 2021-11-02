package main.repository;

import main.entity.ProceedsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProceedsRepository extends CrudRepository<ProceedsEntity, Long> {

    ProceedsEntity findByDate(LocalDate localDate);
    List<ProceedsEntity> findAll();
}
