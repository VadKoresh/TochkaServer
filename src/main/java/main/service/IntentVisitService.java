package main.service;

import main.entity.IntentVisitEntity;
import main.repository.IntentVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntentVisitService {

    @Autowired
    private IntentVisitRepository intentVisitRepository;

    public List<IntentVisitEntity> getAll(){
        return intentVisitRepository.findAll();
    }
}
