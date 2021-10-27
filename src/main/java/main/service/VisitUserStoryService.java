package main.service;

import main.entity.VisitUserStoryEntity;
import main.modelConvert.VisitUserStoryConvertTo;
import main.repository.VisitUserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
