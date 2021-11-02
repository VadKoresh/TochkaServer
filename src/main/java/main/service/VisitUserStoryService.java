package main.service;

import main.entity.VisitUserStoryEntity;
import main.modelConvert.VisitUserStoryConvertTo;
import main.repository.VisitUserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VisitUserStoryService {

    @Autowired
    private VisitUserStoryRepository visitUserStoryRepository;

    public String addVisitStory(VisitUserStoryConvertTo visitUserStoryConvertTo){
        try {
            visitUserStoryRepository.save(VisitUserStoryEntity.fromJsonToEntity(visitUserStoryConvertTo));
            return "Запись прошла успешно!";
        }catch (Exception e){
            return "Что-то пошло не так! Ошибка №12";
        }
    }

    public ArrayList<VisitUserStoryConvertTo> getVisitStoryToday(LocalDateTime today){
        List<VisitUserStoryEntity> byCreationDate = visitUserStoryRepository.findByCreationDate(today);
        ArrayList<VisitUserStoryConvertTo> convertTos = new ArrayList<>();
        for (VisitUserStoryEntity visitUserStoryEntity : byCreationDate){
            convertTos.add(VisitUserStoryConvertTo.convertTo(visitUserStoryEntity));
        }
        return convertTos;
    }

    public VisitUserStoryConvertTo getOneVisit(long id){
        return VisitUserStoryConvertTo.convertTo(visitUserStoryRepository.findById(id).get());
    }
}
