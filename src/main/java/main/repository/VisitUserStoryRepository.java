package main.repository;

import main.entity.VisitUserStoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitUserStoryRepository extends CrudRepository<VisitUserStoryEntity, Long> {

    default List<VisitUserStoryEntity> findByCreationDate(LocalDateTime localDateTime) {
        if (localDateTime.getHour() < 3){
            return findAllByTimeInBetween(localDateTime.toLocalDate().minusDays(1).atStartOfDay().plusHours(10), localDateTime);
        }
        return findAllByTimeInBetween(localDateTime.toLocalDate().atStartOfDay(), localDateTime.toLocalDate().plusDays(1).atStartOfDay());
    }

    List<VisitUserStoryEntity> findAllByTimeInBetween(LocalDateTime from, LocalDateTime to);
}
