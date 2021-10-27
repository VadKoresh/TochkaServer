package main.controller;

import main.modelConvert.VisitUserStoryConvertTo;
import main.service.VisitUserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visit")
public class VisitUserStoryController {

    @Autowired
    private VisitUserStoryService visitUserStoryService;

    @PostMapping("/")
    public ResponseEntity addVisit(@RequestBody VisitUserStoryConvertTo visitUserStoryConvertTo) {
        try {
            return ResponseEntity.ok(visitUserStoryService.addVisitStory(visitUserStoryConvertTo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Сервер: " + e.getMessage());
        }
    }
}
